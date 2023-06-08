package tema02_Condicionales.actividades;

/********************************************************************************
 * 																				*
 * Dise�a una aplicaci�n en la que, dado un n�mero de DNI, calcule la letra 	*
 * que le corresponde.															*
 *																				*
 ********************************************************************************/
import java.util.Scanner;
public class Ejercicio16_LetraDni {
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		int intNumDni; //variable para guardar el DNI del usuario
		int intRestoDni; //variable para guardar el resto de la operaci�n intNumDni MOD 23
		char chrLetra = ' '; //variable para guardar la letra correspondiente
		
		System.out.println("Introduzca su DNI");
		intNumDni = scEntrada.nextInt();
		
		intRestoDni = intNumDni % 23; //la letra del DNI es una relaci�n letra => Resto de DNI/23
		
		switch(intRestoDni) { //condicional multiple para asignar la letra
		case 0:{
			chrLetra = 'T';
			break;
		}
		case 1:{
			chrLetra = 'R';
			break;
		}
		case 2:{
			chrLetra = 'W';
			break;
		}
		case 3:{
			chrLetra = 'A';
			break;
		}
		case 4:{
			chrLetra = 'G';
			break;
		}
		case 5:{
			chrLetra = 'M';
			break;
		}
		case 6:{
			chrLetra = 'Y';
			break;
		}
		case 7:{
			chrLetra = 'F';
			break;
		}
		case 8:{
			chrLetra = 'P';
			break;
		}
		case 9:{
			chrLetra = 'D';
			break;
		}
		case 10:{
			chrLetra = 'X';
			break;
		}
		case 11:{
			chrLetra = 'B';
			break;
		}
		case 12:{
			chrLetra = 'N';
			break;
		}
		case 13:{
			chrLetra = 'J';
			break;
		}
		case 14:{
			chrLetra = 'Z';
			break;
		}
		case 15:{
			chrLetra = 'S';
			break;
		}
		case 16:{
			chrLetra = 'Q';
			break;
		}
		case 17:{
			chrLetra = 'V';
			break;
		}
		case 18:{
			chrLetra = 'H';
			break;
		}
		case 19:{
			chrLetra = 'L';
			break;
		}
		case 20:{
			chrLetra = 'C';
			break;
		}
		case 21:{
			chrLetra = 'K';
			break;
		}
		case 22:{
			chrLetra = 'E';
			break;
		}
		}
		System.out.println("El DNI completo es: " + intNumDni + "-" + chrLetra);
	}
}
