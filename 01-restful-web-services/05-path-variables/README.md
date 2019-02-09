# Path variables

Created three REST endpoints:
* /hello-world
* /hello-world-bean
* /hello-world/path-variable/{name}
 
All the endpoints (Path, verb and mapped method) are defined in 
[HelloWorldController](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/HelloWorldController.java) class.
This class uses [HelloWorldBean](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/HelloWorldBean.java)
bean to process the input information and generate an output.

The endpoint `/hello-world/path-variable/{name}` captures the `{name}` part as path parameter and prints it into a Hello
World message.

To run this project place into to this directory and run:

```
$ mvn clean spring-boot:run
```