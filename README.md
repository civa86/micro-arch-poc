# [P.O.C.] Microservices Architecture

Proof of Concept of a Microservices Architecture.

* Microservices implementation with [Spring Boot](https://spring.io/projects/spring-boot) and [Netflix OSS](https://netflix.github.io/)
* Log centralization with [ELK Stack](https://www.elastic.co/elk-stack)
* Architecture running inside [Docker](https://www.docker.com/) with [Docker Compose](https://docs.docker.com/compose/)

###### Architecture Scheme

![architecture](docs/architecture.jpg 'Architecture Scheme')

---

## Spring Boot Generic Service

Create a new microservice with Spring Boot

###### Website

[Spring Boot Start](https://start.spring.io)

###### CLI

[Spring Boot CLI](https://docs.spring.io/spring-boot/docs/current/reference/html/cli.html)

#### Service Dependencies

All microservices have at least following dependencies

| Dependency       | Feature                           |
| ---------------- | --------------------------------- |
| Eureka Discovery | Service discovery                 |
| Actuator         | Monitor and Manage the service    |
| Web              | FullStack devolpment MVC          |
| DevTools         | Development Tools with hot reload |

#### Service Development

```bash
cd <microservice_folder>
./mvnw spring-boot:run
```

---

## Microservices Architecture

* Infrastructure
    * [Eureka Service](infrastructure/eureka-service/README.md)
    * [Edge Service](infrastructure/edge-service/README.md)
    * [Auth Service](infrastructure/auth-service/README.md)
* Microservices
    * [Hash Service](microservices/hash-service/README.md)

## API Usage Examples

PostMan Collection can be found [here](docs/postman-collection.json).

---

## Docker Compose

Run inside docker with compose.

For compose commands refer to the [official documentation](https://docs.docker.com/compose/)

Examples:

```bash
# Run database and eureka (dev mode)
docker-compose up -d mysql eureka

# Run full architecture
docker-compose up -d

# Shutdown and destroy storages
docker-compose down -v
```

---

## References

* https://developer.okta.com/blog/2017/06/15/build-microservices-architecture-spring-boot
* http://callistaenterprise.se/blogg/teknik/2015/05/20/blog-series-building-microservices/
* https://stormpath.com/blog/microservices-jwt-spring-boot
* https://piotrminkowski.wordpress.com/2017/02/22/microservices-security-with-oauth2/
* https://piotrminkowski.wordpress.com/2017/12/01/part-2-microservices-security-with-oauth2/
* https://github.com/TechPrimers/spring-security-oauth-mysql-example/tree/master/spring-security-auth-server
* https://developer.okta.com/blog/2018/02/13/secure-spring-microservices-with-oauth
* http://www.baeldung.com/rest-api-spring-oauth2-angularjs
* https://gigsterous.github.io/engineering/2017/03/01/spring-boot-4.html