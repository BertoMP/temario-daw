// CLASES
/**
 * Clase Player
 * 
 * Representa un jugador en un juego con los atributos nombre, edad y 
 * estadísticas de victorias, dederrotas y de rondas completadas.
 *
 * Esta clase permite crear y gestionar jugadores, gestionando sus 
 * progresos en el juego. Cada jugador tiene un nombre, edad,
 * y estadísticas relacionadas con su rendimiento en el juego, 
 * como el número de victorias, derrotas y rondas completadas.
 *
 * @class
 */
class Player {
    // ATRIBUTOS
    #nombre; // Nombre del jugador.
    #edad; // Edad del jugador.
    #victorias; // Victorias del jugador.
    #derrotas; // Derrotas del jugador.
    #rondasCompletadas; // Rondas ganadas por el jugador.

    /**
     * Constructor de la clase Player. 
     * 
     * Crea una nueva instancia de Player con el nombre y la edad especificados, 
     * inicializando las estadísticas de victorias, derrotas y rondas completadas
     * en cero por defecto.
     *
     * @param {string} nombre - El nombre del jugador.
     * @param {number} edad - La edad del jugador.
     */

    constructor(nombre, edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.victorias = 0;
        this.derrotas = 0;
        this.rondasCompletadas = 0;
    }

    /**
     * Incrementa el número de victorias del jugador.
     */

    ganaPartida = () => this.victorias++;

    /**
     * Incrementa el número de derrotas del jugador.
     */

    pierdePartida = () => this.derrotas++;


    /**
     * Incrementa el número de rondas completadas por el jugador.
     */

    completaRonda = () => this.rondasCompletadas++;

    /**
     * Devuelve una representación en formato de texto de los datos del jugador.
     *
     * @returns {string} - Los datos del jugador en formato de texto.
     */

    toString = () => `Usuario: ${this.nombre} (${this.edad} años) <br />
                    Victorias: ${this.victorias} <br/>
                    Derrotas: ${this.derrotas} <br />
                    Rondas completadas: ${this.rondasCompletadas}`;

}

// FUNCIONES DEL PROGRAMA
/**
 * Ajusta los tiempos del juego reduciéndolos en un 10%.
 */

