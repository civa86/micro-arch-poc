[Home](../../README.md)

# API Usage

Full documentation of available REST API and PostMan Collection file.

In this API documentation, microservices are not authenticated and supposed to run in development mode.

**Assumptions**:

* Every `Microservice` is public, no need of `User Authentication`
* `Microservice` port is exposed on the machine `localhost`

When Microservices run behind **Edge Service** and inside the **docker-compose** environment, they have full protection and private networking communication.

## Contents

* Infrastructure
    * [Auth Service](./Auth.md)
* Microservices
    * [Hash Service](./Hash.md)
    * [Photo Service](./Photo.md)

## Postman Collection

Download [Postman](https://www.getpostman.com/) and import the [collection](../postman-collection.json)