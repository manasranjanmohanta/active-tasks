# Spring Boot and Microservices Course Outline
## 1. Introduction To Spring & Spring Boot  
(IOC, Beans, Dependency Injection, Maven, Annotations, AutoConfigurations, Spring Initializer)
- Spring Framework Core Features like Spring IOC Container, Java-based
configuration, Annotation-based configuration, Dependency Injection, and
more.
- Spring Boot Fundamentals and Features - Dive into Spring Boot Internals,
Auto Configuration, Spring Initializr, and Starter Projects.
- Internal Flow of a Spring Boot Application.
- Maven Build Tools and Lifecycle goals

## 2. Spring Boot MVC and RESTful APIs
(Spring MVC, Spring Web, REST APIs, Lombok, Model Mappers, CRUD operations, Bean Validation, Exception Handling)
- Spring MVC Concepts - Learn how to create APIs using MVC. Turning your API
dreams into reality, one controller at a time!
- Lombok - Simplify your Java code with Lombok
- Setting up an In-Memory Database with H2 DB
- Spring Bean Validation - Ensure your data is always squeaky clean before it
even reaches the Service layer
- Exception Handling in Spring Boot Application

## 3. Spring Boot Data JPA and Database Integration
(MySQL, DBeaver, JPA, Hibernate, JPQL, 1:1, 1:N, N:1 , M:N, Indexes, Database constraints)
- Install MySQL database server and DBeaver analytics tool
- Spring Data JPA Fundamentals like database, drivers, JDBC, ORM, Spring
Data JPA Repositories, etc.
- Configuring Hibernate ORM with MySQL Database
- Build custom queries effortlessly with Spring Data JPA Query Methods
- JPQL and Named Query - Master JPQL and Named Queries.
- One to One, One to Many, Many to One and Many to Many Mappings with
real-world examples.

## 4. Production ready Spring Boot Features
(Metrics, Health Checks, Swagger Documentation, Open API, Spring Dev Tools, Logging, REST Template, Third-party APIs)
- Spring Boot Actuator - Monitor your application's health with Spring Boot
Actuator.
- Spring Documentation with Swagger and Open API
- Spring Dev Tools - Supercharge your development with Spring Dev Tools.
- Logging - Keep track of everything with logging.
- REST Template and Third-Party APIs - Integrate third-party APIs with ease.

## 5. Authentication & Authorisation with Spring Security
(Authentication, Authorisation, Google OAuth, Request Filters, JWT, Password Encoding, Session Management)
- Create a secure Login and user registration system
- Add request filters to secure your REST endpoints
- Security against CSRF Cross-Site Request Forgery) and XSS Cross-Site
Scripting) attacks
- Third-party registration system with Google OAuth and JWT authentication
- Implement role-based access control with Spring Boot Authorization and SQL
Database.
- Password Security with Encoding - Secure passwords with encoding. Keep
those passwords safe from prying eyes!
- Session Management - Manage user sessions effectively. Keep your users

## 6. Spring Boot Junit Testings
(JUnit, Assert Methods, Unit Testing, Mockito)
- Get started with testing and JUnit. Test early test often and conquer bugs!
- Dive deep into JUnit annotations and assert methods.
- Master Mockito for unit testing.

## 7. Spring Boot Deployment with CI/CD
- Use Spring Profiles to manage different environments like development,
staging and production
- Learn to creat buildspec to define the build flow
- Create Pipelines for CI/CD using AWS Codepipeline
- Deploying with CodePipeline and CodeDeploy on Elastic Beanstalk

