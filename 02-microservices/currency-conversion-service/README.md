# Currency Conversion Service

Project generated with [Spring Initializr](https://start.spring.io/)

As this project was developed with Spring Boot `2.0.0.M3` for this course and
nowadays this version is missing from the options of the website, I used this
HTTP call to generate the project with the settings I need:

```
$ curl -s https://start.spring.io/starter.tgz                              \
    -d groupId=com.in28minutes.microservices                               \
    -d artifactId=currency-conversion-service                              \
    -d packageName=com.in28minutes.microservices.currencyconversionservice \
    -d name=CurrencyExchangeService                                        \
    -d 'description=Currency Exchange microservice'                        \
    -d type=maven-project                                                  \
    -d language=java                                                       \
    -d bootVersion=2.0.0.RELEASE                                           \
    -d dependencies=web,devtools,cloud-config-client,actuator              \
    -d baseDir=currency-exchange-service                                   \
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

Set application name, port, and the list of servers where ribbon will load
balance to in file [application.properties](src/main/resources/application.properties).

Enabled `Feign` and `Ribbon` in class [CurrencyExchangeServiceApplication.java](src/main/java/com/in28minutes/microservices/currencyconversionservice/CurrencyExchangeServiceApplication.java)
using annotations `@EnableFeignClients` and `@RibbonClient`.

Created class [CurrencyConversionController](src/main/java/com/in28minutes/microservices/CurrencyConversionController.java)
to expose endpoint `/currency-converter/from/{from}/to/{to}/quantity/{quantity}`
mapped to method `convertCurrency` that gets inputs values to return an
instance of class [CurrencyConversionBean](src/main/java/com/in28minutes/microservices/CurrencyConversionBean.java),
who makes a REST request to microservice `currency-conversion-service` to get
the conversion multiple.

Created class [CurrencyExchangeServiceProxy.java](src/main/java/com/in28minutes/microservices/currencyconversionservice/CurrencyExchangeServiceProxy.java)

Added dependency `spring-cloud-starter-netflix-eureka-client` in `pom.xml`:

```
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
		</dependency>
```


Added annotation `@EnableDiscoveryClient` to class [CurrencyConversionServiceApplication.java](src/main/java/com/in28minutes/microservices/currencyconversionservice/CurrencyConversionServiceApplication.java) 

Added configuration property `eureka.client.service-url.default-zone=http://localhost:8761/eureka` to file [application.properties](src/main/resources/application.properties).

Commented property `currency-exchange-service.ribbon.listOfServers=http://localhost:8000,http://localhost:8001` in file [application.properties](src/main/resources/application.properties)
because it's address is now beging managed by Eureka.

Modified class [CurrencyExchangeServiceProxy](src/main/java/com/in28minutes/microservices/currencyconversionservice/CurrencyExchangeServiceProxy.java) to make Feign requests to service `netflix-zuul-api-gateway-server`.


There are different REST call kinds implemented in controller class [CurrencyConversionController](src/main/java/com/in28minutes/microservices/CurrencyConversionController.java)
to connect it to Eureka Name Server.

| URL Mapping                                                       | Method                 | Description          |
|-------------------------------------------------------------------|------------------------|----------------------|
| /currency-converter/from/{from}/to/{to}/quantity/{quantity}       | convertCurrency()      | RestTemplate based   |
| /currency-converter-feign/from/{from}/to/{to}/quantity/{quantity} | convertCurrencyFeign() | Feign + Ribbon based |

To run this project place into it's root directory and run:

```
$ mvn clean spring-boot:run
```

To test multiple instances working together, you can overwrite the port by launching
jarfiles, por example, to launch an instance on port 8000 and another on port 8001:

```
$ mvn clean package
$ java -jar -Dserver.port=8000 target/currency-exchange-service-0.0.1-SNAPSHOT.jar
$ java -jar -Dserver.port=8001 target/currency-exchange-service-0.0.1-SNAPSHOT.jar
```

Or

```
$ java -jar target/currency-exchange-service-0.0.1-SNAPSHOT.jar --server.port=8000
$ java -jar target/currency-exchange-service-0.0.1-SNAPSHOT.jar --server.port=8001
```

Service `currency-conversion-service` is now prepared to connect
to `currency-exchange-service` instances passing through Zuul.

All requests to `currency-exchange-service` endpoint will be logged in the console of `netflix-zuul-api-gateway-server`.

[Insomnia](https://insomnia.rest/) API test plan is defined in
test file [insomia-test-plan.json](insomia-test-plan.json).

Note that a different `currency-exchange-service`
microservice (different port) responds to each request.