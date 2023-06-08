package tema03_Bucles.actividades;
import java.util.Scanner;
public class Ejercicio26_PrimosDe1AN {
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		
		int intNumUsuario; 
		boolean blnEsPrimo;
		
		System.out.print("Introduzca un n�mero: ");
		intNumUsuario = scEntrada.nextInt();
		System.out.println("Entre el 1 y el " + intNumUsuario + " hay los siguientes primos: ");
		
	        for (int i = 1; i < (intNumUsuario + 1); i++) {
	        	blnEsPrimo = true;
	        	for(int j = i - 1; j > 1 && blnEsPrimo; j--) {
	        		if(i % j == 0) {
	        			blnEsPrimo = false;
	        		}
	        	}
	        	if(blnEsPrimo) {
	        		System.out.print(i + " ");
	        	}
	        }
	}
}
