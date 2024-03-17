fetch('http://10.224.34.231:3000/fruit')
	.then(res => res.json())
	.then(res => console.log(res));