const boton = document.getElementById('boton1');
boton.addEventListener('click', function(evento){
    const miParrafo = document.getElementById('pregunta1');
    miParrafo.classList.add('correcta');
});