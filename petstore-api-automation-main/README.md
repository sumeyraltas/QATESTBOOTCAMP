
In order to perform API testing, I created two different classes: userTests.js and storeTests.js.
I have 4 different scenarios in the userTests class.

 1-  GET - GetUserInfo User not found --> This class gets user with using username, I test user that is not in the api. Our status should be 404, so I settes as. And controls operation. 

  2-  POST - CreateUser --> This class posts user. And controls operation.
 
  3-  DELETE - DeleteUser --> This class deletes with using username the user we created in CreateUser step. And controls operation.  
  
  4-  PUT - UpdateUser --> This class updates/changes the user informations with PUT. And controls operation.

 I have 4 different scenarios in the storeTests.js class.
  
  1-  GET - GetStoreInfo /Store not found  --> This class gets store informations with using id, I test id that is not in the api. And controls operation.
  
  2-  POST - CreateStore --> This class posts store informations. And controls operation.
 
  3-  GET - GetStoreInfo --> This class gets store informations with using id, I test id that is in the api. And controls operation.
  
  4-  DELETE - DeleteStore  --> This class deletes with using id. And controls operation.
 
  //I setted resBody part with respect to Postman's outputs.
  
To running program first write "npm test" in the terminal line.

Runing program will prints; 

> petstore-api-testing@1.0.0 test
> mocha tests/ --timeout 90000  --exit


  Store Module
  
tests\storeTests.js:7:5
    
    ✔ GET - GetStoreInfo /Store not found (776ms)
tests\storeTests.js:22:5
   
    ✔ POST - CreateStore (160ms)
tests\storeTests.js:49:5
   
    ✔ GET - GetStoreInfo (168ms)
tests\storeTests.js:67:5
 
    ✔ DELETE - DeleteStore (157ms)

  User Module
  
tests\userTests.js:7:4
   
    ✔ GET - GetUserInfo User not found (158ms)
tests\userTests.js:22:4
   
    ✔ POST - CreateUser (161ms)
tests\userTests.js:43:4
tests\userTests.js:63:4
   
    ✔ DELETE - DeleteUser (158ms)
tests\userTests.js:77:4
    
    ✔ PUT - UpdateUser (159ms)
    
---SCREENSHOT--
    
![image](https://github.com/sumeyraltas/petstore-api-automation/assets/74320640/9f315b63-ddbd-4d76-a3c3-90c40ef75dad)

We can observe the results and elapsed time. As a result, our all tests are working correctly. 
