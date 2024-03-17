/**
 * Script jQuery para gestionar el comportamiento del clic en los títulos de las películas.
 * Se utiliza para mostrar y ocultar información adicional sobre cada película.
 *
 * @script
 */

$(document).ready(function() {
	// Selecciona la sección de películas.
	const $films = $('#section-peliculas');

	// Agrega un manejador de eventos al hacer clic en los títulos de las películas.
	$films.find('h4').click(function() {
		// Encuentra el siguiente elemento div asociado al título clicado.
		const div = $(this).next('div');

		// Verifica si el div está visible.
		if (div.is(':visible')) {
			// Si está visible, oculta el div.
			div.slideUp();
		} else {
			// Si no está visible, oculta cualquier div visible y luego muestra el div asociado al título clicado.
			setTimeout(function () {
				$films.find('div:visible').slideUp();
				div.slideDown();
			}, 100);
		}
	});
});