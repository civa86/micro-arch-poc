[Documentation](../../README.md#documentation)

# Authentication Service

Spring Security is used to manage OAuth2 tokens.

[Spring Security Documentation](https://spring.io/projects/spring-security)

[OAuth2 Documentation](https://oauth.net/2/)

## Grant Type

Enabled grant types are: `password` and `refresh_token`.

Read about [OAuth2 grant types](https://oauth.net/2/grant-types/) to change authentication behavior

## Client Credentials

Inside `application.yml` properties there are clientId and clientSecret.

These credentials, alongside a username and a password (placed into the database) are required to generate a valid token request.

```bash
curl -X POST \
     -u clientId:clientSecret \
     -F "username=user@test.com" \
     -F "password=password" \
     -F "grant_type=password" \
     http://localhost:9000/oauth/token
```

## Roles

Application starts with 2 pre-built roles:

| Id | Role  |
| -- | ----- |
| 1  | USER  |
| 2  | ADMiN |

## Development Accounts

There are 2 pre-built accounts created only when the service starts with maven in the local machine (Development)

These accounts let developers test login and different roles.

In the real life, accounts have to be created with the dedicated API.

| Username       | Password | Role        |
| -------------- | -------- | ----------- |
| admin@test.com | password | USER, ADMIN |
| user@test.com  | password | USER        |

