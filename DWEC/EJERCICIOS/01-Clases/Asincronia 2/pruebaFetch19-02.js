fetch('http://10.224.34.231:3000/pilotos')
	.then(res => res.json())
	.then(data => console.log(data))
	.catch(() => console.log('Error'));