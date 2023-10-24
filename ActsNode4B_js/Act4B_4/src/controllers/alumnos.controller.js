const { pool } = require('../db.js');

const getAlumnos = async (req, res) => {
    const [filas] = await pool.query('SELECT * FROM alumnos');
    res.json(filas);
};

const getOne = async (req, res) => {
    const [filas] = await pool.query('SELECT * FROM alumnos WHERE id = ?', [req.params.id]);
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

const updateAlumnos = async (req, res) => {
    const { idM } = req.params;
    const { matricula, nombre, direccion, telefono, id_carrera } = req.body;

    try {
        const [verification] = await pool.query('SELECT * FROM alumnos WHERE id = ?', [idM]);
        if (verification.lenght == 0) {
            return res.status(404).json({ msj: "Alumno no Encontrado" });
        } else {
            await pool.query('UPDATE alumno SET ', [matricula, nombre, direccion, telefono, id_carrera, idM]);
        }

        res.send("Empleado actualizado correctamente");
    } catch (error) {
        console.error("Error al actualizar al empleado", error);
        res.status(500).json({ "msj": "Error al actualizar al empleado" });
    };

};