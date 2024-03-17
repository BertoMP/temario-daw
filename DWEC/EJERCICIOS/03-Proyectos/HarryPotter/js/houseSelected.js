import { hogwartsHouses } from './hogwartsHouses.js';

/**
 * Elimina los datos 'selectedHouse' y 'password' almacenados
 * en localStorage y redirige a la página de cuestionario.
 *
 * @function
 * @returns {void}
 */
function clearStorage() {
	localStorage.removeItem('selectedHouse');
	localStorage.removeItem('password');
	window.location = './questionnaire.html';
}

/**
 * Crea un fragmento de documento que contiene la presentación de la casa seleccionada.
 * - Incluye una sección con el nombre de la casa y su logo, video y botón asociados.
 *
 * @function
 * @returns {DocumentFragment} - Fragmento de documento con la presentación de la casa.
 */
function createFragment() {
	const fragmentToReturn = document.createDocumentFragment();

	// Crear la sección principal.
	const section = createHTMLElement(
		'section',
		'section-house');
	fragmentToReturn.appendChild(section);

	// Crear el encabezado con el nombre del usuario y el mensaje del sombrero seleccionador.
	const h2 = createHTMLElement(
		'h2',
		'h2-house',
		{
			innerHTML: `${localStorage.getItem('name')}, el sombrero seleccionador te elige para...`
		});
	section.appendChild(h2);

	// Crear la imagen de la casa.
	const img = createHTMLElement(
		'img',
		'img-house',
		{
			src: selectedHouse.logoPath,
			alt: `Logo de la casa ${localStorage.getItem('selectedHouse')}`
		}
	);
	section.appendChild(img);

	// Crear el video de presentación de la casa.
	const video = createHTMLElement(
		'video',
		'video-house',
		{
			src: selectedHouse.videoPath,
			controls: true,
			autoplay: true,
		}
	);
	section.appendChild(video);

	// Crear el botón de retorno al cuestionario.
	const button = createHTMLElement(
		'button',
		'btn-return',
		{
			innerHTML: 'Volver a realizar el cuestionario'
		}
	);
	button.style.background = `linear-gradient(to right, ${selectedHouse.btnColor[0]}, ${selectedHouse.btnColor[1]})`;
	button.addEventListener('click', clearStorage);
	section.appendChild(button);

	return fragmentToReturn;
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
 * Crea la estructura del contenedor principal y la añade al cuerpo del documento.
 *
 * @function
 * @returns {void}
 */
function createHouseContainer() {
	const fragment = createFragment();

	// Crear la sección principal.
	const section = createHTMLElement('section', 'section-main');
	section.appendChild(fragment);

	// Crear el elemento main.
	const main = createHTMLElement('main', 'main-house');
	main.appendChild(section);

	document.body.appendChild(main);
}

/**
 * Elimina la contraseña almacenada en el localStorage y recarga la página.
 * Limpia el contenido del cuerpo del documento, elimina la contraseña del localStorage
 * y recarga la página actual.
 *
 * @function
 * @returns {void}
 */
function rememberPassword() {
	// Limpia el contenido del cuerpo del documento.
	document.body.innerHTML = '';

	// Elimina la contraseña almacenada en el localStorage.
	localStorage.removeItem('password');

	// Recarga la página actual.
	window.location.reload();
}

/**
 * Muestra un mensaje de error indicando que la contraseña ingresada no es la correcta.
 * Si ya existe un párrafo con el mensaje de error, no realiza ninguna acción adicional.
 * Si no existe, crea un nuevo párrafo y lo agrega junto con estilos adicionales al documento.
 *
 * @function
 * @returns {void}
 */
function incorrectPassword() {
	// Obtiene el elemento de párrafo existente con el mensaje de error.
	const paragraphIncorrect = document.getElementById('p-password');

	if (!paragraphIncorrect) {
		const paragraphIncorrect = createHTMLElement(
			'p',
			'p-password',
			{
				innerHTML: 'Esa no es la contraseña de tu casa.'
			});
		paragraphIncorrect.classList.add('invalid');

		// Obtiene el elemento de entrada de respuesta.
		const answerInput = document.getElementById('input-password');
		answerInput.classList.add('invalid');
		answerInput.after(paragraphIncorrect);
	}
}

/**
 * Intenta validar la contraseña ingresada comparándola con la contraseña
 * de la casa de Hogwarts seleccionada.
 * Si la contraseña no coincide, se llama a la función incorrectPassword.
 * Si la contraseña es correcta, se llama a la función showHogwartsHouse.
 *
 * @function
 * @returns {void}
 */
function tryPassword() {
	const password = document.getElementById('input-password').value;

	password !== selectedHouse.password ? incorrectPassword() : showHogwartsHouse();
}

/**
 * Muestra la sala común de la casa de Hogwarts seleccionada.
 * Almacena la contraseña de la casa en el localStorage, resetea el contenido
 * del cuerpo del documento
 * y realiza acciones de inicialización, como la aplicación de estilos al fondo
 * y la creación del contenedor de la casa.
 *
 * @function
 * @returns {void}
 */
function showHogwartsHouse() {
	// Almacena la contraseña de la casa seleccionada en el localStorage.
	localStorage.setItem('password', selectedHouse.password);

	// Resetea el contenido del body.
	document.body.innerHTML = '';

	// Aplica estilos al fondo, crea el contenedor y realiza otras acciones de inicialización.
	document.body.style.background = `url(${selectedHouse.background})`;
	createHouseContainer();
}

/**
 * Muestra la contraseña para entrar a la sala común de la casa de Hogwarts seleccionada.
 * Crea elementos HTML dinámicamente y los agrega al cuerpo del documento.
 *
 * @function
 * @returns {void}
 */
function showPassword() {
	// Crea un elemento 'section' con la clase 'section-main'.
	const section = createHTMLElement('section', 'section-main');
	const sectionPass = createHTMLElement('section', 'section-pass');
	section.appendChild(sectionPass);

	// Crea y agrega el logo de Hogwarts al elemento 'sectionPass'.
	const hogwartsLogo = createHTMLElement(
		'img',
		'hogwarts-logo',
		{
			src: '../assets/images/principal-logo-min.png',
			alt: 'Logo de Hogwarts'
		}
	);

	// Crea y agrega un párrafo con un mensaje al elemento 'sectionPass'.
	const paragraph = createHTMLElement(
		'p',
		'p-password',
		{
			innerHTML: 'La contraseña para entrar a la sala común de tu casa es:'
		});

	// Crea y agrega un encabezado h2 con la contraseña de la casa seleccionada.
	const h2Password = createHTMLElement(
		'h2',
		'h2-password',
		{
			innerHTML: `${selectedHouse.password}`
		}
	);

	// Crea y agrega otro párrafo con información adicional al elemento 'sectionPass'.
	const otherParagraph = createHTMLElement(
		'p',
		'p-pass-info',
		{
			innerHTML: 'Guárdala en un lugar seguro y no la pierdas.'
		}
	);

	// Crea y agrega un botón 'Aceptar' al elemento 'sectionPass'.
	const button = createHTMLElement(
		'button',
		'btn-accept',
		{
			innerHTML: 'Aceptar'
		});
	button.addEventListener('click', showHogwartsHouse);

	sectionPass.appendChild(hogwartsLogo);
	sectionPass.appendChild(paragraph);
	sectionPass.appendChild(h2Password);
	sectionPass.appendChild(otherParagraph);
	sectionPass.appendChild(button);

	// Crear el elemento main.
	const main = createHTMLElement('main', 'main-house');
	main.appendChild(section);

	document.body.appendChild(main);
}

/**
 * Solicita al usuario que introduzca la contraseña de su casa de Hogwarts.
 * Crea elementos HTML dinámicamente, como un formulario de entrada de contraseña,
 * y los agrega al cuerpo del documento para que el usuario pueda ingresar la contraseña.
 *
 * @function
 * @returns {void}
 */
function askForPassword() {
	// Crea un elemento 'section' con la clase 'section-main'.
	const section = createHTMLElement('section', 'section-main');

	// Crea un elemento 'section' con la clase 'section-input-pass'.
	const sectionInput = createHTMLElement('section', 'section-input-pass');
	section.appendChild(sectionInput);

	// Crea y agrega el logo de Hogwarts.
	const hogwarstLogo = createHTMLElement(
		'img',
		'hogwarts-logo',
		{
			src: '../assets/images/principal-logo-min.png',
			alt: 'Logo de Hogwarts'
		}
	);

	// Crea y agrega un párrafo con instrucciones.
	const paragraph = createHTMLElement(
		'p',
		'p-input-pass',
		{
			innerHTML: 'Introduce la contraseña de tu casa.'
		});

	// Crea un campo de entrada de texto para la contraseña.
	const input = createHTMLElement(
		'input',
		'input-password',
		{
			type: 'text',
		}
	);

	// Crea un botón 'Aceptar'.
	const button = createHTMLElement(
		'button',
		'btn-accept',
		{
			innerHTML: 'Aceptar'
		});
	button.addEventListener('click', tryPassword);

	// Crea y agrega un botón 'Pedir ayuda al prefecto de tu casa'.
	const buttonRemember = createHTMLElement(
		'button',
		'btn-remember',
		{
			innerHTML: 'Pedir ayuda al prefecto de tu casa'
		});
	buttonRemember.addEventListener('click', rememberPassword);

	sectionInput.appendChild(hogwarstLogo);
	sectionInput.appendChild(paragraph);
	sectionInput.appendChild(input);
	sectionInput.appendChild(button);
	sectionInput.appendChild(buttonRemember);

	// Crea el elemento 'main'.
	const main = createHTMLElement('main', 'main-house');
	main.appendChild(section);

	document.body.appendChild(main);
}

/**
 * Verifica si hay una contraseña almacenada en el localStorage.
 * Si hay una contraseña almacenada, llama a la función askForPassword.
 * Si no hay contraseña almacenada, llama a la función showPassword.
 *
 * @function
 * @returns {void}
 */
function checkPasswordStorage() {
	// Obtiene la contraseña almacenada en el localStorage.
	const housePassword = localStorage.getItem('password');

	housePassword ? askForPassword() : showPassword();
}

/**
 * Obtiene el objeto de datos de la casa de Hogwarts seleccionada almacenado en localStorage.
 *
 * @function
 * @returns {Object} - Objeto de datos de la casa de Hogwarts seleccionada. Undefined si no existe la casa.
 */
function getHouseObject() {
	const selectedHouse = localStorage.getItem('selectedHouse');
	return hogwartsHouses[selectedHouse];
}

/**
 * Comprueba el almacenamiento local (localStorage) en busca de datos necesarios.
 * Redirige a páginas apropiadas si falta algún dato.
 *
 * @function
 * @returns {boolean} 	Devuelve true si los datos requeridos están presentes,
 * 						de lo contrario, devuelve false.
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

	// Si la casa no está presenta, redirige al cuestionario y devuelve falso.
	if (selectedHouse === null || selectedHouse === '') {
		localStorage.removeItem('selectedHouse');
		window.location = './questionnaire.html';
		return false;
	}

	return true;
}

/**
 * Función de inicialización que se ejecuta al cargar completamente el DOM.
 * Verifica la existencia de datos almacenados y, si es el caso, realiza las acciones de inicialización.
 *
 * @function
 * @returns {void}
 */
function init() {
	// Verifica si hay datos almacenados y procede con la inicialización.
	if (checkStorage()) {
		// Obtiene el objeto de datos de la casa seleccionada.
		selectedHouse = getHouseObject();

		// Verifica si la casa seleccionada es válida.
		if (selectedHouse === undefined) {
			// En caso de que no sea válida, limpia los datos almacenados y redirige al usuario.
			localStorage.removeItem('selectedHouse');
			window.location = './questionnaire.html';
			return;
		}

		checkPasswordStorage();
	}
}

/**
 * Variable global que almacenará la casa de Hogwarts seleccionada.
 * Inicializada como una cadena vacía.
 *
 * @type {Object}
 */
let selectedHouse;

/**
 * Evento que se ejecuta cuando el DOM ha sido completamente cargado,
 * inicializa la aplicación llamando a la función 'init'.
 *
 * @event
 * @listens DOMContentLoaded
 * @returns {void}
 */
window.addEventListener('DOMContentLoaded', init);