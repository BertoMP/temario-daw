package tema02_Condicionales.actividades;
/************************************************************************************************
 *																								* 
 * Utiliza el operador ternario para calcular el valor absoluto de un numero que se solicita 	*
 * al usuario por teclado. 																		*
 *																								*
 ************************************************************************************************/
import java.util.Scanner;
public class Ejercicio20_ValorAbsoluto {
	public static void main(String[] args) {
		
		/********************************************************************************
		 * 																				*
		 * El programa busca calcular el valor absoluto de un n�mero que ser� el propio	*
		 * numero si es positivo o cero o su contrario si es negativo, por ejemplo:		*
		 * 																				*
		 * |5| = 5																		*
		 * |-3| = 3																		*
		 * 																				*
		 ********************************************************************************/
		
		Scanner scEntrada = new Scanner(System.in);
		int intNum;
		int intValorAbsoluto;
		
		System.out.print("Introduzca un numero: ");
		intNum = scEntrada.nextInt();
		
		intValorAbsoluto = (intNum >= 0) ? intNum : -intNum;
		
		/********************************************************************************
		 * 																				*
		 * Es lo mismo que:																*
		 * 																				*
		 * if (intNum > 0) {															*
		 * 	intValorAbsoluto = intNum;													*
		 * else {																		*
		 * 	intValorAbosluto = -intNum;													*
		 * 																				*
		 ********************************************************************************/
		
		System.out.println("El valor absoluto de " + intNum + " es " + intValorAbsoluto + ".");

	}

}
