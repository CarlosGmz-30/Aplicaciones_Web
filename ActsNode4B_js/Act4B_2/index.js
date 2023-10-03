/*
Hacer una agenda con 5 contactos, cada contacto debe tener nombre completo, dirección, email y teléfono. 
(Dentro de cada contacto debe haber otro arreglo con 2 contactos de emergencia con la misma información).
*/
const express = require('express');

const app = express();
app.use(express.json());

const agenda = [
    {
        id: 1,
        name: 'Alan Manuel Benitez Garcia', 
        address: 'Calle 123',
        email: '20223tn046@utez.edu.mx',
        phone: '734 131 7626',
        emergency: [
            {
                name: 'Jackeline Nieobe Hernández Bernal', 
                address: 'Calle 321',
                email: '20223tn057@utez.edu.mx',
                phone: '81 3191 0011'
            },
            {
                name: 'Moises Santiago Gonzáles Retana', 
                address: 'Calle 456',
                email: '20223tn055@utez.edu.mx',
                phone: '777 341 2106'
            }
        ]
    },
    {
        id: 2,
        name: 'Diego Jesús Hernández Palma', 
        address: 'Calle 666',
        email: '20223tn059@utez.edu.mx',
        phone: '777 294 0297',
        emergency: [
            {
                name: 'Alan Manuel Benitez Garcia', 
                address: 'Calle 123',
                email: '20223tn046@utez.edu.mx',
                phone: '81 3191 0011'
            },
            {
                name: 'Carlos Martínez Gómez', 
                address: 'Calle 428',
                email: '20223tn066@utez.edu.mx',
                phone: '777 223 8283'
            }
        ]
    },
    {
        id: 3,
        name: 'Carlos Martínez Gómez', 
        address: 'Calle 428',
        email: '20223tn066@utez.edu.mx',
        phone: '777 223 8283',
        emergency: [
            {
                name: 'Alan Manuel Benitez Garcia', 
                address: 'Calle 123',
                email: '20223tn046@utez.edu.mx',
                phone: '734 131 7626'
            },
            {
                name: 'Diego Jesús Hernández Palma', 
                address: 'Calle 666',
                email: '20223tn059@utez.edu.mx',
                phone: '777 294 0297'
            }
        ]
    },
    {
        id: 4,
        name: 'Jackeline Nieobe Hernández Bernal',
        address: 'Calle 321',
        email: '20223tn057@utez.edu.mx',
        phone: '81 3191 0011',
        emergency: [
            {
                name: 'Moises Santiago Gonzáles Retana', 
                address: 'Calle 456',
                email: '20223tn055@utez.edu.mx',
                phone: '777 341 2106'
            },
            {
                name: 'Alan Manuel Benitez Garcia', 
                address: 'Calle 123',
                email: '20223tn046@utez.edu.mx',
                phone: '734 131 7626'
            }
        ]
    },
    {
        id: 5,
        name: 'Moises Santiago Gonzáles Retana', 
        address: 'Calle 456',
        email: '20223tn055@utez.edu.mx',
        phone: '777 341 2106',
        emergency: [
            {
                name: 'Jackeline Nieobe Hernández Bernal', 
                address: 'Calle 321',
                email: '20223tn057@utez.edu.mx',
                phone: '81 3191 0011'
            },
            {
                name: 'Carlos Martínez Gómez', 
                address: 'Calle 428',
                email: '20223tn066@utez.edu.mx',
                phone: '777 223 8283'
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

const port = process.env.port || 80;
app.listen(port, () => console.log(`Listen en el puerto ${port}`));

