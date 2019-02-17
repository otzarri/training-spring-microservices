# Versioning REST API

Created a new package called `versioning` to store all the code related to API versioning. Inside it I created the classes below:

| Class                                                                                                                                      | Description                                                         |
|--------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------|
| [PersonV1](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/versioning/PersonV1.java)                                     | Bean representation of return body in v1                            |
| [PersonV2](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/versioning/PersonV2.java)                                     | Bean representation of return body in v1                            |
| [Name](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/versioning/Name.java)                                             | Class used as attribute of class `personV2`                         |
| [PersonVersioningController](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/versioning/PersonVersioningController.java) | REST controller where methods, endpoints and versioning are defined |

Rest Controller implemented two methods (with rest endpoind path assigned) for each vesioning method.

| Method                       | Endpoint                 | Versioning type |
|------------------------------|--------------------------|-----------------|
| urlVersioningPersonV1()      | /v1/person-url           | URL path        |
| urlVersioningPersonV2()      | /v2/person-url           | URL path        |
| paramVersioningPersonV1()    | /person-param?version=1  | URL parameter   |
| paramVersioningPersonV2()    | /person-param?version=2  | URL parameter   |
| headerVersioningPersonV1()   | /person-header           | HTTP header     |
| headerVersioningPersonV2()   | /person-header           | HTTP header     |
| producesVersioningPersonV1() | /person-produces         | Produces        |
| producesVersioningPersonV2() | /person-produces         | Produces        |

A test for each endpoint is defined in the [Insomnia](https://insomnia.rest/) test file [insomnia-api-tests.json](insomnia-api-tests.json).

To run this project place into to this directory and run:

```
$ mvn clean spring-boot:run
```