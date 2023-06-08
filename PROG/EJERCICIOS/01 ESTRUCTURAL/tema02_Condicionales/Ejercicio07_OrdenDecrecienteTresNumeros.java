package tema02_Condicionales.actividades;

/************************************************************************************
 * 																					*
 * Pedir tres n�meros y mostrar los ordenados de mayor a menor.						*
 *																					*
 ************************************************************************************/
import java.util.Scanner;
public class Ejercicio07_OrdenDecrecienteTresNumeros {
	public static void main(String[] args) {
		int intNum1, intNum2, intNum3;
		Scanner scEntrada = new Scanner(System.in);
		
		System.out.print("Introduzca el primer n�mero: ");
		intNum1 = scEntrada.nextInt();
		System.out.print("Introduzca el segundo n�mero: ");
		intNum2 = scEntrada.nextInt();
		System.out.print("Introduzca el tercer n�mero: ");
		intNum3 = scEntrada.nextInt();
		
		if((intNum1 > intNum2) && (intNum2 > intNum3)) {
			System.out.println("Orden decreciente: " + intNum1 + ", " + intNum2 + ", " + intNum3 + ".");
		}else if((intNum1 > intNum3) && (intNum3 > intNum2)) {
			System.out.println("Orden decreciente: " + intNum1 + ", " + intNum3 + ", " + intNum2 + ".");
		}else if((intNum2 > intNum1) && (intNum1 > intNum3)) {
			System.out.println("Orden decreciente: " + intNum2 + ", " + intNum1 + ", " + intNum3 + ".");
		}else if((intNum2 > intNum3) && (intNum3 > intNum1)) {
			System.out.println("Orden decreciente: " + intNum2 + ", " + intNum3 + ", " + intNum1 + ".");
		}else if((intNum3 > intNum1) && (intNum1 > intNum2)) {
			System.out.println("Orden decreciente: " + intNum3 + ", " + intNum1 + ", " + intNum2 + ".");
		}else if((intNum3 > intNum2) && (intNum2 > intNum1)) {
			System.out.println("Orden decreciente: " + intNum3 + ", " + intNum2 + ", " + intNum1 + ".");
		}
	}
}
