import { Jugador } from './jugador.model.js';

/**
 * Crea un elemento de audio con las propiedades especificadas.
 *
 * @returns {HTMLAudioElement} El elemento de audio creado.
 */
function creaElementoAudio() {
	const elementoAudio = document.createElement('audio');
	elementoAudio.setAttribute('id', 'musica');
	elementoAudio.setAttribute('src', './assets/music/musica.mp3');
	elementoAudio.autoplay = true;
	elementoAudio.loop = true;

	return elementoAudio;
}

/**
 * Devuelve un jugador aleatorio del listado de jugadores.
 *
 * @returns {Jugador} Jugador aleatorio del listado.
 */
function getJugadorAleatorio() {
	return listadoJugadores[Math.floor(Math.random() * listadoJugadores.length)];
}

/**
 * Imprime la información de una tecla en un elemento HTML con la clase especificada.
 *
 * @param {string} tecla - La tecla que se va a imprimir.
 * @param {string} clase - La clase del elemento HTML en el que se imprimirá la tecla.
 */
function imprimeInfoTecla(tecla, clase) {
	const divTecla = document.getElementsByClassName(clase)[0];
	divTecla.innerHTML = tecla;

	return;
}

/**
 * Imprime la información de un jugador en un elemento HTML con el ID especificado.
 *
 * @param {Jugador} jugador - El jugador cuya información se va a imprimir.
 * @param {string} id - El ID del elemento HTML en el que se imprimirá la información del jugador.
 */
function imprimeInfoJugador(jugador, id) {
	const contenedor = document.getElementById(id);

	const parrafoNombre = contenedor.querySelector('p:nth-child(2)');
	parrafoNombre.innerHTML = `<strong>Nombre:</strong> ${jugador.nombre}`;

	const parrafoEdad = contenedor.querySelector('p:nth-child(3)');
	parrafoEdad.innerHTML = `<strong>Edad:</strong> ${jugador.edad}`;

	const parrafoEntrenamiento = contenedor.querySelector('p:nth-child(4)');
	parrafoEntrenamiento.innerHTML = `<strong>Entrenamiento:</strong> ${jugador.nivelEntrenamiento} (${jugador.cantVictorias} victorias)`;

	return;
}

/**
 * Devuelve una tecla aleatoria en mayúsculas.
 *
 * @returns {string} Tecla aleatoria en mayúsculas.
 */
function getTeclaAleatoria() {
	const teclas = '1234567890qwertyuiopasdfghjklñzxcvbnm';

	return teclas[Math.floor(Math.random() * teclas.length)];
}

/**
 * Realiza la elección de dos teclas distintas aleatorias.
 *
 * @returns {Array.<string>} Un array con las dos teclas aleatorias elegidas.
 */
function eleccionTeclas() {
	const tecla1 = getTeclaAleatoria();
	let tecla2;

	do {
		tecla2 = getTeclaAleatoria();
	} while (tecla1 === tecla2);

	return [tecla1, tecla2];
}

/**
 * Realiza la elección de dos jugadores distintos aleatorios.
 *
 * @returns {Array.<Jugador>} Un array con los dos jugadores aleatorios elegidos.
 */
function eleccionJugadores() {
	const jugador1 = getJugadorAleatorio();
	let jugador2;

	do {
		jugador2 = getJugadorAleatorio();
	} while (jugador1 === jugador2);

	return [jugador1, jugador2];
}

/**
 * Vuelve a permitir la pulsación de la tecla especificada.
 *
 * @param {KeyboardEvent} evento - El evento de teclado que desencadena la función.
 */
function volverAPermitirPulsacion(evento) {
	if (evento.key === teclas[0]) {
		estadoTeclas[0] = true;
	}

	if (evento.key === teclas[1]) {
		estadoTeclas[1] = true;
	}

	return;
}

/**
 * Imprime la información de las pulsaciones de un jugador en un elemento HTML con el ID especificado.
 *
 * @param {number} pulsacionesJugador - La cantidad de pulsaciones del jugador a imprimir.
 * @param {string} id - El ID del elemento HTML en el que se imprimirá la información de las pulsaciones.
 */
