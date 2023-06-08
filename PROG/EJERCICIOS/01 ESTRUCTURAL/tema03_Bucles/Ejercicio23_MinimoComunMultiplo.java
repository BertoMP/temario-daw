package tema03_Bucles.actividades;

import java.util.Scanner;

public class Ejercicio23_MinimoComunMultiplo {

	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		int intNumUsuario1;
		int intNumUsuario1Inicial;
		int intNumUsuario2;
		int intNumUsuario2Inicial;
		int intResultado = 0;

		System.out.print("Dame un n�mero: ");
		intNumUsuario1 = scEntrada.nextInt();
		intNumUsuario1Inicial = intNumUsuario1;

		do {
			System.out.print("Dame un segundo n�mero (debe ser mayor que el anterior): ");
			intNumUsuario2 = scEntrada.nextInt();
			intNumUsuario2Inicial = intNumUsuario2;
		} while (intNumUsuario2 < intNumUsuario1);

		for(int i = intNumUsuario2; (i % intNumUsuario1 != 0) || (i % intNumUsuario2 != 0); i++) {
			intResultado = i;
		}

		System.out.print("El m�nimo com�n multiplo de " + intNumUsuario1Inicial + " y " + intNumUsuario2Inicial + " es: "
				+ (intResultado+1));
	}

}
