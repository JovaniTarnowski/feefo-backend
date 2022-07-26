# Feefo Software Engineering Technical Assessmen

Given the input, the code returns a normalize version of the Job Title

## Installation

#### Backend Requirements:

- Java 11
- Maven
- Liquibase
- H2 DB
- Docker Compose

Start the application using the command bellow:
 ```
mvn spring-boot:run
```
or run
 ```
docker-compose up
```
The application uses H2 DB. More information in the aplication.properties file.

#### Example of request: 
```
curl --location --request GET 'http://localhost:8080/v1/job/get-normalized-job-title?jobTitle=Accountant'
```