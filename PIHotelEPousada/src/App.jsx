
import {
    BrowserRouter,
    Routes,
    Route,
  } from "react-router-dom";
  import Home from "./pages/home/Home";
  import Login from "./pages/login/Login";
  import SingUp from "./pages/SignUp/signup";

  
  
  function App() {
    return (
  
      // <Home />
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Home />}/>
          <Route path="/login" element={<Login />} />
          <Route path="/singup" element={<SingUp />} />
         
        </Routes>
      </BrowserRouter>
    );
  }
  
  export default App;

