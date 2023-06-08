package tema04_Funciones.actividades;

import java.util.Scanner;

//Crear un programa que decida el numero mayor. La funcion debe devolver el numero mayor.
public class Ejercicio04_NumeroMayor {

	/************************************************************************************
	 * 																					*
	 * Funcion para decidir el numero que es mayor de dos introducidos por consola.		*
	 * @param intNum1 --> primer numero del usuario										*
	 * @param intNum2 --> segundo numero del usuario									*
	 * @return intNumMayor --> se devolvera el numero mayor de los dos utilizados		*
	 * 																					*
	 ************************************************************************************/
	//La funcion sera int porque debe devolver el numero mayor.
	public static int numeroMayor(int intNum1, int intNum2) {
		int intNumMayor = (intNum1 > intNum2) ? intNum1 : intNum2;
		
		return intNumMayor;
	}
	
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		
		int intNum1;
		int intNum2;
		int intNumMayor;
		
		System.out.print("Introduzca el primer número: ");
		intNum1 = scEntrada.nextInt();
		
		System.out.println("Introduzca el segundo número: ");
		intNum2 = scEntrada.nextInt();
		
		scEntrada.close();

		intNumMayor = numeroMayor(intNum1, intNum2);

		System.out.print("El número mayor es: " + intNumMayor);

	}

}
