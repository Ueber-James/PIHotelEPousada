import { Grid, Card, CardContent, Typography, CardActions, Button } from "@mui/material";
import Container from "@mui/material/Container";
import Data from '../../Data.json';
import { CardActionArea } from '@mui/material';
import CardMedia from '@mui/material/CardMedia';
import "./card.css"

export default function Cards() {
  
  return(
    <>
    <Container maxWidth="lg">
      <Typography variant='h4' align='center' style={{marginTop:"50px"}}>
        Hoteis e pousadas
      </Typography>
      <Grid container spacing={5} style={{marginTop:"20px"}}>
        {Data.map((result, index)=>(
          <Grid item xs={12} sm={4} ms={4} key={index}>
            <Card sx={{ maxWidth: 345 }} style={{padding:"10px", marginBottom:"30px"}}>
      <CardActionArea>
        <CardMedia
          component="img"
          height="140"
          image={result.img}
          alt="green iguana"
          style={{borderRadius:"5px"}}
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
    </Container>
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
    </>

  )
}