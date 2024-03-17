$(document).ready(function() {
	$('#blog h3').click(function(e) {
		e.preventDefault();
		const paragraph = $(this).next('p'); // Selecciona el párrafo correspondiente al titular clicado
		if (paragraph.is(':visible')) {
			paragraph.slideUp(); // Si el párrafo está visible, lo oculta con un efecto de deslizamiento
		} else {
			$('#blog p:visible').slideUp(); // Oculta cualquier párrafo visible
			paragraph.slideDown(); // Muestra el párrafo correspondiente con un efecto de deslizamiento
		}
	});
});