$(document).ready(function() {
	// Seleccionar los elementos de navegación
	const elementosNav = $('#nav li');
	elementosNav.hover(mostrarSubMenu, ocultarSubMenu);
	// Función para mostrar el submenú
	function mostrarSubMenu() {
		// Añade la clase hover
		$(this).addClass('hover');
		const elementosHijos = $(this).find('ul');
		// Si existen elementos hijo
		if (elementosHijos.length > 0) {
			elementosHijos.slideDown();
		}
	}

	// Función para ocultar el submenú
	function ocultarSubMenu() {
		// Elimina la clase hover
		$(this).removeClass('hover');
		const elementosHijos = $(this).find('ul');
		// Si existen elementos hijo
		if (elementosHijos.length > 0) {
			elementosHijos.slideUp();
		}
	}
});