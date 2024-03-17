/**
 * Solicitar al usuario una serie de números separados por coma a través de un prompt,
 * a continuación pedir al usuario que decida la operación a realizar.
 * Convertir el prompt de números en un array y operar con él. Mostrar el resultado
 * por pantalla.
 */

let numeros = prompt("Introduce números separados por coma");
let array = numeros.split(",");
let operacion = prompt("Dime la operación");
let resultado = 0;

switch(operacion) {
    case "suma":
        for(let numero of array) {
            resultado += parseInt(numero);
        }
        alert(resultado);
        break;
    case "multiplicacion":
        resultado = 1;
        for(let numero of array) {
            resultado *= numero;
        }
        alert(resultado);
        break;
    default:
        alert("Las operaciones pueden ser suma o multiplicación");
}