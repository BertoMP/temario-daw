/**
 * Función encargada de eliminar un elemento audio al documento.
 *
 * @param {HTMLElement} btnMusic - Elemento HTML que actúa como activador
 * 								   del evento.
 */
function removeAudioElement(btnMusic) {
	const audio = document.getElementById('audio-activo');
	document.body.removeChild(audio);

	btnMusic.classList.remove('fa-stop');
	btnMusic.classList.remove('sonidoActivado');
	btnMusic.classList.add('fa-music');
}

/**
 * Función encargada de devolver la ruta del sonido pasado por
 * parámetro.
 *
 * @param soundName - El sonido del que se quiere conocer la ruta.
 * @returns {string} - Devuelve un string con la ruta del sonido.
 */
function getSoundPath(soundName) {
	const sounds = {
		halloween: './audios/halloweenTheme.mp3',
		saw: './audios/sawTheme.mp3',
		door: './audios/sonidoPuerta.mp3',
		lockedDoor: './audios/lockedDoor.mp3',
		footsteps: './audios/pisadas.mp3',
		laugh: './audios/carcajada.mp3',
		zombie: './audios/zombie.mp3',
		scape: './audios/huida.mp3',
		brokenGlass: './audios/roturaCristales.mp3',
		run: './audios/correr.mp3',
		punches: './audios/punches.mp3',
		thunder: './audios/thunder.mp3',
		vampiro: './audios/vampiro.mp3',
		'hombre lobo': './audios/hombreLobo.mp3',
		fantasma: './audios/fantasma.mp3',
		'payaso asesino': './audios/payasoLoco.mp3',
		demonio: './audios/demonio.mp3'
	};

	let path = sounds[soundName];

	if (!window.location.pathname.includes('index.html')) {
		path = `.${path}`;
	}

	return path;
}

/**
 * Elimina un evento de tipo 'ended' al elemento audio.
 *
 * @param functionToDelete - La función asociada al evento.
 */
function removeEventListenerAudio(functionToDelete) {
	const audioElement = document.getElementById('audio');
	audioElement.removeEventListener('ended', functionToDelete);
}

/**
 * Añade un evento de tipo 'ended' al elemento audio.
 *
 * @param functionToTrigger - La función asociada al evento.
 */
function addEventListenerAudio(functionToTrigger) {
	const audioElement = document.getElementById('audio');
	audioElement.addEventListener('ended', functionToTrigger);
}

/**
 * Función encargada de crear y devolver un elemento HTML de tipo audio.
 *
 * @returns {HTMLAudioElement} - Devuelve un elemento <audio>.
 */
function createAudioElement() {
	const elementoAudio = document.createElement('audio');
	elementoAudio.id = 'audio';

	return elementoAudio;
}

/**
 * Función encargada de ejecutar el sonido pasado por parámetro.
 *
 * @param {string} sonido - Sonido a reproducir.
 */
function executeSound(sonido) {
	let elementoAudio = document.getElementById('audio');

	if (!elementoAudio) {
		elementoAudio = createAudioElement();
		document.body.appendChild(elementoAudio);
	}

	elementoAudio.src = getSoundPath(sonido);
	elementoAudio.autoplay = true;
}

/**
 * Función encargada de añadir un elemento audio al documento.
 *
 * @param {HTMLElement} btnMusic - Elemento HTML que actúa como activador
 * 								   del evento.
 */
function addAudioElement(btnMusic) {
	const audio = document.createElement('audio');
	const song = window.location.pathname.includes('index.html') ? 'halloween' : 'saw';
	audio.src = getSoundPath(song);
	audio.id = 'audio-activo';
	audio.loop = true;
	audio.autoplay = true;

	btnMusic.classList.remove('fa-music');
	btnMusic.classList.add('fa-stop');
	btnMusic.classList.add('sonidoActivado');

	document.body.appendChild(audio);
}

/**
 * Función encargada de gestionar si se añade o elimina un elemento de
 * tipo <audio>.
 */
function toggleMusic() {
	const btnMusic = document.getElementById('btn-music');

	if (btnMusic.classList.contains('fa-stop')) {
		removeAudioElement(btnMusic);
		return;
	}

	addAudioElement(btnMusic);
}

/**
 * Función encargada de añadir un elemento de escucha al botón con
 * id btn-music.
 */
function init() {
	const btnMusic = document.getElementById('btn-music');
	btnMusic.addEventListener('click', toggleMusic);
}

window.addEventListener('DOMContentLoaded', init);