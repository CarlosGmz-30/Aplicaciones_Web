const { pool } = require("./bd.js");
const express = require('express');
const employeesRoutes = require("./routes/employees.routes.js");
const indexRoutes = require('./routes/index.routes.js')

const app = express();

app.use("/api", employeesRoutes);
app.use("/api", indexRoutes);

app.listen(8080);
console.log("Escuchando en el servidor 8080");