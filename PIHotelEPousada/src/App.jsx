<<<<<<< HEAD
import { BrowserRouter, Route, Routes } from "react-router-dom";
import SignUp from "../src/components/signUp/Index";
import ErrorBoundary from "./components/Error/ErrorBoundary";
import Home from "./pages/home/Home";

function App() {
  return (
    // <Home />
    <div>
      <ErrorBoundary>
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/signup" element={<SignUp />} />
          </Routes>
        </BrowserRouter>
      </ErrorBoundary>
    </div>
  );
}

export default App;
=======
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
>>>>>>> 7583c36a09b34c897a2d82f58c32c5dc7196d5c0
