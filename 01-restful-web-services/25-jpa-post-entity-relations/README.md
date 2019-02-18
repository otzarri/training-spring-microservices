# Post entity and relationships in JPA

Created entity class [Post](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/user/Post.java) and
defined the relationship with entity [User](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/user/User.java) that was previously created.
This last entity was also modified to define the same relationship.

Added two posts into file [data.sql](src/main/resources/data.sql) to be loaded at application startup.

To run this project place into to this directory and run:

```
$ mvn clean spring-boot:run
```

To query the database easily visit http://localhost:8080/h2-console and connect to database `jdbc:h2:mem:testdb` with
username `sa` and no password.