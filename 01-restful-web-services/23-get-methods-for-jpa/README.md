# GET methods for JPA

Created interface [UserRepository](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/user/UserRepository.java)
to get methods to query database.

Created class [UserJpaResource](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/user/UserJpaResource.java)
to define the endpoints and the classes to manage the database using an instance of interface `UserRepository`.

A test for each endpoint is defined in the [Insomnia](https://insomnia.rest/) test file [insomnia-api-tests.json](insomnia-api-tests.json).

To run this project place into to this directory and run:

```
$ mvn clean spring-boot:run
```
