/**
 * Oculta todos los elementos que funcionan como contenedor de películas.
 */
function repliegaMenus() {
	const contenedoresPelis = document.querySelectorAll('h2+section');
	for (const contenedor of contenedoresPelis) {
		contenedor.classList.remove('activo');
	}

	return;
}

/**
 * Muestra el siguiente elemento 'section' al 'h2' sobre el que se hace clic y se desplaza la ventana a la altura de
 * dicho elemento.
 * @param evento
 */
function despliegaPelis(evento) {
	const elemento = evento.target;

	if (elemento.localName === 'h2') {
		repliegaMenus();
		elemento.nextElementSibling.classList.add('activo');
		elemento.scrollIntoView({ behavior: 'smooth' });
	}

	return;
}

/**
 * Agrega un evento de escucha al elemento 'main' del documento.
 */
function addEventoEscucha() {
	const main = document.getElementsByTagName('main')[0];
	main.addEventListener('click', despliegaPelis);

	return;
}

/**
 * Inicializa el script agregando el evento de escucha.
 */
function init() {
	addEventoEscucha();

	return;
}

window.addEventListener('DOMContentLoaded', init);