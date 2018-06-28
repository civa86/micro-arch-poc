# [P.O.C.] Microservices Architecture

Proof of Concept of a Microservices Architecture.

* Microservices implementation with [Spring Boot](https://spring.io/projects/spring-boot) and [Netflix OSS](https://netflix.github.io/)
* Log centralization with [ELK Stack](https://www.elastic.co/elk-stack)
* Architecture running inside [Docker](https://www.docker.com/) with [Docker Compose](https://docs.docker.com/compose/)

## Requirements

**Docker Environment**
* Dedicated RAM 4GB+
* Client 17.12+
* Server Engine 17.12+

**Spring Boot Development**
* Java 1.8+

---

![architecture](docs/architecture.jpg 'Architecture Scheme')

---

## Documentation

Learn how to run the architecture inside docker containers, call API, configure services and develop single parts independently.

* Architecture Components
    * [Database](docs/components/Database.md)
    * [(Eureka) Discovery Service](docs/components/Eureka.md)
    * [(Zuul) Edge Service](docs/components/Zuul.md)
    * [Authentication Service](docs/components/Auth.md)
    * [Generic Spring Boot Microservice](docs/components/SpringBootMS.md)
* ELK Stack
    * [Elastic Search](docs/components/ELK.md#elastic-search)
    * [Logstash](docs/components/ELK.md#logstash)
    * [Kibana](docs/components/ELK.md#kibana)

* [Development](docs/development/README.md)
* [Docker Compose](docs/docker-compose/README.md)
* [API Usage](docs/api/README.md)

## License

MIT.