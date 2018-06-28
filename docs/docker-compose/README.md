[Documentation](../../README.md#documentation)

# Docker Compose

Run docker containers with compose.

[Official Documentation](https://docs.docker.com/compose/)

## Build Docker Images

```bash
docker-compose build
```

## Default Architecture

```bash
# Start
docker-compose up -d

# Stop
docker-compose down
```

## Development Configuration

Apply `dev` overrides to expose ports of some services that otherwise are private.

Read more on [Development Chapter](../development/README.md#docker)

```bash
# Start
docker-compose -f docker-compose.yml -f docker-compose.dev.yml up -d

# Stop
docker-compose -f docker-compose.yml -f docker-compose.dev.yml down
```

## Data Persistence

Apply `storage` overrides to create persistent volumes and maintain data between services reboot.

```bash
# Start
docker-compose -f docker-compose.yml -f docker-compose.storage.yml up -d

# Stop
docker-compose -f docker-compose.yml -f docker-compose.storage.yml down

# Stop and Clean
docker-compose -f docker-compose.yml -f docker-compose.storage.yml down -v
```

## Environment Variables

Some containers are configured and tweaked with environment variables:

| Container     | Variable            | Value              | Description                   |
| ------------- | ------------------- | ------------------ | ----------------------------- |
| mysql         | MYSQL_ROOT_PASSWORD | root               | Password for the root user    |
| eureka        | JAVA_OPTIONS        | -Xmx256m -Xms256m  | JVM options                   |
| edge          | ELK_SERVICE_NAME    | EDGE               | Logstash application property |
| edge          | JAVA_OPTIONS        | -Xmx256m -Xms256m  | JVM options                   |
| auth          | ELK_SERVICE_NAME    | AUTH               | Logstash application property |
| auth          | JAVA_OPTIONS        | -Xmx256m -Xms256m  | JVM options                   |
| hash          | ELK_SERVICE_NAME    | HASH               | Logstash application property |
| hash          | JAVA_OPTIONS        | -Xmx256m -Xms256m  | JVM options                   |
| photo         | ELK_SERVICE_NAME    | PHOTO              | Logstash application property |
| photo         | JAVA_OPTIONS        | -Xmx256m -Xms256m  | JVM options                   |
| elasticsearch | ES_JAVA_OPTS        | -Xmx256m -Xms256m  | JVM options                   |
| logstash      | LS_JAVA_OPTS        | -Xmx256m -Xms256m  | JVM options                   |
| kibana        | -                   | -                  | -                             |

## Service Configuration

#### Logs configuration

...

#### Spring Boot Application Properties

Properties can be extended or overriden when services run inside `docker-compose`.

Mount a volume with an `application.yml` file placed at the same level of the service jar,

Spring Boot will automatically merge external file properties with internal ones.

###### Docker container working directory

```bash
.
├── application.yml
└── svc.jar
```

#### ELK configuration

...