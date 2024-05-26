# Step-by-step-process-to-build-springboot-application-and-push-to-dockerhub

### Step 1: Pull the Latest MySQL Docker Image

`docker pull mysql:8.0.34`

This command pulls the latest MySQL Docker image from Docker Hub. If you want to use a specific version, you can specify it (e.g., `mysql:8.0`).

### Step 2: Run the MySQL Docker Container

```sh
docker run --name mysql \
     -e MYSQL_ROOT_PASSWORD=<your_password> \
     -e MYSQL_DATABASE=<your_db_name> \
     -p 3306:3306 \
     -v /path/on/host:/var/lib/mysql \
     -d mysql:8.0.34
```

This command runs a new MySQL container with the following specifications:

- `--name mysql`: Names the container "mysql".
- `-e MYSQL_ROOT_PASSWORD=<your_password>`: Sets the root password for MySQL.
- `-e MYSQL_DATABASE=<your_db_name>`: Creates a new database named `employee_db`.
- `-p 3306:3306`: Maps port 3306 of the container to port 3306 on the host machine.
- `-v /path/on/host:/var/lib/mysql`: Mounts the host directory (`/path/on/host`) to the container’s data directory (`/var/lib/mysql`) to persist data.
- `-d mysql:8.0.34`: Runs the container in detached mode using MySQL version 8.0.34.

### Step 3: Apply the configurations in your application.properties file
```properties
# Your database name which you provided above
  spring.datasource.url=jdbc:mysql://172.17.0.2:3306/<your_db_name>
  spring.datasource.username=root
  spring.datasource.password=root
  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

### Step 4: Package the Maven Project Without Running Tests

`mvn package -DskipTests`

This command packages your Maven project into a JAR file without running the tests.

### Step 5: Build the Docker Image for the Spring Boot Application

`docker build -t <your_image_name>:<tag_or_version_name> .`

This command builds a Docker image for your Spring Boot application using the Dockerfile in the current directory (`.`), and tags the image as `employee-management:1.0`.

### Step 6: Tag the Docker Image for Pushing to Docker Hub

`docker tag <your_image_name>:<tag_or_version_name>  <your_dockerhub_username>/<your_image_name>:<tag_or_version_name>`

**Exmaple:**

`docker tag employee-management:v1 manasranjanmohanta/employee-management:v1`

This command tags the local image `employee-management:v1` with a new name (`manasranjanmohanta/employee-management:v1`) for pushing to Docker Hub.

### Step 7: Log In to Docker Hub

`docker login`

This command prompts you to log in to your Docker Hub account. Provide your Docker Hub username and password.

### Step 8: Push the Docker Image to Docker Hub

`docker push <your_new_docker_image_which_is_tagged_with_your_dockerhub_username>`

**Example:**

`docker push manasranjanmohanta/employee-management:v1`

This command pushes your Docker image (`manasranjanmohanta/employee-management:v1`) to Docker Hub, making it available for others to pull and use.


# Summary

```sh
# Step 1: Pull the latest MySQL Docker image
docker pull mysql:latest

# Step 2: Run the MySQL Docker container
docker run --name mysql \
    -e MYSQL_ROOT_PASSWORD=root \
    -e MYSQL_DATABASE=employee_db \
    -p 3306:3306 \
    -v /path/on/host:/var/lib/mysql \
    -d mysql:8.0.34

# Step 3: Package the Maven project without running tests
mvn package -DskipTests

# Step 4: Build the Docker image for the Spring Boot application
docker build -t employee-management:v1 .

# Step 5: Tag the Docker image for pushing to Docker Hub
docker tag employee-management:v1 manasranjanmohanta/employee-management:v1

# Step 6: Log in to Docker Hub
docker login

# Step 7: Push the Docker image to Docker Hub
docker push manasranjanmohanta/employee-management:v1

```
