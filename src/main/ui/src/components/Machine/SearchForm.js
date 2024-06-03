import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './animations.css'; // Import the CSS animations

const SearchForm = ({ onSearch }) => {
  const [addresses, setAddresses] = useState([]);
  const [selectedAddress, setSelectedAddress] = useState('');

  useEffect(() => {
    const fetchAddresses = async () => {
      try {
        const response = await axios.get('/api/addresses');
        setAddresses(response.data);
      } catch (error) {
        console.error('There was an error fetching the addresses!', error);
      }
    };
    fetchAddresses();
  }, []);

  const handleSubmit = (event) => {
    event.preventDefault();
    onSearch(selectedAddress);
  };

  return (
    <form onSubmit={handleSubmit} className="fade-in">
      <div className="form-group">
        <label htmlFor="address">Select Address:</label>
        <select
          className="form-control input-focus-effect"
          id="address"
          value={selectedAddress}
          onChange={(e) => setSelectedAddress(e.target.value)}
        >
          <option value="">Select an address</option>
          {addresses.map((address) => (
            <option key={address.id} value={address.id}>
              {`${address.street}, ${address.city}, ${address.state}, ${address.zipCode}`}
            </option>
          ))}
        </select>
      </div>
      <button type="submit" className="btn btn-primary button-hover-effect">Search</button>
    </form>
  );
};

export default SearchForm;
