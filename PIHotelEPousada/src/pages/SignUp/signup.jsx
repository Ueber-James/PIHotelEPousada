// Importe os componentes necessários
import Footer from "../../components/footer/Footer";
import NavBar from "../../components/navbar/Navbar";
import Header from "../home/Home";

import SignUp from "../signUp/Index";
// Defina a estrutura da página
const SignUpPage = () => {
  return (
    <div>
      <NavBar />
      <Header />
      <main className="main-content">
        <SignUp />
      </main>
      <Footer />
    </div>
  );
};

export default SignUpPage;
