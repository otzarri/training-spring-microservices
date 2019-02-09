# REST controller with bean

Created three REST endpoints:
* /hello-world
* /hello-world-bean
 
All the endpoints (Path, verb and mapped method) are defined in 
[HelloWorldController](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/HelloWorldController.java) class.
This class uses [HelloWorldBean](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/HelloWorldBean.java)
bean to process the input information and generate an output.

To run this project place into to this directory and run:

```
$ mvn clean spring-boot:run
```