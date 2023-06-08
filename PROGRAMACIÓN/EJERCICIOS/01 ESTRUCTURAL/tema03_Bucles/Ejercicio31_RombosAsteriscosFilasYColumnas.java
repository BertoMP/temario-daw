package tema03_Bucles.actividades;

import java.util.Scanner;

public class Ejercicio31_RombosAsteriscosFilasYColumnas {
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);

		int intNumLado;
		int intFilasUsuario;
		int intColumnasUsuario;

		System.out.print("Introduzca tama�o del lado: ");
		intNumLado = scEntrada.nextInt();

		System.out.print("Introduzca filas: ");
		intFilasUsuario = scEntrada.nextInt();
		
		System.out.print("Introduzca columnas: ");
		intColumnasUsuario = scEntrada.nextInt();

		for(int intFila = 0; intFila < intFilasUsuario; intFila++) {
			for (int i = 0; i <= intNumLado - 1; i++) {
				System.out.println("");
				for (int intColumna = 0; intColumna < intColumnasUsuario; intColumna++) {
					for (int j = 0; j <= (intNumLado * 2) - 1; j++) {
						if ((j == intNumLado - 1 - i) || j == intNumLado - 1 + i) {
							System.out.print("*");
						} else {
							System.out.print(" ");
						}
					}
					System.out.print("\t");
				}
			}
			for (int i = (intNumLado - 2); i >= 0; i--) {
				System.out.println("");
				for (int intColumna = 0; intColumna < intColumnasUsuario; intColumna++) {
					for (int j = 0; j <= (intNumLado * 2) - 1; j++) {
						if ((j == intNumLado - 1 - i) || (j == intNumLado - 1 + i)) {
							System.out.print("*");
						} else {
							System.out.print(" ");
						}
					}
					System.out.print("\t");
				}
			}
			System.out.println("");
		}
	}
}
