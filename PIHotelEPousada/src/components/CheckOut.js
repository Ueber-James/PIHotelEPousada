// CheckOut.js
import React, { useContext, useEffect } from 'react';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import { BsCalendar } from 'react-icons/bs';
import { RoomContext } from '../context/RoomContext';
import { format } from 'date-fns';

const CheckOut = () => {
  const { checkOutDate, handleCheckOutChange, setStayDuration, checkInDate, stayDuration } = useContext(RoomContext);

  useEffect(() => {
    // Lógica específica ao mudar a data de check-out (se necessário)
    if (checkInDate && checkOutDate) {
      const diffInDays = Math.floor((checkOutDate - checkInDate) / (1000 * 60 * 60 * 24));
      setStayDuration(diffInDays);
    }
  }, [checkInDate, checkOutDate, setStayDuration, stayDuration]);

  console.log('Detalhes da Reserva:', { checkInDate, checkOutDate, stayDuration, stayDuration });

  return (
    <div className='relative flex items-center justify-end h-full'>
      <div className='absolute z-10 pr-8'>
        <div>
          <BsCalendar className='text-accent text-base' />
        </div>
      </div>
      <DatePicker
        className='w-full h-full'
        selected={checkOutDate}
        placeholderText='Check Out'
        onChange={(date) => handleCheckOutChange(date)}
        dateFormat='dd/MM/yyyy'
        showMonthDropdown
        showYearDropdown
        dropdownMode='select'
      />
    </div>
  );
};

export default CheckOut;
