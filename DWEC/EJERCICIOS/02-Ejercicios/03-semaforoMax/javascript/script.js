/**
 * Resetea las clases de los elementos span y button del documento. 
 */
function reset() {
    const arbolSpan = document.getElementsByTagName('span');
    const arbolBotones = document.getElementsByTagName('button');
    const elementoAudio = document.getElementById('himnoPB');

    for (let span of arbolSpan) {
        span.setAttribute('class','');
    }

    for (let button of arbolBotones) {
        button.setAttribute('class','');
    }

    if (elementoAudio) {
        const contenedorPrincipal = document.getElementById('contenedor-principal');
        contenedorPrincipal.removeChild(elementoAudio);
    }

    return;
}

/**
 * Genera un elemento <audio> con los valores que recibe por parámetro y lo
 * devuelve como resultado de la función.
 * 
 * @param {string} id - id que tendrá el elemento audio. 
 * @param {string} ruta - ruta del audio en el proyecto.
 * @returns {HTMLElement} - El elemento audio creado.
 */
function crearElementoAudio(id, ruta) {
    const elementoAudio = document.createElement('audio');
    elementoAudio.setAttribute('id', id);
    elementoAudio.setAttribute('src', ruta);
    elementoAudio.setAttribute('controls', true);
    elementoAudio.setAttribute('autoplay', true);

    return elementoAudio;
}

/**
 * Coloca el semáforo con los colores de la bandera de Países Bajos y añade
 * un elemento <audio> al documento.
 */
function setMax() {
    const arbolSpan = document.getElementsByTagName('span');
    reset();
    arbolSpan[0].classList.add('rojo');
    arbolSpan[2].classList.add('azul');

    const elementoAudio = crearElementoAudio('himnoPB', './audio/himnoPaisesBajos.mp3');
    const contenedorPrincipal = document.getElementById('contenedor-principal');
    contenedorPrincipal.appendChild(elementoAudio);

    return;
}

/**
 * Determina el color que tiene el elemento <span> con el id pasado por parámetro.
 * @param {string} id - Atributo id del span a modificar.
 * @param {string} color - Color que tendrá el span.
 */
function setColor(id, color) {
    const span = document.getElementById(id);
    reset();
    span.classList.add(color);

    return;
}

const botonVerde = document.getElementById('verde'); // Nodo del botón con id 'verde'.
botonVerde.addEventListener('click', function(){
    if (botonVerde.classList.contains('presionado')) {
        reset();
    } else {
        setColor('span1', 'verde');
        botonVerde.classList.add('presionado');
    }
});

const botonAmarillo = document.getElementById('amarillo'); // Nodo del botón con id 'amarillo'.
botonAmarillo.addEventListener('click', function(){
    if (botonAmarillo.classList.contains('presionado')) {
        reset();
    } else {
        setColor('span2', 'amarillo');
        botonAmarillo.classList.add('presionado');
    }
});

const botonRojo = document.getElementById('rojo'); // Nodo del botón con id 'rojo'.
botonRojo.addEventListener('click', function(){
    if (botonRojo.classList.contains('presionado')) {
        reset();
    } else {
        setColor('span3', 'rojo');
        botonRojo.classList.add('presionado');
    }
});

const botonMax = document.getElementById('max'); // Nodo del botón con id 'max'.
botonMax.addEventListener('click', function(){
    if (botonMax.classList.contains('presionado')) {
        reset();
    } else {
        setMax();
        botonMax.classList.add('presionado');
    }
});

const botonReset = document.getElementById('reset'); // Nodo del botón con id 'reset'.
botonReset.addEventListener('click', function(){
    reset();
    botonReset.classList.add('presionado');
    setTimeout(function(){
        botonReset.classList.remove('presionado');
    }, 200);
});