/**
 * Clase que representa a una persona con nombre y edad.
 */
class Persona {
	#_nombre; // El nombre de la persona.
	#_edad; // La edad de la persona.

	/**
	 * Crea una instancia de Persona.
	 * @param {string} nombre - El nombre de la persona.
	 * @param {number} edad - La edad de la persona.
	 */
	constructor(nombre, edad) {
		this.#_nombre = nombre;
		this.#_edad = edad;
	}

	/**
	 * Obtiene el nombre de la persona.
	 * @returns {string} El nombre de la persona.
	 */
	get nombre() {
		return this.#_nombre;
	}

	/**
	 * Obtiene la edad de la persona.
	 * @returns {number} La edad de la persona.
	 */
	get edad() {
		return this.#_edad;
	}
}

export { Persona };
