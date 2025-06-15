# java-spring-boot-practice

java-spring-boot-practice is responsible for having all the handling for the java spring boot.

## Build

## SonarQube

## Environment

| Env     | Endpoint              | Health Check                          |
|---------|-----------------------|---------------------------------------|
| default | http://localhost:8080 | http://localhost:8080/actuator/health |
| dev     | http://localhost:8081 | http://localhost:8081/actuator/health |

## Headers

| Key                  | Value                     | Description                                 |
|----------------------|---------------------------|---------------------------------------------|
| request_tracking_id  | uniqueIdentifier          | Unique e2e tracking Id for each transaction |
| CONSUMER_ID          |                           |                                             |
| SVC_NAME             | JAVA-SPRING-BOOT-PRACTICE |                                             |
| SVC_ENV              |                           |                                             |
| AUTH_SIGNATURE       |                           |                                             |
| CONSUMER_INTIMESTAMP |                           |                                             |

## Running Locally

```
-Dspring.profiles.active=dev
```