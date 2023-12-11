import React, { useContext, useEffect, useState  } from 'react';
import {Link, useParams } from 'react-router-dom';
import StripeCheckout from 'react-stripe-checkout';
import Swal from 'sweetalert2';
import {
  FaWifi,
  FaCoffee,
  FaBath,
  FaParking,
  FaSwimmingPool,
  FaHotdog,
  FaStopwatch,
  FaCocktail,
  FaMapMarkedAlt
} from 'react-icons/fa';


import AdultsDropdown from '../components/AdultsDropdown'
import KindsDropdown from '../components/KidsDropdown'
import CheckIn from '../components/CheckIn'
import CheckOut from '../components/CheckOut'

import ScrollToTop from '../components/ScrollToTop'

import { RoomContext } from '../context/RoomContext';

import { FaCheck } from 'react-icons/fa';
const { v4: uuidv4 } = require('uuid');
const stripe = require('stripe')('pk_test_51OHwPjCrGIRUCSMTIKXEkqWVejJsdBFhroJvepmbM271JJ6GiP4D1Ss6dPEXQrPMqy6SHhuHliAp2l0J7HosE0yz00ScdjnLgE')



const RoomDetails = () => {




  const { rooms,checkInDate, checkOutDate, setCheckInDate, setCheckOutDate, setStayDuration, stayDuration, token  } = useContext(RoomContext);
  const { id } = useParams();
  const room = rooms.find((room) => {
    return room.id === Number(id);
  })
  const [total, setTotal] = useState(room?.price || 0);
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

  const handleMapClick = () => {
    // Use window.open() to open Google Maps in a new tab
    const googleMapsUrl = `https://www.google.com/maps?q=${endereco},${pais}`;
    window.open(googleMapsUrl, '_blank');
  };

  const { name, description, facilities, imageLg, price, pais, endereco } = room;
  
  function onToken(token){
    console.log(token)
    Swal.fire('congratulation' ,'Your Room Booked Successfully' ,'success').then(result=>{
      window.location.href='/'
    })
  }
  
  return (
    <section >
      <div className='bg-room bg-cover bg-center h-[560px] relative flex justify-start items-center '>
        {/* overlay */}
        <div className='absolute w-full h-full bg-black/70'></div>
        {/* title */}
       
      </div>
      <div className='bg-gray py-2 shadow-lg mx-auto h-full flex uppercase px-10 text-accent'>
        <div className='px-3'>
        <FaMapMarkedAlt />
        </div>
        <h5 onClick={handleMapClick} style={{ cursor: 'pointer ' }} className='text-accent'>
          {endereco}, {pais}
        </h5>
      </div>
      <div className='container mx-auto '>
        <div className='flex flex-col lg:flex-row h-full py-24'>
          {/* left */}
          <div className='w-full h-full lg:w-[60%]  px-6'>
            <h2 className=' h2'>{name}</h2>
            <p className='mb-8'>{description}</p>
            <img className='mb-8' src={imageLg} />
            {/* location */}
            <div className='mb-12 uppercase'>
              <h3 className='h3 mb-3'>location</h3>
              <p onClick={handleMapClick} style={{ cursor: 'pointer ' }} >
          {endereco}, {pais}
        </p>
              </div>
            {/* facilities */}
            <div className='mb-12 uppercase'>
              <h3 className='h3 mb-3'>Romm Faciities</h3>
              <p className='mb-12'>Lorem Ipsum is simply dummy text of the p</p>
              {/* grid */}
              <div className='grid grid-cols-3 gap-6 mb-12'>

              <div className='flex items-center gap-x-3 flex-1 '>
                      <div className='text-2xl text-accent'>{<FaWifi />}</div>
                      <div className='text-1xl'>Wifi</div>
                    </div>
                    <div className='flex items-center gap-x-3 flex-1 '>
                      <div className='text-2xl text-accent'>{ <FaCoffee />}</div>
                      <div className='text-1xl'>Coffee</div>
                    </div>
                    <div className='flex items-center gap-x-3 flex-1 '>
                      <div className='text-2xl text-accent'>{ <FaBath />}</div>
                      <div className='text-1xl'>Bath</div>
                    </div>
                    <div className='flex items-center gap-x-3 flex-1 '>
                      <div className='text-2xl text-accent'>{ <FaParking />}</div>
                      <div className='text-1xl'>Parking Space</div>
                    </div>
                    <div className='flex items-center gap-x-3 flex-1 '>
                      <div className='text-2xl text-accent'>{ <FaSwimmingPool />}</div>
                      <div className='text-1xl'>Swimming Pool</div>
                    </div>
                    <div className='flex items-center gap-x-3 flex-1 '>
                      <div className='text-2xl text-accent'>{ <FaHotdog />}</div>
                      <div className='text-1xl'>Breakfast</div>
                    </div>
                    <div className='flex items-center gap-x-3 flex-1 '>
                      <div className='text-2xl text-accent'>{ <FaStopwatch />}</div>
                      <div className='text-1xl'>GYM</div>
                    </div>
                    <div className='flex items-center gap-x-3 flex-1 '>
                      <div className='text-2xl text-accent'>{ <FaCocktail />}</div>
                      <div className='text-1xl'>Drinks</div>
                    </div>
              </div>
            </div>
          </div>
          {/* right */}
          <div className='w-full h-full lg:w-[40%]'>
            {/* reservation */}
            <div className='py-8 px-6  bg-accent/20 mb-12'>
              <div className='flex flex-col space-y-4 mb-4'>
                <h3>
                  Your Reservation
                </h3>
                <div className='h-[60px]'>
                  <CheckIn />
                </div>
                <div className='h-[60px]'>
                  <CheckOut />
                </div>
                <div className='h-[60px]'>
                  <AdultsDropdown />
                </div>
                <div className='h-[60px]'>
                  <KindsDropdown />
                </div>
                
              </div>
              
          <StripeCheckout
          amount={total * 100}
        token={onToken}
        stripeKey="pk_test_51OHwPjCrGIRUCSMTIKXEkqWVejJsdBFhroJvepmbM271JJ6GiP4D1Ss6dPEXQrPMqy6SHhuHliAp2l0J7HosE0yz00ScdjnLgE"
      > <Link className='btn btn-primary w-full h-[40px] text-center'>
      reserve or Book now ${total} ({stayDuration === 0 ? '1 nights' : `${stayDuration} nights`})
   
 </Link></StripeCheckout>
            </div>
           
          </div>
        </div>
      </div>
    </section>
    // to={`/reservation/${id}`} 
  )
};

export default RoomDetails;
