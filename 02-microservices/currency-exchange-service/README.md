# Currency Exchange Service

Project generated with [Spring Initializr](https://start.spring.io/)

As this project was developed with Spring Boot `2.0.0.M3` for this course and nowadays this version is missing from the options of the
website, I used this HTTP call to generate the project with the settings I need:

```
$ curl -s https://start.spring.io/starter.tgz                            \
    -d groupId=com.in28minutes.microservices                             \
    -d artifactId=currency-exchange-service                              \
    -d packageName=com.in28minutes.microservices.currencyexchangeservice \
    -d name=CurrencyExchangeService                                      \
    -d 'description=Currency Exchange microservice'                      \
    -d type=maven-project                                                \
    -d language=java                                                     \
    -d bootVersion=2.0.0.RELEASE                                         \
    -d dependencies=web,devtools,cloud-config-client,actuator            \
    -d baseDir=currency-exchange-service                                 \
    | tar -zxvf -
```

Set application name and port in file [application.properties](src/main/resources/application.properties).

Created class [CurrencyExchangeController](src/main/java/com/in28minutes/microservices/CurrencyExchangeController.java)
to set endpoint methods and added new endpoint method `retrieveExchangeValue()` to create a new REST endpoint for `GET`
method to return instances of entity class [ExchangeValue](src/main/java/com/in28minutes/microservices/ExchangeValue.java),
also creates an instance of class [Environment](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/env/Environment.html)
to retrieve the port where the service is running and attach it to the response.

Created repository class [ExchangeValueRepository.java](src/main/java/com/in28minutes/microservices/ExchangeValueRepository.java)
with method `findByFromAndTo` to get exchange value from the database and modified the controller class to return the object
given by this last method.

Added dependencies for JPA using H2 database:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
</dependency>
```

Configured class [ExchangeValue](src/main/java/com/in28minutes/microservices/ExchangeValue.java)
to integrate with JPA using tags `@Entity`, `@Id`, and `@Column`.

Created file [data.sql](src/main/resources/data.sql) with sample data for H2 database.

Added some database-related settings to [application.properties](src/main/resources/application.properties):

```ini
...
spring.jpa.show-sql=true
spring.h2.console.enabled=true
```

Added dependency `spring-cloud-starter-netflix-eureka-client` in `pom.xml`:

```
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
		</dependency>
```

Added annotation `@EnableDiscoveryClient` to class [CurrencyExchangeServiceApplication.java](src/main/java/com/in28minutes/microservices/currencyexchangeservice/CurrencyExchangeServiceApplication.java) 

Added configuration property `eureka.client.service-url.default-zone=localhost:8761/eureka` to file [application.properties](src/main/resources/application.properties).

To run this project place into to this directory and run:

```
$ mvn clean spring-boot:run
```

To query the database easily visit http://localhost:8080/h2-console and connect to database `jdbc:h2:mem:testdb` with
username `sa` and no password.

[Insomnia](https://insomnia.rest/) API test plan is defined in
test file [insomia-test-plan.json](insomia-test-plan.json).