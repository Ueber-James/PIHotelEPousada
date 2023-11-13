import { useParams } from 'react-router-dom';
import Data from '../../Data.json';
import NavBar from "../../components/navbar/Navbar";
import Header from "../../components/header/Header";
import Footer from "../../components/footer/Footer";
import ProdutoDetalhesCard from '../../components/VerProduto/ProdutoDetalhesCard';

const VerProduto = () => {
  const { id } = useParams();
  const produto = Data.find((item) => item.id === parseInt(id));

  if (!produto) {
    return;
  }

  return (
    
    <div>
      <NavBar />
      <Header />      
      <ProdutoDetalhesCard/>
      <Footer />
      
    </div>
  );
};

export default VerProduto;

