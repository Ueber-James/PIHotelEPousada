import { useEffect,useCallback,useState} from "react";
import ScheduleFormModal from "../form/ScheduleFormModal";
import styles from "./DetailCard.module.css";

const  DetailCard = () => {

  const [perfilNormalizado, setPerfilNormalizado] = useState({})

  const usuarioNormalizado = useCallback(() => {
    setPerfilNormalizado({
      login: perfil.login,
      imgUrl: perfil.avatar_url,
      sobrenome:perfil.sobrename,
      nome: perfil.name ? perfil.name : perfil.login
    })
  }, [perfil.avatar_url, perfil.login, perfil.name]);

  useEffect(() => {
    //Nesse useEffect, você vai fazer um fetch na api passando o 
    //id do dentista que está vindo do react-router e carregar os dados em algum estado
    usuarioNormalizado();
  }, [usuarioNormalizado])

  return (
    //As instruções que estão com {''} precisam ser 
    //substituídas com as informações que vem da api
    <>
      <h1>Detail about Dentist {'Nome do Dentista'} </h1>
      <section className="card col-sm-12 col-lg-6 container">
        {/* //Na linha seguinte deverá ser feito um teste se a aplicação
        // está em dark mode e deverá utilizar o css correto */}
        <div
          className={`card-body row`}
        >
          <div className="col-sm-12 col-lg-6">
            <img
              className="card-img-top"
              src={perfilNormalizado.imgUrl}
              alt={`Imagem do usuário ${perfilNormalizado.nome}`}
            />
          </div>
          <div className="col-sm-12 col-lg-6">
            <ul className="list-group">
              <li className="list-group-item">Nome: '{perfilNormalizado.nome}'</li>
              <li className="list-group-item">
                Sobrenome: {perfilNormalizado.sobrename}'
              </li>
              <li className="list-group-item">
                Usuário: '{perfilNormalizado.nome}'
              </li>
            </ul>
            <div className="text-center">
              {/* //Na linha seguinte deverá ser feito um teste se a aplicação
              // está em dark mode e deverá utilizado o css correto */}
              <button 
                data-bs-toggle="modal"
                data-bs-target="#exampleModal"
                className={`btn btn-light ${styles.button
                  }`}
                  
              >
                Marcar consulta
              </button>
            </div>
          </div>
        </div>
      </section>
      <ScheduleFormModal />
    </>
  );
};

export default DetailCard;
