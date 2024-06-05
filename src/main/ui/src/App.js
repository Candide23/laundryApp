import React from 'react';
import Navbar from './components/HomePage/Navbar';
import HeroSection from './components/HomePage/HeroSection';
import FeaturesSection from './components/HomePage/FeaturesSection';
import Footer from './components/HomePage/Footer';
import MachineForm from './components/Machine/MachineForm';
import './App.css';

function App() {
  return (
    <div className="App">
      <Navbar />
      <HeroSection />
      <FeaturesSection />
      <MachineForm />
      <Footer />
    </div>
  );
}

export default App;

