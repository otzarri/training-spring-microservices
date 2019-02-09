# Logging

Logging is configured in [application.properties](src/main/resources/application.properties)
file and the valid log levels are:

| Level   | Description                                                                                           |
|---------|-------------------------------------------------------------------------------------------------------|
| FATAL   | Severe errors that cause premature termination. Expected to be seen on a status console.              |
| ERROR   | Other runtime errors or unexpected conditions. Expected to be seen on a status console.               |
| WARNING | Other runtime situations that are unexpected, but not wrong. Expected to be seen on a status console. |
| INFO    | Interesting runtime events (startup/shutdown). Expected to be seen immediately on a console.          |
| DEBUG   | Detailed information on the flow through the system. Expect these to be written to logs only          |
| TRACE   | More detailed information. Expect these to be written to logs only                                    |
| ALL     | Turn on all logging.                                                                                  |

To run this project place into to this directory and run:

```
$ mvn clean spring-boot:run
```