[Documentation](../../README.md#documentation)

# Docker Compose

Run docker containers with compose.

[Official Documentation](https://docs.docker.com/compose/)

#### Build All Images

```bash
docker-compose build
```

#### Default Architecture

```bash
# Start
docker-compose up -d

# Stop
docker-compose down
```

#### Development Configuration

```bash
# Start
docker-compose -f docker-compose.yml -f docker-compose.dev.yml up -d

# Stop
docker-compose -f docker-compose.yml -f docker-compose.dev.yml down
```

#### Persistent Storage

```bash
# Start
docker-compose -f docker-compose.yml -f docker-compose.storage.yml up -d

# Stop
docker-compose -f docker-compose.yml -f docker-compose.storage.yml down

# Stop and Clean
docker-compose -f docker-compose.yml -f docker-compose.storage.yml down -v
```

## Environment Variables

...

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

## Data Persistence

...