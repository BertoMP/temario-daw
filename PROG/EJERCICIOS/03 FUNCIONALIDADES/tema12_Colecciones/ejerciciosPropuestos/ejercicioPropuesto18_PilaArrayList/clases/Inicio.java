package tema12_Colecciones.ejerciciosPropuestos.ejercicioPropuesto18_PilaArrayList.clases;

import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Scanner para la entrada de datos.
        Pila<Integer> listadoNumeros = new Pila<>(); //Pila para guardar los números.

        //DECLARACIÓN DE VARIABLES
        int intPush; //Int para guardar el número a encolar.
        Integer integerPop; //Integer para guardar el número desencolado.

        System.out.println("Apilando...");
        for (int intCont = 0; intCont < 10;) {
            System.out.print("Dime el " + (intCont + 1) + "º número a apilar: ");
            try {
                intPush = Integer.parseInt(scEntrada.nextLine());
                listadoNumeros.push(intPush);
                System.out.println("Pila actual: " + listadoNumeros);
                intCont++;
            } catch (NumberFormatException e) {
                System.out.println("El valor introducido no es válido. No se introducirá en pila.");
            }
        }

        System.out.println("\nDesapilando...");
        integerPop = listadoNumeros.pop();

        while (integerPop != null) {
            System.out.println("El número desapilado es: " + integerPop);
            System.out.println("Pila actual: " + listadoNumeros);
            integerPop = listadoNumeros.pop();
        }
    }
}
