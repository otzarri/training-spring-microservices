# Creating limits-service

Project generated with [Spring Initializr](https://start.spring.io/)

As this project was developed with Spring Boot `2.0.0.M3` for this course and nowadays this version is missing from the options of the
website, I used this HTTP call to generate the project with the settings I need:

```
$ curl -s https://start.spring.io/starter.tgz                 \
    -d groupId=com.in28minutes.microservices                  \
    -d artifactId=currency-exchange-service                   \
    -d packageName=com.in28minutes.microservices              \
    -d name=CurrencyExchangeService                           \
    -d 'description=Currency Exchange microservice'           \
    -d type=maven-project                                     \
    -d language=java                                          \
    -d bootVersion=2.0.0.RELEASE                              \
    -d dependencies=web,devtools,cloud-config-client,actuator \
    -d baseDir=currency-exchange-service                      \
    | tar -zxvf -
```

Set application name and port in file [application.properties](src/main/resources/application.properties).

Created class [CurrencyExchangeController](src/main/java/com/in28minutes/microservices/CurrencyExchangeController.java)
to set endpoint methods and added new endpoint method `retrieveUserPosts()` to create a new REST endpoint for `GET`
method to return instances of entity class [ExchangeValue](src/main/java/com/in28minutes/microservices/ExchangeValue.java).



---
Set application name in [application.properties](src/main/resources/application.properties) using `spring.application.name`,
this is an important parameter because the requests to the Spring Boot Configuration Server will be built using this
parameter. Default configurations for this service will be exposed at http://localhost:8888/limits-service/default.

Created class [LimitsConfigurationController](src/main/java/com/in28minutes/microservices/LimitsConfigurationController.java)
to define method `retrieveLimitsFromConfigurations()` that returns an instance of class [LimitConfiguration](src/main/java/com/in28minutes/microservices/bean/LimitConfiguration.java)
using endpoint `/limits`. 

Class [LimitsConfigurationController](src/main/java/com/in28minutes/microservices/LimitsConfigurationController.java)
gathers configuration from [Spring Cloud Configuration Server](../spring-cloud-config-server) at http://localhost:8080,
which is defined in the `spring.cloud.config.uri`.

To run this project place into to this directory and run:

```
$ mvn clean spring-boot:run
```