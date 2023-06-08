package tema02_Condicionales.actividades;

import java.util.Scanner;
public class Ejercicio15_CapicuaModulos {
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		int intNum; //variable para introducir el numero original del usuario la cual ademas guardara los resultados de las divisiones /10
		int intUnidades, intDecenas, intCentenas, intUnidadesMillar; //variables para guardar los n�meros correspondientes a cada digito
		boolean blnCapicua = false; //variable para decidir si es capicua (true) o no lo es (false)
		
		System.out.print("Introduzca un numero: ");
		intNum = scEntrada.nextInt();
		
		if(intNum >= 1 && intNum <= 9999) {
			intUnidades = intNum % 10; //para sacar las unidades saco el m�dulo del n�mero entre 10, por ejemplo, 9999 % 10 = 9
			intNum = intNum / 10; /* se divide al n�mero entre 10 para eliminar las unidades, por ejemplo, 9999 / 10 = 999.9 
									 (como es un int s�lo se guarda la parte entera del n�mero) */
			intDecenas = intNum % 10;
			intNum = intNum / 10;
			
			intCentenas = intNum % 10;
			intNum = intNum / 10;
			
			intUnidadesMillar = intNum;
			
			if(intNum < 10) {
				blnCapicua = true;
				}else if(intNum < 100) {
						  if(intUnidades == intDecenas) {
							  blnCapicua = true;
						  }
								}else if(intNum < 1000){
										  if(intUnidades == intCentenas) {
											  blnCapicua = true;
										  }
												}else if(intNum < 10000) {
															if((intUnidades == intUnidadesMillar) &&(intDecenas == intCentenas)) {
																 blnCapicua = true;
															}
														}
																	}else {
																		System.out.println("El n�mero introducido est� fuera de rango.");
																	}
	}
}
