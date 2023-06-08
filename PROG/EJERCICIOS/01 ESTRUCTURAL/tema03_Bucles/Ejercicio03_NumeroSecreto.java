package tema03_Bucles.actividades;
import java.util.Scanner;
public class Ejercicio03_NumeroSecreto {
	/************************************************************************************************************************
	 * 																														*
	 * Codificar el juego “el número secreto”, que consiste en acertar un número entre 1 y 100 (generado aleatoriamente).	*
	 * Para ellos se introduce por teclado una serie de números, para los que se indica: “mayor” o “menor”, según sea		*
	 * mayor o menor con respecto al número secreto. El proceso termina cuando el usuario acierta o cuando se rinde			*
	 * (introduciendo un -1). 																								*
	 * 																														*
	 ************************************************************************************************************************/
	public static void main(String[] args) {
		//CREACIÓN DE ESCANER Y DE VARIABLES
		Scanner scEntrada = new Scanner(System.in);
		int intNumSecreto; //variable para guardar el número aleatorio que habrá que adivinar
		int intNumUsuario; //variable para guardad los diferentes números que pruebe el usuario para acertar
		String strRespuesta; //variable String para el ternario que avisará si el número secreto es mayor o menor que el introducido
		String strRespuestaFinal; //variable String para el ternario final en función de si el usuario acierta o se rinde
		
		//CREACIÓN DEL NÚMERO SECRETO
		intNumSecreto = (int) (Math.random() * 100 + 1); /* como es de 1 a 100, Math.random debe ser multiplicado por 100 y debe añadírsele 1.
														    Además se tipea a int para guardarlo como número entero. */	
		//SOLICITUD DEL PRIMER NÚMERO
		System.out.print("Introduzca un número: ");
		intNumUsuario = scEntrada.nextInt();
		
		//BUCLE WHILE (se elige while porque es posible que el usuario acierte el número a la primera sin necesidad de bucle)
		while(intNumUsuario != intNumSecreto && intNumUsuario != -1) { //condicionales de salida serían acertar el número y que el número sea -1 
			strRespuesta = (intNumSecreto > intNumUsuario) ? "Mayor" : "Menor"; //ternario para mayor/menor
			System.out.print(strRespuesta);
			
			//SOLICITUD DEL RESTO DE NÚMEROS DENTRO DEL BUCLE
			System.out.println("\nIntroduzca otro número (-1 para rendirte): ");
			intNumUsuario = scEntrada.nextInt();
		}
		
		//IMPRESIÓN DE RESPUESTA FINAL
		strRespuestaFinal = (intNumUsuario == intNumSecreto) ? "Correcto!" : "El número era el " + intNumSecreto + "."; /* ternario para la respuesta fina
																														  en función de acierto o rendición */
		System.out.println(strRespuestaFinal);
	}
}
