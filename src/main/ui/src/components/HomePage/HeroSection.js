import React from 'react';
import './HeroSection.css';
import backgroundImage from '../../images/laundromat.jpg';

const HeroSection = () => {
  return (
    <div className="hero-container" style={{ backgroundImage: `url(${backgroundImage})` }}>
      <div className="hero-overlay">
        <div className="hero-content">
          <h1>Welcome to LaundryApp</h1>
          <p>Manage your laundry sessions with ease.</p>
          <a className="btn btn-primary" href="#signup">Sign Up Now</a>
        </div>
      </div>
    </div>
  );
};

export default HeroSection;


