# Spring Boot Logging with @Slf4j

In Spring Boot, the `@Slf4j` annotation is used to enable logging in your classes using the **Simple Logging Facade for Java (SLF4J)** API. It eliminates the need to manually declare a logger instance. Here's a step-by-step guide on how to use it:

---

### 1. **Add Dependencies**

Ensure your project includes the SLF4J API and a logging implementation. Spring Boot typically uses **Logback** by default, so you may not need to add any additional dependencies if you're using Spring Boot's default setup.

If needed, add the SLF4J annotation processor to your `pom.xml`:

```xml
<dependency>     
	<groupId>org.projectlombok</groupId>     
	<artifactId>lombok</artifactId>     
	<version>1.18.28</version> 
</dependency>
```

### 2. **Enable Lombok in IDE**

Ensure Lombok is installed and configured in your IDE (like IntelliJ IDEA or Eclipse). Most modern IDEs provide Lombok plugins to recognize annotations like `@Slf4j`.

### 3. **Use @Slf4j in Your Class**

Annotate your class with `@Slf4j` to automatically create a `log` instance.

```java
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoggingController {

	@GetMapping("/log-example")
	public String logExample() {
		log.info("This is an INFO log message.");
		log.warn("This is a WARN log message.");
		log.error("This is an ERROR log message.");
		return "Check your logs for messages!";
	}
}
```

---
	
### 4. **Log Levels**

SLF4J supports various logging levels:

- `log.debug("Debugging message");`
- `log.info("Informational message");`
- `log.warn("Warning message");`
- `log.error("Error message");`
- `log.trace("Trace message");`

---

### 5. **Customize Logging Configuration**

Modify the logging levels and settings in the `application.properties` or `application.yml` file:

#### For `application.properties`:

```properties
logging.level.root=WARN logging.level.com.example=DEBUG
```

#### For `application.yml`:

```yaml
logging:   
	level:     
		root: WARN     
		com.example: DEBUG
```

---

### 6. **Verify Logs**

Run your application and trigger the API. Logs will be printed to the console or to a file (if configured).

### 7. **Optional: Use Custom Loggers**

If you need to use a custom logger name, you can declare a `Logger` manually:

```java
private static final Logger logger = LoggerFactory.getLogger(CustomClass.class);
```

But with `@Slf4j`, this step is automated.

---

### Key Benefits of `@Slf4j`

1. Reduces boilerplate code.
2. Works seamlessly with Spring Boot's logging infrastructure.
3. Compatible with various logging backends (e.g., Logback, Log4j).
