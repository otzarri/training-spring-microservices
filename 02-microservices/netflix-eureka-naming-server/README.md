# Netflix Eureka Naming Server

Project generated with [Spring Initializr](https://start.spring.io/)

As this project was developed with Spring Boot `2.0.0.M3` for this course and nowadays this version is missing from the options of the
website, I used this HTTP call to generate the project with the settings I need:

```
curl -s https://start.spring.io/starter.tgz                                   \
    -d groupId=com.in28minutes.microservices                                  \
    -d artifactId=netflix-eureka-naming-server                                \
    -d packageName=com.in28minutes.microservices.netflixeurekanamingserver    \
    -d name=NetflixEurekaNamingServer                                         \
    -d 'description=Netflix Eureka Naming Server'                             \
    -d type=maven-project                                                     \
    -d language=java                                                          \
    -d bootVersion=2.0.0.RELEASE                                              \
    -d dependencies=cloud-eureka-server,devtools,cloud-config-client,actuator \
    -d baseDir=netflix-eureka-naming-server                                   \
    | tar -zxvf -
```

Added annotation `@EnableEurekaServer` to class [NetflixEurekaNamingServerApplication](src/main/java/com/in28minutes/microservices/netflixeurekanamingserver/NetflixEurekaNamingServerApplication.java).

Added configuration properties to file [application.properties](src/main/resources/application.properties).


Added dependencies `Feign` and `Ribbon`:

```
<dependency>
    <groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```

To run this project place into to this directory and run:

```
$ mvn clean spring-boot:run
```

Once service started, go to http://localhost:8761 to use Eureka's web UI 
