package tema03_Bucles.actividades;
import java.util.Scanner;
public class Ejercicio02_EdadesAlumnos {
	/****************************************************************************************************************************
	 * 																															*
	 * Implementar una aplicaci�n para calcular datos estad�sticos de las edades de los alumnos de un centro educativo.			*	
	 * SE introducir�n datos hasta que uno de ellos sea negativo, y se mostrar�: la suma de todas las edades introducidas,		*
	 * la media, el n�mero de alumnos y cu�ntos son mayores de edad.															*
	 * 																															* 
	 ****************************************************************************************************************************/
	public static void main(String[] args) {
		//DECLARACI�N VARIABLES
		int intEdadAlumno; //variable para guardar la edad del alumno
		int intSumaTotalEdades = 0; //variable para guardar la suma de todas las edades
		int intContadorMayoresDeEdad = 0; //variable contador de mayores de edad
		int intContadorAlumnos = 0; //variable contador de n�mero de alumnos
		double rlnEdadMedia; //variable para guardar la edad media
		
		//SOLICITUD DE PRIMERA EDAD
		System.out.print("Introduzca edad del alumno: ");
		intEdadAlumno = new Scanner (System.in).nextInt();
		
		//BUCLE (se elige while ya que es posible que la primera introducci�n sea negativa)
		while(intEdadAlumno >= 0) {
			intSumaTotalEdades += intEdadAlumno; /*esto es igual que intSumaTotalEdades = intSumaTotalEdades + intEdadAlumno. Sirve para guardar la 
												   edad total de todos los alumnos. */	
			intContadorAlumnos++;
			
			if(intEdadAlumno >= 18) {
				intContadorMayoresDeEdad++;
			}
			
			//SOLICITUD DEL RESTO DE EDADES EN LAS ITERACIONES
			System.out.print("Introduzca edad del alumno (si es negativa, se realizar� el procesado de datos): ");
			intEdadAlumno = new Scanner (System.in).nextInt();	
		}
		
		rlnEdadMedia = intSumaTotalEdades / intContadorAlumnos; //c�lculo de la edad media.
		
		//IMPRESI�N DE DATOS FINALES
		System.out.println("\nDATOS FINALES:"
						 + "\n\tEDAD TOTAL: " + intSumaTotalEdades + " a�os."
						 + "\n\tEDAD MEDIA: " + rlnEdadMedia + " a�os."
						 + "\n\tCANTIDAD DE ALUMNOS: " + intContadorAlumnos + " alumnos."
						 + "\n\tALUMNOS MAYORES DE EDAD: " + intContadorMayoresDeEdad + " alumnos.");
	}
}
