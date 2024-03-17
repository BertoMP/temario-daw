import { Alumno } from './alumno.model.js';

/**
 * Genera un elemento <tbody> a partir de los valores de un objeto registro de un alumno.
 *
 * @param {Object} registroAlumno - El registro del alumno que contiene sus datos.
 * @returns {HTMLTableSectionElement} - El elemento <tbody> generado y rellenado.
 */
function generaTbody(registroAlumno) {
	const tbody = document.createElement('tbody');
	const filaTb = tbody.insertRow();

	for (const itemValor in registroAlumno) {
		const celda = filaTb.insertCell();
		celda.innerHTML = registroAlumno[itemValor];
	}

	return tbody;
}

/**
 * Genera un elemento <thead> a partir de las claves de un objeto registro de un alumno.
 * @param {Object} registroAlumno - El registro del alumno que contiene las claves para los encabezados.
 * @returns {HTMLTableSectionElement} - El elemento <thead> generado y rellenado.
 */
function generaThead(registroAlumno) {
	const thead = document.createElement('thead');
	const encabezadoFila = thead.insertRow();

	for (const atributo in registroAlumno) {
		const elementoTh = document.createElement('th');
		elementoTh.setAttribute('scope', 'column');
		elementoTh.innerHTML = atributo.toUpperCase();
		encabezadoFila.appendChild(elementoTh);
	}

	return thead;
}

/**
 * Genera un elemento <table> con un atributo id especificado por parámetro.
 * @param {Object} id - El valor del atributo id.
 * @returns {HTMLTableElement} - El elemento <table> generado.
 */
function generaTable(id) {
	const table = document.createElement('table');
	table.setAttribute('id', id);

	return table;
}

/**
 * Genera un elemento <h2> con un mensaje especificado.
 * @param {string} mensaje - El mensaje que se mostrará en el elemento <h2>.
 * @returns {HTMLHeadingElement} - El elemento <h2> generado.
 */
function generah2(mensaje) {
	const h2 = document.createElement('h2');
	h2.innerHTML = mensaje;

	return h2;
}

/**
 * Genera un elemento <section> con el atributo id especificado.
 *
 * @param {string} id - El valor del atributo id que se asignará al elemento <section>.
 * @returns {HTMLElement} - El elemento <section> generado.
 */
function generaSection(id) {
	const section = document.createElement('section');
	section.setAttribute('id', id);

	return section;
}

/**
 * Crea una sección en el cuerpo del documento que muestra los datos de un registro
 * de alumno en una tabla.
 *
 * @param {Object} registroAlumno - El registro del alumno cuyos datos se mostrarán
 * 									en la tabla.
 */
function muestraSeccionDatos(registroAlumno) {
	const sectionDatos = generaSection('sectionDatos');
	document.body.appendChild(sectionDatos);

	const h2 = generah2('Datos del último alumno introducido');
	sectionDatos.appendChild(h2);

	const tabla = generaTable('tablaDatos');
	sectionDatos.appendChild(tabla);

	const thead = generaThead(registroAlumno);
	tabla.appendChild(thead);

	const tbody = generaTbody(registroAlumno);
	tabla.appendChild(tbody);

	return;
}

/**
 * Cambia el texto de un botón entre "Mostrar" y "Cerrar" alternativamente.
 */
function mensajeBotonMostrar() {
	const botonMostrar = document.getElementById('mostrar');

	botonMostrar.innerHTML = botonMostrar.innerHTML === 'Mostrar' ? 'Cerrar' : 'Mostrar';

	return;
}

/**
 * Genera un mapa de datos a partir de un objeto Alumno.
 *
 * @param {Alumno} alumno - El objeto Alumno del cual se extraen los datos.
 * @returns {Object} - El mapa de datos generado.
 */
function generaMapaDatos(alumno) {
	const mapaReturn = {
		Nombre: alumno.nombre,
		Apellidos: alumno.apellidos,
		Edad: `${alumno.edad} años`,
		'Postre favorito': alumno.postreFavorito,
		'Asignatura favorita': alumno.asignaturaFavorita,
	};

	return mapaReturn;
}

/**
 * Elimina la sección de datos y restaura el contenido del botón de mostrar.
 */
function removeSection() {
	const sectionDatos = document.getElementById('sectionDatos');

	if (sectionDatos) {
		document.body.removeChild(sectionDatos);
		mensajeBotonMostrar();
	}

	return;
}

/**
 * Alterna la visualización de datos de un alumno en una tabla y actualiza el botón.
 */
