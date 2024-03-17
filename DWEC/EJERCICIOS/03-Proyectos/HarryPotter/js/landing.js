/**
 * Guarda el nombre del usuario en el almacenamiento local.
 *
 * @function
 * @returns {void}
 */
function saveData() {
	const userName = document.getElementById('name').value.trim();
	localStorage.setItem('name', userName);
}

/**
 * Envía el formulario actual.
 *
 * @function
 * @returns {void}
 */
function formSubmit() {
	const form = document.getElementsByTagName('form')[0];
	form.submit();
}

/**
 * Formatea un párrafo de información en la página.
 * - Obtiene la referencia al párrafo de información.
 * - Crea un nuevo párrafo si no existe uno.
 * - Actualiza la clase y el contenido del párrafo de información.
 *
 * @function
 * @param {string} message - El mensaje que se mostrará en el párrafo de información.
 * @param {string} classAssociated - La clase que se añadirá al párrafo de información.
 * @returns {void}
 */
function createInfoParagraph(message, classAssociated) {
	const newParagraph = document.createElement('p');
	newParagraph.setAttribute('class', classAssociated);
	newParagraph.innerHTML = message;

	const form = document.getElementById('form-hogwarts');
	form.appendChild(newParagraph);
}

/**
 * Valida un correo electrónico según un formato específico.
 *
 * @function
 * @returns {boolean} - Devuelve true si el correo electrónico es válido, o false si no lo es.
 */
function validateEmail() {
	const email = document.getElementById('email').value;
	const regex = new RegExp(
		'^[\\w!#$%&\'*+\\-/?^`={|}~]+(\\.[\\w!#$%&\'*+\\-/?^`={|}~]+)*@[a-zA-Z\\d-]+(\\.[a-zA-Z\\d-]{2,})*$'
	);

	return regex.test(email);
}

/**
 * Valida un número de teléfono según un formato específico.
 *
 * @function
 * @returns {boolean} - Devuelve true si el número de teléfono es válido, o false si no lo es.
 */
function validatePhone() {
	const phone = document.getElementById('phone').value;
	const regex = new RegExp('^(\\+34)?[\\s|\\-]?[679]\\d{8}$');

	return regex.test(phone);
}

/**
 * Valida un nombre según un formato específico.
 *
 * @function
 * @returns {boolean} - Devuelve true si el nombre es válido, o false si no lo es.
 */
function validateName() {
	const name = document.getElementById('name').value;
	const regex = new RegExp('^[A-ZÀ-ÖØ-ß][a-zà-öø-ý]+([\\s-][A-ZÀ-ÖØ-ß][a-zà-öø-ý]+)?$');

	return regex.test(name);
}

/**
 * Verifica si la casilla de verificación de aceptación de términos está seleccionada.
 * - Obtiene la referencia a la casilla de verificación.
 * - Muestra un mensaje de error si la casilla no está seleccionada.
 * - Elimina el mensaje de error si la casilla está seleccionada.
 *
 * @function
 * @returns {boolean} - Devuelve true si la casilla está seleccionada, o false si no lo está.
 */
function isChecked() {
	const checkbox = document.getElementById('accept-terms');

	// Verifica si la casilla de verificación no está seleccionada y muestra un mensaje de error si es así.
	if (!checkbox.checked) {
		formatSmall(checkbox, 'Debes aceptar el uso de datos.', 'access-denied');
		return false;
	}

	// Elimina el mensaje de error si la casilla de verificación está seleccionada.
	deleteSmall(checkbox);

	// La casilla de verificación está seleccionada.
	return true;
}

/**
 * Verifica la validez del campo de correo electrónico en el formulario.
 * - Obtiene la referencia al elemento de entrada de correo electrónico.
 * - Comprueba si el valor está vacío y muestra un mensaje de error si es así.
 * - Llama a la función 'validateEmail' para verificar si el correo electrónico cumple con un formato válido.
 * - Establece la apariencia del campo de correo electrónico según la validación.
 *
 * @function
 * @returns {boolean} - Devuelve true si el campo de correo electrónico es válido, o false si no lo es.
 */
