package tema02_Condicionales.actividades;
/****************************************************************************************************************
 * 																												*
 * Modifica la Actividad de aplicacion 21 para que, ademas de los dos numeros aleatorios, tambien aparezca la	*
 * operacion que debe realizar el jugador: suma. resta o multiplicacion.										*
 *																												*
 ****************************************************************************************************************/
import java.util.Scanner;
public class Ejercicio22_JuegoMejorado {
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		int intNumAleatorizado, intNumAleatorizado2; //variables para guardar los numeros aleatorizados
		int intOperacionAleatorizado; //variable para guardar la operacion aleatorizada
		int intResultadoOperacion = 0; //variable para guardar el resultado de la operacion
		int intRespuestaUsuario = 0; //variable para guardar la respuesta del usuario
		String strRespuestaFinal; //variable para guardar la respuesta final de la aplicacion
		
		intNumAleatorizado = (int) Math.floor(Math.random() * 99 + 1); //primer numero aleatorio
		intNumAleatorizado2 = (int) Math.floor(Math.random() * 99 + 1); //segundo numero aleatorio
		intOperacionAleatorizado = (int) Math.floor(Math.random() * 3 + 1); //operacion aleatoria
		
		switch(intOperacionAleatorizado) { //condicional multiple para realizar una u otra operacion
			case 1:{ //SUMA
				intResultadoOperacion = intNumAleatorizado + intNumAleatorizado2;
				
				System.out.println("Introduzca el resultado de sumar " + intNumAleatorizado + " + " + intNumAleatorizado2);
				intRespuestaUsuario = scEntrada.nextInt();
				break;
			}
			case 2:{ //RESTA
				intResultadoOperacion = intNumAleatorizado - intNumAleatorizado2;
				
				System.out.println("Introduzca el resultado de restar " + intNumAleatorizado + " - " + intNumAleatorizado2);
				intRespuestaUsuario = scEntrada.nextInt();
				break;
			}
			case 3:{ //MULTIPLICACION
				intResultadoOperacion = intNumAleatorizado * intNumAleatorizado2;
				
				System.out.println("Introduzca el resultado de multiplicar " + intNumAleatorizado + " * " + intNumAleatorizado2);
				intRespuestaUsuario = scEntrada.nextInt();
				break;
			}
		}
		
		strRespuestaFinal = intResultadoOperacion == intRespuestaUsuario ? "CORRECTO." 
		 																	       : "INCORRECTO. El resultado es: " + intResultadoOperacion + ".";
		
		System.out.println("\n" + strRespuestaFinal);
	}
}
