const { pool } = require("../db.js");
const bcrypt = require('bcrypt')
const jwt = require('jsonwebtoken');

const addUser = async (req, res) => {
    const { username, pass, rol } = req.body;
    //              Variable de la contraseña/Extensión de encriptado
    const hashedPass = await bcrypt.hash(pass, 10);

    // De esta manera hacemos nuestra petición en la base de datos
    const rows = await pool.query(
        'insert into usuario (username, pass, rol) VALUES (?, ?, ?)',
        [username, hashedPass, rol]);
    res.send({ rows });
};


const loginUser = async (req, res) => {
    const { username, pass } = req.body;
    const [rows] = await pool.query('select * from usuario where username = ?', [username]);
    if (rows.length === 0) {
        //El usuario no existe
        res.json({
            "msj": "El usuario no se encuentra"
        });
    } else {
        //       Contraseña/Encriptada        Nombre de función
        bcrypt.compare(pass, rows[0].pass).then(function (data) {
            console.log(data);
            if (data) {
                const token = jwt.sign({
                    username: username,
                    id: rows[0].id
                }, "4Tx)D@pH3O$9");
                res.json({ token });
            } else {
                res.json({ "msg": "Usuario y/o contrasenias no encontradas" });
            }
        });
    }
}


// Exportamos el módulo
module.exports = {
    addUser, loginUser
};