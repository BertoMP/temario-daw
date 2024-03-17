fetch('https://pokeapi.co/api/v2/pokemon/151')
	.then(res => res.json())
	.then(res => res.sprites.front_default)
	.then(res => fetch(res))
	.then(res => res.blob())
	.then(blob => document.getElementById('myImage').src = URL.createObjectURL(blob))
	.catch(err => console.log(err));