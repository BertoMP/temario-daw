package tema03_Bucles.actividades;
import java.util.Scanner;
public class Ejercicio16_DecimalABinario {

	public static void main(String[] args) {
		int intNumUsuario;
		int intNumUsuarioInicial;
		int intDigitoBinario;
		int intContadorExponente = 0;
		int intBinario = 0;
		
		Scanner scEntrada = new Scanner(System.in);
		
		do {
			System.out.print("Introduzca un n�mero igual o mayor a 0: ");
			intNumUsuario = scEntrada.nextInt();
			intNumUsuarioInicial = intNumUsuario;
		}while(intNumUsuario < 0);
		
		for (int i = 0; intNumUsuario != 0; i++) {
			intDigitoBinario = intNumUsuario % 2;
			intBinario += (int) (intDigitoBinario * Math.pow(10, intContadorExponente));
			intContadorExponente++;
			intNumUsuario /= 2;
		}
		System.out.println("Binario de " + intNumUsuarioInicial +": " +intBinario );
	}
}
