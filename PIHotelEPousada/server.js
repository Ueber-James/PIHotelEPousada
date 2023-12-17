const express = require('express');
const app = express();
const port = 3001;


app.get('/api/reservations/:userId', (req, res) => {
  const userId = req.params.userId;

  
  res.json();
});