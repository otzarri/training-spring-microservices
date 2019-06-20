# Limits Service

Project generated with [Spring Initializr](https://start.spring.io/)

As this project was developed with Spring Boot `2.0.0.M3` for this course and nowadays this version is missing from the options of the
website, I used this HTTP call to generate the project with the settings I need:

```
$ curl -s https://start.spring.io/starter.tgz                  \
    -d groupId=com.in28minutes.microservices                   \
    -d artifactId=limits-service                               \
    -d packageName=com.in28minutes.microservices.limitsservice \
    -d name=LimitsService                                      \
    -d 'description=Limits microservice'                       \
    -d type=maven-project                                      \
    -d language=java                                           \
    -d bootVersion=2.0.0.RELEASE                               \
    -d dependencies=web,devtools,cloud-config-client,actuator  \
    -d baseDir=limits-service                                  \
    | tar -zxvf -
```

Set application name in [application.properties](src/main/resources/application.properties) using `spring.application.name`,
this is an important parameter because the requests to the Spring Boot Configuration Server will be built using this
parameter. Default configurations for this service will be exposed at http://localhost:8888/limits-service/default.

Created class [LimitsConfigurationController](src/main/java/com/in28minutes/microservices/LimitsConfigurationController.java)
to define method `retrieveLimitsFromConfigurations()` that returns an instance of class [LimitConfiguration](src/main/java/com/in28minutes/microservices/bean/LimitConfiguration.java)
using endpoint `/limits`. 

Class [LimitsConfigurationController](src/main/java/com/in28minutes/microservices/LimitsConfigurationController.java)
gathers configuration from [Spring Cloud Configuration Server](../spring-cloud-config-server) at http://localhost:8080,
which is defined in the `spring.cloud.config.uri`.

Added dependency `spring-cloud-starter-netflix-eureka-client` in `pom.xml`:

```
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
```

Added annotation `@EnableDiscoveryClient` to class [CurrencyExchangeServiceApplication.java](src/main/java/com/in28minutes/microservices/currencyexchangeservice/CurrencyExchangeServiceApplication.java) 

Added configuration property `eureka.client.service-url.default-zone=localhost:8761/eureka` to file [application.properties](src/main/resources/application.properties).

Added following dependencies to [pom.xml](pom.xml):

```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-sleuth-zipkin</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-bus-amqp</artifactId>
        </dependency>
```

Added the following lines to [bootstrap.properties](src/main/resources/bootstrap.properties):

```
management.security.enabled=false
management.endpoints.web.exposure.include=*
```

To enable fault tolerance, added Hystrix in [pom.xml](pom.xml):

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-sleuth-hystrix</artifactId>
</dependency>
```

Added annotation `@EnableHystrix` to class [LimitsServiceApplication](src/main/java/com/in28minutes/microservices/limitsservice/LimitsServiceApplication.java).

Implemented fault-tolerancy in class  [LimitsConfigurationController](src/main/java/com/in28minutes/microservices/limitsservice/LimitsConfigurationController.java).

To run this project place into to this directory and run:

```
$ mvn clean spring-boot:run
```