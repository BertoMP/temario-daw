package tema02_Condicionales.actividades;

/****************************************************************************************
 * 																						*
 * Pedir una nota entera entre 0 y 10 y mostrarla de la siguiente forma: insuficiente 	*
 * (de 0 a 4), suficiente (5), bien (6), notable (7 y 8) y sobresaliente (9 y 10).		*
 *																						*
 ****************************************************************************************/
import java.util.Scanner;
public class Ejercicio10_NotasAlumnosSwitch {
	public static void main(String[] args) {
		byte btyNotaAlumno;
		Scanner scEntrada = new Scanner(System.in);
		
		System.out.print("Introduzca nota del alumno: ");
		btyNotaAlumno = scEntrada.nextByte();
		
		switch(btyNotaAlumno) {
			case 0,1,2,3,4:{
				System.out.println("INSUFICIENTE.");
				break;
			}
			case 5:{
				System.out.println("SUFICIENTE");
				break;
			}
			case 6:{
				System.out.println("BIEN");
				break;
			}
			case 7,8:{
				System.out.println("NOTABLE");
				break;
			}
			case 9,10:{
				System.out.println("SOBRESALIENTE");
				break;
			}
			default:
				System.out.println("Valor introducido no v�lido.");
		}
	}
}
