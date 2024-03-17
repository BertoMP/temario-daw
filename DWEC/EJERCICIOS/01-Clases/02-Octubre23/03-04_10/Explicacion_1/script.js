// let miParrafo = document.getElementById('miParrafo1'); // Ahora tiene un nodo.
// miParrafo.innerHTML = 'Hola, majo.';

let misParrafos = document.getElementsByTagName('p');

console.log(misParrafos);

misParrafos[0].innerHTML = 'Hola!!!';

let misParrafosClase = document.getElementsByClassName('parrafoSecundario');
misParrafosClase[0].innerHTML = 'Segundo parrafo very cool nevertheless.';