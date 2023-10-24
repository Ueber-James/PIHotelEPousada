
import { Outlet } from "react-router-dom";
import Footer from "./Components/layout/Footer";
import Navbar from "./Components/layout/Navbar";



function App() {
  
  return (
    <>
      {/* //Na linha seguinte deverá ser feito um teste se a aplicação
        // está em dark mode e deverá utilizar a classe dark ou light */}
        
      <div className={`app light}`} >


        <Navbar />
        <main>
          <Outlet />
        </main>
        <Footer />
      </div>
    </>
  );
}

export default App;
import { RouteList } from './routes';

export function App() {
  return (
    <RouteList />
  )
}