function toogleMuestraDatos() {
	eliminaParrafo();
	vaciaCampos();

	const tablaDatos = document.getElementById('tablaDatos');

	if (tablaDatos) {
		removeSection();
		return;
	}

	const ultimoRegistro = registroAlumnos.get(registroAlumnos.size);
	const mapaDatos = generaMapaDatos(ultimoRegistro);
	muestraSeccionDatos(mapaDatos);
	mensajeBotonMostrar();

	return;
}

/**
 * Agrega un evento de clic al botón 'Mostrar' para alternar la visualización de datos.
 */
function addEventoBotonMostrar() {
	const botonMostrar = document.getElementById('mostrar');
	botonMostrar.addEventListener('click', toogleMuestraDatos);

	return;
}

/**
 * Vacia los campos de entrada de datos en el formulario.
 */
function vaciaCampos() {
	const nombreInput = document.getElementById('nombre');
	const apellidosInput = document.getElementById('apellidos');
	const edadInput = document.getElementById('edad');
	const postreFavInput = document.getElementById('postre');
	const asignaturaFavInput = document.getElementById('asignatura');

	nombreInput.value = '';
	apellidosInput.value = '';
	edadInput.value = '';
	postreFavInput.value = '';
	asignaturaFavInput.value = '';

	return;
}

/**
 * Inserta un elemento <p> en el documento HTML.
 * @param {string} id - Valor que tendrá el atributo id del párrafo.
 * @param {string} clase - Valor que tendrá el atributo class del párrafo.
 * @param {string} mensaje - Mensaje que contendrá el párrafo.
 */
function generaParrafo(id, clase, mensaje) {
	const parrafoInformativo = document.createElement('p');
	parrafoInformativo.setAttribute('id', id);
	parrafoInformativo.classList.add(clase);
	parrafoInformativo.innerHTML = mensaje;

	const divAlumno = document.getElementsByClassName('alumno')[0];
	divAlumno.appendChild(parrafoInformativo);

	return;
}

/**
 * Elimina el párrafo de información del documento HTML.
 */
function eliminaParrafo() {
	const parrafoInformativo = document.getElementById('parrafoInfo');

	if (parrafoInformativo) {
		parrafoInformativo.remove();
	}

	return;
}

/**
 * Inserta un registro de alumno en el registro de alumnos a partir de los valores del formulario.
 */
function insertaRegistro() {
	eliminaParrafo();
	removeSection();

	const nombre = document.getElementById('nombre').value;
	const apellidos = document.getElementById('apellidos').value;
	const edad = parseInt(document.getElementById('edad').value);
	const postreFav = document.getElementById('postre').value;
	const asignaturaFav = document.getElementById('asignatura').value;

	if (!nombre || !apellidos || isNaN(edad) || !postreFav || !asignaturaFav) {
		generaParrafo('parrafoInfo', 'noValido', 'Alguno de los campos no está relleno. No se completó el formulario.');
		return;
	}

	const nuevoAlumno = new Alumno(nombre, apellidos, edad, postreFav, asignaturaFav);
	registroAlumnos.set(registroAlumnos.size + 1, nuevoAlumno);

	generaParrafo('parrafoInfo', 'valido', 'Alumno insertado con éxito.');
	vaciaCampos();

	return;
}

/**
 * Agrega un evento de clic al botón 'Insertar' para insertar un registro de alumno.
 */
function addEventoBotonInsertar() {
	const botonInsertar = document.getElementById('insertar');
	botonInsertar.addEventListener('click', insertaRegistro);

	return;
}

/**
 * Crea y agrega un botón "Insertar" en la sección de alumno.
 */
function addBotonInsertar() {
	const botonInsertar = document.createElement('button');
	const seccionAlumno = document.getElementsByClassName('alumno')[0];

	botonInsertar.setAttribute('type', 'button');
	botonInsertar.setAttribute('id', 'insertar');
	botonInsertar.innerHTML = 'Insertar';
	seccionAlumno.appendChild(botonInsertar);

	return;
}

/**
 * Inicializa la aplicación, agregando eventos a los botones.
 */
function init() {
	addBotonInsertar();
	addEventoBotonInsertar();
	addEventoBotonMostrar();

	return;
}

const registroAlumnos = new Map();
registroAlumnos.set(1, new Alumno('Alberto', 'Martínez Pérez', 33, 'Flan de huevo', 'Programación'));
registroAlumnos.set(2, new Alumno('Lucía', 'Sánchez Jiménez', 27, 'Croissant', 'Despliegue'));
registroAlumnos.set(3, new Alumno('Tomás', 'Luján Machado', 23, 'Natillas', 'Diseño Web'));

window.addEventListener('load', init);
