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
