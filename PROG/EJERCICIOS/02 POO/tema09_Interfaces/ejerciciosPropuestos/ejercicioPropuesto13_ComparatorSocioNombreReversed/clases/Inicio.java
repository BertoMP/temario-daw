package tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto13_ComparatorSocioNombreReversed.clases;

import tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto13_ComparatorSocioNombreReversed.comparadores.ComparadorSocioNombre;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal de la clase.                                                               *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Objeto de tipo Scanner.
        ComparadorSocioNombre comparadorSocioNombre = new ComparadorSocioNombre(); //Objeto de tipo ComparadorSocioNombre.

        //DECLARACIÓN DE VARIABLES
        Socio[] arrSocios = { //Array de objetos de tipo Socio.
                new Socio(5,"Pepe", 20, LocalDate.parse("2003-02-18")),
                new Socio(7,"María", 18, LocalDate.parse("2004-05-30")),
                new Socio(2,"Julio", 27, LocalDate.parse("1995-08-03")),
                new Socio(6,"Sofía", 20, LocalDate.parse("2003-01-07")),
                new Socio(9,"Alejandro", 21, LocalDate.parse("2001-07-09")),
                new Socio(12,"Andrés", 19, LocalDate.parse("2004-09-12")),
                new Socio(23,"Paula", 22, LocalDate.parse("2000-09-02")),
                new Socio(1,"Clara", 27, LocalDate.parse("1995-09-01")),
                };
        int intOpcion; //Int que guarda la opción del usuario en el menú.

        do {
            System.out.println("""
                Elige una opción:
                    1. Crear nuevo socio.
                    2. Ver socios ordenados por fecha de nacimiento.
                    3. Ver socios ordenados por nombre (A-Z).
                    4. Ver socios ordenados por nombre (Z-A).
                    5. Salir.""");
            System.out.print("Opción: ");
            intOpcion = Integer.parseInt(scEntrada.nextLine());

            switch (intOpcion) {
                case 1 -> {
                    arrSocios = Arrays.copyOf(arrSocios, arrSocios.length + 1);
                    arrSocios[arrSocios.length - 1] = generaSocio(scEntrada);
                }
                case 2 -> {
                    Arrays.sort(arrSocios);
                    System.out.println("Socios ordenados por fecha de nacimiento.");
                    Inicio.imprimeSocios(arrSocios);
                }
                case 3 -> {
                    Arrays.sort(arrSocios, comparadorSocioNombre);
                    System.out.println("Socios ordenados por nombre (A-Z).");
                    Inicio.imprimeSocios(arrSocios);
                }
                case 4 -> {
                    Arrays.sort(arrSocios,comparadorSocioNombre.reversed());
                    System.out.println("Socios ordenados por nombre (Z-A).");
                    Inicio.imprimeSocios(arrSocios);
                }
                case 5 -> System.out.println("Finalizando aplicación...");
                default -> System.out.println("Opción no válida.");
            }
            System.out.println();
        } while (intOpcion != 5);
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
        LocalDate fechaNacimiento; //LocalDate que guarda la fecha de nacimiento del socio.

        System.out.print("Dime ID del socio: ");
        intId = Integer.parseInt(scEntrada.nextLine());
        System.out.print("Dime nombre del socio: ");
        strNombre = scEntrada.nextLine();
        System.out.print("Dime edad del socio: ");
        intEdad = Integer.parseInt(scEntrada.nextLine());
        System.out.print("Dime fecha de nacimiento (formato dd/mm/aaaa): ");
        fechaNacimiento = LocalDate.parse(scEntrada.nextLine());

        return new Socio(intId, strNombre, intEdad, fechaNacimiento);
    }

    /*******************************************************************************************************************
     * Método encargado de imprimir el array de socios.                                                                *
     *                                                                                                                 *
     * @param array Array de socios.                                                                                   *
     *******************************************************************************************************************/
    private static void imprimeSocios(Socio[] array) {
        for (int intCont = 0; intCont < array.length; intCont++) {
            System.out.println("[" + (intCont + 1) + "] " + array[intCont]);
        }
    }
}
