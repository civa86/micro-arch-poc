[Home](../../README.md)

# Database

MySql Database instance run with docker.

Image used is the [official mysql image](https://hub.docker.com/_/mysql/)

```
username: root
password: root
```

## Development

By default mysql run without exposing port. It listens to the 3306 but only inside the docker private network.

In development process an exposed port is needed and there is a docker compose dev file to override the default values.

###### Start Service

```bash
docker-compose -f docker-compose.yml -f docker-compose.dev.yml up -d mysql
```

###### Stop Service

```bash
docker-compose -f docker-compose.yml -f docker-compose.dev.yml down -v
```

#### Exposed Port

In development mode mysql listens to port `13306`.

Port is not the default one in order to avoid collision with other mysql instances running in the system.

If you have some service that already use the `13306` port, change this configuration inside `docker-compose.dev.yml`

## Migrations

Inside Microservices [FlyWay](https://flywaydb.org/) is used to migrate database structure and data.

###### Migration Path

Default path for flyway migrations

```
classpath::/db/migration
```

**Auth Service** has two separate folders to create `schema` and `data`

```
classpath:/db/migration/schema
classpath::/db/migration/data
```

Data contains some users and roles to start a development environment without the need to run any query.

## FlyWay Configuration

#### Default

Every Microservice have its own `application.yml` file

```
classpath::/application.yml
```

###### Properties

```ini
spring.flyway.baseline-description= #
spring.flyway.baseline-on-migrate= #
spring.flyway.baseline-version=1 # Version to start migration
spring.flyway.check-location=true # Whether to check that migration scripts location exists.
spring.flyway.clean-disabled= #
spring.flyway.clean-on-validation-error= #
spring.flyway.dry-run-output= #
spring.flyway.enabled=true # Whether to enable flyway.
spring.flyway.encoding= #
spring.flyway.error-handlers= #
spring.flyway.group= #
spring.flyway.ignore-future-migrations= #
spring.flyway.ignore-missing-migrations= #
spring.flyway.init-sqls= # SQL statements to execute to initialize a connection immediately after obtaining it.
spring.flyway.installed-by= #
spring.flyway.locations=classpath:db/migration # The locations of migrations scripts.
spring.flyway.mixed= #
spring.flyway.out-of-order= #
spring.flyway.password= # JDBC password to use if you want Flyway to create its own DataSource.
spring.flyway.placeholder-prefix= #
spring.flyway.placeholder-replacement= #
spring.flyway.placeholder-suffix= #
spring.flyway.placeholders.*= #
spring.flyway.repeatable-sql-migration-prefix= #
spring.flyway.schemas= # schemas to update
spring.flyway.skip-default-callbacks= #
spring.flyway.skip-default-resolvers= #
spring.flyway.sql-migration-prefix=V #
spring.flyway.sql-migration-separator= #
spring.flyway.sql-migration-suffix=.sql #
spring.flyway.sql-migration-suffixes= #
spring.flyway.table= #
spring.flyway.target= #
spring.flyway.undo-sql-migration-prefix= #
spring.flyway.url= # JDBC url of the database to migrate. If not set, the primary configured data source is used.
spring.flyway.user= # Login user of the database to migrate.
spring.flyway.validate-on-migrate= #
```

#### Docker Override

Properties can be overriden when running inside docker compose.

A volume with override `application.yml` file is mounted for each service at the same level of the builded jar.