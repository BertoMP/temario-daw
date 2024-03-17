import { ciudades } from './ciudades.js';

/**
 * Genera un elemento 'tbody' que muestra la información del vuelo en forma de tabla.
 * Cada atributo del vuelo se muestra como una fila con dos celdas (nombre del atributo y valor).
 * @param {Object} vuelo - Objeto que contiene la información del vuelo.
 * @returns {HTMLTableSectionElement} Elemento 'tbody' con la información del vuelo.
 */
function generaTbody(vuelo) {
	const tbody = document.createElement('tbody');

	for (const atributo in vuelo) {
		const tr = generaElemento('tr');
		tbody.appendChild(tr);

		const th = generaElemento('th', atributo);
		tr.appendChild(th);

		const valorCampo = vuelo[atributo];
		const td = generaElemento('td', valorCampo);
		tr.appendChild(td);
	}

	return tbody;
}

/**
 * Genera una tabla de datos finales para un vuelo específico.
 * @param {object} vuelo - Objeto que contiene los datos del vuelo para llenar la tabla.
 * @returns {HTMLTableElement} - Tabla HTML con los datos del vuelo.
 */
function generaTablaDatosFinaleS(vuelo) {
	const tabla = generaElemento('table');

	const tbody = generaTbody(vuelo);
	tabla.appendChild(tbody);

	return tabla;
}

/**
 * Obtiene la ruta de la imagen correspondiente a una ciudad específica.
 * @param {string} ciudad - El nombre de la ciudad para obtener la ruta de la imagen.
 * @returns {string} - La ruta de la imagen para la ciudad dada.
 */
function getRutaImagen(ciudad) {
	return ciudadImagen[ciudad];
}

/**
 * Genera un elemento de imagen con la ruta correspondiente según la ciudad especificada.
 * @param {string} ciudad - Nombre de la ciudad para obtener la ruta de la imagen.
 * @returns {HTMLImageElement} - Elemento de imagen con la ruta asignada.
 */
function generaImagenFinal(ciudad) {
	const img = generaElemento('img');
	img.setAttribute('src', getRutaImagen(ciudad));

	return img;
}

/**
 * Genera un fragmento de documento que muestra la información de un vuelo en forma de tabla.
 * @param {Object} vuelo - Objeto que contiene la información del vuelo.
 * @returns {DocumentFragment} Fragmento de documento generado.
 */
function generaFragmentoVueloFinal(vuelo) {
	const fragmento = document.createDocumentFragment();

	const h2 = generaElemento('h2', 'TU VUELO');
	fragmento.appendChild(h2);

	const img = generaImagenFinal(vuelo.CIUDAD);
	fragmento.appendChild(img);

	const tabla = generaTablaDatosFinaleS(vuelo);
	fragmento.appendChild(tabla);

	return fragmento;
}

/**
 * Inserta un fragmento HTML representando la información de un vuelo en forma de tabla
 * en el elemento con el ID 'sec-info'.
 * @param {Object} vuelo - Objeto que contiene la información del vuelo.
 */
function insertaFragmentoTabla(vuelo) {
	const articuloInformacion = document.getElementById('sec-info');
	const fragmento = generaFragmentoVueloFinal(vuelo);

	articuloInformacion.appendChild(fragmento);
}

/**
 * Formatea un objeto de vuelo con detalles específicos para presentación al usuario.
 * @param {Object} objetoVuelo - Objeto de vuelo a formatear.
 * @returns {Object} Objeto formateado con propiedades específicas para la visualización.
 */
function formateaObjetoVuelo(objetoVuelo) {
	return {
		'CIUDAD': objetoVuelo.name,
		'CONTINENTE': objetoVuelo.continent,
		'DURACIÓN': `${objetoVuelo.details.days} días`,
		'ESCALAS': (objetoVuelo.details.stops.length !== 0)
			? objetoVuelo.details.stops.join(', ')
			: 'Sin escalas',
		'PRECIO': `${objetoVuelo.details.budget} €`
	};
}

/**
 * Presenta el resultado final del vuelo seleccionado al usuario.
 */
function imprimeResultadoFinal() {
	eliminarElementosInfo();

	const vueloUsuario = formateaObjetoVuelo(vuelosUsuario[0]);

	insertaFragmentoTabla(vueloUsuario);
}

