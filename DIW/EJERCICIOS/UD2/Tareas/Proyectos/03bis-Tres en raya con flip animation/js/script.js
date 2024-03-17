function reiniciaPartida() {
	location.reload();
}

function generaBotonReinicio() {
	const botonReinicio = document.createElement('div');
	botonReinicio.innerHTML = 'Nueva partida';
	document.body.appendChild(botonReinicio);

	botonReinicio.addEventListener('click', reiniciaPartida);
}

function generaParrafoFinal(empate, simboloGanador) {
	const parrafoFinal = document.createElement('p');
    
	if (empate) {
		parrafoFinal.innerHTML = 'Hay un empate.';
	} else {
		parrafoFinal.innerHTML = `Gana el jugador con la ficha ${simboloGanador}.`;
	}

	document.body.appendChild(parrafoFinal);
}

function eliminaEventoEscucha() {
	tablero.removeEventListener('click', eligeCelda);
}

function cambiaJugador() {
	jugadorActual = (jugadorActual === 'X') ? 'O' : 'X';
}

function finDelJuego(empate, simboloGanador) {
	eliminaEventoEscucha();
	generaParrafoFinal(empate, simboloGanador);
	generaBotonReinicio();
}

function hayEmpate() {
	for (const celda of celdas) {
		if (celda.textContent === '') {
			return false;
		}
	}
	return true;
}

function hayVictoria(simboloJugador) {
	const situacionesVictoria = [
		[0, 1, 2],
		[3, 4, 5],
		[6, 7, 8],
		[0, 3, 6],
		[1, 4, 7],
		[2, 5, 8],
		[0, 4, 8],
		[2, 4, 6],
	];

	for (const situacion of situacionesVictoria) {
		if(situacion.every(indice => celdas[indice].innerText === simboloJugador)) {
			return true;
		}
	}

	return false;
}

function cambiaCasilla(nodo) {
	const back = nodo.nextElementSibling;
	back.innerHTML = jugadorActual;

	nodo.classList.add('volteadoFrontal');
	back.classList.add('volteadoTrasero');

	const rutaImagen = (jugadorActual === 'X') ? './images/x.png' : './images/o.png';
	const imagen = document.createElement('img');
	imagen.setAttribute('src', rutaImagen);
	imagen.setAttribute('alt', `Simbolo del jugador ${jugadorActual}`);

	back.appendChild(imagen);
}

function eligeCelda(evento) {
	console.log(evento);
	if (evento.target.localName === 'div' && evento.target.innerHTML === '') {
		cambiaCasilla(evento.target);
		if (hayVictoria(jugadorActual)) {
			finDelJuego(false, jugadorActual);
		} else if (hayEmpate()) {
			finDelJuego(true);
		} else {
			cambiaJugador();
		}
	}

	return;
}

const tablero = document.getElementById('tableroJuego');
tablero.addEventListener('click', eligeCelda);

const celdas = document.querySelectorAll('div.back');

let jugadorActual = 'X';