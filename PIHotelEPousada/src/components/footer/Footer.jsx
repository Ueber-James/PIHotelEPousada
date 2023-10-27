import "./footer.css";

import Face from "../../assets/footer/iconfacebook.png"
import Ig from "../../assets/footer/iconig.png"
import Link from "../../assets/footer/iconlinkedin.png"
import Twitter from "../../assets/footer/twitter.png"

const Footer = () => {
  return (
    <div className="footer">
      
      <div className="fText">Copyright © 2022 Lamabooking.</div>

      <div className="Ficons ">
        <div className="fLists">
        <img className="fList " src={Face} alt="facebook" />
        <img className="fList " src={Ig} alt="instagran" />
        <img className="fList " src={Link} alt="linkedin" />
        <img className="fList " src={Twitter} alt="twitter" />
        </div>
        </div>
    </div>
  );
};

export default Footer;
