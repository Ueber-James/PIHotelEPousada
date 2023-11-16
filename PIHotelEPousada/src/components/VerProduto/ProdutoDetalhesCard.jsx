import { useParams } from 'react-router-dom';
import Slider from 'react-slick';
import {  Card,  CardContent,  Typography,  CardMedia,  Button,  Box,} from '@mui/material';
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import 'slick-carousel/slick/slick.css';
import 'slick-carousel/slick/slick-theme.css';
import NewData from '../../NewData.json';

const ProdutoDetalhesCard = () => {
  const { id } = useParams();
  const product = NewData.find((item) => item.id === parseInt(id));

  if (!product) {
    return <div>Produto não encontrado</div>;
  }

  const settings = {
    dots: true,
    infinite: true,
    speed: 500,
    slidesToShow: 1,
    slidesToScroll: 1,
  };

  return (
    <Box
      display="flex"
      flexDirection="column"
      alignItems="center"
      justifyContent="center"
      minHeight="80vh"
      paddingBottom="16px"
    >
      <Card
        sx={{
          maxWidth: 800,
          width: '80%',
          padding: '16px',
          borderRadius: '8px',
        }}
      >
        <Slider {...settings}>
          {product.img.map((image, index) => (
            <CardMedia
              key={index}
              component="img"
              height="300"
              image={image}
              alt={product.title}
              style={{ borderRadius: '8px' }}
            />
          ))}
        </Slider>
        <CardContent>
          <Typography gutterBottom variant="h5" component="div">
            {product.title}
          </Typography>
          <Typography variant="body2" color="text.secondary">
            {product.des}
          </Typography>
        </CardContent>
        <Button
          variant="contained"
          size="large"
          startIcon={<ShoppingCartIcon />}
          onClick={() => alert('Reservar')}
          style={{ marginTop: '16px' }}
        >
          Reservar
        </Button>
      </Card>
    </Box>
  );
};

export default ProdutoDetalhesCard;
