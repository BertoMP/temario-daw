package tema02_Condicionales.actividades;

/****************************************************************************************************************
 * En una granja se compra diariamente una cantidad (comidaDiaria) de comida para los animales. El n�mero de	*
 * animales que alimentar (todos de la misma especie) es numAnmales, y sabemos que cada animal come una			*
 * media kilosPorAnimal. Dise�a un programa que solicite al usuario los valores anteriores y determine si		*
 * disponemos de alimento suficiente para cada animal. En caso negativo, ha de calcular cu�l es la raci�n que	*
 * corresponde a cada uno de los animales.																		*
 * Nota: Evitar que la aplicaci�n realice divisiones por cero. 													*
 *																												*
 ****************************************************************************************************************/

import java.util.Scanner;
public class Ejercicio17_Granja {
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		double rlnComidaDiaria; //variable para guardar la comida que se ha comprado
		int intNumAnimales; //variable para guardar el numero de animales
		double rlnKilosPorAnimal; //variable para guardar el numero de kilos que come cada animal
		double rlnComidaNecesaria; //variable para guardar la cantidad de comida que se necesita
		
		System.out.print("Introduzca cantidad de comida comprada: ");
		rlnComidaDiaria = scEntrada.nextDouble();
		System.out.print("Introduzca cantidad de animales: ");
		intNumAnimales = scEntrada.nextInt();
		System.out.print("Introduzca kilos de comida que come cada animal: ");
		rlnKilosPorAnimal = scEntrada.nextDouble();
		
		
		if(intNumAnimales == 0) { //para evitar division entre 0, si el numero de animales es 0 se lanzar� un error.
			System.out.println("\nERROR. No puede haber 0 animales.");
		}else {
			rlnComidaNecesaria = rlnKilosPorAnimal * intNumAnimales; //calculo para conocer la comida necesaria
			if (rlnComidaNecesaria > rlnComidaDiaria) { //si la comida necesaria es superior a la comprada habra que hacer un reparto
				rlnKilosPorAnimal = rlnComidaDiaria / intNumAnimales;
				System.out.println("\nNo hay comida suficiente en el almac�n. Dar " + rlnKilosPorAnimal + "kg a cada animal.");
			}else {
				System.out.println("\nHay comida suficiente en el almac�n. Dar raciones normales (" + rlnKilosPorAnimal + ") a cada animal.");
			}
		}
	}
}
