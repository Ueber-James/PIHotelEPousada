import {
  BrowserRouter,
  Routes,
  Route,
} from "react-router-dom";
import Home from "./pages/home/Home";
import Login from "./pages/login/Login";
import Singup from "./pages/singup/Sign";


function App() {
  return (

    // <Home />
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />}/>
        <Route path="/login" element={<Login />} />
        <Route path="/singup" element={<Singup />} />
       
      </Routes>
    </BrowserRouter>
  );
}

export default App;