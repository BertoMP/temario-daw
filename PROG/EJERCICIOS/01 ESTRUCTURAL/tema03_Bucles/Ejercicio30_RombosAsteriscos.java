package tema03_Bucles.actividades;

import java.util.Scanner;

public class Ejercicio30_RombosAsteriscos {
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);

		int intNumLado;

		System.out.print("Introduzca tamaño del lado: ");
		intNumLado = scEntrada.nextInt();
		
		for (int i = 0; i <= intNumLado - 1; i++) {
			System.out.println();
			for (int j = 0; j <= (intNumLado * 2) - 1; j++) {
				if ((j == intNumLado - 1 - i) || j == intNumLado - 1 + i) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
		}
		for (int i = (intNumLado - 2); i >= 0; i--) {
			System.out.println();
			for(int j = 0; j <= (intNumLado * 2) - 1; j++) {
				if ((j == intNumLado - 1 - i) || (j == intNumLado - 1 + i)) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
		}
	}
}