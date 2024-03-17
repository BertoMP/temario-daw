const myData = fetch('https://swapi.dev/api/people/8363')
	.then(data => data.text())
	.then(data => {
		console.log(data);
		return data;
	})
	.then(data => data.split(','))
	.then(data => {
		const myIndex = data[3];

		return new Promise((resolve, reject) => {
			if (myIndex !== undefined) resolve(myIndex);
			else reject('Ese índice no existe.');
		});
	})
	.then(data => console.log(data))
	.catch(error => console.log(error))
	.finally(() => console.log('Iteración'));


console.log(myData);