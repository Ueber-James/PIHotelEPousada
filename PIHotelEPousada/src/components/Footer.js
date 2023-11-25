import React from 'react';
import Face from "../assets/img/iconfacebook.svg"
import Ig from "../assets/img/iconig.svg"
import Link from "../assets/img/iconlinkedin.svg"
import Twitter from "../assets/img/twitter.svg"


const Footer = () => {
  return (
    <footer className='bg-primary py-12 '>
      <div className='container mx-auto text-white flex justify-between'>
        Copyright © 2022 Lamabooking.
<div className="flex justify-between w-[150px] " >
<img  src={Face} alt="facebook" />
        <img className="fList " src={Ig} alt="instagran" />
        <img className="fList " src={Link} alt="linkedin" />
        <img className="fList " src={Twitter} alt="twitter" />
</div>
       
      </div>
    </footer>
  )
};

export default Footer;
