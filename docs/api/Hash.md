[Home](../../README.md#documentation) | [API Usage](README.md)

# Hash Service REST API

MicroService to hash strings.

* [Generate UUID](#generate-uuid)
* [BCrypt String](#bcrypt-string)

---

## Generate UUID

API to generate a uuid

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

---

## BCrypt String

API to encode a string with BCrypt algorithm.

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