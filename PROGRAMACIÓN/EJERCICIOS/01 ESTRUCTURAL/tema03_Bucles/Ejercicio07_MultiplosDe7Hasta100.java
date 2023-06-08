package tema03_Bucles.actividades;
public class Ejercicio07_MultiplosDe7Hasta100 {
	/************************************************************
	 * 															*
	 * Escribir todos los m�ltiplos de 7 menores que 100.		*
	 * 															*
	 ************************************************************/
	public static void main(String[] args) {
		//BUCLE (se elige for porque se conoce inicio y fin, iterador a 0, condici�n "menor de 100" y paso o itinerancia a 7 para s�lo sacar los m�ltiplos de 7)
		for (int i = 0; i < 100; i += 7) {
			//IMPRESI�N DE RESULTADOS
			System.out.print(i + " ");
		}

	}
}
