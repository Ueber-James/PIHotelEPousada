import React from 'react';
import { Link } from 'react-router-dom';
import NavBar from "../../components/navbar/Navbar";
import Footer from "../../components/footer/Footer";
import './login.css';

function Login() {
  return (
    <div>  
      <NavBar />
    <div className="app">
      <main className="main">
        <div className="center-container">
          <h1>Iniciar sessão</h1>
          <form>
            <div className="form-group">
              <label htmlFor="username">E-mail:</label>
              <input type="email" id="email" name="email" />
            </div>
            <div className="form-group">
              <label htmlFor="password">Password:</label>
              <input type="password" id="password" name="password" />
            </div>
            <button type="submit" className="button">Login</button>
          </form>
          <h5>Ainda não tem conta? <Link to="/singup">Registre-se</Link> </h5>
        </div>
      </main>
      
      </div>
      <Footer />
    </div>
  );
}

export default Login;
