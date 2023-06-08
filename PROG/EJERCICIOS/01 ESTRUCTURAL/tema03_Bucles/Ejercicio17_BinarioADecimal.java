package tema03_Bucles.actividades;

import java.util.Scanner;

public class Ejercicio17_BinarioADecimal {

	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		long lngNumUsuario;
		long lngNumUsuarioInicial;
		int intContadorExponente = 0;
		int intDigitoBinario;
		int intNumDecimal = 0;

		System.out.println("Introduzca un numero binario: ");
		lngNumUsuario = scEntrada.nextInt();
		lngNumUsuarioInicial = lngNumUsuario;

		for (int i = 0; lngNumUsuario > 0; i++) {
			intDigitoBinario = (int) lngNumUsuario % 10;
			intNumDecimal += (int) (intDigitoBinario * Math.pow(2, intContadorExponente));
			intContadorExponente++;
			lngNumUsuario /= 10;
		}
		System.out.println("El numero binario " + lngNumUsuarioInicial + " es el: " + intNumDecimal);
	}
}