/**
 * Función encargada de almacenar el terror elegido por el usuario.
 */
function saveTerror() {
	const terrorFromInput = document.getElementById('terror').value;

	localStorage.setItem('terror', terrorFromInput);
}

/**
 * Función encargada de almacenar el nombre del usuario.
 */
function saveUsername() {
	username = document.getElementById('input-name').value;
	localStorage.setItem('name', username);
}

/**
 * Función encargada de generar un elemento <p>.
 * @param message - Mensaje que tendrá el elemento <p>.
 * @param elementClass - Class que tendrá el elemento <p>.
 * @returns {HTMLParagraphElement} - Devuelve un elemento <p>`.
 */
function createParagraph(message, elementClass) {
	const parrafo = document.createElement('p');

	parrafo.id = 'p-info';
	parrafo.innerHTML = message;
	parrafo.setAttribute('class', elementClass);

	return parrafo;
}

/**
 * Función que se encarga de aplicar al parrafo que informa
 * de si es posible acceder o no a la página.
 *
 * @param message - Mensaje que aparecerá en el <p>.
 * @param elementClass - Class que tendrá el elemento <p>.
 */
function formatInfoParagraph(message, elementClass) {
	const parrafo = document.getElementById('p-info');

	if (!parrafo) {
		const form = document.getElementById('form');
		const nuevoParrafo = createParagraph(message, elementClass);

		form.appendChild(nuevoParrafo);
		return;
	}

	parrafo.innerHTML = message;
	parrafo.setAttribute('class', elementClass);
}

/**
 * Función encargada de calcular la edad de un usuario.
 *
 * @param birthInput - Fecha de nacimiento indicada por el usuario.
 * @returns {number} - Cantidad de años entre la fecha actual y la fecha
 * 					   de nacimiento indicada.
 */
function calculateAge(birthInput) {
	const dateToday = new Date();
	dateToday.setHours(0, 0, 0, 0);

	const dateOfBirth = new Date(birthInput);
	dateOfBirth.setHours(0, 0, 0, 0);

	if (dateOfBirth > dateToday) {
		return -1;
	}

	const dateLegalAge = new Date();
	dateLegalAge.setFullYear(dateToday.getFullYear() - LEGAL_AGE);
	dateLegalAge.setHours(0, 0, 0, 0);

	let userAge = dateToday.getFullYear() - dateOfBirth.getFullYear();

	return (userAge === LEGAL_AGE && dateOfBirth > dateLegalAge)
		? --userAge
		: userAge;
}

/**
 * Función encargada de comprobar si el usuario ha introducido una fecha
 * de nacimiento que confirme que es mayor de edad.
 */
function checkLegalAge() {
	const dateOfBirth = document.getElementById('input-date').value;
	const age = calculateAge(dateOfBirth);

	if (age < 0) {
		formatInfoParagraph(
			'No puedes elegir una fecha en el futuro.',
			'access-denied'
		);
		return false;
	}

	if (age < LEGAL_AGE) {
		formatInfoParagraph(
			`No puedes entrar. Debes tener al menos ${LEGAL_AGE} años.`,
			'access-denied'
		);
		return false;
	}

	formatInfoParagraph(
		`Puedes entrar, ${username}.`,
		'access-granted'
	);
	return true;
}

/**
 * Función encargada de redireccionar a la sección del juego.
 */
function redirectToGame() {
	removeEventListenerAudio(redirectToGame);

	const form = document.getElementsByTagName('form')[0];
	form.submit();
}

/**
 * Función encargada de comprobar los datos del formulario, guardando el nombre
 * introducido y en el caso de que la edad sea mayor de la establecida como
 * mayoría de edad, ejecutar un sonido y una redirección.
 */
function useDataFields() {
	saveUsername();
	saveTerror();
	if (checkLegalAge()) {
		executeSound('door');
		addEventListenerAudio(redirectToGame);
	}
}

/**
 * Comprueba que el checkbox está seleccionado.
 * @returns {boolean} - Devuelve el valor del atributo checked.
 */
function isChecked() {
	const checkbox = document.getElementById('accept');
	return checkbox.checked;
}

/**
 * Valida un correo electrónico.
 * @returns {boolean} Devuelve true si el correo electrónico es válido, de lo contrario devuelve false.
 */
function validateEmail() {
	const email = document.getElementById('email').value;
	const regex = new RegExp(
		'^[\\w!#$%&\'*+\\-/?^=`{|}~]+(\\.[\\w!#$%&\'*+\\-/?^=`{|}~]+)*@[a-zA-Z\\d-]+(\\.[a-zA-Z\\d-]{2,})*$'
	);

	return regex.test(email);
}

/**
 * Valida un número de teléfono en formato español.
 * @returns {boolean} Devuelve true si el número de teléfono es válido, de lo contrario devuelve false.
 */
function validatePhone() {
	const phonenumber = document.getElementById('phonenumber').value;
	const regex = new RegExp('^(\\+34)?\\s?[679]\\d{8}$');

	return regex.test(phonenumber);
}

/**
 * Función encargada de comprobar que los campos del formulario están completos.
 */
function checkFields(evento) {
	evento.preventDefault();
	const inputs = document.getElementsByTagName('input');

	for (const input of inputs) {
		if (input.value.trim() === '') {
			formatInfoParagraph(
				'Debes completar todos los campos.',
				'access-denied');
			return;
		}
	}

	if (!isChecked()) {
		formatInfoParagraph('Debes aceptar el aviso.', 'access-denied');
		return;
	}

	if (!validateEmail()) {
		formatInfoParagraph('El email no tiene un formato válido.', 'access-denied');
		return;
	}

	if (!validatePhone()) {
		formatInfoParagraph('El teléfono no tiene un formato válido.', 'access-denied');
		return;
	}

	useDataFields();
}

/**
 * Comprueba el estado de almacenamiento local para determinar si la clave 'endgame'
 * tiene un valor.
 * Si la clave 'endgame' tiene un valor, redirige a la página
 * './pages/endgame.html'.
 *
 * @returns {boolean} - Devuelve true si la clave 'endgame' no tiene un valor,
 * 						de lo contrario, false.
 */
function checkStorage() {
	const endgame = localStorage.getItem('endgame');

	if (endgame) {
		window.location = './pages/endgame.html';
		return false;
	}

	return true;
}

/**
 * Función encargada de añadir un elemento de escucha al botón con
 * id btn-start.
 */
function init() {
	if (checkStorage()) {
		const form = document.getElementsByTagName('form')[0];
		form.addEventListener('submit', checkFields);
	}
}

// INICIADOR DEL PROGRAMA
window.addEventListener('DOMContentLoaded', init);

// VARIABLES GLOBALES
const LEGAL_AGE = 18; // Constante con la edad que establece la mayoría de edad.
let username; // Variable que guarda el nombre del usuario.
