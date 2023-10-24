import styles from "././Card.module.css";

const Card = () => {
  const listaDeDentist = [
    {
      userName:'deyse',
      image:'https://github.com/deysebonisegnia.png'
    }
  ]

  return (
    <>
      {/* //Na linha seguinte deverá ser feito um teste se a aplicação
        // está em dark mode e deverá utilizar o css correto */}
      <div className={`card`}>
        <img
          className="card-img-top"
          src="/images/doctor.jpg"
          alt="doctor placeholder"
        />
        <div className={`card-body ${styles.CardBody}`}>
        {listaDeDentist && (
            listaDeDentist.map((Dentist, index) => {
              return (
                <Dentist key={index} Dentist={Dentist} />
                <User key={index} user={usuario} />
              )
            })
          )}
          <a href={`/dentist/MatriculaDoDentista`}>
            <h5 className={`card-title ${styles.title}`}>Nome e Sobrenome do dentista</h5>
          </a>
        </div>
      </div>
    </>
  );
};

export default Card;
