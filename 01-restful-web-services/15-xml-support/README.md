# XML support

Added dependency `com.fasterxml.jackson.dataformat.jackson-dataformat-xml` to automatically handle XML based
representation of resources. Use HTTP header `Accept` to set format to `application/json` or `application/xml` in REST
client.

To run this project place into to this directory and run:

```
$ mvn clean spring-boot:run
```