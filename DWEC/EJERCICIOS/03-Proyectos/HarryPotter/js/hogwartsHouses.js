/**
 * Objeto que contiene las casas de Hogwarts y su información asociada.
 *
 * @type {Object.<string, HogwartsHouse>}
 *
 * Cada uno de los objetos es a su vez un objeto que contiene la información
 * asociada a la casa:
 *
 *  @typedef {Object} HogwartsHouse
 *
 *  @property {string} background	La ruta de la imagen del fondo asociada a la casa.
 *
 *  @property {string[]} btnColor	Un arreglo con los colores para el botón representativo de la casa.
 *
 *  @property {string} logoPath		La ruta del logo de la casa.
 *
 *  @property {string} videoPath	La ruta del video representativo de la casa.
 *
 */
const hogwartsHouses = {
	'Gryffindor': {
		background: '../assets/images/gryffindor-room-min.jpg',
		btnColor: ['#740001', '#FFD700'],
		logoPath: '../assets/images/gryffindor-min.png',
		videoPath: '../assets/videos/gryffindor.mp4',
		password: 'caput draconis'
	},
	'Ravenclaw': {
		background: '../assets/images/ravenclaw-room-min.webp',
		btnColor: ['#000080', '#C0C0C0'],
		logoPath: '../assets/images/ravenclaw-min.png',
		videoPath: '../assets/videos/ravenclaw.mp4',
		password: 'alohomora'
	},
	'Hufflepuff': {
		background: '../assets/images/hufflepuff-room-min.png',
		btnColor: ['#FFD700', '#000000'],
		logoPath: '../assets/images/hufflepuff-min.png',
		videoPath: '../assets/videos/hufflepuff.mp4',
		password: 'helga'
	},
	'Slytherin': {
		background: '../assets/images/slytherin-room-min.webp',
		btnColor: ['#006400', '#1A472A'],
		logoPath: '../assets/images/slytherin-min.png',
		videoPath: '../assets/videos/slytherin.mp4',
		password: 'parsel'
	}
};

export { hogwartsHouses };