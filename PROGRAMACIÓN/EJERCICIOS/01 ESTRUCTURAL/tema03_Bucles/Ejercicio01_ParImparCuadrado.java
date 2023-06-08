package tema03_Bucles.actividades;
import java.util.Scanner;
public class Ejercicio01_ParImparCuadrado {
	/************************************************************************************************
	 * 																								*
	 * Dise�ar un programa que muestre, para cada n�mero introducido por teclado, si es par,		*
	 * si es positivo y su cuadrado.																*
	 * El proceso se repetir� hasta que el n�mero introducido sea 0.								*
	 * 	 																							*
	 ************************************************************************************************/
	public static void main(String[] args) {
		//VARIBLES
		int intNumUsuario; //variable para guardar el n�mero del usuario
		int intCuadrado; //variable para guardar el cuadrado del numero
		String strPositivo; //variable para guardar el mensaje del ternario positivo/negativo
		String strPar; //variable para guardar el mensaje del ternario par/impar
		
		//SOLICITUD DE PRIMER NUMERO
		System.out.print("Introduzca un n�mero: ");
		intNumUsuario = new Scanner (System.in).nextInt();
		
		//BUCLE (se elige while porque es posible que la primera introducci�n sea un 0)
		while(intNumUsuario !=0) {
			strPositivo = (intNumUsuario > 0) ? "Es un n�mero positivo." : "No es un n�mero positivo."; //Ternario para positivo/negativo
			strPar = ((intNumUsuario % 2) == 0) ? "Es un n�mero par." : "No es un n�mero par."; //Ternario para par/impar
			intCuadrado = (int) Math.pow(intNumUsuario, 2);
			
			//IMPRESI�N DE DATOS
			System.out.println("\nHa introducido el n�mero " + intNumUsuario + ". Este n�mero..." 
							+ "\n" + strPositivo
							+ "\n" + strPar
							+ "\nSu cuadrado es: " + intCuadrado);
			
			//SOLICITUD DE LOS DIFERENTES N�MEROS DE LAS ITERACIONES
			System.out.print("\nIntroduzca un n�mero (si es 0 se finalizar� el programa): ");
			intNumUsuario = new Scanner (System.in).nextInt();
		}
		//FIN DEL PROGRAMA
		System.out.println("FIN DEL PROGRAMA");
	}
}
