# Setting Up dbdocs for Your DBML File

Follow these steps to set up `dbdocs` and generate documentation for your DBML file.

## 1. Install dbdocs

First, you'll need to install `dbdocs`. You can do this using npm, which is a package manager for Node.js.

1. **Install Node.js and npm**
   - If you don't have Node.js and npm installed, you can download and install it from [nodejs.org](https://nodejs.org).

2. **Install dbdocs globally**
   - Open your terminal and run the following command to install `dbdocs` globally:
   
     ```bash
     npm install -g dbdocs
     ```
   - Or use
  
     ```bash
     sudo npm install -g dbdocs
     ```

## 2. Log in to dbdocs

You need to log in to your `dbdocs` account. If you don't have an account, you can create one at [dbdocs.io](https://dbdocs.io).

1. **Log in to dbdocs**
   - Run the following command in your terminal:
   
     ```bash
     dbdocs login
     ```
   
   - Follow the prompts to log in or sign up.

## 3. Create the DBML File

Create a file named `database.dbml` and copy the DBML content into it. You can do this in any text editor.

## 4. Build the Documentation

Now you can build the documentation from your DBML file.

1. **Navigate to your project directory**
   - Open your terminal and navigate to the directory where your `database.dbml` file is located:
   
     ```bash
     cd /path/to/your/project
     ```

2. **Build the documentation**
   - Run the following command to build the documentation:
   
     ```bash
     dbdocs build /path/to/your/project/database.dbml
     ```

## 5. View Your Documentation

After building, you can view your documentation online.

1. **Open the documentation in your browser**
   - Once the build is successful, you can open your documentation by visiting your dbdocs profile at [dbdocs.io](https://dbdocs.io).

## Summary of Commands

1. **Install dbdocs**:
   ```bash
   sudo npm install -g dbdocs
   ```
2. **Log in to dbdocs**:
    ```bash
    dbdocs login
    ```
3. **Navigate to your project directory**:
    ```bash
    cd /path/to/your/project
    ```
4. **Build the documentation**:
    ```bash
    dbdocs build /path/to/your/project/database.dbml
    ```
