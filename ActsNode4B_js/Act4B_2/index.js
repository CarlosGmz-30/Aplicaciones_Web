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
        let año = fecha[2].slice(-2);
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
        const name = agenda.name.toLowerCase();
        const firstLastname = agenda.firstLastname.toLowerCase();
        const secondLastname = agenda.secondLastname.toLowerCase();
        const consonantes = "bcdfghjklmnñpqrstvxzwy";
        let nombre = "";
        let apellido1 = "";
        let apellido2 = "";

        for (let i = 0; i < name.length; i++) {
            if (consonantes.includes(name[i])) {
                nombre += name[i];
            }
        }

        for (let i = 0; i < firstLastname.length; i++) {
            if (consonantes.includes(firstLastname[i])) {
                apellido1 += firstLastname[i];
            }
        }

        for (let i = 0; i < secondLastname.length; i++) {
            if (consonantes.includes(secondLastname[i])) {
                apellido2 += secondLastname[i];
            }
        }

        return apellido1.charAt(1) + apellido2.charAt(1) + nombre.charAt(1);
    }
    agenda.push(agenda);
    res.json(agenda);
});

const port = process.env.port || 80;
app.listen(port, () => console.log(`Listen en el puerto ${port}`));

