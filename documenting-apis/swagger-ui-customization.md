# Swagger UI Customization Annotations

## @OpenAPIDefinition in `OpenApiConfig` configuration class
```java
@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Manas",
                        email = "manasranjanmohanta357@gmail.com",
                        url = "my-website.com"
                ),
                description = "These are the APIs to manage employee-management-application.",
                title = "Employee Management Application",
                version = "1.0",
                license = @License(
                        name = "License name",// for example mit license or apache license
                        url = "license-url"
                ),
                termsOfService = "Terms of service"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "Prod ENV",
                        url = "product-url"
                )
        },
        security = {
                @SecurityRequirement(
                        name = "bearerAuth"
                )
        }
)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT Auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {
}
```
## Controller Name

- To change the controller name, use the `@Tag` annotation on the controller class:

```java
@Tag(name = "Employee-Management")  
public class EmployeeController {
    // ...
}
```

## API Documentation

- To specify details about an API, including its purpose, response, etc., use the `@Operation` annotation:

```java
@Operation(  
    description = "POST endpoint to save employee information.",  
    summary = "This is the summary for POST endpoint",  
    responses = {@ApiResponse(  
        description = "Success",  
        responseCode = "200"  
    ),  
    @ApiResponse(  
        description = "Unauthorized / Invalid token",  
        responseCode = "403"  
    )  
    }  
)  
@PostMapping()  
public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {  
    Employee savedEmployee = employeeService.createEmployee(employee);  
    return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
}

```


## Hiding APIs

- To hide an API from exposure, use `@Hidden`:

```java
@Hidden
@DeleteMapping("/{id}")  
public ResponseEntity<Void> deleteEmployee(@PathVariable long id) {  
    boolean deleted = employeeService.deleteEmployee(id);  
    if (deleted) {  
        return ResponseEntity.noContent().build();  
    } else return ResponseEntity.notFound().build();  
}

```

## @Api
- Use `@Api` to provide metadata about the API such as the title, description, and version.
```java
@Api(tags = "Employee Management API", description = "APIs for managing employee data", version = "1.0")
```

## @ApiOperation

- `@ApiOperation` provides additional information about individual API operations.

```java
@ApiOperation(value = "Get employee by ID", notes = "Returns detailed information about an employee by their ID", response = Employee.class)
```

## @ApiParam

- Use `@ApiParam` to describe parameters of an API operation.
```java
@ApiParam(name = "id", value = "Employee ID", required = true, example = "123")
```

## @ApiResponse

- `@ApiResponse` documents possible responses from an API operation.
```java
@ApiResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Employee.class)))
```

## @ApiResponses

- Use `@ApiResponses` to group multiple `@ApiResponse` annotations for a single API operation.
```java
@ApiResponses({
    @ApiResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Employee.class))),
    @ApiResponse(responseCode = "404", description = "Employee not found")
})
```

## @Hidden

- `@Hidden` is used to hide an API operation from Swagger UI documentation.

```java
@Hidden
@DeleteMapping("/{id}")  
public ResponseEntity<Void> deleteEmployee(@PathVariable long id) {  
    boolean deleted = employeeService.deleteEmployee(id);  
    if (deleted) {  
        return ResponseEntity.noContent().build();  
    } else return ResponseEntity.notFound().build();  
}

```

## @Schema
- Use `@Schema` to define the schema of a model class or property.
```java
@Schema(name = "Employee", description = "Employee details")
public class Employee {
    @Schema(description = "Employee ID")
    private Long id;
    // other properties
}
```

## @ApiModel

- Use `@ApiModel` to provide additional information about a model class for Swagger documentation.
- It allows you to specify the model's name, description, and other metadata.
```java
@ApiModel(description = "Employee details")
public class Employee {
    // properties...
}
```

## @ApiIgnore

- Use `@ApiIgnore` to exclude specific methods or classes from being included in Swagger documentation.
- This can be helpful for hiding endpoints or models that are not intended for public use.
```java
@ApiIgnore
@GetMapping("/internal")
public ResponseEntity<String> internalEndpoint() {
    // method implementation
}
```

## @ApiModelProperty

- Use `@ApiModelProperty` to customize properties of a model class in Swagger documentation.
- It allows you to specify property descriptions, default values, and other metadata.
```java
@ApiModel(description = "Employee details")
public class Employee {
    @ApiModelProperty(value = "Employee ID", example = "123")
    private Long id;
    // other properties...
}

```

## References

1. Springdoc Documentation - [https://springdoc.org/](https://springdoc.org/)
2. Swagger Annotations - [https://github.com/swagger-api/swagger-core/wiki/Swagger-2.X---Getting-started](https://github.com/swagger-api/swagger-core/wiki/Swagger-2.X---Getting-started)
