# Auth Service

MicroService to manage Authentication with OAuth2, Users and Roles.

## Get Service Status

Api to discover the service status.

**Authorization**

None

**Request**

GET /actuator/health

**Response**

```json
{
    "status": "UP"
}
```

**Example CURL**

```bash
curl http://localhost:9000/actuator/health
```

## Register User

Api to register a new user

**Authorization**

None

**Request**

POST /user

Content-Type application/json

```json
{
	"email": "user@test.com",
	"password": "password",
	"firstName": "User",
	"lastName": "Test"
}
```

**Response**

```json
{
    "id": 1,
    "email": "user@test.com",
    "firstName": "User",
    "lastName": "Test",
    "active": 1,
    "roles": [
        {
            "roleId": 1,
            "role": "USER"
        }
    ],
    "ceatedAt": "2018-06-12T12:22:28.814+0000"
}
```

**Example CURL**

```bash
curl -X POST \
     -H "Content-Type: application/json" \
     -d '{"email": "user@test.com", "password": "password", "firstName": "User", "lastName": "Test"}' \
     http://localhost:9000/user
```

## Obtain Access Token

Api to obtain the access token (login)

**Authorization**

Basic $CLIENT_ID:$CLIENT_SECRET

**Request**

POST /oauth/token

Content-Type application/x-www-form-urlencoded

```
username=$USERNAME
password=$PASSWORD
grant_type=password
```

**Response**

```json
{
    "access_token": "4ead95e7-575e-4187-84b0-11b79bd27dfe",
    "token_type": "bearer",
    "refresh_token": "486d0aab-dab4-45b9-b6d9-63dd0be7306b",
    "expires_in": 1799,
    "scope": "read write"
}
```

**Example CURL**

```bash
curl -X POST \
     -u clientId:clientSecret \
     -F "username=user@test.com" \
     -F "password=password" \
     -F "grant_type=password" \
     http://localhost:9000/oauth/token
```

## User Profile Data

Api to get logged user profile data

**Authorization**

Bearer $ACCESS_TOKEN

**Request**

GET /user

**Response**

```json
{
    "id": 2,
    "email": "user@test.com",
    "firstName": "User",
    "lastName": "Test",
    "active": 1,
    "roles": [
        {
            "roleId": 1,
            "role": "USER"
        }
    ],
    "username": "user@test.com",
    "enabled": true,
    "authorities": [
        {
            "authority": "ROLE_USER"
        }
    ],
    "credentialsNonExpired": true,
    "accountNonLocked": true,
    "accountNonExpired": true,
    "ceatedAt": "2018-06-12T10:23:19.000+0000"
}
```

**Example CURL**

```bash
curl -H "Authorization: Bearer $ACCESS_TOKEN" http://localhost:9000/user
```

## Check Access Token

Api to check access token validity

**Authorization**

Basic $CLIENT_ID:$CLIENT_SECRET

**Request**

GET /oauth/check_token?token=$ACCESS_TOKEN

**Response**

```json
{
    "active": true,
    "exp": 1528846623,
    "user_name": "user@test.com",
    "authorities": [
        "ROLE_USER"
    ],
    "client_id": "clientId",
    "scope": [
        "read",
        "write"
    ]
}
```

**Example CURL**

```bash
curl -u "clientId:clientSecret" http://localhost:9000/oauth/check_token?token=$ACCESS_TOKEN
```

## Refresh Token

Api to regenerate both access and refresh token

**Authorization**

Basic $CLIENT_ID:$CLIENT_SECRET

**Request**

POST /oauth/token

Content-Type application/x-www-form-urlencoded

```
refresh_token=$REFRESH_TOKEN
grant_type=refresh_token
```

**Response**

```json
{
    "access_token": "7bb7d24d-72bc-48e1-9f77-c249887721ce",
    "token_type": "bearer",
    "refresh_token": "82e7dc4e-4595-44cd-bddc-82ecc2237bf4",
    "expires_in": 1799,
    "scope": "read write"
}
```

**Example CURL**

```bash
curl -X POST \
     -u clientId:clientSecret \
     -F "refresh_token=$REFRESH_TOKEN" \
     -F "grant_type=refresh_token" \
     http://localhost:9000/oauth/token
```