package tema03_Bucles.actividades;
import java.util.Scanner;
public class Ejercicio15_DibujoAsteriscos {
	/****************************************************************************************************************
	 * 																												*
	 * Pedir por consola un n�mero n y dibujar un tri�ngulo rect�ngulo de n elementos de lado utilizando para ello	*
	 * asteriscos (*). Por ejemplo, para n = 4:																		*
	 *     ****																										*
	 *     ***																										*
	 *     **																										*
	 *     *																										*
	 * 																												*
	 ****************************************************************************************************************/
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		
		//DECLARACI�N DE VARIABLES
		int intNElementosDeLado; //variable para decidir los elementos de lado
		
		//SOLICITUD DE DATOS
		System.out.print("Introduzca tama�o del lado: ");
		intNElementosDeLado = scEntrada.nextInt();
		
		//BUCLE 1 (se encargar� de las filas y s�lo imprimir� un salto de l�nea cuando el anidado termine su funci�n)
		for(int i = 1; i <= intNElementosDeLado; i++) {
			
			//BUCLE 2 (se encargar� de las columnas e imprimir� los *)
			for(int j = i; j <= intNElementosDeLado; j++) {
				
				//IMPRESI�N DE RESULTADOS
				System.out.print("* "); //debe ser un .print para que salga todo seguido, con println se crear�an nuevas filas
			}
			
			//IMPRESI�N DE RESULTADOS 2
			System.out.println(""); //salto de l�nea para iniciar una nueva fila
		}
	}
}