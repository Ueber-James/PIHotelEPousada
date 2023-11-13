import {
  BrowserRouter,
  Routes,
  Route,
} from "react-router-dom";
import Home from "./pages/home/Home";
import Login from "./pages/login/Login";
import Singup from "./pages/singup/Sign";
import VerProduto from "./components/VerProduto/VerProduto";

function App() {
  return (

    // <Home />
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />}/>
        <Route path="/login" element={<Login />} />
        <Route path="/singup" element={<Singup />} />
        <Route path="/detalhe-do-produto/:id" element={<VerProduto />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;