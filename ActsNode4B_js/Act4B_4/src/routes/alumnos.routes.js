const express = require('express');
const { getAlumnos, updateAlumno, deleteAlumno, createAlumno, getOne }
    = require("../controllers/alumnos.controller.js");
const router = express.Router();

router.get('/university', getAlumnos);

router.get('/university/:matricula', getOne);

router.get('/university', createAlumno);

router.get('/university/:idM', updateAlumno);

router.get('/university/:matricula', deleteAlumno);


module.exports = router;