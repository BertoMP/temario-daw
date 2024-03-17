/**
 * Elimina todos los elementos hijos del elemento con el ID "historico".
 * @function
 * @returns {void}
 */
function removeHistorico() {
	const historicoDiv = document.getElementById('historico');

	while (historicoDiv.firstChild) {
		historicoDiv.removeChild(historicoDiv.firstChild);
	}

	return;
}

/**
 * Genera un elemento tbody y lo rellena con los datos del registro de batallas.
 * @returns {HTMLElement}
 */
function cuerpoTabla() {
	const tbody = document.createElement('tbody');

	let indiceRegistro = 1;
	for (const registroActual of registro) {
		const fila = tbody.insertRow();
		const numeroCelda = fila.insertCell(0);
		numeroCelda.innerHTML = indiceRegistro;

		for (const atributo in registroActual) {
			const valorCelda = fila.insertCell();
			valorCelda.innerHTML = registroActual[atributo];
		}
		indiceRegistro++;
	}

	return tbody;
}

/**
 * Genera un elemento thead y rellena los th con los nombres de
 * los atributos de cada objeto del registro.
 * @returns {HTMLHtmlElement}
 */
function cabeceraTabla() {
	const thead = document.createElement('thead');
	const encabezadoFila = thead.insertRow();

	const encabezadoCelda = document.createElement('th');
	encabezadoCelda.innerHTML = '#';
	encabezadoFila.appendChild(encabezadoCelda);

	const primerRegistro = registro[0];
	for (const atributo in primerRegistro) {
		const encabezadoCelda = document.createElement('th');
		encabezadoCelda.innerHTML = atributo.toUpperCase();
		encabezadoFila.appendChild(encabezadoCelda);
	}

	return thead;
}

/**
 * Crea una tabla a partir de un registro de combates.
 * @function
 * @param {Array} registro - El registro de combates a mostrar.
 * @returns {HTMLElement}
 */
function crearTabla() {
	const tabla = document.createElement('table');
	tabla.setAttribute('id', 'tablaRegistros');

	const thead = cabeceraTabla();
	tabla.appendChild(thead);

	const tbody = cuerpoTabla();
	tabla.appendChild(tbody);

	return tabla;
}

/**
 * Modifica el botón de carga de historico para alternar entre mostrar y
 * ocultar la tabla de registros.
 * @function
 * @returns {void}
 */
function toggleHistorico() {
	const botonRegistro = document.getElementById('cargarHistorico');
	const historicoDiv = document.getElementById('historico');
	const tablaVisible = document.getElementById('tablaRegistros');

	if (tablaVisible) {
		removeHistorico();
		botonRegistro.innerHTML = 'Resultados históricos!';
		return;
	}

	const tabla = crearTabla();
	historicoDiv.appendChild(tabla);
	botonRegistro.innerHTML = 'Cerrar histórico';

	return;
}

/**
 * Muestra el registro de combates en una tabla dentro del elemento con
 * el ID "historico".
 * Si no hay combates registrados, muestra una alerta.
 * @function
 * @returns {void}
 */
function muestraRegistro() {
	if (registro.length === 0) {
		alert('No hay combates registrados');
		return;
	}

	toggleHistorico();

	return;
}

/**
 * Agrega un nuevo registro de combate al registro existente.
 * El registro incluye la fecha, los nombres del héroe y el villano, y
 * el ganador del combate.
 * @function
 * @returns {void}
 */
function addRegistro() {
	const fecha = new Date();

	registro.push({
		fecha: fecha.toLocaleString(),
		heroe: heroeElegido.nombre,
		villano: villanoElegido.nombre,
		ganador: ganadorPelea,
	});

	return;
}

/**
 * Muestra la imagen del ganador final en la interfaz gráfica.
 * @function
 * @param {string} tipoGanador - El tipo de ganador ('heroe' o 'villano')
 *                               para determinar qué imagen mostrar.
 * @returns {void}
 */
function muestraFotoFinal(tipoGanador) {
	const imagenGanador = document.getElementById('ganador-imagen');
	imagenGanador.setAttribute(
		'src',
		tipoGanador === 'villano' ? './image/villano.png' : './image/heroe.png',
	);
	imagenGanador.style.visibility = 'visible';

	return;
}

/**
 * Muestra la información final del ganador en el elemento con el ID 'resultado'.
 * @function
 * @returns {void}
 */
function muestraInfoFinal() {
	const parrafoInfoFinal = document.getElementById('resultado');
	parrafoInfoFinal.innerHTML = `Ha ganado ${ganadorPelea.toUpperCase()}.`;

	return;
}

/**
 * Modifica el número de la ronda y actualiza el contenido del botón con el ID 'round'.
 * @function
 * @param {number} numeroRonda - El número de la ronda a mostrar en el botón.
 * @returns {void}
 */