## 8. Aspect-Oriented Programming
(Cross cuttign concerns, AOP Basics, Advice types, Handling Exceptions, JoinPoints Weaving
- Learn the fundamentals of Aspect-Oriented Programming (AOP) and how it
improves software modularity.
- Explore different advice types (before, after, around) to manage the behavior
of your application at specified join points.
- Discover the weaving process and how aspects are integrated with the main
code during compile time, load time, or runtime.

## 9. Caching and Redis Cache in Spring Boot
(Redis, Spring Cache, Distributed Caching, Cache Configuration)
- Spring Cache: Understand the Spring Cache abstraction and how to
- implement caching with ease using Spring Boot.
- Distributed Caching: Explore the concepts and implementation of distributed
caching to enhance scalability and performance.

## 10. Apache Kafka in Spring Boot
(Kafka, Spring Boot Messaging Publisher Consumer Broker, RabbitMQ)
- Discover how to leverage Apache Kafka for building robust and scalable
messaging systems in Spring Boot.
- Learn about the messaging capabilities in Spring Boot and how to integrate
them seamlessly with Kafka
- Explore the differences and similarities between Kafka and RabbitMQ, and
learn how to choose the right messaging solution for your Spring Boot
application

## 11. Microservices Architecture
(Eureka Registry, API Gateway, Microservice Security, Microservice REST APIs, Circuit Breaker, Resilient4J. Distributed Logs, Centralised Logs, ELK Stack, Zipkin, Sleuth
- Learn how to use Eureka Registry for service discovery in a microservices
architecture with Spring Boot.
- Explore strategies and best practices for securing your microservices in a
Spring Boot environment.
- Learn how to use Resilient4J to build resilient microservices with fault
tolerance and recovery mechanisms.
- Explore centralized logging solutions to aggregate and manage logs from all
your microservices.
- Master the ELK Stack Elasticsearch, Logstash, Kibana) for powerful log
analysis and visualization in a microservices environment.
- Discover how Spring Cloud Sleuth adds tracing capabilities to your
microservices integrating seamlessly with Zipkin

## 12. Docker
(Docker Setup, Docker Compose, Dockerfile, Containerization, Docker Images, Docker Volumes)
- Learn how to set up Docker on your development environment for efficient
containerization.
- Understand the usage of Docker Compose to manage multi-container
applications with ease.
- Gain insights into building, managing, and deploying Docker images for
consistent application environments.


## 13. Kubernetes Deployment for Spring Boot Applications
(Cluster Management, Kubernetes, Kubernetes Dashboard, Monitoring, Cluster Deployment)
- Learn the essentials of managing Kubernetes clusters, including setting up,
scaling, and maintaining cluster resources effectively.
- Dive into the core concepts and functionalities of Kubernetes, such as Pods, Deployments, Services, and more, to orchestrate and manage containerized
applications at scale.
- Explore the Kubernetes Dashboard, a web-based user interface for managing
and monitoring Kubernetes clusters, to visualize and interact with cluster
resources efficiently.


# Summary
1. Dependency Injection
2. Learn Spring MVC Concepts
3. Spring Boot Internals, Spring Initializr, and Starter Projects
4. Lombok - Simplify your Java code with Lombok.
5. Setting up an In-Memory Database with H2 DB
6. Spring Bean Data Validation
7. Exception Handling in Spring Boot Application
8. Reformatting the Response Object - Polish those responses until they shine!
9. Building Spring Boot REST APIs - Create REST APIs with ease
10. Mini Project: Restful Web Services - Put your skills to the test with a mini project
11. Master Spring Data JPA from Basics to Custom Queries with MySQL and PostgreSQL
12. Configuring Hibernate ORM with JDBC
13. Spring Data JPA Query Methods
14. Using DTO Pattern and Mapping Libraries
15. Monitor your applications with Spring Boot Actuator
16. Spring Documentation with Swagger and Open API
17. Supercharge your development with Spring Dev Tools
18. Logging - Keep track of everything with logging
19. Auditing - Keep track of App's History
20. REST Template and Third-Party APIs - Integrate third-party APIs with ease
21. Secure your REST APIs with Spring Security 6 and SQL Database
22. Create a registration and login system with Spring MVC, Spring Boot, Spring Data JPA, and MySQL
23. Third-Party Registration System with Google OAuth and JWT Authentication
24. Implement role-based access control with Spring Boot Authorization and SQL Database
25. Fine-tune roles and permissions, secure methods, and customize error pages
26. Secure passwords with encoding. Keep those passwords safe from prying eyes!
27. Master the User Session Management
28. Testing with JUnit and Assert Methods
29. Integration Tests for Reactive CRUD REST APIs
30. Master Mockito for unit testing
31. Use Spring Profiles to manage different environments like dev, stage and prod
32. Learn to creat buildspec to define the build flow
33. Create Pipelines for CI/CD using AWS Codepipeline
34. Deploying with CodePipeline and CodeDeploy on Elastic Beanstalk
35. Aspect-Oriented Programming
36. Various Advice Types: Before, After, After Throwing Advice
37. Redis Spring Cache to make your cache smarter and faster!
38. Implement publish/subscribe messaging with Redis
39. Using Apache Kafka in Spring Boot
40. Understanding Kafka's architecture
41. Kafka Publisher and Kafka Consumer
42. Spring Boot Messaging with RabbitMQ
43. Spring Cloud Stream using Kafka Binder
44. Introduction to Microservices
45. Monolithic vs. Microservice Architecture
46. Key Microservice Principles and Advantages
47. Creating REST APIs in Microservice Architecture
48. Microservices Communication using RestTemplate, WebClient, and Cloud OpenFeign
49. Service Registry and Discovery using Spring Cloud Netflix Eureka
50. API Gateway using Spring Cloud Gateway
51. Auto Refresh Config Changes using Spring Cloud Bus
52. Secure your microservices with JWT
53. Distributed Tracing with Spring Cloud Sleuth and Zipkin
54. Resilience4J: Circuit Breaker, Retry, and RateLimiter Patterns
55. Centralized Configuration using Spring Cloud Config Server
56. Centralized Logging using Elasticsearch, Logstash and Kibana Stack
57. Docker Setup and Commands
58. Dockering Spring Boot Application Step-by-Step
59. Learn Docker's role in microservices. Understand how Docker revolutionizes microservice deployment!
60. Use Docker Compose. Orchestrate multi-container Docker applications with ease!
61. Understand Kubernetes in Microservices. Master container orchestration with Kubernetes!
62. Orchestration using Kubernetes
63. Use the Kubernetes Dashboard. Visualize and manage your Kubernetes clusters with an intuitive UI!
64. Configure Kubernetes. Set up your Kubernetes clusters for optimal performance!
65. Deploying Microservices to Kubernetes Cluster
66. Utilizing Kubernetes services for load balancing and scaling
