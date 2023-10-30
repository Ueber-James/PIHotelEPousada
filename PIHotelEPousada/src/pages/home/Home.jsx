import NavBar from "../../components/navbar/Navbar";
import Header from "../../components/header/Header";
import Card from "../../components/card/Card";


function Home() {


    return (
        <div>
            <NavBar />
            <Header />
            <div>
                <Card/>
            </div>
        </div>
    );
}

export default Home;