function ajustarTiempos() {
    tiempoIluminacion = Math.max(tiempoIluminacion * 0.9, 300);
    tiempoEntrePasos = Math.max(tiempoEntrePasos * 0.9, 500);
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
 * Función muestra un mensaje de victoria, actualiza el párrafo en el juego, 
 * resetea el botón de inicio, registra la victoria en el jugador 
 * y muestra los datos del usuario.
 */

function victoria() {
    const mensaje = '¡Felicidades! <br /> Has completado el nivel.'
    actualizaParrafo(mensaje);
    resetearBotonInicio();
    nuevoJugador.ganaPartida();
    datosUsuario();
}

/**
 * Comprueba si el usuario ha completado la secuencia actual.
 * @returns {boolean} Verdadero si la secuencia del usuario está completa, falso en caso contrario.
 */

function haCompletadoSecuencia() {
    return secuenciaPlayer.length === rondaActual;
}

/**
 * Resetea el estado del botón inicio.
 */

function resetearBotonInicio() {
    botonInicio.setAttribute('class', '');
}

/**
 * Función muestra un mensaje de derrota, actualiza el párrafo en el juego, 
 * resetea el botón de inicio, registra la derrota en el jugador 
 * y muestra los datos del usuario.
 */

function derrota() {
    const mensaje = `¡Has perdido! <br /> Rondas completadas: ${rondaActual - 1}`
    actualizaParrafo(mensaje);
    resetearBotonInicio();
    nuevoJugador.pierdePartida();
    datosUsuario();
}

/**
 * Comprueba si el último color ingresado por el usuario coincide con el de la secuencia de la CPU.
 * @param {number} contador - El índice del último color ingresado por el usuario.
 * @returns {boolean} Verdadero si no coincide, falso en caso contrario.
 */

function coincideUltimoColor(contador) {
    return secuenciaCPU[contador] === secuenciaPlayer[contador];
}

/**
 * Comprueba el estado del juego después de que el usuario haga clic en un color.
 */

function comprueba() {
    const contador = secuenciaPlayer.length - 1;

    if (!coincideUltimoColor(contador)) {
        derrota();
        return;
    }

    if (haCompletadoSecuencia()) {
        rondaActual++;

        nuevoJugador.completaRonda();
        datosUsuario();
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
        secuenciaPlayer.push(colorClickado);

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
    setTimeout(function () {
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
    const intervalo = setInterval(function () {
        iluminaBoton(secuenciaCPU[indiceSecuenciaCPU]);
        indiceSecuenciaCPU++;

        // Comprueba si se ha iluminado toda la secuencia.
        if (indiceSecuenciaCPU === rondaActual) {
            clearInterval(intervalo); // Detiene el intervalo.
            secuenciaPlayer = []; // Reinicia la secuencia del usuario.
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
 * supera el número máximo de rondas, llama a la función `victoria` para mostrar un mensaje
 * de felicitación por completar el juego.
 */

function rondaJuego() {
    if (rondaActual <= rondasMaximas) {
        actualizaParrafo(`Ronda ${rondaActual} de ${rondasMaximas}`);
        addColorSecuenciaCPU();
        iluminaSecuenciaCPU();
    } else {
        victoria();
    }
}

/**
 * Solicita al jugador que defina el número máximo de rondas del juego.
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
 * Solicita al jugador que defina su edad.
 * 
 * @returns {number} - La edad definida por el jugador.
 */

function defineEdad() {
    let edadReturn;

    do {
        edadReturn = prompt('Dime tu edad:');

        if (isNaN(edadReturn) || edadReturn <= 0) {
            alert('Debes introducir un número entero mayor de 0.');
            edadReturn = 0;
        }

    } while (!edadReturn);

    return parseInt(edadReturn);
}

/**
 * Solicita al jugador que defina su nombre.
 * 
 * @returns {string} - El nombre definido por el jugador. 
 */

function defineNombre() {
    let nombreReturn;

    do {
        nombreReturn = prompt('Dime tu nombre:');

        if (!nombreReturn) {
            alert('El nombre no puede ser un campo vacío.');
        }
    } while (!nombreReturn);

    return nombreReturn;
}

/**
 * Genera un objeto jugador y lo devuelve como resultado de la función.
 * 
 * @returns {Player} - El objeto Player generado. 
 */

function generaJugador() {
    const nombre = defineNombre();
    const edad = defineEdad();

    return new Player(nombre, edad);
}

/**
 * Inicia el juego y configura la primera ronda.
 * 
 * Esta función establece los valores por defecto, solicita al jugador que defina el número
 * máximo de rondas mediante la función `defineRondasMaximas`, oculta el botón de inicio e
 * inicia la primera ronda del juego llamando a la función `rondaJuego`.
 */

function init() {
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

/**
 * Actualiza un párrafo que contiene los datos del usuario.
 */

function datosUsuario() {
    const parrafoUser = document.getElementById('datosJugador');
    parrafoUser.innerHTML = nuevoJugador.toString();
}

// VARIABLES Y CONSTANTES GLOBALES
const colores = ['rojo', 'verde', 'azul', 'amarillo']; // Conjunto de colores disponibles en el juego.
let secuenciaCPU = []; // Almacena la secuencia de colores generada por la CPU.
let tiempoIluminacion = 0; // Tiempo en milisegundos que un botón de color permanece iluminado durante el juego.
let tiempoEntrePasos = 0; // Tiempo en milisegundos entre los pasos de iluminación de la secuencia de colores de la CPU.
let secuenciaPlayer = []; // Almacena la secuencia de colores ingresada por el usuario durante el juego.
let rondaActual = 0; // Número de la ronda actual en el juego.
let rondasMaximas = 0; // Número máximo de rondas que se jugarán en la partida.

// INICIO
const botonInicio = document.getElementById('botonInicio');
botonInicio.addEventListener('click', init);
const nuevoJugador = generaJugador();
datosUsuario();
actualizaParrafo('Pulsa el botón Inicio.');