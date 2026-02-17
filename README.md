# Transactions Handler

A Spring Boot REST API for managing accounts and financial transactions. Built with an H2 in-memory database — no external database setup required.

## Prerequisites

- Java 8+
- Maven

## How to Run

```bash
mvn spring-boot:run
```

The application starts on `http://localhost:8080`.

## Run with Docker

```bash
mvn clean package -DskipTests
docker-compose up --build
```

Or without Compose:

```bash
mvn clean package -DskipTests
docker build -t transactions-handler .
docker run -p 8080:8080 transactions-handler
```

## API Documentation (Swagger)

Once the app is running, open:

- **Swagger UI**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- **OpenAPI JSON**: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

## H2 Console

Available at [http://localhost:8080/h2-console](http://localhost:8080/h2-console) with JDBC URL `jdbc:h2:mem:pismodb`, user `sa`, and no password.
