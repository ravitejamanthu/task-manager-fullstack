# Personal Task Manager - Full Stack Java Developer Project

A complete full-stack web application for managing personal tasks with user authentication. This project demonstrates modern web development practices using Java Spring Boot for the backend and React for the frontend.

## 🚀 Features

### Backend (Spring Boot)
- **RESTful API** with proper HTTP methods and status codes
- **JWT Authentication** for secure user sessions
- **Spring Security** with role-based access control
- **H2 Database** for data persistence (in-memory for development)
- **JPA/Hibernate** for object-relational mapping
- **Input Validation** with Bean Validation
- **CORS Configuration** for cross-origin requests
- **Comprehensive Error Handling**

### Frontend (React)
- **Modern React 18** with functional components and hooks
- **Responsive Design** that works on all devices
- **JWT Token Management** with automatic authentication
- **Real-time Updates** for immediate user feedback
- **Form Validation** with user-friendly error messages
- **Clean and Intuitive UI** with modern styling

### Core Functionality
- **User Registration & Login** with secure authentication
- **Task CRUD Operations** (Create, Read, Update, Delete)
- **Task Completion Toggle** with visual indicators
- **User-specific Task Management** (users can only see their own tasks)
- **Responsive Navigation** with authentication status

## 🛠️ Tech Stack

### Backend
- **Java 17**
- **Spring Boot 3.2.0**
- **Spring Security**
- **Spring Data JPA**
- **H2 Database**
- **JWT (JSON Web Tokens)**
- **Maven**

### Frontend
- **React 18.2.0**
- **React Router DOM 6.11.2**
- **Axios 1.4.0**
- **CSS3** with modern styling
- **JavaScript ES6+**

## 📋 Prerequisites

- **Java 17** or higher
- **Maven 3.6** or higher
- **Node.js 16** or higher
- **npm** or **yarn** package manager

## 🚀 Quick Start

### 1. Clone the Repository
```bash
git clone <repository-url>
cd task-manager-project
```

### 2. Start the Backend
```bash
cd backend
mvn clean install
mvn spring-boot:run
```

The backend will start on `http://localhost:8080`

### 3. Start the Frontend
```bash
cd frontend
npm install
npm start
```

The frontend will start on `http://localhost:3000`

### 4. Access the Application
- **Frontend**: http://localhost:3000
- **Backend API**: http://localhost:8080/api
- **H2 Database Console**: http://localhost:8080/h2-console

## 📁 Project Structure

```
project/
├── backend/                 # Spring Boot Backend
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/taskmanager/
│   │   │   │   ├── config/
│   │   │   │   ├── controller/
│   │   │   │   ├── dto/
│   │   │   │   ├── model/
│   │   │   │   ├── repository/
│   │   │   │   ├── security/
│   │   │   │   ├── service/
│   │   │   │   └── TaskManagerApplication.java
│   │   │   └── resources/
│   │   │       └── application.properties
│   │   └── test/
│   ├── pom.xml
│   └── README.md
├── frontend/                # React Frontend
│   ├── src/
│   │   ├── components/
│   │   ├── services/
│   │   ├── App.js
│   │   ├── index.js
│   │   └── index.css
│   ├── public/
│   ├── package.json
│   └── README.md
└── README.md
```

## 🔧 API Endpoints

### Authentication
- `POST /api/auth/register` - User registration
- `POST /api/auth/login` - User login

### Tasks (Requires Authentication)
- `GET /api/tasks` - Get all tasks for the authenticated user
- `POST /api/tasks` - Create a new task
- `PUT /api/tasks/{id}` - Update an existing task
- `PATCH /api/tasks/{id}/toggle` - Toggle task completion
- `DELETE /api/tasks/{id}` - Delete a task

## 🎯 How to Use

1. **Register a new account** or **login** with existing credentials
2. **Create tasks** by clicking "Add New Task"
3. **Edit tasks** by clicking the "Edit" button
4. **Mark tasks as complete** by clicking the toggle button
5. **Delete tasks** by clicking the "Delete" button
6. **Logout** when finished

## 🔒 Security Features

- **JWT Token Authentication** for stateless sessions
- **Password Encryption** using BCrypt
- **Input Validation** on both client and server
- **CORS Configuration** for secure cross-origin requests
- **User Isolation** - users can only access their own tasks
- **Automatic Token Refresh** and error handling

## 🧪 Testing the API

### Using cURL

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

3. **Create a task (replace <token> with JWT token):**
```bash
curl -X POST http://localhost:8080/api/tasks \
  -H "Authorization: Bearer <token>" \
  -H "Content-Type: application/json" \
  -d '{"title":"My first task","description":"This is a test task"}'
```

### Using Postman
Import the API endpoints into Postman for easier testing.

## 🚀 Deployment

### Backend Deployment
- **Heroku**: Easy deployment with Maven
- **AWS**: Deploy to EC2 or use Elastic Beanstalk
- **Docker**: Containerize the application
- **Google Cloud**: Deploy to App Engine

### Frontend Deployment
- **Netlify**: Drag and drop deployment
- **Vercel**: Optimized for React applications
- **GitHub Pages**: Free hosting for static sites
- **AWS S3 + CloudFront**: Scalable hosting solution

## 📝 Resume Highlights

This project demonstrates:

### Technical Skills
- **Full Stack Development** with Java and React
- **RESTful API Design** following best practices
- **Authentication & Authorization** with JWT
- **Database Design** with JPA/Hibernate
- **Modern Frontend Development** with React hooks
- **Responsive Web Design** with CSS3
- **Version Control** with Git

### Soft Skills
- **Project Planning** and architecture design
- **Problem Solving** and debugging
- **Documentation** and code organization
- **User Experience** design
- **Testing** and quality assurance

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

## 🙏 Acknowledgments

- Spring Boot team for the excellent framework
- React team for the amazing frontend library
- The open-source community for various tools and libraries

---

**Perfect for your resume as a Full Stack Java Developer!** 🎯

This project showcases your ability to build complete web applications from frontend to backend, demonstrating both technical skills and understanding of modern web development practices.
