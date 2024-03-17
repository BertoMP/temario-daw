const myNamePromise = new Promise((resolve, reject) => {
	const name = 'Alberto'

	setTimeout(
		() => resolve(name),
		5000
	);
});

myNamePromise
	.then((name) => console.log(`El nombre es ${name}.`));