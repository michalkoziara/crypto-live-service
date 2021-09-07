# CryptoLive
### RESTful web service for tracking cryptocurrency prices

The goal of this project is to implement RESTful API web service that will be responsible for
managing and storing user's data in database and redirecting data related to cryptocurrencies from external sources.

This repository contains only source code related to the web service. 
Additional web application created with React.js that serves as a user interface 
can be found in the [michalkoziara/crypto-live-web](https://github.com/michalkoziara/crypto-live-web) repository.

## Getting Started

These instructions will get you a copy of the project up and running on 
your local machine for development and testing purposes.

### Prerequisites

* Java [11 or above] - https://www.oracle.com/java/
* MongoDB [4.4.3 or above] - https://www.mongodb.com/
* Apache Tomcat [9.0.8 or above] - https://tomcat.apache.org/
* CryptoCompare API key - https://www.cryptocompare.com/

Detailed information about installation and configurations are provided at developers' site.

## Technology Stack

* Spring Boot [2.4.2]
* Spring Security
* JSON Web Token
* MongoDB
* Retrofit2
* Maven
* Java 11

### Build 

A step by step instruction [on Windows 10]:
* Setup MongoDB database and user.
* Get API key from CryptoCompare.
* Set your secret constants inside `SecretConstants` file that is located in project directory.
    ```
    \crypto-live-service\src\main\java\com\kozmapps\SecretConstants.java
    ```
* Navigate project directory in Windows command prompt (cmd).
* Use Maven to build project.
  ```
  mvn install
  ```
* Copy service file from project directory.
    ```
    \crypto-live-service\target\crypto-live-RELEASE.war
    ```
* Navigate the main directory of previously installed Apache Tomcat and paste this file into `webapps` directory 
(example:``C:\apache-tomcat-9.0.8\webapps\``).
* Navigate `bin` folder in Apache Tomcat main directory (example:``C:\apache-tomcat-9.0.8\bin``).
* Run `` startup.bat `` file.
* Apache Tomcat should start a web service, you can check that by visiting http://localhost:8080/ in your browser.
 

## Example Usage
### Read cryptocurrencies
Request
`http://localhost:8080/coins`
```
GET /coins
Host: localhost:8080
Authorization: Bearer {JSON Web Token}
```
Response
`Status: 200 OK`
```
[
    {
        "id": "{id}",
        "symbol": "{symbol}"
    }
]
```

### Read minute cryptocurrencies' prices
Request
`http://localhost:8080/prices/minute?coinFromSymbol={coinFromSymbol}&coinToSymbol={coinToSymbol}&limit={limit}`
```
GET /prices/minute?coinFromSymbol={coinFromSymbol}&coinToSymbol={coinToSymbol}&limit={limit}
Host: localhost:8080
Authorization: Bearer {JSON Web Token}
```
Response
`Status: 200 OK`
```
[
    {
        "time": {time},
        "high": {high},
        "low": {low},
        "open": {open},
        "volumeFrom": {volumeFrom},
        "volumeTo": {volumeTo},
        "close": {close},
        "conversionType": "{conversionType}",
        "conversionSymbol": "{conversionSymbol}"
    }
]
```

### Read hourly cryptocurrencies' prices
Request
`http://localhost:8080/prices/hourly?coinFromSymbol={coinFromSymbol}&coinToSymbol={coinToSymbol}&limit={limit}`
```
GET /hourly/minute?coinFromSymbol={coinFromSymbol}&coinToSymbol={coinToSymbol}&limit={limit}
Host: localhost:8080
Authorization: Bearer {JSON Web Token}
```
Response
`Status: 200 OK`
```
[
    {
        "time": {time},
        "high": {high},
        "low": {low},
        "open": {open},
        "volumeFrom": {volumeFrom},
        "volumeTo": {volumeTo},
        "close": {close},
        "conversionType": "{conversionType}",
        "conversionSymbol": "{conversionSymbol}"
    }
]
```

### Read daily cryptocurrencies' prices
Request
`http://localhost:8080/prices/daily?coinFromSymbol={coinFromSymbol}&coinToSymbol={coinToSymbol}&limit={limit}`
```
GET /hourly/daily?coinFromSymbol={coinFromSymbol}&coinToSymbol={coinToSymbol}&limit={limit}
Host: localhost:8080
Authorization: Bearer {JSON Web Token}
```
Response
`Status: 200 OK`
```
[
    {
        "time": {time},
        "high": {high},
        "low": {low},
        "open": {open},
        "volumeFrom": {volumeFrom},
        "volumeTo": {volumeTo},
        "close": {close},
        "conversionType": "{conversionType}",
        "conversionSymbol": "{conversionSymbol}"
    }
]
```

### Read favorites
Request
`http://localhost:8080/favorites`
```
GET /favorites
Host: localhost:8080
Authorization: Bearer {JSON Web Token}
```
Response
`Status: 200 OK`
```
[
    {
        "coinFromSymbol": "{coinFromSymbol}",
        "coinToSymbol": "{coinToSymbol}",
        "description": "{description}"
    }
]
```

### Create favorite
Request
`http://localhost:8080/favorites`
```
POST /favorites
Host: localhost:8080
Content-Type: application/json
{
    "coinFromSymbol": "{coinFromSymbol}",
    "coinToSymbol": "{coinToSymbol}",
    "description": "{description}"
}
```
Response `Status: 200 OK`

### Update favorite
Request
`http://localhost:8080/favorites`
```
PUT /favorites
Host: localhost:8080
Content-Type: application/json
{
    "coinFromSymbol": "{coinFromSymbol}",
    "coinToSymbol": "{coinToSymbol}",
    "description": "{description}"
}
```
Response `Status: 200 OK`

### Delete favorite
Request
`http://localhost:8080/favorites`
```
DELETE /favorites
Host: localhost:8080
Content-Type: application/json
{
    "coinFromSymbol": "{coinFromSymbol}",
    "coinToSymbol": "{coinToSymbol}",
    "description": "{description}"
}
```
Response `Status: 200 OK`

### Register user
Request
`http://localhost:8080/public/users/register`
```
POST /public/users/register/
Host: localhost:8080
Content-Type: application/x-www-form-urlencoded
username={username}&password={password}
```
Response `Status: 200 OK`
```
{JSON Web Token}
```

### Sign in user
Request
`http://localhost:8080/public/users/login`
```
POST /public/users/login/
Host: localhost:8080
Content-Type: application/x-www-form-urlencoded
username={username}&password={password}
```
Response `Status: 200 OK`
```
{JSON Web Token}
```

### Read user's profile
Request
`http://localhost:8080/users/profile`
```
GET /users/profile/
Host: localhost:8080
Authorization: Bearer {JSON Web Token}
```
Response `Status: 200 OK`
```
{
    "username": "{username}"
}
```

### Log out user
Request
`http://localhost:8080/users/logout`
```
GET /users/logout/
Host: localhost:8080
Authorization: Bearer {JSON Web Token}
```
Response `Status: 200 OK`

## Author

* **Michał Koziara** 
