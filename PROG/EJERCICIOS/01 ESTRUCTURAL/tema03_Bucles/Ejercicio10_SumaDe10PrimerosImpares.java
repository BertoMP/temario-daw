package tema03_Bucles.actividades;
public class Ejercicio10_SumaDe10PrimerosImpares {
	/************************************************************************
	 * 																		*
	 * Dise�ar un programa que muestre la suma de los 10 primeros impares.	*
	 * 																		*
	 ************************************************************************/
	public static void main(String[] args) {
		//DECLARACI�N VARIABLES
		int intSuma = 0; //variable para guardar la suma de los n�meros
		//BUCLE (se elige for porque se sabe el inicio, el fin y la itinerancia)
		for (int i = 1; i <= 19; i+=2) { //se inicia el bucle en el 1 y se termina en 19 -10� impar- y con itinerancia 2 (1,3,5,7...)
			intSuma += i; //esto es lo mismo que intSuma = intSuma + i;
		}
		
		//IMPRESI�N RESULTADOS
		System.out.print("La suma de los 10 primeros impares es: " + intSuma);
	}
}