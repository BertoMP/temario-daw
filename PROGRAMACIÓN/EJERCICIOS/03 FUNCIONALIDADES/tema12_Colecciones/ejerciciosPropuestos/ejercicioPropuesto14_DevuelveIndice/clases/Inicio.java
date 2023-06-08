package tema12_Colecciones.ejerciciosPropuestos.ejercicioPropuesto14_DevuelveIndice.clases;

import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Contenedor<Integer> contenedor = new Contenedor<>(new Integer[0]); //Objeto de tipo Contenedor que contendrá los números.
        Integer integerUsuario = null; //Integer con el número del usuario.

        for (int intCont = 0; intCont < 30; intCont++) {
            contenedor.insertarAlFinal((int) (Math.random() * 10) + 1);
        }

        System.out.println(contenedor);

        do {
            System.out.print("Dime un índice: ");
            try {
                integerUsuario = Integer.parseInt(new Scanner(System.in).nextLine());
            } catch (NumberFormatException e) {
                System.out.println("El valor introducido no es numérico. Vuelve a intentarlo.");
            }
        } while (integerUsuario == null);

        System.out.println("En el índice " + integerUsuario + " está el número " + contenedor.get(integerUsuario) + ".");

    }
}
