import React from 'react';
import { Link } from 'react-router-dom';
import "../navbar/navbar.css"
import Logo from "../../assets/logo2.jpg";


function NavBar() {
  return (
    <div className="navbar">
    <div className="navContainer">
      <Link to="/" className="logo"><a Link to="/"><img src={Logo} alt="" /></a></Link>
      <div className="navItems">
      <Link to="/login" className="navButton">Register</Link>
        <Link to="/login" className="navButton">Login</Link>
      </div>
    </div>
  </div>
  );
}

export default NavBar;



