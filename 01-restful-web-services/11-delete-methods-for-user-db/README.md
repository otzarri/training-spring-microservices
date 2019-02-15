# Delete methods for user database

Previously package `user` was created to store all the code related to the [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)
based in-memory database containing the classes below:

| Class                                                                                                        | Description                                   |
|--------------------------------------------------------------------------------------------------------------|-----------------------------------------------|
| [User](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/user/User.java)                     | Java bean representing an user                |
| [UserDaoService](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/user/UserDaoService.java) | DAO object to work with the data backend      |
| [UserResource](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/user/UserResource.java)     | REST controller who invokes `UserDatoService` |

This project has implemented User deletion adding method `deleteById()` to [UserDaoService](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/user/UserDaoService.java)
to delete the user from in-memory database, this method is exposed in the REST API through the new method `deleteUser()`
added to class [UserResource](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/user/UserResource.java).

To run this project place into to this directory and run:

```
$ mvn clean spring-boot:run
```