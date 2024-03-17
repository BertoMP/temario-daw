/**
 * Redirecciona al inicio y limpia el localStorage.
 *
 * @returns {void}
 */
function clearStorageAndRedirect() {
	window.close();
	localStorage.clear();
	window.open('../index.html');
}

/**
 * Aplica estilos de fondo al cuerpo del documento basados en la condición
 * de finalización del juego.
 * Utiliza la imagen de fondo definida en el objeto 'endingCondition'.
 */
function styleBackground() {
	const ending = endingCondition[localStorage.getItem('endgame')];

	document.body.style.background = ending.background;
}

/**
 * Crea un fragmento de documento que contiene elementos HTML
 * representando el resultado del juego.
 * Utiliza la información de la condición de finalización del juego
 * almacenada en localStorage.
 *
 * @returns {DocumentFragment} - Un fragmento de documento con la
 * 								 representación del resultado del juego.
 */
function createFragment() {
	const ending = endingCondition[localStorage.getItem('endgame')];

	const fragment = document.createDocumentFragment();
	const section = document.createElement('section');
	fragment.appendChild(section);

	const h2 = document.createElement('h2');
	h2.innerHTML = ending.h2;
	section.appendChild(h2);

	const secondSection = document.createElement('section');
	section.appendChild(secondSection);

	const p = document.createElement('p');
	p.innerHTML = ending.p;
	secondSection.appendChild(p);

	const button = document.createElement('button');
	button.addEventListener('click', clearStorageAndRedirect);
	button.innerHTML = 'Cerrar ventana y volver a inicio';
	secondSection.appendChild(button);

	return fragment;
}

/**
 * Crea una sección principal en el cuerpo del documento y agrega
 * un fragmento con el resultado del juego.
 */
function createSection() {
	const main = document.createElement('main');
	const fragment = createFragment();

	main.appendChild(fragment);
	document.body.appendChild(main);
}

/**
 * Comprueba el estado de almacenamiento local para garantizar que la clave 'endgame' tenga un valor válido.
 * Si la clave 'endgame' no tiene un valor o tiene un valor no válido, realiza las siguientes acciones:
 * - Limpia el almacenamiento local.
 * - Redirige a la página '../index.html'.
 *
 * @returns {boolean} - Devuelve true si la clave 'endgame' tiene un valor válido ('gameOver' o 'victory'),
 *                     	de lo contrario, devuelve false.
 */
function checkStorage() {
	const endgame = localStorage.getItem('endgame');

	if (!endgame || (endgame !== 'gameOver' && endgame !== 'victory')) {
		localStorage.clear();
		window.location = '../index.html';
		return false;
	}

	return true;
}

/**
 * Inicializa la aplicación realizando una serie de acciones si las condiciones son satisfactorias.
 * - Verifica el estado de almacenamiento local utilizando la función checkStorage().
 * - Aplica estilos de fondo utilizando la función styleBackground().
 * - Crea una sección en la interfaz de usuario mediante la función createSection().
 */
function init() {
	if (checkStorage()) {
		styleBackground();
		createSection();
	}
}

/**
 * Condiciones de finalización del juego, que definen los diferentes resultados del juego.
 * Cada condición tiene información asociada, como el título (h2), el párrafo (p) y la imagen de fondo.
 *
 * @typedef {Object} EndingCondition
 * @property {string} h2 - El título (encabezado) asociado a la condición.
 * @property {string} p - El párrafo asociado a la condición.
 * @property {string} background - La imagen de fondo asociada a la condición (como una URL).
 */
const endingCondition = {
	gameOver: {
		h2: 'GAME OVER',
		p: 'No has conseguido escapar de este hospital psiquiátrico y descansarás en él.',
		background: 'url(../images/gameover.jpg)'
	},
	victory: {
		h2: '¡Has escapado!',
		p: 'Has conseguido escapar del psiquiátrico.',
		background: 'url(../images/final.jpg)'
	}
};

// INICIADOR DEL PROGRAMA
window.addEventListener('DOMContentLoaded', init);