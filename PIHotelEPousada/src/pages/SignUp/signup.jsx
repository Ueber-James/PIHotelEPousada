import React from "react";
import ErrorBoundary from "../../components/Error/ErrorBoundary";
import SignUp from "../SignUp/index";

const SignUpPage = () => {
  return (
    <>
      <h1>Cadastre-se</h1>
      <ErrorBoundary>
        <SignUp />
      </ErrorBoundary>
      {/* Aqui você pode adicionar o formulário de cadastro */}
    </>
  );
};

export default SignUpPage;
