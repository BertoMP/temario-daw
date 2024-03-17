/**
 * Crea un nuevo elemento o actualiza un elemento existente en el DOM según su ID.
 * @param {string} id - ID del elemento.
 * @param {string} elementType - Tipo de elemento a crear (p, img, section, etc.).
 * @param {string} idContainer - ID del contenedor en el que se debe agregar el elemento.
 * @param {Object} attributes - Atributos para establecer en el elemento (por ejemplo, {innerHTML: 'texto'}).
 * @param {string} elementClass - Clase CSS a aplicar al elemento.
 */
function createOrUpdateElementById(id, elementType, idContainer, attributes = undefined, elementClass = undefined) {
	let element = document.getElementById(id);
	const container = document.getElementById(idContainer);

	if (!element) {
		element = document.createElement(elementType);
		element.id = id;
		container.appendChild(element);
	}

	for (const attribute in attributes) {
		element[attribute] = attributes[attribute];
	}

	if (elementClass) {
		element.setAttribute('class', elementClass);
	}
}

/**
 * Elimina elementos del DOM según sus IDs.
 * @param {...string} elementIDs - IDs de los elementos a eliminar.
 */
function deleteElementById(...elementIDs) {
	for (const id of elementIDs) {
		const element = document.getElementById(id);
		if (element) element.remove();
	}
}

/**
 * Imprime las imágenes del Pokémon en el DOM.
 * @param {Object} sprites - Objeto que contiene las URLs de las imágenes del Pokémon.
 */
function printSprites(sprites) {
	createOrUpdateElementById('sectionImg', 'section', 'main');
	createOrUpdateElementById('imgNormal', 'img', 'sectionImg', { src: sprites.front_default });
	createOrUpdateElementById('imgShiny', 'img', 'sectionImg', { src: sprites.front_shiny });
}

/**
 * Imprime un mensaje de error y elimina otros elementos del DOM.
 * @param {string} errorMessage - Mensaje de error a imprimir.
 */
function printError(errorMessage) {
	deleteElementById('pInfo', 'pType', 'pDesc', 'imgNormal', 'imgShiny');
	createOrUpdateElementById('pError', 'p', 'main',
		{ innerHTML: errorMessage }, 'error');
}

/**
 * Traduce un tipo de Pokémon de inglés a español.
 * @param {string} type - Tipo de Pokémon en inglés.
 * @returns {string} - Tipo de Pokémon traducido al español.
 */
function translateTypeToSpanish(type) {
	const typeToSpanish = {
		'normal': 'normal',
		'fighting': 'lucha',
		'flying': 'volador',
		'poison': 'veneno',
		'ground': 'tierra',
		'rock': 'roca',
		'bug': 'bicho',
		'ghost': 'fantasma',
		'steel': 'acero',
		'fire': 'fuego',
		'water': 'agua',
		'grass': 'planta',
		'electric': 'eléctrico',
		'psychic': 'psíquico',
		'ice': 'hielo',
		'dragon': 'dragón',
		'dark': 'siniestro',
		'fairy': 'hada',
	};

	return typeToSpanish[type];
}

/**
 * Imprime los tipos del Pokémon en español.
 * @param {Array} types - Lista de tipos del Pokémon.
 */
function printTypes(types) {
	let stringTypes = types.length === 1
		? 'Su tipo es: '
		: 'Sus tipos son: ';

	for (let intCont = 0; intCont < types.length; intCont++) {
		stringTypes += translateTypeToSpanish(types[intCont].type.name);

		if (intCont < types.length - 1) {
			stringTypes += ' y ';
		}
	}

	stringTypes += '.';

	createOrUpdateElementById('pType', 'p', 'main', { innerHTML: stringTypes });
}

/**
 * Obtiene y muestra la descripción del Pokémon en español.
 * @param {number} pokemonId - Número de la Pokédex del Pokémon.
 */
function getDescription(pokemonId) {
	const url = `https://pokeapi.co/api/v2/pokemon-species/${pokemonId}`;

	fetch(url)
		.then((res) => {
			if (!res.ok) {
				return;
			}
			return res.json();
		})
		.then((res) => {
			const descriptions = res.flavor_text_entries;

			for (const description of descriptions) {
				if (description.language.name === 'es') {
					return description.flavor_text;
				}
			}
		}).then((res) => createOrUpdateElementById('pDesc', 'p', 'main',
			{
				innerHTML: res
					? `"${res}"`
					: 'No hay descripción en la base de datos.'
			}, 'description'));
}

/**
 * Obtiene la información de un Pokémon según su nombre o número de Pokédex.
 * @param {string} pokeValueSearch - Nombre o número de Pokédex del Pokémon a buscar.
 */
function getPokemon(pokeValueSearch) {
	const isNameSearch = isNaN(pokeValueSearch);
	const url = isNameSearch
		? `https://pokeapi.co/api/v2/pokemon/${pokeValueSearch.toLowerCase()}`
		: `https://pokeapi.co/api/v2/pokemon/${pokeValueSearch}`;

	fetch(url)
		.then((res) => {
			if (!res.ok) {
				const errorMessage = isNameSearch
					? `El pokémon con nombre '${pokeValueSearch}' no existe.`
					: `El pokémon con número de pokédex '${pokeValueSearch}' no existe.`;
				throw new Error(errorMessage);
			}
			return res.json();
		})
		.then((res) => {
			deleteElementById('pError');
			printSprites(res.sprites);
			return res;
		})
		.then((res) => {
			const message = isNameSearch
				? `Número de la Pokédex Nacional: #${res.id}.`
				: `Nombre del Pokémon: ${res.name.slice(0, 1).toUpperCase()}${res.name.slice(1,)}.`;
			createOrUpdateElementById('pInfo', 'p', 'main', { innerHTML: message });
			return res;
		})
		.then((res) => {
			printTypes(res.types);
			return res;
		})
		.then((res) => getDescription(res.id))
		.catch((err) => printError(err));
}

/**
 * Manejador de eventos para la búsqueda de Pokémon.
 * @param {Event} e - Objeto de evento del clic en el botón de búsqueda.
 */
function searchPokemon(e) {
	e.preventDefault();

	const pokeSearch = document.getElementById('searchPoke').value;

	if (!pokeSearch) {
		printError('El campo de búsqueda no puede estar vacío.');
		return;
	}

	getPokemon(pokeSearch);
}

/**
 * Inicializa la aplicación configurando los escuchadores de eventos.
 */
function init() {
	const btnSearch = document.getElementById('btn-search');
	btnSearch.addEventListener('click', searchPokemon);
}

/**
 * Escuchador de eventos para el evento 'DOMContentLoaded'.
 * Inicia la aplicación cuando el DOM se ha cargado completamente.
 */
window.addEventListener('DOMContentLoaded', init);