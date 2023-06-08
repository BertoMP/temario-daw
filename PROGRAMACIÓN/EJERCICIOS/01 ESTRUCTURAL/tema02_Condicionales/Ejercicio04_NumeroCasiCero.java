package tema02_Condicionales.actividades;

/****************************************************************************************
 * 																						*
 * Implementar un programa que pida por teclado un n�mero decimal e indique sei es un	*
 * n�mero casi-cero, que son aquellos, positivos o negativos, que se acercan a 0 por 	*
 * menos de 1 unidad, aunque curiesamente el 0 no se considera un n�mero casi-cero. 	*
 * Ejemplos de n�meros casi-cero son: el 0`3, el -0`99 o el 0`123; algunos n�meros que 	*
 * no se consideran casi-cero son: el 12`3, el 0 o el -1.								*
 * 																						*
 ****************************************************************************************/
import java.util.Scanner;
import java.util.Locale;
public class Ejercicio04_NumeroCasiCero {
	public static void main(String[] args) {
		double rlnNumUsuario; //variable para el n�mero del usuario
		Scanner scEntrada = new Scanner(System.in);
		scEntrada.useLocale(Locale.US); //para utilizar (.) con los decimales
		
		System.out.print("Introduzca un n�mero positivo o negativo (si es decimal, separar con punto (.): ");
		rlnNumUsuario = scEntrada.nextDouble();
		
		if((-1 < rlnNumUsuario) && (rlnNumUsuario < 1) && (rlnNumUsuario != 0)) {
			System.out.println("El n�mero " + rlnNumUsuario + " se considera un n�mero casi-cero.");
		}else {
			System.out.println("El n�mero " + rlnNumUsuario + " no se considera un n�mero casi-cero.");
		}
	}
}
