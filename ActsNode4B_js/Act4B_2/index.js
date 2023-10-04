/*
Hacer una agenda de contactos y que al momento de hacer el post se cree 
el CURP del contacto, el CURP se crea con lo siguiente:
- Primer letra del primer apellido
- Primer vocal del primer apellido
- Letra inicial del segundo apellido
- Letra inicial del nombre
- Fecha de nacimiento
- Sexo
- Entidad federativa
- Primer consonantes interna de apellidos y nombres
- Dos números random
*/

const express = require('express');

const app = express();
app.use(express.json());

const agenda = [
    {
        id: 1,
        name: 'Carlos',
        firstLastname: 'Martinez',
        secondLastname: 'Gómez',
        birthdate: "30/01/2004",
        sex: "H",
        state: "Morelos",
    }
];


app.get('/', (req, res) => {
    res.send('Pagina de Inicio');
});

app.get('/api/agenda', (req, res) => {
    res.send(agenda);
});

app.get('/api/agenda/:id', (req, res) => {
    const contact = agenda.find(c => c.id === parseInt(req.params.id));
    if (!contact) res.status(404).send('El contacto con el ID dado no fue encontrado');
    res.send(contact);
});

app.post('/api/agenda', (req, res) => {
    const agenda = {
        id: agenda.length + 1,
        name: req.body.name,
        firstLastname: req.body.firstLastname,
        secondLastname: req.body.secondLastname,
        birthdate: req.body.birthdate,
        sex: req.body.sex,
        state: req.body.state
    }

    // Zona de funciones
    function separarFecha(agenda) {
        const fecha = agenda.birthdate.split('/');
        const dia = fecha[0];
        const mes = fecha[1];
        const año = fecha[2];
        año = año.substring(2, 4);
        return { dia, mes, año };
    }

    function numeroRandom() {
        var num1 = Math.floor(Math.random() * 10);
        var num2 = Math.floor(Math.random() * 10);
        const num = "" + num1 + num2;
        return num;
    }

    function entidad(agenda) {
        const estado = agenda.state.substring(0, 2);
        return estado;
    }

    function consonante(agenda) {
        const consonante = "";
        const name = agenda.name.toLowerCase();
        const firstLastname = agenda.firstLastname.toLowerCase();
        const secondLastname = agenda.secondLastname.toLowerCase();
        const consonantes = "bcdfghjklmnñpqrstvxzwy";
        var nombre = [];
        var apellido1 = [];
        var apellido2 = [];
        for (let i = 0; i < name.length; i++) {
            if (name[i] == consonantes) {
                nombre.push(name[i]);
            }
        }
        for (let i = 0; i < firstLastname.length; i++) {
            if (firstLastname[i] == consonantes) {
                apellido1.push(firstLastname[i]);
            }
        }
        for (let i = 0; i < secondLastname.length; i++) {
            if (secondLastname[i] == consonantes) {
                apellido2.push(secondLastname[i]);
            }
        }

        consonante += apellido1[1] += apellido2[1] += nombre[1];
        return consonante;
    }

    function crearCURP() {
        const curp = "";
        const fecha = separarFecha(agenda);
        const numAleatorio = numeroRandom();
        const estado = entidad(agenda);
        const letrasConsonantes = consonante(agenda);
        curp += agenda.firstLastname[0];
        curp += agenda.firstLastname[1];
        curp += agenda.secondLastname[0];
        curp += agenda.name[0];
        curp += fecha.año;
        curp += fecha.mes;
        curp += fecha.dia;
        curp += agenda.sex;
        curp += estado;
        curp += letrasConsonantes;
        curp += numAleatorio;
    }

    
    agenda.push(agenda);
    res.json(agenda);
});

const port = process.env.port || 80;
app.listen(port, () => console.log(`Listen en el puerto ${port}`));

