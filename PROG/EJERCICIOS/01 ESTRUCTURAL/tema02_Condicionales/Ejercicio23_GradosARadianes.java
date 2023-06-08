package tema02_Condicionales.actividades;
/************************************************************************************************************************
 * 																														*
 * Crea una aplicacion que solicite al usuario cuantos grados tiene un angulo y muestre el equivalente en radianes.		*
 * Si el angulo introducido por el usuario no se encuentra en el rango de 0 a 360 hay que transformarlo a dicho			*
 * rango.																												*
 * Nota: El operador modulo puede ayudarnos a convertir un angulo a su equivalente en el rango comprendido 				*
 * de 0 a 360.																											*
 *																														*
 ************************************************************************************************************************/
import java.util.Scanner;
public class Ejercicio23_GradosARadianes {
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		int intAngulo; //variable para guardar el angulo introducido por el usuario
		int intAnguloCambiado; //variable para guardar el angulo final en caso de introducir un angulo por encima de los 360�
		double rlnRadianes; //variable para guardar el valor del angulo en radianes
		
		System.out.print("Introduzca un angulo: ");
		intAngulo = scEntrada.nextInt();
		
		/****************************************************************************************
		 * 																						*
		 * Lo primero que habr� que comprobar es si el angulo que ha introducido es				*
		 * superior a superior a 360 grados, en cuyo caso habr� que sacar el m�dulo				*
		 * de la division entera del angulo del usuario / 360 (por ejemplo, si introduce		*
		 * 390� el resto ser�an 30, esos 30 ser�an los grados del angulo a calcular).			*
		 * 																						*
		 * A continuaci�n hay que pasar ese angulo (bien intAnguloCambiado si el angulo			*
		 * es superior a 360, bien intAngulo si no lo es) a radianes. La formula para el paso	*
		 * de grados a radianes es: angulo * (PI / 180).										*
		 * 																						*
		 * Para PI tenemos dos opciones:														*
		 * 																						*
		 * 	- Declarar una variable constante (por ejemplo, final double PI = 3.1416)			*
		 * 	- Usar el campo PI de la clase Math.												*
		 * 																						*
		 ****************************************************************************************/
		
		if(intAngulo > 360) {
			intAnguloCambiado = intAngulo % 360;
			rlnRadianes = intAnguloCambiado * (Math.PI / 180);
		} else {
			rlnRadianes = intAngulo * (Math.PI / 180);
		}
		
		System.out.println("El angulo " + intAngulo + " equivale a " + rlnRadianes + " radianes.");
	}
}
