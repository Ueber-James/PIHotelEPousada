import React, { useState } from 'react';
import { Grid, Card, CardContent, Typography, CardActions, Button, IconButton } from "@mui/material";
import Data from '../../Data.json';
import NewData from '../../NewData.json';
import { CardActionArea } from '@mui/material';
import CardMedia from '@mui/material/CardMedia';
import VerProduto from "../VerProduto/VerProduto";
import FavoriteIcon from '@mui/icons-material/Favorite';
import FavoriteBorderIcon from '@mui/icons-material/FavoriteBorder';
import Rating from '@mui/material/Rating';
import LocationOnIcon from '@mui/icons-material/LocationOn';
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import { Link } from 'react-router-dom';
import Styles from '../card/styles.css';
import { Parallax } from 'react-parallax';


const imageDimensions = {
  width: 250,
  height: 150,
};

export default function Cards() {
  const [favorites, setFavorites] = useState([]);

  const toggleFavorite = (id) => {
    if (favorites.includes(id)) {
      setFavorites(favorites.filter(favId => favId !== id));
    } else {
      setFavorites([...favorites, id]);
    }
  };

  const handleShowOnMap = (city) => {
    const formattedCity = city.replace(/\s+/g, '+');
    const mapsUrl = `https://www.google.com/maps?q=${formattedCity}`;
    window.open(mapsUrl, '_blank');
  };

  return (
    <>
      <div style={{ marginBottom: "100px" }}>
        <Typography variant='h5' align='left' style={{ marginTop: "40px", marginLeft: "20px" }}>
          Hoteis e pousadas
        </Typography>
        <Grid container spacing={2} style={{ marginTop: "1px" }}>
          {Data.map((result, index) => (
            <Grid item xs={12} sm={6} md={3} key={index}>
              <Parallax strength={500}>
                <Card className="parallax" sx={{
                  maxWidth: "100%",
                  display: 'flex',
                  flexDirection: 'column',
                  justifyContent: 'space-between',
                  height: '100%',
                  margin: "8px",
                  position: 'relative',
                }}>
                  <CardActionArea style={{ flexGrow: 1 }}>
                    <CardMedia
                      component="img"
                      width={imageDimensions.width}
                      height={imageDimensions.height}
                      image={result.img}
                      alt="Imagem"
                      style={{ borderRadius: "5px" }}
                    />
                    <CardContent style={{ maxHeight: "100px", overflow: "hidden" }}>
                      <Typography gutterBottom variant="h5" component="div">
                        {result.title}
                      </Typography>
                      <div style={{ display: 'flex', alignItems: 'center' }}>
                        <Typography variant="body2" color="text.secondary">
                          <des /> {result.des}
                        </Typography>
                      </div>
                    </CardContent>
                  </CardActionArea>
                </Card>
              </Parallax>
            </Grid>
          ))}
        </Grid>

        <Typography variant='h5' align='left' style={{ marginTop: "130px", marginLeft: "20px" }}>
          Recomendações
        </Typography>
        <Grid container spacing={2} style={{ marginTop: "20px" }}>
          {NewData.map((result, index) => (
            <Grid item xs={12} sm={6} md={3} key={index}>
              <Parallax strength={500}>
                <Card className="parallax" sx={{
                  maxWidth: "100%",
                  display: 'flex',
                  flexDirection: 'column',
                  justifyContent: 'space-between',
                  height: '100%',
                  margin: "8px",
                  position: 'relative',
                }}>
                  <CardActionArea style={{ flexGrow: 2 }}>
                    <CardMedia
                      component="img"
                      height="140"
                      image={result.img[0]}
                      alt="hotel-image"
                      style={{ borderRadius: "5px", position: 'relative' }}
                    />
                    <CardContent>
                      <Typography gutterBottom variant="h5" component="div">
                        {result.title}
                      </Typography>
                      <div style={{ display: 'flex', alignItems: 'center' }}>
                        <Typography variant="body2" color="text.secondary">
                          <LocationOnIcon fontSize="small" /> {result.localizacao}
                        </Typography>
                        <p
                          onClick={() => handleShowOnMap(result.localizacao)}
                          style={{
                            cursor: 'pointer',
                            marginLeft: '10px',
                            color: '#1DBEB4',
                            fontWeight: 'bold',
                            textDecoration: 'none',
                          }}
                        >
                          MOSTRAR NO MAPA
                        </p>
                      </div>
                    </CardContent>
                  </CardActionArea>
                  <Button
                    onClick={() => toggleFavorite(result.id)}
                    startIcon={favorites.includes(result.id) ? <FavoriteIcon color="error" /> : <FavoriteBorderIcon />}
                    size="medium"
                    variant="outlined"
                  />
                  <CardActions style={{ justifyContent: 'space-between' }}>
                    <Rating
                      name={`rating-${result.id}`}
                      value={5}
                      readOnly
                    />
                    <Link to={`/detalhe-do-produto/${result.id}`}>
                      <Button
                        variant="contained"
                        size="large"
                        startIcon={<ShoppingCartIcon />}
                        style={{ marginTop: '16px' }}
                      >
                        Mais Informações
                      </Button>
                    </Link>
                  </CardActions>
                  {index >= Data.length - 4 && (
                    <div style={{
                      position: 'absolute',
                      top: '10px',
                      right: '10px',
                      backgroundColor: '#1DBEB4',
                      color: 'white',
                      padding: '8px',
                      borderRadius: '8px',
                      fontSize: '16px',
                      zIndex: 1,
                    }}>
                      <h4 style={{ margin: 0 }}>10</h4>
                    </div>
                  )}
                </Card>
              </Parallax>
            </Grid>
          ))}
        </Grid>
        <VerProduto />
      </div>
    </>
  );
}
