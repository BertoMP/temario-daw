let URL = 'https://pokeapi.co/api/v2/pokemon';
const pokenames = [];

function printAllPokemon() {
	let count = 1;

	for (const pokemon of pokenames) {
		const p = document.createElement('p');
		p.innerHTML = `#${count} - ${pokemon}`;
		document.body.appendChild(p);

		count++;
	}
}

function getAllPokemon(URL) {
	return fetch(URL).then((res) => res.json());
}

function pushNames(pokemonResults) {
	for (const pokemon of pokemonResults) {
		pokenames.push(pokemon.name);
	}
}

function checkNext() {
	if (URL) fetchAllPokemon();
	else printAllPokemon();
}

function fetchAllPokemon() {
	getAllPokemon(URL)
		.then((res) => {
			pushNames(res.results);
			URL = res.next;
		})
		.then(() => checkNext())
		.catch((error) => console.error(`Error durante los fetch: ${error}`));
}

fetchAllPokemon();