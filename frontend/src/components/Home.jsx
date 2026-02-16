import React from 'react';
import { useNavigate } from 'react-router-dom';
import Header from './Header';
import '../styles/Home.css';

const Home = () => {
  const navigate = useNavigate();
  
  // Check if user has admin role (you can enhance this with proper auth context)
  const isAdmin = true; // This should come from your authentication context

  return (
    <div className="home-container">
      <Header />
      
      <main className="main-content">
        <h2 className="welcome-text">Welcome to Course Registration Portal</h2>
        
        <div className="button-grid">
          <div className="nav-card" onClick={() => navigate('/register')}>
            <div className="card-icon">📝</div>
            <h3>Register a Course</h3>
            <p>Enroll yourself in exciting new courses</p>
          </div>
          
          <div className="nav-card" onClick={() => navigate('/available-courses')}>
            <div className="card-icon">📚</div>
            <h3>Available Courses</h3>
            <p>Browse all available courses</p>
          </div>
          
          {isAdmin && (
            <div className="nav-card admin-card" onClick={() => navigate('/enrolled-students')}>
              <div className="card-icon">👥</div>
              <h3>Enrolled Students</h3>
              <p>View all enrolled students (Admin Only)</p>
            </div>
          )}
        </div>

        <div className="instructions">
          <h2>How to Use</h2>
          <ul>
            <li><strong>Register a Course:</strong> Fill out the registration form to enroll in a course</li>
            <li><strong>Available Courses:</strong> View all courses offered with details</li>
            <li><strong>Enrolled Students:</strong> Admins can view list of all enrolled students</li>
          </ul>
        </div>
      </main>
    </div>
  );
};

export default Home;
