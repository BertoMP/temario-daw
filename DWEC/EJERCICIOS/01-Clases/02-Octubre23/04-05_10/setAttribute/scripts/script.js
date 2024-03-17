let miImagen = document.getElementsByTagName('img');
miImagen[0].setAttribute('src', './image/croissant.jpg');

let miBoton = document.getElementById('miBoton');
miBoton.addEventListener('click', function() {
	console.log('Botón pulsado');
});