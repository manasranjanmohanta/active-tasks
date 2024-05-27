# What is Github Actions?

GitHub Actions is a platform that allows developers to automate various workflows related to their projects. It integrates seamlessly with GitHub repositories and can handle tasks ranging from simple automation to complex CI/CD pipelines.

### CI/CD Tool
While GitHub Actions can automate many different workflows, one of its primary uses is as a CI/CD (Continuous Integration/Continuous Deployment) tool. CI/CD is a process that automates the testing, building, and deployment of code, ensuring that new code changes are safely integrated and deployed.


## What are those workflows?

### CI/CD Pipeline

A typical CI/CD pipeline involves several stages:

1. **Merged Code:** The code is merged into the main branch.

2. **Test:** Automated tests are run to ensure the code works as expected.

3. **Build:** The code is built into a deployable application.

4. **Deployment:** The built application is deployed to a staging or production environment.


![CI/CD Pipeline](https://github.com/manasranjanmohanta/md-related-docs/blob/main/github-actions/github-action4.png)

## How Github Actions automate these workflows?

GitHub Actions automate workflows by responding to events that occur in or to your repository. These events are known as GitHub Events and include activities like:

- Pull Request (PR) creation
- Contributor joining the repository
- Issue creation
- PR merging
- Integration with other apps

When such events are detected, GitHub Actions can trigger predefined actions to execute in response.

![GitHub Events](https://github.com/manasranjanmohanta/md-related-docs/blob/main/github-actions/github-action3.png)

## CI/CD with Github Actions

The most common workflow for repositories involves the CI/CD process:

1. **Commit Code:** Developers commit changes to the repository.
2. **Test:** Automated tests are run on the new code.
3. **Build:** The code is built into an application.
4. **Push:** The built application is pushed to a container registry or a storage location.
5. **Deploy:** The application is deployed to a production environment.

![CI/CD Process](https://github.com/manasranjanmohanta/md-related-docs/blob/main/github-actions/github-action2.png)
 
## Why not have just another CI/CD Tool?

Using GitHub Actions for CI/CD has several advantages:

- Single Tool Integration: It eliminates the need for third-party CI/CD tools, streamlining the development process.
- Ease of Setup: Setting up CI/CD pipelines with GitHub Actions is straightforward and user-friendly.
- Developer-Friendly: GitHub Actions is designed with developers in mind, reducing the need for specialized DevOps engineers.
- No Need for Jenkins: It provides a simpler alternative to tools like Jenkins, reducing complexity.

  
## Why is the setup easier?

GitHub Actions' integration with various programming languages and environments makes setup easier and more flexible. It supports:

- Direct integration with popular languages and frameworks
- Easy configuration with YAML files
- Extensive marketplace for pre-built actions and workflows

![Integration](https://github.com/manasranjanmohanta/md-related-docs/blob/main/github-actions/github-action1.png)


# Basic Example

```yml
name: Java CI with Maven and Tests

# Trigger on push events to the main branch and pull request events
on:
  push:
    branches: [ main ]
  pull_request:
    branches: [ main ]

# Use an Ubuntu runner with the latest version
jobs:
  build:
    runs-on: ubuntu-latest
    # If you want to run on different OSs, replace ubuntu-latest with the OS you want to run on e.g. macos-latest
    # runs-on: ${{ matrix.os }}
    # strategy:
    #   matrix:
    #     java-version: [ 8, 11, 17 ]
    #     os: [ ubuntu-latest, macos-latest, windows-latest ]

    steps:
      # Checkout the code from the GitHub repository
      - uses: actions/checkout@v4

      # Setup Java 17 using actions/setup-java action
      - name: Set up JDK 17
        uses: actions/setup-java@v3
        with:
          java-version: '17'
          distribution: 'temurin'

      # Cache Maven packages to improve workflow execution time
      - name: Cache Maven packages
        uses: actions/cache@v3
        with:
          path: ~/.m2/repository
          key: ${{ runner.os }}-maven-${{ hashFiles('**/pom.xml') }}
          restore-keys: |
            ${{ runner.os }}-maven-

      # Build the project with Maven (fail on failures)
      - name: Build with Maven (fail on errors)
        run: mvn -B package --file pom.xml || exit 1

      # Run tests with Maven (fail on failures)
      - name: Run tests with Maven (fail on errors)
        run: mvn test --file pom.xml || exit 1

      # Login to Docker Hub (replace with your credentials)
      - name: Login to Docker Hub
        run: echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin
        env:
          DOCKER_USERNAME: ${{ secrets.DOCKER_USERNAME }}
          DOCKER_PASSWORD: ${{ secrets.DOCKER_PASSWORD }}

      # Build Docker image based on your Dockerfile
      - name: Build Docker image
        run: docker build -t ${{ secrets.DOCKER_USERNAME }}/your-image-name:latest .

      # Push Docker image to Docker Hub (replace with your image name)
      - name: Push Docker image
        run: docker push ${{ secrets.DOCKER_USERNAME }}/your-image-name:latest

      # Upload build artifacts (optional)
      - name: Upload build artifacts
        uses: actions/upload-artifact@v3
        with:
          name: maven-artifacts
          path: target/*.jar

# Replace pom.xml with the actual path to your project's pom.xml file if it's located differently.
# Adjust the java-version if you need a different Java version.

```