function imprimeInfoPulsaciones(pulsacionesJugador, id) {
	const divPulsaciones = document.getElementById(id);
	divPulsaciones.innerHTML = pulsacionesJugador;

	return;
}

/**
 * Actualiza la información de las pulsaciones de dos jugadores en elementos HTML específicos.
 */
function actualizarPulsaciones() {
	imprimeInfoPulsaciones(pulsacionesJ1, 'contador1');
	imprimeInfoPulsaciones(pulsacionesJ2, 'contador2');

	return;
}

/**
 * Cuenta las pulsaciones de teclas y actualiza la información en la pantalla.
 *
 * @param {KeyboardEvent} evento - El evento de teclado que desencadena la función.
 */
function contarPulsaciones(evento) {
	if (evento.key === teclas[0] && estadoTeclas[0]) {
		pulsacionesJ1++;
		estadoTeclas[0] = false;
	}

	if (evento.key === teclas[1] && estadoTeclas[1]) {
		pulsacionesJ2++;
		estadoTeclas[1] = false;
	}

	actualizarPulsaciones();

	return;
}

/**
 * Determina al ganador basado en el número de pulsaciones y actualiza las victorias de los jugadores.
 *
 * @returns {string} Mensaje que indica el resultado de la partida.
 */
function defineGanador() {
	if (pulsacionesJ1 === pulsacionesJ2) {
		return 'Hay un empate';
	} else if (pulsacionesJ1 > pulsacionesJ2) {
		jugadores[0].aumentaVictoria();

		return `Ha ganado ${jugadores[0].nombre} con ${pulsacionesJ1} pulsaciones.`;
	} else {
		jugadores[1].aumentaVictoria();

		return `Ha ganado ${jugadores[1].nombre} con ${pulsacionesJ2} pulsaciones.`;
	}
}

/**
 * Imprime la información del ganador del juego en un elemento HTML.
 */
function imprimeInfoGanador() {
	const mensajeGanador = defineGanador();
	const divResumen = document.getElementsByClassName('resumen')[0];

	const fragmento = document.createDocumentFragment();

	const parrafo = creaParrafo('pGanador', 'ganador', mensajeGanador);
	fragmento.appendChild(parrafo);
	divResumen.appendChild(fragmento);

	return;
}

/**
 * Finaliza el juego, removiendo los event listeners, mostrando al ganador y habilitando los botones.
 */
function finJuego() {
	removeEventListenerTeclado();
	imprimeInfoGanador();
	toogleButtons();

	return;
}

/**
 * Elimina el formulario del elemento HTML con el ID 'formulario'.
 */
function eliminaFormulario() {
	const formulario = document.getElementById('formularioIngreso');

	if (formulario) {
		const divContenedor = document.getElementsByClassName('addJugador')[0];
		divContenedor.removeChild(formulario);

		return;
	}

	return;
}

/**
 * Elimina un nodo de párrafo de un formulario especificado por su ID.
 *
 * @param {HTMLElement} nodoParrafo - El nodo de párrafo que se eliminará del formulario.
 */
function delParrafo(nodoParrafo) {
	const formulario = document.getElementById('formularioIngreso');
	formulario.removeChild(nodoParrafo);

	return;
}

/**
 * Agrega un nodo de párrafo a un formulario con el ID 'formulario'.
 *
 * @param {HTMLElement} nodoParrafo - El nodo de párrafo que se agregará al formulario.
 */
function addParrafo(nodoParrafo) {
	const formulario = document.getElementById('formularioIngreso');
	formulario.appendChild(nodoParrafo);

	return;
}

/**
 * Crea un elemento de párrafo con un ID, una clase y un texto especificados.
 *
 * @param {string} id - El ID que se asignará al párrafo.
 * @param {string} clase - La clase que se agregará al párrafo.
 * @param {string} texto - El texto que se mostrará en el párrafo.
 * @returns {HTMLElement} El párrafo creado.
 */
function creaParrafo(id, clase, texto) {
	const parrafo = document.createElement('p');
	parrafo.setAttribute('id', id);
	parrafo.classList.add(clase);
	parrafo.innerHTML = texto;

	return parrafo;
}

/**
 * Muestra un mensaje en el formulario de registro.
 *
 * @param {string} nombreJugador - El nombre del jugador registrado (puede ser nulo o vacío).
 */
