// Fetch es una api para gestionar comunicaciones con el servidor
// Por ejemplo, traer datos de una API.
let miDevolucion = fetch('https://swapi.dev/api/people/1');

// Los resultados deben ser trabajados en un tipo de dato que conozca JS.
miDevolucion
	.then((res) => {
		console.log(res);
		return res;
	})
	.then((res) => res.json())
	.then((res) => {
		console.log(res);
		console.log(`El nombre es: ${res.name}.`);
		console.log(`Su altura es: ${res.height}cm.`);
	})
	.catch((err) => console.error(err));