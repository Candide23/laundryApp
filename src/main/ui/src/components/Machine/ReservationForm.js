import React, { useState } from 'react';
import axios from 'axios';
import './animations.css'; // Import the CSS animations

const ReservationForm = ({ machine }) => {
  const [reservationCode, setReservationCode] = useState('');
  const [startTime, setStartTime] = useState('');
  const [endTime, setEndTime] = useState('');

  const handleSubmit = async (event) => {
    event.preventDefault();
    const reservation = {
      machine: { id: machine.id },
      code: reservationCode,
      startTime,
      endTime,
    };
    try {
      const response = await axios.post('/api/reservations', reservation);
      alert('Reservation created: ' + response.data.id);
    } catch (error) {
      console.error('There was an error creating the reservation!', error);
    }
  };

  return (
    <form onSubmit={handleSubmit} className="slide-in-bottom">
      <h3>Reserve {machine.type}</h3>
      <div className="form-group">
        <label htmlFor="reservationCode">Reservation Code:</label>
        <input
          type="text"
          className="form-control input-focus-effect"
          id="reservationCode"
          value={reservationCode}
          onChange={(e) => setReservationCode(e.target.value)}
        />
      </div>
      <div className="form-group">
        <label htmlFor="startTime">Start Time:</label>
        <input
          type="datetime-local"
          className="form-control input-focus-effect"
          id="startTime"
          value={startTime}
          onChange={(e) => setStartTime(e.target.value)}
        />
      </div>
      <div className="form-group">
        <label htmlFor="endTime">End Time:</label>
        <input
          type="datetime-local"
          className="form-control input-focus-effect"
          id="endTime"
          value={endTime}
          onChange={(e) => setEndTime(e.target.value)}
        />
      </div>
      <button type="submit" className="btn btn-primary button-hover-effect">Create Reservation</button>
    </form>
  );
};

export default ReservationForm;
