## Spring Boot Swagger 3 Maven dependency
- For **Spring Boot 3:** <br>
To use Swagger 3 in your Maven project, you need to add the [springdoc-openapi-starter-webmvc-ui](https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-ui) dependency to your project’s pom.xml file:

```xml
<dependency>
  <groupId>org.springdoc</groupId>
  <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
  <version>2.0.3</version>
</dependency>
```
- For **Spring Boot 2:** <br>
With earlier version of Spring Boot, you can use [springdoc-openapi-ui](https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-ui) dependency:

```xml
<dependency>
  <groupId>org.springdoc</groupId>
  <artifactId>springdoc-openapi-ui</artifactId>
  <version>1.6.15</version>
</dependency>
```

## Run and Check
Run Spring Boot project. Open browser with following url you can see your swagger documentation : <br>
`http://localhost:8080/swagger-ui/index.html`
<p align="center">
  <img src="https://github.com/manasranjanmohanta/md-related-docs/blob/main/swagger-ui-example.png" />
</p>

Open `http://localhost:8080/v3/api-docs`, you will see document in Json format : 
<p align="center">
  <img src="https://github.com/manasranjanmohanta/md-related-docs/blob/main/swagger-api-docs-example.png" />
</p>


## Spring Boot and Swagger API description
Before you start documenting the API, you may first define API description with its basic information, which includes the base URL (development and production environment), title, version, author contact, description, license…

Now define SwaggerConfiguration class with OpenAPI bean like following code:

**configs/SwaggerConfiguration.java**

```java
package com.example.employee.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfiguration {
    @Value("${employee.openapi.dev-url}")
    private String devUrl;

    @Value("${employee.openapi.prod-url}")
    private String prodUrl;

    private static final String CONTACT_EMAIL = "manasranjanmohanta679@gmail.com";
    private static final String CONTACT_NAME = "Manas Ranjan Mohanta";
    private static final String CONTACT_URL = "<my-website>";
    private static final String API_TITLE = "Employee Management Application";
    private static final String API_VERSION = "1.0";
    private static final String API_DESCRIPTION = "This API exposes endpoints to manage Employee Management Application.";
    private static final String LICENSE_NAME = "Apache License Version 2.0";
    private static final String LICENSE_URL = "https://www.apache.org/licenses/LICENSE-2.0";

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

        Server prodServer = new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription("Server URL in Production environment");

        Contact contact = new Contact();
        contact.setEmail(CONTACT_EMAIL);
        contact.setName(CONTACT_NAME);
        contact.setUrl(CONTACT_URL);

        License mitLicense = new License().name(LICENSE_NAME).url(LICENSE_URL);

        Info info = new Info()
                .title(API_TITLE)
                .version(API_VERSION)
                .contact(contact)
                .description(API_DESCRIPTION)
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
    }
}
```

**In application.properties file:**
```properties
employee.openapi.dev-url=http://localhost:8080
employee.openapi.prod-url=http://employee-management.com
```


Run the project and you can see the OpenAPI 3 configuration will be loaded:
![](https://github.com/manasranjanmohanta/md-related-docs/blob/main/Screenshot%202024-05-03%20at%2011.19.48%20PM.png)

And http://localhost:8080/v3/api-docs:
![](https://github.com/manasranjanmohanta/md-related-docs/blob/main/Screenshot%202024-05-03%20at%2011.29.09%20PM.png)

For making API description for Rest Controller or each HTTP request, we continue with Swagger annotations.

```java
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Employee Management", description = "Employee management APIs")
@RestController
public class EmployeeController {

}
```


We’re gonna use Swagger 3 annotations to customize description with more details.

```java
@Tag(name = "Employee Management", description = "Employee management APIs")
@RestController
public class EmployeeController {
  // ...

   @Operation(
            summary = "Retrieve a Employee by Id",
            description = "Get a Employee object by specifying its id. The response is Employee object with id, name, age, salary and employee address.",
            tags = ("Get Employee"))
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = EmployeeEntity.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

  // ...
}
```

## Swagger Configuration in Spring Boot
We can configure our API documentation by specifying properties in the spring configuration file. These properties can be classified into OpenAPI and Swagger UI properties.

- OpenAPI properties specify how the project should be scanned to identify API endpoints and create documentation based on them.
- Swagger UI properties helps us to customize the user interface of our API documentation.

`application.properties`

```properties
#springdoc.api-docs.enabled=false
#springdoc.swagger-ui.enabled=false

springdoc.swagger-ui.path=/employee-swagger
springdoc.api-docs.path=/api-docs

springdoc.packages-to-scan=com.example.employee.controller
springdoc.swagger-ui.tryItOutEnabled=true
springdoc.swagger-ui.operationsSorter=method
springdoc.swagger-ui.tagsSorter=alpha
springdoc.swagger-ui.filter=true
```

– Use `api-docs.enabled=false` if you want to disable springdoc-openapi endpoints.
– Use `swagger-ui.enabled=false` to disable the swagger-ui endpoint.

– `api-docs.path` is for custom path of the OpenAPI documentation in Json format. Now it is http://localhost:8080/api-docs.

– `swagger-ui.path` is for custom path of the Swagger documentation. If you visit `http://localhost:8080/employee-swagger`, the browser will redirect you to http://localhost:8080/swagger-ui/index.html

## Reference 
- For more informations click [here](https://www.bezkoder.com/swagger-3-annotations/).
