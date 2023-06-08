package tema02_Condicionales.actividades;

/************************************************************************************
 * 																					*
 * Pedir tres n�meros y mostrar los ordenados de mayor a menor.						*
 *																					*
 ************************************************************************************/
import java.util.Scanner;
public class Ejercicio07_OrdenDecrecienteTresNumerosMejorado {
	public static void main(String[] args) {
		int intNum1, intNum2, intNum3;
		int intNumMayor = 0, intNumMedio = 0, intNumMenor = 0;
		Scanner scEntrada = new Scanner(System.in);
		
		System.out.print("Introduzca el primer n�mero: ");
		intNum1 = scEntrada.nextInt();
		System.out.print("Introduzca el segundo n�mero: ");
		intNum2 = scEntrada.nextInt();
		System.out.print("Introduzca el tercer n�mero: ");
		intNum3 = scEntrada.nextInt();
		
		if((intNum1 > intNum2) && (intNum2 > intNum3)) {
			intNumMayor = intNum1;
			intNumMedio = intNum2;
			intNumMenor = intNum3;
			}else if((intNum1 > intNum3) && (intNum3 > intNum2)) {
				intNumMayor = intNum1;
				intNumMedio = intNum3;
				intNumMenor = intNum2;
				}else if((intNum2 > intNum1) && (intNum1 > intNum3)) {
					intNumMayor = intNum2;
					intNumMedio = intNum1;
					intNumMenor = intNum3;
					}else if((intNum2 > intNum3) && (intNum3 > intNum1)) {
						intNumMayor = intNum2;
						intNumMedio = intNum3;
						intNumMedio = intNum1;
						}else if((intNum3 > intNum1) && (intNum1 > intNum2)) {
							intNumMayor = intNum3;
							intNumMedio = intNum1;
							intNumMenor = intNum2;
							}else if((intNum3 > intNum2) && (intNum2 > intNum1)) {
								intNumMayor = intNum3;
								intNumMedio = intNum2;
								intNumMenor = intNum1;
							}
		System.out.println("Orden decreciente: " + intNumMayor + " > " + intNumMedio + " > " + intNumMenor + ".");
	}
}
