/**
 * Cierra la ventana actual del navegador.
 */
function closeWindow() {
	window.close();
}

// FORMATEO SECTION
/**
 * Función encargada de formatear el elemento section principal del juego.
 *
 * @param backgroundName - Nombre de la imagen de fondo a utilizar.
 * @param soundName - Nombre del sonido a ejecutar.
 * @param h2Text - Texto del elemento H2.
 * @param pText - Texto del elemento p.
 * @param buttons - Array que contiene los botones a crear.
 */
function formatSection(backgroundName, soundName, h2Text, pText, buttons) {
	removeButtons();

	if (backgroundName) {
		changeBackgroundImage(backgroundName);
	}

	executeSound(soundName);
	formatH2(h2Text);
	formatP(pText);

	if (buttons) {
		for (const button of buttons) {
			createButton(button[0], button[1]);
		}
	}
}

/**
 * Función encargada de eliminar los botones del elemento section.
 */
function removeButtons() {
	const buttons = Array.from(document.getElementsByTagName('button'));

	buttons.forEach(button => {
		button.remove();
	});
}

/**
 * Función encargada de crear un elemento button.
 *
 * @param buttonText - Texto que tendrá el botón
 * @param buttonEvent - Evento asociado al botón.
 */
function createButton(buttonText, buttonEvent) {
	const section = document.getElementById('section-contenido');

	const button = document.createElement('button');
	button.innerHTML = buttonText;
	button.addEventListener('click', buttonEvent);

	section.appendChild(button);
}

/**
 * Función encargada de eliminar el elemento H3.
 */
function removeH3() {
	const h3 = document.getElementById('section-h3');
	h3.remove();
}

/**
 * Función encargada de crear e insertar un elemento H3 en el section.
 */
function createH3() {
	const section = document.getElementById('section-contenido');
	const h3 = document.createElement('h3');
	h3.id = 'section-h3';
	h3.innerHTML = 'NO TE MUEVAS...';
	section.appendChild(h3);
}

/**
 * Función encargada de formatear el elemento p con el mensaje pasado
 * por parámetro.
 *
 * @param mensaje - Mensaje a incrustar en el p.
 */
function formatP(mensaje) {
	const p = document.getElementById('section-p');
	p.innerHTML = mensaje;
}

/**
 * Función encargada de formatear el elemento h2 con el mensaje pasado
 * por parámetro.
 *
 * @param mensaje - Mensaje a incrustar en el H2.
 */
function formatH2(mensaje) {
	const h2 = document.getElementById('section-h2');
	h2.innerHTML = mensaje;
}

/**
 * Función encargada de generar el fragmento inicial de la pantalla.
 *
 * @returns {DocumentFragment} - Un fragmento con el contenido básico.
 */
function createFragment() {
	const fragmento = document.createDocumentFragment();

	const h2 = document.createElement('h2');
	h2.id = 'section-h2';
	fragmento.appendChild(h2);

	const section = document.createElement('section');
	section.id = 'section-contenido';
	fragmento.appendChild(section);

	const parrafo = document.createElement('p');
	parrafo.id = 'section-p';
	section.appendChild(parrafo);

	return fragmento;
}

/**
 * Función encargada de insertar el fragmento inicial de la pantalla.
 */
function addInitialFragment() {
	const seccionJuego = document.getElementById('section-decisiones');
	const fragmento = createFragment();
	seccionJuego.appendChild(fragmento);
}

/**
 * Función encargada de buscar en un objeto que funciona como mapa, la URL de una foto cuyo
 * nombre de referencia se pasa por parámetro.
 *
 * @param imageName - Nombre de la imagen.
 * @returns {string} - Devuelve el string con la URL del proyecto que contiene la imagen.
 */
function getBackgroundURL(imageName) {
	const backgrounds = {
		start: '../images/hospitalHall.jpg',
		bloodyHallway: '../images/hospitalCorridor.webp',
		room: '../images/hospitalRoom.png',
		exit: '../images/hospitalSalida.jpg',
		gameover: '../images/gameover.jpg',
		victory: '../images/final.jpg'
	};

	return backgrounds[imageName];
}

/**
 * Función encargada de cambiar la imagen de fondo de la pantalla.
 *
 * @param imageName - Nombre de la imagen a utilizar.
 */
function changeBackgroundImage(imageName) {
	const background = getBackgroundURL(imageName);

	document.body.style.backgroundImage = `url(${background})`;
}

// EVENTOS DE ESCUCHA
/**
 * Función encargada de eliminar eventos de escucha en ratón y teclado.
 */
function removeMouseKeyboardListeners() {
	document.removeEventListener('keydown', movement);
	document.removeEventListener('mousemove', movement);
}

/**
 * Función encargada de añadir eventos de escucha en ratón y teclado.
 */
function addMouseKeyboardListeners() {
	document.addEventListener('mousemove', movement);
	document.addEventListener('keydown', movement);
}

// CONDICIONES DE VICTORIA-DERROTA
/**
 * Función encargada de manejar el final del juego decidiendo si es victoria o derrota.
 */
