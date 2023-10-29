const express = require('express');
const { getAlumnos, updateAlumno, deleteAlumno, createAlumno, getOne }
    = require("../controllers/alumnos.controller.js");
const router = express.Router();

router.get('/university', getAlumnos);

router.get('/university/:matricula', getOne);

router.post('/university', createAlumno);

router.put('/university/:idM', updateAlumno);

router.delete('/university/:matricula', deleteAlumno);


module.exports = router;