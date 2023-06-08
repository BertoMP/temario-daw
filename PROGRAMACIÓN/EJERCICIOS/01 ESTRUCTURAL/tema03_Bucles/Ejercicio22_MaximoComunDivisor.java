package tema03_Bucles.actividades;
import java.util.Scanner;
public class Ejercicio22_MaximoComunDivisor {

	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		int intNumUsuario1;
		int intNumUsuario1Inicial;
		int intNumUsuario2;
		int intNumUsuario2Inicial;
		int intResultado;
		
		System.out.print("Dame un n�mero: ");
		intNumUsuario1 = scEntrada.nextInt();
		intNumUsuario1Inicial = intNumUsuario1;
		
		do {
			System.out.print("Dame un segundo n�mero (debe ser mayor que el anterior): ");
			intNumUsuario2 = scEntrada.nextInt();
			intNumUsuario2Inicial = intNumUsuario2;
		}while(intNumUsuario2 < intNumUsuario1);
		
		do {
			intResultado = intNumUsuario2;
			intNumUsuario2 = intNumUsuario1 % intNumUsuario2;
			intNumUsuario1 = intResultado;
		}while (intNumUsuario2 != 0);
		
		System.out.print("El m�ximo com�n divisor de " + intNumUsuario1Inicial + " y " + intNumUsuario2Inicial + " es: " + intResultado);
	}
}
