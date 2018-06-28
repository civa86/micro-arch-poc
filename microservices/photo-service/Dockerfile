# Build JAR
FROM maven:3.5.3-jdk-8-alpine as builder

ENV BUILD_DIR=/build

RUN mkdir $BUILD_DIR
WORKDIR $BUILD_DIR
ADD pom.xml $BUILD_DIR
RUN mvn verify clean --fail-never
ADD . $BUILD_DIR
RUN mvn clean package -DskipTests

# Launch JAR
FROM java:8-alpine

ENV ARTIFACT=photo-service-0.0.1-SNAPSHOT.jar
ENV PORT=8082

RUN mkdir /service
COPY --from=builder /build/target/$ARTIFACT /service/svc.jar
EXPOSE $PORT
WORKDIR /service
CMD java $JAVA_OPTIONS -jar svc.jar