const express = require('express');

const app = express();
app.use(express.json());

const movies = [
    {
        id: 1,
        name: 'Scream 6',
        duration: 125,
        distribution: [
            {
                name: 'Jena Ortega',
                age: 21,
                birthdate: '27-sep-2002'
            },
            {
                name: 'Melissa Barrera',
                age: 33,
                birthdate: '07-Aug-1990'
            }
        ]
    },
    {
        id: 2,
        name: 'El juego de Ender',
        duration: 114,
        distribution: [
            {
                name: 'Asa Butterfield',
                age: 26,
                birthdate: '1-April-1997'
            },
            {
                name: 'Hailee Steinfeld',
                age: 26,
                birthdate: '11-Dec-1997'
            }
        ]
    },
    {
        id: 3,
        name: 'Harry poter y el caliz de fuego',
        duration: 157,
        distribution: [
            {
                name: 'Daniel Radcliffe',
                age: 34,
                birthdate: '23-Jul-1989'
            },
            {
                name: 'Emma Watson',
                age: 33,
                birthdate: '15-April-1990'
            }
        ]
    }
];

app.get('/', (req, res) => {
    res.send('Pagina de Inicio');
});

app.get('/api/movies', (req, res) => {
    res.send(movies);
});

app.get('/api/movies/:id', (req, res) => {
    const movie = movies.find(m => m.id === parseInt(req.params.id));
    if (!movie) return res.status(400).send('Pelicula no encontrada');
    else res.send(movie)
});

app.delete('/api/movies/:id', (req, res) => {
    const movie = movies.find(m => m.id === parseInt(req.params.id));
    if (!movie)
        return res.status(400).send('Pelicula no encontrada');
    const index = movies.indexOf(movie);
    movies.splice(index, 1);
    res.send(movie);
});
const port = process.env.port || 80;
app.listen(port, () => console.log(`Listen en el puerto ${port}`));