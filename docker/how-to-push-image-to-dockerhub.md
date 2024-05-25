# How to push your image to DockerHub?

To push a Docker image to Docker Hub, you need to follow these steps:

1. **Tag the Docker Image:**
- Before pushing the image, ensure it's tagged correctly with your Docker Hub repository name. The format for tagging is `docker tag <image_id> <username>/<repository>:<tag>`. Replace `<image_id>` with the ID of your Docker image, `<username>` with your Docker Hub username or organization, `<repository>` with the name of your repository on Docker Hub, and `<tag>` with the tag you want to assign to the image (e.g., `latest`).
    
    ```
    docker tag my-spring-boot-app username/my-spring-boot-app:latest
    ```
    
2. **Login to Docker Hub:** 
- Use the `docker login` command to log in to Docker Hub. Enter your Docker Hub username, password, and optionally your email address when prompted.
    
    ```
    docker login
    ```
    
3. **Push the Docker Image:**
- Once logged in, you can push the tagged image to Docker Hub using the `docker push` command. Specify the full image name (including repository and tag) you tagged in the previous step.
    
    ```
    docker push username/my-spring-boot-app:latest
    ```
    

Replace `<username>` with your Docker Hub username or organization and `<repository>` with the name of your repository on Docker Hub.

4. **Verify on Docker Hub:**
- Go to Docker Hub (https://hub.docker.com/) and log in to your account. Navigate to your repository to verify that the image has been successfully pushed and is available on Docker Hub.