function checkEmail() {
	const inputEmail = document.getElementById('email');

	// Verifica si el valor del campo de correo electrónico está vacío y muestra un mensaje de error si es así.
	if (inputEmail.value.trim() === '') {
		invalidInput(inputEmail, 'El email no puede estar vacío.');
		return false;
	}

	// Verifica si el correo electrónico cumple con un formato válido.
	if (!validateEmail()) {
		invalidInput(inputEmail, 'El email no tiene un formato válido.');
		return false;
	}

	// Establece la apariencia del campo de correo electrónico como válido.
	validInput(inputEmail);

	// El campo de correo electrónico es válido.
	return true;
}

/**
 * Formatea o crea un elemento 'small' asociado a un campo de entrada específico con un mensaje y una clase asociada.
 * Si ya existe un elemento 'small' asociado, actualiza su contenido; de lo contrario, crea uno nuevo.
 *
 * @function
 * @param {HTMLElement} input - El elemento de entrada (input) al que se asociará el elemento 'small'.
 * @param {string} message - El mensaje que se mostrará en el elemento 'small'.
 * @param {string} associatedClass - La clase que se añadirá al elemento 'small'.
 * @returns {void}
 */
function formatSmall(input, message, associatedClass) {
	const small = document.getElementById(`small-${input.id}`);

	// Si no existe un elemento 'small' asociado, crea uno nuevo.
	if (!small) {
		const small = document.createElement('small');
		small.id = `small-${input.id}`;
		small.innerHTML = message;
		small.classList.add(associatedClass);
		input.parentNode.appendChild(small);
		return;
	}

	// Si ya existe un elemento 'small' asociado, actualiza su contenido.
	small.innerHTML = message;
}

/**
 * Elimina un elemento 'small' asociado a un campo de entrada específico.
 *
 * @function
 * @param {HTMLElement} input - El elemento de entrada (input) al que se asocia el elemento 'small'.
 * @returns {void}
 */
function deleteSmall(input) {
	const small = document.getElementById(`small-${input.id}`);

	// Verifica si existe un elemento 'small' asociado y lo elimina.
	if (small) {
		small.remove();
	}
}

/**
 * Establece la apariencia de un campo de entrada como inválido y muestra un mensaje de error asociado.
 *
 * @function
 * @param {HTMLElement} input - El elemento de entrada (input) que se marcará como inválido.
 * @param {string} message - El mensaje de error que se mostrará.
 * @returns {void}
 */
function invalidInput(input, message) {
	input.setAttribute('class', 'invalid');
	formatSmall(input, message, 'access-denied');
}

/**
 * Restaura la apariencia del campo de entrada y elimina mensajes de error asociados.
 *
 * @function
 * @param {HTMLElement} input - El elemento de entrada (input) que se validará.
 * @returns {void}
 */
function validInput(input) {
	input.setAttribute('class', '');
	deleteSmall(input);
}

/**
 * Verifica la validez del campo de teléfono en el formulario.
 * - Obtiene la referencia al elemento de entrada de teléfono.
 * - Comprueba si el valor está vacío y muestra un mensaje de error si es así.
 * - Llama a la función 'validatePhone' para verificar si el teléfono cumple con un formato válido.
 * - Actualiza la apariencia del campo de teléfono según la validación.
 *
 * @function
 * @returns {boolean} - Devuelve true si el campo de teléfono es válido, o false si no lo es.
 */
function checkPhone() {
	const inputPhone = document.getElementById('phone');

	// Verifica si el valor del campo de teléfono está vacío y muestra un mensaje de error si es así.
	if (inputPhone.value.trim() === '') {
		invalidInput(inputPhone,'El teléfono no puede estar vacío.');
		return false;
	}

	// Verifica si el teléfono cumple con un formato válido.
	if (!validatePhone()) {
		invalidInput(inputPhone,'El teléfono introducido no cumple con un formato válido.');
		return false;
	}

	// Restaura la apariencia del campo de teléfono y elimina mensajes de error.
	validInput(inputPhone);

	// El campo de teléfono es válido.
	return true;
}

