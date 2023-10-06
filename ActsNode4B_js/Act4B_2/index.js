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
    let name = req.body.name;
    let firstLastname = req.body.firstLastname;
    let secondLastname = req.body.secondLastname;
    let birthdate = req.body.birthdate;
    let sex = req.body.sex;
    let state = req.body.state;

    //Inicial y primer vocal del primer apellido
    const vocales = "aeiou";
    let vocal = "";
    let ape1 = firstLastname.toLowerCase();
    for (let i = 0; i < ape1.length; i++) {
        if (vocales.includes(ape1[i])) {
            vocal = ape1[i];
        }
    }
    const part1 = ape1.charAt(0) + vocal.charAt(0) + secondLastname.charAt(0) + name.charAt(0);

    //Separar fecha
    const fecha = birthdate.split('/');
    let dia = fecha[0].padStart(2, '0');
    let mes = fecha[1].padStart(2, '0');
    let año = fecha[2].slice(-2);
    const part2 = año + mes + dia;

    //Sexo
    const part3 = sex;

    //Entidad federativa
    const part4 = state.substring(0, 2);


    //Primer consonante interna de apellidos y nombres
    const n1 = name.toLowerCase();
    const a1 = firstLastname.toLowerCase();
    const a2 = secondLastname.toLowerCase();
    const consonantes = "bcdfghjklmnñpqrstvxzwy";
    let nombre = "";
    let apellido1 = "";
    let apellido2 = "";

    for (let i = 0; i < name.length; i++) {
        if (consonantes.includes(n1[i])) {
            nombre += name[i];
        }
    }

    for (let i = 0; i < firstLastname.length; i++) {
        if (consonantes.includes(a1[i])) {
            apellido1 += firstLastname[i];
        }
    }

    for (let i = 0; i < secondLastname.length; i++) {
        if (consonantes.includes(a2[i])) {
            apellido2 += secondLastname[i];
        }
    }

    const part5 = apellido1.charAt(1) + apellido2.charAt(1) + nombre.charAt(1)

    //Números random
    let num1 = Math.floor(Math.random() * 10);
    let num2 = Math.floor(Math.random() * 10);
    let part6 = "" + num1 + num2;

    //CURP
    let curpUnion = part1 + part2 + part3 + part4 + part5 + part6;
    let curpFinal = curpUnion.toUpperCase();

    const agenda = {
        id: agenda.length + 1,
        name: req.body.name,
        firstLastname: req.body.firstLastname,
        secondLastname: req.body.secondLastname,
        birthdate: req.body.birthdate,
        sex: req.body.sex,
        state: req.body.state,
        CURP: curpFinal,
    }

    agenda.push(agenda);
    res.json(agenda);
});

const port = process.env.port || 80;
app.listen(port, () => console.log(`Listen en el puerto ${port}`));

