fetch('https://dbd.tricky.lol/api/characters')
	.then(res => res.json())
	.then(res => console.log(res['0']));