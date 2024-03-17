/**
 * Generar un script que imprima un array de números en un elemento p de HTML
 * y que, a continuación, imprima el resultado de la suma de los números
 * en otro elemento p.
 */

let miArray = [1, 5, 6, 42, 3, 511];
let miNodo = document.getElementById("array");
let miNodo2 = document.getElementById("resultado");
let resultado = 0;

miNodo.innerHTML = miArray.toString();

for (let intCont = 0; intCont < miArray.length; intCont++) {
    resultado += miArray[intCont];
}

miNodo2.innerHTML = resultado;