package tema03_Bucles.actividades;
import java.util.Scanner;
public class Ejercicio18_Hora {

	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		
		int intHoraActual;
		int intMinutoActual;
		int intSegundoActual;
		int intSegundosASumar;
		
		System.out.println("Introduzca la hora actual:");
		System.out.print("\tHORA: ");
		intHoraActual = scEntrada.nextInt();
		System.out.print("\tMINUTOS: ");
		intMinutoActual = scEntrada.nextInt();
		System.out.print("\tSEGUNDOS: ");
		intSegundoActual = scEntrada.nextInt();
		System.out.print("\nIntroduzca los segundos a sumar: ");
		intSegundosASumar = scEntrada.nextInt();
		
		for(int i = 0; i < intSegundosASumar; i++) {
			intSegundoActual++;
			if(intSegundoActual > 59) {
				intSegundoActual = 0;
				intMinutoActual++;
				if(intMinutoActual > 59) {
					intMinutoActual = 0;
					intHoraActual++;
					if(intHoraActual > 23) {
						intHoraActual = 0;
					}
				}
			}
		}
		System.out.print("La hora dentro de " + intSegundosASumar + " segundos sera: ");
		System.out.print(intHoraActual + ":");
		if(intMinutoActual < 10) {
			System.out.print("0");
		}
		System.out.print(intMinutoActual + ":");
		if(intSegundoActual < 10) {
			System.out.print("0");
		}
		System.out.println(intSegundoActual);
	}
}
