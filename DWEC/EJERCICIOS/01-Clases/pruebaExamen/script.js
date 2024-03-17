function printError(error) {
	const div = document.getElementById('resultado');
	div.innerHTML = error;
}

function transformData(data) {
	const formattedData = {
		nombre: 'NOMBRE',
		pais: 'PAÍS',
		titulos_constructores: 'TÍTULOS DE CONSTRUCTORES',
		pilotos_destacados: 'PILOTOS DESTACADOS',
		id: 'ID',
		equipo: 'EQUIPO',
		numero: 'NÚMERO',
		nacionalidad: 'NACIONALIDAD',
	}

	return formattedData[data];
}

function arrayToString(array) {
	let result = '';
	let cont = 0;


	for (const element of array) {
		result += element;
		cont++;
		if (cont < array.length) {
			result += ' y ';
		}
	}

	return result;
}

function createTable(data) {
	const table = document.createElement('table');

	const headers = Object.keys(data);

	for (const attribute in data) {
		let value = data[attribute];

		console.log(value, typeof value);

		if (typeof value === 'object') {
			value = arrayToString(value);
		}

		const tr = document.createElement('tr');
		const th = document.createElement('td');
		const td = document.createElement('td');
		th.innerHTML = transformData(attribute);
		td.innerHTML = value;
		tr.appendChild(th);
		tr.appendChild(td);
		table.appendChild(tr);
	}

	return table;
}

function printData(data, searchValue) {
	const div = document.getElementById('resultado');
	div.innerHTML = '';

	for (const datum of data) {
		if (datum.nombre === searchValue) {
			div.appendChild(createTable(datum));
			return;
		}
	}

	div.innerHTML = 'No encontrado';
}

function checkValue(value) {
	const regex = new RegExp('^([A-Z][a-z]+)(\\s[A-Z][a-z]+)?$');

	return regex.test(value);
}


function search() {
	const checkBox = document.getElementById('buscarPilotos');
	const searchValue = document.getElementById('cajaBusqueda').value;

	if (!searchValue) {
		printError('No se ha introducido un valor');
		return;
	}

	if (!checkValue(searchValue)) {
		printError('El valor introducido no es válido');
		return;
	}

	let url = 'http://localhost:3000/escuderias';

	if (checkBox.checked) {
		url = 'http://localhost:3000/pilotos';
	}

	fetch(url)
		.then(response => response.json())
		.then(data => printData(data, searchValue))
		.catch(error => {
			console.error('Error:', error);
		});

}

function createButton(id, text, onClick) {
	const btn = document.createElement('button');
	btn.id = id;
	btn.innerHTML = text;
	btn.addEventListener('click', onClick);

	const div = document.getElementById('resultado');
	div.before(btn);
}

function init() {
	createButton('btnSubmit', 'Buscar', search);
}

window.addEventListener('DOMContentLoaded', init);