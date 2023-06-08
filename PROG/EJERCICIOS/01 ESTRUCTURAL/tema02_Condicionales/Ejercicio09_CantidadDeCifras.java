package tema02_Condicionales.actividades;

/************************************************************************************************
 * 																								*
 * Escribir una aplicaci�n que indique cu�ntas cifras tiene un n�mero entero introducido por	* 
 * teclado, que estar� comprendido entre 0 y 99999.												*
 *																								*
 ************************************************************************************************/
import java.util.Scanner;
public class Ejercicio09_CantidadDeCifras {
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		int intNum;
		
		System.out.print("Introduzca un n�mero: ");
		intNum = scEntrada.nextInt();
		
		if(intNum < 10) {
			System.out.println("El n�mero tiene 1 cifra.");
			}else if(intNum < 100) {
				System.out.println("El n�mero tiene 2 cifra.");
				}else if(intNum < 1000) {
					System.out.println("El n�mero tiene 3 cifra.");
					}else if(intNum < 10000) {
						System.out.println("El n�mero tiene 4 cifra.");
						}else if(intNum < 100000) {
							System.out.println("El n�mero tiene 5 cifra.");
						}
	}
}
