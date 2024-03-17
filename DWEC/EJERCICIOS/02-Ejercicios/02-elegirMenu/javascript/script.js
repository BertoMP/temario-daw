/** 
 * Generar un script que solicite al usuario un menú a elegir entre varios
 * primeros platos, varios segundos platos y varios postres.
 * 
 * A continuación, crear la estructura HTML necesaria para mostrar un mensaje
 * con el plato elegido y una imagen del plato seleccionado.
 * 
 * Por último, mostrar un mensaje estilo 'Gracias por su visita.'
 * 
 * Se debe realizar sobre un HTML vacío.
*/

/**
 * Permite al usuario elegir un plato de una lista de opciones.
 * @param {string} ordenPlato - El orden del plato que se va a elegir (primer plato, segundo plato o postre).
 * @param {string[]} opciones - Array de strings que contiene las opciones de platos disponibles.
 * @returns {string} - El plato seleccionado por el usuario.
 */
function elegirPlato(ordenPlato, opciones) {
	let eleccionValida = false; // Variable booleana que actúa de bandera para rastrear si la opción elegida por el usuario es válida.

	do {
		let mensaje = `Elige un ${ordenPlato}:\n\n`; // String que almacenará la cadena a mostrar en el prompt.
        
		for (let intCont = 0; intCont < opciones.length; intCont++) {
			mensaje += ` ${intCont + 1} - ${opciones[intCont].charAt(0).toUpperCase()}${opciones[intCont].slice(1)}.\n`;
		}
        
		let opcionUsuario = parseInt(prompt(mensaje)); // Variable que almacena la opción elegida por el usuario.

		if (opcionUsuario > 0 && opcionUsuario <= opciones.length) {
			eleccionValida = true;
			return opciones[opcionUsuario - 1];
		}

		let mensajeError = isNaN(opcionUsuario) // String que almacena el mensaje de error en caso de que la opción elegida no sea válida.
			? 'Debe introducir un número con la opción elegida.' 
			: `La opción "${opcionUsuario}" no está entre los platos disponibles.`;

		alert(mensajeError);

	}while(!eleccionValida);
}

/**
 * Crea un elemento de párrafo (<p>) con el contenido de texto especificado.
 * @param {string} texto - El texto que se mostrará dentro del párrafo.
 * @returns {HTMLElement} - El elemento de párrafo creado.
 */
function createParrafo(texto) {
	const parrafo = document.createElement('p');

	parrafo.innerHTML = texto;

	return parrafo;
}

/**
 * Obtiene la ruta de la imagen asociada a un plato dado.
 * @param {string} plato - El nombre del plato para el cual se desea obtener la ruta de la imagen.
 * @returns {string} La ruta de la imagen correspondiente al plato.
 */
function getRutaImagen(plato) {
	return imagenesPlatos[plato];
}

/**
 * Crea un elemento de imagen (<img>) con la ruta y el atributo 'alt' especificados.
 * @param {string} ruta - La ruta de la imagen a mostrar.
 * @param {string} alt - El texto alternativo para la imagen (atributo 'alt').
 * @returns {HTMLElement} - El elemento de imagen creado.
 */
function createImagen(ruta, alt) {
	const imagen = document.createElement('img');

	imagen.setAttribute('src', ruta);
	imagen.setAttribute('alt', alt);

	return imagen;
}

/**
 * Muestra un plato en el documento HTML, incluyendo un párrafo con la descripción y una imagen del plato.
 * @param {string} ordenPlato - El orden del plato que se va a mostrar (primer plato, segundo plato o postre).
 * @param {string} plato - El nombre del plato que se va a mostrar.
 */
function muestraPlato(ordenPlato, plato) {
	const parrafo = createParrafo(`Como ${ordenPlato} has elegido: ${plato}`);
	const ruta = getRutaImagen(plato);
	const imagen = createImagen(ruta, `Imagen de ${plato}`);

	document.body.appendChild(parrafo);
	document.body.appendChild(imagen);
    
	return;
}

/**
 * Muestra un mensaje de despedida en el documento HTML.
 */
function muestraDespedida() {
	const parrafo = createParrafo('¡¡Gracias por su visita!!');
    
	document.body.appendChild(parrafo);

	return;
}

const primerosPlatos = [ // Array que contiene los primeros platos.
	'lentejas guisadas con verduras',
	'ensalada con atún y huevo',
];

const segundosPlatos = [ // Array que contiene los segundos platos.
	'marmitako de atún con patatas',
	'entrecot de ternera',
];

const postres = [ // Array que contiene los postres.
	'natillas de vainilla',
	'pudding de frutas',
];

const imagenesPlatos = { // Objeto que funciona como mapa y contiene las imágenes asociadas a los platos.
	'lentejas guisadas con verduras': './image/lentejasGuisadas.jpg',
	'ensalada con atún y huevo': './image/ensaladaAtunHuevo.jpg',
	'marmitako de atún con patatas': './image/marmitakoAtunPatatas.jpg',
	'entrecot de ternera': './image/entrecotTernera.jpg',
	'natillas de vainilla': './image/natillasVainilla.jpg',
	'pudding de frutas': './image/puddingFrutas.jpg',
};

alert('Elige un menú a partir de las siguientes opciones.');

const menuElegido = { // Objeto que guarda los 3 platos elegidos por el usuario.
	'primer plato': elegirPlato('primer plato', primerosPlatos),
	'segundo plato': elegirPlato('segundo plato', segundosPlatos),
	postre: elegirPlato('postre', postres),
};

for (let atributo in menuElegido) {
	muestraPlato(atributo, menuElegido[atributo]);
}

muestraDespedida();