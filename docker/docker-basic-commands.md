# Docker Basic Commands

1. **docker --version**
    - Description: Check the installed Docker version.
    - Usage:
      ```sh
      docker --version
      ```

2. **docker pull**
   - Description: Download a Docker image from a registry (like Docker Hub).
   - Usage:
     ```sh
     docker pull <image_name>
     ```
   - Example:
     ```sh
     docker pull mongo
     ```

3. **docker run**
   - Description: Run a command in a new container.
   - Usage:
     ```sh
     docker run [OPTIONS] IMAGE [COMMAND] [ARG...]
     ```
   - Example:
     ```sh
     docker run -d -p 80:80 nginx
     ```

4. **docker ps**
   - Description: List running containers.
   - Usage:
     ```sh
     docker ps
     ```

5. **docker ps -a**
   - Description: List all containers, including stopped ones.
   - Usage:
     ```sh
     docker images
     ```

6. **docker images**
   - Description: List all Docker images on the local sytem.
   - Usage:
     ```sh
     docker images
     ```

7. **docker stop**
   - Description: Stop a running container.
   - Usage:
     ```sh
     docker stop <container_id>
     ```

8. **docker start**
   - Description: Start a stopped container.
   - Usage:
     ```sh
     docker start <container_id>
     ```

9. **docker restart**
    - Description: Restart a running container.
    - Usage:
      ```sh
      docker restart <container_id>
      ```

10. **docker rm**
    - Description: Remove a container.
    - Usage:
      ```sh
      docker rm <container_id>
      ```

11. **docker rmi**
    - Description: Remove an image.
    - Usage:
      ```sh
      docker rmi <image_id>
      ```

11. **docker exec**
    - Description: Run a command in a running container.
    - Usage:
      ```sh
      docker exec [OPTIONS] CONTAINER COMMAND [ARG...]
      ```
    - Example:
      ```sh
      docker exec -it <container_id> /bin/bash
      ```

12. **docker logs**
    - Description: Run a command in a running container.
    - Usage:
      ```sh
      docker exec [OPTIONS] CONTAINER COMMAND [ARG...]
      ```
    - Example:
      ```sh
      docker exec -it <container_id> /bin/bash
      ```

13. **docker build**
    - Description: Build an image from a Dockerfile.
    - Usage:
      ```sh
      docker build [OPTIONS] PATH
      ```
      - Example:
      ```sh
      docker build -t my-image:latest .
      ```

14. **docker-compose up**
    - Description: Build, (re)create, start, and attach to containers for a service defined in a `docker-compose.yml` file.
    - Usage:
      ```sh
      docker-compose up
      ```

15. **docker-compose down**
    - Description: Build, (re)create, start, and attach to containers for a service defined in a `docker-compose.yml` file.
    - Usage:
      ```sh
      docker-compose up
      ```
