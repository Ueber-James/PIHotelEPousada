import React from 'react';
import {Swiper, SwiperSlide} from 'swiper/react';
import 'swiper/css';
import 'swiper/css/effect-fade';

import {EffectFade, Autoplay} from 'swiper';

//image
import Img1 from '../assets/img/heroSlider/1.jpg';
import Img2 from '../assets/img/heroSlider/2.jpg';
import Img3 from '../assets/img/heroSlider/3.jpg';

const slides = [
  {
    title: 'Your Luxury Hotel For Vocation',
    bg: Img1,
    bntText: 'Room & Suites'

  },
  {
    title: 'Your Luxury Hotel For Vocation',
    bg: Img2,
    bntText: 'Rooms & Suites'

  },
  {
    title: 'Your Luxury Hotel For Vocation',
    bg: Img3,
    bntText: 'Room & Suites'

  },
]



const HeroSlider = () => {
  return (
    <Swiper modules={[EffectFade, Autoplay]} effect={'fade'} 
    loop={true}
    autoplay={{
      delay: 2000,
      disableOnInteraction: false
    }}
    className='heroSlider h-[600px] lg:h-[860px] '>
      {slides.map((slide, index)=> {
        const {title, bg, bntText} = slide
        return <SwiperSlide className='h-full bg-black relative flex justify-center items-center
        ' key={index}>
          <div className='z-20 text-white text-center'>
            <div className='uppercase font-tertiary tracking-[6px] mb-5'>
              Just Enjoy and Relax
            </div>
            <h1 className='text-[32px] font-primary uppercase tracking-[2px] max-w-[920px] lg:tect-[68px] leading-tight mb-6'>{title}</h1>
          <button className=' btn btn-lg btn-primary mx-auto'>{bntText}</button>
          </div>
          <div className='absolute top-0 w-full h-full'><img className='object-cover h-full w-full' src={bg} /></div>
          <div className=' absolute w-full h-full bg-black/70'></div>
        </SwiperSlide>
      } )}
    </Swiper>
  )
};

export default HeroSlider;
