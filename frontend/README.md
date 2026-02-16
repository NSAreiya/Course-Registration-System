# Course Registration System - React + Vite Frontend

## 🚀 Features

- **Modern UI**: Built with React and Vite for fast, interactive user experience
- **Beautiful Design**: Gradient backgrounds, smooth animations, and responsive layouts
- **Routing**: Client-side routing with React Router
- **API Integration**: Axios for seamless communication with Spring Boot backend
- **User-Friendly**: Intuitive navigation and clear visual feedback

## 📋 Pages

1. **Home**: Navigation hub with cards for all main features
2. **Register Course**: Form to enroll in courses with validation
3. **Available Courses**: Table view of all courses with details
4. **Enrolled Students**: Admin-only view of all enrolled students

## 🛠️ Technologies Used

- **React 19.2**: Modern UI library
- **Vite**: Next-generation frontend build tool
- **React Router**: Client-side routing
- **Axios**: HTTP client for API calls
- **CSS3**: Custom styles with gradients and animations

## 📦 Getting Started

### Prerequisites
- Node.js (v16 or higher)
- Java 17+
- Maven

### Start Development

1. **Start Backend** (in project root):
```bash
mvnw spring-boot:run
```
Backend runs on `http://localhost:8080`

2. **Start Frontend** (in frontend directory):
```bash
cd frontend
npm run dev
```
Frontend runs on `http://localhost:5173`

3. Open your browser to `http://localhost:5173`

## 🔧 Configuration

- CORS enabled for React frontend
- API proxy configured in `vite.config.js`
- Session-based authentication with Spring Security

## 📱 API Endpoints

- `GET /courses` - Get all available courses
- `POST /courses/register` - Register for a course
- `GET /admin/courses/enrolled` - Get enrolled students (Admin only)
- `POST /logout` - Logout user

## 🎨 Design Highlights

- **Unique Gradients**: Each page features distinct gradient backgrounds
- **Smooth Animations**: Hover effects and transitions
- **Responsive Design**: Works on all device sizes
- **Interactive Cards**: Clickable navigation cards with visual feedback
- **Form Validation**: Real-time validation and error messages

## 📂 Project Structure

```
frontend/
├── src/
│   ├── components/          # React components
│   ├── styles/              # CSS files
│   ├── App.jsx              # Main app with routing
│   ├── main.jsx             # Entry point
│   └── index.css            # Global styles
├── package.json
└── vite.config.js
```

## 🚀 Build for Production

```bash
npm run build
```

Built files will be in `dist/` directory.
