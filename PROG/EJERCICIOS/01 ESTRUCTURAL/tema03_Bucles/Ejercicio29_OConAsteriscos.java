package tema03_Bucles.actividades;

import java.util.Scanner;

public class Ejercicio29_OConAsteriscos {
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);

		int intNumLado;

		System.out.print("Introduzca tama�o del lado: ");
		intNumLado = scEntrada.nextInt();
		
		for (int i = 1; i <= intNumLado + 2; i++) {
			for (int j = 1; j <= intNumLado + 2; j++) {
				if (i == 1 || i == intNumLado + 2) {
					if (j == 1 || j == intNumLado + 2) {
						System.out.print("  ");
					} else {
						System.out.print("* ");
					}
				}else {
					if(j == 1 || j == intNumLado + 2) {
						System.out.print("* ");
					}else {
						System.out.print("  ");
					}
				}
			}
			System.out.println(" ");
		}

	}
}