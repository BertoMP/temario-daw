package tema02_Condicionales.actividades;
import java.util.Scanner;
/****************************************************************
 * 																*
 * Crea un programa llamado **MostrarTiempo.java** que tomando 	*
 * una cantidad por teclado de segundos (entero positivo) 		*
 * muestre la cantidad de minutos y segundos contenidos.		*
 *																*
 ****************************************************************/
public class Ejercicio26_MostrarTiempo {
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		int intSegundosUsuario;
		int intMinutos = 0;
		int intSegundos = 0;
		
		System.out.print("Introduzca segundos: ");
		intSegundosUsuario = scEntrada.nextInt();
		
		if(intSegundosUsuario < 0) {
			intMinutos = intSegundosUsuario / 60;
			intSegundos = intSegundosUsuario % 60;
		}else {
			System.out.println("No puede haber un n�mero negativo de minutos.");
		}
		
		System.out.println("En " + intSegundosUsuario + " segundos hay un total de: " + intMinutos + " minutos y " + 
						   intSegundos + " segundos. ");
	}
}