/**
 * Filtra la lista de vuelos ('vuelosUsuario') según el valor seleccionado en un
 * campo de formulario.
 * @param {Event} evento - Evento que desencadena el filtro.
 */
function filtrar(evento) {
	const filtro = evento.target.id.split('-').pop();
	let valorSelect = String(document.getElementById('slc-filtro').value);

	if (filtro === 'days' || filtro === 'budget' || filtro === 'stops') {
		valorSelect = parseInt(valorSelect.split(' ').shift());
	}

	const arrAux = [];

	for (const vuelo of vuelosUsuario) {
		let filtroVuelo;

		if (filtro === 'days' || filtro === 'budget') {
			filtroVuelo = vuelo.details[filtro];
		} else if (filtro === 'stops') {
			filtroVuelo = vuelo.details[filtro].length;
		} else {
			filtroVuelo = vuelo[filtro];
		}

		if (filtroVuelo === valorSelect) {
			arrAux.push(vuelo);
		}
	}

	vuelosUsuario = arrAux;
}

/**
 * Verifica si existe solo un vuelo en el array 'vuelosUsuario'.
 * @returns {boolean} Devuelve 'true' si hay exactamente un vuelo, de lo contrario, devuelve 'false'.
 */
function unicoVuelo() {
	return vuelosUsuario.length === 1;
}

/**
 * Controlador de evento para avanzar a la siguiente pregunta en el formulario de filtrado.
 * Filtra los vuelos según los criterios establecidos en el formulario.
 * Si queda un único vuelo después del filtrado, imprime el resultado final.
 * De lo contrario, agrega un filtro adicional para seleccionar una ciudad.
 * @param {Event} evento - Evento que desencadenó la función.
 */
function siguientePregunta(evento) {
	filtrar(evento);

	console.log(vuelosUsuario);

	if (unicoVuelo()) {
		imprimeResultadoFinal();
	} else {
		agregarFiltro('name', '¿Elige una ciudad?');
	}
}

/**
 * Función de comparación para ordenar valores numéricos en orden ascendente.
 * @param {string} elementoA - Primer elemento a comparar.
 * @param {string} elementoB - Segundo elemento a comparar.
 * @returns {number} Valor negativo si A es menor que B, valor positivo si A es mayor que B, 0 si son iguales.
 */
function comparaValoresNumericos(elementoA, elementoB) {
	const valorA = parseInt(elementoA);
	const valorB = parseInt(elementoB);

	if (valorA !== valorB) {
		return valorA - valorB;
	}
	return 0;
}

/**
 * Genera un array de valores únicos basados en un filtro dado.
 * @param {string} filtro - Tipo de filtro para generar el array de valores.
 * @returns {Array} Array de valores únicos basados en el filtro.
 */
function generaArray(filtro) {
	const arrayReturn = [];

	for (const vuelo of vuelosUsuario) {
		let filtroVuelo;

		if (filtro === 'days' || filtro === 'budget') {
			filtroVuelo = vuelo.details[filtro];
		} else if (filtro === 'stops') {
			filtroVuelo = vuelo.details[filtro].length;
		} else {
			filtroVuelo = vuelo[filtro];
		}

		if (!arrayReturn.includes(filtroVuelo)) {
			arrayReturn.push(filtroVuelo);
		}
	}

	if (filtro === 'days' || filtro === 'budget' || filtro === 'stops') {
		return arrayReturn.sort(comparaValoresNumericos);
	} else {
		return arrayReturn.sort();
	}
}

/**
 * Genera un fragmento de formulario con elementos HTML para un filtro específico.
 * @param {string} opcionFiltro - Tipo de filtro para generar el formulario.
 * @param {string} texto - Texto asociado al filtro.
 * @returns {DocumentFragment} Fragmento de formulario generado.
 */
function generaFragmentoFormulario(opcionFiltro, texto) {
	const fragmento = document.createDocumentFragment();

	const articlePregunta = generaElemento('article');
	fragmento.appendChild(articlePregunta);

	const h4 = generaElemento('h4', texto);
	articlePregunta.appendChild(h4);

	const select = generaElemento('select', null, 'slc-filtro');
	articlePregunta.appendChild(select);

	const arrayFiltro = generaArray(opcionFiltro);

	for (const elemento of arrayFiltro) {
		const option = generaElemento('option', elemento, null, opcionFiltro);
		select.appendChild(option);
	}

	const articleBoton = generaElemento('article');
	fragmento.appendChild(articleBoton);

	const botonSiguiente = generaElemento('button', 'Siguiente', `btn-filtrar-${opcionFiltro}`);
	botonSiguiente.addEventListener('click', siguientePregunta);

	articleBoton.appendChild(botonSiguiente);

	return fragmento;
}

