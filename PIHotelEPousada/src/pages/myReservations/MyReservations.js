import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './myreservations.css';


const MyReservations = () => {
  const [reservations, setReservations] = useState([]);

  useEffect(() => {
    const fetchReservations = async () => {
      try {
        const currentUser = JSON.parse(localStorage.getItem('currentUser'));
        const userId = currentUser.id;

        const response = await axios.get(`http://localhost:3001/api/reservations/${userId}`);
        setReservations(response.data);
      } catch (error) {
        console.error('Erro ao obter as reservas do usuário:', error);
      }
    };

    fetchReservations();
  }, []);

  return (
    <div><h1>Minhas Reservas</h1>
      
      <div className="app">
      <main className="main">
        {reservations.length === 0 ? (
          <div className="center-container">
            <p>Ainda não fez uma reserva.</p>
            <a href="/">Voltar à página inicial</a>
          </div>
        ) : (
          <ul>
            {reservations.map((reservation) => (
              <li key={reservation.id}>
              </li>
            ))}
          </ul>
        )}
        </main>
      </div>

    </div>
  );
};

export default MyReservations;
