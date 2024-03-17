import { MD5 } from './md5.js'; // Importa la función MD5 de md5.js

/**
 * Genera una tabla con la información del personaje.
 * @param character Personaje a imprimir.
 */
function generateTable(character) {
	showContainer();

	const sectionHeroes = document.getElementById('heroInfo');
	sectionHeroes.innerHTML = '';

	console.log(character);

	const parameters = {
		'Descripción': character.description ? character.description : 'No se conoce su descripción.',
		'Cómics': character.comics.available ? character.comics.available : 'Sin comics registrados.',
		'Series': character.series.available ? character.series.available : 'Sin series registradas.',
		'Eventos': character.events.available ? character.events.available : 'Sin eventos registrados.',
		'Historias': character.stories.available ? character.stories.available : 'Sin historias registradas.',
	};

	const table = document.createElement('table');
	sectionHeroes.appendChild(table);

	const trName = document.createElement('tr');
	table.appendChild(trName);

	const thName = document.createElement('th');
	thName.colSpan = 2;
	thName.innerHTML = character.name;
	trName.appendChild(thName);

	const trImg = document.createElement('tr');
	table.appendChild(trImg);

	const thImg = document.createElement('th');
	thImg.colSpan = 2;

	const img = document.createElement('img');
	img.src = `${character.thumbnail.path}.${character.thumbnail.extension}`;
	img.alt = `Foto de ${character.name}`;
	img.width = 300;
	thImg.appendChild(img);
	trImg.appendChild(thImg);

	for (const property in parameters) {
		const tr = document.createElement('tr');
		tr.classList.add('info-field');
		table.appendChild(tr);


		const th = document.createElement('th');
		th.innerHTML = property;
		tr.appendChild(th);

		const td = document.createElement('td');
		td.innerHTML = parameters[property];
		tr.appendChild(td);
	}
}

/**
 * Imprime la información del personaje.
 * @param id Identificador del personaje.
 */
function printHero(id) {
	showContainer();

	const queryParams = getQueryParams();

	const apiUrl = `${baseUrl}/${id}?${queryParams}`;

	fetch(apiUrl, options)
		.then(res => res.json())
		.then(data => generateTable(data.data.results[0]))
		.catch(() => getRandomCharacter());
}

/**
 * Elimina el mensaje de error.
 */
function removeError() {
	const pInfo = document.getElementById('pInfo');

	if (pInfo) {
		pInfo.remove();
	}
}

/**
 * Imprime un mensaje de error.
 * @param message Mensaje de error.
 */
function printError(message) {
	let pInfo = document.getElementById('pInfo');

	if (!pInfo) {
		pInfo = document.createElement('p');
		pInfo.id = 'pInfo';
		pInfo.classList.add('error');

		const btnSearch = document.getElementById('btnSubmit');
		btnSearch.after(pInfo);
	}

	pInfo.innerHTML = message;
}

/**
 * Crea una tarjeta con la información del personaje.
 * @param character Personaje a imprimir.
 * @returns {HTMLElement} Tarjeta con la información del personaje.
 */
function createCard(character) {
	const articleHeroe = document.createElement('article');
	articleHeroe.classList.add('character-card');

	const p = document.createElement('p');
	const img = document.createElement('img');

	p.innerText = character.name;
	img.id = `img-${character.id}`;
	img.src = `${character.thumbnail.path}.${character.thumbnail.extension}`;
	img.alt = `Imagen de ${character.name}`;
	img.width = 100;

	articleHeroe.appendChild(img);
	articleHeroe.appendChild(p);

	return articleHeroe;
}

/**
 * Imprime los personajes.
 * @param characters Personajes a imprimir.
 */
function printItems(characters) {
	showContainer();

	let heroListSection = document.getElementById('heroList');

	if (!heroListSection) {
		heroListSection = document.createElement('section');
		heroListSection.id = 'heroList';
		heroListSection.classList.add('heroList');
		heroListSection.addEventListener('click', getCharacterById);

		const heroInfo = document.getElementById('heroInfo');
		heroInfo.appendChild(heroListSection);
	}

	heroListSection.innerHTML = '';

	for (const character of characters) {
		const characterCard = createCard(character);
		heroListSection.appendChild(characterCard);
	}
}

/**
 * Verifica si los botones de navegación deben estar habilitados o deshabilitados.
 */
function checkButtons() {
	const btnPrev = document.getElementById('btnPrev');
	btnPrev.disabled = offset <= 0;

	const btnNext = document.getElementById('btnNext');
	btnNext.disabled = offset >= total - limit;
}

/**
 * Pasa a la página anterior.
 */
function prevPage() {
	offset -= limit;
	checkButtons();
	getCharacters();
}

/**
 * Pasa a la siguiente página.
 */
function nextPage() {
	offset += limit;
	checkButtons();
	getCharacters();
}