/**
 * Agrega un nuevo formulario de filtro al elemento con el ID 'sec-info'.
 * @param {string} tipo - Tipo de filtro a agregar.
 * @param {string} texto - Texto o pregunta asociada al filtro.
 */
function agregarFiltro(tipo, texto) {
	eliminarElementosInfo();

	const articuloInformacion = document.getElementById('sec-info');
	const fragmento = generaFragmentoFormulario(tipo, texto);

	articuloInformacion.appendChild(fragmento);
}

/**
 * Controlador de evento para filtrar por continentes.
 */
function filtraContinentes() {
	agregarFiltro('continent', '¿A qué continente quieres viajar?');
}

/**
 * Controlador de evento para filtrar por escalas.
 */
function filtraEscalas() {
	agregarFiltro('stops', '¿Cuántas escalas quieres?');
}

/**
 * Controlador de evento para filtrar por días.
 */
function filtraDias() {
	agregarFiltro('days', '¿Cuántos días quieres que duren tus vacaciones?');
}

/**
 * Controlador de evento para filtrar por precio.
 */
function filtraPrecio() {
	agregarFiltro('budget', '¿Qué presupuesto tienes?');
}

/**
 * Genera un elemento HTML dinámicamente según los parámetros proporcionados.
 * @param {string} type - Tipo de elemento a crear ('div', 'span', 'button', 'option', etc.).
 * @param {string|number} texto - Texto o contenido del elemento (opcional).
 * @param {string} id - Identificador único del elemento (opcional).
 * @param {string} opcionFiltro - Opción específica del filtro para elementos 'option' (opcional).
 * @returns {HTMLElement} Elemento HTML generado dinámicamente.
 */
function generaElemento(type, texto, id, opcionFiltro) {
	const elemento = document.createElement(type);

	if (texto || texto === 0) {
		elemento.innerHTML = texto;
	}

	if (type === 'option') {
		switch (opcionFiltro) {
		case 'days':
			elemento.innerHTML += ' días';
			break;
		case 'budget':
			elemento.innerHTML += ' €';
			break;
		case 'stops':
			elemento.innerHTML += ' escalas';
			break;
		}
	}

	if (id) {
		elemento.id = id;
	}

	return elemento;
}

/**
 * Agrega eventos de clic a los botones de filtrado.
 * @returns {void} No devuelve ningún valor.
 */
function addEventosFiltrado() {
	const botonFiltroPrecio = document.getElementById('btn-precio');
	botonFiltroPrecio.addEventListener('click', filtraPrecio);

	const botonFiltroDias = document.getElementById('btn-días');
	botonFiltroDias.addEventListener('click', filtraDias);

	const botonFiltroEscalas = document.getElementById('btn-escalas');
	botonFiltroEscalas.addEventListener('click', filtraEscalas);

	const botonFiltroContinentes = document.getElementById('btn-continentes');
	botonFiltroContinentes.addEventListener('click', filtraContinentes);
}

/**
 * Genera un fragmento de documento con botones de filtrado.
 * @returns {DocumentFragment} Devuelve un fragmento de documento con botones de filtrado.
 */
function generaFragmentoBotonesFiltrado() {
	const fragmento = document.createDocumentFragment();

	const valoresFiltrado = ['Precio', 'Días', 'Escalas', 'Continentes'];

	const articleEncabezado = generaElemento('article');
	fragmento.appendChild(articleEncabezado);

	const h4 = generaElemento('h4', '¿Cómo quieres elegir tu viaje?');
	articleEncabezado.appendChild(h4);

	const articleBotones = generaElemento('article');
	fragmento.appendChild(articleBotones);

	for (const value of valoresFiltrado) {
		const botonFiltro = generaElemento('button', value, `btn-${value.toLowerCase()}`);
		articleBotones.appendChild(botonFiltro);
	}

	return fragmento;
}

/**
 * Genera y añade botones de filtrado al artículo de información en la interfaz.
 * @returns {void}
 */