function mostrarMensaje(nombreJugador) {
	const pInfo = document.getElementById('pInfo');

	if (pInfo) {
		delParrafo(pInfo);
	}

	let mensaje;
	let clase;

	if (nombreJugador) {
		mensaje = `Jugador ${nombreJugador} registrado correctamente.`;
		clase = 'registroValido';
	} else {
		mensaje = 'Ambos campos deben estar rellenados.';
		clase = 'faltanDatos';
	}

	const nuevoPInfo = creaParrafo('pInfo', clase, mensaje);
	addParrafo(nuevoPInfo);

	return;
}

/**
 * Finaliza el proceso de registro de jugador, eliminando el formulario y habilitando los botones.
 */
function finRegistro() {
	eliminaFormulario();
	toogleButtons();

	return;
}

/**
 * Agrega un nuevo jugador al listado de jugadores.
 */
function pushJugador() {
	const nombreJugador = document.getElementById('nombreJugador').value;
	const edadJugador = document.getElementById('edadJugador').value;

	if (!nombreJugador || !edadJugador) {
		mostrarMensaje();
		return;
	}

	listadoJugadores.push(new Jugador(nombreJugador, edadJugador));

	mostrarMensaje(nombreJugador);

	setTimeout(finRegistro, 2000);

	return;
}

/**
 * Elimina los event listeners del teclado para detener el conteo de pulsaciones.
 */
function removeEventListenerTeclado() {
	document.removeEventListener('keydown', contarPulsaciones);
	document.removeEventListener('keyup', volverAPermitirPulsacion);

	return;
}

/**
 * Agrega eventos de escucha para el teclado (keydown y keyup).
 */
function addEventoEscuchaTeclas() {
	document.addEventListener('keydown', contarPulsaciones);
	document.addEventListener('keyup', volverAPermitirPulsacion);

	return;
}

/**
 * Realiza la selección de dos teclas aleatorias y muestra la información en áreas específicas.
 */
function seleccionTeclas() {
	teclas = eleccionTeclas();
	imprimeInfoTecla(teclas[0].toUpperCase(), 'area1');
	imprimeInfoTecla(teclas[1].toUpperCase(), 'area2');

	return;
}

/**
 * Realiza la selección de dos jugadores aleatorios y muestra su información en áreas específicas.
 */
function seleccionJugadores() {
	jugadores = eleccionJugadores();
	imprimeInfoJugador(jugadores[0], 'jugador1');
	imprimeInfoJugador(jugadores[1], 'jugador2');

	return;
}

/**
 * Activa o desactiva la música de fondo y actualiza el botón correspondiente.
 */
function toogleMusic() {
	const botonMusica = document.getElementById('ponMusica');
	botonMusica.classList.toggle('musicaActiva');

	if (!musicaPuesta) {
		botonMusica.innerHTML = 'Apagar música';

		const audio = creaElementoAudio();
		document.body.appendChild(audio);

		musicaPuesta = true;

		return;
	}

	const audio = document.getElementById('musica');
	botonMusica.innerHTML = '¿Música?';
	document.body.removeChild(audio);

	musicaPuesta = false;

	return;
}

/**
 * Inicia un nuevo juego, reiniciando las variables, mostrando información de jugadores y teclas, y activando eventos de teclado.
 */
function newGame() {
	pulsacionesJ1 = 0;
	pulsacionesJ2 = 0;
	estadoTeclas = [true, true];

	actualizarPulsaciones();
	borraInfoGanador();
	toogleButtons();
	seleccionJugadores();
	seleccionTeclas();
	addEventoEscuchaTeclas();

	const letraIntervalo = setInterval(seleccionTeclas, TIEMPO_CAMBIO);

	setTimeout(function () {
		clearInterval(letraIntervalo);
		finJuego();
	}, TIEMPO_PARTIDA);

	return;
}

/**
 * Agrega eventos a los botones del formulario para insertar un jugador y cancelar.
 */
function addEventosBotonesFormulario() {
	const botonInserta = document.getElementById('add');
	botonInserta.addEventListener('click', pushJugador);

	const botonCancela = document.getElementById('cancel');
	botonCancela.addEventListener('click', finRegistro);

	return;
}

