package tema03_Bucles.actividades;
import java.util.Scanner;
public class Ejercicio33_HexaADecimal {
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		
		String strNumUsuario;
		boolean blnNumeroValido = true;
		String strCaracteresHexa = "0123456789ABCDEF";
		int intDigitoHexa = 0;
		boolean blnDigitoHexaEncontrado;
	
		int intExponente = 0;
		int intPotencia;
		int intNumDecimal = 0;
		
		do {
			System.out.print("Introduzca un n�mero hexadecimal: ");
			strNumUsuario = scEntrada.nextLine();
			
			for(int i = 0; i < strNumUsuario.length() && !blnNumeroValido; i++) {
				if(!strNumUsuario.matches("[0-9a-fA-F]")) {
					blnNumeroValido = false;
				}
			}
		}while (!blnNumeroValido);
		strNumUsuario = strNumUsuario.toUpperCase();
		
		for(int i = strNumUsuario.length() - 1; i >= 0; i--) {
			blnDigitoHexaEncontrado = false;
			for(int j = 0; j <= 15 && !blnDigitoHexaEncontrado; j++) {
				for(int k = 0; k <= 0; k++) {
					if(strNumUsuario.charAt(i) == strCaracteresHexa.charAt(j)) {
						intDigitoHexa = j;
						blnDigitoHexaEncontrado = true;
					}
				}
			}
			intPotencia = (int) (Math.pow(16, intExponente) * intDigitoHexa);
			intNumDecimal += intPotencia;
			intExponente++;
		}
		System.out.println("El n�mero hexadecimal " + strNumUsuario + " es el decimal " + intNumDecimal + ".");	
	}
}