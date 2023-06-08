package tema03_Bucles.actividades;
import java.util.Scanner;
public class Ejercicio12_AlumnosSuspensos {
	/********************************************************************************
	 * 																				*
	 * Pedir 5 calificaciones de alumnos y decir al final si hay alg�n suspenso		*
	 * 																				*
	 ********************************************************************************/
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		
		//DECLARACI�N DE VARIABLES
		double intNotaAlumno; //variable para guardar las notas, no habla de notas enteras, as� que se supone que pueden entrar decimales por eso, double
		boolean blnSuspensos = false; //variable que actuar� como bandera para decir si hay suspensos o no
		String strSuspensos; //variable String para guardar el mensaje final del operador ternario
		
		//BUCLE (se elige for porque se conoce inicio, fin, itinerancia y condiciones de rotura del bucle
		for (int i = 1; i <= 5; i++) {
			System.out.print("Introduce la nota del alumno " + i + ": ");
			intNotaAlumno = scEntrada.nextDouble();
			if(intNotaAlumno < 5) { //condicional para que si se introduce un suspenso, la bandera pase a true
				blnSuspensos = true;
			}
		}
		
		strSuspensos = (blnSuspensos) ? "Hay suspensos." : "No hay suspensos."; //operador ternario para la respuesta final en funci�n de si hay o no suspensos
		
		//IMPRESI�N DE DATOS FINALES
		System.out.print("\n" + strSuspensos);
	}
}