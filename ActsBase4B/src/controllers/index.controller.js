const { pool } = require('../bd.js');
const indexDb = async (req, res) => {
    const [result] = await pool.query('SELECT 1 + 1 as result');
    res.json(result[0]);
}

module.exports = {
    indexDb
};