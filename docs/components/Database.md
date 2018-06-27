[Home](../../README.md)

# Database

MySql Database instance runs in a docker container.

No instances are required to be manually installed in the host machine.

[Official MySql Image](https://hub.docker.com/_/mysql/)

#### Credentials

Password for root user is set by the ENV Variable `MYSQL_ROOT_PASSWORD` defined in the `docker-compose.yml` file.

```
username: root
password: root
```

## Migrations

If a Microservice has database persistence, [FlyWay](https://flywaydb.org/) is used to migrate database structure and data.

###### Migration Path

Default path for flyway migrations

```
classpath:db/migration
```

**Auth Service** has two separate folders to create `schema` and `data`

```
classpath:db/migration/schema
classpath:db/migration/data
```

The folder `schema` contains table structures and insertion of roles that are available in this P.O.C.

The folder `data` contains some insert statements to start a development environment with 2 kind of users already created: 1 User and 1 Administrator.

## FlyWay Configuration

FlyWay is configured inside spring application properties.

#### Properties List

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