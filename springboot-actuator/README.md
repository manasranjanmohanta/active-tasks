# Spring Boot Actuator
- Spring Boot Actuator is a production ready feature which helps to monitor/manage spring boot application using HTTP endpoints or with JMX.
- Key points we can check:
	- Audit
	- Health
	- Metrices
	- Beans
	- Caches etc.


## Spring-boot Actuator Implementation
1. First, add the actuator dependency in `pom.xml`:
```xml
	<dependency>
	    <groupId>org.springframework.boot</groupId>
	    <artifactId>spring-boot-starter-actuator</artifactId>
	</dependency>
```

2. Configure endpoints in `application.properties`:
```properties
 # Enable all endpoints
management.endpoints.web.exposure.include=*

# Or enable specific endpoints
management.endpoints.web.exposure.include=health,info,metrics,prometheus

# Server port for actuator (optional - if you want separate port)
management.server.port=8081

# Base path for actuator endpoints (default is /actuator)
management.endpoints.web.base-path=/actuator

# Enable detailed health information
management.endpoint.health.show-details=always
```

3. Add custom info in `application.properties` (optional):
```properties
management.info.env.enabled=true
info.app.name=My Spring Application
info.app.description=My Spring Boot Application
info.app.version=1.0.0
```

4. Key endpoints available:
```
http://localhost:8082/actuator                 # List all endpoints
http://localhost:8082/actuator/health          # Application health info
http://localhost:8082/actuator/info            # Application info
http://localhost:8082/actuator/metrics         # Application metrics
http://localhost:8082/actuator/env             # Environment properties
http://localhost:8082/actuator/loggers         # Logger configurations
http://localhost:8082/actuator/mappings        # Request mappings
```

5. To create custom health indicator (optional):
```java
@Component
public class CustomHealthIndicator implements HealthIndicator {
    
    @Override
    public Health health() {
        try {
            // Add your health check logic here
            return Health.up()
                    .withDetail("service", "running")
                    .withDetail("timestamp", System.currentTimeMillis())
                    .build();
        } catch (Exception e) {
            return Health.down()
                    .withDetail("error", e.getMessage())
                    .build();
        }
    }
}
```


## Custom DB health check

```java
@Component
public class MyDBHealthService implements HealthIndicator {
	private static final String DB_SERVICE = "Database Service";

	public boolean isHealthGood() {
		// custom logic
		return true;
	}

	@Override
	public Health health() {
		if (isHealthGood()) {
			return Health.up().withDetail(DB_SERVICE, "Database service is running.").build();
		}
		return Health.down().withDetail(DB_SERVICE, "Database service is down.").build();
	}
}
```
