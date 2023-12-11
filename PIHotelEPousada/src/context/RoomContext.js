// RoomContext.js
import React, { createContext, useEffect, useState } from 'react';
import { roomData } from '../data';

export const RoomContext = createContext();

const RoomProvider = ({ children }) => {
  const [rooms, setRooms] = useState(roomData);
  const [adults, setAdults] = useState('1 adult');
  const [kids, setKids] = useState('0 kids');
  const [total, setTotal] = useState(0);
  const [cidade, setCidade] = useState('');
  const [pais, setPais] = useState('');
  const [checkInDate, setCheckInDate] = useState(null);
  const [checkOutDate, setCheckOutDate] = useState(null);
  const [stayDuration, setStayDuration] = useState(0);

  useEffect(() => {
    setTotal(Number(adults[0]) + Number(kids[0]));
  }, [adults, kids]);

  const handleCityChange = (e) => {
    setCidade(e.target.value);
  };

  const handleCountryChange = (e) => {
    setPais(e.target.value);
  };

  const handleCheckInChange = (date) => {
    setCheckInDate(date);
  };

  const handleCheckOutChange = (date) => {
    setCheckOutDate(date);
  };

  const handleClick = (e) => {
    e.preventDefault();

    const newRooms = roomData.filter((room) => {
      return (
        total <= room.maxPerson &&
        (cidade.trim() === '' || room.cidade.toLowerCase().includes(cidade.toLowerCase())) &&
        (pais.trim() === '' || room.pais.toLowerCase().includes(pais.toLowerCase()))
      );
    });
    setRooms(newRooms);
  };

  return (
    <RoomContext.Provider
      value={{
        rooms,
        adults,
        setAdults,
        kids,
        setKids,
        cidade,
        setCidade,
        pais,
        setPais,
        checkInDate,
        setCheckInDate,
        checkOutDate,
        setCheckOutDate,
        stayDuration,
        setStayDuration,
        handleCityChange,
        handleCountryChange,
        handleCheckInChange,
        handleCheckOutChange,
        handleClick,
      }}
    >
      {children}
    </RoomContext.Provider>
  );
};

export default RoomProvider;
