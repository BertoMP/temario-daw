import { questions } from './questions.js';

/**
 * Determina la casa de Hogwarts seleccionada basándose en los puntos acumulados.
 * - Itera sobre las casas y encuentra la casa con la mayor cantidad de puntos.
 * - Si hay empate, selecciona una casa al azar entre las que tienen la máxima puntuación.
 * - Devuelve la casa seleccionada.
 *
 * @function
 * @returns {string} - Nombre de la casa de Hogwarts seleccionada.
 */
function getHouse() {
	let maxPoints = 0;

	// Encuentra la cantidad máxima de puntos entre todas las casas.
	for (const house in hogwartsHouses) {
		if (hogwartsHouses[house] > maxPoints) {
			maxPoints = hogwartsHouses[house];
		}
	}

	const arrayHouses = [];

	// Encuentra las casas que tienen la máxima cantidad de puntos.
	for (const house in hogwartsHouses) {
		if (hogwartsHouses[house] === maxPoints) {
			arrayHouses.push(house);
		}
	}

	// Si hay empate, selecciona una casa al azar entre las de máxima puntuación.
	if (arrayHouses.length > 1) {
		return arrayHouses[Math.floor(Math.random() * arrayHouses.length)];
	}

	// Devuelve la única casa con la máxima puntuación.
	return arrayHouses[0];
}

/**
 * Redirige a la página 'houseSelected.html' después de almacenar la casa seleccionada en el almacenamiento local.
 * - Obtiene la casa seleccionada llamando a la función 'getHouse'.
 * - Almacena la casa seleccionada en el almacenamiento local.
 * - Redirige a la página 'houseSelected.html'.
 *
 * @function
 * @returns {void}
 */
function toSelectedHouse() {
	const selectedHouse = getHouse();
	localStorage.setItem('selectedHouse', selectedHouse);
	window.location = './houseSelected.html';
}

/**
 * Selecciona una respuesta y actualiza el progreso del cuestionario.
 * - Aumenta los puntos de la casa correspondiente en el objeto 'hogwartsHouses'.
 * - Incrementa el índice de la pregunta actual.
 * - Si hay más preguntas, muestra la siguiente pregunta llamando a 'displayQuestion'.
 * - De lo contrario, redirige a la página 'houseSelected.html' llamando a 'toSelectedHouse'.
 *
 * @function
 * @param {string} house - Casa asociada a la respuesta seleccionada.
 * @param {number} points - Puntos asociados a la respuesta seleccionada.
 * @returns {void}
 */
function selectAnswer(house, points) {
	hogwartsHouses[house] += points;

	currentQuestion++;
	if (currentQuestion < totalQuestions) {
		displayQuestion();
	} else {
		toSelectedHouse();
	}
}

/**
 * Muestra la pregunta actual en la interfaz.
 * - Actualiza el título y el texto de la pregunta.
 * - Crea botones de respuesta para cada opción.
 *
 * @function
 * @returns {void}
 */
function displayQuestion() {
	const questionText = document.getElementById('p-question');
	const btnContainer = document.getElementById('btn-container');
	const h2Question = document.getElementById('h2-question');
	let btnCounter = 1;

	// Actualiza el título con el número de la pregunta actual y el total de preguntas.
	h2Question.innerHTML = `PREGUNTA ${currentQuestion + 1} DE ${totalQuestions}`;

	// Actualiza el texto de la pregunta actual.
	questionText.textContent = questions[currentQuestion].question;

	// Limpia el contenedor de botones existente.
	btnContainer.innerHTML = '';

	// Crea botones de respuesta para cada opción y los agrega al contenedor.
	questions[currentQuestion].answers.forEach((answer) => {
		const button = createHTMLElement(
			'button',
			`btn-${btnCounter}`,
			{
				textContent: answer.text
			});

		/**
		 * Asigna un manejador de eventos al clic en un botón de respuesta.
		 * - Se ejecuta al hacer clic en un botón de respuesta.
		 * - Llama a la función 'selectAnswer' con la casa y los puntos asociados a la respuesta seleccionada.
		 *
		 * @event
		 * @listens 'click'
		 */
		button.addEventListener('click', () => selectAnswer(answer.house, answer.points));
		btnContainer.appendChild(button);
		btnCounter++;
	});
}

/**
 * Crea y retorna un elemento HTML con un identificador específico y otros parámetros opcionales.
 *
 * @function
 * @param {string} elementTag - Tipo de elemento HTML a crear (por ejemplo, 'div', 'p', 'h2', 'img', 'button').
 * @param {string} elementId - Identificador único para el elemento creado.
 * @param {Object} otherParameters - Otros parámetros opcionales a asignar al elemento (clave-valor).
 * @returns {HTMLElement} - El elemento HTML creado.
 */
