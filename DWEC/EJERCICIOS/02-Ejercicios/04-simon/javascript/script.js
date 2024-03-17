/**
 * Ajusta los tiempos del juego reduciéndolos en un 10%.
 */

function ajustarTiempos() {
    tiempoIluminacion = ((tiempoIluminacion *= 0.9) > 300) ? tiempoIluminacion *= 0.9 : 300;
    tiempoEntrePasos = ((tiempoEntrePasos *= 0.9) > 500) ? tiempoEntrePasos *= 0.9 : 500;
}

/**
 * Desactiva el listener de clic en los botones de colores para detener la interacción del usuario.
 * 
 * Esta función elimina el listener de clic previamente agregado al contenedor de botones de colores,
 * lo que impide que el usuario interactúe con el juego hasta que se vuelva a activar.
 */

function desactivaListener() {
    const contenedorBotones = document.getElementById('containerBotones');

    // Elimina el listener de clic del contenedor de botones para detener la interacción del usuario.
    contenedorBotones.removeEventListener('click', clickColor);
}

/**
 * Comprueba si el usuario ha completado la secuencia actual.
 * @returns {boolean} Verdadero si la secuencia del usuario está completa, falso en caso contrario.
 */

function haCompletadoSecuencia() {
    return secuenciaUser.length === rondaActual;
}

/**
 * Finaliza el juego y muestra un mensaje de resultado. 
 * 
 * Esta función elimina cualquier clase CSS aplicada al botón de inicio, 
 * luego llama a la función `actualizaParrafo` para mostrar el mensaje de resultado.
 * 
 * @param {string} mensaje - El mensaje que se mostrará como resultado del juego.
 */

function finJuego(mensaje) {
    actualizaParrafo(mensaje);
    botonInicio.setAttribute('class', '');
}

/**
 * Comprueba si el último color ingresado por el usuario coincide con el de la secuencia de la CPU.
 * @param {number} contador - El índice del último color ingresado por el usuario.
 * @returns {boolean} Verdadero si no coincide, falso en caso contrario.
 */

function coincideUltimoColor(contador) {
    return secuenciaCPU[contador] === secuenciaUser[contador];
}

/**
 * Comprueba el estado del juego después de que el usuario haga clic en un color.
 */

function comprueba() {
    const contador = secuenciaUser.length - 1;

    if (!coincideUltimoColor(contador)) {
        finJuego(`¡Has perdido! Rondas completadas: ${rondaActual - 1}`);
        return;
    }

    if (haCompletadoSecuencia()) {
        rondaActual++;

        desactivaListener();
        ajustarTiempos();
        rondaJuego();
    }
}

/**
 * Maneja el evento de clic en un botón de color durante el juego.
 * 
 * @param {Event} evento - El evento de clic del usuario.
 */

function clickColor(evento) {
    const colorClickado = evento.target.id;
    
    if (colorClickado !== 'containerBotones') {
        secuenciaUser.push(colorClickado);
        
        comprueba();
    }
}

/**
 * Activa el listener de clic en los botones de colores para permitir que el usuario juegue.
 * 
 * Esta función reinicia la secuencia del usuario y agrega un listener de clic al contenedor
 * de botones de colores para que el usuario pueda interactuar con el juego.
 */

function activaListener() {
    const contenedorBotones = document.getElementById('containerBotones');

    // Agrega un listener de clic al contenedor de botones para manejar los clics en los colores.
    contenedorBotones.addEventListener('click', clickColor);
}

/**
 * Ilumina un botón de color en la interfaz del juego temporalmente.
 * 
 * @param {string} color - El ID del botón de color que se iluminará.
 */

function iluminaBoton(color) {
    const boton = document.getElementById(color);

    // Agrega la clase 'activo' al botón para resaltar el color temporalmente.
    boton.classList.add('activo');

    // Elimina la clase 'activo' después de un tiempo para desactivar la iluminación.
    setTimeout(function() {
        boton.classList.remove('activo');
    }, tiempoIluminacion); // Tiempo que pasará hasta que se desactive.
}

/**
 * Ilumina secuencialmente la secuencia de colores generada por la CPU en el juego.
 * 
 * Esta función inicia un intervalo que ilumina cada color de la secuencia de la CPU
 * de manera secuencial con un cierto intervalo de tiempo entre pasos. Una vez que se
 * completa la secuencia, activa el listener para permitir que el usuario juegue.
 */

