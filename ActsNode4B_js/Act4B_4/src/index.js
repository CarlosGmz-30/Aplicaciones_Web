const express = require('express');

const app = express();
app.use(express.json());
console.clear();


app.listen(8080);
console.log('Escuchando en el puerto 8080');