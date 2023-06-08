package tema02_Condicionales.actividades;
import java.util.Scanner;

/********************************************************************************************
 * 																							*
 * Dise�ar una aplicaci�n que solicite al usuario un n�mero e indique si es	par o impar.	*																*
 * 																							*
 ********************************************************************************************/

public class Ejercicio01_ParImparTernario {
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in); //creaci�n de un Scanner.
		int intNumUsuario; //variable para introducir n�meros.
		String strRespuesta; //variable para el ternario.
	
		System.out.print("Introduzca un n�mero: "); //solicitud de datos al usuario.
		intNumUsuario = scEntrada.nextInt();
		
		//Operador ternario
		strRespuesta = (intNumUsuario % 2 == 0)?"El n�mero " + intNumUsuario + " es un numero par."
											   :"El n�mero " + intNumUsuario + " es un numero impar.";
		
		System.out.println(strRespuesta);
	}
}
