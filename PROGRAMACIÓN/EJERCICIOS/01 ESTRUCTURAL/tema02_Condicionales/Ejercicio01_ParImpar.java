package tema02_Condicionales.actividades;
import java.util.Scanner;

/********************************************************************************************
 * 																							*
 * Diseñar una aplicación que solicite al usuario un número e indique si es	par o impar.	*																*
 * 																							*
 ********************************************************************************************/

public class Ejercicio01_ParImpar {
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in); //creación de un Scanner.
		int intNumUsuario; //variable para introducir números.
	
		System.out.print("Introduzca un número: "); //solicitud de datos al usuario.
		intNumUsuario = scEntrada.nextInt();
		
		if (intNumUsuario % 2 == 0) { //condicional doble para decidir si el número es par o impar.
			System.out.println("El número " + intNumUsuario + " es un número par.");
		} else {
			System.out.println("El número " + intNumUsuario + " es un número impar.");
		}
	}
}
