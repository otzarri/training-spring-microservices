# Dynamic filtering for REST API

Added two new endpoint methods (`retrieveDynamicFilterBean` and `retrieveListOfDynamicFilterBean`) to REST controller class [FilteringController](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/filtering/FilteringController.java).
In these methods a FilterProvider is configured to apply filters to the instances of class [DynamicFilterBean](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/filtering/DynamicFilterBean.java), where annotation
`@JsonFilter` is used to call the FileProvider created before.
 
To run this project place into to this directory and run:

```
$ mvn clean spring-boot:run
```
