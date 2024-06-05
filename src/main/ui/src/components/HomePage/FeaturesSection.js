import React from 'react';
import './FeaturesSection.css';

const FeaturesSection = () => {
  return (
    <div className="features-section" id="features">
      <h2>Features</h2>
      <div className="features-container">
        <div className="feature-item">
          <h3>Real-time Availability</h3>
          <p>Check which machines are available in real-time.</p>
        </div>
        <div className="feature-item">
          <h3>Easy Reservations</h3>
          <p>Reserve your favorite machines ahead of time.</p>
        </div>
        <div className="feature-item">
          <h3>Notifications</h3>
          <p>Get notified when machines become available.</p>
        </div>
      </div>
    </div>
  );
};

export default FeaturesSection;
