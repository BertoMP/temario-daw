package tema02_Condicionales.actividades;

/************************************************************************************
 * 																					*	
 * Escribir un programa que pida una hora de la siguiente forma: hora, 				*
 * minutos y segundos. El programa debe mostrar qu� hora ser� un segundo m�s 		*
 * tarde. Por ejemplo: hora actual [10:41:59] -> hora actual +1 segundo [10:42:00]	*
 *																					*
 ************************************************************************************/

import java.util.Scanner;
public class Ejercicio13_HorasSiguiente {
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		byte btySegundos, btyMinutos, btyHoras;
		
		System.out.println("Introduzca hora:"); //solicitar hora al usuario
		System.out.print("Introduzca horas: ");
		btyHoras = scEntrada.nextByte();
		System.out.print("Introduzca minutos: ");
		btyMinutos = scEntrada.nextByte();
		System.out.print("Introduzca segundos: ");
		btySegundos = scEntrada.nextByte();
		
		btySegundos++; //a�adir segundo
		
		if(btySegundos > 59) { //en caso de cambio de minuto (y hora) realizar reseteos y operaciones de conteo de a�adido
			btySegundos = 0;
			btyMinutos++;
			if(btyMinutos > 59) {
				btyMinutos = 0;
				btyHoras++;
				if(btyHoras > 23) {
					btyHoras = 0;
				}
			}
		}
		System.out.println("La hora en el pr�ximo segundo ser�: " + btyHoras + ":" + btyMinutos + ":" + btySegundos);
	}
}
