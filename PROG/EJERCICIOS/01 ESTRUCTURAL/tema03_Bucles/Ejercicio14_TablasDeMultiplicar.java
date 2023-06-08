package tema03_Bucles.actividades;
public class Ejercicio14_TablasDeMultiplicar {
	/********************************************************************************
	 * 																				*
	 * Dise�ar una aplicaci�n que muestre las tablas de multiplicar del 1 al 10.	*
	 * 																				*
	 ********************************************************************************/
	public static void main(String[] args) {
		//BUCLE 1 (sirve para ir de 1 a 10 en el m�ltiplo 1)
		for (int i = 1; i <= 10; i++) {
			System.out.println("\nTABLA DEL " + i);
			
			//BUCLE 2 (sirve para ir de 1 a 10 en el m�ltiplo 2)
			for (int j = 1; j <= 10; j++) {
				int intMultiplicacion;
				intMultiplicacion = i * j; //c�lculo de las multiplicaciones
				
				//IMPRESI�N DE RESULTADOS
				System.out.println(i + " X " + j + " = " + intMultiplicacion);
			}
		}
	}
}