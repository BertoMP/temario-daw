/**
 * La definición de clases se realiza a través de la palabra reservada class seguida
 * del nombre que tendrá la clase, dentro de esta clase tendremos los atributos y
 * métodos de la clase.
 *
 * Uno de estos métodos es el constructor, el cual es el primer método de la clase
 * y utiliza la palabra reservada "constructor" y puede recibir o no parámetros
 * por lo que su sintaxis es constructor([parámetros]). Este método se va a encargar
 * de inicializar los valores de los atributos que tiene cada instancia del objeto.
 *
 * Los cuatro pilares básicos de la programación orientada a objetos (POO) son:
 *
 *  - Abstracción. Consiste en determinar las características de un objeto. Por ejemplo,
 *    una clase Coche podría tener los atributos de "motor", "matricula" y "color" sus
 *    métodos podrían ser "arrancar()", "intermitente()" y "parar()".
 *
 *  - Encapsulación. Impide que puedas acceder de forma explícita a los atributos de un
 *    objeto sino que se hace a través de ciertos métodos. Por ejemplo, en el ejemplo
 *    anterior el atributo "motor" podría ser un objeto de tipo Motor que tenga sus
 *    propios atributos y métodos. Para privatizar un atributo usamos el #, por ejemplo,
 *    #motor. También podemos usar métodos privados utilizando el mismo caracter, por ejemplo,
 *    #arrancar().
 *
 *  - Herencia. Por ejemplo podemos tener una clase Alumno y una clase Profesor que
 *    tengan unas características comunes. En este caso sería interesante crear una
 *    superclase llamada Persona que tenga estas características comunes. Esto sería
 *    la herencia, es decir, los atributos (o métodos) que sean comunes entre dos o
 *    más clases es conveniente que se junten en una superclase y que las subclases
 *    hereden de esta.
 *
 *  - Polimorfismo. Cuando hacemos una herencia puede ser que queramos que un método
 *    funcione de una manera en un objeto y de una manera diferente en otro, por ejemplo,
 *    Alumno y Profesor pueden tener un método común heredado de persona que sea asistir()
 *    pero en Alumno la forma de asistir a clase es "recibir la clase" o "atender a la
 *    explicación" pero para un Profesor la implementación de asistir() sería, por ejemplo,
 *    "impartir la clase" o "realizar una explicación".
 *
 * Podríamos tener un quinto pilar que sería la recolección de basura que se va a encargar
 * de que los datos que se van a dejar de utilizar durante la ejecución del programa son
 * eliminados del sistema para liberar recursos.
 */

class Coche {
	#_motor;
	constructor(motor) {
		this.#_motor = motor;
	}

	arrancar() {
		return 'El coche arranca.';
	}

	intermitente() {
		return 'Se activa el intermitente.';
	}

	parar() {
		return 'El coche para.';
	}
}

class Persona {
	#_nombre;
	#_apellidos;
	#_edad;
	constructor(nombre, apellidos, edad) {
		this.#_nombre = nombre;
		this.#_apellidos = apellidos;
		this.#_edad = edad;
	}

	tuNombre() {
		return `${this.#_nombre} ${this.#_apellidos}}`; // Esto es lo mismo que "this.#_nombre + " " + this.#_apellidos"
	}

	asistir() {
		return 'La persona asiste a clase.';
	}
}

class Estudiante extends Persona {
	constructor(nombre, apellidos, edad) {
		super(nombre, apellidos, edad);
	}

	asistir() {
		return 'El estudiante recibe la clase impartida por el profesor.';
	}
}

class Profesor extends Persona {
	constructor(nombre, apellidos, edad) {
		super(nombre, apellidos, edad);
	}

	asistir() {
		return 'El profesor imparte la clase.';
	}
}

const personaUno = new Persona('Alberto', 'Martínez', 33);
const estudianteUno = new Estudiante('Juan', 'Sánchez', 18);
const profesorUno = new Profesor('Alicia', 'Giménez', 45);

console.log(personaUno.tuNombre());
console.log(personaUno.asistir());
console.log(estudianteUno.asistir());
console.log(profesorUno.asistir());
