package tema02_Condicionales.actividades;
import java.util.Scanner;

/****************************************************************
 * 																*
 * Solicitar dos n�meros distintos y mostrar cu�l es el mayor.	*
 * 																*
 ****************************************************************/

public class Ejercicio03_NumeroMayorTernario {
	public static void main(String[] args) {	
		Scanner scEntrada = new Scanner(System.in);
		int intNum1Usuario, intNum2Usuario; //variables para la introducci�n de valores.
		String strRespuesta; //variable para el operador ternario.
		
		System.out.print("Introduzca un n�mero: "); //petici�n de datos al usuario.
		intNum1Usuario = scEntrada.nextInt();
		System.out.print("Introduzca un n�mero diferente al anterior: ");
		intNum2Usuario = scEntrada.nextInt();
		
		//Operador ternario
		strRespuesta = (intNum1Usuario > intNum2Usuario)?"El n�mero " + intNum1Usuario + " es mayor que el n�mero " + intNum2Usuario + "."
														:"El n�mero " + intNum2Usuario + " es mayor que el n�mero " + intNum1Usuario + ".";
		
		System.out.println(strRespuesta);
	}
}
