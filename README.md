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

### Authentication Examples

#### User

> Login

```bash
curl -X POST \
     -u clientId:clientSecret \
     -F "username=user@test.com" \
     -F "password=password" \
     -F "grant_type=password" \
     http://localhost:9000/oauth/token
```

> Profile

#### Admin

> Login

```bash
curl -X POST \
     -u clientId:clientSecret \
     -F "username=admin@test.com" \
     -F "password=password" \
     -F "grant_type=password" \
     http://localhost:9000/oauth/token
```