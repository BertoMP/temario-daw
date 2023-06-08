package tema03_Bucles.actividades;
import java.util.Scanner;
public class Ejercicio05_CalculoMentalSumas {
	/********************************************************************************************************************************
	 * 																																*
	 *  Desarrollar un juego que ayude a mejorar el c�lculo mental de la suma. El jugador tendr� que introducir la soluci�n			*
	 *  de la suma de dos n�meros aleatorios comprendidos entre 1 y 100. Mientras la soluci�n introducida sea correcta,				*
	 *  el juego continuar�. En caso contrario, el programa terminar� y mostrar� el n�mero de operaciones realizadas				*
	 *  correctamente. 																												*
	 *																																*
	 ********************************************************************************************************************************/
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		
		//DECLARACI�N DE VAIRABLES
		int intNumAleatorio1, intNumAleatorio2; //variables para guardar los n�meros aleatorios
		int intResultadoCorrecto; //variable para guardar la suma correcta
		int intResultadoUsuario; //variable para guardar el resultado del usuario
		int intContadorOperacionesCorrectas = 0; //variable tipo contador para contar operaciones correctas
		
		//BUCLE (se elige porque habr� que realizarlo al menos una vez)
		do {
			
			intNumAleatorio1 = (int) (Math.random() * 100 + 1); //c�lculo de los n�meros aleatorios
			intNumAleatorio2 = (int) (Math.random() * 100 + 1);
			
			//SOLICITUD DE RESULTADOS
			System.out.print(intNumAleatorio1 + " + " + intNumAleatorio2 + " = ");
			intResultadoUsuario = scEntrada.nextInt();
			intResultadoCorrecto = intNumAleatorio1 + intNumAleatorio2;
			
			intContadorOperacionesCorrectas++; /* otra opci�n de colocar este contador es con un if
			
				 									  if (intResultadoUsuario == intResultadoCorrecto){
				 									  		intContadorOperacionesCorrectas++;
				 									  }
			 									  
	  		 									  Ambas opciones son v�lidas pero cambiar� la forma de expresarlo en el resultado final. 
	  		 									  Habr� que poner intContadorOperacionesCorrectas en lugar de intContadorOperacionesCorrectas-1 */

		}while (intResultadoCorrecto == intResultadoUsuario); //el bucle terminar� cuando el usuario falle una suma.
		
		//IMPRESI�N DE RESULTADOS
		System.out.print("Has realizado correctamente: " + (intContadorOperacionesCorrectas-1) + " consecutivas.");
	}
}
