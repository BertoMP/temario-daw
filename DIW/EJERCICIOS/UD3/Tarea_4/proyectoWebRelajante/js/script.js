/**
 * Crea un elemento de audio con el nombre proporcionado y lo agrega al
 * cuerpo del documento HTML.
 * @param {string} nombreBoton - El nombre del botón para generar la ruta
 * 								 del archivo de audio.
 */
function addElementoMusica(nombreBoton) {
	const audio = document.createElement('audio');
	audio.id = 'audio';
	audio.loop = true;
	audio.autoplay = true;
	audio.src = `./audio/${nombreBoton}.mp3`;

	document.body.appendChild(audio);
}

/**
 * Elimina el elemento de audio del cuerpo del documento HTML, si existe.
 */
function removeElementoAudio() {
	const audio = document.getElementById('audio');

	if (audio) {
		document.body.removeChild(audio);
	}
}

/**
 * Cambia la apariencia de un botón para indicar que la música está activada.
 * @param {string} idBoton - El ID del botón que se modificará.
 */
function cambiaBoton(idBoton) {
	const boton = document.getElementById(idBoton);
	boton.setAttribute('class', '');
	boton.classList.add('fa-solid');
	boton.classList.add('fa-stop');
	boton.classList.add('sonidoActivado');
}

/**
 * Formatea todos los botones para indicar que la música está desactivada.
 */
function formateaBotones() {
	const botones = document.getElementsByTagName('i');

	for (const boton of botones) {
		boton.setAttribute('class', '');
		boton.classList.add('fa-solid');
		boton.classList.add('fa-play');
	}
}

/**
 * Controla el evento de clic en los botones para activar/desactivar la música.
 * @param {Event} evento - El evento de clic en un botón.
 */
function toogleMusic(evento) {
	const elementoEvento = evento.target.localName;

	if (elementoEvento === 'i') {
		const idBoton = evento.target.id;
		const boton = document.getElementById(idBoton);

		if (boton.classList.contains('fa-stop')) {
			formateaBotones();
			removeElementoAudio();
		} else {
			const nombreBoton = evento.target.id.split('-')[1];
			formateaBotones();
			cambiaBoton(evento.target.id);
			removeElementoAudio();
			addElementoMusica(nombreBoton);
		}
	}
}

/**
 * Agrega un evento de escucha inicial a la sección de botones.
 */
function addEventoEscuchaInicial() {
	const contenedorBotones = document.getElementsByClassName('contenedor-grid')[0];
	contenedorBotones.addEventListener('click', toogleMusic);
}

window.addEventListener('DOMContentLoaded', addEventoEscuchaInicial);