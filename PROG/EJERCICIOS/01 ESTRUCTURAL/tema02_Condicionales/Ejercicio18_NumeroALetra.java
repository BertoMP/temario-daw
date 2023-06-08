package tema02_Condicionales.actividades;

/********************************************************************************************************************
 * 																													*
 * Escribe un programa que solicite al usuario un n�mero comprendido entre 1 y 99. El programa debe mostrarlo		*
 * con letras. por ejemplo, para 56, se ver�: �cincuenta y seis�. 													*
 *																													*
 ********************************************************************************************************************/
import java.util.Scanner;
public class Ejercicio18_NumeroALetra {
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		int intNum; //variable para guardar el numero
		int intDecenas; //variable para guardar el digito correspondiente a las decenas
		int intUnidades; //variable para guardar el digito correspondiente a las unidades
		String strUnidades = ""; //variable para guardar el nombre de las unidades (1-9)
		String strDecenas = ""; //variable para guardar el nombre de los numeros decena (diez, veinte, treinta...)
		String strNumerosEspeciales = ""; //variable para guardar el nombre de los numeros con nombre unico (11-15)
		
		System.out.print("Introduzca un n�mero: ");
		intNum = scEntrada.nextInt();
		
		intDecenas = intNum / 10;
		intUnidades = intNum - (intDecenas * 10);
		
		switch(intUnidades) { //condicional multiple para asignar nombre al digito de las unidades
			case 1:{
				strUnidades = "uno";
				break;
			}	
			case 2:{
				strUnidades = "dos";
				break;
			}
			case 3:{
				strUnidades = "tres";
				break;
			}
			case 4:{
				strUnidades = "cuatro";
				break;
			}
			case 5:{
				strUnidades = "cinco";
				break;
			}
			case 6:{
				strUnidades = "seis";
				break;
			}
			case 7:{
				strUnidades = "siete";
				break;
			}
			case 8:{
				strUnidades = "ocho";
				break;
			}
			case 9:{
				strUnidades = "nueve";
				break;
			}
		}
		
		switch(intDecenas) { //condicional multiple para dar nombre al digito de las decenas
			case 1:{
				strDecenas = "diez";
				break;
			}
			case 2:{
				strDecenas = "veinte";
				break;
			}
			case 3:{
				strDecenas = "treinta";
				break;
			}
			case 4:{
				strDecenas = "cuarenta";
				break;
			}
			case 5:{
				strDecenas = "cincuenta";
				break;
			}
			case 6:{
				strDecenas = "sesenta";
				break;
			}
			case 7:{
				strDecenas = "setenta";
				break;
			}
			case 8:{
				strDecenas = "ochenta";
				break;
			}
			case 9:{
				strDecenas = "noventa";
				break;
			}
		}
		
		switch(intNum) { //condicional multiple para los casos especiales
			case 11:{
				strNumerosEspeciales = "once";
				break;
			}
			case 12:{
				strNumerosEspeciales = "doce";
				break;
			}
			case 13:{
				strNumerosEspeciales = "trece";
				break;
			}
			case 14:{
				strNumerosEspeciales = "catorce";
				break;
			}
			case 15:{
				strNumerosEspeciales = "quince";
				break;
			}
		}
		if(intNum >=1 && intNum <=9) {
			System.out.println("El n�mero es: " + strUnidades + "."); //los numeros del 1 al 9 se denominan por su unidad (strUnidades)
			}else if(intUnidades == 0) {
				System.out.println("El n�mero es: " + strDecenas + "."); //los numeros terminados en 0 se denominan por su decena (strDecenas)
				}else if(intNum >= 11 && intNum <= 15) {
					System.out.println("El n�mero es: " + strNumerosEspeciales + "."); //los numeros del 11 al 15 tienen un nombre especial (strNumerosEspeciales)
					}else if(intNum >= 16 && intNum <= 19) {
						System.out.println("El n�mero es: dieci" + strUnidades + "."); //los numeros del 16 al 19 tienen la iniciaci�n dieci seguida del nombre de la unidad
						}else if(intNum >= 21 && intNum <= 29) {
							System.out.println("El n�mero es: veinti" + strUnidades + "."); //los numeros del 21 al 29 tienen la iniciaci�n venti seguida del nombre de la unidad.
							}else {
								System.out.println("El n�mero es: " + strDecenas + " y " + strUnidades + "."); //a partir del 31 (salvo los numeros decena) tienen la estructura "decena y unidad".
							}
	}
}
