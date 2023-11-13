import { useParams } from 'react-router-dom';
import { Card, CardContent, Typography, CardMedia, Button, Box } from '@mui/material';
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import NewData from '../../NewData.json';

const ProdutoDetalhesCard = () => {
  const { id } = useParams();
  const product = NewData.find(item => item.id === parseInt(id));

  if (!product) {
    return <div>Produto não encontrado</div>;
  }

  return (
    <Box
      display="flex"
      flexDirection="column"
      alignItems="center"
      justifyContent="center"
      minHeight="80vh"
      paddingBottom="16px"
    >
      <Card sx={{ maxWidth: 800, width: '80%', padding: '16px', borderRadius: '8px' }}>
        <CardMedia
          component="img"
          height="300"
          image={product.img}
          alt={product.title}
          style={{ borderRadius: '8px' }}
        />
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
