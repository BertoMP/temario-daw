/**
 * Script jQuery para gestionar la carga dinámica de contenido al hacer clic en elementos h4,
 * utilizando datos provenientes de un archivo HTML externo.
 *
 * @script
 */

$(document).ready(function() {
	// Selecciona el contenedor principal de las películas.
	const $films = $('#section-peliculas');

	// Para cada elemento h4, crea un elemento div oculto y almacena la referencia.
	$films.find('h4').each(function() {
		const $this = $(this);
		const $elementoObjetivo = $('<div/>').insertAfter($this);
		$elementoObjetivo.css({ 'display': 'none' });
		$this.data('elementoObjetivo', $elementoObjetivo);
	}).click(function() {
		// Al hacer clic en un elemento h4, obtiene el elemento div asociado y el id del h4.
		const $this = $(this);
		const id = `#${this.id}`;
		const $target = $this.data('elementoObjetivo');

		// Realiza una petición AJAX para cargar el contenido desde el archivo HTML externo.
		$.ajax({
			url: 'data/films.html',
			dataType: 'html',
			success: function(response) {
				// Filtra el contenido del archivo HTML según el id del h4 y lo clona en el elemento div.
				const $response = $(response);
				const $tablaSeleccionada = $response.filter(id).clone();

				// Inserta el contenido clonado en el elemento div objetivo.
				$target.html($tablaSeleccionada);
			},
			error: function(xhr, status, error) {
				console.error('Error al cargar el archivo:', error);
			}
		});
	});
});
