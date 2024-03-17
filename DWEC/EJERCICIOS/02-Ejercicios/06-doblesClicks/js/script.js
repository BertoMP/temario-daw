/**
 * Recarga la página actual.
 * @function
 * @returns {void}
 */
function reset() {
	location.reload();
}

/**
 * Genera un botón de reinicio en el elemento con el id 'main' 
 * y asigna un manejador de eventos para reiniciar la página 
 * cuando se hace clic en el botón.
 * @function
 * @returns {void}
 */
function generaBotonReinicio() {
	const main = document.getElementById('main');
	const botonReinicio = document.createElement('p');
	botonReinicio.innerHTML = 'Nuevo test';
	main.appendChild(botonReinicio);

	botonReinicio.addEventListener('click', reset);
}

/**
 * Genera información final en el elemento especificado con el 
 * porcentaje de dobles clicks y una recomendación al servicio 
 * técnico si es necesario.
 * @function
 * @param {HTMLElement} nodo -  El elemento donde se agregará la 
 *                              información final.
 * @returns {void}
 */
function infoFinal(nodo) {
	const porcentaje = (contadorDoblesClicks / contadorClicks) * 100;
	const parrafo = document.createElement('p');
    
	parrafo.classList.add(porcentaje >= 3 ? 'servicioTecnico' : 'normal');
	parrafo.innerHTML = `Tienes un ${porcentaje}% de dobles clicks.`
        + (porcentaje >= 3 ? ' Acude al servicio técnico.' : '');

	nodo.appendChild(parrafo);
	generaBotonReinicio();
}

/**
 * Desactiva los eventos de clic normal y doble clic en el botón 
 * de pulsación.
 * @function
 * @returns {void}
 */
function desactivaEventos() {
	botonPulsacion.removeEventListener('click', clickNormal);
	botonPulsacion.removeEventListener('dblclick', dobleClick);
}

/**
 * Limpia la información de la sección de información en el 
 * contenedor, si existe.
 * @function
 * @returns {void}
 */
function limpiaInfo() {
	const contenedor = document.getElementById('contenedor');
	const seccionInfo = document.getElementById('seccionInfo');
    
	if (seccionInfo) {
		contenedor.removeChild(seccionInfo);
	}
}

/**
 * Muestra información en la sección de información en el contenedor, 
 * incluyendo el número de pulsaciones totales y dobles pulsaciones.
 * Si el número de pulsaciones totales alcanza el máximo, desactiva 
 * los eventos y muestra información final.
 * @function
 * @returns {void}
 */
function muestraInfo() {
	limpiaInfo();

	const contenedor = document.getElementById('contenedor');
	const seccion = document.createElement('section');
	seccion.setAttribute('id', 'seccionInfo');
	contenedor.appendChild(seccion);

	const parrafoClicks = document.createElement('p');
	parrafoClicks.innerHTML = `Pulsaciones totales: ${contadorClicks}`;
	seccion.appendChild(parrafoClicks);
    
	const parrafoDoblesClicks = document.createElement('p');
	parrafoDoblesClicks.innerHTML = `Dobles pulsaciones: ${contadorDoblesClicks}`;
	seccion.appendChild(parrafoDoblesClicks);

	if (contadorClicks === pulsacionesMaximas) {
		desactivaEventos();
		infoFinal(seccion);
	}
}

/**
 * Cambia el color de fondo del botón de pulsación a un color 
 * especificado temporalmente y luego lo restablece.
 * @function
 * @param {string} color -  El color al que se cambiará el 
 *                          fondo del botón.
 * @returns {void}
 */
function colorea(color) {
	botonPulsacion.style.backgroundColor = color;

	setTimeout(function() {
		botonPulsacion.style.backgroundColor = '';
	}, 300);
}

/**
 * Maneja un evento de doble clic en el botón de pulsación, 
 * aumenta los contadores, cambia el color temporalmente y 
 * muestra información.
 * @function
 * @returns {void}
 */
function dobleClick() {
	contadorClicks++;
	contadorDoblesClicks++;
	colorea('#ff1007');
	muestraInfo();
}

/**
 * Maneja un evento de clic normal en el botón de pulsación, 
 * aumenta el contador, cambia el color temporalmente y 
 * muestra información.
 * @function
 * @returns {void}
 */
function clickNormal() {
	contadorClicks++;
	colorea('#008f39');
	muestraInfo();
}

const pulsacionesMaximas = 100; // Número máximo de pulsaciones permitidas.

let contadorClicks = 0; // Contador de clics normales.
let contadorDoblesClicks = 0; // Contador de dobles clics.

const botonPulsacion = document.getElementById('botonClick');
botonPulsacion.addEventListener('click', clickNormal);
botonPulsacion.addEventListener('dblclick', dobleClick);