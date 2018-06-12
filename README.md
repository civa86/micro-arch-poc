# ELK Tracking P.O.C.

ELK - JVM MicroServices - Docker Containers

## JVM Microservices Architecture

### Spring Package Creator

###### Website

[Spring Boot Start](https://start.spring.io)

###### CLI

[Spring Boot CLI](https://docs.spring.io/spring-boot/docs/current/reference/html/cli.html)

## Service Dependencies

`Eureka Service`: Eureka Server

`Edge Service`: Eureka Discovery, Feign, Zuul, Rest Repositories, Web, Hystrix, Lombok

`Generic Service`: Eureka Discovery, Actuator, Web, DevTools


### Usage

```bash
cd <microservice_folder>
./mvnw spring-boot:run
```

### Eureka Discovery Service

http://localhost:8761/

### Authentication API Examples

> Login

```bash
curl -X POST \
     -u <CLIENT_ID>:<CLIENT_SECRET> \
     -F "username=<USERNAME>" \
     -F "password=<PASSWORD>" \
     -F "grant_type=password" \
     http://localhost:9000/oauth/token
```

> Profile Data

```bash
curl -H "Authorization: Bearer <ACCESS_TOKEN>" http://localhost:9000/user
```