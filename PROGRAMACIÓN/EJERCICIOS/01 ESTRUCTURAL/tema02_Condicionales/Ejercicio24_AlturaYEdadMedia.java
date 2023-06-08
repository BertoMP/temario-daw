package tema02_Condicionales.actividades;
import java.util.Scanner;
/* **************************************************************
 * 																*
 * Dadas las edades y alturas de 5 alumnos, mostrar la edad 	*
 * y la estatura media, la cantidad de alumnos mayores de 18	*
 * a�os, y la cantidad de alumnos que miden m�s de 1.75.		*
 * 																*
 ****************************************************************/
public class Ejercicio24_AlturaYEdadMedia {
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		
		int intEdadAlumno;
		double rlnAlturaAlumno;
		
		int intEdadTotalAlumnos = 0;
		double rlnAlturaTotalAlumnos = 0;
		
		double rlnEdadMedia;
		double rlnAlturaMedia;
		
		int intContadorMayoresEdad = 0;
		int intContadorAltos = 0;
		
		System.out.println("Introduzca los datos del alumno 1:");
		System.out.print("Altura: ");
		intEdadAlumno = scEntrada.nextInt();
		intEdadTotalAlumnos += intEdadAlumno;
		System.out.print("Edad: ");
		rlnAlturaAlumno = scEntrada.nextDouble();
		rlnAlturaTotalAlumnos += rlnAlturaAlumno;
		if(intEdadAlumno >= 18){
			intContadorMayoresEdad++;
		}
		if(rlnAlturaAlumno > 1.75) {
			intContadorAltos++;
		}
		
		System.out.println("\nIntroduzca los datos del alumno 2:");
		System.out.print("Altura: ");
		intEdadAlumno = scEntrada.nextInt();
		intEdadTotalAlumnos += intEdadAlumno;
		System.out.print("Edad: ");
		rlnAlturaAlumno = scEntrada.nextDouble();
		rlnAlturaTotalAlumnos += rlnAlturaAlumno;
		if(intEdadAlumno >= 18){
			intContadorMayoresEdad++;
		}
		if(rlnAlturaAlumno > 1.75) {
			intContadorAltos++;
		}
		
		System.out.println("\nIntroduzca los datos del alumno 3:");
		System.out.print("Altura: ");
		intEdadAlumno = scEntrada.nextInt();
		intEdadTotalAlumnos += intEdadAlumno;
		System.out.print("Edad: ");
		rlnAlturaAlumno = scEntrada.nextDouble();
		rlnAlturaTotalAlumnos += rlnAlturaAlumno;
		if(intEdadAlumno >= 18){
			intContadorMayoresEdad++;
		}
		if(rlnAlturaAlumno > 1.75) {
			intContadorAltos++;
		}
		
		System.out.println("\nIntroduzca los datos del alumno 4:");
		System.out.print("Altura: ");
		intEdadAlumno = scEntrada.nextInt();
		intEdadTotalAlumnos += intEdadAlumno;
		System.out.print("Edad: ");
		rlnAlturaAlumno = scEntrada.nextDouble();
		rlnAlturaTotalAlumnos += rlnAlturaAlumno;
		if(intEdadAlumno >= 18){
			intContadorMayoresEdad++;
		}
		if(rlnAlturaAlumno > 1.75) {
			intContadorAltos++;
		}
		
		System.out.println("\nIntroduzca los datos del alumno 5:");
		System.out.print("Altura: ");
		intEdadAlumno = scEntrada.nextInt();
		intEdadTotalAlumnos += intEdadAlumno;
		System.out.print("Edad: ");
		rlnAlturaAlumno = scEntrada.nextDouble();
		rlnAlturaTotalAlumnos += rlnAlturaAlumno;
		if(intEdadAlumno >= 18){
			intContadorMayoresEdad++;
		}
		if(rlnAlturaAlumno > 1.75) {
			intContadorAltos++;
		}
		
		rlnEdadMedia = intEdadTotalAlumnos / 5;
		rlnAlturaMedia = rlnAlturaTotalAlumnos / 5;
		
		System.out.println("\nDATOS FINALES" +
						   "\n\tEdad media: " + rlnEdadMedia + " a�os." +
						   "\n\tAltura media: " + rlnAlturaMedia + " metros." +
						   "\n\tAlumnos mayores de edad: " + intContadorMayoresEdad + " alumnos." +
						   "\n\tAlumnos altos (m�s de 1.75m): " + intContadorAltos + " alumnos.");
	}
}
