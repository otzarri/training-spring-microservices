# HATEOAS for REST API

Added dependency to support `HATEOAS`:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-hateoas</artifactId>
</dependency>
```

Modified method `retrieveUser()` on controller class [UserResource](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/user/UserResource.java)
to return `HATEOAS` based response.

To run this project place into to this directory and run:

```
$ mvn clean spring-boot:run
```