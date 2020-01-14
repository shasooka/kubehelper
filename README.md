Kubehelper rest API
=========================

# How to Run

mvn test

mvn package

# Run in docker 

docker build -t kubehelper .

docker run -p8080:8080 kubehelper:latest

After running docker you can access the application at http://localhost:8080/