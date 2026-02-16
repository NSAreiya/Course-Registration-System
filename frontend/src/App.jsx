import React from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import { AuthProvider } from './context/AuthContext';
import ProtectedRoute from './components/ProtectedRoute';
import Login from './components/Login';
import SignUp from './components/SignUp';
import Home from './components/Home';
import Register from './components/Register';
import AvailableCourses from './components/AvailableCourses';
import EnrolledStudents from './components/EnrolledStudents';
import AdminCourses from './components/AdminCourses';
import Cart from './components/Cart';
import PaymentSuccess from './components/PaymentSuccess';
import './App.css';

function App() {
  return (
    <AuthProvider>
      <Router>
        <Routes>
          <Route path="/login" element={<Login />} />
          <Route path="/signup" element={<SignUp />} />
          <Route path="/" element={
            <ProtectedRoute>
              <Home />
            </ProtectedRoute>
          } />
          <Route path="/register" element={
            <ProtectedRoute>
              <Register />
            </ProtectedRoute>
          } />
          <Route path="/available-courses" element={
            <ProtectedRoute>
              <AvailableCourses />
            </ProtectedRoute>
          } />
          <Route path="/enrolled-students" element={
            <ProtectedRoute>
              <EnrolledStudents />
            </ProtectedRoute>
          } />
          <Route path="/admin/courses" element={
            <ProtectedRoute>
              <AdminCourses />
            </ProtectedRoute>
          } />
          <Route path="/cart" element={
            <ProtectedRoute>
              <Cart />
            </ProtectedRoute>
          } />
          <Route path="/payment-success" element={
            <ProtectedRoute>
              <PaymentSuccess />
            </ProtectedRoute>
          } />
          <Route path="*" element={<Navigate to="/login" replace />} />
        </Routes>
      </Router>
    </AuthProvider>
  );
}

export default App;
