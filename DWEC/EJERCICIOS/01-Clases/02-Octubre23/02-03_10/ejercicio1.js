/**
 * Crear un scrip que contenga un array de números y solicite al usuario una operación 
 * (suma o multiplicación) y que en base a la opción elegida realice un alert con 
 * el resultado de la operación utilizando los números del array para ello.
 */

let miArray = [3, 4, 5, 6, 7];
let miVariable = prompt("Dime la operación");
let resultado = 0;

switch(miVariable) {
    case "suma":
        for(let numero of miArray) {
            resultado += numero;
        }
        alert(resultado);
        break;
    case "multiplicacion":
        resultado = 1;
        for(let numero of miArray) {
            resultado *= numero;
        }
        alert(resultado);
        break;
    default:
        alert("Las operaciones pueden ser suma o multiplicación");
}