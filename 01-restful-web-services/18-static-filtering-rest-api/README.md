# Static filtering for REST API

Created a new package called `filtering` to store all the code related to filtering. Inside it I created the classes below:

| Class                                                                                                                       | Description                                                 |
|-----------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------|
| [FilteringController](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/filtering/FilteringController.java) | REST controller to expose one endpoint for each class below |
| [StaticFilterBeanOne](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/filtering/StaticFilterBeanOne.java) | Bean defining static filtering at attribute level           |
| [StaticFilterBeanTwo](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/filtering/StaticFilterBeanTwo.java) | Bean defining static filtering at class level               |

To run this project place into to this directory and run:

```
$ mvn clean spring-boot:run
```
