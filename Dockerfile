FROM java:8
ADD target/authorize-service.jar authorize-service.jar
ENTRYPOINT ["java","-jar","authorize-service.jar"]
