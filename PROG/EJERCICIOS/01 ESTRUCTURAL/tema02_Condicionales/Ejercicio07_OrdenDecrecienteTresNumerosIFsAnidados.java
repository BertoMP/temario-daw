package tema02_Condicionales.actividades;

/************************************************************************************
 * 																					*
 * Pedir tres n�meros y mostrar los ordenados de mayor a menor.						*
 *																					*
 ************************************************************************************/
import java.util.Scanner;
public class Ejercicio07_OrdenDecrecienteTresNumerosIFsAnidados {
	public static void main(String[] args) {
		int intNum1, intNum2, intNum3;
		int intNumMayor, intNumMedio, intNumMenor;
		Scanner scEntrada = new Scanner(System.in);
		
		System.out.print("Introduzca el primer n�mero: ");
		intNum1 = scEntrada.nextInt();
		System.out.print("Introduzca el segundo n�mero: ");
		intNum2 = scEntrada.nextInt();
		System.out.print("Introduzca el tercer n�mero: ");
		intNum3 = scEntrada.nextInt();
		
		if(intNum1 > intNum2) {
			if (intNum1 > intNum3) {
				intNumMayor = intNum1;
				if(intNum2 > intNum3) {
					intNumMenor = intNum3;
					intNumMedio = intNum2;
					}else {
						intNumMenor = intNum2;
						intNumMedio = intNum3;
					}
				}else {
				intNumMayor = intNum3;
				intNumMenor = intNum2;
				intNumMedio = intNum1;
				}
			}else {
				if(intNum2 > intNum3) {
					intNumMayor = intNum2;
					if(intNum1 > intNum3) {
						intNumMenor = intNum3;
						intNumMedio = intNum1;
						}else {
							intNumMenor = intNum1;
							intNumMedio = intNum3;
						}
					}else {
						intNumMayor = intNum3;
						intNumMedio = intNum2;
						intNumMenor = intNum1;
					}
		}
		System.out.println("Orden decreciente: " + intNumMayor + ", " + intNumMedio + ", " + intNumMenor);
	}
}
