package tema02_Condicionales.actividades;

/********************************************************************
 * 																	*
 * Pedir dos n�meros y mostrarlos oredenados de forma decreciente.	*
 * 																	*
 ********************************************************************/
import java.util.Scanner;
public class Ejercicio05_OrdenDecrecienteDosNumerosTernario {
	public static void main(String[] args) {
		int intNum1Usuario, intNum2Usuario, mayor, menor;
		Scanner scEntrada = new Scanner(System.in);
		
		System.out.print("Introduzca un n�mero: ");
		intNum1Usuario = scEntrada.nextInt();
		System.out.print("Introduzca otro n�mero: ");
		intNum2Usuario = scEntrada.nextInt();
		
		mayor = (intNum1Usuario > intNum2Usuario) ? intNum1Usuario : intNum2Usuario;
		menor = (intNum1Usuario < intNum2Usuario) ? intNum1Usuario : intNum2Usuario;
		
		System.out.println("El orden decreciente de los n�meros es: " + mayor + ", " + menor + ".");
	}
}