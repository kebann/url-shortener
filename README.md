## Usage

- Build a docker image for the URL shortener service `mvn spring-boot:build-image`
- Start docker containers with Redis and the URL shortener by running `docker-compose up`
- Make a request to shorten a URL
```curl 
curl -v --location --request POST 'http://localhost:8080/v1/short-url' \
--header 'Content-Type: application/json' \
--data-raw '{
    "title": "Object Mapping & Redis Repositories",
    "url": "https://developer.redis.com/develop/java/redis-and-spring-course/lesson_3/"
}' 
```
- Copy a short URL from a response `Location` header and use it to access the original URL