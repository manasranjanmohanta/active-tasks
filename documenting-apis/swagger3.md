# Documenting  APIs
### What is Swagger and Open API Specification

- **OpenAPI Specification (formerly Swagger Specification)** is an API description format for REST APIs. An OpenAPI file allows you to describe your entire API.  

<p align="center">
  <img src="https://github.com/manasranjanmohanta/md-related-docs/blob/main/openapi-swagger.jpg" />
</p>

- **Swagger** is a set of open-source tools built around the OpenAPI Specification that can help you design, build, document and consume REST APIs. It is the most popular tool for Web developers to document REST APIs.
- In Simple words Swagger makes documenting your RESTful services easy and Spring Boot makes RESTFUL implementations easy.  
- Swagger provides a user interface OR API Documentation in UI format to access our RESTful web services via the web browser

- Swagger is an open-source project used to describe and document RESTful APIs. It dynamically generate documentation from a Swagger-compliant API. Swagger UI allows API developers or consumers to interact with the API’s resources without having any of the implementation logic in place.

## How to integrate Swagger Open API 3 in your SpringBoot 3 projects?

**Maven** **Setup**

- To enable the Swagger3 in Spring Boot application, you need to add the following dependencies in our build configurations file that is maven POM.xml. It will automatically document all your APIs for you.

```xml
<dependency>  
    <groupId>org.springdoc</groupId>  
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>  
    <version>2.5.0</version>  
</dependency>
```
- If you have Spring-Security integrated in your project then make the `/swagger-ui/**` and `/v3/api-doc/**` to public URL to access.
- Add the property: `springdoc.enable-spring-security:false` in `application.properties` so that `SpringDocSecurityConfiguration` bean wont be created and search for spring security related classes.
- For the swagger ui the endpoint is accessible at: `http://localhost:8080/swagger-ui/index.html`.
  You can see the swagger-ui as follows:
<p align="center">
  <img src="https://github.com/manasranjanmohanta/md-related-docs/blob/main/swagger-ui-example.png" />
</p>
  
- For the docs the endpoint is accessible at `http://localhost:8080/v3/api-docs`.
    You can see the api-docs as follows:
<p align="center">
  <img src="https://github.com/manasranjanmohanta/md-related-docs/blob/main/swagger-api-docs-example.png" />
</p>

- You can also customise the above url by mentioning in the `application.properties` or `.yaml` file :

```properties
springdoc.swagger-ui.path=/my-swagger-ui  
springdoc.api-docs.path=/api-docs
```
