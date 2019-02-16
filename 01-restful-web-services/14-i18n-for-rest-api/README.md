# I18n for REST API

Created internationalized endpoint in controler [HelloWorldController](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/helloworld/HelloWorldController.java).

Created `@Bean localeResolver()` method in [DemoApplication](src/main/java/com/in28minutes/rest/webservices/restfulwebservices/DemoApplication.java)
to return a `LocaleResolver` object with the default localte set.

Created [messages.properties](src/main/resources/messages.properties) and [messages_eu.properties](src/main/resources/messages.properties)
language file into [resources](src/main/resources) resources directory.

Use HTTP header `Accept-Language` to set the desired language in REST client.

To run this project place into to this directory and run:

```
$ mvn clean spring-boot:run
```