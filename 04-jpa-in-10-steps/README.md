# Introduction to Spring Boot in 10 Steps

Project generated with [Spring Initializr](https://start.spring.io/)

As this project was developed with Spring Boot `2.0.0.M3` for this course
and nowadays this version is missing from the options of the website, I used
this HTTP call to generate the project with the settings I need:

```
$ curl -s https://start.spring.io/starter.tgz       \
    -d groupId=com.in28minutes.jpa                  \
    -d artifactId=jpa-in-10-steps                   \
    -d packageName=com.in28minutes.jpa.jpain10steps \
    -d name=JpaIn10Steps                            \
    -d 'description=JPA in 10 Steps course'         \
    -d type=maven-project                           \
    -d language=java                                \
    -d bootVersion=2.0.0.RELEASE                    \
    -d dependencies=web,devtools,jpa,h2             \
    -d baseDir=jpa-in-10-steps                      \
    | tar -zxvf -
```

## User entity

Created entity class [User][src/main/java/com/in28minutes/jpa/jpain10steps/entity/User.java] to manage `User` entities.


## Managing data through DAO

There are two ways for managing data.

### Service UserDAOService

Created service [UserDAOService](src/main/java/com/in28minutes/jpa/jpain10steps/service/UserDAOService.java) to manage `User` entities in the database.


### Runner UserDaoServiceCommandLineRunner

Automatically creating users when application starts is implemented in class [UserDaoServiceCommanLineRunner](src/main/java/com/in28minutes/jpa/jpain10steps/UserDaoServiceCommanLineRunner.java).


## Managing data through Repository (Preferred)

### Repository UserRepository

Created class [UserRepository](src/main/java/com/in28minutes/jpa/jpain10steps/service/UserRepository.java)
to manage entities through a repository.

### Runner UserRepositoryCommandLineRunner

Automatically creating users and querying them when application starts is implemented in class [UserRepositoryCommanLineRunner](src/main/java/com/in28minutes/jpa/jpain10steps/UserRepositoryCommanLineRunner.java).

# Enable console and show SQL

Added properties file [application.properties](src/main/resources/application.properties)
to enable detailed logging and access to web console on H2 database.

## Start application

Application is ready to be started:

```
$ mvn clean spring-boot:run
```

## Check results

Check what happens in:
  - Application console logs
  - H2 Console: http://localhost:8080/h2-console
    - Driver class: org.h2.Driver
    - JDBC URL: jdbc:h2:mem:testdb
    - User name: sa
    - Password: 
  
  