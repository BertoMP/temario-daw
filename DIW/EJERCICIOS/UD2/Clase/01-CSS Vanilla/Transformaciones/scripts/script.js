window.addEventListener('load', iniciar, false);

function iniciar() {
    let run = document.getElementById('miBoton');
    run.addEventListener('click', accRun, false);
}

function accRun() {
    let reloj = document.getElementById('miImagen');
    reloj.classList = 'animaReloj';
    reloj.addEventListener('animationend', accRun2, false);
}

function accRun2() {
    let reloj = document.getElementById('miImagen2');
    reloj.classList = 'animaReloj';
}
