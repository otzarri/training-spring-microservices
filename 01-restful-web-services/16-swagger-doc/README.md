# Swagger documentation

Added required dependencies to [pom.xml](pom.xml):

```xml
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.4.0</version>
</dependency>
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.4.0</version>
</dependency>
```

Created a `Docket` object to set the configuration in class [SwaggerConfig](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/SwaggerConfig.java).
Modified model class [User](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/user/User.java)
to add documentation through Swagger annotations `@ApiModel` and `@ApiModelProperty`.


To run this project place into to this directory and run:

```
$ mvn clean spring-boot:run
```

To see Swagger visit: http://localhost:8080/v2/api-docs

To see Swagger UI visit: http://localhost:8080/swagger-ui.html
