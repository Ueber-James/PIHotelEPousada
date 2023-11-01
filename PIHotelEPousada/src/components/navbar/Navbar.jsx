import { Link } from "react-router-dom";
import Logo from "../../assets/logo1.png";
import "../navbar/navbar.css";

function NavBar() {
  return (
    <div className="navbar">
      <div className="navContainer">
        <span className="logo">
          <a href="../../pages/home/Home">
            <img src={Logo} alt="" />
          </a>
        </span>
        <div className="navItems">
          <Link to="/signup" className="navButton">
            Register
          </Link>
          <button className="navButton">Login</button>
        </div>
      </div>
    </div>
  );
}

export default NavBar;
