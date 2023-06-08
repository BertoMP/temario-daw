package tema03_Bucles.actividades;
import java.util.Scanner;
public class Ejercicio25_DineroTotal {
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		
		double rlnDineroBanco = 0;
		double rlnDineroHucha = 0;
		double rlnDineroCajon = 0;
		double rlnDineroBolsillos = 0;
		double rlnDineroTotal;
		int intOpcionElegida;
		
		do {
			System.out.println("\nSeleccione una opci�n:"
					+ "\n\t 1: BANCO" 
					+ "\n\t 2: HUCHA"
					+ "\n\t 3: CAJ�N"
					+ "\n\t 4: BOLSILLOS"
					+ "\n\t 0: SALIR Y PROCEDER A SUMA");
			System.out.print("OPCI�N: ");
			intOpcionElegida = scEntrada.nextInt();
			
			switch(intOpcionElegida) {
				case 0:{
					break;
				}
				case 1:{
					System.out.print("Introduzca dinero en el banco: ");
					rlnDineroBanco = scEntrada.nextDouble();
					break;
				}
				case 2:{
					System.out.print("Introduzca dinero en la hucha: ");
					rlnDineroHucha = scEntrada.nextDouble();
					break;
				}
				case 3:{
					System.out.print("Introduzca dinero en el caj�n: ");
					rlnDineroCajon = scEntrada.nextDouble();
					break;
				}
				case 4:{
					System.out.print("Introduzca dinero en los bolsillos: ");
					rlnDineroBolsillos = scEntrada.nextDouble();
					break;
				}
				default:{
					System.out.println("Opci�n elegida no v�lida.");
				}
			}
		}while(intOpcionElegida != 0);
		
		rlnDineroTotal = rlnDineroBanco + rlnDineroHucha + rlnDineroCajon + rlnDineroBolsillos;
		System.out.print("BANCO: " + rlnDineroBanco 
				+ "\nHUCHA: " + rlnDineroHucha
				+ "\nCAJ�N: " + rlnDineroCajon
				+ "\nBOLSILLOS: " + rlnDineroBolsillos
				+ "\nDINERO TOTAL: " + rlnDineroTotal);
	}
}
