package tema04_Funciones.actividades;

import java.util.Scanner;

//Crear una aplicacion que tenga una funcion que determine con un booleano si un numero es primo o no.

public class Ejercicio06_Primo {
	/************************************************************************************
	 * 																					*
	 * Funcion para determinar si un numero es primo o no								*
	 * @param intNumUsuario --> numero introducido por el usuario						*
	 * @return blnPrimo --> resultado que dara la funcion, true/false en funcion de si	*
	 * 						el numero es primo o no.									*
	 * 																					*
	 ************************************************************************************/
	//La funcion debe ser booolean ya que debe devolver un valor de este tipo.
	public static boolean esPrimo(int intNumUsuario) {
		boolean blnPrimo = true;
		
		if(intNumUsuario == 0 || intNumUsuario == 1 || intNumUsuario == 4) {
			blnPrimo = false;
		}
		
		for(int i = 2; i < intNumUsuario / 2 && blnPrimo; i++) {
			if(intNumUsuario % i == 0) {
				blnPrimo = false;
			}
		}
		return blnPrimo;
	}
	
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		
		int intNumUsuario;
		
		System.out.print("Introduzca un numero: ");
		intNumUsuario = scEntrada.nextInt();
		
		scEntrada.close();
		
		System.out.println("El numero " + intNumUsuario + " es primo? " + esPrimo(intNumUsuario));
	}
}