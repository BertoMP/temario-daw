package tema02_Condicionales.actividades;
/********************************************************************************************************************
 * 																													*
 * Realiza el ''��juego de la suma''��, que consiste en que aparezcan dos numeros aleatorios (comprendidos entre 1 y	*
 * 99) que el usuario tiene que sumar. La aplicacion debe indicar si el resultado de la operacion es correcto o		*
 * incorrecto. 																										*
 *																													*
 ********************************************************************************************************************/
import java.util.Scanner;
public class Ejercicio21_JuegoSuma {
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		int intNumAleatorizado, intNumAleatorizado2; //variables para guardar los numeros randomizados
		int intSumaNumerosAletorizados; //variable para guardar la suma de los numeros
		int intRespuestaUsuario; //variable para guardar la respuesta del usuario
		String strRespuestaFinal; //variable para guardar el mensaje final de la aplicacion
		
		/********************************************************************************************
		 * 																							*
		 * Para sacar n�meros randoms se usa el metodo Random de la clase Math. Este m�todo			*
		 * permite sacar un n�mero aleatorio igual o mayor 0 y menor de 1. Si multiplicamos			*
		 * ese numero por un valor X conseguiremos valores desde 0 hasta X-1 (Random nunca			*
		 * puede arrojar un 1 como aleatorio por lo que nunca se podr� obtener X como numero		*
		 * aleatorio), para solucionar esta limitaci�n se suma un +1 y de esa manera se eliminaInicio 	*
		 * tambi�n el 0 (el problema pide del 1 al 99)												*
		 * 																							*
		 * Adem�s del metodo Random se usa tambi�n el metodo Floor de la misma clase Math nos 		*
		 * permite redondear el numero al double de la unidad entera, es decir, el 35.2 lo 			*
		 * redondear� a 35.0, el 47.8 lo redondear� a 47.0, etc. Nunca redondea hacia arriba,		*
		 * siempre al numero de la unidad entera													*
		 * 		  																					*
		 * Por �ltimo, para evitar que el valor se guarde como un numero double con decimal 0		*
		 * se castea toda la formula a (int) y, de esa forma, el 47.0 o el 35.0 se guardar�n		*
		 * como 47 y 35.																			*
		 * 																							*
		 ********************************************************************************************/
		
		intNumAleatorizado = (int) Math.floor(Math.random() * 99 + 1); //aleatorizacion primer numero
		intNumAleatorizado2 = (int) Math.floor(Math.random() * 99 + 1); //aleatorizacion segundo numero
		
		intSumaNumerosAletorizados = intNumAleatorizado + intNumAleatorizado2; //calculo de la suma
		
		System.out.println("Introduzca el resultado de sumar " + intNumAleatorizado + " + " + intNumAleatorizado2);
		intRespuestaUsuario = scEntrada.nextInt();
		
		//Operador ternario para la respuesta correcta o incorrecta
		strRespuestaFinal = intSumaNumerosAletorizados == intRespuestaUsuario ? "CORRECTO." 
		 																	  : "INCORRECTO. El resultado es: " + intSumaNumerosAletorizados + ".";
		
		System.out.println("\n" + strRespuestaFinal);

	}

}
