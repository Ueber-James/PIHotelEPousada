// CheckOut.js
import React, { useContext, useEffect } from 'react';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import { BsCalendar } from 'react-icons/bs';
import { RoomContext } from '../context/RoomContext';
import { format } from 'date-fns';

const CheckOut = () => {
  const { checkOutDate, setCheckOutDate, setStayDuration, checkInDate } = useContext(RoomContext);

  useEffect(() => {
    // Lógica específica ao mudar a data de check-out (se necessário)
  }, [checkInDate, checkOutDate, setStayDuration]);

  const formatDate = (date) => format(date, 'dd/MM/yyyy');

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
        onChange={(date) => setCheckOutDate(date)}
        dateFormat="dd/MM/yyyy" // Adicione esta propriedade para definir o formato da data
        showMonthDropdown
        showYearDropdown
        dropdownMode="select"
      />
    </div>
  );
};

export default CheckOut;
