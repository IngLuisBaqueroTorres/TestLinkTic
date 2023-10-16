# Test Linktic
## Docker
### Build
Para construir la imagen de docker se debe ejecutar el siguiente comando:

``` docker compose up --build ```

### Run
Para ejecutar la imagen de docker se debe ejecutar el siguiente comando:

``` docker compose up ```

### Stop
Para detener la imagen de docker se debe ejecutar el siguiente comando:

``` docker compose down ```
## Swagger
Para acceder a la documentación de la API se debe acceder a la siguiente URL:

``` http://localhost:8080/swagger-ui.html ```

## Kubernetes
### Deploy
Para arrancar el cluster de kubernetes se debe ejecutar el siguiente comando:

``` minikube start ```
### Build
Para construir la imagen de docker se debe ejecutar el siguiente comando:

``` eval $(minikube docker-env) ```

``` docker compose up --build ```
### Deploy
Para desplegar la aplicación en kubernetes se debe ejecutar el siguiente comando:

``` kubectl apply -f kubernetes/deployment.yaml ```
### Run
Para ejecutar la aplicación en kubernetes se debe ejecutar el siguiente comando:

``` kubectl port-forward deployment/testlinktic 8080:8080 ```