
# Simple E-Commerce API

The E-commerce API is a self-project that aims to create Create, Read, Update, and Delete (CRUD) data and aims to connect to the database. This project uses Spring Boot as framework, MongoDB as database. This project uses the Dependency Injection design pattern and implements the pagination technique.

## Tools & Technology
- Java Version 8
- Maven Apache
- Spring Boot 3.0.2
- MongoDB Compass
- Postman

## Dependencies
This project is based on the Spring Boot project and uses these dependecies :
- Spring Boot Reactive Web
- Lombok 1.18.22
- Spring Boot MongoDB

## Installation
The project is created with Maven, so you just need to import it to your IDE and build the project to resolve the dependencies

## Database Configuration
Create a MongoDB database with the name ecommerce and add the credentials to /resources/application.properties.
The default ones are :
```
spring.data.mongodb.database=ecommerce
spring.data.mongodb.port=27017
spring.data.mongodb.host=localhost
```
Download the example document of Simple E-commerce API in [here](https://github.com/bashirhanafi/simple-ecommerce-api/blob/main/product.json)



## Usage
Run the project through the IDE and head out to http://localhost:8080
or run this command in the command line:
```
mvn spring-boot:run
```

## API Reference

__1. Add a product__

```POST /product/add```

Request Body :
```
{
    "name" : String,
    "price" : double,
    "stock" : int,
    "weight" : double,
    "description" : String
}
```
__2. Get all products__

```GET /product/all```

__3. Get all products by page & size__

```GET /product/all?page={page}&size={size}```
| Parameters                     | Attributes | Description                            |
|-------------------------------|------------|----------------------------------------|
| page : int, defaultValue = 0  | -          | It's used for set the page number      |
| size : int, defaultValue = 10 | -          | It's used for set the size of the page |

__4. Get all products sort by__

```GET /product/all?sort={sort}```
| Parameters                             | Attributes                                                             | Description                                  |
|---------------------------------------|------------------------------------------------------------------------|----------------------------------------------|
| sort : String, defaultValue = "price" | id, createdAt, name, price,  stock, weight, description,  isStockReady | It's used for determines which field to sort |

__5. Get all products ascending or descending__

```GET /product/all?sort={sort}&sortby={sortby}```
| Parameters                             | Attributes                                                             | Description                                       |
|---------------------------------------|------------------------------------------------------------------------|---------------------------------------------------|
| sort : String, defaultValue = "price" | id, createdAt, name, price,  stock, weight, description,  isStockReady | It's used for determines which field to sort      |
| sortby : String, defaultValue = "asc" | asc, dsc                                                               | It's used to select ascending or  descending sort |

__6. Get a product by id__

```GET /product/{id}```
| Parameters | Attributes | Description                   |
|------------|------------|-------------------------------|
| id : int         | -          | Uniquely id for each document |

__7. Update a product by id__

```UPDATE /product/update/{id}```
| Parameters | Attributes | Description                   |
|------------|------------|-------------------------------|
| id : int        | -          | Uniquely id for each document |

Request Body :
```
{
    "name" : String,
    "price" : double,
    "stock" : int,
    "weight" : double,
    "description" : String,
    "isStockReady" : Boolean
}
```

__8. Delete a product by id__

```DELETE /product/delete/{id}```
| Parameters | Attributes | Description                   |
|------------|------------|-------------------------------|
| id : int         | -          | Uniquely id for each document |


__9. Patch a product status__

```PATCH /product/update-status/{id}?isStockReady={isStockReady}```
| Parameters                                  | Attributes  | Description                               |
|---------------------------------------------|-------------|-------------------------------------------|
| id : int                                    | -           | Uniquely id for each document             |
| isStockReady : Boolean, defaultValue = null | true, false | It's used for status update on a document |


## Testing

To run tests, download file testing Postman API in [here](https://github.com/bashirhanafi/simple-ecommerce-api/blob/main/Ecommerce%20API%20Test.postman_collection.json)

## Resources
- [Tutorial Spring Boot dari Nol Untuk Pemula 2023](https://www.youtube.com/watch?v=o0Y4krQsFhg&t=2955s)
- [MongoDB Documentation](https://www.mongodb.com/docs/)


