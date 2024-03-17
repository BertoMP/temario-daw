import { Persona } from './persona.model.js';

/**
 * Clase que representa a un Alumno que hereda de la clase Persona.
 */
class Alumno extends Persona {
	// ATRIBUTOS
	#_asignaturaFavorita; // Asignatura favorita del alumno.

	/**
	 * Crea una instancia de la clase Alumno.
	 * @param {string} nombre - El nombre del alumno.
	 * @param {string} apellidos - Los apellidos del alumno.
	 * @param {number} edad - La edad del alumno.
	 * @param {string} postreFavorito - El postre favorito del alumno.
	 * @param {string} asignaturaFavorita - La asignatura favorita del alumno.
	 */
	constructor(nombre, apellidos, edad, postreFavorito, asignaturaFavorita) {
		super(nombre, apellidos, edad, postreFavorito);
		this.#_asignaturaFavorita = asignaturaFavorita;
	}

	/**
	 * Obtiene la asignatura favorita del alumno.
	 * @returns {string} - La asignatura favorita del alumno.
	 */
	get asignaturaFavorita() {
		return this.#_asignaturaFavorita;
	}
}

export { Alumno };
