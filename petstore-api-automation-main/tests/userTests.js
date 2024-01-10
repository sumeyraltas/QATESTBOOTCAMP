const chakram = require('chakram'),
   expect = chakram.expect;

describe("User Module", function () {


   it("GET - GetUserInfo User not found", function () {
      const resBody = {
         "code": 1,
         "type": "error",
         "message": "User not found"
      };

      const response = chakram.get("https://petstore.swagger.io/v2/user/sumeyra");
      expect(response).to.have.status(404);
      expect(response).to.comprise.of.json(resBody);
      expect(response).to.have.header('content-type', 'application/json');
      return chakram.wait();
   });


   it("POST - CreateUser", function () {
      const resBody = { "code": 200, "type": "unknown", "message": "123" };

      const body = {
         "id": 123,
         "username": "sumeyra123",
         "firstName": "sumeyra",
         "lastName": "altas",
         "email": "sumeyraltas123@gmail.com",
         "password": "string",
         "phone": "string",
         "userStatus": 0
      };
      const response = chakram.post("https://petstore.swagger.io/v2/user", body);
      expect(response).to.have.status(200);
      expect(response).to.comprise.of.json(resBody);
      expect(response).to.have.header('content-type', 'application/json');
      return chakram.wait();
   });


   it("GET - GetUserInfo", function () {
      const resBody = {
         "id": 123,
         "username": "sumeyra123",
         "firstName": "sumeyra",
         "lastName": "altas",
         "email": "sumeyraltas123@gmail.com",
         "password": "string",
         "phone": "string",
         "userStatus": 0
      };

      const response = chakram.get("https://petstore.swagger.io/v2/user/sumeyra123");
      expect(response).to.have.status(200);
      expect(response).to.comprise.of.json(resBody);
      expect(response).to.have.header('content-type', 'application/json');
      return chakram.wait();
   });


   it("DELETE - DeleteUser", function () {
      const resBody = {
         "code": 200,
         "type": "unknown",
         "message": "sumeyra123"
      };
      const response = chakram.delete("https://petstore.swagger.io/v2/user/sumeyra123");
      expect(response).to.have.status(200);
      expect(response).to.comprise.of.json(resBody);
      expect(response).to.have.header('content-type', 'application/json');
      return chakram.wait();
   });


   it("PUT - UpdateUser", function () {
      const resBody = {
         "code": 200,
         "type": "unknown",
         "message": "9223372036854775807"
     };

      const body = {
         "id": 0,
         "username": "string",
         "firstName": "string",
         "lastName": "string",
         "email": "string",
         "password": "string",
         "phone": "string",
         "userStatus": 0
       };
      const response = chakram.put("https://petstore.swagger.io/v2/user/sumeyra123", body);
      expect(response).to.have.status(200);
      expect(response).to.comprise.of.json(resBody);
      expect(response).to.have.header('content-type', 'application/json');
      return chakram.wait();
   });


});
