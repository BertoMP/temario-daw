package tema02_Condicionales.actividades;

import java.util.Scanner;
public class Ejercicio16_LetraDniCharAt {
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		int intNumDni; //variable para guardar el numero de DNI del usuario
		int intResto; //variable para guardar el resto de la operacion intNumDNI MOD 23
		String strLetrasDni = "TRWAGMYFPDXBNJZSQVHLCKE"; //variable para guardar todas las letras posibles.
		char chrLetra = ' '; //variable para guardar la letra correspondiente
		
		
		System.out.print("Introduzca n�mero del DNI: ");
		intNumDni = scEntrada.nextInt();
		
		intResto = intNumDni % 23;
		
		chrLetra = strLetrasDni.charAt(intResto); /* Un string es un array (""conjunto"") de chars por lo que si selecciono el char (hueco)
		 											 de strLetrasDNI correspondiente al resto, conseguir� la letra correspondiente. */
		
		System.out.println("DNI completo: " + intNumDni + "-" + chrLetra + ".");
	}
}
