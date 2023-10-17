const { pool } = require('../db.js');

const getemployees = async (req, res) => {
    const [filas] = await pool.query('select * from employee;');
    res.json(filas);
};

const getOne = async (req, res) => {
    const [filas] = await pool.query('SELECT * FROM employee WHERE id = ?', [req.params.id]);
    if (filas.length <= 0)
        return res.status(404).json({
            msj: "Empleado no Encontrado"
        });
    return res.json(filas);
};

const createemployees = async (req, res) => {

    const { empName, ap1, ap2, salary, posType } = req.body;
    const filas = await pool.query('insert into employee(empName, ap1, ap2, salary, posType) VALUES (?, ?, ? ,?,?)', [empName, ap1, ap2, salary, posType]);
    res.send({ filas });
};

const updateemployees = async (req, res) => {
    const { idM } = req.params;
    const { empName, ap1, ap2, salary, posType } = req.body;

    try {
        const [verification] = await pool.query('SELECT * FROM employee WHERE id = ?', [idM]);
        if (verification.lenght == 0) {
            return res.status(404).json({ msj: "Empleado no Encontrado" });
        } else {
            await pool.query('UPDATE employee SET empName = ?, ap1 = ?, ap2 = ?, salary = ?, posType = ? WHERE id = ?', [empName, ap1, ap2, salary, posType, idM]);
        }

        res.send("Empleado actualizado correctamente");
    } catch (error) {
        console.error("Error al actualizar al empleado", error);
        res.status(500).json({ "msj": "Error al actualizar al empleado" });
    };
};

const deleteemployees = async (req, res) => {
    id = req.params.id;
    const [rows] = await pool.query('DELETE FROM employee WHERE id = ?', [req.params.id]);
    if (rows.affectedRows > 0) {
        return res.json("Empleado eliminado exitosamente");
    } else {
        return res.status(404).json({ msj: "Empleado no encontrado" });
    }

};



module.exports = {
    getemployees, updateemployees, deleteemployees, createemployees, getOne
};
