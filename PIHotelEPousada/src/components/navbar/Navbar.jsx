<<<<<<< HEAD
import { Link } from "react-router-dom";
import Logo from "../../assets/logo1.png";
import "../navbar/navbar.css";
=======
import React from 'react';
import { Link } from 'react-router-dom';
import "../navbar/navbar.css"
import Logo from "../../assets/logo2.jpg";

>>>>>>> 7583c36a09b34c897a2d82f58c32c5dc7196d5c0

function NavBar() {
  return (
    <div className="navbar">
<<<<<<< HEAD
      <div className="navContainer">
        <span className="logo">
          <a href="../../pages/home/Home">
            <img src={Logo} alt="" />
          </a>
        </span>
        <div className="navItems">
          <Link to="/signup" className="navButton">
            Register
          </Link>
          <button className="navButton">Login</button>
        </div>
=======
    <div className="navContainer">
      <Link to="/" className="logo"><a Link to="/"><img src={Logo} alt="" /></a></Link>
      <div className="navItems">
      <Link to="/SingUp" className="navButton">Register</Link>
        <Link to="/login" className="navButton">Login</Link>
>>>>>>> 7583c36a09b34c897a2d82f58c32c5dc7196d5c0
      </div>
    </div>
  );
}

export default NavBar;
<<<<<<< HEAD
=======



>>>>>>> 7583c36a09b34c897a2d82f58c32c5dc7196d5c0
