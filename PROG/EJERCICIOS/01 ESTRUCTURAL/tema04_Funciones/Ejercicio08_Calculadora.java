package tema04_Funciones.actividades;

import java.util.Scanner;

public class Ejercicio08_Calculadora {
	/************************************************************************************
	 * 																					*
	 * Funcion para determinar el tipo de operacion a realizar con la calculadora		*
	 * @param rlnNumUsuario1 --> primer numero introducido por el usuario				*
	 * @param rlnNumUsuario2 --> segundo numero introducido por el usuario				*
	 * @param bytOpcionElegida --> opcion de operacion elegida por el usuario			*
	 * 																					*
	 ************************************************************************************/
	//La funcion debe ser void ya que no devolverá ningún valor, realizará las operaciones dentro de la funcion.
	public static void calculadora(double rlnNumUsuario1, double rlnNumUsuario2, byte bytOpcionElegida) {
		double rlnResultado;
		
		switch(bytOpcionElegida) {
			case 1:
				rlnResultado = rlnNumUsuario1 + rlnNumUsuario2;
				System.out.println(rlnNumUsuario1 + " + " + rlnNumUsuario2 + " = " + rlnResultado);
				break;
			
			case 2:
				rlnResultado = rlnNumUsuario1 - rlnNumUsuario2;
				System.out.println(rlnNumUsuario1 + " - " + rlnNumUsuario2 + " = " + rlnResultado);
				break;
			
			case 3:
				rlnResultado = rlnNumUsuario1 * rlnNumUsuario2;
				System.out.println(rlnNumUsuario1 + " * " + rlnNumUsuario2 + " = " + rlnResultado);
				break;
			
			case 4:
				if(rlnNumUsuario2 == 0) {
					System.out.println("Es imposible dividir entre 0.");
				}else {
					rlnResultado = rlnNumUsuario1 / rlnNumUsuario2;
					System.out.println(rlnNumUsuario1 + " / " + rlnNumUsuario2 + " = " + rlnResultado);
				}
				break;
			
			default:
				System.out.println("La opción elegida no es válida.");
		}
	}
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		
		double rlnNumUsuario1;
		double rlnNumUsuario2;
		byte bytOpcionElegida;
		
		System.out.print("Introduzca un numero: ");
		rlnNumUsuario1 = scEntrada.nextDouble();
		
		System.out.print("Introduzca otro numero: ");
		rlnNumUsuario2 = scEntrada.nextDouble();
		
		System.out.print("Elija una opcion:"
				+"\n\t 1. SUMAR"
				+"\n\t 2. RESTAR"
				+"\n\t 3. MULTIPLICAR"
				+"\n\t 4. DIVIDIR"
				+"\nOPCION: ");
		bytOpcionElegida = scEntrada.nextByte();
		
		scEntrada.close();
		
		calculadora(rlnNumUsuario1, rlnNumUsuario2, bytOpcionElegida);
	}
}
