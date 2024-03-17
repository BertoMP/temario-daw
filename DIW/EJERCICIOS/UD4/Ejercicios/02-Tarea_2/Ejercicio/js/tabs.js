$(document).ready(function() {
	// Constantes que almacenan los elementos div con clase module y la lista desordenada.
	const modulos = $('div.module');
	const listado = $('<ul class="tabs"></ul>').insertBefore(modulos.first());

	// Ocultar todos los elementos div.module excepto el primero.
	modulos.not(':first').hide();

	// Iterar sobre cada div.module y crear la lista de pestañas.
	modulos.each(function(index) {
		const titulo = $(this).find('h2').text();
		$('<li><a href="#tab' + index + '">' + titulo + '</a></li>').appendTo(listado);
	});

	// Mostrar la primera pestaña.
	listado.find('li:first').addClass('current');

	// Manejar el cambio de pestañas al hacer clic.
	listado.on('click', 'li', function(e) {
		e.preventDefault();
		const index = $(this).index();

		modulos.hide().eq(index).show(); // Oculta todos los div.module y muestra el correspondiente al índice.
		$(this).addClass('current').siblings().removeClass('current'); // Gestiona las clases "current".
	});
});
