import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Header from './Header';
import '../styles/AdminCourses.css';

const AdminCourses = () => {
  const [courses, setCourses] = useState([]);
  const [formData, setFormData] = useState({
    courseName: '',
    trainer: '',
    durationInWeeks: '',
    photoUrl: '',
    description: '',
    price: ''
  });
  const [loading, setLoading] = useState(false);
  const [message, setMessage] = useState({ type: '', text: '' });

  useEffect(() => {
    fetchCourses();
  }, []);

  const fetchCourses = async () => {
    try {
      const response = await axios.get('https://course-registration-system-ivm7-hxkupeicw-nsareiyas-projects.vercel.app/admin/courses');
      setCourses(response.data);
    } catch (error) {
      console.error('Error fetching courses:', error);
    }
  };

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);
    setMessage({ type: '', text: '' });

    try {
      await axios.post('https://course-registration-system-ivm7-hxkupeicw-nsareiyas-projects.vercel.app/admin/courses/add', {
        ...formData,
        durationInWeeks: parseInt(formData.durationInWeeks),
        price: parseFloat(formData.price)
      });

      setMessage({ type: 'success', text: 'Course added successfully!' });
      setFormData({
        courseName: '',
        trainer: '',
        durationInWeeks: '',
        photoUrl: '',
        description: '',
        price: ''
      });
      fetchCourses();
    } catch (error) {
      setMessage({ type: 'error', text: 'Failed to add course' });
    } finally {
      setLoading(false);
    }
  };

  const handleDelete = async (courseId) => {
    if (window.confirm('Are you sure you want to delete this course?')) {
      try {
        await axios.delete(`https://course-registration-system-ivm7-hxkupeicw-nsareiyas-projects.vercel.app/admin/courses/${courseId}`);
        setMessage({ type: 'success', text: 'Course deleted successfully!' });
        fetchCourses();
      } catch (error) {
        setMessage({ type: 'error', text: 'Failed to delete course' });
      }
    }
  };

  return (
    <div className="admin-courses-container">
      <Header />
      <div className="admin-content">
        <h1>🎓 Manage Courses</h1>

        {message.text && (
          <div className={`message ${message.type}`}>
            {message.text}
          </div>
        )}

        <div className="add-course-form">
          <h2>Add New Course</h2>
          <form onSubmit={handleSubmit}>
            <div className="form-row">
              <div className="form-group">
                <label>Course Name *</label>
                <input
                  type="text"
                  name="courseName"
                  value={formData.courseName}
                  onChange={handleChange}
                  required
                />
              </div>
              <div className="form-group">
                <label>Trainer *</label>
                <input
                  type="text"
                  name="trainer"
                  value={formData.trainer}
                  onChange={handleChange}
                  required
                />
              </div>
            </div>

            <div className="form-row">
              <div className="form-group">
                <label>Duration (Weeks) *</label>
                <input
                  type="number"
                  name="durationInWeeks"
                  value={formData.durationInWeeks}
                  onChange={handleChange}
                  required
                />
              </div>
              <div className="form-group">
                <label>Price (₹) *</label>
                <input
                  type="number"
                  step="0.01"
                  name="price"
                  value={formData.price}
                  onChange={handleChange}
                  required
                />
              </div>
            </div>

            <div className="form-group">
              <label>Photo URL *</label>
              <input
                type="url"
                name="photoUrl"
                value={formData.photoUrl}
                onChange={handleChange}
                placeholder="https://example.com/image.jpg"
                required
              />
            </div>

            <div className="form-group">
              <label>Description *</label>
              <textarea
                name="description"
                value={formData.description}
                onChange={handleChange}
                rows="4"
                required
              />
            </div>

            <button type="submit" className="add-btn" disabled={loading}>
              {loading ? 'Adding...' : '➕ Add Course'}
            </button>
          </form>
        </div>

        <div className="courses-list">
          <h2>Existing Courses ({courses.length})</h2>
          <div className="courses-grid">
            {courses.map((course) => (
              <div key={course.courseId} className="course-card">
                <img src={course.photoUrl} alt={course.courseName} />
                <div className="course-info">
                  <h3>{course.courseName}</h3>
                  <p className="trainer">👨‍🏫 {course.trainer}</p>
                  <p className="description">{course.description}</p>
                  <div className="course-meta">
                    <span className="duration">⏱️ {course.durationInWeeks} weeks</span>
                    <span className="price">₹{course.price}</span>
                  </div>
                  <button 
                    className="delete-btn"
                    onClick={() => handleDelete(course.courseId)}
                  >
                    🗑️ Delete
                  </button>
                </div>
              </div>
            ))}
          </div>
        </div>
      </div>
    </div>
  );
};

export default AdminCourses;