/**
 * Crea un elemento de botón con un ID y texto especificados.
 *
 * @param {string} id - El ID que se asignará al botón.
 * @param {string} texto - El texto que se mostrará en el botón.
 * @param {string} tipoBoton - El tipo de botón a crear.
 * @returns {HTMLButtonElement} El botón creado.
 */
function creaBoton(id, tipoBoton, texto) {
	const boton = document.createElement('button');
	boton.innerHTML = texto;
	boton.setAttribute('type', tipoBoton);
	boton.setAttribute('id', id);

	return boton;
}

/**
 * Crea un elemento de etiqueta (label) con un for y texto especificados.
 *
 * @param {string} id - El ID que se asignará a la etiqueta.
 * @param {string} texto - El texto que se mostrará en la etiqueta.
 * @returns {HTMLLabelElement} La etiqueta creada.
 */
function creaLabel(id, texto) {
	const label = document.createElement('label');
	label.setAttribute('for', id);
	label.innerHTML = texto;

	return label;
}

/**
 * Crea un elemento de entrada (input) con los atributos especificados.
 *
 * @param {string} type - El tipo de entrada (e.g., "text", "number", "password").
 * @param {string} id - El ID que se asignará al elemento de entrada.
 * @param {string} name - El nombre que se asignará al elemento de entrada.
 * @param {string} placeholder - El texto de marcador de posición para el elemento de entrada.
 * @param {number} min - El valor mínimo permitido para el elemento de entrada (opcional).
 * @param {number} max - El valor máximo permitido para el elemento de entrada (opcional).
 * @param {number} step - El incremento para los valores del elemento de entrada (opcional).
 * @returns {HTMLInputElement} El elemento de entrada creado.
 */
function creaInput(type, id, name, placeholder, min, max, step) {
	const input = document.createElement('input');
	input.setAttribute('type', type);
	input.setAttribute('id', id);
	input.setAttribute('name', name);
	input.setAttribute('placeholder', placeholder);

	if (min) {
		input.setAttribute('min', min);
	}

	if (max) {
		input.setAttribute('max', max);
	}

	if (step) {
		input.setAttribute('step', step);
	}

	return input;
}

/**
 * Crea un encabezado HTML (por ejemplo, h1, h2, h3) con el tipo y texto especificados.
 *
 * @param {string} tipo - El tipo de encabezado HTML (por ejemplo, "h1", "h2").
 * @param {string} texto - El texto que se mostrará en el encabezado.
 * @returns {HTMLElement} El encabezado HTML creado.
 */
function creaEncabezado(tipo, texto) {
	const encabezado = document.createElement(tipo);
	encabezado.innerHTML = texto;

	return encabezado;
}

/**
 * Crea un contenedor HTML (por ejemplo, div) con el tipo de contenedor y ID especificados.
 *
 * @param {string} tipoContenedor - El tipo de contenedor HTML (por ejemplo, "div").
 * @param {string} clase - La clase que se asignará al contenedor.
 * @param {string} id - El ID que se asignará al contenedor.
 * @returns {HTMLElement} El contenedor HTML creado.
 */
function creaContenedor(tipoContenedor, clase, id) {
	const contenedor = document.createElement(tipoContenedor);
	contenedor.setAttribute('class', clase);

	if (id) {
		contenedor.setAttribute('id', id);
	}

	return contenedor;
}

/**
 * Genera un fragmento de documento que representa un formulario de registro.
 *
 * @returns {DocumentFragment} El fragmento de documento generado.
 */
