import { Persona } from './persona.model.js';
/**
 * Clase que representa a un jugador, heredando de la clase Persona.
 */
class Jugador extends Persona {
	#_nivelEntrenamiento; // Nivel que tiene el jugador.
	#_cantVictorias; // Cantidad de victorias del jugador.

	/**
	 * Crea una instancia de Jugador.
	 * @param {string} nombre - El nombre del jugador.
	 * @param {number} edad - La edad del jugador.
	 */
	constructor(nombre, edad) {
		super(nombre, edad);
		this.#_nivelEntrenamiento = 'Principiante';
		this.#_cantVictorias = 0;
	}

	/**
	 * Obtiene el nivel de entrenamiento del jugador.
	 * @returns {string} El nivel de entrenamiento del jugador.
	 */
	get nivelEntrenamiento() {
		return this.#_nivelEntrenamiento;
	}

	/**
	 * Obtiene el número de victorias del jugador.
	 * @returns {number} El número de del jugador.
	 */
	get cantVictorias() {
		return this.#_cantVictorias;
	}

	/**
	 * Establece el nivel de entrenamiento del jugador.
	 * @param {string} nuevoNivel - El nuevo nivel de entrenamiento.
	 */
	set nivelEntrenamiento(nuevoNivel) {
		this.#_nivelEntrenamiento = nuevoNivel;
	}

	/**
	 * Establece la cantidad de victorias del jugador.
	 * @param {number} nuevaCantidad - La nueva cantidad de victorias.
	 */
	set cantVictorias(nuevaCantidad) {
		this.#_cantVictorias = nuevaCantidad;
	}

	/**
	 * Aumenta la cantidad de victorias del jugador y ajusta su nivel de entrenamiento.
	 */
	aumentaVictoria() {
		this.#_cantVictorias++;
		this.#cambiaNivelEntrenamiento();
	}

	/**
	 * Método privado que cambia el nivel de entrenamiento del jugador basado en su cantidad de victorias.
	 * @private
	 */
	#cambiaNivelEntrenamiento() {
		switch (this.#_cantVictorias) {
			case 1:
			case 2:
			case 3:
				this.#_nivelEntrenamiento = 'Principiante';
				break;
			case 4:
			case 5:
			case 6:
			case 7:
				this.#_nivelEntrenamiento = 'Intermedio';
				break;
			default:
				this.#_nivelEntrenamiento = 'Experto';
		}
	}
}

export { Jugador };
