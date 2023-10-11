const getEmployees = (req, res) => {
    res.json({
        msj: "Peticion get"
    });
};

const addEmployee = (req, res) => {
    res.json({
        msj: "Peticion post"
    });
};

const updateEmployee = (req, res) => {
    res.json({
        msj: "Peticion put"
    });
};

const deleteEmployee = (req, res) => {
    res.json({
        msj: "Peticion delete"
    });
};

// Exportamos los metodos para que puedan ser usados en otros archivos
module.exports = {
    addEmployee, getEmployees, updateEmployee, deleteEmployee
};

