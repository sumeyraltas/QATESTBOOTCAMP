from locust import HttpUser, between, task


# Starting web interface at http: // localhost: 8089(accepting connection from all network interfaces)
# Starting Locust 2.14.2
class WebsiteUser(HttpUser):
    wait_time = between(5, 15)

    def createStore(self, id, petid, quantity):
        payload = {
            "id": id,
            "petId": petid,
            "quantity": quantity,
            "shipDate": "2023-12-24T11:43:04.735+0000",
            "status": "placed",
            "complete": True
            }
        self.client.post("/v2/store/order", json=payload)

    @task
    def getStoreInfo(self):
        self.createStore(1,1,1)
        self.client.get("/v2/store/order/1")

    @task
    def deleteStore(self): 
        self.createStore(2,2,2)
        self.client.delete("/v2/store/order/2")

