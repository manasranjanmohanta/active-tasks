# What is Logging in Java?
Logging is an essential aspect of application development that allows developers to monitor and troubleshoot their application.
Spring Boot supports various logging framework such as `Logback`, `Log4j2`, `Java Util Loggin(JUL)`.

#### 1. Logback: 
A popular logging framework that serves as the default in many Spring Boot applications. It offers a flexible configuration and good performance.

#### 2. Log4j2:
Another widely used logging framework with features such as asynchronous logging and support for various output formats.

#### 3. Java Util Logging(JUL):
The default logging framework included in the Java Standard Edition. White it's less feature rich than some third party frameworks. It is straightforward and is part of the java platform.



 - Spring Boot comes with a default logging configuration that uses **Logback** as the default logging implementation. It provides a good balance between simplicity and flexibility.
 - The default configuration is embedded within the Spring Boot libraries, and it may not be visible in your project's source code.
 - If you want to customise the logging configuration,  you can create your own **logback-spring.xml** or **logback.xml** file in the src/main/resources directory.
 - When Spring Boot detects this file in your project, it will use it instead of default configuration.


| Date | Time | Log severity | Process Id | Application name | Thread name | Package name | Log msg |
| --- | --- | --- | ---| ---| --- | --- | --- |
| 2024-04-24 | T22:00:47.364+05:30 | INFO  | 4854 | [Weighbridge_Admin] | [main]| com.weighbridge.WeighbridgeApplication  | Starting WeighbridgeApplication using Java 17.0.10 with PID 4854 (/Users/manas/Documents/Projects/LDTech/Weighbridge/Weighbridge_Project/Weighbridge_Admin/target/classes started by manas in /Users/manas/Documents/Projects/LDTech/Weighbridge/Weighbridge_Project/Weighbridge_Admin) |


## Logging Levels (How much severe the Log is ?):
- Logging levels help in categorising log statements based on their severity. The common logging levels are - (low to high)
```
TRACE > DEBUG > INFO > WARN > ERROR
```

- We can set the desired logging level for specific packages or classes allowing them to control the amount of information logged at runtime.
- By default logging is enabled for `INFO, WARN, ERROR`
- Spring Boot provides annotations like `@Slf4j` & `Log4j2`, that you can use to automatically inject logger instances into your classes.

## How to use in your project?
**Step - 1:** Create instance where you  want to use log.
```java
private final Logger logger = LogerFactory.getLogger(CurrentClassName.class)
```
- Here "CurrentClassName" is the class name where you want to use Logger.

**Step - 2:** User logger instance to call methods like trace, debug, info, warn, error.

```java
try {
    int res = 10 / 0;
} catch (Exception e) {
    logger.info("Hello");
    logger.error("Error occurred", e);
    
    // We can also use a placeholder - {}
    logger.error("Error occurred for {}: {}", res, e);
}
```

**@Slf4j** - Logging Abstraction Framework.("Simple Logging Facade for Java"- is an abstraction layer for Java logging framework that allows you to plug in different logging frameworks at deployment time without changing your code). 

**Facade** - A way of behaving or a false appearance. (A superficial appearance or illusion of something.)
- To remove writing logger instance we use @Slf4j annotation. It creates instance with name "log" . (Through Slf4j we will use Logback)
- Spring Boot allows us to configure logging using properties or yaml files.

1. **Using application.propteries file :**
```properties
# Set the root logging level
logging.level.root=INFO

# Configure console logging
logging.level.org.springframework=INFO
logging.level.com.example=DEBUG
logging.pattern.console=%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n

# Configure file logging
logging.file.name=application.log
logging.file.path=/path/to/logs
logging.pattern.file=%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n

```

- `logging.level.root`: Sets the root logging level. In this example, it's set to `INFO`, which means only logs with a level of `INFO` and higher (e.g., `WARN`, `ERROR`) will be logged.
- `logging.level.org.springframework` and `logging.level.com.example`: Sets the logging levels for specific packages or classes. Here, `org.springframework` is set to `INFO` and `com.example` is set to `DEBUG`.
- `logging.pattern.console`: Specifies the log message format for console output. The placeholders `%d`, `%thread`, `%level`, `%logger`, and `%msg` have the same meanings as in the Logback configuration example.
- `logging.file.name` and `logging.file.path`: Configures file logging by specifying the log file name and path where log files will be stored.
- `logging.pattern.file`: Specifies the log message format for file output.

```properties
# To enable TRACE or DEBUG(Similarly we can do this in yaml files.)
logging.level.com.helloworld=TRACE 

# To stop all error log 
# we can also use specific class (in that case replace root with pacakegename.class)
logging.level.root=OFF

# To show only specific severity log
logging.level.root=ERROR
```

2. **Using logback.xml :**
The `logback.xml` file is a configuration file used with the Logback logging framework in Java applications. It allows you to customize various aspects of logging such as log levels, log formatting, and log output destinations.
```xml
<!-- Main tag -->
<configuration>
	<!-- means where we want to print the logs i.e, in files or console -->
	<!-- Appender and Logger information go here -->
</configuration>
```

```xml
<configuration>

    <!-- Define the appenders -->
    <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>

    <appender name="FILE" class="ch.qos.logback.core.FileAppender">
        <file>application.log</file>
        <encoder>
            <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>

    <!-- Set the root logger level and its appenders -->
    <root level="INFO">
        <appender-ref ref="CONSOLE" />
        <appender-ref ref="FILE" />
    </root>

</configuration>

```

1. `<configuration>`: This is the root element of the Logback configuration file.
2. `<appender>`: Defines the appenders, which are responsible for outputting log messages. In this example, there are two appenders: `CONSOLE` for console output and `FILE` for logging to a file.
3. `<encoder>`: Specifies the format of log messages using a pattern. The `%d`, `%thread`, `%level`, `%logger`, and `%msg` are placeholders for date/time, thread name, log level, logger name, and log message, respectively.
4. `<root>`: Sets the root logger level (`INFO` in this case) and associates it with the defined appenders (`CONSOLE` and `FILE`).