function modificaRonda(numeroRonda) {
	const botonRonda = document.getElementById('round');
	botonRonda.innerHTML = `Ronda ${numeroRonda}`;

	return;
}

/**
 * Elimina todos los elementos hijos de un contenedor específico en función de su posición en la jerarquía.
 * @function
 * @param {HTMLElement} contenedor - El elemento contenedor del que se eliminarán los hijos.
 * @param {number} hijo - La posición del hijo que se eliminará (comenzando desde 1).
 * @returns {void}
 */
function vaciaContenedor(contenedor, hijo) {
	let elementoAEliminar = contenedor.querySelector(`:nth-child(${hijo})`);

	while (elementoAEliminar) {
		contenedor.removeChild(elementoAEliminar);
		elementoAEliminar = contenedor.querySelector(`:nth-child(${hijo})`);
	}

	return;
}

/**
 * Agrega elementos de información de la ronda a un contenedor específico.
 * @function
 * @param {string} id - El ID del elemento contenedor al que se
 *                      agregarán los elementos.
 * @param {Object} objetoHeroeVillano - El objeto que contiene las
 *                                      estadísticas del héroe o villano.
 * @param {number} valorEstadistica - El valor de la estadística elegida.
 * @param {string} eleccion - La estadística seleccionada (por ejemplo,
 *                            'ataque', 'defensa', etc.).
 * @param {number} vida - La cantidad de vida restante del héroe o villano.
 * @returns {void}
 */
function addElementosRonda(id, objetoHeroeVillano, valorEstadistica, eleccion, vida) {
	const contenedor = document.getElementById(id);

	vaciaContenedor(contenedor, 3);

	const parrafoEstadisticaRonda = document.createElement('p');
	parrafoEstadisticaRonda.innerHTML = `Estadistica ${eleccion}: ${valorEstadistica} / ${objetoHeroeVillano[eleccion]}`;
	contenedor.appendChild(parrafoEstadisticaRonda);

	const parrafoVida = document.createElement('p');
	parrafoVida.innerHTML = `Vida restante: ${vida} / 200`;
	contenedor.appendChild(parrafoVida);

	return;
}

/**
 * Agrega elementos generales de información del héroe o villano a un
 * contenedor específico.
 * @function
 * @param {string} id - El ID del elemento contenedor al que se
 *                      agregarán los elementos.
 * @param {Object} objetoHeroeVillano - El objeto que contiene la información
 *                                      general del héroe o villano.
 * @returns {void}
 */
function addElementosGenerales(id, objetoHeroeVillano) {
	const contenedor = document.getElementById(id);

	vaciaContenedor(contenedor, 2);

	const parrafoNombre = document.createElement('p');
	parrafoNombre.innerHTML = `Nombre: ${objetoHeroeVillano.nombre}`;
	contenedor.appendChild(parrafoNombre);

	return;
}

/**
 * Calcula un valor de estadística aleatorio entre 0 (inclusive) y un valor
 * máximo (exclusivo).
 * @function
 * @param {number} maximo - El valor máximo (exclusivo) para la estadística.
 * @returns {number} - El valor aleatorio de la estadística.
 */
function calculaEstadistica(maximo) {
	return Math.floor(Math.random() * (maximo + 1));
}

/**
 * Solicita al usuario que elija entre "fuerza" e "intelecto" mediante una ventana
 * emergente de entrada.
 * @function
 * @returns {string|null} - La elección del usuario ('fuerza' o 'intelecto') o null si
 *                          se cancela la selección.
 */
function eligeFuerzaIntelecto() {
	let eleccion;

	do {
		eleccion = prompt('¿Elige fuerza o intelecto?');

		if (eleccion === null) {
			return null;
		}

		eleccion = eleccion.toLowerCase();

		if (eleccion !== 'fuerza' && eleccion !== 'intelecto') {
			alert(`La opción ${eleccion} no es válida.`);
		}
	} while (eleccion !== 'fuerza' && eleccion !== 'intelecto');

	return eleccion;
}

/**
 * Elige de manera aleatoria un héroe y un villano de las listas disponibles y los asigna a
 * las variables globales `heroeElegido` y `villanoElegido`.
 * @function
 * @returns {void}
 */
function eligePersonajes() {
	heroeElegido = heroes[Math.floor(Math.random() * heroes.length)];
	villanoElegido = villanos[Math.floor(Math.random() * villanos.length)];
}

/**
 * Agrega un mensaje al registro de log en la interfaz gráfica.
 * @function
 * @param {string} mensaje - El mensaje a agregar al registro de log.
 * @returns {void}
 */
