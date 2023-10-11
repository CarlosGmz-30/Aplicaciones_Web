import { createPool } from "mysql2/promise";

const pool = createPool({
    host: 'localhost',
    user: 'root',
    password: 'root',
    database: 'employees'
});

module.exports = {
    pool
};