### Docker for windows
No needed changes only make sure that the docker is up and running

### Minikube usage

1. Run   _minikube docker-env_

> $ minikube docker-env

- export DOCKER_TLS_VERIFY="1"
- export DOCKER_HOST="tcp:/**DOCKER_IP**:**DOCKER_PORT**"
- export DOCKER_CERT_PATH="C:/Users/**YOUR_USER**/.minikube/certs"
- export MINIKUBE_ACTIVE_DOCKERD="minikube"

2. Create under C:/Users/**YOUR_USER** .testcontainers.properties

Note: Create the file with extension **properties** !!!

3. Use from docs https://java.testcontainers.org/features/configuration/ -> **Customizing Docker host detection**
   to set the file by using what you ve got from step 1. 