function addMensajeLog(mensaje) {
	const divLog = document.getElementById('divLog');
	const parrafo = document.createElement('p');

	parrafo.innerHTML = mensaje;
	divLog.appendChild(parrafo);
}

/**
 * Realiza un ataque de un atacante a un defensor utilizando una estadística específica.
 * @function
 * @param {Object} atacante - El objeto del personaje que realiza el ataque.
 * @param {Object} defensor - El objeto del personaje que recibe el ataque.
 * @param {string} eleccion - La elección de estadística para el ataque (por ejemplo, 'ataque' o 'defensa').
 * @param {number} estadisticaAtacante - El valor de la estadística del atacante para el ataque.
 * @param {number} vidaDefensor - La vida actual del defensor.
 * @returns {number} - La vida restante del defensor después del ataque.
 */
function realizarAtaque(atacante, defensor, eleccion, estadisticaAtacante, vidaDefensor) {
	vidaDefensor -= estadisticaAtacante;

	if (vidaDefensor < 0) {
		vidaDefensor = 0;
	}

	addMensajeLog(
		`${atacante.nombre} ataca a ${defensor.nombre} con ${estadisticaAtacante} de ${eleccion}. ` +
			(vidaDefensor > 0
				? `A ${defensor.nombre} le quedan ${vidaDefensor} puntos de vida.`
				: `${atacante.nombre} ha derrotado a ${defensor.nombre}.`),
	);

	return vidaDefensor;
}

/**
 * Finaliza el combate y muestra la información final, incluyendo al ganador del combate.
 * @function
 * @param {number} vidaHeroe - La vida restante del héroe al final del combate.
 * @returns {void}
 */
function finalCombate(vidaHeroe) {
	let tipoGanador;

	if (vidaHeroe === 0) {
		tipoGanador = 'villano';
		ganadorPelea = villanoElegido.nombre;
	} else {
		tipoGanador = 'heroe';
		ganadorPelea = heroeElegido.nombre;
	}

	muestraInfoFinal();
	muestraFotoFinal(tipoGanador);
	addRegistro();
	muestraBotones();
}

/**
 * Agrega un nuevo elemento de registro-log (tipodiv) al documento HTML
 * justo después del elemento con el ID 'contendientes'.
 *
 * @returns {void}
 */
function addDivLog() {
	const contendientes = document.getElementById('contendientes');
	const logDiv = document.createElement('div');
	logDiv.setAttribute('id', 'divLog');

	const h2 = document.createElement('h2');
	h2.innerHTML = 'LOG DEL COMBATE';
	logDiv.appendChild(h2);

	contendientes.parentNode.insertBefore(logDiv, contendientes.nextSibling);

	return;
}

/**
 * Agrega un encabezado de ronda al elemento con el ID 'divLog' en el documento HTML.
 *
 * @param {number} ronda - El número de la ronda que se mostrará en el encabezado.
 * @returns {void}
 */
function encabezadoRonda(ronda) {
	const divLog = document.getElementById('divLog');
	const h3 = document.createElement('h3');
	h3.innerHTML = `Ronda #${ronda}`;
	divLog.appendChild(h3);

	return;
}

/**
 * Simula un combate entre un héroe y un villano, usando una estadística específica
 * (ataque, defensa, etc.) según la elección del jugador.
 * @function
 * @param {string} eleccion - La elección de estadística para el combate
 *                           (por ejemplo, 'ataque' o 'defensa').
 * @returns {void}
 */
function combate(eleccion) {
	let vidaHeroe = 200;
	let vidaVillano = 200;
	let ronda = 1;

	addDivLog();

	const interval = setInterval(function () {
		let estadisticaHeroe = calculaEstadistica(heroeElegido[eleccion]);
		let estadisticaVillano = calculaEstadistica(villanoElegido[eleccion]);

		encabezadoRonda(ronda);

		vidaHeroe = realizarAtaque(
			villanoElegido,
			heroeElegido,
			eleccion,
			estadisticaVillano,
			vidaHeroe,
		);

		if (vidaHeroe > 0) {
			vidaVillano = realizarAtaque(
				heroeElegido,
				villanoElegido,
				eleccion,
				estadisticaHeroe,
				vidaVillano,
			);
		}

		modificaRonda(ronda);
		addElementosRonda('heroe', heroeElegido, estadisticaHeroe, eleccion, vidaHeroe);
		addElementosRonda('villano', villanoElegido, estadisticaVillano, eleccion, vidaVillano);

		ronda++;

		if (vidaHeroe === 0 || vidaVillano === 0) {
			clearInterval(interval);
			finalCombate(vidaHeroe);
		}
	}, 1000);

	return;
}

/**
 * Elimina el contenido del elemento con el ID 'resultado'.
 * @function
 * @returns {void}
 */
