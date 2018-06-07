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

### Auth Service

POST /oauth/token HTTP/1.1
Host: localhost:9000
Content-Type: application/x-www-form-urlencoded
Authorization: Basic Q2xpZW50SWQ6c2VjcmV0
Body: username=Sam&password=sam&grant_type=password

### TODO

AUTH-SERVICE

* move token store to db
* move clientId-secret to db
* manage refresh token
* password encoder
* detailed documentation

### References

NETFLIX ARCH

* https://developer.okta.com/blog/2017/06/15/build-microservices-architecture-spring-boot
* http://callistaenterprise.se/blogg/teknik/2015/05/20/blog-series-building-microservices/
* https://stormpath.com/blog/microservices-jwt-spring-boot

OAUTH

* PART1: https://piotrminkowski.wordpress.com/2017/02/22/microservices-security-with-oauth2/
 PART2: https://piotrminkowski.wordpress.com/2017/12/01/part-2-microservices-security-with-oauth2/

* https://github.com/TechPrimers/spring-security-oauth-mysql-example/tree/master/spring-security-auth-server

* https://developer.okta.com/blog/2018/02/13/secure-spring-microservices-with-oauth
* http://www.baeldung.com/rest-api-spring-oauth2-angularjs
* https://gigsterous.github.io/engineering/2017/03/01/spring-boot-4.html