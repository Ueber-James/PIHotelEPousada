import { Grid, Card, CardContent, Typography, CardActions, Button } from "@mui/material";
import Data from '../../Data.json';
import { CardActionArea } from '@mui/material';
import CardMedia from '@mui/material/CardMedia';

export default function Cards() {
  return (
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
    </div>
  )
}