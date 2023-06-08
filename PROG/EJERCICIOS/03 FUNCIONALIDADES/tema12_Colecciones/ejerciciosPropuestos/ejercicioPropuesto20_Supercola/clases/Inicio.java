package tema12_Colecciones.ejerciciosPropuestos.ejercicioPropuesto20_Supercola.clases;

import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada de controlar el desarrollo principal del programa.                                                  *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Objeto de tipo Scanner.
        Supercola supercola = new Supercola(); //Objeto de tipo Supercola.
        Integer intNum; //Integer que almacena el número a añadir.

        //DECLARACIÓN DE VARIABLES
        int intOpcion; //Int que guarda la opción del usuario en el menú.
        boolean blnOpcion; //Boolean con la opción elegida;

        do {
            System.out.println(supercola);

            intOpcion = muestraMenu(scEntrada);

            switch (intOpcion) {
                case 1, 2 -> {
                    blnOpcion = intOpcion == 1 ? true : false;
                    System.out.print("Dime número a encolar: ");
                    intNum = null;
                    do {
                        try {
                            intNum = scEntrada.nextInt();
                        } catch (NumberFormatException e) {
                            System.out.println("No se ha introducido un número entero.");
                        }
                    } while (intNum == null);
                    supercola.push(intNum, blnOpcion);
                }
                case 3, 4 -> {
                    blnOpcion = intOpcion == 1 ? true : false;
                    System.out.println("Elemento desencolado: " + supercola.pop(blnOpcion));
                }
                case 5 -> System.out.println("Finalizando aplicación...");
                default -> System.out.println("Opción elegida no válida.");
            }
            System.out.println();
        } while (intOpcion != 5);
        scEntrada.close();
    }

    /*******************************************************************************************************************
     * Método encargado de mostrar un menú y devolver la opción elegida por el usuario.                                *
     *                                                                                                                 *
     * @param scEntrada Scanner para la entrada de datos.                                                              *
     * @return Devuelve un int con el valor de la opción elegida por el usuario.                                       *
     *******************************************************************************************************************/
    private static int muestraMenu(Scanner scEntrada) {
        //DECLARACIÓN DE VARIABLES
        Integer integerOpcion = null; //Integer que almacena la opción elegida por el usuario.

        do {
            System.out.println("""
            Elige una opción:
                1. Encolar en cola 1.
                2. Encolar en cola 2.
                3. Desencolar de cola 1.
                4. Desencolar de cola 2.
                5. Salir.""");
            System.out.print("Opción: ");
            try {
                integerOpcion = Integer.parseInt(scEntrada.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("No se ha introducido un número. Vuelve a intentarlo.");
            }
        } while (integerOpcion == null);
        return integerOpcion;
    }
}
