import { useEffect, useState,useContext } from "react";
import Card from "../card/Card";
import { dhOdontoContextProvider } from "../../contexts/dhOdontoContext";


const Home = () => {
  
  const { listaDePerfis, addUsuarioALista } = useContext(dhOdontoContextProvider);

  const [usuarioASerBuscado, setUsuarioASerBuscado] = useState('');
  
  useEffect(() => {
    //Nesse useEffect, deverá ser obtido todos os dentistas da API
    //Armazena-los em um estado para posteriormente fazer um map
    //Usando o componente <Card />
  }, []);

  return (
    <>
      <h1>Home</h1>
      <div className="card-grid container">
        <Card />
      </div>
    </>
  );
};

export default Home;
