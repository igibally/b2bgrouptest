

You should be able to start the example application by executing com.b2bgroup.B2BGroupServerApplicantTestApplication, which starts a webserver on port 8080 (http://localhost:8080) and serves SwaggerUI where can inspect and try existing endpoints.

The project is based on a small web service which uses the following technologies:

* Java 1.8
* Spring Boot
* Maven
---------------------------------------------------------------------------------------------------------------------------------------

-----------------------------------------------------------------------------------------------------------
Authentication login:


Role:ADMIN
userername: admin/ passowrd: admin123
Can access
/v1/products/*


Autentication Type:
Basic Auth 
 String "username:password" base64 encoded.
---------------------------------------------------------------------------------------------


cloud url.
http://ec2-34-215-69-62.us-west-2.compute.amazonaws.com:8080/swagger-ui.html

/-----------------------------------------------------------------------------------------/
sample request for creat new product 

{
  "description": "my third product description",
  "dietaryFlags": "vegan, lactose-free",
  "image_url": "https://s3-us-west-2.amazonaws.com/b2b-group-task/3.jpg",
  "title": "my third product",
  "vendor_ID": 11,
   "price": 800.5
}
---------------------------------------------------------------------------------------
b2bgroup.postman_collection.json file can  be imported into postman for requst samples


thank you. 




