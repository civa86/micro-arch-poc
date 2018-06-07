FROM java:8-alpine

ADD target/edge-service-0.0.1-SNAPSHOT.jar /edge-service/app.jar

EXPOSE 8080

CMD ["java", "-jar", "/edge-service/app.jar"]