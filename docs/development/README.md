[Home](../../README.md)

# Development

--> Run third part services and discover server inside docker, with a development configuration and start microservices independently.

## Docker

Development of any microservice may need some ancillary services running aside.

Use `docker-compose` to start containers depending on development needs, for example:

* Microservice with database persistence
* Avoid discovery clients exception because they don't find the server
* Logs transmission and analysis

### Database

Exposed port: `13306`.

No Data Persistence.

```bash
docker-compose -f docker-compose.yml -f docker-compose.dev.yml up -d mysql
```

### Eureka

Exposed port: `8761`.

Web Interface URL: [`http://localhost:8761`](http://localhost:8761).

```bash
docker-compose -f docker-compose.yml -f docker-compose.dev.yml up -d eureka
```

### ELK stack

Exposed port (logstash): `5000`.

Web Interface URL (kibana): [`http://localhost:5601`](http://localhost:5601).

```bash
docker-compose -f docker-compose.yml -f docker-compose.dev.yml elasticsearch logstash kibana
```

### Stop All containers

Stop all running containers and remove created volumes in order to clean for the next run.

```bash
docker-compose -f docker-compose.yml -f docker-compose.dev.yml down -v
```

---

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

Microservice will run in `http://localhost:8080` by default but service port can be changed inside configuration properties.

#### Configuration Properties

All microservices configurations are saved inside `classpath:application.yml`

```bash
.
├── Dockerfile
├── mvnw
├── mvnw.cmd
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   └── resources
    │       └── application.yml
    └── test
```

Configuration can be externalized and can be different base on the running profile.

Read official [documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html)

#### References and Tutorials

* https://developer.okta.com/blog/2017/06/15/build-microservices-architecture-spring-boot
* http://callistaenterprise.se/blogg/teknik/2015/05/20/blog-series-building-microservices/
* https://stormpath.com/blog/microservices-jwt-spring-boot
* https://piotrminkowski.wordpress.com/2017/02/22/microservices-security-with-oauth2/
* https://piotrminkowski.wordpress.com/2017/12/01/part-2-microservices-security-with-oauth2/
* https://github.com/TechPrimers/spring-security-oauth-mysql-example/tree/master/spring-security-auth-server
* https://developer.okta.com/blog/2018/02/13/secure-spring-microservices-with-oauth
* http://www.baeldung.com/rest-api-spring-oauth2-angularjs
* https://gigsterous.github.io/engineering/2017/03/01/spring-boot-4.html