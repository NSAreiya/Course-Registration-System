import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import Header from './Header';
import '../styles/PaymentSuccess.css';

const PaymentSuccess = () => {
  const navigate = useNavigate();
  const [orderDetails, setOrderDetails] = useState(null);

  useEffect(() => {
    const order = JSON.parse(localStorage.getItem('lastOrder') || 'null');
    if (order) {
      setOrderDetails(order);
    }
  }, []);

  return (
    <div className="payment-success-container">
      <Header />
      
      <div className="success-content">
        <div className="success-card">
          <div className="success-icon">✅</div>
          <h1>Payment Successful!</h1>
          <p className="success-message">
            Thank you for your purchase! Your courses have been added to your account.
          </p>

          {orderDetails && (
            <div className="order-details">
              <h2>Order Summary</h2>
              <div className="order-info">
                <div className="info-row">
                  <span>Order Date:</span>
                  <span>{new Date(orderDetails.date).toLocaleDateString()}</span>
                </div>
                <div className="info-row">
                  <span>Total Items:</span>
                  <span>{orderDetails.items.reduce((sum, item) => sum + item.quantity, 0)}</span>
                </div>
                <div className="info-row total">
                  <span>Total Paid:</span>
                  <span>₹{orderDetails.total.toFixed(2)}</span>
                </div>
              </div>

              <div className="purchased-courses">
                <h3>Purchased Courses:</h3>
               
{orderDetails.items.map((item, index) => (
                  <div key={index} className="course-item">
                    <img src={item.photoUrl || 'https://via.placeholder.com/80'} alt={item.courseName} />
                    <div className="course-info">
                      <h4>{item.courseName}</h4>
                      <p>Qty: {item.quantity} × ₹{item.price}</p>
                    </div>
                    <div className="course-price">
                      ₹{(item.price * item.quantity).toFixed(2)}
                    </div>
                  </div>
                ))}
              </div>
            </div>
          )}

          <div className="action-buttons">
            <button className="home-btn" onClick={() => navigate('/')}>
              🏠 Go to Home
            </button>
            <button className="courses-btn" onClick={() => navigate('/available-courses')}>
              📚 Browse More Courses
            </button>
          </div>

          <div className="email-notification">
            📧 A confirmation email has been sent to your registered email address.
          </div>
        </div>
      </div>
    </div>
  );
};

export default PaymentSuccess;
