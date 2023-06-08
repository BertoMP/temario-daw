package tema04_Funciones.actividades;

import java.util.Scanner;
/*
 * Crear una aplicación que mediante una funcion eco() imprima por consola un número n de ecos.
 * N es introducido por el usuario.
 * 
 */
public class Ejercicio01_Eco {

	/********************************************************************************************
	 * 																							*
	 * Funcion para la impresion de n "eco".													*
	 * @param intRepeticiones --> Indica el número de ecos que se han de imprimir por pantalla.	*
	 * 																							*
	 ********************************************************************************************/
	//La funcion es void porque no va a devolver ningun valor, va a realizar la impresion directamente.
	public static void repeticionesEco (int intRepeticiones){
		/*Al conocer tanto el inicio (1) como el fin (intRepeticiones) de iteraciones del bucle
		  se elige un bucle for para realizar los ciclos. */
		for(int i = 1; i <= intRepeticiones; i++) {
			System.out.println("Eco " + i);
		}
	}
	
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		
		int intNumEcos;
		
		System.out.print("Introduzca número de repeticiones: ");
		intNumEcos = scEntrada.nextInt();
		
		scEntrada.close();
		
		/*Llamada a la funcion eco() a la que se le asigna un parametro de entrada intNumEcos que es
		  fijado por el usuario mediante consola. */
		repeticionesEco(intNumEcos);

	}

}
