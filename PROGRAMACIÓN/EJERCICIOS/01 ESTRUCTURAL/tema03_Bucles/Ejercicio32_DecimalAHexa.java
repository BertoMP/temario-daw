package tema03_Bucles.actividades;
import java.util.Scanner;
public class Ejercicio32_DecimalAHexa {
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		
		int intNumUsuario;
		int intNumUsuarioInicial;
		int intResto;
		String strCaracteresHexa = "0123456789ABCDEF";
		char chrDecimalAHexa;
		String strNumeroHexa = "";
	
		do {
			System.out.print("Introduzca un n�mero decimal mayor de 0: ");
			intNumUsuario = scEntrada.nextInt();
			intNumUsuarioInicial = intNumUsuario;
		}while(intNumUsuario < 0);
		
		for(int i = 0; intNumUsuario !=0; i++) {
			intResto = intNumUsuario % 16;
			chrDecimalAHexa = strCaracteresHexa.charAt(intResto);
			strNumeroHexa = chrDecimalAHexa + strNumeroHexa;
			intNumUsuario /= 16;
		}
		System.out.println("El n�mero decimal " + intNumUsuarioInicial + " es el hexadecimal: " + strNumeroHexa + ".");
	}
}