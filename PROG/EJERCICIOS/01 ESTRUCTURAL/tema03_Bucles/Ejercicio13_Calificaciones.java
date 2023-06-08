package tema03_Bucles.actividades;
import java.util.Scanner;
public class Ejercicio13_Calificaciones {
	/****************************************************************************************************************
	 * 																												*
	 * Dadas 6 notas, escribir la cantidad de alumnos aprobados, condicionados (nota igual a cuatro) y suspensos.	*
	 * 																												*
	 ****************************************************************************************************************/
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		
		//DECLARACI�N DE VARIABLES
		double intNotaAlumno; //variable para guardar las notas, como no se especifica notas enteras, se supone que pueden ser decimales, double
		int intContadorAprobados = 0; //variable contador para los aprobados
		int intContadorCondicionados = 0; //variable contador para los condicionados
		int intContadorSuspensos = 0; //variable contador para los suspensos
		
		//BUCLE (se elige for porque se conoce el inicio, el fin y la itinerancia)
		for (int i = 0; i < 6; i++) {
			
			//SOLICITUD DE DATOS
			System.out.print("Introduce nota del alumno " + (i+1) + ": ");
			intNotaAlumno = scEntrada.nextInt();
			
			if(intNotaAlumno >= 5) { //condicional para aprobados
				intContadorAprobados++;
					}else if(intNotaAlumno == 4) { //condicional para condicionados
						intContadorCondicionados++;
							}else { //resto de posibilidades (suspensos)
								intContadorSuspensos++;
							}
		}
		
		//IMPRESI�N DE RESULTADOS
		System.out.println("\nDATOS FINALES" 
						 + "\nAPROBADOS: " + intContadorAprobados 
						 + "\nCONDICIONADOS: " + intContadorCondicionados
						 + "\nSUSPENSOS: " + intContadorSuspensos);
	}
}
