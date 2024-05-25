# What is Dockerfile?

A Dockerfile is a text document that contains all the commands and instructions required to build a Docker image. It serves as a blueprint for creating Docker images, specifying the base image, dependencies, environment variables, ports, and commands needed to run an application inside a container.

### Basic Structure of a Dockerfile

1. **Base Image:**
    
    - Specify the base image from which your Docker image will be built. Use an existing image from Docker Hub or a private registry as the starting point.
    
    ```
	FROM base_image:tag
	```
    
2. **Environment Variables:**
    
    - Set environment variables needed for your application, such as configuration settings or runtime parameters.

	```
	ENV ENV_VAR=value
	```
    
3. **Working Directory:**
    
    - Set the working directory inside the container where your application will be located.

	```
	WORKDIR /path/to/working/directory
	```
    
4. **Copy Files:**
    
    - Copy files and directories from the host machine to the Docker image.
    
	```
	COPY /path/on/host /path/in/container
	```
    
5. **Expose Ports:**
    
    - Expose ports on the container that the application will use to communicate with the outside world.
    
    ```
	EXPOSE port_number
	```
    
6. **Install Dependencies:**
    
    - Install necessary dependencies and packages for your application using package managers like `apt-get`, `yum`, or language-specific package managers.
    
    ```
	RUN apt-get update && apt-get install -y package_name
	```
    
7. **Run Commands:**
    
    - Execute commands to set up and configure the environment, build the application, or perform other tasks.
    
    ```
	RUN command_to_execute
	```
    
8. **Start Application:**
    
    - Specify the command to run when the container starts. This is typically the entry point for your application.
    
    ```
	CMD ["command", "arg1", "arg2"]
	```

### Example Dockerfile for a Java Springboot Application

```Dockerfile
FROM openjdk:17-alpine

WORKDIR /app

COPY target/MyApp-0.0.1-SNAPSHOT.jar  /app/MyApp-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "MyApp-0.0.1-SNAPSHOT.jar"]
```

Here's a breakdown of each line:

1. `FROM openjdk:17-alpine`
    
    - Specifies the base image to use. In this case, `openjdk:17-alpine` is a lightweight Alpine Linux image with OpenJDK 17 installed.
2. `WORKDIR /app`
    
    - Sets the working directory inside the container to `/app`, which is where your application will be copied and executed.
3. `COPY target/MyApp-0.0.1-SNAPSHOT.jar /app/MyApp-0.0.1-SNAPSHOT.jar`
    
    - Copies the JAR file of your Spring Boot application from the `target` directory on the host machine to the `/app` directory inside the container.
4. `EXPOSE 8080`
    
    - Exposes port `8080` of the container, indicating that the Spring Boot application will listen for incoming connections on this port.
5. `CMD ["java", "-jar", "MyApp-0.0.1-SNAPSHOT.jar"]`
    
    - Specifies the command to run when the container starts. It executes the JAR file of your Spring Boot application using the `java -jar` command.

To use this Dockerfile:

1. Save the Dockerfile in the root directory of your Spring Boot project.
2. Build the Docker image using the following command:
    
	```
	docker build -t my-spring-boot-app .
	```
    
    Replace `my-spring-boot-app` with your desired image name.
3. Once the image is built, you can run the Docker container:
    
	```
	docker run -p 8080:8080 my-spring-boot-app
	```
    
    This command maps port `8080` of the host machine to port `8080` of the Docker container, allowing you to access your Spring Boot application at `http://localhost:8080`.
