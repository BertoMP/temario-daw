package tema02_Condicionales.actividades;

/************************************************************************************************
 * 																								*
 * Crear una aplicaci�n que solicite al usuario una fecha (d�a, mes y a�o) y muestre 			*
 * la fecha correspondiente al d�a siguiente.													*
 *																								*
 ************************************************************************************************/

import java.util.Scanner;
public class Ejercicio14_FechaSiguiente {
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		byte btyDia, btyMes;
		int intAnno;
		byte btyMaximoDiasMes = 0;
		
		System.out.println("Introduzca fecha: "); //solicitar fecha al usuario
		System.out.print("Introduzca d�a: ");
		btyDia = scEntrada.nextByte();
		System.out.print("Introduza mes: ");
		btyMes = scEntrada.nextByte();
		System.out.print("Introduzca a�o: ");
		intAnno = scEntrada.nextInt();
		
		switch(btyMes) { //establecer el m�ximo de d�as que puede tener un mes
			case 2:{
				btyMaximoDiasMes = 28;
				break;
			}
			case 4,6,9,11:{
				btyMaximoDiasMes = 30;
				break;
			}
			default:{
				btyMaximoDiasMes = 31;
			}
		}
		
		btyDia++; //a�adir un d�a m�s
		
		if(btyDia > btyMaximoDiasMes) { //en caso de superar el l�mite m�ximo de d�as, realizar cambio de mes (y a�o si es necesario).
			btyDia = 1;
			btyMes++;
			if(btyMes > 12) {
				btyMes = 1;
				intAnno++;
			}
		
		}
		if(intAnno == 0) {
			intAnno = 1;
		}
		
		System.out.println("Fecha d�a siguiente: " + btyDia + "/" + btyMes + "/" + intAnno);
	}

}
