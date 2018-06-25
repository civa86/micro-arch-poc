[Home](../../README.md)

# Development

...

## Docker: mysql + eureka

...

## Spring Boot Development

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

#### Run Dev Environment

```bash
cd <microservice_folder>
./mvnw spring-boot:run
```

###### Configuration

...

###### Networking

...

## References and Tutorials

* https://developer.okta.com/blog/2017/06/15/build-microservices-architecture-spring-boot
* http://callistaenterprise.se/blogg/teknik/2015/05/20/blog-series-building-microservices/
* https://stormpath.com/blog/microservices-jwt-spring-boot
* https://piotrminkowski.wordpress.com/2017/02/22/microservices-security-with-oauth2/
* https://piotrminkowski.wordpress.com/2017/12/01/part-2-microservices-security-with-oauth2/
* https://github.com/TechPrimers/spring-security-oauth-mysql-example/tree/master/spring-security-auth-server
* https://developer.okta.com/blog/2018/02/13/secure-spring-microservices-with-oauth
* http://www.baeldung.com/rest-api-spring-oauth2-angularjs
* https://gigsterous.github.io/engineering/2017/03/01/spring-boot-4.html