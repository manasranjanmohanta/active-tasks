# Debug Docker Container

Debugging a Docker container involves troubleshooting and resolving issues that arise during the container's runtime.

### 1. Check Container Status and Logs

1. **Check Container Status:** 
- Use the `docker ps` command to list all running containers:

	```sh
	docker ps
	```

- If the container is not running, use `docker ps -a` to see all containers (including stopped ones) and their statuses.

2. **View Container Logs:**
-  Use the `docker logs` command to view the logs of a specific container.

	```sh
	docker logs <container_id_or_name>
	```

- Replace `<container_id_or_name>` with the actual container ID or name.


### 2. Access Container Shell for Inspection

1. **Access Container Shell:** 
- If there is a need to inspect the container interactively, use `docker exec` to access its shell:

	```sh
	docker exec -it <container_id_or_name> /bin/bash
	```

- This command opens a shell inside the container, allows to run commands and investigate the container's environment.


### 3. Debug Application Within the Container

1. **Check Application Logs:** 
- Within the container shell, check the application's logs or output for any errors or warnings:

	```sh
	tail -f /path/to/application/logs
	```

2. **Run Debugging Tools:**
- Install and run debugging tools inside the container to troubleshoot specific issues. For example, if it's a Node.js application, we might use `node inspect` for debugging.


### 4. Check Container Resources and Settings

1. **Check Container Resource Usage:**
- Use `docker stats` to monitor resource usage (CPU, memory, etc.) of running containers:

	```sh
	docker stats <container_id_or_name>
	```
    
2. **Inspect Container Configuration:**
- Use `docker inspect` to view detailed information about a container, including its configuration:

    ```sh
    docker inspect <container_id_or_name>
    ```


### 5. Update Container Configuration or Environment

1. **Restart Container:** 
- If you've made changes to the container's configuration or environment, restart the container to apply the changes:

	```sh
	docker restart <container_id_or_name>
	```
    
2. **Update Container Settings:** 
- If necessary, update the container settings (e.g., environment variables, volume mounts) using `docker update`.


### 6. Analyze Container Network Connectivity

1. **Check Network Configuration:** Use `docker network inspect` to view network configuration details, especially if your application relies on network connectivity:

	```sh
	docker network inspect <network_id_or_name>
	```
    
2. **Test Network Connectivity:** 
- Test network connectivity from inside the container using tools like `ping`, `curl`, or `telnet` to troubleshoot network-related issues.


### 7. Monitor and Collect Container Metrics

1. **Use Monitoring Tools:**
- Set up monitoring tools or services (e.g., Prometheus, Grafana) to collect metrics and monitor container performance over time.
    
2. **Utilize Docker Health Checks:** 
- Implement Docker health checks in your Dockerfile or Compose file to automatically monitor the health of your containers.

Example: `docker-compose.yml`

```sh
version: '3.8'

services:
  myapp:
    image: myapp-image:latest
    ports:
      - "8080:8080"
    healthcheck:
      test: ["CMD-SHELL", "curl -f http://localhost:8080/health || exit 1"]
      interval: 30s
      retries: 3
      timeout: 10s
```

In this example:

- `myapp` is the name of your service.
- `myapp-image:latest` is the Docker image used for the service. Replace it with your actual image name and tag.
- The `ports` section maps port `8080` of the container to port `8080` on the host machine.
- The `healthcheck` section defines the health check for the container:
    - `test` specifies the command to run for the health check. Here, it uses `curl` to check the health endpoint (`/health`) of the application. If the command returns a non-zero exit code, the health check fails.
    - `interval` sets the interval between health checks. In this case, it checks every `30s`.
    - `retries` specifies the number of retries before considering the container unhealthy.
    - `timeout` sets the maximum time to wait for the health check command to complete.
