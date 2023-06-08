package tema02_Condicionales.actividades;
import java.util.Scanner;
/****************************************************************
 * 																*
 * Escribe un programa que lea millas como valor double 		*
 * de la consola y lo convierta en km mostrando el resultado. 	*
 * La f�rmula para la conversi�n es: `1 milla = 1.6 km`			*
 *																*
 ****************************************************************/
public class Ejercicio25_MillasAKilometros {

	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		double rlnMillas;
		double rlnKilometros;
		
		System.out.print("Introduzca millas: ");
		rlnMillas = scEntrada.nextDouble();
		
		rlnKilometros = rlnMillas * 1.6;
		
		System.out.println(rlnMillas + " millas son un total de " + rlnKilometros + " kil�metros.");

	}

}
