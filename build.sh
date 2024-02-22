mvn clean package
docker build -t hengyoush/my-spring-boot-app:$EXP_ID .
docker login -u $DOCKER_HUB_USERNAME -p $DOCKER_HUB_PASSWORD
docker push docker.io/hengyoush/my-spring-boot-app:$EXP_ID