function iluminaSecuenciaCPU() {
    let indiceSecuenciaCPU = 0;

    // Inicia un intervalo que ilumina los colores de la secuencia uno por uno.
    const intervalo = setInterval(function() {
        iluminaBoton(secuenciaCPU[indiceSecuenciaCPU]);
        indiceSecuenciaCPU++;

        // Comprueba si se ha iluminado toda la secuencia.
        if (indiceSecuenciaCPU === rondaActual) {
            clearInterval(intervalo); // Detiene el intervalo.
            secuenciaUser = []; // Reinicia la secuencia del usuario.
            activaListener(); // Activa el listener para el usuario.
        }
    }, tiempoEntrePasos); // Intervalo de tiempo entre pasos.
}

/**
 * Genera un color aleatorio y lo añade a la secuencia de la CPU.
 */

function addColorSecuenciaCPU() {
    const colorAleatorio = colores[Math.floor(Math.random() * colores.length)];
    secuenciaCPU.push(colorAleatorio); // Agrega el color a la secuencia de la CPU.
}

/**
 * Actualiza el contenido de un elemento de párrafo con el mensaje proporcionado.
 * 
 * @param {string} mensaje - El mensaje que se utilizará para actualizar el párrafo.
 */

function actualizaParrafo(mensaje) {
    const parrafoInfo = document.getElementById('parrafoInfo');
    
    parrafoInfo.innerHTML = mensaje;
}

/**
 * Controla el flujo de juego y gestiona las rondas.
 * 
 * Esta función comprueba si la ronda actual es menor o igual al número máximo de rondas
 * establecido en el juego. Si es así, muestra un mensaje con el número de ronda actual y
 * llama a la función `iluminaSecuenciaCPU` para iniciar una nueva ronda. Si la ronda actual
 * supera el número máximo de rondas, llama a la función `finJuego` para mostrar un mensaje
 * de felicitación por completar el juego.
 */

function rondaJuego() {
    if (rondaActual <= rondasMaximas) {
        actualizaParrafo(`Ronda ${rondaActual} de ${rondasMaximas}`);
        addColorSecuenciaCPU();
        iluminaSecuenciaCPU();
    } else {
        finJuego('¡Felicidades! Has completado el juego.');
    }
}

/**
 * Solicita al jugador que defina el número máximo de rondas del juego.
 * 
 * Esta función muestra un cuadro de diálogo al jugador para que introduzca el número
 * máximo de rondas que desea jugar. Luego, valida la entrada para asegurarse de que sea
 * un número entero mayor que cero. Continúa solicitando la entrada hasta que se proporcione
 * un valor válido y, finalmente, devuelve el número máximo de rondas elegido.
 *
 * @returns {number} - El número máximo de rondas definido por el jugador.
 */

function defineRondasMaximas() {
    let rondasReturn;

    do {
        rondasReturn = prompt('Define el máximo de rondas:');

        if (rondasReturn === null) {
            return null;
        } else if (isNaN(rondasReturn) || rondasReturn <= 0) {
            alert('Debes introducir un número entero mayor de 0.');
            rondasReturn = 0;
        }
    } while (!rondasReturn);

    return parseInt(rondasReturn);
}

/**
 * Inicia el juego y configura la primera ronda.
 * 
 * Esta función establece los valores por defecto, solicita al jugador que defina el número
 * máximo de rondas mediante la función `defineRondasMaximas`, oculta el botón de inicio e
 * inicia la primera ronda del juego llamando a la función `rondaJuego`.
 */

function inicioJuego() {
    rondaActual = 1; // Establece la ronda actual en 1.
    secuenciaCPU = []; // Reestablece la secuencia de la CPU.
    tiempoIluminacion = 1000; // Tiempo de iluminación a 1000ms.
    tiempoEntrePasos = 1500; // Tiempo entre pasos a 1500ms.
    rondasMaximas = defineRondasMaximas(); // Solicita al jugador el número máximo de rondas.
    if (rondasMaximas !== null) {
        botonInicio.classList.add('oculto'); // Oculta el botón de inicio.
        rondaJuego(); // Inicia la primera ronda del juego.
    }
}

// VARIABLES Y CONSTANTES GLOBALES
const colores = ['rojo', 'verde', 'azul', 'amarillo']; // Conjunto de colores disponibles en el juego.
let secuenciaCPU = []; // Almacena la secuencia de colores generada por la CPU.
let tiempoIluminacion = 0; // Tiempo en milisegundos que un botón de color permanece iluminado durante el juego.
let tiempoEntrePasos = 0; // Tiempo en milisegundos entre los pasos de iluminación de la secuencia de colores de la CPU.
let secuenciaUser = []; // Almacena la secuencia de colores ingresada por el usuario durante el juego.
let rondaActual = 0; // Número de la ronda actual en el juego.
let rondasMaximas = 0; // Número máximo de rondas que se jugarán en la partida.

// INICIO
const botonInicio = document.getElementById('botonInicio');
botonInicio.addEventListener('click', inicioJuego);