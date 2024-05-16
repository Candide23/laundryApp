import React from 'react';
import './App.css';  // Import global styles right after React import
import Navbar from './components/HomePage/Navbar';
import HeroSection from './components/HomePage/HeroSection';
import FeaturesSection from './FeaturesSection';
import Testimonials from './components/HomePage/Testimonials';
import Footer from './components/HomePage/Footer';
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

