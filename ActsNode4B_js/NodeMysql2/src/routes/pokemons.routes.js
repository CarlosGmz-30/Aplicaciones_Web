const express = require('express');
const { getemployees, createemployees, updateemployees, deleteemployees,
getOne } = require("../controllers/pokemons.controller.js");
// Declaramos nuestra constante del validateToken
const validateToken = require('./validate-token.js');

const router = express.Router();

//                       Llamar el metodo de validar
router.get('/employees', validateToken, getemployees);

router.get('/employees/:id', getOne);

router.post('/employees', createemployees);

router.put('/employees/:idM', updateemployees);

router.delete('/employees/:idA', deleteemployees);

module.exports = router;