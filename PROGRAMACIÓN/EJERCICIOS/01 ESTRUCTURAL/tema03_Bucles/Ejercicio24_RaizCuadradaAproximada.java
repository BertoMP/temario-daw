package tema03_Bucles.actividades;
import java.util.Scanner;
public class Ejercicio24_RaizCuadradaAproximada {
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		int intNumUsuario;
		int intPotencia;
		int intResultado;
		int intResto;
		int intContador = 0;
		
		System.out.println("Introduzca n�mero: ");
		intNumUsuario = scEntrada.nextInt();
		
		do {
			intContador++;
			intPotencia = (int) Math.pow(intContador, 2);		
		}while (intPotencia < intNumUsuario);
		
		intResto = (int) (intNumUsuario - (Math.pow(intContador-1, 2)));
		
		if(Math.pow(intContador,2) == intNumUsuario) {
			System.out.print("La raiz cuadrada de " + intNumUsuario + " es: " + intContador);
		}else {
			System.out.println("La ra�z cuadrada aproximada de " + intNumUsuario + " es " + (intContador-1) + " y el resto es " + intResto);
		}
	}
}
