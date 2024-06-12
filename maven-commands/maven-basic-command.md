# Maven Commands

Maven is a build automation tool used primarily for Java projects. Here is a reference for commonly used Maven commands:

## `mvn clean`

This command cleans the Maven project by deleting the target directory:

```sh
mvn clean
```

**Example Output:**

```csharp
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ maven-example-jar --- [INFO] Deleting /Users/manas/Desktop/maven-examples/maven-example-jar/target [INFO] ------------------------------------------------------------------------ [INFO] BUILD SUCCESS
```

## `mvn compiler:compile`

This command compiles the Java source classes of the Maven project:

```sh
mvn compiler:compile
```

**Example Output:**

```csharp
[INFO] --- maven-compiler-plugin:3.8.1:compile (default-cli) @ maven-example-jar --- [INFO] Changes detected - recompiling the module! [INFO] Compiling 1 source file to /Users/manas/Desktop/maven-examples/maven-example-jar/target/classes [INFO] ------------------------------------------------------------------------ [INFO] BUILD SUCCESS
```

## `mvn compiler:testCompile`

This command compiles the test classes of the Maven project:

```sh
mvn compiler:testCompile
```

**Example Output:**

```csharp
[INFO] --- maven-compiler-plugin:3.8.1:testCompile (default-cli) @ maven-example-jar --- [INFO] Changes detected - recompiling the module! [INFO] Compiling 1 source file to /Users/manas/Desktop/maven-examples/maven-example-jar/target/test-classes [INFO] ------------------------------------------------------------------------ [INFO] BUILD SUCCESS
```

## `mvn package`

This command builds the Maven project and packages it into a JAR, WAR, etc.:

```sh
mvn package
```

**Example Output:**

```csharp
[INFO] --- maven-compiler-plugin:3.8.1:compile (default-compile) @ maven-example-jar --- [INFO] Changes detected - recompiling the module! [INFO] Compiling 1 source file to /Users/manas/Desktop/maven-examples/maven-example-jar/target/classes ... [INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ maven-example-jar --- ... [INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ maven-example-jar --- ... [INFO] BUILD SUCCESS
```

## `mvn install`

This command builds the Maven project and installs the project files to the local `.m2` repository:

```sh
mvn install
```

**Example Output:**

```csharp
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ maven-example-jar --- ... [INFO] --- maven-compiler-plugin:3.8.1:compile (default-compile) @ maven-example-jar --- ... [INFO] --- maven-install-plugin:2.4:install (default-install) @ maven-example-jar --- [INFO] Installing /Users/manas/Desktop/maven-examples/maven-example-jar/target/maven-example-jar-0.0.1-SNAPSHOT.jar to /Users/sammy/.m2/repository/com/example/maven/maven-example-jar/0.0.1-SNAPSHOT/maven-example-jar-0.0.1-SNAPSHOT.jar [INFO] ------------------------------------------------------------------------ [INFO] BUILD SUCCESS
```

## `mvn deploy`

This command deploys the artifact to the remote repository:

```sh
mvn deploy
```

## `mvn validate`

This command validates the Maven project to ensure everything is correct:

```sh
mvn validate
```

## `mvn dependency:tree`

This command generates the dependency tree of the Maven project:

```sh
mvn dependency:tree
```

## `mvn dependency:analyze`

This command analyzes the Maven project to identify unused dependencies:

```sh
mvn dependency:analyze
```

## `mvn archetype:generate`

This command generates skeleton Maven projects of different types:

```sh
mvn archetype:generate
```

## `mvn site:site`

This command generates a site for the project:

```sh
mvn site:site
```

## `mvn test`

This command runs the test cases of the project:

```sh
mvn test
```

## `mvn compile`

This command compiles the source Java classes of the project:

```sh
mvn compile
```

## `mvn verify`

This command builds the project, runs all the test cases, and checks integration test results:

```sh
mvn verify
```

## Maven Options

Maven provides various command-line options to customize the build process:

- `-help`: Displays Maven usage and available options.
- `-f dir/pom.xml package`: Builds a project from a different location.
- `-o`: Runs the build in offline mode.
- `-q`: Runs the build in quiet mode.
- `-X`: Runs the build in debug mode.

For more information, use the `-help` option or refer to Maven documentation.
