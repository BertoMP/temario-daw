import { Persona } from './Persona.js';

/**
 * Clase que representa a un Profesor que hereda de la clase Persona.
 */
class Profesor extends Persona {
	/**
	 * Crea una instancia de la clase Profesor.
	 * @param {string} nombre - El nombre del profesor.
	 * @param {string} apellidos - Los apellidos del profesor.
	 * @param {number} edad - La edad del profesor.
	 * @param {string} postreFavorito - El postre favorito del profesor.
	 */
	constructor(nombre, apellidos, edad, postreFavorito) {
		super(nombre, apellidos, edad, postreFavorito);
	}
}

export { Profesor };
