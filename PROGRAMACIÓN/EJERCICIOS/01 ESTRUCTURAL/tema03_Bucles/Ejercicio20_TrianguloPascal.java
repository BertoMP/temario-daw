package tema03_Bucles.actividades;
import java.util.Scanner;
public class Ejercicio20_TrianguloPascal {
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		int intFilas;
		int intNumeroAImprimir;
		
		System.out.print("Escriba el número de filas: ");
		intFilas = scEntrada.nextInt();
		
		for(int i = 0; i < intFilas; i++) {
			intNumeroAImprimir = 1;
			for(int j = 0; j <= i; j++) {
				System.out.print(intNumeroAImprimir + " ");
				intNumeroAImprimir = intNumeroAImprimir * (i-j) / (j+1);
			}
			System.out.println(" ");
		}
	}
}
