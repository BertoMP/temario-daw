/**
 * Generar un script que realice las siguientes acciones:
 *  1. Realizar una serie de preguntas al usuario solicitando una respuesta 'verdadero'
 *     o 'falso' y almacenar sus respuestas.
 *  2. Comprobar si el usuario ha acertado la pregunta o no:
 *      - En el caso de acertar, usar una clase 'valida' que permita mediante CSS
 *        aplicar un color verde a la respuesta.
 *      - En el caso de fallar, usar una clase 'invalida' que permita mediante CSS
 *        aplicar un color rojo a la respuesta.
 *  3. Realizar un recuento de las respuestas acertadas y falladas.
 *      - Si hay más aciertos que fallos mostrar el mensaje 'OK'.
 *      - Si hay más fallos que aciertos mostrar el mensaje 'Tienes que seguir estudiando'.
 */

let preguntas = [ // Array con las preguntas a realizar.
    '¿La Tierra es el planeta más grande del sistema solar?',
    '¿El agua hierve a una temperatura de 100ºC?',
    '¿El sol gira alrededor de la Tierra?',
];

let respuestasUsuario = []; // Array que guarda las respuestas proprocionadas por el usuario.
let respuestasCorrectas = ['falso', 'verdadero', 'falso']; // Array que almacena las respuestas correctas.
let contadorAciertos = 0; // Variable que funciona como contador de aciertos.
let contadorFallos = 0; // Variable que funciona como contador de fallos.
let media = preguntas.length / 2; // Variable que guarda la media a partir de la cual se aprueba o no la prueba.

// Inicio de las preguntas al usuario.
alert('Responde verdadero o falso a las siguientes preguntas');
for(let pregunta of preguntas) {
    respuestasUsuario.push(prompt(pregunta).toLowerCase());
}

// Construcción del HTML con las respuestas del usuario, informándole de aciertos y fallos en sus respuestas.
for(let intCont = 0; intCont < respuestasUsuario.length; intCont++) {
    let elementoPregunta = document.createElement('p');
    elementoPregunta.innerHTML = `Pregunta ${intCont + 1} => ${preguntas[intCont]}`;
    document.body.appendChild(elementoPregunta);

    let elementoRespuesta = document.createElement('p');

    if(respuestasUsuario[intCont] === respuestasCorrectas[intCont]) {
        elementoRespuesta.innerHTML = `Tu respuesta => ${respuestasUsuario[intCont]} (Correcto)`;
        elementoRespuesta.classList.add('valida');
        contadorAciertos++;
    } else {
        elementoRespuesta.innerHTML = `Tu respuesta => ${respuestasUsuario[intCont]} (Incorrecto)`;
        elementoRespuesta.classList.add('invalida');
        contadorFallos++;
    }

    document.body.appendChild(elementoRespuesta);
}

// Creación y agregación de un elemento <p> informando del resultado final de la prueba.
let elementoResultado = document.createElement('p');
elementoResultado.innerHTML = (contadorAciertos > media) ? 'Resultado: OK.' : 'Resultado: Tienes que estudiar más.';
document.body.appendChild(elementoResultado);