import React, { useState } from 'react';
import axios from 'axios';
import './MachineForm.css';

const MachineForm = () => {
  const [machine, setMachine] = useState({
    type: '',
    status: '',
    address: {
      street: '',
      city: '',
      state: '',
      zipCode: ''
    },
    timeRemaining: 0
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    if (name.includes('address.')) {
      const addressField = name.split('.')[1];
      setMachine(prevMachine => ({
        ...prevMachine,
        address: {
          ...prevMachine.address,
          [addressField]: value
        }
      }));
    } else {
      setMachine(prevMachine => ({
        ...prevMachine,
        [name]: value
      }));
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('http://localhost:8080/api/machines', machine);
      console.log('Machine created:', response.data);
      alert('Machine created successfully!');
    } catch (error) {
      console.error('There was an error creating the machine!', error);
      alert('Failed to create machine.');
    }
  };

  return (
    <form onSubmit={handleSubmit} className="machine-form" id="machines">
      <h2>Create Machine</h2>
      <div>
        <label>Type:</label>
        <input
          type="text"
          name="type"
          value={machine.type}
          onChange={handleChange}
          required
        />
      </div>
      <div>
        <label>Status:</label>
        <input
          type="text"
          name="status"
          value={machine.status}
          onChange={handleChange}
          required
        />
      </div>
      <div>
        <h3>Address</h3>
        <label>Street:</label>
        <input
          type="text"
          name="address.street"
          value={machine.address.street}
          onChange={handleChange}
          required
        />
        <label>City:</label>
        <input
          type="text"
          name="address.city"
          value={machine.address.city}
          onChange={handleChange}
          required
        />
        <label>State:</label>
        <input
          type="text"
          name="address.state"
          value={machine.address.state}
          onChange={handleChange}
          required
        />
        <label>Zip Code:</label>
        <input
          type="text"
          name="address.zipCode"
          value={machine.address.zipCode}
          onChange={handleChange}
          required
        />
      </div>
      <div>
        <label>Time Remaining (minutes):</label>
        <input
          type="number"
          name="timeRemaining"
          value={machine.timeRemaining}
          onChange={handleChange}
          required
        />
      </div>
      <button type="submit">Create Machine</button>
    </form>
  );
};

export default MachineForm;
