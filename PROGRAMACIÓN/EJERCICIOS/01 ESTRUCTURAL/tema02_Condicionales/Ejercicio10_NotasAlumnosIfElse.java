package tema02_Condicionales.actividades;

/****************************************************************************************
 * 																						*
 * Pedir una nota entera entre 0 y 10 y mostrarla de la siguiente forma: insuficiente 	*
 * (de 0 a 4), suficiente (5), bien (6), notable (7 y 8) y sobresaliente (9 y 10).		*
 *																						*
 ****************************************************************************************/
import java.util.Scanner;
public class Ejercicio10_NotasAlumnosIfElse {
	public static void main(String[] args) {
		byte btyNotaAlumno;
		Scanner scEntrada = new Scanner(System.in);
		
		System.out.print("Introduzca nota del alumno: ");
		btyNotaAlumno = scEntrada.nextByte();
		
		if(0 < btyNotaAlumno && btyNotaAlumno < 4) {
			System.out.println("INSUFICIENTE.");
		}else if(btyNotaAlumno == 5) {
			System.out.println("SUFICIENTE.");
		}else if(btyNotaAlumno == 6) {
			System.out.println("BIEN.");
		}else if(btyNotaAlumno == 7 || btyNotaAlumno == 8) {
			System.out.println("NOTABLE.");
		}else if(btyNotaAlumno == 9 || btyNotaAlumno == 9) {
			System.out.println("SOBRESALIENTE.");
		}
	}
}
