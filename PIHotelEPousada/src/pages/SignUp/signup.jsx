<<<<<<< HEAD
// Importe os componentes necessários
import Footer from "../../components/footer/Footer";
import NavBar from "../../components/navbar/Navbar";
import Header from "../home/Home";
=======
import React from "react";
import ErrorBoundary from "../../components/Error/ErrorBoundary";
import SignUp from "../SignUp/index";
>>>>>>> 7583c36a09b34c897a2d82f58c32c5dc7196d5c0

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
