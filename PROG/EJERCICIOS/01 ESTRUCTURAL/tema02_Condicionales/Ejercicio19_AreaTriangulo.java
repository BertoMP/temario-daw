package tema02_Condicionales.actividades;
/********************************************************************************************************************
 * 																													*
 * Escribe una aplicacion que solicite por consola dos numeros reales que corresponden a la base y la altura de un	*
 * triangulo. Debera mostrarse su area. comprobando que los numeros introducidos por el usuario no son negativo,	* 
 * algo que no tendria sentido. 																					*
 *																													*
 ********************************************************************************************************************/
import java.util.Scanner;
public class Ejercicio19_AreaTriangulo {
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		double rlnBaseTriangulo, rlnAlturaTriangulo; //variables para las caracteristicas del triangulo
		double rlnAreaTriangulo; //variable para el calculo del area del triangulo
		
		System.out.print("Introduzca los datos del triangulo (si son decimales usar coma (,):" 
					   + "\n\tBase del triangulo: ");
		rlnBaseTriangulo = scEntrada.nextDouble();
		System.out.print("\n\tAltura del triangulo: ");
		rlnAlturaTriangulo = scEntrada.nextDouble();
		
		if(rlnBaseTriangulo <= 0 || rlnAlturaTriangulo <= 0) { /*si el triangulo tiene una caracteristica a 0 o negativa, es imposible que sea un
																 triangulo */	
			System.out.print("\nDatos erroneos. Altura o base del triangulo es igual a 0 o negativo.");
		} else {
			rlnAreaTriangulo = ((rlnBaseTriangulo * rlnAlturaTriangulo)) / 2; //calculo del area de un triangulo
			System.out.print("\nEl area del triangulo es: " + rlnAreaTriangulo + ".");
		}
	}
}
