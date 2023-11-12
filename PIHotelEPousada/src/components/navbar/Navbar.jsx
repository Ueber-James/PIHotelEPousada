import React from 'react';
import { Link } from 'react-router-dom';
import "../navbar/navbar.css"
import Logo from "../../assets/logo2.jpg";


function getRandomColor() {
  const letters = '0123456789ABCDEF';
  let color = '#';
  for (let i = 0; i < 6; i++) {
    color += letters[Math.floor(Math.random() * 16)];
  }
  return color;
}

function NavBar() {
  const currentUser = JSON.parse(localStorage.getItem('currentUser'));

  const handleLogout = () => {
    // Implemente a lógica de logout aqui
    // Por exemplo, você pode limpar os dados do usuário no localStorage
    localStorage.removeItem('currentUser');
    // Em seguida, redirecione o usuário para a página de login ou outra página desejada
    window.location.href = '/';
  };

  return (
    <div className="navbar">
      <div className="navContainer">
        <Link to="/" className="logo"><a Link to="/"><img src={Logo} alt="" /></a></Link>
        <div className="navItems">
          {currentUser ? (
            <>
             <div className="userContainer">
                <div className="userCircle" style={{ backgroundColor: getRandomColor() }}>
                  {currentUser.nome.charAt(0)}
                </div>
                <button className="navButton" onClick={handleLogout}>Logout</button>
              </div>
             
            </>
            
          ) : (
            <>
              <Link to="/singup" className="navButton">Register</Link>
              <Link to="/login" className="navButton">Login</Link>
            </>
          )}
        </div>
      </div>
    </div>
  );
}

export default NavBar;
