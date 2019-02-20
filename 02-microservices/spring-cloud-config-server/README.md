# Creating limits-service

Project generated with [Spring Initializr](https://start.spring.io/)

As this project was developed with Spring Boot `2.0.0.M3` for this course and nowadays this version is missing from the options of the
website, I used this HTTP call to generate the project with the settings I need:

```
$ curl -s https://start.spring.io/starter.tgz                \
    -d groupId=com.ins28minutes.microservices                \
    -d artifactId=spring-cloud-config-server                 \
    -d packageName=com.ins28minutes.microservices            \
    -d name=SpringCloudConfigServer                          \
    -d 'description=Spring Cloud Config Server microservice' \
    -d type=maven-project                                    \
    -d language=java                                         \
    -d bootVersion=2.0.0.RELEASE                             \
    -d dependencies=devtools,cloud-config-server             \
    -d baseDir=spring-cloud-config-server                    \
    | tar -zxvf -
```

As a Git repository was needed for this course, I created the public repo [spring-microservices-config](https://gitlab.com/josebamartos-training/spring-microservices-config)
to be used as backend with the [limits-service.properties](https://gitlab.com/josebamartos-training/spring-microservices-config/blob/master/limits-service.properties)
file inside it. This file will be read by this service and exposed as configuration in an endpoint.

Created [application.properties](../limits-service/src/main/resources/application.properties) file to set configuration
using `spring.application.name` to set the name, `server.port` to modify the port and `spring.cloud.config.server.git.uri`
to define the remote git repository. 

Modified main class [SpringCloudConfigServerApplication](src/main/java/com/ins28minutes/microservices/SpringCloudConfigServerApplication.java)
to enable Spring Boot Configuration server using annotation `@EnableConfigServer`.

To run this project place into to this directory and run:

```
$ mvn clean spring-boot:run
```

This service exposes different properties files in their own endpoint.

| Endpoint                                                                |  Properties file                                                                                                                            |
|-------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------|
| [/limits-service/default](http://localhost:8888/limits-service/default) | [limits-service.properties](https://gitlab.com/josebamartos-training/spring-microservices-config/blob/master/limits-service.properties)     |
| [/limits-service/dev](http://localhost:8888/limits-service/dev)         | [limits-service-dev.properties](https://gitlab.com/josebamartos-training/spring-microservices-config/blob/master/limits-service.properties) |
| [/limits-service/qa](http://localhost:8888/limits-service/default)      | [limits-service-qa.properties](https://gitlab.com/josebamartos-training/spring-microservices-config/blob/master/limits-service.properties)  |