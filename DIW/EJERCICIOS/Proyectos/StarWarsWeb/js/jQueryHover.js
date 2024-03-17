/**
 * Script jQuery para gestionar el comportamiento de eventos de ratón en elementos h2 y h4.
 * Se utiliza para cambiar estilos y agregar interactividad al pasar el ratón sobre los elementos.
 *
 * @script
 */

$(document).ready(function(){
	// Agrega un manejador de eventos a los elementos h2 cuando el ratón entra en ellos.
	$('h2').mouseenter(function(){
		$(this).css({
			'filter': 'brightness(1.2)',
			'text-decoration': 'underline',
			'color': 'red',
			'cursor': 'pointer'
		});
	})
		// Agrega un manejador de eventos a los elementos h2 cuando el ratón sale de ellos.
		.mouseout(function(){
			$(this).css({
				'filter': 'brightness(1)',
				'text-decoration': 'none',
				'color': 'yellow'
			});
		});

	// Agrega un manejador de eventos a los elementos h4 cuando el ratón entra en ellos.
	$('h4').mouseenter(function () {
		$(this).css({
			'cursor': 'pointer',
			'text-decoration': 'underline'
		});
	})
		// Agrega un manejador de eventos a los elementos h4 cuando el ratón sale de ellos.
		.mouseout(function(){
			$(this).css({ 'text-decoration': 'none' });
		});
});
