# Sea Of Thieves API

API para consumo referente às ilhas do Sea of Thieves e suas respectivas coordenadas

## Auth
Para fazer o consumo da API é necessário realizar uma  autenticação "Basic Auth", com as seguintes credenciais:
```bash
Username: user
Password: 123456
```

## Entities

### Isle

```json
{
    "x_coordinate": "E",
    "y_coordinate": "17",
    "name": "Nome da Ilha",
    "description": "Descrição da Ilha",
    "id_neighborhood": 1 //Id da região da ilha
}
```

### Neighborhood

```json
{
    "name": "Nome da vizinhança",
    "description": "Descrição da vizinhança"
}
```

## Main Route

Através de protocolos HTTP, utilize a seguinte rota principal:

```bash
https://api-sot.herokuapp.com/isles/
```

## Isles Usage

### Get All Isles (GET)

```javascript
https://api-sot.herokuapp.com/isles/
```

### Get Isle By Id (GET)

```javascript
https://api-sot.herokuapp.com/isles/{id}
```

### Get Isle By Name (GET)

```javascript
https://api-sot.herokuapp.com/isles/findByName/{name}
```

### Post New Isle (POST)

```javascript
https://api-sot.herokuapp.com/isles/
```

### Delete Isle (DELETE)

```javascript
https://api-sot.herokuapp.com/isles/{id}
```

### Updade Isle (PUT)

```javascript
https://api-sot.herokuapp.com/isles/
```

## Neighborhoods Usage

### Get All Neighborhoods (GET)

```javascript
https://api-sot.herokuapp.com/neighborhoods/
```

### Get Isle By Id (GET)

```javascript
https://api-sot.herokuapp.com/neighborhoods/{id}
```

### Post New Isle (POST)

```javascript
https://api-sot.herokuapp.com/neighborhoods/
```

### Delete Isle (DELETE)

```javascript
https://api-sot.herokuapp.com/neighborhoods/{id}
```

### Updade Isle (PUT)

```javascript
https://api-sot.herokuapp.com/neighborhoods/
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)
