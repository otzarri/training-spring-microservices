# Setting up JPA

Added the required dependency to [pom.xml](pom.xml).

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

Disabled `spring-boot-starter-security` at [pom.xml](pom.xml) for ease of development:

```xml
<!--
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
-->
```

Added annotation `@entity` at class level and annotations `@Id` and `@GeneratedValue` for `Id` attribute in class
[User](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/user/User.java). 

Enabled logging features `spring.jpa.show-sql` and `spring.h2.console.enabled` in file [application.properties](src/main/resources/application.properties).

Created sample data to populate in-memory H2 datase in SQL format inside file [data.sql](src/main/resources/data.sql).
This data is loaded into the database when application boots.

To run this project place into to this directory and run:

```
$ mvn clean spring-boot:run
```

To query the database easily visit http://localhost:8080/h2-console and connect to database `jdbc:h2:mem:testdb` with
username `sa` and no password.