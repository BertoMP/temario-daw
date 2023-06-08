package tema02_Condicionales.actividades;
/********************************************************************************************
 * 																							*
 * Pedir los coeficientes de una ecuaci�n de segundo grado y mostrar sus soluciones reales.	* 
 * Si no existen, habra que indicarlo. Hay que tener en cuenta que las soluciones de una 	*
 * ecuaci�n de segundo grado ax2+bx+c=0 son: x=(-b+-raiz(b2-4ac))/2a						*
 *																							*
 ********************************************************************************************/

import java.util.Scanner;
import java.util.Locale;
public class Ejercicio08_EcuacionSegundoGrado {

	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		scEntrada.useLocale(Locale.US);
		
		double rlnNumA, rlnNumB, rlnNumC; //variables utilizadas para guardar los datos aportados por el usuario.
		double rlnSolucionUnica, rlnSolucion1, rlnSolucion2, rlnDiscriminante; /*variables para los diferentes c�lculos necesarios:
																					- Si el discriminante es negativo, la ecuaci�n no tendr�
																					  soluciones reales.
																					- Si el discriminante es 0, la ecuaci�n no ser� de
																					  segundo grado.
																					- Si el discriminante es positivo, la ecuaci�n ser� de
																					  segundo grado y tendr� 2 soluciones. */
		
		System.out.print("Introduzca coeficiente A: ");
		rlnNumA = scEntrada.nextDouble();
		System.out.print("Introduzca coeficiente B: ");
		rlnNumB = scEntrada.nextDouble();
		System.out.print("Introduzca coeficiente C: ");
		rlnNumC = scEntrada.nextDouble();
		
		//Calcular el discriminante
		rlnDiscriminante = Math.pow(rlnNumB, 2) - (4 * rlnNumA * rlnNumC);
		
		System.out.println("\nEl discriminante es: " + rlnDiscriminante);
		
		//Soluciones
		if(rlnDiscriminante < 0) {
			System.out.println("\nDiscrimiante negativo." +
							   "\nNo existen soluciones reales.");
		} else {
			if (rlnDiscriminante == 0) {
				rlnSolucionUnica = (-rlnNumB / (2 * rlnNumA));
				System.out.println("\nDiscrminante 0." + 
								   "\nNo es una ecuaci�n de segundo grado. Y s�lo tiene una soluci�n:" +
								   "\n\tSoluci�n: " + rlnSolucionUnica);
			} else {
				rlnSolucion1 = ((-rlnNumB + Math.sqrt(rlnDiscriminante)) / (2 * rlnNumA));
				rlnSolucion2 = ((-rlnNumB - Math.sqrt(rlnDiscriminante)) / (2 * rlnNumA));
				System.out.println("\nDiscriminante positivo."
								  +"\nEs una ecuaci�n de segundo grado y sus soluciones son: " 
								  +"\n\tSoluci�n 1: " + rlnSolucion1 + "." 
								  +"\n\tSoluci�n 2: " + rlnSolucion2 + ".");
			}
		}
	}
}
