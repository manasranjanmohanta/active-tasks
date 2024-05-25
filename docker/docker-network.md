# Docker Network

In Docker, networking plays a crucial role in facilitating communication between containers, enabling services to interact, and connecting containers to external networks.

1. **Default Network:** When we install Docker, it creates a default bridge network named `bridge`. Containers connected to this network can communicate with each other by default, using container names as hostnames.
    
2. **User-Defined Networks:** Docker allows us to create custom networks with specific configurations, such as subnet range, gateway, and DNS settings. This helps in organizing and isolating containers based on their functionality or application.
    
3. **Network Drivers:** Docker supports multiple network drivers to suit different use cases:
    
    - `bridge`: Default network driver for connecting containers on the same host.
    - `host`: Connects containers directly to the host network, bypassing Docker's network isolation.
    - `overlay`: Facilitates communication between containers across multiple Docker hosts in a swarm cluster.
    - `macvlan`: Assigns containers a MAC address from the host's network, enabling them to appear as physical devices on the network.
    - `none`: Disables networking for a container, useful for special cases like storage-only containers.
4. **Container Connectivity:** Containers within the same network can communicate with each other using container names or service names (if using Docker Compose or Swarm). They can also communicate via exposed ports or internal DNS resolution.
    
5. **External Connectivity:** Docker containers can connect to external networks, including the host network and external networks (e.g., the internet) if properly configured. Port mappings and network bridge settings allow for inbound and outbound communication.

### Example Docker Network Commands

1. **List Networks:**
	```sh
	docker network ls
	```
    
2. **Inspect Network:**
    ```sh
    docker network inspect <network_name>
	```
    
3. **Create a Custom Network:**
	```
	docker network create my-network
	```
    
4. **Run Container on Custom Network:**
    ```sh
    docker run -d --network=my-network --name=my-container nginx
    ```
    
5. **Connect Container to Network:**
	 ```
	docker network connect my-network my-container
	```
    
6. **Disconnect Container from Network:**
	```sh
	docker network disconnect my-network my-container
	```
