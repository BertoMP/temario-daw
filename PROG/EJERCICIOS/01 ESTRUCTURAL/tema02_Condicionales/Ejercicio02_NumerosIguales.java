package tema02_Condicionales.actividades;
import java.util.Scanner;

/************************************************************
 * 															*
 * Pedir dos n�meros enteros y decir si son iguales o no.	*
 * 															*
 ************************************************************/

public class Ejercicio02_NumerosIguales {
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in); //creaci�n de un Scanner.
		int intNum1Usuario, intNum2Usuario; //variables para la introducci�n de n�meros.
		
		System.out.print("Introduzca un n�mero: "); //solicitud de datos.
		intNum1Usuario = scEntrada.nextInt();
		System.out.print("Introduzca un segundo n�mero: ");
		intNum2Usuario = scEntrada.nextInt(); 
		
		if (intNum1Usuario == intNum2Usuario) {
			System.out.println("Los n�meros son iguales.");
		} else {
			System.out.println("Los n�meros son diferentes.");
		}
	}

}
