package tema03_Bucles.actividades;
import java.util.Scanner;
public class Ejercicio21_TrianguloAsteriscos {
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		int intNumeroFilas;
		
		System.out.print("Introduzca n�mero de filas: ");
		intNumeroFilas = scEntrada.nextInt();
		
		for(int i = 1; i <= intNumeroFilas; i++) { //controla el alto
			for(int j = 1; j <= (intNumeroFilas-i); j++) { //controla los espacios
				System.out.print(" ");
			}
			for(int k = 1; k <= (i*2)-1; k++) { //controla la impresi�n
				System.out.print("*");
			}
			System.out.println(" ");
		}
		
	}
}
