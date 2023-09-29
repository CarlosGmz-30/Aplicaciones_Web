/*
El programa recibirá el número del que quiere hacer su tabla de multiplicar y
hasta que número quiere que se multiplique.
*/

// Zona de variables
var numero = 10;
var limite = 15;


// Zona de operaciones
function multiplicar(numero, limite) {
    for (var i = 1; i <= limite; i++) {
        console.log(numero + " x " + i + " = " + (numero * i));
    }
}

// Zona de impresión
multiplicar(10, 15);