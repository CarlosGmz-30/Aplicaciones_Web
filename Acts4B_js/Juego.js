/*
El programa es un juego de piedra, papel o tijera en el que el usuario
juega contra la computadora, el usuario ingresa su jugada y el programa de 
manera aleatoria contesta con una de las tres opciones.
*/

/*
Selecciona una opción:
1.Piedra (0)
2.Papel (1)
3.Tijera (2)
*/

// Zona de variables y arreglos
var usuario = 1; //
const opciones = ["piedra", "papel", "tijera"];

// Generar respuesta aleatoria
function generarRespuesta(opciones) {
    var respuesta = Math.floor(Math.random() * 3);
    return respuesta;
}

// Comparar respuesta de usuario y computadora
function juego(respuesta, usuario) {
    usuario = usuario - 1;
    if (respuesta === usuario) {
        return "Empate";
    } else if (respuesta === 0 && usuario === 2) {
        return "Perdiste, ¡suerte para la próxima!";
    } else if (respuesta === 0 && usuario === 1) {
        return "¡Ganaste!";
    } else if (respuesta === 1 && usuario === 0) {
        return "Perdiste, ¡suerte para la próxima!";
    } else if (respuesta === 1 && usuario === 2) {
        return "¡Ganaste!";
    } else if (respuesta === 2 && usuario === 1) {
        return "Perdiste, ¡suerte para la próxima!";
    } else if (respuesta === 2 && usuario === 0) {
        return "¡Ganaste!";
    }
}

// Zona de llamada a las funciones
var respuesta = generarRespuesta(opciones);

// Llamada a la función juego y captura del resultado
var resultado = juego(respuesta, usuario);

// Zona de impresión
console.log("\nLa computadora eligió: " + opciones[respuesta] + " y tú elegiste: " + opciones[usuario - 1] + ".");
console.log(resultado);