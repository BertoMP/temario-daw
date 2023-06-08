package tema12_Colecciones.ejerciciosResueltos.ejercicioResuelto04_ColeccionNumeros.clases;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Collection<Integer> listadoNumeros = new ArrayList<>(); //Objeto ArrayList que se comporta como una colección.
        Scanner scEntrada = new Scanner(System.in); //Scanner para la entrada de objetos.
        Integer integer = null; //Integer para la recogida de datos.

        do {
            try {
                System.out.print("Dime un número a introducir en el listado (-1 para finalizar): ");
                integer = Integer.parseInt(scEntrada.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("El número introducido no es válido.");
            }
        } while (integer == null);

        while (integer != -1) {
            listadoNumeros.add(integer);
            integer = null;
            do {
                try {
                    System.out.print("Dime un número a introducir en el listado (-1 para finalizar): ");
                    integer = Integer.parseInt(scEntrada.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("El número introducido no es válido.");
                }
            } while (integer == null);
        }

        scEntrada.close();

        System.out.println("Todos los números -> " + listadoNumeros);
        System.out.print("Numeros pares -> " );
        for (Integer integerValor : listadoNumeros) {
            if (integerValor % 2 == 0) {
                System.out.print(integerValor + " ");
            }
        }
        System.out.println();
        for (Iterator<Integer> iterador = listadoNumeros.iterator(); iterador.hasNext();) {
            integer = iterador.next();
            if (integer % 3 == 0) {
                iterador.remove();
            }
        }
        System.out.println("Listado números sin múltiplos de 3 -> " + listadoNumeros);
    }
}
