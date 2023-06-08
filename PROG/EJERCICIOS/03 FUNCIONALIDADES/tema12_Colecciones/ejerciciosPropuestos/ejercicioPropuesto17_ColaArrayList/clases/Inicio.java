package tema12_Colecciones.ejerciciosPropuestos.ejercicioPropuesto17_ColaArrayList.clases;

import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Scanner para la entrada de datos.
        Cola<Integer> listadoNumeros = new Cola<>(); //Cola para guardar los números.

        //DECLARACIÓN DE VARIABLES
        int intPush; //Int para guardar el número a encolar.
        Integer integerPop; //Integer para guardar el número desencolado.

        System.out.println("Encolando...");
        for (int intCont = 0; intCont < 10;) {
            System.out.print("Dime el " + (intCont + 1) + "º número a encolar: ");
            try {
                intPush = Integer.parseInt(scEntrada.nextLine());
                listadoNumeros.push(intPush);
                intCont++;
                System.out.println("Cola actual: " + listadoNumeros);
            } catch (NumberFormatException e) {
                System.out.println("No se ha introducido un valor válido, no se añadirá.");
            }
        }

        scEntrada.close();

        System.out.println("\nDesencolando...");
        integerPop = listadoNumeros.pop();

        while (integerPop != null) {
            System.out.println("Número desencolado: " + integerPop);
            System.out.println("Números restantes en cola: " + listadoNumeros);
            integerPop = listadoNumeros.pop();
        }
    }
}
