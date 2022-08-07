# Dokumenation Social Media

## API
### URL-Aufbau

http://localhost:8080/api/oosers/{ooserId}/posts/{postId}/comments/{commentId}

### Bestandteile
#### Ooser

##### Alle User beziehen

`GET`

http://localhost:8080/api/oosers

##### Einzelne User beziehen
`GET`

http://localhost:8080/api/oosers/{ooserId}

##### Nutzer anlegen

`POST`

http://localhost:8080/api/oosers

`{"fullName": "Name","ooserName": "UserName"}`

##### Nutzer bearbeiten

`PUT`

http://localhost:8080/api/oosers/{ooserId}

`{"fullName": "(NewName)","ooserName": "(NewUserName)"}`

Nur möglich wenn die `OID` unter Header mit der im Nutzerobjekt übereinstimmt.
Dies soll vor unbefugtem Zugriff schützen.

##### Nutzer löschen

`DEL`

http://localhost:8080/api/oosers/{ooserId}

Nur möglich wenn die `OID` unter Header mit der im Nutzerobjekt übereinstimmt.


#### Posts

##### Alle Posts beziehen

`GET`

http://localhost:8080/api/posts

##### Alle Posts eines Nutzers beziehen

`GET`

http://localhost:8080/api/oosers/{ooserId}/posts

##### Einelne Posts beziehen

`GET`

http://localhost:8080/api/oosers/{ooserId}/posts/{postId}

##### Post anlegen

`POST`

`{
    "title":"PostTitel",
    "text":"PostText",
    "likes":0
}`

http://localhost:8080/api/oosers/{ooserId}/posts

##### Post bearbeiten

`PUT`

http://localhost:8080/api/oosers/{ooserId}/posts/{postId}

`{
    "title":"NewPostTitle",
    "text":"NewPostText",
    "likes":123
}`

Nur möglich wenn die `OID` unter Header mit der im Postobjekt übereinstimmt.

##### Post löschen

`DELETE`

http://localhost:8080/api/oosers/{ooserId}/posts/{postId}

Nur möglich wenn die `OID` unter Header mit der im Postobjekt übereinstimmt.

#### Comments

##### Alle Kommentare beziehen

`GET`

http://localhost:8080/api/comments

##### Alle Kommentare eine Users beziehen

`GET`

http://localhost:8080/api/oosers/{ooserId}/comments

##### Alle Kommentare eines Posts beziehen

`GET`

http://localhost:8080/api/oosers/{ooserId}/posts/{postId}/comments

##### Einzelnen Kommentar eines bestimmten Posts beziehen

`GET`

http://localhost:8080/api/oosers/{ooserId}/posts/{postId}/comments/{commentId}

##### Kommentar anlegen

`POST`

http://localhost:8080/api/oosers/{ooserId}/posts/{postId}/comments

`{
    "text":"CommentText",
    "likes":0
}`

##### Kommentar bearbeiten

`PUT`

http://localhost:8080/api/oosers/{ooserId}/posts/{postId}/comments/{commentId}

`{
    "text":"NewCommentText",
    "likes":123
}`

Nur möglich wenn die `OID` unter Header mit der im Kommentarobjekt übereinstimmt.

##### Kommentar löschen

`DELETE`

http://localhost:8080/api/oosers/{ooserId}/posts/{postId}/comments/{commentId}

Nur möglich wenn die `OID` unter Header mit der im Kommentarobjekt übereinstimmt.
