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

## Encode String

Api to encode a string with BCrypt algorithm.

**Authorization**

None

**Request**

GET /crypt?string=EXAMPLE-STRING

**Response**

```json
{
    "decoded": "EXAMPLE-STRING",
    "encoded": "$2a$10$L0C.5N3mHhVdpVyg3mY.muypCEjt54Sk3iL/ZVbzT8Qmxnu/AcXAO"
}
```

**Example CURL**

```bash
curl http://localhost:9000/crypt?string=EXAMPLE-STRING
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

Basic $CLIENT-ID:$CLIENT-SECRET

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
    "expires_in": 35999,
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

Bearer $ACCESS-TOKEN

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