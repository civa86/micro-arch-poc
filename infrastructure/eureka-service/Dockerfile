FROM java:8-alpine

ADD target/eureka-service-0.0.1-SNAPSHOT.jar /eureka-service/app.jar

EXPOSE 8761

CMD ["java", "-jar", "/eureka-service/app.jar"]