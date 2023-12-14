import React, { useContext } from 'react';
import {Link, useParams } from 'react-router-dom';
import {
  FaMapMarkedAlt
} from 'react-icons/fa';

import AdultsDropdown from '../components/AdultsDropdown'
import KindsDropdown from '../components/KidsDropdown'
import CheckIn from '../components/CheckIn'
import CheckOut from '../components/CheckOut'

import ScrollToTop from '../components/ScrollToTop'

import { RoomContext } from '../context/RoomContext';

import { FaCheck } from 'react-icons/fa';

const RoomDetails = () => {
  const { rooms } = useContext(RoomContext);
  const { id } = useParams();
  const room = rooms.find((room) => {
    return room.id === Number(id);
  })

  const handleMapClick = () => {
    // Use window.open() to open Google Maps in a new tab
    const googleMapsUrl = `https://www.google.com/maps?q=${endereco},${pais}`;
    window.open(googleMapsUrl, '_blank');
  };

  const { name, description, facilities, imageLg, price, pais, endereco } = room;
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
      <div className='container mx-auto'>
        <div className='flex flex-col lg:flex-row h-full py-24'>
          {/* left */}
          <div className='w-full h-full lg:w-[60%]  px-6'>
            <h2 className=' h2'>{name}</h2>
            <p className='mb-8'>{description}</p>
            <img className='mb-8' src={imageLg} />
            {/* facilities */}
            <div className='mb-12'>
              <h3 className='h3 mb-3'>Romm Faciities</h3>
              <p className='mb-12'>Lorem Ipsum is simply dummy text of the p</p>
              {/* grid */}
              <div className='grid grid-cols-3 gap-6 mb-12'>

                {facilities.map((item, index) => {
                  const { name, icon } = item;
                  return (
                    <div className='flex items-center gap-x-3 flex-1 ' key={index}>
                      <div className='text-3xl text-accent'>{icon}</div>
                      <div className='text-3xl'>{name}</div>
                    </div>)
                })}
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
              <Link to={`/reservation/${id}`} className='btn btn-primary w-full h-[40px]'>
            Book now for ${price}
          </Link>
            </div>
           
          </div>
        </div>
      </div>
    </section>
  )
};

export default RoomDetails;