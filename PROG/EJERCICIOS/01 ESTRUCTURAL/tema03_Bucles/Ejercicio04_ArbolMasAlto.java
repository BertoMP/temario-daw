package tema03_Bucles.actividades;
import java.util.Scanner;
public class Ejercicio04_ArbolMasAlto {
	/************************************************************************************************************************
	 * 																														*
	 * Un centro de investigaci�n de la flora urbana necesita una aplicaci�n que muestre cu�l es �rbol m�s alto. 			*
	 * Para ello se introducir� por teclado la altura (en cent�metros) de cada �rbol (terminando la introduciendo 			*
	 * de datos cuando se utilice -1 como altura). Los �rboles se identifican mediante etiquetas con n�meros correlativos, 	*
	 * comenzando en 0. Dise�ar una aplicaci�n que resuelva el problema planteado.											*
	 * 																														*
	 ************************************************************************************************************************/
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		//DECLARACI�N DE VARIABLES
		int intAlturaArbol; //variable para guardar la altura del �rbol
		int intEtiquetaArbol = 0; //variable incremental para las etiquetas
		int intArbolMasAlto; //variable para guardar la altura del �rbol m�s alto
		int intEtiquetaArbolMasAlto; //variable para guardar la etiqueta del �rbol m�s alto
		
		//INTRODUCCI�N DEL PRIMER �RBOL
		System.out.print("�RBOL " + intEtiquetaArbol + ":"
					   + "\nAltura: ");
		intAlturaArbol = scEntrada.nextInt();
		
		intArbolMasAlto = intAlturaArbol; // al ser el primer �rbol ser� el m�s alto
		intEtiquetaArbolMasAlto = intEtiquetaArbol;
		
		//BUCLE (se elige while porque el bucle podr�a no iniciarse)
		while(intAlturaArbol != -1) {
			
			if(intAlturaArbol > intArbolMasAlto) { //condicional para valorar si el �rbol es m�s alto
				intArbolMasAlto = intAlturaArbol;
				intEtiquetaArbolMasAlto = intEtiquetaArbol;
			}
			
			intEtiquetaArbol++;
			
			//SOLICITUD DEL RESTO DE �RBOLES
			System.out.print("\n�RBOL " + intEtiquetaArbol + ":"
					 	   + "\nAltura (introducir -1 para finalizar programa): ");
			intAlturaArbol = scEntrada.nextInt();
		}
		
		//IMPRESI�N DE DATOS FINALES
		System.out.print("\nEl �rbol m�s alto de los introducidos es: "
					   + "\n\tETIQUETA: " + intEtiquetaArbolMasAlto
					   + "\n\tALTURA: " + intArbolMasAlto);
	}
}
