package tema03_Bucles.actividades;
import java.util.Scanner;
public class Ejercicio09_TablaDeMultiplicar1Numero {
	/********************************************************************************************************************
	 * 																													*
	 * Implementar una aplicaci�n que pida al usuario un n�mero comprendido entre 1 y 10. Hay que mostrar la tabla de	*
	 * multiplicar de dicho n�mero, asegur�ndose de que el n�mero introducido se encuentra en el rango establecido.		*
	 * 																													*
	 ********************************************************************************************************************/
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		
		//DECLARACI�N DE VARIABLES
		int intNumUsuario; //variable para guardar la tabla que quiere el usuario
		
		//SOLICITUD DE DATOS
		System.out.print("Introduzca un n�mero del 1 al 10: ");
		intNumUsuario = scEntrada.nextInt();
		
		/*BUCLE (se elige while para que se active en caso de que se introduzca un n�mero mayor de 10 o menor de 1 y que
		  pregunte hasta que se introduzca un n�mero correcto */
		while ((intNumUsuario < 1 ) || (intNumUsuario > 10)) {
			System.out.println("\nERROR. Ha introducido un "
							 + "valor incorrecto.");
			System.out.print("Introduzca un n�mero del 1 al 10: ");
			intNumUsuario = scEntrada.nextInt();
		}
		//IMPRESI�N DE RESULTADOS 1
		System.out.println("\nTABLA DEL " + intNumUsuario);
		//BUCLE (se elige for porque se conoce principio, final e itinerancia)
		for (int i = 1; i <= 10; i++) {
			int intMultiplicacion = intNumUsuario * i;
			//IMPRESI�N DE RESULTADOS 2 (por cada iteraci�n har� una impresi�n 1X1=1, 1X2=2, 1X3=3...)
			System.out.println("\t" + intNumUsuario + " X " + i +
							   " = " + intMultiplicacion);
		}
	}
}