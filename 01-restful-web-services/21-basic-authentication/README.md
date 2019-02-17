# Basic authentication in REST API

Added the required dependency to [pom.xml](pom.xml).

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

By default, it will create a random password for the user `username` each the the service starts. So I set a static user
and password in [application.properties](src/main/resources/application.properties).

To run this project place into to this directory and run:

```
$ mvn clean spring-boot:run
```
