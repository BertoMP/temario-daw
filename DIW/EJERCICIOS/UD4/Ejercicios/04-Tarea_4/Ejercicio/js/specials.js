// Se ejecuta cuando el documento HTML está completamente cargado y listo para interactuar.
$(document).ready(function() {
	// Selecciona el elemento con el ID #specials y elimina el elemento <li> con la clase
	// .buttons que se encuentra dentro.
	const $specials = $('#specials');
	$specials.find('li.buttons').remove();

	// Variable para almacenar la respuesta JSON obtenida de la solicitud AJAX.
	let cachedResponse = null;

	// Crea un elemento <div> que servirá para mostrar los detalles del usuario.
	const $details = $('<div/>').appendTo($specials);

	// Función que maneja la respuesta JSON y muestra los detalles correspondientes al día seleccionado.
	const handleResponse = function (specials, val) {
		// Obtiene los detalles del usuario basados en el día seleccionado.
		const daySpecial = specials[val];

		// Construye el contenido HTML para mostrar los detalles del usuario.
		let html = '<h3>' + daySpecial.title + '</h3>';
		html += '<p>' + daySpecial.text + '</p>';

		// Coloca el contenido HTML en el elemento <div> creado anteriormente.
		$details.html(html);

		// Crea una imagen utilizando la URL proporcionada y la agrega al elemento <div>.
		$('<img/>').attr('src', daySpecial.image).appendTo($details);

		// Establece el color del texto en el elemento <div> utilizando la información proporcionada.
		$details.css('color', daySpecial.color);
	};

	// Selecciona el elemento <select> dentro del elemento con ID #specials y establece un evento de cambio.
	const $select = $specials.find('select').change(function () {
		// Obtiene el valor seleccionado en el menú desplegable.
		const val = $select.val();

		// Si no se ha seleccionado ningún valor, vacía el elemento <div> que muestra los detalles.
		if (!val) {
			$details.empty(); // Vacía el contenido del elemento <div> donde se muestran los detalles.
			return;
		}

		// Si hay un valor seleccionado, llama a la función handleResponse con la respuesta almacenada
		// y el valor seleccionado.
		handleResponse(cachedResponse, val);
	});

	// Realiza una solicitud Ajax para obtener el archivo JSON.
	$.ajax({
		type: 'get', // Método HTTP GET
		dataType: 'json', // Tipo de datos esperados en la respuesta
		url: 'data/specials.json', // URL del archivo JSON
		success: function (specials) {
			cachedResponse = specials; // Almacena la respuesta JSON en la variable cachedResponse

			// Obtiene el valor seleccionado actualmente en el menú desplegable.
			const val = $select.val();

			// Verifica si hay un valor seleccionado y si se ha almacenado una respuesta JSON.
			if (val && cachedResponse) {
				handleResponse(val); // Llama a la función handleResponse con el valor seleccionado
			}
		}
	});

});
