# Generic exception handling for all resources

Created a new package called `exception` to store all the code related to the generic exception handling. It stores the
classes listed below:

| Class                                                                                                                                                                 | Description                                                                                                |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------|
| [ExceptionResponse](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/exception/ExceptionResponse.java)                                               | Bean representation of the REST API response body when a exception happens.                                |
| [CustomizedResponseEntityExceptionHandler](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/exception/CustomizedResponseEntityExceptionHandler.java) | Defines a handler method for `Exception` type exceptions and another one for `UserNotFoundException` ones. |



The new POST method was defined in the class [UserResource](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/user/UserResource.java).

When class [UserResource](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/user/UserResource.java)
finds for a certain user in
[UserDaoService](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/user/UserDaoService.java)
and gets a `null` object throws an
[UserNotFoundException](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/user/UserNotFoundException.java)
who is handled by class [CustomizedResponseEntityExceptionHandler](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/exception/CustomizedResponseEntityExceptionHandler.java)
to modify the output of the REST service returning the response body represented in bean [ExceptionResponse](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/exception/ExceptionResponse.java).


To run this project place into to this directory and run:

```
$ mvn clean spring-boot:run
```
