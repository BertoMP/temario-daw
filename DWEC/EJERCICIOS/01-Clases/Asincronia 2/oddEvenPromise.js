let number = 5;

let promise = new Promise((resolve, reject) => {
	number % 2 === 0 ? resolve('Es par') : reject('Es impar');
});

promise
	.then(data => console.log(data))
	.catch(error => console.log(error));

function oddEven() {
	const number = prompt('¿Cuál es tu número?');

	return new Promise((resolve, reject) => number % 2 === 0
		? resolve('Es par')
		: reject('Es impar'));
}

oddEven()
	.then(data => console.log(data))
	.catch(error => console.log(error));