// PROMESAS
// Siguen una estructura fija
// Esperan una función que siempre va a tener dos parámetros, un resolve
// y un reject que son las dos soluciones de una promesa
const myPromise = new Promise((resolve, reject) => {
	let sum = 3 + 2;

	if (sum > 4) resolve(sum)
	else reject('No es mayor que 4');
});

myPromise
	.then((result) => {
		console.log(`El primer resultado es: ${result}`);
		return result + 7;
	})
	.then(function (result) {
		console.log(`El segundo resultado es: ${result}`);
	})
	.catch((error) => {console.log(error)})
	.finally(() => console.log('Iteración.'));

console.log('Sorpresa');