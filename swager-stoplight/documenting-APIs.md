# Documenting  APIs

Swagger is tool which is used to document APIs. It is the most popular tool for Web developers to document REST APIs.

#### Introduction

- In Simple words Swagger makes documenting your RESTful services easy and Spring Boot makes RESTFUL implementations easy.  
- Swagger provides a user interface OR API Documentation in UI format to access our RESTful web services via the web browser

Swagger is an open-source project used to describe and document RESTful APIs. It dynamically generate documentation from a Swagger-compliant API. Swagger UI allows API developers or consumers to interact with the API’s resources without having any of the implementation logic in place.

## How to integrate Swagger Open API 3 in your SpringBoot3 projects?

**Maven** **Setup**

- To enable the Swagger3 in Spring Boot application, you need to add the following dependencies in our build configurations file that is maven POM.xml. It will automatically document all your APIs for you.

```xml
<dependency>  
    <groupId>org.springdoc</groupId>  
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>  
    <version>2.5.0</version>  
</dependency>
```

- Add the property: `springdoc.enable-spring-security:false` in `application.properties` so that `SpringDocSecurityConfiguration` bean wont be created and search for spring security related classes.
- The endpoint is accessible at: `http://localhost:8080/swagger-ui/index.html`
- You can also customise by mentioning path for your url in the `application.properties` file-
```properties
springdoc.swagger-ui.path=/my-swagger-ui  
springdoc.api-docs.path=/api-docs
```
