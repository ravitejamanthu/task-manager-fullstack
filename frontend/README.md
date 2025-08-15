# Task Manager Frontend

A modern React application for managing personal tasks with a beautiful and responsive user interface.

## Features

- **User Authentication**: Login and registration with JWT tokens
- **Task Management**: Create, read, update, delete, and toggle task completion
- **Responsive Design**: Works perfectly on desktop, tablet, and mobile devices
- **Modern UI**: Clean and intuitive user interface
- **Real-time Updates**: Instant feedback for all user actions
- **Form Validation**: Client-side validation for better user experience

## Tech Stack

- **React 18.2.0**
- **React Router DOM 6.11.2**
- **Axios 1.4.0**
- **CSS3** with modern styling
- **JavaScript ES6+**

## Prerequisites

- Node.js 16 or higher
- npm or yarn package manager

## Setup Instructions

1. **Navigate to the frontend directory**
   ```bash
   cd frontend
   ```

2. **Install dependencies**
   ```bash
   npm install
   ```

3. **Start the development server**
   ```bash
   npm start
   ```

The application will open in your browser at `http://localhost:3000`

## Project Structure

```
src/
├── components/
│   ├── Login.js
│   ├── Navbar.js
│   ├── Register.js
│   ├── TaskForm.js
│   ├── TaskItem.js
│   └── TaskList.js
├── services/
│   └── api.js
├── App.js
├── App.css
├── index.js
└── index.css
```

## Features in Detail

### Authentication
- **Login**: Username and password authentication
- **Register**: User registration with email validation
- **JWT Token Management**: Automatic token handling and storage
- **Protected Routes**: Secure access to task management features

### Task Management
- **Create Tasks**: Add new tasks with title and optional description
- **View Tasks**: Display all tasks in a clean, organized list
- **Edit Tasks**: Modify existing task details
- **Delete Tasks**: Remove tasks with confirmation
- **Toggle Completion**: Mark tasks as complete/incomplete
- **Task Status**: Visual indicators for task completion status

### User Interface
- **Responsive Design**: Adapts to different screen sizes
- **Modern Styling**: Clean, professional appearance
- **Loading States**: Visual feedback during API calls
- **Error Handling**: User-friendly error messages
- **Form Validation**: Real-time validation feedback

## API Integration

The frontend communicates with the backend through RESTful APIs:

- **Authentication Endpoints**: `/api/auth/register`, `/api/auth/login`
- **Task Endpoints**: `/api/tasks` (GET, POST, PUT, DELETE, PATCH)

## Development

### Available Scripts

- `npm start`: Runs the app in development mode
- `npm build`: Builds the app for production
- `npm test`: Launches the test runner
- `npm eject`: Ejects from Create React App (not recommended)

### Environment Variables

The application is configured to proxy requests to `http://localhost:8080` (the backend server). This is set in the `package.json` file.

## Deployment

This React application can be easily deployed to:

- **Netlify**
- **Vercel**
- **GitHub Pages**
- **AWS S3 + CloudFront**
- **Firebase Hosting**

### Build for Production

```bash
npm run build
```

This creates a `build` folder with optimized production files.

## Browser Support

- Chrome (latest)
- Firefox (latest)
- Safari (latest)
- Edge (latest)

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test thoroughly
5. Submit a pull request

## Troubleshooting

### Common Issues

1. **Backend Connection Error**: Ensure the backend server is running on port 8080
2. **CORS Issues**: The backend is configured to allow cross-origin requests
3. **Authentication Issues**: Clear browser localStorage and try logging in again

### Development Tips

- Use browser developer tools to debug API calls
- Check the Network tab for request/response details
- Use React Developer Tools for component debugging