function generaFragmento() {
	const fragmento = document.createDocumentFragment();

	const contenedor = creaContenedor('section', 'formulario', 'formularioIngreso');
	fragmento.appendChild(contenedor);

	const h2 = creaEncabezado('h2', 'FORMULARIO REGISTRO');
	contenedor.appendChild(h2);

	const articleNombre = creaContenedor('article', 'info');
	contenedor.appendChild(articleNombre);

	const labelNombre = creaLabel('nombreJugador', 'Nombre:');
	articleNombre.appendChild(labelNombre);

	const inputNombre = creaInput('text', 'nombreJugador', 'nombre', 'Tu nombre aquí');
	articleNombre.appendChild(inputNombre);

	const articleEdad = creaContenedor('article', 'info');
	contenedor.appendChild(articleEdad);

	const labelEdad = creaLabel('edadJugador', 'Edad:');
	articleEdad.appendChild(labelEdad);

	const inputEdad = creaInput('number', 'edadJugador', 'edad', 'Tu edad aquí', 15, 99, 1);
	articleEdad.appendChild(inputEdad);

	const articleBotones = creaContenedor('article', 'botones');
	contenedor.appendChild(articleBotones);

	const botonAddJugador = creaBoton('add', 'button', 'Insertar');
	articleBotones.appendChild(botonAddJugador);

	const botonCancelar = creaBoton('cancel', 'button', 'Cancelar');
	articleBotones.appendChild(botonCancelar);

	return fragmento;
}

/**
 * Despliega el formulario de registro en un elemento HTML con la clase 'addJugador'.
 */
function despliegaFormulario() {
	const fragmento = generaFragmento();
	const divContenedor = document.getElementsByClassName('addJugador')[0];

	divContenedor.appendChild(fragmento);

	return;
}

/**
 * Alterna la disponibilidad y estilo de los botones en la página.
 */
function toogleButtons() {
	const arrayBotones = document.querySelectorAll('button:not(.botones button:last-child)');

	for (const boton of arrayBotones) {
		boton.toggleAttribute('disabled');
		boton.classList.toggle('disabled');
	}

	return;
}

/**
 * Borra la información del ganador de la página si existe.
 */
function borraInfoGanador() {
	const parrafoGanador = document.getElementById('pGanador');

	if (parrafoGanador) {
		const divResumen = document.getElementsByClassName('resumen')[0];
		divResumen.removeChild(parrafoGanador);

		return;
	}

	return;
}

/**
 * Inicia el proceso de agregar un nuevo jugador, borrando la información del ganador anterior, habilitando botones y desplegando el formulario de registro.
 */
function addPlayer() {
	borraInfoGanador();
	toogleButtons();
	despliegaFormulario();
	addEventosBotonesFormulario();

	return;
}

/**
 * Agrega eventos de escucha a los botones en la página para realizar acciones como agregar un nuevo jugador, iniciar un nuevo juego y alternar la música.
 */
function addEventosEscucha() {
	const botonNewPlayer = document.getElementById('nuevoJugador');
	botonNewPlayer.addEventListener('click', addPlayer);

	const botonNewGame = document.getElementById('iniciaJuego');
	botonNewGame.addEventListener('click', newGame);

	const botonMusica = document.getElementById('ponMusica');
	botonMusica.addEventListener('click', toogleMusic);

	return;
}

/**
 * Inicializa la página, agregando eventos de escucha a los botones y realizando otras tareas iniciales si es necesario.
 */
function init() {
	addEventosEscucha();

	return;
}

window.addEventListener('DOMContentLoaded', init);

let jugadores = []; // Array que se utiliza para almacenar los dos jugadores aleatorios que jugarán la partida.
let teclas = []; // Array que se utiliza para almacenar las teclas aleatorias que se utilizarán.
let pulsacionesJ1; // Contador que se utiliza para rastrear las pulsaciones del jugador 1.
let pulsacionesJ2; // Contador que se utiliza para rastrear las pulsaciones del jugador 2.
let estadoTeclas = []; // Array que se utiliza para rastrear el estado de las teclas.
let musicaPuesta = false; // Bandera booleana que indica si la música de fondo está habilitada.

const TIEMPO_PARTIDA = 10000; // Constante que almacena la duración de la partida en milisegundos.
const TIEMPO_CAMBIO = 3000; // Constante que almacena cada cuántos milisegundos se debe cambiar la letra.

const listadoJugadores = [
	// Array que almacena objetos Jugador.
	new Jugador('Alberto', 33),
	new Jugador('Lucía', 31),
	new Jugador('Víctor', 27),
	new Jugador('David', 28),
];

listadoJugadores[0].cantVictorias = 12;
listadoJugadores[0].nivelEntrenamiento = 'Experto';

listadoJugadores[2].cantVictorias = 5;
listadoJugadores[2].nivelEntrenamiento = 'Intermedio';
