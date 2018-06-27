[Home](../../README.md#documentation)

# [Zuul] Edge Service

Gateway that provides dynamic routing, monitoring, resiliency, security, and more.

**Official Repository**

[`https://github.com/Netflix/zuul`](https://github.com/Netflix/zuul)

## Networking

Edge Service is the single entrypoint to access API.

It receives all requests, check on user authentication with a Remote Token Service and use the private internal network to communicate with other services.

**Endpoint**

[`http://localhost:8080`](http://localhost:8080)

| Route              | Target Service |
| ------------------ | -------------- |
| /uaa/**            | auth-service   |
| /hash-service/**   | hash-service   |
| /photo-service/**  | photo-service  |