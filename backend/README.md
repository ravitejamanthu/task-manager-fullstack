# Task Manager Backend

A Spring Boot REST API for managing personal tasks with user authentication.

## Features

- **User Authentication**: JWT-based authentication with registration and login
- **Task Management**: CRUD operations for tasks (Create, Read, Update, Delete)
- **Security**: Spring Security with JWT tokens
- **Database**: H2 in-memory database (perfect for demos and development)
- **RESTful API**: Clean REST endpoints following best practices

## Tech Stack

- **Java 17**
- **Spring Boot 3.2.0**
- **Spring Security**
- **Spring Data JPA**
- **H2 Database**
- **JWT (JSON Web Tokens)**
- **Maven**

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

## Setup Instructions

1. **Clone/Download the project**
2. **Navigate to the backend directory**
   ```bash
   cd backend
   ```
3. **Build the project**
   ```bash
   mvn clean install
   ```
4. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

The application will start on `http://localhost:8080`

## API Endpoints

### Authentication

#### Register User
```
POST /api/auth/register
Content-Type: application/json

{
  "username": "john_doe",
  "email": "john@example.com",
  "password": "password123"
}
```

#### Login
```
POST /api/auth/login
Content-Type: application/json

{
  "username": "john_doe",
  "password": "password123"
}
```

### Tasks (Requires Authentication)

#### Get All Tasks
```
GET /api/tasks
Authorization: Bearer <jwt_token>
```

#### Create Task
```
POST /api/tasks
Authorization: Bearer <jwt_token>
Content-Type: application/json

{
  "title": "Complete project",
  "description": "Finish the task manager project"
}
```

#### Update Task
```
PUT /api/tasks/{taskId}
Authorization: Bearer <jwt_token>
Content-Type: application/json

{
  "title": "Updated task title",
  "description": "Updated description"
}
```

#### Toggle Task Completion
```
PATCH /api/tasks/{taskId}/toggle
Authorization: Bearer <jwt_token>
```

#### Delete Task
```
DELETE /api/tasks/{taskId}
Authorization: Bearer <jwt_token>
```

## Database

- **H2 Console**: Access at `http://localhost:8080/h2-console`
- **JDBC URL**: `jdbc:h2:mem:taskdb`
- **Username**: `sa`
- **Password**: `password`

## Project Structure

```
src/main/java/com/example/taskmanager/
├── TaskManagerApplication.java
├── config/
│   └── SecurityConfig.java
├── controller/
│   ├── AuthController.java
│   └── TaskController.java
├── dto/
│   ├── LoginRequest.java
│   ├── RegisterRequest.java
│   ├── TaskRequest.java
│   └── TaskResponse.java
├── model/
│   ├── Task.java
│   └── User.java
├── repository/
│   ├── TaskRepository.java
│   └── UserRepository.java
├── security/
│   ├── CustomUserDetailsService.java
│   ├── JwtAuthenticationFilter.java
│   └── JwtUtils.java
└── service/
    ├── TaskService.java
    └── UserService.java
```

## Testing the API

You can test the API using:
- **Postman**
- **cURL**
- **H2 Console** for database inspection

### Example cURL commands:

1. **Register a user:**
```bash
curl -X POST http://localhost:8080/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{"username":"testuser","email":"test@example.com","password":"password123"}'
```

2. **Login:**
```bash
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"testuser","password":"password123"}'
```

3. **Create a task (replace <token> with the JWT token from login):**
```bash
curl -X POST http://localhost:8080/api/tasks \
  -H "Authorization: Bearer <token>" \
  -H "Content-Type: application/json" \
  -d '{"title":"My first task","description":"This is a test task"}'
```

## Security Features

- **JWT Authentication**: Stateless authentication using JSON Web Tokens
- **Password Encryption**: BCrypt password hashing
- **CORS Configuration**: Cross-origin resource sharing enabled
- **Input Validation**: Bean validation for all inputs
- **User Isolation**: Users can only access their own tasks

## Deployment

This application can be easily deployed to:
- **Heroku**
- **AWS**
- **Google Cloud Platform**
- **Docker containers**

For production deployment, consider:
- Using a persistent database (PostgreSQL, MySQL)
- Configuring proper CORS settings
- Setting up HTTPS
- Using environment variables for sensitive data
