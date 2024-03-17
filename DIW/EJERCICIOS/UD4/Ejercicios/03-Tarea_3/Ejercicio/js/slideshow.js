$(document).ready(function() {
	// Variable para el temporizador
	let timeout = false;

	// Variable para el modo manual de navegación
	let modoManual = false;

	// Selecciona el slideshow y lo mueve al contenedor principal
	const slideshow = $('#slideshow').prependTo('#main');

	// Oculta todos los elementos li del slideshow
	const elementos = slideshow.find('li').hide();

	// Obtiene el total de elementos
	const total = elementos.length;

	// Crea un div para el contador y lo inserta después del slideshow
	const contador = $('<div/>').insertAfter(slideshow);

	// Crea un div para los controles y lo inserta después del slideshow
	const controles = $('<div/>').insertAfter(slideshow);

	// Crea un botón 'anterior' y lo añade a los controles
	const btnAnterior = $('<input/>', {
		type: 'button',
		value: 'Anterior'
	}).appendTo(controles);

	// Crea un botón 'siguiente' y lo añade a los controles
	const btnSiguiente = $('<input/>', {
		type: 'button',
		value: 'Siguiente'
	}).appendTo(controles);

	// Función para actualizar el contador con el número de foto actual
	function actualizarContador(num) {
		contador.text('Foto ' + num + ' de ' + total);
	}

	// Función para obtener el elemento a mostrar, según la dirección (anterior/siguiente)
	function obtenerElemento($item, trav) {
		const elementoDevuelto = $item[trav]();
		return elementoDevuelto.length ?
			elementoDevuelto :
			elementos[(trav == 'next') ? 'first' : 'last']();
	}

	// Función para mostrar un elemento, con fade in/out y llamada a callbackFade
	function mostrarElemento($elementoActual, $elementoAMostrar) {
		$elementoAMostrar = $elementoAMostrar || obtenerElemento($elementoActual, 'next');

		$elementoActual.fadeOut(500, function() {
			$elementoAMostrar.fadeIn(500, callbackFade);
		});
	}

	// Función de callback para el fade, maneja la lógica de cambio automático de elementos
	function callbackFade() {
		if (modoManual) { return; }

		const $this = $(this);
		const siguiente = obtenerElemento($this, 'next');
		const num = $this.prevAll().length + 1;

		// Actualiza el contador con el número de foto actual
		actualizarContador(num);

		// Establece el temporizador para mostrar el siguiente elemento en 5 segundos
		timeout = setTimeout(function() {
			mostrarElemento($this, siguiente);
		}, 5000);
	}

	// Función para manejar el click en los botones 'anterior' y 'siguiente'
	function manejarClickBoton(e) {
		clearTimeout(timeout);
		modoManual = true;

		const elementoActual = elementos.filter(':visible');
		const elementoAMostrar = obtenerElemento(elementoActual, e.data.direccion);

		mostrarElemento(elementoActual, elementoAMostrar);
		const num = elementoAMostrar.prevAll().length + 1;
		actualizarContador(num);
	}

	// Eventos clic para los botones 'anterior' y 'siguiente', con manejo de dirección
	btnAnterior.bind('click', { direccion: 'prev' }, manejarClickBoton);
	btnSiguiente.bind('click', { direccion: 'next' }, manejarClickBoton);

	// Muestra el primer elemento del slideshow con fade in y llama a callbackFade
	elementos.eq(0).fadeIn(500, callbackFade);
});

