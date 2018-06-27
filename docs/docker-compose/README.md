[Documentation](../../README.md#documentation)

# Docker Compose

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

## External Service Configuration

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

## Data Persistence

...