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

Containers are externally configured in different ways.

External configurations give the possibility to change settings without rebuilding the docker image.

#### Logs configuration

Inside the running architecture logs are managed by [Logback](https://logback.qos.ch/).

Logs are not saved to file but directly sent to the listening logstash instance with the right [appender](https://github.com/logstash/logstash-logback-encoder).

###### Configuration file

```
.
├── config
│   └── logback.xml
```

#### Spring Boot Application Properties

Properties can be extended or overriden when services run inside `docker-compose`.

In the `config` folder there is a file for every service that need overrides.

###### Configuration files

```
.
├── config
│   ├── auth.props.yml
│   ├── edge.props.yml
│   ├── hash.props.yml
│   └── photo.props.yml
```

For each service mount a volume with the configuration file placed at the same level of the service jar.

Remember to rename them in `application.yml` so Spring Boot will automatically merge external file properties with internal ones.

###### Docker container working directory

```
.
├── application.yml
└── svc.jar
```

#### ELK configuration

ELK containers have their configuration files mounted within docker volumes.

###### Configuration files

```
.
├── config
│   ├── elk
│   │   ├── elasticsearch.yml
│   │   ├── kibana.yml
│   │   ├── logstash.yml
│   │   └── pipeline
│   │       └── logstash.conf
```