# Exception handling for 404 - Not found

Created a new package called `user` to store all the code related to the [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)
based in-memory database. Inside it I created the classes below:

| Class                                                                                                                      | Description                                    |
|----------------------------------------------------------------------------------------------------------------------------|------------------------------------------------|
| [User](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/user/User.java)                                   | Java bean representing an user                 |
| [UserDaoService](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/user/UserDaoService.java)               | DAO object to work with the data backend       |
| [UserResource](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/user/UserResource.java)                   | REST controller who invokes `UserDatoService`  |
| [UserNotFoundException](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/user/UserNotFoundException.java) | Returns detailed REST output for the exception |

The new POST method was defined in the class [UserResource](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/user/UserResource.java).

When class [UserResource](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/user/UserResource.java)
finds for a certain user in
[UserDaoService](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/user/UserDaoService.java)
and gets a `null` object throws an
[UserNotFoundException](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/user/UserNotFoundException.java)
who modifies the output of the REST service giving more detailed information about the problem.


To run this project place into to this directory and run:

```
$ mvn clean spring-boot:run
```
