//Clase Jugador
class Persona {
	#_nombre;
	#_apellidos;
	#_edad;

	constructor(nombre, apellidos, edad) {
		this.#_nombre = nombre;
		this.#_apellidos = apellidos;
		this.#_edad = edad;
	}

	//Genero Getters y Setters
	get nombreJugador() {
		return `${this.#_nombre} ${this.#_apellidos}`;
	}

	set nombreJugador(nombre) {
		this.#_nombre = nombre;
		return 'Nombre cambiado!!!';
	}

	set apellidoJugador(apellidos) {
		this.#_apellidos = apellidos;
		return 'Apellidos cambiados!!!';
	}

	get edadJugador() {
		return this.#_edad;
	}

	set edadJugador(edad) {
		this.#_edad = edad;
		return 'Edad cambiada!!!';
	}
}

class Jugador extends Persona {
	#_entrenamiento;

	constructor(nombre, apellidos, edad) {
		super(nombre, apellidos, edad);
		this.#_entrenamiento = 0;
	}

	get nivelEntrenamiento() {
		return this.#_entrenamiento;
	}

	set nivelEntrenamiento(nivel) {
		this.#_entrenamiento = nivel;
		return 'Nivel cambiado!!!';
	}
}

// Array para almacenar jugadores
let misJugadores = [];

// Array para almacenar los dos jugadores que compiten
let dosJugadores = [];

//Jugadores dummy para practicar
let jugador1 = new Jugador('Adrián', 'Escribano', 20);
let jugador2 = new Jugador('Alberto', 'Martínez', 33);

//Letras a pulsar para sumar puntos
let letras = [];

//Letras pulsadas
let banderaTeclas = [];

//Jugadores dummies para llenar el array
misJugadores.push(jugador1);
misJugadores.push(jugador2);

//Creamos variables de arranque
let botonNuevoJugador = document.getElementById('nuevoJugador');
botonNuevoJugador.addEventListener('click', introducirJugador);

/**************************************************************************************************************/
function disableButtons() {
	const botones = document.getElementsByTagName('button');

	for (let intCont = 0; intCont < botones.length - 1; intCont++) {
		botones[intCont].disabled = true;
	}

	return;
}

function muestraForm() {
	const nodoAddJugador = document.getElementsByClassName('addJugador')[0];

	if (nodoAddJugador.children.length === 0) {
		let camposJugadores = document.getElementsByClassName('addJugador')[0];
		let campos = crearCampos();
		camposJugadores.appendChild(campos);

		return;
	}

	nodoAddJugador.classList.remove('hidden');
	return;
}

function vaciarInputs() {
	const nodos = document.getElementsByClassName('addJugador')[0].children;

	if (nodos) {
		for (const nodo of nodos) {
			nodo.value = '';
		}
		return;
	}
	return;
}

//Función raíz añadir jugador
function introducirJugador() {
	disableButtons();
	muestraForm();
	vaciarInputs();

	return;
}

function generaElemento(tipoElemento, idElemento, tipoDato, placeholder) {
	const elementoReturn = document.createElement(tipoElemento);
	elementoReturn.id = idElemento;
	elementoReturn.type = tipoDato;

	if (tipoElemento === 'button') {
		elementoReturn.innerText = placeholder;
		return elementoReturn;
	}

	elementoReturn.placeholder = placeholder;
	return elementoReturn;
}

function generaFragmento(...elementos) {
	const fragmento = document.createDocumentFragment();

	for (const elemento of elementos) {
		fragmento.appendChild(elemento);
	}

	return fragmento;
}

// Creamos los distintos campos text donde irán los datos de los jugadores
function crearCampos() {
	const campoNombre = generaElemento(
		'input',
		'nombreJugador',
		'text',
		'Nombre'
	);
	const campoApellidos = generaElemento(
		'input',
		'apellidosJugador',
		'text',
		'Apellidos'
	);
	const campoEdad = generaElemento(
		'input',
		'edadJugador',
		'number',
		'Edad'
	);
	const botonInsertar = generaElemento(
		'button',
		'botonInsertar',
		'button',
		'Insertar jugador'
	);
	botonInsertar.addEventListener('click', insertarJugador);

	return generaFragmento(campoNombre, campoApellidos, campoEdad, botonInsertar);
}

function creaJugador() {
	const campoNombre = document.getElementById('nombreJugador').value;
	const campoApellidos = document.getElementById('apellidosJugador').value;
	const campoEdad = document.getElementById('edadJugador').value;

	let nuevoJugador = null;

	if (campoNombre !== '' || campoApellidos !== '' || !isNaN(parseInt(campoEdad))) {
		nuevoJugador = new Jugador(campoNombre, campoApellidos, campoEdad);
		return nuevoJugador;
	}

	return nuevoJugador;
}