/**
 * Verifica la validez del campo de nombre en el formulario.
 * - Obtiene la referencia al elemento de entrada de nombre.
 * - Comprueba si el valor está vacío y muestra un mensaje de error si es así.
 * - Llama a la función 'validateName' para verificar si el nombre cumple con un patrón válido.
 * - Actualiza la apariencia del campo de nombre según la validación.
 *
 * @function
 * @returns {boolean} - Devuelve true si el campo de nombre es válido, o false si no lo es.
 */
function checkName() {
	const inputName = document.getElementById('name');

	// Verifica si el valor del campo de nombre está vacío y muestra un mensaje de error si es así.
	if (inputName.value.trim() === '') {
		invalidInput(inputName, 'El nombre no puede estar vacío.');
		return false;
	}

	// Verifica si el nombre cumple con un patrón válido.
	if (!validateName()) {
		invalidInput(inputName, 'El nombre no cumple con un patrón válido.');
		return false;
	}

	// Restaura la apariencia del campo de nombre y elimina mensajes de error.
	validInput(inputName);

	// El campo de nombre es válido.
	return true;
}

/**
 * Verifica los datos del formulario y realiza acciones correspondientes.
 * - Previene el comportamiento predeterminado del evento.
 * - Verifica la validez de los campos del formulario llamando a funciones específicas.
 * - Si todos los campos son válidos, muestra un mensaje, guarda los datos y realiza una redirección.
 *
 * @function
 * @param {Event} event - El objeto de evento asociado al clic del botón de inicio.
 * @returns {void}
 */
function checkData(event) {
	// Evita el comportamiento por defecto del botón del formulario (submit).
	event.preventDefault();

	// Funciones de validación para cada campo del formulario.
	const functions = [checkName(), checkPhone(), checkEmail(), isChecked()];

	let blnFlag = true;

	// Verifica cada función de validación y establece el indicador de bandera en false si alguna falla.
	for (const functionField of functions) {
		if (!functionField) {
			blnFlag = false;
		}
	}

	// Si todos los campos son válidos, muestra un mensaje, guarda los datos y realiza el submit del formulario.
	if (blnFlag) {
		createInfoParagraph('Puedes acceder al cuestionario', 'access-granted');
		saveData();
		setTimeout(formSubmit, 1000);
	}
}

/**
 * Verifica el almacenamiento local para determinar el estado de la aplicación.
 * Redirige a páginas específicas dependiendo de la existencia de ciertos datos en el almacenamiento local.
 *
 * @function
 * @returns {boolean}	Devuelve true si no se encuentran datos almacenados y la aplicación puede continuar,
 *                     	o devuelve false si se redirige a una página específica.
 */
function checkStorage() {
	const selectedHouse = localStorage.getItem('selectedHouse');

	// Si se ha seleccionado una casa previamente, redirige a la página de casa seleccionada.
	if (selectedHouse !== null && selectedHouse !== '') {
		window.location = './pages/houseSelected.html';
		return false;
	}

	const userName = localStorage.getItem('name');

	// Si hay un nombre de usuario almacenado, redirige al cuestionario.
	if (userName !== null && selectedHouse !== '') {
		window.location = './pages/questionnaire.html';
		return false;
	}

	// No se encontraron datos almacenados, la aplicación puede continuar.
	return true;
}

/**
 * Inicializa la aplicación.
 * Verifica si hay datos almacenados llamando a la función 'checkStorage'.
 * Si hay datos almacenados, agrega un evento de clic al botón con id 'btn-start' que ejecuta la función 'checkData'.
 *
 * @function
 * @returns {void}
 */
function init() {
	if (checkStorage()) {
		const btnStart = document.getElementById('btn-start');

		/**
		 * Evento que se dispara al hacer clic en el botón de inicio.
		 *
		 * @event
		 * @listens click
		 * @returns {void}
		 */
		btnStart.addEventListener('click', checkData);
	}
}

/**
 * Evento que se ejecuta cuando el DOM ha sido completamente cargado,
 * inicializa la aplicación llamando a la función 'init'.
 *
 * @event
 * @listens DOMContentLoaded
 * @returns {void}
 */
window.addEventListener('DOMContentLoaded', init);