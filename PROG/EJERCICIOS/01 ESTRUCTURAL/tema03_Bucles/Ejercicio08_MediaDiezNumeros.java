package tema03_Bucles.actividades;
import java.util.Scanner;
public class Ejercicio08_MediaDiezNumeros {
	/****************************************************************
	 * 																*
	 * Pedir diez n�meros enteros por teclado y mostrar la media.	*
	 *																*
	 ****************************************************************/	
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		//DECLARACI�N DE VARIABLES
		int intNumUsuario; //variable para guardar los n�meros del usuario
		int intSumaNumeros = 0; //variable para guardar la suma de los n�meros del usuario
		double rlnMediaNumeros; //variable para guardar la media
		
		//BUCLE (se elige el for porque se sabe el inicio, el fin y la itinerancia)
		for (int i = 1; i <= 10; i++) {
			//SOLICITUD DE DATOS
			System.out.print("Introduzca el " + i + "� n�mero: ");
			intNumUsuario = scEntrada.nextInt();
			
			intSumaNumeros += intNumUsuario; //suma de los n�meros, es igual que intSumaNumeros = intSumaNumeros + intNumUsuario
		}
		
		rlnMediaNumeros = intSumaNumeros / 10; //c�lculo de la media.
		
		//IMPRESI�N DE RESULTADOS
		System.out.print("La media es: " + rlnMediaNumeros + ".");
	}
}