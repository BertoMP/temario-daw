package tema04_Funciones.actividades;

import java.util.Scanner;
//Crear un programa que determine mediante funciones la cantidad de divisores primos que tiene un numero.
public class Ejercicio07_NumeroDivisoresPrimos {
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
	/************************************************************************************
	 * 																					*
	 * Funcion para determinar el numero de divisores primos							*
	 * @param intNumUsuario --> numero introducido por el usuario						*
	 * @return intContadorPrimos --> resultado que dara la funcion, numero de divisores	*
	 * 								 primos												*
	 * 																					*
	 ************************************************************************************/
	//La funcion debe ser int ya que debe devolver un valor de este tipo.
	public static int contadorPrimos(int intNumUsuario) {
		int intContadorPrimos = 0;
		
		for(int i = 2; i <= intNumUsuario; i++) {
			if(esPrimo(i) && intNumUsuario % i == 0) {
				intContadorPrimos++;
			}
		}
		
		return intContadorPrimos;
	}
	
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		
		int intNumUsuario;
		
		System.out.print("Introduzca un numero: ");
		intNumUsuario = scEntrada.nextInt();
		scEntrada.close();
		
		System.out.println("Divisores de " + intNumUsuario + ": " + contadorPrimos(intNumUsuario));

	}

}
