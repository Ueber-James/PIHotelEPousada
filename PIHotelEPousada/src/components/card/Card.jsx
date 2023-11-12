import { Grid, Card, CardContent, Typography, CardActions, Button } from "@mui/material";
import Data from '../../Data.json';
import { CardActionArea } from '@mui/material';
import CardMedia from '@mui/material/CardMedia';
import "./card.css"

export default function Cards() {

 
  return (
    <>
    <div style={{ marginBottom: "100px" }}>
      <Typography variant='h4' align='center' style={{ marginTop: "50px" }}>

        Hoteis e pousadas
      </Typography>
      <Grid container spacing={2} style={{ marginTop: "20px" }}>
        {Data.map((result, index) => (
          <Grid item xs={12} sm={6} md={3} key={index}>
            <Card sx={{
              maxWidth: "100%",
              display: 'flex',
              flexDirection: 'column',
              justifyContent: 'space-between',
              height: '100%',
              margin: "8px"
            }}>
              <CardActionArea style={{ flexGrow: 1 }}>
                <CardMedia
                  component="img"
                  height="140"
                  image={result.img}
                  alt="green iguana"
                  style={{ borderRadius: "5px" }}
                />
                <CardContent>
                  <Typography gutterBottom variant="h5" component="div">
                    {result.title}
                  </Typography>
                  <Typography variant="body2" color="text.secondary">
                    {result.des}
                  </Typography>
                </CardContent>
              </CardActionArea>
              <CardActions>
                <Button variant="contained" size="medium">
                  Saiba mais
                </Button>
              </CardActions>
            </Card>
          </Grid>
        ))}
      </Grid>

    <div className="product-list">
    <div className="product-card">
    <div className="product-image">
      <img src="https://ideiasnamala.com/wp-content/uploads/2020/06/Chez-Louise-et-Louis-e1593024038997.jpg.webp" alt="" />
    </div>
    <div className="product-details">
      <div className="product-info">
        <div className="hotel-nome">hotel 1</div>
        <div className="hotel-localizacao"> sao bernarso do campo</div>
        <div className="hotel-categoria">luxo</div>
        <div className="hotel-descricao"> ddddddd</div>
        <button className="view-details-button">View Details</button>
      </div>
      
    </div>
  </div>
  
  
  <div className="product-card">
  <div className="product-image">
    <img src="https://ideiasnamala.com/wp-content/uploads/2020/06/Chez-Louise-et-Louis-e1593024038997.jpg.webp" alt="" />
  </div>
  <div className="product-details">
    <div className="product-info">
      <div className="hotel-nome">hotel 1</div>
      <div className="hotel-localizacao"> sao bernarso do campo</div>
      <div className="hotel-categoria">luxo</div>
      <div className="hotel-descricao"> ddddddd</div>
      <button className="view-details-button">View Details</button>
    </div>
    
  </div>
</div>
<div className="product-card">
  <div className="product-image">
    <img src="https://ideiasnamala.com/wp-content/uploads/2020/06/Chez-Louise-et-Louis-e1593024038997.jpg.webp" alt="" />
  </div>
  <div className="product-details">
    <div className="product-info">
      <div className="hotel-nome">hotel 1</div>
      <div className="hotel-localizacao"> sao bernarso do campo</div>
      <div className="hotel-categoria">luxo</div>
      <div className="hotel-descricao"> ddddddd</div>
      <button className="view-details-button">View Details</button>
    </div>
    
  </div>
</div>
<div className="product-card">
  <div className="product-image">
    <img src="https://ideiasnamala.com/wp-content/uploads/2020/06/Chez-Louise-et-Louis-e1593024038997.jpg.webp" alt="" />
  </div>
  <div className="product-details">
    <div className="product-info">
      <div className="hotel-nome">Hermitage Hotel</div>
      <div className="hotel-localizacao"> A 940 m do centro - MOSTRAR NO MAPA</div>
      <div className="hotel-categoria">luxo</div>
      <div className="hotel-descricao"> No coração de San Telmo, desfrute de uma pousada inspirada nas paixões de Buenos Aires. mais...</div>
      <button className="view-details-button">Ver mais</button>
    </div>
    
  </div>
</div>
</div>
</div>

    </>


  

  )
}