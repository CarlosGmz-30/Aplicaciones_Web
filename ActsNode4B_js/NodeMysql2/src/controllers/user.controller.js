const { pool } = require("../db.js");
const bcrypt = require('bcrypt')

const addUser = async (req, res) => {
    const { username, pass, rol } = req.body;
    //              Variable de la contraseña/Extensión de encriptado
    const hashedPass = await bcrypt.hash(pass, 10);

    // De esta manera hacemos nuestra petición en la base de datos
    const rows = await pool.query(
        'insert into usuario (username, pass, rol) VALUES (?, ?, ?)',
        [username, hashedPass, rol]
    );
    res.send({ rows })
};

// Exportamos el módulo
module.exports = {
    addUser
};