# MySQL Docker Quickstart

This document provides **step-by-step instructions** for setting up and running a MySQL database using Docker — from pulling the image to connecting to the database.

Replace placeholders (`your_root_password`, `mydatabase`, `myuser`, `mypassword`) with your own values.

---

## 1. Pull the MySQL image
```bash
docker pull mysql:latest
```
> You can use a specific version, e.g. `mysql:8.0`.

---

## 2. (Optional) Create the container (without starting)
This sets up the environment variables, port, and persistent volume.

```bash
docker create \
  --name mysql-db \
  -e MYSQL_ROOT_PASSWORD=your_root_password \
  -e MYSQL_DATABASE=mydatabase \
  -e MYSQL_USER=myuser \
  -e MYSQL_PASSWORD=mypassword \
  -v mysql-data:/var/lib/mysql \
  -p 3306:3306 \
  mysql:latest
```

**Explanation:**
- `--name mysql-db` → Container name.
- `MYSQL_ROOT_PASSWORD` → Required, sets root password.
- `MYSQL_DATABASE`, `MYSQL_USER`, `MYSQL_PASSWORD` → Optional; create a DB and user automatically.
- `-v mysql-data:/var/lib/mysql` → Persistent storage.
- `-p 3306:3306` → Maps MySQL port to host.

---

## 3. Start the container
```bash
docker start mysql-db
```

Follow logs while starting:
```bash
docker logs -f mysql-db
```
Wait until you see: `ready for connections`.

---

## 4. Shortcut: Create and Run in a Single Command
```bash
docker run -d --name mysql-db \
  -e MYSQL_ROOT_PASSWORD=your_root_password \
  -e MYSQL_DATABASE=mydatabase \
  -e MYSQL_USER=myuser \
  -e MYSQL_PASSWORD=mypassword \
  -v mysql-data:/var/lib/mysql \
  -p 3306:3306 \
  mysql:latest
```

- `-d` → Detached mode (runs in background).

---

## 5. Enter the container shell
```bash
docker exec -it mysql-db bash
```
If `bash` isn’t available, use:
```bash
docker exec -it mysql-db sh
```

---

## 6. Connect to MySQL inside the container
Once inside:
```bash
mysql -u root -p
```
Enter your password when prompted.

Or connect to the created DB/user:
```bash
mysql -u myuser -p mydatabase
```

---

## 7. Run MySQL commands
Inside MySQL prompt:
```sql
SHOW DATABASES;
USE mydatabase;
SHOW TABLES;
DESCRIBE table_name;
SELECT * FROM table_name LIMIT 10;
```

---

## 8. One-liner access from host
Run MySQL client directly via Docker:
```bash
docker exec -it mysql-db mysql -u root -p
```
Or specify DB and user:
```bash
docker exec -it mysql-db mysql -u myuser -p mydatabase
```

If you have the MySQL client installed on your host:
```bash
mysql -h 127.0.0.1 -P 3306 -u root -p
```

---

## 9. Useful Docker commands
```bash
# show all containers
docker ps -a

# stop / restart container
docker stop mysql-db
docker restart mysql-db

# remove container
docker rm -v mysql-db

# remove image
docker rmi mysql:latest

# check logs
docker logs mysql-db
```

---

## 10. Docker Compose Example
Save as `docker-compose.yml`:

```yaml
version: '3.8'
services:
  mysql:
    image: mysql:latest
    container_name: mysql-db
    environment:
      MYSQL_ROOT_PASSWORD: your_root_password
      MYSQL_DATABASE: mydatabase
      MYSQL_USER: myuser
      MYSQL_PASSWORD: mypassword
    ports:
      - "3306:3306"
    volumes:
      - mysql-data:/var/lib/mysql
volumes:
  mysql-data:
```

Run it:
```bash
docker-compose up -d
```

---

## 11. Windows PowerShell example
PowerShell one-liner:
```powershell
docker run -d --name mysql-db -e MYSQL_ROOT_PASSWORD="your_root_password" -e MYSQL_DATABASE="mydatabase" -e MYSQL_USER="myuser" -e MYSQL_PASSWORD="mypassword" -v mysql-data:/var/lib/mysql -p 3306:3306 mysql:latest
```

---

## 12. Troubleshooting
- **Port already in use** → Change host port mapping (e.g., `-p 13306:3306`).
- **Access denied errors** → Ensure user credentials are correct.
- **Permission issues** → Check folder ownership if using host-mounted volumes.
- **Check logs:**
  ```bash
  docker logs mysql-db
  ```

---

## 13. Security tips
- Avoid hardcoding passwords in files.
- Use Docker secrets or environment management for production setups.

---

## 14. TL;DR Quick Setup
```bash
docker pull mysql:latest

docker run -d --name mysql-db \
  -e MYSQL_ROOT_PASSWORD=your_root_password \
  -e MYSQL_DATABASE=mydatabase \
  -e MYSQL_USER=myuser \
  -e MYSQL_PASSWORD=mypassword \
  -v mysql-data:/var/lib/mysql \
  -p 3306:3306 \
  mysql:latest

# connect directly
docker exec -it mysql-db mysql -u root -p
```

---

*End of document.*