function handleEndgame() {
	removeEventListenerAudio(handleEndgame);
	executeSound(isVictory ? 'scape' : 'laugh');
	createButton('Cerrar ventana', closeWindow);
	window.open('./endgame.html', '_blank');
}

/**
 * Función encargada de desencadenar el evento de victoria.
 */
function victory() {
	const message = 'Al entrar en la habitación ves que la ventana está abierta por lo que decides, salir por ella'
		+ ' y huir. Descubres que estabas en un antiguo psiquiátrico, sigues sin saber cómo has llegado aquí ni'
		+ ' dónde estás pero eso te da igual, sales corriendo en dirección al bosque sabiendo que has escapado del'
		+ ' infierno con vida...';
	executeSound('door');
	formatP(message);
	removeButtons();
	isVictory = true;
	addEventListenerAudio(handleEndgame);
	localStorage.setItem('endgame', 'victory');
}

/**
 * Función encargada de desencadenar el evento de derrota.
 *
 * @param sound
 * @param message - Mensaje a visualizar en el section.
 */
function gameOver(sound, message) {
	executeSound(sound);
	formatP(message);
	removeButtons();
	addEventListenerAudio(handleEndgame);
	localStorage.setItem('endgame', 'gameOver');
}

// POSIBLES ESCENARIOS
/**
 * Función encargada de desencadenar el evento 'Defenderse' del árbol de decisiones
 * del lugar 'habitación'.
 */
function tryToDefend() {
	const possibleMessages = {
		'hombre lobo': 'Intentas luchar contra el hombre lobo, pero su ferocidad es implacable. Tu esfuerzo es en'
			+ ' vano y finalmente te derrota.',
		'vampiro': 'Decides enfrentarte al vampiro, pero su velocidad y fuerza te superan. No puedes evitar su'
			+ ' ataque, y termina acabando contigo.',
		'fantasma': 'Buscas enfrentarte al fantasma, pero su naturaleza etérea hace que tus golpes pasen a través de'
			+ ' él. Finalmente, sucumbes ante su poder sobrenatural.',
		'payaso asesino': 'Tratas de defenderte del payaso asesino, pero su astucia y agilidad te superan. '
			+ 'No logras evitar tu trágico destino.',
		'demonio': 'Haces un intento por luchar contra el demonio, pero su aura maligna te paraliza. '
			+ 'No puede hacer nada mientras termina con tu existencia.',
	};

	gameOver(
		'punches',
		possibleMessages[terrorElegido]
	);
}

/**
 * Función encargada de desencadenar el evento 'Intentar volver al hall' del árbol de
 * decisiones del lugar 'habitación'.
 */
function goToHall() {
	gameOver(
		'lockedDoor',
		'Intentas volver al hall pero la puerta está atrancada. No tienes forma de escapar y mueres'
		+ ' en la habitación.');
}

/**
 * Función encargada de desplegar el texto y botones del escenario habitación.
 */
function roomScenario() {
	removeEventListenerAudio(roomScenario);
	formatSection(
		'room',
		terrorElegido,
		'HABITACIÓN',
		'Entras en la habitación, está a oscuras y no puedes ver apenas nada. Al fondo ves moverse una'
		+ ` sombra... Se trata de un ${terrorElegido}, se abalanza sobre ti. ¿Qué decides hacer?`,
		[
			['Volver al hall', goToHall],
			['Defenderte', tryToDefend]
		]
	);
}

/**
 * Función encargada de gestionar el evento 'Entrar por la puerta' del árbol de decisiones
 * del primer nivel.
 */
function walkToDoor() {
	executeSound('door');
	formatP('Decides entrar en la habitación de la derecha...');
	removeButtons();
	addEventListenerAudio(roomScenario);
}

/**
 * Función encargada de provocar el evento asociado al botón con el texto 'Ir directo hacia la puerta'
 * del último nivel de decisiones.
 */
function tryGetOut() {
	gameOver(
		'run',
		'Echas a correr hacia la puerta de salida pero de la nada aparece un zombie'
		+ ' enorme que te corta el paso, intentas darte la vuelta para volver pero justo detrás de ti tienes a otro'
		+ ' zombie que te muerde. Te has convertido en uno de ellos.');
}

/**
 * Función encargada de desplegar el texto y botones del escenario sala principal.
 */
function mainHall() {
	removeEventListenerAudio(mainHall);
	formatSection(
		'exit',
		'thunder',
		'SALA PRINCIPAL',
		'Llegas al final de un pasillo, oyes los truenos y la lluvia, la salida debe estar cerca.'
		+ ' De hecho te giras y la ves, allí, al fondo está la salida del hospital. Aun así, oyes un sonido cerca,'
		+ ' ¿qué decides hacer?',
		[
			['Ir directo hacia la puerta', tryGetOut],
			['Entrar en la habitación de la izquierda', victory]
		]
	);
}

/**
 * Evento asociado al botón con el texto 'Avanzar por el pasillo'.
 */
function walkHallway() {
	executeSound('footsteps');
	formatP('Avanzas por el pasillo con miedo a que vuelvan a salir los zombies.');
	removeButtons();
	addEventListenerAudio(mainHall);
}

