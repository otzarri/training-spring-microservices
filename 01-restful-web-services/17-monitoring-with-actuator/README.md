# REST API monitoring with Swagger

Added required dependencies to [pom.xml](pom.xml):

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.data</groupId>
    <artifactId>spring-data-rest-hal-browser</artifactId>
</dependency>
```

Configured Actuator to show all the monitoring data in [application.properties](application.properties).

To run this project place into to this directory and run:

```
$ mvn clean spring-boot:run
```

To see Actuator data visit: http://localhost:8080/actuator

In newer versions actuator was moved to: http://localhost:8080/application

To use HAL Browser visit: http://localhost:8080/browser/index.html#/ and call `/actuator` to parse monitoring data.