/**
 * Obtiene los parámetros de la búsqueda.
 * @returns {URLSearchParams} Parámetros de la búsqueda en formato URLSearchParams para ser usados en la URL.
 */
function getQueryParams() {
	const urlSearchParams = new URLSearchParams();
	urlSearchParams.set('apikey', publicKey);
	urlSearchParams.set('ts', timeStamp.toString());
	urlSearchParams.set('hash', hash);
	urlSearchParams.set('limit', limit.toString());
	urlSearchParams.set('offset', offset.toString());

	if (search) {
		urlSearchParams.set('nameStartsWith', search);
	}

	return urlSearchParams;
}

/**
 * Muestra el contenedor de información.
 */
function showContainer() {
	const heroContainer = document.getElementById('heroInfo');
	heroContainer.style.visibility = 'visible';
}

/**
 * Oculta el contenedor de información.
 */
function hideContainer() {
	const heroContainer = document.getElementById('heroInfo');
	heroContainer.style.visibility = 'hidden';
}

/**
 * Realiza la búsqueda de un personaje.
 * @param e Evento de click
 */
function searchCharacter(e) {
	e.preventDefault();
	offset = 0;

	const sectionHeroes = document.getElementById('heroInfo');
	sectionHeroes.innerHTML = '';

	search = document.getElementById('inputName').value;

	if (!search) {
		printError('Error: El campo de búsqueda no estar vacío.');
		hideContainer();
		return;
	}

	getCharacters();
}

/**
 * Obtiene los personajes.
 */
function getCharacters() {
	const queryParams = getQueryParams();

	const apiUrl = `${baseUrl}?${queryParams}`;

	fetch(apiUrl, options)
		.then(res => res.json())
		.then(data => {
			total = data.data.total;
			if (total === 0) {
				throw new Error(`No existen resultados de búsqueda para '${search}'.`);
			}

			removeError();

			if (total > limit) createButtons();

			printItems(data.data.results);
		})
		.catch(err => {
			printError(err);
			hideContainer();
		});
}

/**
 * Crea los botones de navegación.
 */
function createButtons() {
	let buttonContainer = document.getElementById('btnContainer');

	if (!buttonContainer) {
		buttonContainer = document.createElement('section');
		buttonContainer.id = 'btnContainer';

		const sectionHeroes = document.getElementById('heroInfo');

		sectionHeroes.appendChild(buttonContainer);

		const btnPrev = document.createElement('button');
		btnPrev.id = 'btnPrev';
		btnPrev.disabled = true;
		btnPrev.innerHTML = 'Anterior';
		btnPrev.addEventListener('click', prevPage);
		buttonContainer.appendChild(btnPrev);

		const btnNext = document.createElement('button');
		btnNext.id = 'btnNext';
		btnNext.innerHTML = 'Siguiente';
		btnNext.addEventListener('click', nextPage);
		buttonContainer.appendChild(btnNext);
	}
}

/**
 * Obtiene todos los personajes.
 */
function getAllCharacters() {
	const sectionHeroes = document.getElementById('heroInfo');
	sectionHeroes.innerHTML = '';
	search = '';
	offset = 0;
	getCharacters();
}

/**
 * Obtiene el personaje al que se le dio click.
 * @param e Evento de click
 */
function getCharacterById(e) {
	const target = e.target.localName;

	if (target === 'img') {
		const heroId = e.target.id.split('-')[1];
		printHero(heroId);
	}
}

/**
 * Obtiene un personaje aleatorio.
 */
function getRandomCharacter() {
	search = '';
	const minId = 1010666;
	const maxId = 1011500;

	const randomId = Math.floor(Math.random() * (maxId - minId + 1)) + minId;
	printHero(randomId);
}

/**
 * Agrega los eventos a los botones.
 */
function addEventListeners() {
	const btnSubmit = document.getElementById('btnSubmit');
	btnSubmit.addEventListener('click', searchCharacter);

	const btnRandom = document.getElementById('btnRandom');
	btnRandom.addEventListener('click', getRandomCharacter);

	const btnList = document.getElementById('btnList');
	btnList.addEventListener('click', getAllCharacters);
}

/**
 * Inicializa la aplicación
 */
function init() {
	addEventListeners();
}

window.addEventListener('DOMContentLoaded', init);

const baseUrl = 'https://gateway.marvel.com/v1/public/characters'; // URL base de la API
const publicKey = '9b2b45462012afe69d4794de8a2c2e52'; // Llave pública
const privateKey = '0a24e5b83191d9cbb0e4984e26affa7554fa7a27'; // Llave privada
const timeStamp = new Date().getTime(); // Marca de tiempo
const hash = MD5(`${timeStamp}${privateKey}${publicKey}`); // Hash

const options = { // Opciones para la petición
	method: 'GET',
	headers: {
		'Content-Type': 'application/json',
	},
};

let search = ''; // Búsqueda
let offset = 0; // Desplazamiento
let limit = 8; // Límite de resultados
let total = 0; // Total de resultados