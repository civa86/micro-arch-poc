[Home](../../README.md#documentation) | [API Usage](README.md)

# Photo Service REST API

MicroService to manage albums and pictures.

* Album API
    * [Album List](#album-list)
    * [Album Detail](#album-detail)
    * [Album Pictures](#album-pictures)
    * [Create Album](#create-album)
    * [Edit Album](#edit-album)
    * [Delete Album](#delete-album)
* Picture API
    * [Picture List](#picture-list)
    * [Picture Detail](#picture-detail)
    * [Picture Render](#picture-render)
    * [Create Picture](#create-picture)
    * [Edit Picture](#edit-picture)
    * [Delete Picture](#delete-picture)
---

## Album List

API to get the list of albums

**Request**

GET /albums

**Response**

```json
[
    {
        "id": 1,
        "name": "test album 1",
        "ceatedAt": "2018-06-26T12:22:32.000+0000"
    },
    {
        "id": 2,
        "name": "test album 2",
        "ceatedAt": "2018-06-26T12:22:36.000+0000"
    }
]
```

**Example CURL**

```bash
curl http://localhost:8082/albums
```

---

## Album Detail

API to get the album detail

**Request**

GET /album/:ALBUM_ID

**Response**

```json
{
    "id": 1,
    "name": "test album 1",
    "ceatedAt": "2018-06-26T12:22:32.000+0000"
}
```

**Example CURL**

```bash
curl http://localhost:8082/album/1
```

---

## Album Pictures

API to get the list of album pictures

**Request**

GET /album/:ALBUM_ID/pictures

**Response**

```json
[
    {
        "id": 1,
        "title": "Test Picture 1",
        "mimeType": "image/png",
        "albumId": 1,
        "ceatedAt": "2018-06-26T12:25:48.000+0000"
    },
    {
        "id": 2,
        "title": "Test Picture 2",
        "mimeType": "image/jpg",
        "albumId": 1,
        "ceatedAt": "2018-06-26T12:28:08.000+0000"
    }
]
```

**Example CURL**

```bash
curl http://localhost:8082/album/1/pictures
```

---

## Create Album

API to create a new album

**Request**

POST /album

Content-Type application/json

```json
{
	"name": "Test Album"
}
```

**Response**

```json
{
    "id": 1,
    "name": "Test Album",
    "ceatedAt": "2018-06-26T12:22:35.649+0000"
}
```

**Example CURL**

```bash
curl -X POST \
     -H "Content-Type: application/json" \
     -d '{"name": "Test Album"}' \
     http://localhost:8082/album
```

---

## Edit Album

API to update an existing album

**Request**

PUT /album/:ALBUM_ID

Content-Type application/json

```json
{
	"name": "Edited Album Name"
}
```

**Response**

```json
{
    "id": 1,
    "name": "Edited Album Name",
    "ceatedAt": "2018-06-26T12:22:35.649+0000"
}
```

**Example CURL**

```bash
curl -X PUT \
     -H "Content-Type: application/json" \
     -d '{"name": "Edited Album Name"}' \
     http://localhost:8082/album/1
```

---

## Delete Album

API to delete an existing album

**Request**

DELETE /album/:ALBUM_ID

**Response**

```json
{
    "id": 1,
    "name": "Test Album",
    "ceatedAt": "2018-06-26T12:22:35.649+0000"
}
```

**Example CURL**

```bash
curl -X DELETE http://localhost:8082/album/1
```

---

## Picture List

API to get the list of pictures

**Request**

GET /pictures

**Response**

```json
[
    {
        "id": 1,
        "title": "Test Picture 1",
        "mimeType": "image/png",
        "albumId": 1,
        "ceatedAt": "2018-06-26T12:25:48.000+0000"
    },
    {
        "id": 2,
        "title": "Test Picture 2",
        "mimeType": "image/jpg",
        "albumId": 1,
        "ceatedAt": "2018-06-26T12:28:08.000+0000"
    }
]
```

**Example CURL**

```bash
curl http://localhost:8082/pictures
```

---

## Picture Detail

API to get the picture detail

**Request**

GET /picture/:PICTURE_ID

**Response**

```json
{
    "id": 1,
    "title": "Test Picture",
    "mimeType": "image/png",
    "albumId": 1,
    "ceatedAt": "2018-06-26T12:25:48.000+0000"
}
```

**Example CURL**

```bash
curl http://localhost:8082/picture/1
```

---

## Picture Render

API to return the redered picture (image file)

**Request**

GET /picture/:PICTURE_ID/render

**Response**

![image-sample](./image-sample.png 'Image Sample')

**Example CURL**

```bash
curl http://localhost:8082/picture/1/render
```

---

## Create Picture

API to create a new picture

**Request**

POST /picture

Content-Type multipart/form-data

```
title=Test Picture
albumId=1
image=<RAW_IMAGE_FILE>
```

**Response**

```json
{
    "id": 1,
    "title": "Test Picture",
    "mimeType": "image/jpg",
    "albumId": 1,
    "ceatedAt": "2018-06-26T12:54:03.095+0000"
}
```

**Example CURL**

```bash
curl -X POST \
     -H "Content-Type: multipart/form-data" \
     -F "title=Test Picture" \
     -F "albumId=1" \
     -F "image=@/path/to/image/file.jpg" \
     http://localhost:8082/picture
```

---

## Edit Picture

API to update an existing picture

**Request**

PUT /picture/:PICTURE_ID

Content-Type application/json

```json
{
	"title": "Edited Picture Title"
}
```

**Response**

```json
{
    "id": 1,
    "title": "Edited Picture Title",
    "mimeType": "image/jpg",
    "albumId": 1,
    "ceatedAt": "2018-06-26T12:54:03.095+0000"
}
```

**Example CURL**

```bash
curl -X PUT \
     -H "Content-Type: application/json" \
     -d '{"title": "Edited Picture Title"}' \
     http://localhost:8082/picture/1
```

---

## Delete Picture

API to delete an existing picture

**Request**

DELETE /picture/:PICTURE_ID

**Response**

```json
{
    "id": 1,
    "title": "Test Picture",
    "mimeType": "image/jpg",
    "albumId": 1,
    "ceatedAt": "2018-06-26T12:54:03.095+0000"
}
```

**Example CURL**

```bash
curl -X DELETE http://localhost:8082/picture/1
```