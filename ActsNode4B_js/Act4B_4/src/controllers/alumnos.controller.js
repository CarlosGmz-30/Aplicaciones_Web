const { pool } = require('../db.js');

const getAlumnos = async (req, res) => {
    const [filas] = await pool.query('SELECT * FROM alumnos');
    res.json(filas);
};

const getOne = async (req, res) => {
    const [filas] = await pool.query('SELECT * FROM alumnos WHERE matricula = ?', [req.params.matricula]);
    if (filas.length <= 0)
        return res.status(404).json({
            msj: "Alumno no encontrado"
        });
    return res.json(filas);
};

const createAlumno = async (req, res) => {
    const { matricula, nombre, direccion, telefono, id_carrera } = req.body;
    const filas = await pool.query('INSERT INTO alumnos (matricula, nombre, direccion, telefono, id_carrera) VALUES (?, ?, ?, ?, ?)',
        [matricula, nombre, direccion, telefono, id_carrera]);
    res.send({ filas });
};

const updateAlumno = async (req, res) => {
    const { idM } = req.params;
    const { matricula, nombre, direccion, telefono, id_carrera } = req.body;

    try {
        const [verification] = await pool.query('SELECT * FROM alumnos WHERE matricula = ?', [idM]);
        if (verification.length == 0) {
            return res.status(404).json({ msj: "Alumno no Encontrado" });
        } else {
            await pool.query('UPDATE alumnos SET matricula = ?, nombre = ?, direccion = ?, telefono = ?, id_carrera = ? WHERE matricula = ?', [matricula, nombre, direccion, telefono, id_carrera, idM]);
        }

        res.send("Alumno actualizado correctamente");
    } catch (error) {
        console.error("Error al actualizar al alumno", error);
        res.status(500).json({ "msj": "Error al actualizar al alumno" });
    };
};

const deleteAlumno = async (req, res) => {
    const matricula = req.params.matricula;
    const [rows] = await pool.query('DELETE FROM alumnos WHERE matricula = ?', [matricula]);
    if (rows.affectedRows > 0) {
        return res.json("Alumno eliminado exitosamente");
    } else {
        return res.json("Alumno no econtrado en el sistema")
    }
}

module.exports = {
    getAlumnos, updateAlumno, deleteAlumno, createAlumno, getOne
};