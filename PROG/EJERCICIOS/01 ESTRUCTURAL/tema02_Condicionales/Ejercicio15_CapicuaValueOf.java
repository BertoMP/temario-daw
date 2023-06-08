package tema02_Condicionales.actividades;

import java.util.Scanner;

public class Ejercicio15_CapicuaValueOf {
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		int intNum;
		String strNum;
		boolean blnCapicua = false;

		System.out.print("Introduzca n�mero: ");
		intNum = scEntrada.nextInt();

		strNum = String.valueOf(intNum);

		if (intNum > 0 && intNum < 10000) {
			if (intNum < 10) {
				blnCapicua = true;
				} else if (intNum < 100) {
					if (strNum.charAt(0) == strNum.charAt(1)) {
						blnCapicua = true;
					}
					} else if (intNum < 1000) {
						if (strNum.charAt(0) == strNum.charAt(2)) {
							blnCapicua = true;
						}
						} else if (intNum < 10000) {
							if ((strNum.charAt(0) == strNum.charAt(3)) && (strNum.charAt(1) == strNum.charAt(2))) {
								blnCapicua = true;
							}
						}
			if (blnCapicua) {
				System.out.println("El n�mero " + intNum + " es capic�a.");
			} else {
				System.out.println("El n�mero " + intNum + " no es capic�a.");
			}
		} else {
			System.out.println("El n�mero est� fuera de rango.");
		}
	}
}