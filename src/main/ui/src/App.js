import React from 'react';
import './App.css';  // Import global styles right after React import
import Navbar from './Navbar';
import HeroSection from './HeroSection';
import FeaturesSection from './FeaturesSection';
import Testimonials from './Testimonials';
import Footer from './Footer';
import 'bootstrap/dist/css/bootstrap.min.css';



const App = () => {
  return (
    <div>
      <Navbar />
      <HeroSection />
      <FeaturesSection />
      <Testimonials />
      <Footer />
    </div>
  );
};

export default App;

