# Creating limits-service

Project generated with [Spring Initializr](https://start.spring.io/)

As this project was developed with Spring Boot `2.0.0.M3` for this course and nowadays this version is missing from the options of the
website, I used this HTTP call to generate the project with the settings I need:

```
$ curl -s https://start.spring.io/starter.tgz                 \
    -d groupId=com.in28minutes.microservices                  \
    -d artifactId=currency-conversion-service                 \
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

Added dependencies `Feign` and `Ribbon`:

```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-ribbon</artifactId>
</dependency>
```

Set application name, port, and the list of servers where ribbon will load balance to in file [application.properties](src/main/resources/application.properties).
Enabled `Feign` and `Ribbon` in class [CurrencyExchangeServiceApplication.java](src/main/java/com/in28minutes/microservices/currencyconversionservice/CurrencyExchangeServiceApplication.java)
using annotations `@EnableFeignClients` and `@RibbonClient`.

Created class [CurrencyConversionController](src/main/java/com/in28minutes/microservices/CurrencyConversionController.java)
to expose endpoint `/currency-converter/from/{from}/to/{to}/quantity/{quantity}`
mapped to method `convertCurrency` that gets inputs values to return a instance
of class [CurrencyConversionBean](src/main/java/com/in28minutes/microservices/CurrencyConversionBean.java)
, who makes a REST request to microservice `currency-conversion-service` to get
the conversion multiple.

Created class [CurrencyExchangeServiceProxy.java](src/main/java/com/in28minutes/microservices/currencyconversionservice/CurrencyExchangeServiceProxy.java)


There are different REST call kinds implemented in controller class [CurrencyConversionController](src/main/java/com/in28minutes/microservices/CurrencyConversionController.java).

| URL Mapping                                                       | Method                 | Description          |
|-------------------------------------------------------------------|------------------------|----------------------|
| /currency-converter/from/{from}/to/{to}/quantity/{quantity}       | convertCurrency()      | RestTemplate based   |
| /currency-converter-feign/from/{from}/to/{to}/quantity/{quantity} | convertCurrencyFeign() | Feign + Ribbon based |

To run this project place into to this directory and run:

```
$ mvn clean spring-boot:run
```

A test for each endpoint is defined in the [Insomnia](https://insomnia.rest/)
test file [insomnia-api-tests.json](insomnia-api-tests.json).

<aside class="notice">Note that a different `currency-exchange-service`
microservice (different port) responds to each request.
</aside>