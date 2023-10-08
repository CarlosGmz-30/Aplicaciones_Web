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
        emergencyContact: [
            {
                name: 'Daniela',
                firstLastname: 'Martinez',
                secondLastname: 'Gómez',
                phone: "7773070731",
            },
            {
                name: 'Alexa',
                firstLastname: 'Pereyra',
                secondLastname: 'Lee',
                phone: "7772238283",
            }
        ]
    },
    {
        id: 2,
        name: 'Daniela',
        firstLastname: 'Martinez',
        secondLastname: 'Gómez',
        birthdate: "31/05/2005",
        sex: "M",
        state: "Morelos",
        emergencyContact: [
            {
                name: 'Carlos',
                firstLastname: 'Martinez',
                secondLastname: 'Gómez',
                phone: "7772238283",
            },
            {
                name: 'Alexa',
                firstLastname: 'Pereyra',
                secondLastname: 'Lee',
                phone: "7773070731",
            }
        ]
    },
    {
        id: 3,
        name: 'Alexa Mi Moy',
        firstLastname: 'Pereyra',
        secondLastname: 'Lee',
        birthdate: "29/05/2004",
        sex: "M",
        state: "Morelos",
        emergencyContact: [
            {
                name: 'Carlos',
                firstLastname: 'Martinez',
                secondLastname: 'Gómez',
                phone: "7772238283",
            },
            {
                name: 'Daniela',
                firstLastname: 'Martinez',
                secondLastname: 'Gómez',
                phone: "7773070731",
            }
        ]
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
    let ape1 = firstLastname;
    for (let i = 0; i < ape1.length; i++) {
        if (vocales.includes(ape1[i].toLowerCase())) {
            vocal = ape1[i];
            break;
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

    const nuevoContacto = {
        id: agenda.length + 1,
        name: req.body.name,
        firstLastname: req.body.firstLastname,
        secondLastname: req.body.secondLastname,
        birthdate: req.body.birthdate,
        sex: req.body.sex,
        state: req.body.state,
        emergencyContact: req.body.emergencyContact,
        CURP: curpFinal,
    }

    agenda.push(nuevoContacto);
    res.json(nuevoContacto);
});

app.patch('/api/agenda/:id', (req, res) => {
    const id = parseInt(req.params.id);
    const contact = req.body;

    //Validar si existe el contacto
    const user = agenda.find(c => c.id === id);
    if (!user) {
        return res.status(404).send('El contacto con el ID dado no fue encontrado');
    }

    //Actualizar nombre del contacto
    if (contact.name) {
        user.name = contact.name;
    }

    //Actualizar apellido paterno del contacto
    if (contact.firstLastname) {
        user.firstLastname = contact.firstLastname;
    }

    //Actualizar apellido materno del contacto
    if (contact.secondLastname) {
        user.secondLastname = contact.secondLastname;
    }

    //Actualizar fecha de nacimiento del contacto
    if (contact.birthdate) {
        user.birthdate = contact.birthdate;
    }

    //Actualizar sexo del contacto
    if (contact.sex) {
        user.sex = contact.sex;
    }

    //Actualizar estado del contacto
    if (contact.state) {
        user.state = contact.state;
    }

    // Actualizar el CURP con los nuevos datos
    const vocales = "aeiou";
    let vocal = "";
    let ape1 = user.firstLastname;

    for (let i = 0; i < ape1.length; i++) {
        if (vocales.includes(ape1[i].toLowerCase())) {
            vocal = ape1[i];
            break;
        }
    }

    const part1 = ape1.charAt(0) + vocal.charAt(0) + user.secondLastname.charAt(0) + user.name.charAt(0);
    const fecha = user.birthdate.split('/');
    let dia = fecha[0].padStart(2, '0');
    let mes = fecha[1].padStart(2, '0');
    let año = fecha[2].slice(-2);
    const part2 = año + mes + dia;
    const part3 = user.sex;
    const part4 = user.state.substring(0, 2);

    const n1 = user.name.toLowerCase();
    const a1 = user.firstLastname.toLowerCase();
    const a2 = user.secondLastname.toLowerCase();
    const consonantes = "bcdfghjklmnñpqrstvxzwy";
    let nombre = "";
    let apellido1 = "";
    let apellido2 = "";

    for (let i = 0; i < user.name.length; i++) {
        if (consonantes.includes(n1[i])) {
            nombre += user.name[i];
        }
    }

    for (let i = 0; i < user.firstLastname.length; i++) {
        if (consonantes.includes(a1[i])) {
            apellido1 += user.firstLastname[i];
        }
    }

    for (let i = 0; i < user.secondLastname.length; i++) {
        if (consonantes.includes(a2[i])) {
            apellido2 += user.secondLastname[i];
        }
    }

    const part5 = apellido1.charAt(1) + apellido2.charAt(1) + nombre.charAt(1);

    let num1 = Math.floor(Math.random() * 10);
    let num2 = Math.floor(Math.random() * 10);
    let part6 = "" + num1 + num2;

    let curpUnion = part1 + part2 + part3 + part4 + part5 + part6;
    let curpFinal = curpUnion.toUpperCase();

    user.CURP = curpFinal;

    res.json(user);
});

app.put('/api/agenda/:id', (req, res) => {
    const user = agenda.find(m => m.id === parseInt(req.params.id))
    if (!user) return res.status(404).send('Agenda no encontrada');
    user.id = user.id
    user.name = req.body.name
    user.birthdate = req.body.birthdate
    user.state = req.body.state
    user.sex = req.body.sex
    user.emergencyContact = req.body.emergencyContact
    
    let name = req.body.name;
    let firstLastname = req.body.firstLastname;
    let secondLastname = req.body.secondLastname;
    let birthdate = req.body.birthdate;
    let sex = req.body.sex;
    let state = req.body.state;

    //Inicial y primer vocal del primer apellido
    const vocales = "aeiou";
    let vocal = "";
    let ape1 = firstLastname;
    for (let i = 0; i < ape1.length; i++) {
        if (vocales.includes(ape1[i].toLowerCase())) {
            vocal = ape1[i];
            break;
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

    user.CURP = curpFinal;
    res.send(user);
});


const port = process.env.PORT || 80;
app.listen(port, () => console.log(`Listen en el puerto ${port}`));