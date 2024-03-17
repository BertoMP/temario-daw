$(document).ready(function() {
	// Selecciona el elemento con el ID 'blog'
	const $blog = $('#blog');

	// Encuentra todos los elementos 'h3' dentro de #blog
	$blog.find('h3').each(function() {
		const $this = $(this);
		// Crea un nuevo elemento 'div' y lo inserta después del 'h3'
		const $target = $('<div/>').insertAfter($this);

		// Almacena una referencia al div recién creado en los datos del 'h3' actual
		$this.data('target', $target);
	}).click(function(e) {
		// Cuando se hace clic en un 'h3'
		const $this = $(this);
		const $a = $this.find('a'); // Encuentra el elemento 'a' dentro del 'h3'
		const $target = $this.data('target'); // Obtiene el div almacenado en los datos del 'h3'
		const href = $a.attr('href'); // Obtiene el atributo href del 'a'
		const id = '#' + href.split('#')[1]; // Extrae el ID del enlace

		console.log(id); // Imprime el ID en la consola
		e.preventDefault(); // Previene el comportamiento predeterminado del enlace

		// Carga el contenido del archivo 'blog.html' en el div objetivo usando el ID extraído
		$target.load('data/blog.html ' + id);
	});
});
