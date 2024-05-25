# Container Port V/S Host Port

**Container Port**

- **Definition:** The container port is the port that an application inside the Docker container listens on. This is specified by the application running inside the container.
- **Usage:** When running an application inside a Docker container, it typically listens on a specific port. For example, a web server might listen on port 80 or 8080 inside the container.


**Host Port**

- **Definition:** The host port is the port on the host machine (in computer or server) that is mapped to the container port. This allows us to access the containerized application from outside the container.
- **Usage:** By mapping a host port to a container port, we make the application accessible to external clients (e.g., web browsers, API clients) via the host machine’s IP address and the specified host port.


**Port Mapping**

- When we run a Docker container and want to expose a container port to the outside world, we need to map it to a host port. This is done using the `-p` or `--publish` option in the `docker run` command.

	```sh
		docker run -p <host_port>:<container_port> <image>
	```
**Example:**
- Suppose we have a web server running inside a Docker container that listens on port 80. If we want to access this web server from our host machine, we need to map a host port (e.g., 8080) to the container port (80).

	```sh
		docker run -p 8080:80 nginx
	```

- **Host Port 8080:** The port on our host machine that we will connect to.
- **Container Port 80:** The port inside the container where the web server is listening.

**Accessing the Web Server:**

- We can now access the web server by navigating to `http://localhost:8080` on our host machine.


# Docker Container Example

### Step 1: Run a Container

Run the following command to start a Docker container with the Nginx web server:

```sh
docker run -d -p 8080:80 --name webserver nginx
```


###  Step 2: Check Running Containers

To list the running containers and see the port mappings, use the following command:

```sh
docker ps
```

This command will display information about the running containers, including their ID, names, status, and port mappings.


### Step 3: Access the Application

Open a web browser and navigate to `http://localhost:8080`. We should see the default Nginx welcome page.
