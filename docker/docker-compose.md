# Docker Compose

Docker Compose is a tool that simplifies the management of multi-container Docker applications. It allows us to define and run multi-container Docker applications using a YAML file called `docker-compose.yml`.

1. **Services:**
    
    - A service is a containerized application component defined in the `docker-compose.yml` file.
    - Each service can have its own configuration, including the Docker image, environment variables, ports, volumes, networks, and more.
2. **Containers:**
    
    - Docker Compose uses Docker containers to run services defined in the `docker-compose.yml` file.
    - Each service in the Compose file corresponds to a container when the application is started.
3. **Volumes:**
    
    - Volumes in Docker Compose allow you to persist data between container restarts.
    - We can specify volume mappings in the Compose file to mount host directories or named volumes into containers.
4. **Networks:**
    
    - Docker Compose automatically creates a network for your multi-container application, allowing services to communicate with each other.
    - We can define custom networks in the Compose file to control network configurations and isolation.
5. **Environment Variables:**
    
    - Compose allows you to define environment variables for services, which can be used to configure application settings dynamically.
    - Environment variables can be set in the Compose file or loaded from `.env` files.

### Basic Docker Compose Commands

1. **Start Containers:**

	```sh
	docker-compose up
	```
    
    This command starts the services defined in the `docker-compose.yml` file.
    
2. **Start Containers in Detached Mode:**
    
    ```sh
    docker-compose up -d
    ```
    
    Starts containers in the background (detached mode).
    
3. **Stop Containers:**
    
    ```sh
	docker-compose down
	```
    
    Stops and removes containers, networks, volumes, and other resources created by `docker-compose up`.
    
4. **View Container Logs:**

	```sh
	docker-compose logs
	```
    
    Displays logs from containers managed by Docker Compose.
    
5. **Run a Single Service:**
6. 
	```sh
	docker-compose run <service_name> <command>
	```
    
    Runs a one-time command in a service container.


### Example `docker-compose.yml` File

Here's a simple example of a `docker-compose.yml` file for a web application with a frontend and backend service:

```yml
version: '3.8'

services:
  frontend:
    image: nginx:latest
    ports:
      - "8080:80"

  backend:
    image: node:latest
    environment:
      - NODE_ENV=production
    volumes:
      - ./app:/app
    networks:
      - my_network

networks:
  my_network:
    driver: bridge

```

In this example:

- There are two services defined: `frontend` (Nginx) and `backend` (Node.js).
- The `frontend` service exposes port `8080` on the host, mapped to port `80` inside the container.
- The `backend` service sets the `NODE_ENV` environment variable and mounts a local directory into the container at `/app`.
- Both services are connected to a custom network named `my_network`.
