package tema12_Colecciones.ejerciciosResueltos.ejercicioResuelto09_IndicesPares.inicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Scanner para la entrada de datos.
        List<Integer> listado = new ArrayList<>(); //ArrayList que se comporta como una lista.
        Integer integer = null; //Integer que guardará el número del usuario.

        do {
            System.out.print("Dime un número (negativo para terminar): ");
            try {
                integer = Integer.parseInt(scEntrada.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debes introducir un número.");
            }
        } while (integer == null);

        while (integer >= 0) {
            listado.add(integer);
            integer = null;
            do {
                System.out.print("Dime un número (negativo para terminar): ");
                try {
                    integer = Integer.parseInt(scEntrada.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Debes introducir un número.");
                }
            } while (integer == null);
        }

        scEntrada.close();

        System.out.println("Listado completo: " + listado);
        System.out.print("Índices de valores pares: ");

        for (int intCont = 0; intCont < listado.size(); intCont++) {
            if (listado.get(intCont) % 2 == 0) {
                System.out.print(intCont + " ");
                listado.set(intCont, listado.get(intCont) * 100);
            }
        }

        System.out.println();
        System.out.println("Listado tras los cambios: " + listado);
    }
}
