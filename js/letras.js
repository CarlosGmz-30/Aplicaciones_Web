/*
El programa debe recibir dos palabras de las cuales comparará cada una de sus letras
y mostrará en pantalla el número de letras que no coinciden entre ambas palabras.
(Comparando la primer letra de la palabra 1 con todas las letras de la palabra 2, 
luego la segunda letra de la palabra 1 con todas las letras de la palabra 2, etc.)
*/

//Zona de declaración de variables
var palabra1 = "perro";
var palabra2 = "Perro";
var contador = 0;


//Zona de arreglos
var letras1 = [];
var letrasMayusculas = [];



//Zona de operaciones
function letrasPalabra1(palabra) {
    for (var i = 0; i < palabra.length; i++) {
        letras1.push(palabra.charAt(i).toLowerCase());
    }
}


function compararLetras(letras1, palabra1,palabra2){
    for(var i = 0; i < palabra1.length && i < palabra2.length; i++){
        if(letras1[i] != palabra2.charAt(i)){
            contador++;
        }
    }
}

//Zona de llamada a las funciones
letrasPalabra1(palabra1);
compararLetras(letras1, palabra1, palabra2);

//Zona de impresión
console.log("El número de letras que no coinciden entre ambas palabras es: " + contador);
