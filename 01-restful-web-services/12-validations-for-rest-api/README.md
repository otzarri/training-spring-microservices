# Validations for REST API

Enabled validations using annotation `@valid` in REST mapping methods defined in controller class [UserResource](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/user/UserResource.java). Validations for `name` and `brithDate` parameters are defined in the attributes of bean [User](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/user/User.java). 

Parameter `name` is limited to a 2 character lenght. If a shorter string is received, a `MethodArgumentNotValidException`
is thrown and handled my method `handleMethodArgumentNotValid()` overriden in class [CustomizedResponseEntityExceptionHandler](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/exception/CustomizedResponseEntityExceptionHandler.java).
The same happens when field `birthDate` contains a future date.

To run this project place into to this directory and run:

```
$ mvn clean spring-boot:run
```