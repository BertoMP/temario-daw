package tema04_Funciones.actividades;

import java.util.Scanner;
//Crear un programa que imprima los numeros comprendidos entre a y b. a y b son introducidos por usuario.
public class Ejercicio02_NumerosComprendidos {
	/************************************************************************
	 * 																		*
	 * Funcion para la impresion de n numeros comprendidos entre a y b.		*
	 * @param intNum1 --> Primer numero del usuario							*
	 * @param intNum2 --> Segundo numero del usuario						*
	 * 																		*
	 ************************************************************************/
	//La funcion sera void porque no devolvera ningun valor, realizara el proceso directamente.
	public static void numerosComprendidos (int intNum1, int intNum2) {
		int numMayor;
		int numMenor;
		
		//Ordenacion de los numeros
		numMayor = (intNum1 > intNum2) ? intNum1 : intNum2;
		numMenor = (intNum1 < intNum2) ? intNum1 : intNum2;
		
		//Como se conoce el inicio y el fin del bucle, se utiliza un for.
		for(int i = (numMenor + 1); i < numMayor; i++) {
			System.out.print(i + " ");
		}
	}
	
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		
		int intNum1;
		int intNum2;
		
		System.out.print("Introduzca el primer número: ");
		intNum1 = scEntrada.nextInt();
		
		System.out.print("Introduzca el segundo número: ");
		intNum2 = scEntrada.nextInt();
		
		scEntrada.close();
		
		/*Llamada a la funcion numerosComprendidos(). Los parametros de entrada seran los numeros introducidos
		  mediante el Scanner. */
		numerosComprendidos(intNum1, intNum2);

	}

}
