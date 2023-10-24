import styles from "././Form.module.css";
import { useState,useContext } from "react";
import { useNavigate } from "react-router-dom";
import { dhOdontoContextProvider } from "../../contexts/dhOdontoContext";

import { api } from './../../services/api';


const LoginForm = () => {
  const { listaDePerfis, addUsuarioALista } = useContext(dhOdontoContextProvider);
    const [usuarioASerBuscado, setUsuarioASerBuscado] = useState('');
  const handleSubmit = async(e) => {
    e.preventDefault(); //Nesse handlesubmit você deverá usar o preventDefault,
    
    if (usuarioASerBuscado.length > 0) {
      try {
        const response = await api.get(`/users/${usuarioASerBuscado}`);
        addUsuarioALista(response.data);
      } catch (error) {
        if (error.response.data.message === "Not Found") {
          alert('Usuário não encontrado')
        }
      }
    }
    else {
      alert('Campo de pesquisa deve ser preenchido.')
    }
  }

    //enviar os dados do formulário e enviá-los no corpo da requisição 
    //para a rota da api que faz o login /Path
  
         //lembre-se que essa rota vai retornar um Bearer Token e o mesmo deve ser salvo
      //no localstorage para ser usado em chamadas futuras
    //Com tudo ocorrendo corretamente, o usuário deve ser redirecionado a página principal,com react-router
    //message Lembre-se de usar um alerta para dizer se foi bem sucedido ou ocorreu um erro


  return (
    <>
      {/* //Na linha seguinte deverá ser feito um teste se a aplicação
        // está em dark mode e deverá utilizar o css correto */}
      <div
        className={`text-center card container ${styles.card}`}
      >
        <div className={`card-body ${styles.CardBody}`}>
          <form onSubmit={handleSubmit}>
            <input
              className={`form-control ${styles.inputSpacing}`}
              placeholder="Login"
              name="login"
              onChange={(event) => setUsuarioASerBuscado(event.target.value)}
              value={usuarioASerBuscado}
              required
            />
            <input
              className={`form-control ${styles.inputSpacing}`}
              placeholder="Password"
              name="password"
              type="password"
              onChange={(event) => setUsuarioASerBuscado(event.target.value)}
              value={usuarioASerBuscado}
              required
            />
            <button className="btn btn-primary" type="submit">
            {listaDePerfis && (
              listaDePerfis.map(perfil => {
                return (
                  <Link key={perfil.id} to={`/${perfil.login}`}>
                    <card perfil={perfil} />
                  </Link>
                )
              }))
            }
              Send
            </button>
          </form>
        </div>
      </div>
    </>
  );
};

export default LoginForm;
