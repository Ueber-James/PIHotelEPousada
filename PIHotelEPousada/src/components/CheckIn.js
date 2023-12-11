// CheckIn.js
import React, { useContext, useEffect } from 'react';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import { BsCalendar } from 'react-icons/bs';
import { RoomContext } from '../context/RoomContext';
import { format } from 'date-fns';

const CheckIn = () => {
  const { checkInDate, handleCheckInChange } = useContext(RoomContext);

  useEffect(() => {
    // Lógica específica ao mudar a data de check-in (se necessário)
  }, [checkInDate, handleCheckInChange]);

  return (
    <div className='relative flex items-center justify-end h-full'>
      <div className='absolute z-10 pr-8'>
        <div>
          <BsCalendar className='text-accent text-base' />
        </div>
      </div>
      <DatePicker
        className='w-full h-full'
        selected={checkInDate}
        placeholderText='Check In'
        onChange={(date) => handleCheckInChange(date)}
        dateFormat='dd/MM/yyyy'
        showMonthDropdown
        showYearDropdown
        dropdownMode='select'
      />
    </div>
  );
};

export default CheckIn;
