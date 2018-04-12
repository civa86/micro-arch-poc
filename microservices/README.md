# JVM Microservices Architecture

## Spring Package Creator

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

#### References

* https://developer.okta.com/blog/2017/06/15/build-microservices-architecture-spring-boot
* https://developer.okta.com/blog/2018/02/13/secure-spring-microservices-with-oauth
* http://callistaenterprise.se/blogg/teknik/2015/04/10/building-microservices-with-spring-cloud-and-netflix-oss-part-1/