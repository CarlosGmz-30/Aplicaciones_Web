const express = require('express');
const universityRoutes = require('./routes/alumnos.routes.js');
const indexRoutes = require('./routes/index.routes.js');

const app = express();
app.use(express.json());
console.clear();
app.use("/api", indexRoutes);
app.use("/api", universityRoutes);


app.listen(8080);
console.log('Escuchando en el puerto 8080');