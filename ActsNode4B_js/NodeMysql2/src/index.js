const express = require("express");
const employeesRoutes = require('./routes/pokemons.routes.js');
const indexRoutes = require("./routes/index.routes.js");

const app = express();
app.use(express.json());
console.clear();
app.use("/api", indexRoutes);
app.use("/api", employeesRoutes);



app.listen(8080);
console.log("Escuchando en el puerto 8080");
