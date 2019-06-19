# Netflix Zuul API GW Server

Project generated with [Spring Initializr](https://start.spring.io/)

As this project was developed with Spring Boot `2.0.0.M3` for this course and nowadays this version is missing from the options of the
website, I used this HTTP call to generate the project with the settings I need:

```
curl -s https://start.spring.io/starter.tgz                                   \
    -d groupId=com.in28minutes.microservices.netflixzuulapigatewayserver      \
    -d artifactId=netflix-zuul-api-gateway-server                             \
    -d packageName=com.in28minutes.microservices.netflixeurekanamingserver    \
    -d name=NetflixZuulApiGatewayServer                                       \
    -d 'description=Netflix Zuul API Gateway Server'                          \
    -d type=maven-project                                                     \
    -d language=java                                                          \
    -d bootVersion=2.0.0.RELEASE                                              \
    -d dependencies=actuator,cloud-eureka,devtools,cloud-zuul                 \
    -d baseDir=netflix-zuul-api-gateway-server                                \
    | tar -zxvf -
```

Added annotations `@EnableZuulProxy` and `@EnableDiscoveryClient` to class [NetflixZuulApiGatewayServerApplication](src/main/java/com/in28minutes/microservices/netflixeurekanamingserver/NetflixZuulApiGatewayServerApplication.java).

Added configuration properties to file [application.properties](src/main/resources/application.properties).

Created filter in class [ZuulLoggingFilter](src/main/java/com/in28minutes/microservices/netflixeurekanamingserver/ZuulLoggingFilter.java)

To run this project place into to this directory and run:

```
$ mvn clean spring-boot:run
```

We use the application name to make calls through Zuul using the following
format: `http://localhost:8765/<application-name>/<path>`. Application names
can be checked in Netflix Eureka Naming Server (https://localhost:8761) or in
the `application.properties` file of each application.

For example, to call URL
`http://localhost:8000/currency-exchange/from/EUR/to/INR`
through Zuul, we should call
`http://localhost:8765/currency-exchange-service/currency-exchange/from/EUR/to/INR`.

Service `currency-conversion-service` is now prepared to connect
to `currency-exchange-service` instances passing through Zuul.

All requests and URIs will be logged in the console each time `currency-exchange-service` endpoint is used.

[Insomnia](https://insomnia.rest/) API test plan is defined in
test file [insomia-test-plan.json](insomia-test-plan.json).

Note that a different `currency-exchange-service`
microservice (different port) responds to each request.