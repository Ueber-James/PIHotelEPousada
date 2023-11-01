import { Link } from "react-router-dom";
import "./signup.css";
// eslint-disable-next-line no-unused-vars

const SignUp = () => {
  return (
    <div className="signup-container">
      <div className="forms-container-signup">
        <h2>Criar conta</h2>
        <form>
          <label htmlFor="name">Nome</label>
          <input
            type="text"
            id="name"
            name="name"
            placeholder="Digite seu nome"
            required
            onChange=""
          />
          <label htmlFor="lastname">Sobrenome</label>
          <input
            type="text"
            id="lastname"
            name="lastname"
            placeholder="Digite seu nome"
            required
            onChange=""
          />
          <label htmlFor="email">Email</label>
          <input
            type="email"
            id="email"
            name="email"
            placeholder="Digite seu email"
            required
            onChange=""
          />
          <label htmlFor="password">Senha</label>
          <input
            type="password"
            id="password"
            name="password"
            placeholder="Digite sua senha"
            required
            onChange=""
          />
          <div className="confirm-password-container">
            <label htmlFor="confirmPassword">Confirme sua senha</label>
            <input
              type="password"
              id="confirmPassword"
              name="confirmPassword"
              placeholder="Digite sua senha novamente"
              required
              onChange=""
            />
          </div>

          <button
            id="buttonid"
            type="submit"
            className="custom-link formsButton"
          >
            {" "}
            Criar conta{" "}
          </button>
        </form>

        <div className="formsResgiter">
          Já tem uma conta?{" "}
          <Link to="/login" className="fomrsLink">
            <strong>Iniciar sessão</strong>
          </Link>
        </div>
      </div>
    </div>
  );
};

export default SignUp;