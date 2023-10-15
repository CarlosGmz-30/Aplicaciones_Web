const express = require('express');
const { getemployees, createemployees, updateemployees, deleteemployees,
getOne } = require("../controllers/pokemons.controller.js");

const router = express.Router();

router.get('/employees', getemployees);

router.get('/employees/:id', getOne);

router.post('/employees', createemployees);

router.put('/employees/:idM', updateemployees);

router.delete('/employees/:idA', deleteemployees);

module.exports = router;