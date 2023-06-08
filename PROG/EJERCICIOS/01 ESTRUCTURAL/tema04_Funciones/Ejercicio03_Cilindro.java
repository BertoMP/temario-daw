package tema04_Funciones.actividades;

import java.util.Scanner;

//Crear un programa en el que mediante una funcion se calcule el area o el volumen de un cilindro (a peticion del usuario)
public class Ejercicio03_Cilindro {
	/********************************************************************************
	 * 																				*
	 * Funcion para el calculo del area o volumen de un cilindro a partir de		* 
	 * su altura y radio.															*
	 * @param rlnAltura --> altura del cilindro										*
	 * @param rlnRadio --> radio del cilindro										*
	 * @param bytOpcionElegida --> opcion del usuario para elegir area o volumen	*
	 * 																				*
	 ********************************************************************************/
	//La funcion sera void porque no devolvera ningun valor, realizara el proceso directamente.
	public static void areaVolumenCilindro(double rlnAltura, double rlnRadio, byte bytOpcionElegida) {
		
		switch (bytOpcionElegida) {
		case 1:
			double rlnArea;
			rlnArea = 2 * Math.PI * rlnRadio * (rlnAltura + rlnRadio);
			System.out.println("El area del cilindro es: " + rlnArea);
			break;
			
		case 2:
			double rlnVolumen;
			rlnVolumen = Math.PI * Math.pow(rlnRadio, 2);
			System.out.println("El volumen del cilindro es: " + rlnVolumen);
			break;
			
		default:
			System.out.println("La opción elegida no es correcta.");
		}
	}
	
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		
		double rlnAltura;
		double rlnRadio;
		byte bytOpcionElegida;
		
		System.out.println("Introduzca altura del cilindro: ");
		rlnAltura = scEntrada.nextDouble();
		
		System.out.println("Introduzca radio del cilindro: ");
		rlnRadio = scEntrada.nextDouble();
		
		System.out.println("Seleccione una opción:"
				+ "\n\t 1: Calcular el área."
				+ "\n\t 2: Calcular el volumen.");
		bytOpcionElegida = scEntrada.nextByte();
		
		scEntrada.close();
		
		//Llamada a la funcion areaVolumenCilindro() a la que se le introducen los parametros recogidos del usuario.
		areaVolumenCilindro(rlnAltura, rlnRadio, bytOpcionElegida);
	}

}
