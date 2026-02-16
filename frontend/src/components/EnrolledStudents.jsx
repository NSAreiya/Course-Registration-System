import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import Header from './Header';
import '../styles/EnrolledStudents.css';

const EnrolledStudents = () => {
  const navigate = useNavigate();
  const [students, setStudents] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');

  useEffect(() => {
    fetchEnrolledStudents();
  }, []);

  const fetchEnrolledStudents = async () => {
    try {
      const response = await axios.get('https://course-registration-system-1-g9zp.onrender.com/admin/courses/enrolled', {
        withCredentials: true
      });
      setStudents(response.data);
    } catch (error) {
      if (error.response?.status === 403 || error.response?.status === 401) {
        setError('You are not authorized! Please login as ADMIN.');
      } else {
        setError('Failed to load enrolled students. Please try again.');
      }
      console.error('Error fetching enrolled students:', error);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="enrolled-container">
      <Header />
      
      <div className="enrolled-content">
        <button className="back-btn" onClick={() => navigate('/')}>
          ← Back to Home
        </button>
        
        <h2 className="page-title">Enrolled Students List</h2>
        <h3 className="student-count">
          Total Enrolled Students: {students.length}
        </h3>

        {loading && <div className="loading">Loading students...</div>}
        
        {error && <div className="error-message">{error}</div>}
        
        {!loading && !error && (
          <div className="table-wrapper">
            <table className="enrolled-table">
              <thead>
                <tr>
                  <th>Student Name</th>
                  <th>Email ID</th>
                  <th>Course Enrolled</th>
                </tr>
              </thead>
              <tbody>
                {students.length > 0 ? (
                  students.map((student, index) => (
                    <tr key={index}>
                      <td>{student.name}</td>
                      <td>{student.emailId}</td>
                      <td>{student.courseName}</td>
                    </tr>
                  ))
                ) : (
                  <tr>
                    <td colSpan="3" className="no-data">
                      No enrolled students found
                    </td>
                  </tr>
                )}
              </tbody>
            </table>
          </div>
        )}
      </div>
    </div>
  );
};

export default EnrolledStudents;
