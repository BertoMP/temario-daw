package principal;
import clases.Profesor;
//Clase color el profesor pregunta a un alumno por un color entre (rojo, amarillo y verde)
	public class ClaseColor{
		public static void main(String[] args) {
			Profesor teacher = new Profesor();
			String color = teacher.preguntacolor();
			System.out.println("La respuesta recibida es:" + color);
		}	
	}	
