import React, { useState } from 'react';
import axios from 'axios';
import SearchForm from './SearchForm';
import ReservationForm from './ReservationForm';
import './animations.css'; // Import the CSS animations

const MachineList = () => {
  const [machines, setMachines] = useState([]);
  const [selectedMachine, setSelectedMachine] = useState(null);

  const handleSearch = async (addressId) => {
    try {
      const response = await axios.get(`/api/machines/address/${addressId}`);
      setMachines(response.data);
    } catch (error) {
      console.error("There was an error fetching the machines!", error);
    }
  };

  const handleReservation = (machine) => {
    setSelectedMachine(machine);
  };

  return (
    <div>
      <SearchForm onSearch={handleSearch} />
      <h2>Machines</h2>
      <ul className="list-group slide-in-left">
        {machines.map((machine) => (
          <li key={machine.id} className="list-group-item">
            {machine.type} - {machine.status} - {machine.timeRemaining ? `${machine.timeRemaining} minutes left` : 'No time remaining'}
            <button className="btn btn-secondary button-hover-effect" onClick={() => handleReservation(machine)}>Reserve</button>
          </li>
        ))}
      </ul>
      {selectedMachine && <ReservationForm machine={selectedMachine} />}
    </div>
  );
};

export default MachineList;
