//toString()
//let arrayFrutas = ["Pera", "Manzana", "Plátano", "Naranja"];
//console.log(`El array contiene los siguientes elementos: ${arrayFrutas.toString()}`);

//join()
//let arrayFrutas = ["Pera", "Manzana", "Plátano", "Naranja"];
//console.log(`El array se convertiría en String y quedaría así: ${arrayFrutas.join(" | ")}`);

//pop()
//let arrayFrutas = ["Pera", "Manzana", "Plátano", "Naranja"];
//arrayFrutas.pop();
//console.log(`El array tras eliminar el último elemento queda así: ${arrayFrutas.toString()}`);

//shift()
//let arrayFrutas = ["Pera", "Manzana", "Plátano", "Naranja"];
//arrayFrutas.shift();
//console.log(`El array tras eliminar el primer elemento queda así: ${arrayFrutas.toString()}`);

//delete
//let arrayFrutas = ["Pera", "Manzana", "Plátano", "Naranja"];
//delete arrayFrutas[2];
//console.log(`El array tras eliminar el elemento [2] queda así: ${arrayFrutas.toString()}`);
//console.log(`El elemento [2] es de tipo: ${typeof arrayFrutas[2]}`);

//push()
//let arrayFrutas = ["Pera", "Manzana", "Plátano", "Naranja"];
//arrayFrutas.push("Melocotón");
//console.log(`El array tras añadir un elemento al final queda así: ${arrayFrutas.toString()}`);

//unshift()
//let arrayFrutas = ["Pera", "Manzana", "Plátano", "Naranja"];
//arrayFrutas.unshift("Piña");
//console.log(`El array tras añadir un elemento al inicio queda así: ${arrayFrutas.toString()}`);

//concat()
//let arrayFrutas = ["Pera", "Manzana", "Plátano", "Naranja"];
//let otroArray = ["Piña", "Albaricoque"];
//let arrayFusionado = arrayFrutas.concat(otroArray);
//console.log(`El array fusionado queda así: ${arrayFusionado.toString()}`);

//flat()
//let matriz = [[1, 2], [3, 4], [5, 6]];
//let nuevoArr = matriz.flat();
//console.log(`La matriz contiene los elementos: ${nuevoArr.toString()}`);

//splice()
//let arrayFrutas = ["Pera", "Manzana", "Plátano", "Naranja"];
//arrayFrutas.splice(2, 1, "Mango", "Banana", "Kiwi");
//console.log(`El array queda así: ${arrayFrutas.toString()}`);

//let arrayFrutas = ["Pera", "Manzana", "Plátano", "Naranja"];
//arrayFrutas.splice(1, 2);
//console.log(`El array queda así: ${arrayFrutas.toString()}`);

//slice()
//let arrayFrutas = ["Pera", "Manzana", "Plátano", "Naranja"];
//let arrDividido = arrayFrutas.slice(2);
//let arrDividido2 = arrayFrutas.slice(1, 3);
//console.log(`El array queda así: ${arrDividido.toString()}`);
//console.log(`El array2 queda así: ${arrDividido2.toString()}`);