function createHTMLElement(elementTag, elementId, otherParameters = undefined) {
	const elementToReturn = document.createElement(elementTag);
	elementToReturn.id = elementId;

	if (otherParameters) {
		for (const parameter in otherParameters) {
			elementToReturn[parameter] = otherParameters[parameter];
		}
	}

	return elementToReturn;
}

/**
 * Crea y retorna un fragmento de documento que contiene elementos HTML.
 * - Crea un fragmento de documento.
 * - Crea un elemento 'section' y lo agrega al fragmento.
 * - Crea un elemento 'img' y lo agrega a la 'section'.
 * - Crea un elemento 'h2' y lo agrega a la 'section'.
 * - Crea un elemento 'p' y lo agrega a la 'section'.
 * - Crea un elemento 'div' y lo agrega a la 'section'.
 *
 * @function
 * @returns {DocumentFragment} - El fragmento de documento creado con elementos HTML.
 */
function createFragment() {
	const fragmentToReturn = document.createDocumentFragment();

	// Crear la sección principal.
	const section = createHTMLElement(
		'section',
		'section-question');
	fragmentToReturn.appendChild(section);

	// Crear el elemento img que almacenará el logo de Hogwarts.
	const img = createHTMLElement(
		'img',
		'img-question',
		{
			src: '../assets/images/principal-logo-min.png',
			alt: 'Logo de Hogwarts'
		});
	section.appendChild(img);

	// Crear el encabezado donde se guardará el mensaje del contador de preguntas.
	const h2 = createHTMLElement(
		'h2',
		'h2-question');
	section.appendChild(h2);

	// Crear el párrafo donde se almacenará el mensaje de la pregunta.
	const p = createHTMLElement(
		'p',
		'p-question');
	section.appendChild(p);

	// Crear el contenedor de botones con las posibles respuestas a la pregunta.
	const div = createHTMLElement(
		'div',
		'btn-container');
	section.appendChild(div);

	return fragmentToReturn;
}

/**
 * Crea un contenedor principal en el cuerpo del documento.
 * - Crea un fragmento de documento para optimizar la manipulación del DOM.
 * - Crea un elemento 'main' y un elemento 'section'.
 * - Agrega el fragmento al elemento 'section'.
 * - Agrega el elemento 'section' al elemento 'main'.
 * - Agrega el elemento 'main' al cuerpo del documento.
 *
 * @function
 * @returns {void}
 */
function createContainer() {
	const fragment = createFragment();

	// Crear la sección principal.
	const section = createHTMLElement('section', 'section-main');
	section.appendChild(fragment);

	// Crear el elemento main.
	const main = createHTMLElement('main', 'main-questions');
	main.appendChild(section);

	document.body.appendChild(main);
}

/**
 * Verifica el almacenamiento local para determinar el estado del usuario.
 * - Obtiene el nombre del usuario desde el almacenamiento local.
 *   - Si el nombre no está presente, redirige a la página principal y devuelve falso.
 * - Obtiene la casa seleccionada desde el almacenamiento local.
 *   - Si la casa está presente, redirige a la página de la casa seleccionada y devuelve falso.
 * - Si el nombre está presente y no hay casa seleccionada, devuelve verdadero.
 *
 * @function
 * @returns {boolean} - True si el nombre está presente y no hay casa seleccionada, de lo contrario, false.
 */
function checkStorage() {
	const userName = localStorage.getItem('name');

	// Si el nombre no está presente, redirige a la página principal y devuelve falso.
	if (userName === null || userName === '') {
		localStorage.clear();
		window.location = '../index.html';
		return false;
	}

	const selectedHouse = localStorage.getItem('selectedHouse');

	// Si la casa está presente, redirige a la página de la casa seleccionada y devuelve falso.
	if (selectedHouse !== null && selectedHouse !== '') {
		window.location = './houseSelected.html';
		return false;
	}

	// Si el nombre está presente y no hay casa seleccionada, devuelve verdadero.
	return true;
}

/**
 * Inicializa el programa verificando el almacenamiento local,
 * creando el contenedor de preguntas y mostrando la primera pregunta.
 *
 * @function
 * @returns {void}
 */
function init() {
	if (checkStorage()) {
		createContainer();
		displayQuestion();
	}
}

/**
 * Objeto que representa el conteo de selecciones por casa en Hogwarts.
 * @type {Object.<string, number>}
 */
const hogwartsHouses = {
	'Gryffindor': 0,
	'Slytherin': 0,
	'Ravenclaw': 0,
	'Hufflepuff': 0
};

/**
 * Índice de la pregunta actual en el cuestionario.
 * @type {number}
 */
let currentQuestion = 0;

/**
 * Número total de preguntas en el cuestionario.
 * @type {number}
 */
const totalQuestions = questions.length;

/**
 * Evento que se ejecuta cuando el DOM ha sido completamente cargado,
 * inicializa la aplicación llamando a la función 'init'.
 *
 * @event
 * @listens 'DOMContentLoaded'
 */
window.addEventListener('DOMContentLoaded', init);