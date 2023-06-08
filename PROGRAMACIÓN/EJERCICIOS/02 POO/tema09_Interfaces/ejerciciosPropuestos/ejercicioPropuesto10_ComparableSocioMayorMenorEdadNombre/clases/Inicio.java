package tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto10_ComparableSocioMayorMenorEdadNombre.clases;

import java.util.Arrays;
import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal de la clase.                                                               *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Objeto de tipo Scanner.

        //DECLARACIÓN DE VARIABLES
        Socio[] arrSocios = { //Array de objetos de tipo Socio.
                new Socio(5,"Pepe", 20),
                new Socio(7,"María", 18),
                new Socio(2,"Julio", 27),
                new Socio(6,"Sofía", 20),
                new Socio(9,"Alejandro", 21),
                new Socio(12,"Andrés", 19),
                new Socio(23,"Paula", 22),
                new Socio(1,"Clara", 27),
                };
        int intOpcion; //Int que guarda la opción del usuario en el menú.

        do {
            System.out.println("""
                Elige una opción:
                    1. Crear nuevo socio.
                    2. Ver socios ordenados por edad.
                    3. Salir.""");
            System.out.print("Opción: ");
            intOpcion = Integer.parseInt(scEntrada.nextLine());

            switch (intOpcion) {
                case 1 -> {
                    arrSocios = Arrays.copyOf(arrSocios, arrSocios.length + 1);
                    arrSocios[arrSocios.length - 1] = generaSocio(scEntrada);
                }
                case 2 -> {
                    Arrays.sort(arrSocios);
                    System.out.println("Socios ordenados por edad");
                    for (int intCont = 0; intCont < arrSocios.length; intCont++) {
                        System.out.println("[" + (intCont + 1) + "] " + arrSocios[intCont]);
                    }
                }
                case 3 -> System.out.println("Finalizando aplicacion...");
                default -> System.out.println("Opción no válida.");
            }
            System.out.println();
        } while (intOpcion != 3);
        scEntrada.close();
    }

    /*******************************************************************************************************************
     * Método encargado de generar objetos de tipo Socio.                                                              *
     *                                                                                                                 *
     * @param scEntrada Objeto de tipo Scanner.                                                                        *
     * @return Devuelve un objeto de tipo Socio.                                                                       *
     *******************************************************************************************************************/
    private static Socio generaSocio(Scanner scEntrada) {
        //DECLARACIÓN DE VARIABLES
        int intId; //Int que guarda el ID del socio.
        String strNombre; //String que guarda el nombre del socio.
        int intEdad; //Int que guarda la edad del socio.

        System.out.print("Dime ID del socio: ");
        intId = Integer.parseInt(scEntrada.nextLine());
        System.out.print("Dime nombre del socio: ");
        strNombre = scEntrada.nextLine();
        System.out.print("Dime edad del socio: ");
        intEdad = Integer.parseInt(scEntrada.nextLine());

        return new Socio(intId, strNombre, intEdad);
    }
}
