# Spring Boot - New project

Project generated with [Spring Initializr](https://start.spring.io/)

As this course was developed with Spring Boot 2.0.0 and nowadays this version is missing from the options of the
website, I used this HTTP call to generate the project with the settings I need:

```
$ curl https://start.spring.io/starter.tgz        \
      -d type=maven-project                       \
      -d language=java                            \
      -d bootVersion=2.0.0.RELEASE                \
      -d dependencies=web,devtools,jpa,h2         \
      -d groupId=com.in28minutes.rest.webservices \
      -d artifactId=restful-web-services          \
      -d baseDir=restful-web-services             \
      -o restful-web-services.tar.gz
```

To run this project place into to this directory and run:

```
$ mvn clean spring-boot:run
```