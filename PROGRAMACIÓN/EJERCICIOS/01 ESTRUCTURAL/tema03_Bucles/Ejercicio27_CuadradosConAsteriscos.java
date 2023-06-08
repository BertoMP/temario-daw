package tema03_Bucles.actividades;
import java.util.Scanner;
public class Ejercicio27_CuadradosConAsteriscos {
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		
		int intNumLados;
		
		System.out.print("Introduzca longitud del lado: ");
		intNumLados = scEntrada.nextInt();
		
		for(int i = 1; i <= intNumLados; i++) {
			for (int j = 1; j <= intNumLados; j++) {
				System.out.print("* ");
			}
			System.out.println(" ");
		}
	}
}
