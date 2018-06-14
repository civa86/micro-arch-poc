# Hash Service

MicroService to hash strings.

## Generate UUID

Api to generate a uuid

**Authorization**

None

**Request**

GET /uuid

**Response**

```json
{
    "uuid": "9a0969e6-a1f2-497a-be23-939954f5e7de"
}
```

**Example CURL**

```bash
curl http://localhost:8081/uuid
```

## BCrypt String

Api to encode a string with BCrypt algorithm.

**Authorization**

None

**Request**

GET /bcrypt?string=EXAMPLE_STRING

**Response**

```json
{
    "decoded": "EXAMPLE_STRING",
    "encoded": "$2a$10$8.WexK.3rPN0tI.CqbQUae1tAMzYbQoAKjn9JSLzoM5gB7QwGcp6m"
}
```

**Example CURL**

```bash
curl http://localhost:8081/bcrypt?string=EXAMPLE_STRING
```