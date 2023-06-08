package tema02_Condicionales.actividades;
import java.util.Scanner;

/************************************************************
 * 															*
 * Pedir dos n�meros enteros y decir si son iguales o no.	*
 * 															*
 ************************************************************/

public class Ejercicio02_NumerosIgualesTernario{
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in); //creaci�n de un Scanner.
		int intNum1Usuario, intNum2Usuario; //variables para la introducci�n de n�meros.
		String strRespuesta; //variable para el ternario
		
		System.out.print("Introduzca un n�mero: "); //solicitud de datos.
		intNum1Usuario = scEntrada.nextInt();
		System.out.print("Introduzca un segundo n�mero: ");
		intNum2Usuario = scEntrada.nextInt(); 
		
		//Operador ternario
		strRespuesta = (intNum1Usuario == intNum2Usuario)?"Los n�meros son iguales.":"Los n�meros son diferentes.";
		
		System.out.println(strRespuesta);
	}

}
