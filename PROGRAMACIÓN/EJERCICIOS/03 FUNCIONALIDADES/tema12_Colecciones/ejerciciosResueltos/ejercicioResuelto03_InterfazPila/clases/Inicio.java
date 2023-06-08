package tema12_Colecciones.ejerciciosResueltos.ejercicioResuelto03_InterfazPila.clases;

import tema12_Colecciones.ejerciciosResueltos.ejercicioResuelto03_InterfazPila.interfaces.Pila;

import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Pila<Integer> pila = new Contenedor<>(new Integer[0]); //Objeto Contenedor utilizado como Pila.
        Scanner scEntrada = new Scanner(System.in); //Scanner para la entrada de datos.
        Integer integerEntrada = null; //Integer de entrada.
        Integer integerRetorno; //Integer de retorno.

        do {
            System.out.println("Introduce un número entero positivo (-1 para terminar): ");
            try {
                integerEntrada = Integer.parseInt(scEntrada.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Se ha introducido un valor no válido");
            }
        } while (integerEntrada == null);

        scEntrada.close();

        while (integerEntrada != -1) {
            pila.push(integerEntrada);

            do {
                System.out.println("Introduce un número entero positivo (-1 para terminar): ");
                try {
                    integerEntrada = null;
                    integerEntrada = Integer.parseInt(scEntrada.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Se ha introducido un valor no válido");
                }
            } while (integerEntrada == null);
        }

        System.out.println("DESAPILANDO...");
        integerRetorno = pila.pop();

        while (integerRetorno != null) {
            System.out.println(integerRetorno);
            integerRetorno = pila.pop();
        }
    }
}