function removeGanador() {
	const parrafoGanador = document.getElementById('resultado');
	parrafoGanador.innerHTML = '';
}

/**
 * Elimina la imagen del ganador y oculta su visibilidad.
 * @function
 * @returns {void}
 */
function removeFoto() {
	const imagen = document.getElementById('ganador-imagen');
	imagen.setAttribute('src', '');
	imagen.style.visibility = 'hidden';
}

/**
 * Elimina el elemento con el ID 'divLog' y su contenido si existe.
 * @function
 * @returns {void}
 */
function removeDivLog() {
	const divLog = document.getElementById('divLog');

	if (divLog) {
		divLog.parentNode.removeChild(divLog);
	}
}

/**
 * Oculta los botones 'comienzo' y 'cargarHistorico'.
 * @function
 * @returns {void}
 */
function ocultaBotones() {
	const botonInicio = document.getElementById('comienzo');
	botonInicio.style.visibility = 'hidden';

	const botonRegistro = document.getElementById('cargarHistorico');
	botonRegistro.style.visibility = 'hidden';
}

/**
 * Muestra los botones 'comienzo' y 'cargarHistorico'.
 * @function
 * @returns {void}
 */
function muestraBotones() {
	const botonInicio = document.getElementById('comienzo');
	botonInicio.style.visibility = 'visible';

	const botonRegistro = document.getElementById('cargarHistorico');
	botonRegistro.innerHTML = 'Resultados históricos!';
	botonRegistro.style.visibility = 'visible';
}

/**
 * Realiza una limpieza inicial de la interfaz, eliminando eventos de escucha, la imagen del
 * ganador, el historial, el mensaje del ganador y el registro de log.
 * @function
 * @returns {void}
 */
function removeInicial() {
	ocultaBotones();
	removeFoto();
	removeHistorico();
	removeGanador();
	removeDivLog();
}

/**
 * Inicia la secuencia, realizando la elección de personajes y comenzando un combate
 * basado en la elección de fuerza o intelecto.
 * @function
 * @returns {void}
 */
function init() {
	removeInicial();
	eligePersonajes();

	const eleccion = eligeFuerzaIntelecto();

	if (eleccion === null) {
		alert('No se ha elegido ningún valor. No se producirá un combate.');
		muestraBotones();
		return;
	}

	addElementosGenerales('heroe', heroeElegido, eleccion);
	addElementosGenerales('villano', villanoElegido, eleccion);

	combate(eleccion);
}

/**
 * Agrega eventos de escucha a los botones 'comienzo' y 'cargarHistorico'
 * para iniciar el combate y mostrar el historial.
 * @function
 * @returns {void}
 */
function addEventosEscucha() {
	const botonInicio = document.getElementById('comienzo');
	botonInicio.addEventListener('click', init);

	const botonRegistro = document.getElementById('cargarHistorico');
	botonRegistro.addEventListener('click', muestraRegistro);
}

let heroeElegido;
let villanoElegido;
let ganadorPelea;

window.addEventListener('load', addEventosEscucha);

const registro = [];

// Array de héroes
const heroes = [
	{ nombre: 'Superman', fuerza: 100, intelecto: 90 },
	{ nombre: 'Spider-Man', fuerza: 70, intelecto: 80 },
	{ nombre: 'Wonder Woman', fuerza: 95, intelecto: 85 },
	{ nombre: 'Batman', fuerza: 60, intelecto: 100 },
	{ nombre: 'Captain America', fuerza: 80, intelecto: 75 },
	{ nombre: 'The Flash', fuerza: 75, intelecto: 80 },
	{ nombre: 'Black Widow', fuerza: 70, intelecto: 90 },
	{ nombre: 'Green Lantern', fuerza: 85, intelecto: 80 },
	{ nombre: 'Thor', fuerza: 90, intelecto: 70 },
	{ nombre: 'Aquaman', fuerza: 85, intelecto: 75 },
];

// Array de villanos
const villanos = [
	{ nombre: 'Joker', fuerza: 50, intelecto: 95 },
	{ nombre: 'Lex Luthor', fuerza: 60, intelecto: 98 },
	{ nombre: 'Magneto', fuerza: 80, intelecto: 85 },
	{ nombre: 'Thanos', fuerza: 90, intelecto: 75 },
	{ nombre: 'Loki', fuerza: 75, intelecto: 90 },
	{ nombre: 'Doctor Octopus', fuerza: 70, intelecto: 80 },
	{ nombre: 'Green Goblin', fuerza: 65, intelecto: 85 },
	{ nombre: 'Venom', fuerza: 75, intelecto: 70 },
	{ nombre: 'Red Skull', fuerza: 70, intelecto: 75 },
	{ nombre: 'Harley Quinn', fuerza: 55, intelecto: 80 },
];
