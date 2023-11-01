import Header from "../../components/header/Header";
<<<<<<< HEAD
import NavBar from "../../components/navbar/Navbar";

function Home() {
  return (
    <div>
      <NavBar />
      <Header />
    </div>
  );
}
=======
import Card from "../../components/card/Card";
import Footer from "../../components/footer/Footer";
import "../home/home.css";

function Home() {


    return (
        <div>
            <NavBar />
            <Header />
            <Card/>
            <Footer />
        </div>
>>>>>>> 7583c36a09b34c897a2d82f58c32c5dc7196d5c0

    );
}

export default Home;