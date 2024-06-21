# Database Migration using "`Flyway`"

Flyway is a database migration tool that helps you manage and apply database changes in a consistent and reliable way. It is designed to be easy to use and integrate with your existing tools and frameworks, and it works with a wide range of databases.

## Step 1: Add Flyway Dependencies to the POM

First, let’s add the Flyway dependencies to our POM file. Open the `pom.xml` file and add the following dependencies:

```xml
<dependency>  
    <groupId>org.flywaydb</groupId>  
    <artifactId>flyway-core</artifactId>  
</dependency>
```

## Step 2: Configure the Database Connection

Next, we need to configure the database connection for our application. In the `application.properties` file, add the following properties:

```properties
spring.application.name=user-service
spring.datasource.url=jdbc:mysql://localhost:3306/hotel_db?autoreconnect=true
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```


## Step 3: Create the Database Migration Scripts

Now that our application is configured to connect to the database, we can start creating the database migration scripts. Flyway uses a specific naming convention for the scripts, so make sure to follow it:

- `V<version>__<description>.sql` for versioned scripts
- `U<version>__<description>.sql` for undo scripts
- `R__<description>.sql` for repeatable scripts

For example, to create a script that creates a `users` table, you can create a file named `V1__CREATE_USERS_TABLE.sql` with the following content:

```
CREATE TABLE users
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    username   VARCHAR(50) UNIQUE  NOT NULL,
    password   VARCHAR(255)        NOT NULL,
    email      VARCHAR(100) UNIQUE NOT NULL,
    role       SMALLINT            NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
```


## Step 4: Set the Flyway Configuration Properties

Flyway has several configuration properties that you can set in the `application.properties` file. Here are a few of the most important ones:

- `**flyway.baselineOnMigrate**`: if set to `true`, Flyway will automatically create the baseline for your database when you run the migration. This is useful if you are starting from scratch and don't have any existing database.
- `**flyway.locations**`: this property specifies the locations where Flyway should look for the migration scripts. By default, Flyway will look for them in the `classpath:db/migration` directory, but you can specify a different location if needed.
- `**flyway.schemas**`: this property specifies the schemas that Flyway should manage. You can specify a single schema or multiple schemas separated by commas.

For example, to set the `locations` property to a different directory and the `schemas` property to a single schema, you can add the following to the application. Properties file:

```properties
spring.flyway.enabled=true
flyway.locations=db/migrations  
flyway.schemas=hotel_db
```


## Step 5: Run the Database Migrations

Now that everything is configured, we can run the database migrations. There are two ways to do this:

1. Using the Flyway Maven plugin: you can add the Flyway Maven plugin to your `pom.xml` file and run the `migrate` goal to apply the pending migrations.

```properties
	<build>
	  <plugins>
	    <plugin>
	      <groupId>org.flywaydb</groupId>
	      <artifactId>flyway-maven-plugin</artifactId>
	      <version>6.5.7</version>
	      <configuration>
	        <url>jdbc:mysql://localhost:3306/your_database</url> <!-- Update with your database URL -->
	        <user>your_username</user> <!-- Update with your MySQL username -->
	        <password>your_password</password> <!-- Update with your MySQL password -->
	        <schemas>
	          <schema>your_schema</schema> <!-- Optional: Specify the schema if needed -->
	        </schemas>
	        <locations>
	          <location>filesystem:src/main/resources/db/migration</location> <!-- Update this if your migrations are in a different directory -->
	        </locations>
	      </configuration>
	    </plugin>
	  </plugins>
	</build>
	
	<dependencies>
	  <dependency>
	    <groupId>mysql</groupId>
	    <artifactId>mysql-connector-java</artifactId>
	    <version>8.0.23</version> <!-- Ensure you have the MySQL connector dependency -->
	  </dependency>
	</dependencies>
```

Then, you can run the following command to apply the pending migrations:

`mvn flyway:migrate`

2. Using the Flyway API: you can also use the Flyway API to apply the migrations in your application code. To do this, you will need to create a `Flyway` bean and configure it with the desired properties.

```java
	package com.example.employee.configs;
	
	import jakarta.annotation.PostConstruct;
	import lombok.extern.slf4j.Slf4j;
	import org.flywaydb.core.Flyway;
	import org.springframework.beans.factory.annotation.Value;
	import org.springframework.context.annotation.Configuration;
	
	import javax.sql.DataSource;
	
	@Configuration
	@Slf4j
	public class FlywayConfiguration {
	
	    private final DataSource dataSource;
	
	    @Value("${spring.flyway.baselineOnMigrate}")
	    private boolean baselineOnMigrate;
	
	    public FlywayConfiguration(DataSource dataSource) {
	        this.dataSource = dataSource;
	    }
	
	    @PostConstruct
	    public void init() {
	        log.info("Migration started");
	        migrations(dataSource);
	        log.info("Migration completed");
	    }
	
	    private void migrations(DataSource dataSource) {
	        Flyway flyway = Flyway
	                .configure()
	                .dataSource(dataSource)
	                .baselineOnMigrate(baselineOnMigrate)
	                .locations("classpath:/db/migration")
	                .load();
	
	        flyway.migrate();
	    }
	
	}
```


## Basic Terminologies

### 1. Migration

In the database context, migration refers to the process of making structured changes in the database schema such as performing a [CRUD operations](https://www.geeksforgeeks.org/crud-operations-in-mysql/) that changes the state of the database. Database Migration is an essential technique when dealing with industry-level projects, as our application evolves, we may encounter various anomalies or redundancies so to counter these we migrate our database which can easily be done by utilizing tools like Flyway.

### 2. Migration Script

Database Migration instructions are typically written in a separate file which are referred to as the migration scripts. These scripts contain the instruction to perform migration on the database in a specific query language (eg: SQL). By default, spring scans the following location for the migration script :

`resources/db/migration`

### 3. Migration Lifecycle

Migration lifecycle refers to the process of performing migration on the database. This goes as follows:

1. Write a Migration Script containing instructions on how to migrate the database
2. Save the script using the version number so that Flyway can identity the order and execute it accordingly.
3. The script is automatically executed by flyway to maintain consistency, ensuring the execution is done only once.

### 4. Version Control

The version control system of the flyway is very essential feature that’s defined to maintain the order of execution. Whenever the user creates a migration script, they’ll save it with their version number in following format :

**V<version_number>__migrationScriptName.sql**  
Ex : V1__create_user_table.sql

V1 is the version number, indicating this script should be executed first in order. Ensure that after the version number comes two underscores (__) and the name is delimited by single underscores.

[read more](https://oril.co/blog/flyway-with-spring-boot-and-mysql/)

