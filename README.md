Kubehelper rest API
=========================

# How to Run

**1. Clone the repository**

```bash
git https://github.com/shasooka/kubehelper.git
```

**2. Configure PostgreSQL**

First, create a database named `kubehelper`. Then, open `src/main/resources/application.properties` file and change the spring datasource username and password as per your PostgreSQL installation.

**3. Build the app**

Type the following command from the root directory of the project to build and test it -

```bash
mvn test

mvn package
```

**4. Run the app**

Type the following command from the root directory of the project to run it -
```bash
java -jar target/kubehelper-0.0.1-SNAPSHOT.jar

```
# Run in docker 

docker build -t kubehelper .

docker run -p8080:8080 kubehelper:latest

After running docker you can access the application at http://localhost:8080/