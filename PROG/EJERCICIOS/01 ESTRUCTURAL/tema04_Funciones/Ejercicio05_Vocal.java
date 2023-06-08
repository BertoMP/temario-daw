package tema04_Funciones.actividades;

import java.util.Scanner;
//Desarrollar un programa que tenga una funcion que determine si un caracter introducido por teclado es una vocal.
public class Ejercicio05_Vocal {
	/********************************************************************************************
	 * 																							*
	 * Funcion para determinar si un caracter es una vocal										*
	 * @param chrLetra --> caracter introducido por el usuario									*
	 * @return blnVocal --> respuesta de la funcion tras comprobar si el caracter es vocal.		*
	 * 						True/False en funcion de si la letra es o no vocal.					*
	 * 																							*
	 ********************************************************************************************/
	//La funcion sera boolean porque debe devolver T/F en funcion de si el caracter es vocal o no.
	public static boolean esVocal(char chrLetra) {
		boolean blnVocal;
		
		switch(chrLetra) {
		case 'a','e','i','o','u','A','E','I','O','U':
			blnVocal = true;
			break;
		default:
			blnVocal = false;
		}
		return blnVocal;
	}
	
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		
		char chrLetra;
		
		System.out.print("Introduzca un caracter: ");
		chrLetra = scEntrada.next().charAt(0);
		
		scEntrada.close();
		
		//Llamada a la funcion esVocal(), para imprimir el resultado es necesario un print.
		System.out.println("El caracter " + chrLetra + " es una vocal? " + esVocal(chrLetra));
	}
}