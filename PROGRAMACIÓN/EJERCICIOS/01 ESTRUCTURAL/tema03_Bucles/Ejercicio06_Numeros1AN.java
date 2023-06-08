package tema03_Bucles.actividades;
import java.util.Scanner;
public class Ejercicio06_Numeros1AN {
	/********************************************************************************************************************
	 * 																													*
	 * Escribir una aplicaci�n para aprender a contar, que pedir� un n�mero n y mostrar� todos los n�meros del 1 a n.	*
	 * 																													*
	 ********************************************************************************************************************/
	public static void main(String[] args) {
		//DECLARACI�N DE VARIABLES
		int intCantidadNumeros;
		
		//SOLICITUD DE DATOS
		System.out.print("Introduzca cantidad de numeros a imprimir: ");
		intCantidadNumeros = new Scanner(System.in).nextInt();
		
		//BUCLE (se elige for porque se conoce el principio, el fin y la itinerancia)
		for (int i = 1; i <= intCantidadNumeros; i++) {
			//IMPRESI�N DE RESULTADOS
			System.out.print(i + " ");
		}
		
	}
}
