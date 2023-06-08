package tema02_Condicionales.actividades;

/********************************************************************************************
 * 																							*
 * Pedir el d�a, mes y a�o de una fecha e indicar si la fecha es correcta. Hay que tener 	*
 * en cuenta que existen meses con 28, 30 y 31 d�as (no se considerar� los a�os bisiestos).	*
 *																							*
 ********************************************************************************************/
import java.util.Scanner;
public class Ejercicio12_FechaValidaIfElse {
	public static void main(String[] args) {
		Scanner scEntrada = new Scanner(System.in);
		byte btyDia, btyMes;
		int intAnno;
		boolean blnFechaValida;
		
		System.out.print("Introduzca el d�a: ");
		btyDia = scEntrada.nextByte();
		System.out.print("Introduzca el mes: ");
		btyMes = scEntrada.nextByte();
		System.out.print("Introduzca el a�o: ");
		intAnno = scEntrada.nextInt();
		
		if(intAnno == 0) {
			blnFechaValida = false;
			}else {
				if(btyMes == 2 && (btyDia >= 1 && btyDia <= 28)) {
					blnFechaValida = true;
					}else if((btyMes == 4 || btyMes == 6 || btyMes == 9 || btyMes == 11) && ((btyDia >= 1) && (btyDia <= 30))) {
						blnFechaValida = true;
						}else if((btyMes == 1 || btyMes == 3 || btyMes == 5 || btyMes == 7 || btyMes == 8 || btyMes == 10 || btyMes == 12) 
									&& ((btyDia >= 1) && (btyDia <=31))) {
							blnFechaValida = true;
							}else {
								blnFechaValida = false;
							}
			}
		if(blnFechaValida) {
			System.out.println("Fecha v�lida. Fecha: " + btyDia + "/" + btyMes + "/" + intAnno);
			}else {
				System.out.println("Fecha no v�lida.");
			}
	}
}
