package tema02_Condicionales.actividades;
import java.util.Scanner;

/****************************************************************
 * 																*
 * Solicitar dos n�meros distintos y mostrar cu�l es el mayor.	*
 * 																*
 ****************************************************************/

public class Ejercicio03_NumeroMayor {
	public static void main(String[] args) {	
		Scanner scEntrada = new Scanner(System.in);
		int intNum1Usuario, intNum2Usuario; //variables para la introducci�n de valores.
		
		System.out.print("Introduzca un n�mero: "); //petici�n de datos al usuario.
		intNum1Usuario = scEntrada.nextInt();
		System.out.print("Introduzca un n�mero diferente al anterior: ");
		intNum2Usuario = scEntrada.nextInt();
		
		if (intNum1Usuario > intNum2Usuario) { //condicional anidado para decidir resultado.
			System.out.println("El n�mero " + intNum1Usuario + " es mayor que el n�mero " + intNum2Usuario + ".");
		} else {
			System.out.println("El n�mero " + intNum2Usuario + " es mayor que el n�mero " + intNum1Usuario + ".");
		}
	}
}
