# 🚀 Deployment Guide

## Frontend Deployment (GitHub Pages) ✅ COMPLETED

Your React frontend is now deployed at:
**https://ravitejamanthu.github.io/task-manager-fullstack**

### How it was deployed:
1. Installed `gh-pages` package
2. Added deployment scripts to `package.json`
3. Set homepage URL
4. Ran `npm run deploy`

## Backend Deployment Options

### Option 1: Railway (Recommended - FREE)

1. **Sign up** at [Railway.app](https://railway.app)
2. **Connect GitHub** repository
3. **Deploy from GitHub**:
   - Select your repository: `ravitejamanthu/task-manager-fullstack`
   - Railway will auto-detect it's a Java project
   - Set environment variables:
     ```
     JWT_SECRET=your-super-secret-jwt-key-here
     ALLOWED_ORIGINS=https://ravitejamanthu.github.io
     ```
4. **Get your backend URL** (e.g., `https://your-app.railway.app`)

### Option 2: Render (Alternative - FREE)

1. **Sign up** at [Render.com](https://render.com)
2. **Create New Web Service**
3. **Connect GitHub** repository
4. **Configure**:
   - Build Command: `cd backend && mvn clean package`
   - Start Command: `java -jar target/taskmanager-0.0.1-SNAPSHOT.jar`
   - Environment Variables: Same as Railway

### Option 3: Heroku (Alternative - FREE tier discontinued)

## After Backend Deployment

1. **Update Frontend API URL**:
   ```bash
   cd frontend
   # Create .env file
   echo "REACT_APP_API_URL=https://your-backend-url.railway.app/api" > .env
   npm run deploy
   ```

2. **Test the Application**:
   - Visit: https://ravitejamanthu.github.io/task-manager-fullstack
   - Register a new user
   - Create and manage tasks

## Environment Variables for Backend

```bash
JWT_SECRET=your-super-secret-jwt-key-here
ALLOWED_ORIGINS=https://ravitejamanthu.github.io
DATABASE_URL=your-database-url (if using external database)
```

## Database Options

### For Production (Recommended):
- **PostgreSQL** (free on Railway/Render)
- **MySQL** (free on Railway/Render)

### For Development:
- **H2** (in-memory, resets on restart)

## Troubleshooting

### Frontend Issues:
- Check if GitHub Pages is enabled in repository settings
- Verify homepage URL in `package.json`

### Backend Issues:
- Check Railway/Render logs
- Verify environment variables
- Ensure port is set correctly

## Resume Ready! 🎯

Your project is now:
- ✅ **GitHub Repository**: https://github.com/ravitejamanthu/task-manager-fullstack
- ✅ **Frontend Live**: https://ravitejamanthu.github.io/task-manager-fullstack
- 🔄 **Backend**: Deploy using Railway/Render (instructions above)

Perfect for showcasing your full-stack development skills!
