class Casa {
	#_nombre;
	#_fortaleza;
	#_rutaImagen;

	constructor(nombre, fortaleza, ruta) {
		this.#_nombre = nombre;
		this.#_fortaleza = fortaleza;
		this.#_rutaImagen = ruta;
	}

	getNombre = () => this.#_nombre;
	getFortaleza = () => this.#_fortaleza;
	getRutaImagen = () => this.#_rutaImagen;
}

function generaImagen(casa) {
	const imagen = document.createElement('img');
	const ruta = casasGot[casa].getRutaImagen();
	imagen.setAttribute('src', ruta);
	imagen.setAttribute('alt', `Foto de la fortaleza ${casasGot[casa].getFortaleza()}`);

	return imagen;
}

function generaParrafo(casa) {
	const parrafo = document.createElement('p');
	parrafo.innerHTML = `Has elegido la casa ${casasGot[casa].getNombre()} de ${casasGot[casa].getFortaleza()}.`;

	return parrafo;
}

function limpiaModal() {
	const contenedorPadre = document.getElementById('contenidoModal');
	let elementoHijo = contenedorPadre.querySelector(':nth-child(2)');

	while (elementoHijo) {
		contenedorPadre.removeChild(elementoHijo);
		elementoHijo = contenedorPadre.querySelector(':nth-child(2)');
	}
}

function construyeModal(casa) {
	limpiaModal();

	const contenidoModal = document.getElementById('contenidoModal');
    
	const parrafo = generaParrafo(casa);
	contenidoModal.appendChild(parrafo);

	const imagen = generaImagen(casa);
	contenidoModal.appendChild(imagen);

}

function muestraInfo(e) {
	const casaElegida = e.target.id.split('-')[1];

	construyeModal(casaElegida);
	ventanaModal.style.display = 'block';
}

function cambiaIcono() {    
	if (audioActivado) {
		botonAudio.classList.remove('fa-volume-high');
		botonAudio.classList.add('sonidoActivado');
		botonAudio.classList.add('fa-volume-xmark');
	} else {
		botonAudio.classList.remove('fa-volume-xmark');
		botonAudio.classList.add('fa-volume-high');
		botonAudio.classList.remove('sonidoActivado');
	}
}

function generaElementoAudio() {
	const elementoAudio = document.createElement('audio');
	elementoAudio.setAttribute('id', 'audio-got');
	elementoAudio.setAttribute('src','./audio/got-intro.mp3');
	elementoAudio.setAttribute('autoplay', true);
	elementoAudio.setAttribute('loop', true);

	return elementoAudio;
}

function controlaAudio() {
	const mainDocument = document.getElementsByTagName('main');
	const elementoAudio = document.getElementById('audio-got');

	if (elementoAudio) {
		mainDocument[0].removeChild(elementoAudio);
		audioActivado = false;
		cambiaIcono();
	} else {
		const elementoAudio = generaElementoAudio();

		mainDocument[0].appendChild(elementoAudio);
		audioActivado = true;
		cambiaIcono();
	}

	return;
}

let audioActivado = false;
const casasGot = {
	stark:      new Casa('Stark', 'Invernalia', './image/invernalia.webp'),
	lannister:  new Casa('Lannister', 'Roca Casterly', './image/rocaCasterly.webp'),
	targaryen:  new Casa('Targaryen', 'Rocadragón', './image/rocaDragon.webp'),
	baratheon:  new Casa('Baratheon', 'Bastión de Tormentas', './image/bastionDeTormentas.webp'),
	tyrell:     new Casa('Tyrell', 'Altojardín', './image/altoJardin.jpg'),
	martell:    new Casa('Martell', 'Lanza del Sol', './image/lanzaDelSol.jpg'),
	arryn:      new Casa('Arryn', 'Nido de Águilas', './image/nidoDeAguilas.webp'),
	tully:      new Casa('Tully', 'Aguasdulces', './image/aguasdulces.jpg'),
	greyjoy:    new Casa('Greyjoy', 'Pyke', './image/pyke.jpg'),
};

const seccionCasas = document.getElementById('casas');
seccionCasas.addEventListener('click', muestraInfo);

const botonAudio = document.getElementById('botonAudio');
botonAudio.addEventListener('click', controlaAudio);

const ventanaModal = document.getElementById('ventanaModal');

const cerrarModal = document.getElementById('cerrarModal');
cerrarModal.addEventListener('click', function() {
	ventanaModal.style.display = 'none';
});

window.addEventListener('click', function(event) {
	if(event.target.id === 'ventanaModal') {
		ventanaModal.style.display = 'none';
	}
});
