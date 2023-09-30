/*
Creación de una calculadora básica que nos permita sumar, restar
multiplicar y dividir dos números. La calculadora no puede recibir números 
negativos ni con decimales, en caso de recibirlos debe mostrar un mensaje de error
y volver a pedir el número.
*/


//Declaración de variables
var resultado = 0;
const readLine = require('readline');
const rl = readLine.createInterface({
    input: process.stdin,
    output: process.stdout
});

let opc;


//Zona de funciones
function validarNumeros(num1, num2) {
    if (num1 < 0 || num2 < 0) {
        console.log("No se pueden ingresar números negativos");
        return false;
    } else if (num1 % 1 != 0 || num2 % 1 != 0) {
        console.log("No se pueden ingresar números con decimales");
        return false;
    } else {
        return true;
    }
}

function validarNumerosResta(num1, num2) {
    if (num1 < num2) {
        console.log("El primer número debe ser mayor al segundo");
        return false;
    } else if (num1 < 0 || num2 < 0) {
        console.log("No se pueden ingresar números negativos");
        return false;
    } else if (num1 % 1 != 0 || num2 % 1 != 0) {
        console.log("No se pueden ingresar números con decimales");
        return false;
    } else {
        return true;
    }
}

function validarNumerosDivision(num1, num2) {
    if (num1 == 0 || num2 == 0) {
        console.log("No se puede dividir entre 0");
        return false;
    } else if (num1 < 0 || num2 < 0) {
        console.log("No se pueden ingresar números negativos");
        return false;
    } else if (num1 % 1 != 0 || num2 % 1 != 0) {
        console.log("No se pueden ingresar números con decimales");
        return false;
    } else {
        return true;
    }
}

function sumar(num1, num2) {
    return num1 + num2;
}

function restar(num1, num2) {
    return num1 - num2;
}

function multiplicar(num1, num2) {
    return num1 * num2;
}

function dividir(num1, num2) {
    return num1 / num2;
}

//Zona de menú
function mostrarMenu() {
    console.log("\n**********CALCULADORA**********")
    console.log("1. Sumar\n2. Restar\n3. Multiplicar\n4. Dividir\n5. Salir");
    rl.question('SELECCIONA UNA OPCIÓN: ', (input) => {
        opc = parseInt(input);
        switch (opc) {
            case 1:
                console.log("\n**************SUMA*************")
                rl.question('Introduce el primer número: ', (input1) => {
                    rl.question('Introduce el segundo número: ', (input2) => {
                        const num1 = parseFloat(input1);
                        const num2 = parseFloat(input2);
                        if (validarNumeros(num1, num2)) {
                            const resultado = sumar(num1, num2);
                            console.log(num1 + " + " + num2 +  " = " + resultado);
                            mostrarMenu();
                        } else {
                            mostrarMenu();
                        }
                    });
                });
                break;
            case 2:
                console.log("\n**************RESTA************")
                rl.question('Introduce el primer número: ', (input1) => {
                    rl.question('Introduce el segundo número: ', (input2) => {
                        const num1 = parseFloat(input1);
                        const num2 = parseFloat(input2);
                        if (validarNumerosResta(num1, num2)) {
                            const resultado = restar(num1, num2);
                            console.log(num1 + " - " + num2 +  " = " + resultado);
                            mostrarMenu();
                        } else {
                            mostrarMenu();
                        }
                    });
                });
                break;
            case 3:
                console.log("\n*********MULTIPLICACIÓN********")
                rl.question('Introduce el primer número: ', (input1) => {
                    rl.question('Introduce el segundo número: ', (input2) => {
                        const num1 = parseFloat(input1);
                        const num2 = parseFloat(input2);
                        if (validarNumeros(num1, num2)) {
                            const resultado = multiplicar(num1, num2);
                            console.log(num1 + " * " + num2 +  " = " + resultado);
                            mostrarMenu();
                        } else {
                            mostrarMenu();
                        }
                    });
                });
                break;
            case 4:
                console.log("\n************DIVISIÓN***********")
                rl.question('Introduce el primer número: ', (input1) => {
                    rl.question('Introduce el segundo número: ', (input2) => {
                        const num1 = parseFloat(input1);
                        const num2 = parseFloat(input2);
                        if (validarNumerosDivision(num1, num2)) {
                            const resultado = dividir(num1, num2);
                            console.log(num1 + " / " + num2 +  " = " + resultado);
                            mostrarMenu();
                        } else {
                            mostrarMenu();
                        }
                    });
                });
                break; 
            case 5:
                console.log("\nSALIENDO DE LA CALCULADORA...")
                rl.close();
                break;
            default:
                console.log("*******Opción no válida*******");
                mostrarMenu();
                break;
        }
    });
}

mostrarMenu();