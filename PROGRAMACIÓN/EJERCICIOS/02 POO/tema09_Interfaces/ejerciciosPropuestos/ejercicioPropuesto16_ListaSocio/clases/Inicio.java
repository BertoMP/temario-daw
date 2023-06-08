package tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto16_ListaSocio.clases;

import java.time.LocalDate;
import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada del control principal del programa.                                                                 *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Objeto de tipo Scanner.
        Lista nuevaLista = new Lista(); //Objeto de tipo Lista.
        Lista otraLista = new Lista(); //Objeto de tipo Lista.
        Socio socio; //Objeto de tipo Socio.

        //DECLARACIÓN DE VARIABLES
        int intOpcionUsuario; //Variable que guardará la opción del usuario.
        int intValor; //Variable que guardará un valor a pasar por parámetro.
        int intPosicion; //Variable que guardará una posición de la lista.
        int intRetorno; //Variable que guardará un Integer que se reciba como return de método.
        int intOpcion; //Variable que guarda una opción del usuario en los menús.

        //LISTA POR DEFECTO
        nuevaLista.insertarFinal(new Socio(5,"Pepe", 20, LocalDate.parse("2003-02-18")));
        nuevaLista.insertarFinal(new Socio(7,"María", 18, LocalDate.parse("2004-05-30")));
        nuevaLista.insertarPrincipio(new Socio(2,"Julio", 27, LocalDate.parse("1995-08-03")));
        nuevaLista.insertarPrincipio(new Socio(6,"Sofía", 20, LocalDate.parse("2003-01-07")));
        nuevaLista.insertarFinal(new Socio(9,"Alejandro", 21, LocalDate.parse("2001-07-09")));
        nuevaLista.insertarFinal(new Socio(12,"Andrés", 19, LocalDate.parse("2004-09-12")));
        nuevaLista.insertarPrincipio(new Socio(23,"Paula", 22, LocalDate.parse("2000-09-02")));
        nuevaLista.insertarPrincipio(new Socio(1,"Clara", 27, LocalDate.parse("1995-09-01")));

        do {
            System.out.println("""
                Elige una opción:
                    1. Obtener el número de elementos insertados en la lista.
                    2. Insertar un socio al final de la lista.
                    3. Insertar un socio al principio de la lista.
                    4. Insertar un socio en un lugar de a lista cuyo índice se pasa como parámetro.
                    5. Añadir al final de la lista los elementos de otra lista que se pasa como parámetro.
                    6. Eliminar un elemento cuyo índice en la lista se pasa como parámetro.
                    7. Obtener el elemento cuyo índice se pasa como parámetro.
                    8. Buscar un socio en la lista, devolviendo el índice del primer lugar donde se encuentre.
                       Si no está devolverá -1.
                    9. Mostrar los elementos de la lista por consola.
                    10. Ordenar socios de forma natural (por edad).
                    11. Salir.""");
            System.out.print("OPCIÓN: ");
            intOpcionUsuario = Integer.parseInt(scEntrada.nextLine());
            switch (intOpcionUsuario) {
                case 1 -> System.out.println("El número de elementos es: " + nuevaLista.numeroElementos());
                case 2 -> {
                    socio = generaSocio(scEntrada);
                    nuevaLista.insertarFinal(socio);
                }
                case 3 -> {
                    socio = generaSocio(scEntrada);
                    nuevaLista.insertarPrincipio(socio);
                }
                case 4 -> {
                    socio = generaSocio(scEntrada);
                    System.out.print("Dime posición en la que introducirlo: ");
                    intPosicion = Integer.parseInt(scEntrada.nextLine());
                    nuevaLista.insertarPosicion(intPosicion, socio);
                }
                case 5 -> {
                    do {
                        socio = generaSocio(scEntrada);
                        otraLista.insertarFinal(socio);
                        System.out.println("""
                            ¿Quieres añadir otra persona?
                                1. Sí.
                                2. No.""");
                        System.out.print("Opción: ");
                        intOpcion = Integer.parseInt(scEntrada.nextLine());
                    } while (intOpcion != 2);
                    nuevaLista.insertarFinal(otraLista);
                }
                case 6 -> {
                    System.out.print("Dime el índice que quieres eliminar: ");
                    intValor = Integer.parseInt(scEntrada.nextLine());
                    nuevaLista.eliminar(intValor);
                }
                case 7 -> {
                    System.out.print("Dime el índice que quieras conocer: ");
                    intValor = scEntrada.nextInt();
                    socio = nuevaLista.dimeObjeto(intValor);
                    System.out.println((socio != null)
                            ? "En la posición " + intValor + " está el Socio: " + socio
                            : "No existe el elemento.");
                }
                case 8 ->  {
                    socio = generaSocio(scEntrada);
                    intRetorno = nuevaLista.buscaObjeto(socio);
                    System.out.println((intRetorno != -1)
                            ? "La persona está en la posición " + intRetorno
                            : "No existe el número en la lista.");
                }
                case 9 -> nuevaLista.imprimeArray();
                case 10 -> {
                    nuevaLista.ordenar();
                    System.out.println("Socios ordenados por edad");
                    nuevaLista.imprimeArray();
                }
                case 11 -> System.out.println("Finalizando programa...");
                default -> System.out.println("La opción elegida no es válida.");
            }
            System.out.println();
        } while (intOpcionUsuario != 11);
        scEntrada.close();
    }

    /*******************************************************************************************************************
     * Método encargado de generar objetos de tipo Socio.                                                              *
     *                                                                                                                 *
     * @param scEntrada Objeto de tipo Scanner.                                                                        *
     * @return Devuelve un objeto de tipo Socio.                                                                       *
     *******************************************************************************************************************/
    private static Socio generaSocio(Scanner scEntrada) {
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
        System.out.print("Dime fecha de nacimiento (formato aaaa-MM-dd): ");
        fechaNacimiento = LocalDate.parse(scEntrada.nextLine());

        return new Socio(intId, strNombre, intEdad, fechaNacimiento);
    }
}
