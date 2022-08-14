# Sea Of Thieves API

![Sea Of Thieves](https://www.arenaxbox.com.br/wp-content/uploads/2022/06/sea-of-thieves-7-temporada.jpg)

There's a really cool game that I usually play with my friends, "Sea of Thieves", in this game we have a map with several islands scattered around, but when we need to find a specific island we spend some time looking for it, which can end up taking a while. So I had the idea to solve our problem, after all, programming exists to help us, right?

I developed an API with Spring Boot to fulfill this function! There we can map all the game islands, associating their names with their coordinates, perfect isn't it?! The deployment of the application and the PostgreSQL database was done entirely on Heroku so that any of my friends can also use it.

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

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)
