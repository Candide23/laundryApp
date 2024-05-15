import React from 'react';
import backgroundImage from './images/laundromat.jpg'; // Ensure the path is correct

const HeroSection = () => {
  return (
    <div 
      className="jumbotron jumbotron-fluid hero-background" 
      style={{ 
        backgroundImage: `url(${backgroundImage})`, 
        backgroundSize: 'cover', 
        backgroundPosition: 'center'
      }}
    >
      <div className="container text-center">
        <div className="hero-content text-white">
          <h1 className="display-3">Welcome to LaundryApp</h1>
          <p className="lead">Manage your laundry sessions with ease.</p>
          <a className="btn btn-primary btn-lg" href="#signup" role="button">Sign Up Now</a>
        </div>
      </div>
    </div>
  );
};

export default HeroSection;

