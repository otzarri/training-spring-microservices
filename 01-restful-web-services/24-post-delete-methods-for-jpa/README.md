# POST and DELETE methods for JPA

Modified class [UserJpaResource](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/user/UserJpaResource.java)
to make methods `createUser()` and `deleteUser()` make use of the instance of class `UserRepository`.

A test for each endpoint is defined in the [Insomnia](https://insomnia.rest/) test file [insomnia-api-tests.json](insomnia-api-tests.json).

To run this project place into to this directory and run:

```
$ mvn clean spring-boot:run
```

To query the database easily visit http://localhost:8080/h2-console and connect to database `jdbc:h2:mem:testdb` with
username `sa` and no password.