const { createPool } = require ("mysql2/promise");

const bdPool = createPool({
    host: 'localhost',
    user: 'root',
    password: 'root',
    database: 'employees'
});

module.exports = {
    bdPool
};