
import React from "react";
import ErrorBoundary from "../../components/Error/ErrorBoundary";
import SignUp from "../SignUp/index";

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