function ocultarForm() {
	let camposJugadores = document.getElementsByClassName('addJugador')[0];
	camposJugadores.classList.add('hidden');
}

// Versión con modificación de clases
function insertarJugador() {
	const nuevoJugador = creaJugador();

	if (nuevoJugador !== null) {
		misJugadores.push(nuevoJugador);
		ocultarForm();
		document.getElementById('nuevoJugador').disabled = false;
	}
}

/**************************************************************************************************************/

// Función raíz inicio de juego
let botonInicia = document.getElementById('iniciaJuego');
botonInicia.addEventListener('click', inicioJuego);

function inicioJuego() {
	// Deshabilito adición de jugadores
	disableButtons();

	//Recibo dos jugadores nuevos
	dosJugadores = dameJugadores();
	mostrarJugadores(dosJugadores);

	banderaTeclas = [true, true];

	//Arranco los listeners
	preparadosYa();
}

//Función para solicitar dos jugadores diferentes
function dameJugadores() {
	let numeroJugador1 = getRandom(misJugadores);
	let numeroJugador2;

	do {
		numeroJugador2 = getRandom(misJugadores);
	} while (numeroJugador1 === numeroJugador2);

	return [misJugadores[numeroJugador1], misJugadores[numeroJugador2]];
}

function getRandom(array) {
	const lenght = array.length;
	return Math.floor(Math.random() * lenght);
}

// Introduzco jugadores dentro de los contenedores de juego
function mostrarJugadores(jugadoresPasados) {
	for (let contador = 0; contador < jugadoresPasados.length; contador++) {
		const jugador = `jugador${ contador + 1 }`;
		infoJugador(jugadoresPasados[contador], document.getElementById(jugador));
	}
}

// Función de introducción individualizada
function infoJugador(jugador, nodo) {
	let misP = nodo.getElementsByTagName('p');

	misP[0].innerHTML = `<strong>Nombre:</strong> ${jugador.nombreJugador}`;
	misP[1].innerHTML = `<strong>Edad:</strong> ${jugador.edadJugador}`;
	misP[2].innerHTML = `<strong>Entrenamiento:</strong> ${jugador.nivelEntrenamiento}`;
}

// Saco los dos contadores al global por uso masivo
let contador1 = document.getElementById('contador1');
let contador2 = document.getElementById('contador2');

function activoTeclas() {
	document.addEventListener('keydown', detectarTecla);
	document.addEventListener('keyup', sueltaTecla);
}

function desactivoTeclas() {
	document.removeEventListener('keydown', detectarTecla);
	document.removeEventListener('keyup', sueltaTecla);
}

// Función para detectar pulsaciones de ambas teclas
function detectarTecla(evento) {
	if (evento.key === letras[0] && banderaTeclas[0]) {
		let contador = Number.parseInt(contador1.innerText);
		banderaTeclas[0] = false;
		contador++;
		contador1.innerText = contador.toString();
		return;
	}

	if (evento.key === letras[1] && banderaTeclas[1]) {
		let contador = Number.parseInt(contador2.innerText);
		banderaTeclas[1] = false;
		contador++;
		contador2.innerText = contador.toString();
	}
}

function sueltaTecla(evento) {
	if (evento.key === letras[0]) {
		banderaTeclas[0] = true;
	}

	if (evento.key === letras[1]) {
		banderaTeclas[1] = true;
	}
}

// Preparamos a los jugadores con un contador aleatorio entre 1 y 10 segundos

function preparadosYa() {
	//let i=Math.floor(Math.random()*10+1);
	let i = 2;
	iniciarAviso();
	setTimeout(function () {
		console.log(i);
		cambiarPanel();
		comienzaLaBatalla();
	}, i * 1000);
}

// Funcionalidad del botón aviso
// Busca si el aviso ya estaba creado. Si no existe, lo crea. En ambos casos reinicia su estado a "preparado"

function iniciarAviso() {
	let contenedorAviso;
	if (document.getElementById('contenedorAviso') === null) {
		contenedorAviso = generarAviso();
	} else {
		contenedorAviso = document.getElementById('contenedorAviso');
		verPanel(true);
	}
	let textoAviso = contenedorAviso.getElementsByTagName('p')[0];
	textoAviso.classList.add('preparados');
	textoAviso.classList.remove('ya');
	textoAviso.innerText = 'Ready';
}

