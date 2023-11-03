import Footer from "../../components/footer/Footer";
import NavBar from "../../components/navbar/Navbar";
import Header from "../../components/header/Header";
import React from "react";
import SignUp from "./indexsig";

// Defina a estrutura da página
const SignUpPage = () => {
  return (
    <div>
      <NavBar />
        <SignUp />
      <Footer />
    </div>
  );
};

export default SignUpPage;