/**
 * Función que se encarga de manejar el evento del pasillo cuando el usuario
 * elige la opción 'Caminar hacia la sangre' en el primer conjunto de opciones.
 */
function hallwayEvent() {
	const h3 = document.getElementById('section-h3');
	let counter = 5;

	interval = setInterval(function () {
		h3.innerHTML = counter;
		if (counter === 0) {
			removeMouseKeyboardListeners();
			formatP('Parece que el pasillo está libre, puedes avanzar a la siguiente zona.');
			clearInterval(interval);
			removeH3();
			createButton('Avanzar por el pasillo', walkHallway);
		}
		counter--;
	}, 1000);
}

/**
 * Función encargada de desplegar el texto y botones del escenario pasillo principal.
 */
function hallwayScenario() {
	removeEventListenerAudio(hallwayScenario);
	formatSection(
		'bloodyHallway',
		'zombie',
		'PASILLO PRINCIPAL',
		'Llegas a un pasillo donde ves a 2 zombies deambulando. Sabes que si haces el mínimo movimiento'
		+ ' o ruido morirás por lo que debes quedarte quieto hasta que los zombies liberen el pasillo.'
	);
	createH3();
	setTimeout(function () {
		addMouseKeyboardListeners();
		hallwayEvent();
	}, 2000);
}

/**
 * Función encargada de desarrollar el evento de 'Caminar hacia la sangre' del primer
 * conjunto de opciones.
 */
function walkToBlood() {
	executeSound('footsteps');
	formatP('Decides inspeccionar el rastro de sangre...');
	removeButtons();
	addEventListenerAudio(hallwayScenario);
}

/**
 * Función encargada de desarrollar el evento asociado a teclado y ratón.
 */
function movement() {
	removeMouseKeyboardListeners();
	removeH3();
	clearInterval(interval);
	formatP('Te has movido y has tirado una bandeja con cristales.');
	gameOver(
		'brokenGlass',
		'Presa del pánico has decidido no esperar y moverte antes de tiempo, como consecuencia te has tropezado'
		+ ' con una de las mesas y has tirado al suelo todo el material de curas provocando un gran ruido que no sólo'
		+ ' ha alertado a los 2 zombies del pasillo sino a todos los que se encontraban en las habitaciones. Intentas'
		+ ' huir pero es imposible que te salves... son demasiados.'
	);
}

/**
 * Función encargada de crear iniciar el juego con los primeros elementos.
 */
function start() {
	formatH2('ZONA DE INICIO');
	formatP(`${username}, te despiertas en lo que parece ser un hospital abandonado, al fondo ves un rastro de`
		+ ' sangre y a tu derecha tienes una puerta. ¿Qué decides hacer?');
	createButton('Caminar hacia la sangre', walkToBlood);
	createButton('Entrar por la puerta', walkToDoor);
}

/**
 * Función encargada de dar un valor a las variables terrorElegido
 * y username.
 */
function getStorage() {
	username = localStorage.getItem('name');
	terrorElegido = localStorage.getItem('terror');
}

/**
 * Comprueba si el terror seleccionado se encuentra en la lista de terrors permitidos.
 *
 * @param {string} selectedTerror - El terror seleccionado que se va a verificar.
 * @returns {boolean} - Devuelve true si el terror seleccionado está en la lista
 * 						permitida, de lo contrario, false.
 */
function inTerrorArray(selectedTerror) {
	const possibleTerrors = [
		'hombre lobo',
		'vampiro',
		'fantasma',
		'payaso asesino',
		'demonio'
	];

	for (const terror of possibleTerrors) {
		if (selectedTerror === terror) {
			return true;
		}
	}

	return false;
}

/**
 * Comprueba el estado de almacenamiento local para determinar si se cumplen las
 * condiciones necesarias para continuar con el juego.
 *
 * @returns {boolean} - Devuelve true si las condiciones son satisfactorias,
 * 						de lo contrario, false.
 */
function checkStorage() {
	const endgame = localStorage.getItem('endgame');

	if (endgame) {
		window.location = './endgame.html';
		return false;
	}

	const playerName = localStorage.getItem('name');
	const selectedTerror = localStorage.getItem('terror');

	if (!playerName || !selectedTerror || !inTerrorArray(selectedTerror)) {
		localStorage.clear();
		window.location = '../index.html';
		return false;
	}

	return true;
}

// FUNCIÓN INICIADORA
/**
 * Función que se encarga del formateo inicial de la aplicación.
 */
function init() {
	if (checkStorage()) {
		getStorage();
		changeBackgroundImage('start');
		addInitialFragment();
		start();
	}
}

// INICIO DEL SCRIPT
window.addEventListener('DOMContentLoaded', init);

let terrorElegido; // Variable que guarda el terror elegido por el usuario.
let username; // Variable que guarda el nombre elegido por el usuario.
let interval; // Variable que se utilizará para almacenar un intervalo.
let isVictory = false; // Variable booleana para decidir si el usuario gana o no.