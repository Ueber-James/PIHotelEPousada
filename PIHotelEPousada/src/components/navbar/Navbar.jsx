import "../navbar/navbar.css"
import Logo from "../../assets/logo1.png";

function NavBar() {
  return (
    <div className="navbar">
    <div className="navContainer">
      <span className="logo"><img src={Logo} alt="" /></span>
      <div className="navItems">
        <button className="navButton">Register</button>
        <button className="navButton">Login</button>
      </div>
    </div>
  </div>
  );
}

export default NavBar;