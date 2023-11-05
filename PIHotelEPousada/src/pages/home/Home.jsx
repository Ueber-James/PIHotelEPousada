import Card from "../../components/card/Card";
import Footer from "../../components/footer/Footer";
import Header from "../../components/header/Header";
import NavBar from "../../components/navbar/Navbar";
import "../home/home.css";

function Home() {
  return (
    <div>
      <NavBar />
      <Header />
      <Card />
      <Footer />
    </div>
  );
}

export default Home;