function generarBotonesFiltrado() {
	const articuloInformacion = document.getElementById('sec-info');
	const fragmento = generaFragmentoBotonesFiltrado();
	articuloInformacion.appendChild(fragmento);
}

/**
 * Elimina de manera iterativa todos los nodos hijos del artículo de información
 * identificado por su ID en la interfaz.
 * @returns {void}
 */
function eliminarElementosInfo() {
	const articuloInformacion = document.getElementById('sec-info');

	do {
		let nodoHijo = articuloInformacion.firstChild;

		if (nodoHijo) {
			articuloInformacion.removeChild(nodoHijo);
		}
	} while(articuloInformacion.firstChild);
}

/**
 * Inicia un formulario al eliminar elementos de información, generar botones de filtrado
 * y agregar eventos a los botones generados.
 * @returns {void}
 */
function comenzarFormulario() {
	eliminarElementosInfo();
	generarBotonesFiltrado();
	addEventosFiltrado();
}

/**
 * Agrega un evento de escucha al botón de inicio en la interfaz.
 * @returns {void}
 */
function addEventoEscuchaInicio() {
	const botonInicio = document.getElementById('btn-inicio');
	botonInicio.addEventListener('click', comenzarFormulario);
}

/**
 * Obtiene de manera aleatoria un elemento de un array proporcionado.
 * @param {Array} array - Array del cual se quiere obtener un elemento aleatorio.
 * @returns {string} Elemento aleatorio del array proporcionado.
 */
function getRandomImage(array) {
	const indiceAleatorio = Math.floor(Math.random() * array.length);

	return array[indiceAleatorio];
}

/**
 * Inserta imágenes en los elementos HTML de la portada.
 * @param {string[]} fotos - Array de URLs de imágenes a insertar en la portada.
 * @returns {void}
 */
function insertFotos(fotos) {
	const articlesPortada = document.getElementsByClassName('img-portada');

	for (let intCont = 0; intCont < articlesPortada.length; intCont++) {
		articlesPortada[intCont].style.backgroundImage = 'url(' + fotos[intCont] + ')';
	}
}

/**
 * Agrega imágenes de fondo a la interfaz de usuario.
 * @returns {void}
 */
function addFotosFondo() {
	const urlImages = Object.values(ciudadImagen);
	const fotosRandom = [];

	for (let intCont = 0; intCont < 5;) {
		const urlImagen = getRandomImage(urlImages);

		if (!fotosRandom.includes(urlImagen)) {
			fotosRandom.push(urlImagen);
			intCont++;
		}
	}

	insertFotos(fotosRandom);
}

/**
 * Inicializa la aplicación.
 * @returns {void}
 */
function init() {
	vuelosUsuario = ciudades;
	addFotosFondo();
	addEventoEscuchaInicio();
}

let vuelosUsuario = [];

const ciudadImagen = {
	'Ámsterdam': './assets/image/amsterdam.jpg',
	'Auckland': './assets/image/auckland.jpg',
	'Barcelona': './assets/image/barcelona.jpg',
	'Berlin': './assets/image/berlin.jpg',
	'Casablanca': './assets/image/casablanca.webp',
	'Ciudad de México': './assets/image/ciudad-de-mexico.jpg',
	'Ciudad del Cabo': './assets/image/ciudad-del-cabo.jpg',
	'El Cairo': './assets/image/el-cairo.jpg',
	'Lagos': './assets/image/lagos.jpg',
	'Londres': './assets/image/londres.webp',
	'Los Ángeles': './assets/image/los-angeles.jpeg',
	'Mumbai': './assets/image/mumbai.jpg',
	'Nairobi': './assets/image/nairobi.jpg',
	'Nueva York': './assets/image/nueva-york.webp',
	'Papeete': './assets/image/papeete.png',
	'Pekín': './assets/image/pekin.jpg',
	'Port Moresby': './assets/image/port-moresby.jpg',
	'Río de Janeiro': './assets/image/rio-de-janeiro.jpg',
	'Roma': './assets/image/roma.webp',
	'Seúl': './assets/image/seul.jpg',
	'Sidney': './assets/image/sidney.jpg',
	'Singapur': './assets/image/singapur.jpg',
	'Tokelau': './assets/image/tokelau.webp',
	'Tokio': './assets/image/tokio.jpg',
	'Toronto': './assets/image/toronto.jpg',
};

window.addEventListener('DOMContentLoaded', init);