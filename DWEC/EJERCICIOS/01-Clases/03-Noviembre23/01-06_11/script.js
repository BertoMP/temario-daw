const miAnclaje = document.getElementById('miPrueba');

// CREACIÓN DE UN ELEMENTO <p>
const miParrafo = document.createElement('p');
miParrafo.id = 'nuevoElemento';

miParrafo.innerText = 'Ole, ole, ole, Chole Simeone';

// ANCLAR <p> DENTRO DEL NODO ORIGINAL
//miAnclaje.appendChild(miParrafo);

const miSegundoParrafo = document.createElement('p');
miSegundoParrafo.innerHTML = 'Viva er Betih';

const miCaja = document.createDocumentFragment();
miCaja.appendChild(miParrafo);
miCaja.appendChild(miSegundoParrafo);

miAnclaje.appendChild(miCaja);
