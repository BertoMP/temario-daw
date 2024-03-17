/**
 * Clase que representa a una persona.
 */
class Persona {
	#_nombre; // Nombre de la persona.
	#_apellidos; // Apellidos de la persona.
	#_edad; // Edad de la persona.
	#_postreFavorito; // Postre favorito de la persona.

	/**
	 * Crea una instancia de la clase Persona.
	 * @param {string} nombre - El nombre de la persona.
	 * @param {string} apellidos - Los apellidos de la persona.
	 * @param {number} edad - La edad de la persona.
	 * @param {string} postreFavorito - El postre favorito de la persona.
	 */
	constructor(nombre, apellidos, edad, postreFavorito) {
		this.#_nombre = nombre;
		this.#_apellidos = apellidos;
		this.#_edad = edad;
		this.#_postreFavorito = postreFavorito;
	}

	/**
	 * Obtiene el nombre de la persona.
	 * @returns {string} - El nombre de la persona.
	 */
	get nombre() {
		return this.#_nombre;
	}
	/**
	 * Obtiene los apellidos de la persona.
	 * @returns {string} - Los apellidos de la persona.
	 */
	get apellidos() {
		return this.#_apellidos;
	}

	/**
	 * Obtiene la edad de la persona.
	 * @returns {number} - La edad de la persona.
	 */
	get edad() {
		return this.#_edad;
	}

	/**
	 * Obtiene el postre favorito de la persona.
	 * @returns {string} - El postre favorito de la persona.
	 */
	get postreFavorito() {
		return this.#_postreFavorito;
	}
}

export { Persona };