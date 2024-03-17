/**
 * Array que contiene preguntas y respuestas para determinar la casa de Hogwarts
 * a la que pertenecería una persona.
 *
 * @type {Array<Object>}
 *
 * @property {string} question			La pregunta relacionada con las preferencias o decisiones.
 *
 * @property {Array<Object>} answers	Un arreglo de opciones de respuesta, cada una con un texto,
 *                                      la casa correspondiente, y la cantidad de puntos asociados.
 *
 * @property {string} answers.text		El texto de la respuesta.
 *
 * @property {string} answers.house		La casa de Hogwarts asociada a la respuesta.
 *
 * @property {number} answers.points	La cantidad de puntos asociados a la respuesta.
 */
const questions = [
	{
		question: '¿Qué tipo de actividad disfrutas más?',
		answers: [
			{
				text: 'Planear estratégicamente una tarea',
				house: 'Slytherin',
				points: 4
			},
			{
				text: 'Leer un buen libro',
				house: 'Ravenclaw',
				points: 1
			},
			{
				text: 'Ayudar a otros en sus tareas',
				house: 'Hufflepuff',
				points: 3
			},
			{
				text: 'Realizar un deporte o actividad física',
				house: 'Gryffindor',
				points: 2
			}
		]
	},
	{
		question: '¿Qué cualidad valoras más en un compañero?',
		answers: [
			{
				text: 'Valentía y coraje',
				house: 'Gryffindor',
				points: 3
			},
			{
				text: 'Lealtad y honestidad',
				house: 'Hufflepuff',
				points: 1
			},
			{
				text: 'Inteligencia y sabiduría',
				house: 'Ravenclaw',
				points: 2
			},
			{
				text: 'Ambición y determinación',
				house: 'Slytherin',
				points: 4
			}
		]
	},
	{
		question: '¿Cómo prefieres resolver un problema?',
		answers: [
			{
				text: 'Enfocándote en la estrategia más eficiente',
				house: 'Slytherin',
				points: 1
			},
			{
				text: 'Investigando y aprendiendo sobre el problema',
				house: 'Ravenclaw',
				points: 3
			},
			{
				text: 'Actuando rápidamente para resolverlo',
				house: 'Gryffindor',
				points: 4
			},
			{
				text: 'Trabajando en equipo para encontrar una solución',
				house: 'Hufflepuff',
				points: 2
			}
		]
	},
	{
		question: '¿Qué te motiva más en la vida?',
		answers: [
			{
				text: 'Aprender y buscar conocimiento constantemente',
				house: 'Ravenclaw',
				points: 3
			},
			{
				text: 'Lograr tus metas y objetivos',
				house: 'Slytherin',
				points: 4
			},
			{
				text: 'Ayudar y ser útil a los demás',
				house: 'Hufflepuff',
				points: 1
			},
			{
				text: 'Defender tus principios y valores',
				house: 'Gryffindor',
				points: 2
			}
		]
	},
	{
		question: '¿Qué tipo de ambiente te hace sentir más cómodo?',
		answers: [
			{
				text: 'Estar rodeado de naturaleza',
				house: 'Hufflepuff',
				points: 3
			},
			{
				text: 'Estar en un entorno emocionante y lleno de acción',
				house: 'Gryffindor',
				points: 1
			},
			{
				text: 'Estar en un entorno competitivo y desafiante',
				house: 'Slytherin',
				points: 2
			},
			{
				text: 'Estar en un entorno intelectualmente estimulante',
				house: 'Ravenclaw',
				points: 4
			}
		]
	},
	{
		question: '¿Qué cualidad te identifica más a la hora de tomar decisiones importantes?',
		answers: [
			{
				text: 'Tu intuición y empatía hacia los demás',
				house: 'Hufflepuff',
				points: 1
			},
			{
				text: 'Tu valentía y coraje para enfrentar desafíos',
				house: 'Gryffindor',
				points: 3
			},
			{
				text: 'Tu lógica y razonamiento',
				house: 'Ravenclaw',
				points: 2
			},
			{
				text: 'Tu determinación y enfoque en tus objetivos',
				house: 'Slytherin',
				points: 4
			},
		]
	},
	{
		question: '¿Cómo sueles enfrentarte a situaciones desconocidas?',
		answers: [
			{
				text: 'Desarrollando estrategias para afrontar lo desconocido',
				house: 'Slytherin',
				points: 2
			},
			{
				text: 'Manteniendo la calma y adaptándote al cambio',
				house: 'Hufflepuff',
				points: 4
			},
			{
				text: 'Actuando con valentía y enfrentando lo desconocido directamente',
				house: 'Gryffindor',
				points: 3
			},
			{
				text: 'Investigando y buscando información relevante',
				house: 'Ravenclaw',
				points: 1
			}
		]
	},
	{
		question: '¿Qué actividad te relaja más?',
		answers: [
			{
				text: 'Resolver acertijos o puzzles',
				house: 'Slytherin',
				points: 3
			},
			{
				text: 'Hacer ejercicio intenso',
				house: 'Gryffindor',
				points: 4
			},
			{
				text: 'Meditar o practicar yoga',
				house: 'Hufflepuff',
				points: 1
			},
			{
				text: 'Pintar o dibujar',
				house: 'Ravenclaw',
				points: 2
			},

		]
	},
	{
		question: '¿Cuál es tu clima preferido?',
		answers: [
			{
				text: 'Día soleado y cálido',
				house: 'Gryffindor',
				points: 1
			},
			{
				text: 'Noche fresca y estrellada',
				house: 'Ravenclaw',
				points: 4
			},
			{
				text: 'Tarde lluviosa y tranquila',
				house: 'Hufflepuff',
				points: 2
			},
			{
				text: 'Mañana neblinosa y misteriosa',
				house: 'Slytherin',
				points: 3
			}
		]
	},
	{
		question: '¿Cuál será tu asignatura favorita en Hogwarts?',
		answers: [
			{
				text: 'Adivinación',
				house: 'Ravenclaw',
				points: 4
			},
			{
				text: 'Defensa Contra las Artes Oscuras',
				house: 'Gryffindor',
				points: 1
			},
			{
				text: 'Herbología',
				house: 'Hufflepuff',
				points: 3
			},
			{
				text: 'Pociones',
				house: 'Slytherin',
				points: 2
			},
		]
	}
];

export { questions };