// Creo los nodos para generar el aviso
function generarAviso() {
	let avisoMedio = document.getElementsByClassName('resumen')[0];
	let contenedorAviso = document.createElement('div');
	contenedorAviso.id = 'contenedorAviso';
	contenedorAviso.classList.add('aviso');
	let textoAviso = document.createElement('p');
	textoAviso.id = 'alerta';
	contenedorAviso.appendChild(textoAviso);
	avisoMedio.before(contenedorAviso);
	return contenedorAviso;
}

// Activo el panel para notificar a los jugadores la activación de las pulsaciones
function cambiarPanel() {
	let miPanel = document.getElementById('alerta');
	miPanel.classList.remove('preparados');
	miPanel.classList.add('ya');
	miPanel.innerText = 'GO!';
}

function verPanel(visible) {
	let miPanel = document.getElementById('contenedorAviso');
	if (visible) {
		miPanel.classList.add('aviso');
		miPanel.classList.remove('hidden');
		return;
	}
	miPanel.classList.add('hidden');
	miPanel.classList.remove('aviso');
}

function comienzaLaBatalla() {
	letras = generaLetras();
	activoTeclas();

	// Variable de control de duración de la partida
	let segundos = 4;

	// Variable de control de dificultad
	let dificultad = 2;

	let dificultadPartida = setInterval(function () {
		letras = generaLetras();
	}, dificultad * 1000);

	let partidaActiva = setInterval(function () {
		console.log(segundos);
		segundos--;
		if (segundos === 0) {
			desactivoTeclas();
			verPanel(false);
			finalPartida();
			clearInterval(partidaActiva); // Detiene el setInterval cuando segundos llega a 0
			clearInterval(dificultadPartida); // Detiene el setInterval para refrescar letra cuando llega a 0
		}
	}, 1000);
}

function generaLetras() {
	let numeroAleatorio1 = Math.floor(Math.random() * 25);
	let numeroAleatorio2 = Math.floor(Math.random() * 25);
	while (numeroAleatorio1 === numeroAleatorio2) {
		numeroAleatorio2 = Math.floor(Math.random() * 25);
	}
	let letraDeNumero1 = String.fromCharCode(numeroAleatorio1 + 97);
	let letraDeNumero2 = String.fromCharCode(numeroAleatorio2 + 97);
	ponmeLetras(letraDeNumero1, letraDeNumero2);
	return [letraDeNumero1, letraDeNumero2];
}

function ponmeLetras(letra1, letra2) {
	let contenedorLetra1 = document.getElementsByClassName('area1')[0];
	let contenedorLetra2 = document.getElementsByClassName('area2')[0];
	contenedorLetra1.innerText = letra1;
	contenedorLetra2.innerText = letra2;
}

function finalPartida() {
	// Reactivo botones
	botonNuevoJugador.disabled = false;
	botonInicia.disabled = false;
	// Introduzco resultados
	let ganador = devolverGanador();
	let camposResumen = document.getElementsByClassName('resumen')[0];
	if (ganador === undefined) {
		camposResumen.innerHTML = '<br/><p>¡EMPATE!</p>';
	} else {
		ganador.nivelEntrenamiento = ganador.nivelEntrenamiento + 1;
		camposResumen.innerHTML = `<br/><p>El ganador es ${ganador.nombreJugador}</p>`;
	}

	setTimeout(function () {
		camposResumen.innerHTML = '';
	}, 3000);

	// Reseteo campos

	vaciarCampos();
	vaciarContadores();
}

function devolverGanador() {
	if (Number.parseInt(contador1.innerText) > Number.parseInt(contador2.innerText)) {
		return dosJugadores[0];
	}
	if (Number.parseInt(contador1.innerText) < Number.parseInt(contador2.innerText)) {
		return dosJugadores[1];
	}
}

function vaciarCampos() {
	let jugadores = document.getElementsByClassName('jugadores')[0].children;
	for (let i = 0; i < jugadores.length; i++) {
		let miLetra = String.fromCharCode(i + 65);
		jugadores[i].innerHTML = `<h2>Jugador ${miLetra} </h2>
                            <p><strong>Nombre:</strong></p>
                            <p><strong>Edad:</strong></p>
                            <p><strong>Entrenamiento:</strong></p>`;
	}
}

function vaciarContadores() {
	contador1.innerText = 0;
	contador2.innerText = 0;
}

/*
//Detector de clicks

let miLetra = "k"

setTimeout(function(){miLetra = "l"}, "4000")

window.addEventListener("keyup", function(e){
    if (e.key === miLetra) {
        let contador = Number.parseInt(contador1.innerText)
        contador++
        contador1.innerText = contador;
    }
})
*/
