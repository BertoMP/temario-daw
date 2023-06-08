package tema02_Condicionales.actividades;

/****************************************************************************
 * 																			*
 * Realizar de nuevo la tarea resuelta 2.3 considerando el caso de que los 	*
 * n�meros introducidos sean iguales.										*
 *																			*
 ****************************************************************************/
import java.util.Scanner;
public class Ejercicio06_NumeroMayorOIgual {
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		int intNum1Usuario, intNum2Usuario;
		
		System.out.print("Introduzca un n�mero: ");
		intNum1Usuario = scEntrada.nextInt();
		System.out.print("Introduzca un n�mero diferente al anterior: ");
		intNum2Usuario = scEntrada.nextInt();
		
		if (intNum1Usuario > intNum2Usuario) {
			System.out.println("El n�mero " + intNum1Usuario + " es mayor que el n�mero " + intNum2Usuario + ".");
		} else if (intNum1Usuario < intNum2Usuario) {
			System.out.println("El n�mero " + intNum2Usuario + " es mayor que el n�mero " + intNum1Usuario + ".");
		}	else {
				System.out.println("Los n�meros son iguales.");
			}
	}
}
