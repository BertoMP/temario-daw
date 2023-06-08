package tema03_Bucles.actividades;
import java.util.Scanner;
public class Ejercicio28_CuadradosHuecos {
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		
		int intNumLados;
		
		System.out.print("Introduzca longitud del lado: ");
		intNumLados = scEntrada.nextInt();
		
		for(int i = 1; i <= intNumLados; i++) {
			for (int j = 1; j <= intNumLados; j++) {
				if(i == 1 || i == intNumLados) {
					System.out.print("* ");
				}else if(j == 1 || j == intNumLados) {
					System.out.print("* ");
				}else {
					System.out.print("  ");
				}
			}
			System.out.println(" ");
		}
	}
}