/*
El programa recibirá un texto, si tiene espacios los eliminará, si tiene
"a" la convierte a 4, "e" la convierte a 3, "i" la convierte a 1, "o" la convierte a 0,
convertirá todo a minúsculas y al final mostrará el texto convertido.
*/

// Zona de variables
var texto = "Hola mundo";
var textoFinal = "";

// Zona de operaciones
function conversion (texto){
    texto = texto.toLowerCase();
    for(var i = 0; i < texto.length; i++){
        if(texto.charAt(i) === " "){
            textoFinal += "";
        }else if(texto.charAt(i) === "a"){
            textoFinal += "4";
        }else if(texto.charAt(i) === "e"){
            textoFinal += "3";
        }else if(texto.charAt(i) === "i"){
            textoFinal += "1";
        }else if(texto.charAt(i) === "o"){
            textoFinal += "0";
        }else{
            textoFinal += texto.charAt(i);
        }
    }
    console.log(textoFinal);
}

// Zona de impresión
conversion(texto);
