# Flight Search API and Mock Server with Docker Compose

This repository contains a Docker Compose configuration to run a Spring Boot-based Flight Search API alongside a Mock API Server. The Flight Search API provides flight information, and the Mock API Server simulates external dependencies or services that the main API relies on.

## Prerequisites

Before you begin, ensure you have the following requirements:

- Docker installed on your machine.

## Getting Started

1. Clone this repository to your local machine:

   ```bash

   git clone https://github.com/yourusername/your-repo-name.git

   ```

2. Navigate to the project directory:

   ```bash
   cd FlightExplorer
   ```

3. Build and run the services using Docker Compose:

   ```bash
   docker-compose up --build
   ```

   This will start the Flight Search API, the Mock API Server, a PostgreSQL database, and a Redis instance.

4. The PostgreSQL service will automatically execute the init_db.sql script during initialization. This script is responsible for creating the initial database schema and inserting sample data

5. Redis server is used for caching purposes in the application.

6. The Flight Search API will be available at http://localhost:8080. You can access its Swagger documentation at http://localhost:8080/swagger-ui.html.

7. The Mock API Server will be available at http://localhost:3000/flight for single flight and http://localhost:3000/flights/{flightCount} for multi flights. You can customize its behavior to simulate various scenarios.

8. The application periodically sends scheduled requests to the Mock API Server running at http://localhost:3000 to retrieve flight data and stores it in the database. The scheduling interval can be configured in the application.yaml file.

## Configuration

- The Flight Search API uses a PostgreSQL database for data storage. You can modify the database configuration in the application.properties file within the flight-search-api directory.

- **Scheduled Cron Period**: You can specify the scheduled cron period for sending requests to the Mock API Server. Edit the `application.yaml` file and set the `api.flight.fetch.cron` property. For example, to run the task every hour:

```yaml
api:
  flight:
    fetch:
      cron: 0 */3 * * * *
```

- **Number of Flights Per Mock Request**: Determine how many flight data entries should be retrieved from the Mock API Server in a single request. Modify the api.flight.fetch.count property in the application.yaml file

```yaml
api:
  flight:
    url: http://localhost:3000
    fetch:
      count: 20
```

- **Redis Cache Time-to-Live (TTL)**: You can configure the time-to-live (TTL) for the data stored in the Redis cache. Set the spring.data.redis.ttl property in the application.yaml file. The value is specified in minutes:

```yaml
spring:
  data:
    redis:
      ttl: 60 # Cache data will expire after 60 minutes
```

- The Mock API Server is located in the mock-flight-api directory. You can customize its routes and responses by editing the relevant JavaScript files.

## Usage

- Use the Flight Search API to perform flight searches and retrieve flight information.

- The Mock API Server can be adapted to simulate different behaviors and responses that your main API may depend on.

## Cleanup

To stop and remove the Docker containers, run:

```bash
docker-compose down
```