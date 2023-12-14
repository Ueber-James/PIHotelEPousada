import { useState } from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import "./sing.css";

const SignUp = () => {


  const [formData, setFormData] = useState({
    nome: "",
    sobrenome: "",
    email: "",
    password: "",
    confirmPassword: "",
    role: "USER",
  });

  const [successMessage, setSuccessMessage] = useState("");
  const [errorMessage, setErrorMessage] = useState("");



  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };


  const handleSuccess = () => {
    setSuccessMessage("Cadastro realizado com sucesso");
    setFormData({
      nome: "",
      sobrenome: "",
      email: "",
      password: "",
      confirmPassword: "",
      role: "USER",
    });
    setErrorMessage("");
    setTimeout(() => {
      window.location.href = "/login"; // Você pode alterar a URL de redirecionamento conforme necessário
    }, 500);
  };

  const handleError = (error) => {
    setErrorMessage("Erro ao cadastrar usuário: " + error.message);
    setSuccessMessage("");

  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (formData.password !== formData.confirmPassword) {
      alert("As senhas não coincidem.");
      return;
    }

    try {
      const response = await axios.post("http://localhost:9000/authentication/sign-up", {
        nome: formData.nome,
        email: formData.email,
        senha: formData.password,
      });

      console.log("Cadastro realizado com sucesso:", response.data);
      handleSuccess();
    } catch (error) {
      console.error("Erro ao cadastrar usuário:", error);
      handleError(error);
    }
  };

  return (
    <div className="signup-container">
      <div className="forms-container-signup">
        <h1>Criar conta</h1>
        <form onSubmit={handleSubmit}>
          <label htmlFor="name">Nome</label>
          <input
            type="text"
            id="name"
            name="name"
            placeholder="Digite seu nome"
            required
            value={formData.name}
            onChange={handleChange}
          />
          <label htmlFor="lastname">Sobrenome</label>
          <input
            type="text"
            id="lastname"
            name="lastname"
            placeholder="Digite seu sobrenome"
            required
            value={formData.lastname}
            onChange={handleChange}
          />
          <label htmlFor="email">Email</label>
          <input
            type="email"
            id="email"
            name="email"
            placeholder="Digite seu email"
            required
            value={formData.email}
            onChange={handleChange}
          />
          <label htmlFor="password">Senha</label>
          <input
            type="password"
            id="password"
            name="password"
            placeholder="Digite sua senha"
            required
            value={formData.password}
            onChange={handleChange}
          />
          <div className="confirm-password-container">
            <label htmlFor="confirmPassword">Confirme sua senha</label>
            <input
              type="password"
              id="confirmPassword"
              name="confirmPassword"
              placeholder="Digite sua senha novamente"
              required
              value={formData.confirmPassword}
              onChange={handleChange}
            />
          </div>

          <button id="buttonid" type="submit" className="custom-link btn btn-lg btn-primary mx-auto">
            {" "}
            Criar conta{" "}
          </button>
        </form>
        {successMessage && <div className="success-message">{successMessage}</div>}
        {errorMessage && <div className="error-message">{errorMessage}</div>}
        <h5 className="formsResgiter">
          Já tem uma conta?{" "}
          <Link to="/login" className="fomrsLink">
            <strong>Iniciar sessão</strong>
          </Link>
        </h5>
      </div>
    </div>
  );
};

export default SignUp;
