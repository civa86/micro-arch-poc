# Build JAR
FROM java:8 as builder
RUN mkdir /build
COPY . /build
WORKDIR /build
RUN ./mvnw clean package -DskipTests

# Launch JAR
FROM java:8-alpine
RUN mkdir /service
COPY --from=builder /build/target/auth-service-0.0.1-SNAPSHOT.jar /service/svc.jar
EXPOSE 8080
WORKDIR /service
CMD ["java", "-jar", "svc.jar"]