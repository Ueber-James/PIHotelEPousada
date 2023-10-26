import {
  BrowserRouter,
  Routes,
  Route,
} from "react-router-dom";
import Home from "./pages/home/Home";


function App() {
  return (

    <Home />
    // <BrowserRouter>
    //   <Routes>
    //     <Route path="/" element={<Home/>}/>
       
    //   </Routes>
    // </BrowserRouter>
  );
}

export default App;