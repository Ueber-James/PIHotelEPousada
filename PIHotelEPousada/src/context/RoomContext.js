import React, { createContext, useEffect, useState} from 'react';

// data

import { roomData } from '../data';

//creater context

export const RoomContext = createContext();

const RoomProvider = ({children}) => {
  const [rooms, setRooms] = useState(roomData);
  const [adults, setAdults] = useState('1 adult')
  const [kids, setKids] = useState('0 kids')
  const [total, setTotal] = useState(0);
useEffect (()=> {
  setTotal(Number(adults[0]) + Number(kids[0]))
});
  
const handleClick = (e) => {
 e.preventDefault();
  console.log(total)

  const newRooms = roomData.filter(romm => {
    return total <= romm.maxPerson
  })
  setRooms(newRooms);
};



  return (
  <RoomContext.Provider value={{rooms, adults, setAdults, kids, setKids, handleClick}}>{children}</RoomContext.Provider>
  )
};

export default RoomProvider;
