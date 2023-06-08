package tema02_Condicionales.actividades;

/************************************************************************************************************************
 * 																														*
 * Escriba una aplicaci�n que solicite el usuario un n�mero comprendido entre 0 y 9.999. La aplicaci�n tendr� que		*
 * indicar si el n�mero introducido es capic�a.																			*
 * 																														*
 ************************************************************************************************************************/
import java.util.Scanner;
public class Ejercicio15_Capicua {

	public static void main(String[] args) {

		//Scanner y variables
		Scanner scEntrada = new Scanner(System.in);
		int intNum; //variable para la introducci�n del n�mero
		int intUnidadesMillar, intCentenas, intDecenas, intUnidades; //variables para la descomposici�n del n�mero
		boolean blnCapicua = false; //variables para la asignaci�n final

		//Introducci�n de datos
		System.out.print("Introduce un n�mero: ");
		intNum = scEntrada.nextInt();
		
		/************************************************************************************************
		 *																								*
		 * A continuaci�n se describen una serie de operaciones que buscan sacar cada una de las cifras	*
		 * del n�mero del usuario, es decir, descomponer el n�mero en unidades, decenas, centenas...	*
		 * para su posterior comparaci�n.																*
		 *																								*
		 * Se coger� como ejemplo el n�mero m�ximo permitido es decir, 9999.							*
		 *																								*
		 * Si se descompone este n�mero ser�a el: 9000 (9 unidades de millar) + 900 (9 centenas) +		* 
		 * + 90 (9 decenas) + 9 (9 unidades).															*
		 * 																								*
		 ************************************************************************************************/
		
		//Descomponer el n�mero en sus diferentes d�gitos
		intUnidadesMillar = intNum / 1000; /* 9999 / 1000 = 9 (aunque el resultado es 9'999, lo guardo en 
											  un int as� que s�lo guarda la parte entera */
		intCentenas = (intNum - (intUnidadesMillar * 1000)) / 100; /* 9999 - (9 * 1000) / 100 =
		 															  9999 - 9000 / 100 = 999 / 100 = 9*/
		intDecenas = (intNum - (intUnidadesMillar * 1000 + intCentenas * 100)) / 10; /* 9999 - (9 * 1000 + 9 * 100) / 10 
		 																				9999 - 9900 / 10 = 99 / 10 = 9*/
		intUnidades = (intNum - (intUnidadesMillar * 1000 + intCentenas * 100 + intDecenas * 10)); /* 9999 - (9 * 1000 + 9 * 100 + 9 * 10) =
		 																							  9999 - 9990 = 9*/
		
		//Comparaci�n de d�gitos en funci�n del n�mero total de d�gitos
		if (intNum > 0 && intNum < 10000) {
			if (intNum < 10) { //los n�meros de una �nica cifra ser�n todos capic�a
				blnCapicua = true;
			} else if (intNum < 100) { 
				if (intDecenas == intUnidades) { //los n�meros de dos cifras deber�n tener el mismo d�gito de decenas que de unidades
					blnCapicua = true;
				}
				} else if (intNum < 1000) {
					if (intCentenas == intUnidades) { //los n�meros de tres cifras deber�n tener el mismo n�mero de centenas que de unidades
						blnCapicua = true;
					}
					} else if (intNum < 10000) {
						if ((intUnidadesMillar == intUnidades) && (intCentenas == intDecenas)) { /* los n�meros de cuatro cifras deber�n tener el 
																									mismo numero de unidades de millar que unidades 
																									y de centenas que de decenas */
							blnCapicua = true;
						}
					} 
			
			//Respuesta por consola
			if (blnCapicua) { //condicional para decidir si el n�mero es capicua o no en funci�n de la variable booleana
				System.out.println("El n�mero " + intNum + " es capic�a.");
			} else {
				System.out.println("El n�mero " + intNum + " no es capic�a.");
			}	
		} else {//sysout en caso de introducir n�mero negativo o por encima del valor m�ximo permitido (9999)
			System.out.println("El n�mero introducido no es v�lido.");
		}
	}
}