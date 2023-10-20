const jwt = require('jsonwebtoken');
const dotenv = require('dotenv');

const validateToken = (req, res, next) => {
    const headerToken = req.headers['authorization'];
    if (headerToken !== undefined && headerToken.startsWith('Bearer ')) {
        //Tiene un token válido
        try {
            const bearerToken = headerToken.slice(7);
            const tokenValido = jwt.verify(bearerToken, process.env.SECRET_KEY);
            next();
        } catch (error) {
            res.status(401).json({
                "error": "Token no válido"
            });
        }
    } else {
        res.status(401).json({
            "error": "Token denegado"
        });
    }
}

module.exports = validateToken;