# Short-URL

Short-URL is a URL shortener api made using Gradle, Spring Boot, MySQL and Docker.

## Installation

Use gradle to build the jar file.

```
gradle clean
gradle build
```
Build docker container
```bash
docker-compose up to run application
```

## Usage
Using postman post URL you want to shorten in json format to http://localhost:8080/shorturl
```
{
    "longUrl": "https://www.google.com"
}
```
This should return the following
```
{
    "shortURL": "http://localhost:8080/a"
}
```
The URL can be pasted straight into the browser and will redirect to the original URL

You can return some data on your link by making a get request to http://localhost:8080/analytics/{id}
where id is the string appended on the end of your short URL.

Using http://localhost:8080/analytics/a returns the following in this example:
```
{"id":1,"longUrl":"https://www.google.com","clicks":2,"createTime":"2021-02-09T19:41:51.835953","lastVisited":"2021-02-09T19:50:59.76033"}
```


