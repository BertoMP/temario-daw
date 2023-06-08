package tema03_Bucles.actividades;
import java.util.Scanner;
public class Ejercicio11_CalculoFactorial {
	/********************************************************************************************************************************
	 * 																																*
	 * Pedir un n�mero y calcular su factorial. Por ejemplo, el factorial de 5 se denota 5! Y es igual a 5 x 4 x 3 x 2 x 1 = 120. 	*
	 * 																																*
	 ********************************************************************************************************************************/
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		
		//DECLARACI�N VARIABLES
		int intNumUsuario; //variable para guardar el n�mero de usuario
		double rlnResultadoFactorial = 1; /* variable para guardar el resultado del factorial, se inicia en 1 por ser una multiplicaci�n.
										  Elijo double como tipo de variable porque un int s�lo permitir�a factoriales hasta el 16 (incluido)
										  y un long hasta el 25 (incluido) */
											
		
		//SOLICITUD DE DATOS
		System.out.print("Introduzca el numero: ");
		intNumUsuario = scEntrada.nextInt();
		
		//BUCLE (se elige for porque se conoce el inicio, el fin y la itinerancia)
		for (int i = intNumUsuario; i > 0; i--) {
			rlnResultadoFactorial *= i; //es lo mismo que rlnResultadoFactorial = rlnResultadoFactorial * i
		}
		
		//IMPRESI�N DE RESULTADOS
		System.out.print(intNumUsuario + "! = " + rlnResultadoFactorial);
	}
}
