// let miForm = document.getElementById('paragraph');
//
// let misDatos = fetch('https://swapi.dev/people/1/')
// 	.then()
//
// miForm.addEventListener('click', (e) => { console.log('Hola') });

class Hijo {
	constructor() {
		this.nombre = 'Alejandro';
		this.apellidos = 'Marcos';
	}

	miNombre = () => {
		return this.nombre;
	};

	miNombre2 = function () {
		return this.nombre;
	};
}

let miHijo = new Hijo();

console.log(miHijo.miNombre());
console.log(miHijo.miNombre2());

let miObjeto = {
	nombre: 'Alberto',
	miCosa: () => {
		return this.nombre;
	}
};

const array = [1,2,3,4,5];

function myFunction() {
	array.forEach((indice) => console.log(array));
}

myFunction();
