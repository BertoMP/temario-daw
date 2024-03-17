/**
 * Función para alternar la visibilidad del menú y del panel lateral.
 */
function toogleMenu() {
	const btnMenu = document.getElementById('menu');
	btnMenu.classList.toggle('activo');
	const aside = document.getElementById('aside');
	aside.classList.toggle('visible');

	return;
}

/**
 * Agrega un evento de escucha al botón del menú para activar la función toggleMenu.
 */
function addEventosEscucha() {
	const btnMenu = document.getElementById('menu');
	btnMenu.addEventListener('click', toogleMenu);

	return;
}

/**
 * Inicializa la funcionalidad del menú desplegable agregando los eventos de escucha.
 */
function init() {
	addEventosEscucha();

	return;
}

// Agrega un evento que inicie la funcionalidad una vez que se ha cargado todo el contenido HTML.
window.addEventListener('DOMContentLoaded', init);
