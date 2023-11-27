import React, { useContext } from 'react';
import { RoomContext } from '../context/RoomContext';
import'react-datepicker/dist/react-datepicker.css'
import '../datepicker.css'

const LocationSearch = () => {
  const { cidade, setCidade, pais, setPais } = useContext(RoomContext);

  const handleCityChange = (e) => {
    setCidade(e.target.value);
  };

  const handleCountryChange = (e) => {
    setPais(e.target.value);
  };

  return (
    <div className='relative flex items-center justify-end h-full'>
      <div class="react-datepicker-wrapper"><div class="react-datepicker__input-container"><input  type='text'
        placeholder='Enter Country'
        value={pais}
        onChange={handleCountryChange}
        className='border p-2 w-full h-full'/></div></div>
       <div>
      
      </div>
    </div>
  );
};

export default LocationSearch;
