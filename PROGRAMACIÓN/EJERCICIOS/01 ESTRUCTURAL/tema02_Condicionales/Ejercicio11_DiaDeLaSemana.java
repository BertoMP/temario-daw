package tema02_Condicionales.actividades;

/****************************************************************************************************
 * 																									*
 * Idear un programa que solicite al usuario un n�mero comprendido entre 1 y 7, correspondiente 	*
 * a un d�a de la semana. Se debe mostrar el nombre del d�a de la semana al que corresponde. 		*
 * Por ejemplo, el n�mero corresponde a "lunes" y el 6 a "s�bado".									*
 *																									*
 ****************************************************************************************************/
import java.util.Scanner;
public class Ejercicio11_DiaDeLaSemana {
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		byte btyNum;
		
		System.out.println("Introduzca un n�mero: ");
		btyNum = scEntrada.nextByte();
		
		switch(btyNum) {
			case 1:{
				System.out.println("LUNES");
				break;
			}
			case 2:{
				System.out.println("MARTES");
				break;
			}
			case 3:{
				System.out.println("MI�RCOLES");
				break;
			}
			case 4:{
				System.out.println("JUEVES");
				break;
			}
			case 5:{
				System.out.println("VIERNES");
				break;
			}
			case 6:{
				System.out.println("S�BADO");
				break;
			}
			case 7:{
				System.out.println("DOMINGO");
				break;
			}
			default:
				System.out.println("Valor introducido no v�lido.");
		}
	}
}
