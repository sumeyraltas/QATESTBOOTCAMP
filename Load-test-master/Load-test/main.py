from locust import HttpUser, between, task


# Starting web interface at http: // localhost: 8089(accepting connection from all network interfaces)
# Starting Locust 2.14.2
class WebsiteUser(HttpUser):
    wait_time = between(5, 15)

    def createUser(self, id, username, firstName, lastName, email, password, phone):
        payload = {
            "id": id,
            "username": username,
            "firstName": firstName,
            "lastName": lastName,
            "email": email,
            "password": password,
            "phone": phone,
            "userStatus": 1}
        self.client.post("/v2/user", json=payload)

    @task
    def getUserInfo(self):
        self.createUser(12, "sumeyra12","s","a","s@gmail.com","123","123" )
        self.client.get("/v2/user/sumeyra12")


    @task
    def logout(self):
        self.client.get("/v2/user/logout")

    @task
    def login(self):
        self.client.get("/v2/user/login?username=admin&password=admin")

    @task
    def deleteUser(self):
        self.createUser(2, "sumeyra1234", "s", "a", "s@gmail.com", "123", "123")
        self.client.delete("/v2/user/sumeyra1234")

    @task
    def updateUser(self):
        
        body = {
            "id": 123,
            "username": "sumeyraltas123",
            "firstName": "sumeyra",
            "lastName": "altas",
            "email": "sumeyraltas@gmail.com",
            "password": "123",
            "phone": "123",
            "userStatus": 0
        }
        self.createUser(1234, "sumeyraltas1234","s","a","sumeyraltas123@gmail.com","123","123" )
        self.client.put("/v2/user/sumeyra123", json=body)


    @task
    def createWithArray(self):
        payload = [
            {
                "id": 3,
                "username": "sumeyraltas3",
                "firstName": "sumeyra",
                "lastName": "altas",
                "email": "sumeyraltas3@gmail.com",
                "password": "123",
                "phone": "123",
                "userStatus": 0
            },
            {
                "id": 4,
                "username": "sumeyraltas4",
                "firstName": "sumeyra",
                "lastName": "altas",
                "email": "sumeyraltas4@gmail.com",
                "password": "123",
                "phone": "123",
                "userStatus": 0
            }

        ]
        self.client.post("/v2/user/createWithArray", json=payload)
