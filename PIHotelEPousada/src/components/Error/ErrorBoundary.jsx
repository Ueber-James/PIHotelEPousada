/* eslint-disable react/prop-types */
import { Component } from "react";

class ErrorBoundary extends Component {
  constructor(props) {
    super(props);
    this.state = { hasError: false };
  }

  componentDidCatch(error, info) {
    // Você pode personalizar o tratamento de erros aqui, por exemplo, exibindo uma mensagem amigável
    this.setState({ hasError: true });
  }

  render() {
    if (this.state.hasError) {
      // Renderize uma mensagem de erro amigável ou outra ação apropriada
      return <p>Ops! Algo deu errado.</p>;
    }
    return this.props.children;
  }
}

export default ErrorBoundary;
