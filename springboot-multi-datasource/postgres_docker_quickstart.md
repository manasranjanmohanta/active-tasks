# PostgreSQL Docker Quickstart

This document walks you **step-by-step** from pulling the PostgreSQL Docker image to running the database and accessing it. Copy‑paste commands, replace placeholder values (`your_root_password`, `mydatabase`, `myuser`, `mypassword`) with your own.

---

## 1. Pull the PostgreSQL image
```bash
docker pull postgres:latest
```
> To use a specific version, replace `latest` with e.g. `postgres:15`.

---

## 2. (Optional) Create the container configuration (without starting)
This creates a container with environment variables, data volume and port mapping.

```bash
docker create \
  --name postgres-db \
  -e POSTGRES_PASSWORD=your_root_password \
  -e POSTGRES_DB=mydatabase \
  -e POSTGRES_USER=myuser \
  -v postgres-data:/var/lib/postgresql/data \
  -p 5432:5432 \
  postgres:latest
```

**Notes:**
- `POSTGRES_PASSWORD` is required.
- `POSTGRES_DB` and `POSTGRES_USER` are optional; if omitted, default DB and user `postgres` will be used.
- `postgres-data` is a named volume that persists DB files across container restarts.

---

## 3. Start the container
```bash
docker start postgres-db
```

To follow logs while starting:
```bash
docker logs -f postgres-db
```
Look for a log line like: `database system is ready to accept connections`.

---

## 4. Create + Run in a single command (shortcut)
If you prefer to create and start in one step:

```bash
docker run -d --name postgres-db \
  -e POSTGRES_PASSWORD=your_root_password \
  -e POSTGRES_DB=mydatabase \
  -e POSTGRES_USER=myuser \
  -v postgres-data:/var/lib/postgresql/data \
  -p 5432:5432 \
  postgres:latest
```

- `-d` runs the container detached (in the background).

---

## 5. Enter the container shell
```bash
docker exec -it postgres-db bash
```
If `bash` is not available, use `sh` instead:
```bash
docker exec -it postgres-db sh
```

---

## 6. Use `psql` inside the container
After shelling into the container, run:
```bash
psql -U myuser -d mydatabase
```
Or connect as default `postgres` user:
```bash
psql -U postgres
```

---

## 7. One-line ways to run `psql` (from host)
If you have `psql` installed on the host:
```bash
psql -h 127.0.0.1 -p 5432 -U myuser -d mydatabase
```

Or run `psql` using `docker exec` directly (no shell):
```bash
docker exec -it postgres-db psql -U myuser -d mydatabase
```

---

## 8. Common `psql` commands to inspect the DB
Once inside `psql` prompt:
```sql
\l            -- list databases
\c mydatabase -- connect to `mydatabase`
\dt           -- list tables in current schema
\dt public.*  -- list tables in `public` schema
\d table_name -- describe columns and types of a table
\d+ table_name -- describe table with extra info (size, description)
SELECT * FROM table_name LIMIT 100; -- run a SELECT
```

---

## 9. Useful Docker management commands
```bash
# show containers
docker ps -a

# stop / restart
docker stop postgres-db
docker restart postgres-db

# remove container (and unnamed volumes)
docker rm -v postgres-db

# remove image if needed
docker rmi postgres:latest

# show logs
docker logs postgres-db
```

---

## 10. Docker Compose example
Save this as `docker-compose.yml` and run `docker-compose up -d`.

```yaml
version: '3.8'
services:
  postgres:
    image: postgres:latest
    container_name: postgres-db
    environment:
      POSTGRES_USER: myuser
      POSTGRES_PASSWORD: your_root_password
      POSTGRES_DB: mydatabase
    ports:
      - "5432:5432"
    volumes:
      - postgres-data:/var/lib/postgresql/data
volumes:
  postgres-data:
```

---

## 11. Windows PowerShell tips
- Use double quotes for env vars and avoid backslash line continuations; a single-line `docker run` works fine.
- Example PowerShell one-liner:
```powershell
docker run -d --name postgres-db -e POSTGRES_PASSWORD="your_root_password" -e POSTGRES_DB="mydatabase" -e POSTGRES_USER="myuser" -v postgres-data:/var/lib/postgresql/data -p 5432:5432 postgres:latest
```

---

## 12. Quick troubleshooting
- If bind port 5432 is already in use, change the host port mapping (e.g., `-p 15432:5432`).
- Permission issues with host-mounted volumes: ensure host folder permissions allow Docker to write.
- If container repeatedly restarts, check `docker logs postgres-db` for errors.

---

## 13. Security reminders
- Don’t hardcode production passwords in plaintext or in VCS.
- For production, use secrets management (Docker secrets, environment vaults, or Kubernetes secrets).

---

## 14. TL;DR quick copy-paste (create & run)
```bash
docker pull postgres:latest

docker run -d --name postgres-db \
  -e POSTGRES_PASSWORD=your_root_password \
  -e POSTGRES_DB=mydatabase \
  -e POSTGRES_USER=myuser \
  -v postgres-data:/var/lib/postgresql/data \
  -p 5432:5432 \
  postgres:latest

# connect directly
docker exec -it postgres-db psql -U myuser -d mydatabase
```

---

*End of document.*

