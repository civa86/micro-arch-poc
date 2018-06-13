# [P.O.C.] Microservices Architecture

This project contains a P.O.C of a microservices architecture that runs under JVM (Java, Clojure).

Docker...ELK...

## Spring Boot Package Creator

###### Website

[Spring Boot Start](https://start.spring.io)

###### CLI

[Spring Boot CLI](https://docs.spring.io/spring-boot/docs/current/reference/html/cli.html)

## Service Dependencies

`Eureka Service`: Eureka Server

`Edge Service`: Eureka Discovery, Feign, Zuul, Rest Repositories, Web, Hystrix, Lombok

`Generic Service`: Eureka Discovery, Actuator, Web, DevTools


## Usage

```bash
cd <microservice_folder>
./mvnw spring-boot:run
```

## Eureka Discovery Service

TODO:  Move under eureka readme

http://localhost:8761/

## JVM Microservices Architecture

* [Eureka Service]()
* [Edge Service]()
* [Auth Service](./infrastructure/auth-service/README.md)