FROM java:8-alpine

ADD target/uberjar/random-service.jar /random-service/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/random-service/app.jar"]
