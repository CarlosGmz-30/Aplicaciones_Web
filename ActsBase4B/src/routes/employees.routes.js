//"express" Solo sirve para las peticiones y el uso de ellas
const express = require('express');
const { getEmployees, addEmployee,
    updateEmployee, deleteEmployee } =
    require('../controllers/employees.controller.js');

const router = express.Router();

router.get('/employees', getEmployees);

router.post('/employees', addEmployee);

router.put('/employees', updateEmployee);

router.delete('/employees', deleteEmployee);

module.exports = router;