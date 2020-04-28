FROM java:8
ADD target/authentication-service.jar authentication-service.jar
ENTRYPOINT ["java","-jar","authentication-service.jar"]
