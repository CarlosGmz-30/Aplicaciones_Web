const { bdPool } = require('../bd.js');
const indexDb = async (req, res) => {
    const [result] = await bdPool.query('SELECT 1 + 1 as result');
    res.json(result[0]);
}

module.exports = {
    indexDb
};