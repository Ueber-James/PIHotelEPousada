import  { useState } from 'react';

import './login.css';
import axios from 'axios';

 function Login() {
  const [formData, setFormData] = useState({
    email: '',
    password: '',
  });

  const [error, setError] = useState('');

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post("http://localhost:9000/authentication/sign-in", formData);

      // Verifique a resposta do servidor para determinar se o login foi bem-sucedido
      if (response.data.success) {
        localStorage.setItem('currentUser', JSON.stringify(response.data.user) )
        window.location.href = '/';
      } else {
        setError('Credenciais inválidas. Tente novamente.');
      }
    } catch (error) {
      console.error('Erro ao fazer login:', error);
      setError('Erro ao fazer login. Tente novamente mais tarde.');
    }
  };

  return (
    <div>
     
      <div className="app">
        <main className="main">
          <div className="center-container">
            <h1>Iniciar sessão</h1>
            <form onSubmit={handleSubmit}>
              <div className="form-group">
                <label htmlFor="email">E-mail:</label>
                <input
                  type="email"
                  id="email"
                  name="email"
                  value={formData.email}
                  onChange={handleChange}
                />
              </div>
              <div className="form-group">
                <label htmlFor="password">Password:</label>
                <input
                  type="password"
                  id="password"
                  name="password"
                  value={formData.password}
                  onChange={handleChange}
                />
              </div>
              {error && <div className="error-message">{error}</div>}
              <button className=' btn btn-lg btn-primary mx-auto'>Login</button>
              
            </form>
            <h5>Ainda não tem conta? <a href="/singup">Registre-se</a> </h5>
          </div>
        </main>
      </div>
      
    </div>
  );
}

export default Login;
