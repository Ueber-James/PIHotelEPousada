import React, { useContext, useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { RoomContext } from '../context/RoomContext';
import { FaMapMarkedAlt } from 'react-icons/fa';
import { format, addDays } from 'date-fns';
import CheckIn from '../components/CheckIn'
import CheckOut from '../components/CheckOut'

const ReservationPage = () => {
  const { rooms, checkInDate, checkOutDate, setCheckInDate, setCheckOutDate, setStayDuration, stayDuration } = useContext(RoomContext);
  const { id } = useParams();
  const room = rooms.find((room) => room.id === Number(id));

  const [total, setTotal] = useState(0);

  const handleMapClick = () => {
    const googleMapsUrl = `https://www.google.com/maps?q=${room.endereco},${room.pais}`;
    window.open(googleMapsUrl, '_blank');
  };

  useEffect(() => {
    if (!room || !checkInDate || !checkOutDate || checkInDate >= checkOutDate) {
      return;
    }

    const diffInDays = Math.floor((checkOutDate - checkInDate) / (1000 * 60 * 60 * 24));

    setStayDuration(diffInDays);

    const totalPrice = diffInDays * room.price;
    setTotal(totalPrice);

    console.log('Detalhes da Reserva:', { room, checkInDate, checkOutDate, stayDuration: diffInDays, total: totalPrice, stayDuration });
  }, [checkInDate, checkOutDate, room, setStayDuration]);

  const handleConfirmReservation = () => {
    if (!checkInDate || !checkOutDate || checkInDate >= checkOutDate) {
      console.error('Datas de reserva inválidas');
      return;
    }

   
    // Adicione a lógica para confirmar a reserva (por exemplo, enviar dados para um servidor)
  };

  if (!room) {
    return <div>Quarto não encontrado</div>;
  }

  const formatDate = (date) => format(date, 'dd/MM/yyyy');


  return (
    <section>
      <div className='bg-room bg-cover bg-center h-[560px] relative flex justify-start items-center '>
        <div className='absolute w-full h-full bg-black/70'></div>
      </div>

      <div className='bg-gray py-2 shadow-lg mx-auto h-full flex uppercase px-10 text-accent'>
        <div className='px-3'>
          <FaMapMarkedAlt />
        </div>
        <h5 style={{ cursor: 'pointer ' }} className='text-accent' onClick={handleMapClick}>
          {room.endereco}, {room.pais}
        </h5>
      </div>

      <div>
        <h2>Reservar Quarto: {room.name}</h2>
        <p>Descrição: {room.description}</p>
        <p>Preço por noite: ${room.price}</p>
        <div>
          <label>Data de Check-In:</label>
          {/* <input
            type="date"
            value={checkInDate ? formatDate(checkInDate) : ''}
            min={formatDate(new Date())} // Impede datas anteriores à data atual
            onChange={(e) => setCheckInDate(new Date(e.target.value))}
          /> */}
           <p><CheckIn /></p>
        </div>
        <div>
          <label>Data de Check-Out:</label>
          {/* <input
            type="date"
            value={checkOutDate ? formatDate(checkOutDate) : ''}
            min={checkInDate ? formatDate(addDays(checkInDate, 1)) : formatDate(new Date())} // Impede datas anteriores à data de check-in
            onChange={(e) => setCheckOutDate(new Date(e.target.value))}
          /> */}
          <p><CheckOut /></p>
        </div>
        <p>Duração da Estadia: {stayDuration} dias</p>
        <p>Total: ${total}</p>
        <button onClick={handleConfirmReservation}>Confirmar Reserva</button>
      </div>
    </section>
  );
};

export default ReservationPage;
