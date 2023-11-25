import React, {useState, useEffect} from 'react';
import '../pages/login/login.css'

// logo

import Logowhite from '../assets/img/logo-white.svg'
import LogoDark from '../assets/img/logo-dark.svg'


const Header = () => {
  const currentUser = JSON.parse(localStorage.getItem('currentUser'));

  const handleLogout = () => {
    // Implemente a lógica de logout aqui
    // Por exemplo, você pode limpar os dados do usuário no localStorage
    localStorage.removeItem('currentUser');
    // Em seguida, redirecione o usuário para a página de login ou outra página desejada
    window.location.href = '/';
  };

  const [header, setHeader] = useState(false);
  useEffect(()=> {
    window.addEventListener('scroll', ()=> {
      window.scrollY > 50 ? setHeader (true) : setHeader(false);
    })
  })
  return <header className={`${ header ? 'bg-white py-6 shadow-lg' : 'bg-transparent py-8'} fixed z-50 w-full transition-all duration-300`}>
<div className='container mx-auto flex flex-col items-center gap-y-6 lg:flex-row lg:justify-between lg:gap-y-0'>
{/* logo */}
<a href='/'> 
{header ?( <img className='w-[160px]' src={LogoDark} />) : (<img className='w-[160px]' src={Logowhite} />)}
</a>

<nav className={`${header ? 'text-primary' : ' text-white' } flex gap-x-4 lg:gap-x-8 font-tertiary 
tracking-[3px] text=[15px]  items-center uppercase `}>
  
  {currentUser ? (
          <>
            <div className="userContainer">
              <div className="userCircle" style={{ backgroundColor:'black' }}>
                {currentUser.nome.charAt(0)}                 </div>
              <button className="navButton 'hover:text-accent transition" onClick={handleLogout}>Logout</button>
            </div>

          </>

        ) : (
          <>
            <a href='/login' className='hover:text-accent transition text-primary'>singin</a>
            <a href='/singup' className='hover:text-accent transition text-primary'>singup</a>
          </>
        )}
</nav>
</div>
  </header>
};

export default Header;
