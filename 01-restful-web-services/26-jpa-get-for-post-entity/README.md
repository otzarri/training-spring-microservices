# Post entity and relationships in JPA

Added new endpoint method `retrieveUserPosts()` to controller class [UserJpaResource](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/user/UserJpaResource.java)
to create a new REST endpoint for instances of entity class [Post](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/user/Post.java).

Added annotation `@JsonIgnore` to field `user` in class [Post](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/user/Post.java)
to avoid an infinite loop while searching posts of a user and searching later for users of a post.

A test for each endpoint is defined in the [Insomnia](https://insomnia.rest/) test file [insomnia-api-tests.json](insomnia-api-tests.json).

To run this project place into to this directory and run:

```
$ mvn clean spring-boot:run
```

To query the database easily visit http://localhost:8080/h2-console and connect to database `jdbc:h2:mem:testdb` with
username `sa` and no password.