const chakram = require('chakram'),
   expect = chakram.expect;

describe("Store Module", function () {


    it("GET - GetStoreInfo /Store not found", function () {
       const resBody = {
          "code": 1,
          "type": "error",
          "message": "Order not found"
       };
 
       const response = chakram.get("https://petstore.swagger.io/v2/store/order/4");
       expect(response).to.have.status(404);
       expect(response).to.comprise.of.json(resBody);
       expect(response).to.have.header('content-type', 'application/json');
       return chakram.wait();
    });
 
 
    it("POST - CreateStore", function () {
       const resBody = {
          "id": 2,
          "petId": 2,
          "quantity": 2,
          "shipDate": "2023-12-24T11:43:04.735+0000",
          "status": "placed",
          "complete": true
      };
 
       const body = {
          "id": 2,
          "petId": 2,
          "quantity": 2,
          "shipDate": "2023-12-24T11:43:04.735+0000",
          "status": "placed",
          "complete": true
       };
 
       const response = chakram.post("https://petstore.swagger.io/v2/store/order", body);
       expect(response).to.have.status(200);
       expect(response).to.comprise.of.json(resBody);
       expect(response).to.have.header('content-type', 'application/json');
       return chakram.wait();
    });
 
 
    it("GET - GetStoreInfo", function () {
       const resBody = {
          "id": 2,
          "petId": 2,
          "quantity": 2,
          "shipDate": "2023-12-24T11:43:04.735+0000",
          "status": "placed",
          "complete": true
       };
 
       const response = chakram.get("https://petstore.swagger.io/v2/store/order/2");
       expect(response).to.have.status(200);
       expect(response).to.comprise.of.json(resBody);
       expect(response).to.have.header('content-type', 'application/json');
       return chakram.wait();
    });
 
 
    it("DELETE - DeleteStore", function () {
       const resBody = {
          "code": 200,
          "type": "unknown",
          "message": "2"
       };
       const response = chakram.delete("https://petstore.swagger.io/v2/store/order/2");
       expect(response).to.have.status(200);
       expect(response).to.comprise.of.json(resBody);
       expect(response).to.have.header('content-type', 'application/json');
       return chakram.wait();
    });
 
 });