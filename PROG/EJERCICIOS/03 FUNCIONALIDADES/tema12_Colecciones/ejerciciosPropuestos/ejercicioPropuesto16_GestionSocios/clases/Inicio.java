package tema12_Colecciones.ejerciciosPropuestos.ejercicioPropuesto16_GestionSocios.clases;

import java.util.*;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal de la aplicación.                                                          *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Scanner para la entrada de datos.
        Set<Socio> listadoSocios = new TreeSet<>(); //TreeSet en el que se almacenan los Socios.

        //DECLARACIÓN DE VARIABLES
        int intOpcionUsuario; //Int que almacena la opción del usuario.

        cargaDatos(listadoSocios);

        do {
            intOpcionUsuario = muestraMenu(scEntrada);

            switch (intOpcionUsuario) {
                case 1 -> {
                    System.out.println("\n\t\t\tALTA DE SOCIO");
                    if (altaSocio(scEntrada, listadoSocios, dimeDni(scEntrada))) {
                        System.out.println("Socio añadido con éxito.");
                    } else {
                        System.out.println("El socio no se pudo añadir porque ya existe otro socio con ese DNI.");
                    }
                }
                case 2 -> {
                    System.out.println("\n\t\t\tBAJA DE SOCIO");
                    if (bajaSocio(listadoSocios, dimeDni(scEntrada))) {
                        System.out.println("Socio eliminado con éxito.");
                    } else {
                        System.out.println("El socio no se pudo eliminar porque no existe ningún DNI como el indicado.");
                    }
                }
                case 3 -> {
                    System.out.println("\n\t\t\tMODIFICACIÓN DE SOCIO");
                    if (modificaSocio(scEntrada, listadoSocios, dimeDni(scEntrada))) {
                        System.out.println("Socio modificado con éxito.");
                    } else {
                        System.out.println("El socio no se pudo modificar porque no existe en la base de datos.");
                    }
                }
                case 4 -> {
                    System.out.println("\n\t\t\tLISTADO SOCIOS POR DNI");
                    muestraListado(listadoSocios);
                }
                case 5 -> {
                    System.out.println("\n\t\t\tLISTADO SOCIOS POR ANTIGÜEDAD");
                    muestraListadoAntiguedad(listadoSocios);
                }
                case 6 -> System.out.println("Finalizando...");
                default -> System.out.println("Has introducido un valor fuera de rango.");
            }
            System.out.println();
        } while (intOpcionUsuario != 6);

        scEntrada.close();
    }

    /*******************************************************************************************************************
     * Método encargado de cargar los datos de clientes en un Set que se pasa por parámetro.                           *
     *                                                                                                                 *
     * @param listadoSocios Listado en el que se deben almacenar los datos.                                            *
     *******************************************************************************************************************/
    private static void cargaDatos(Set<Socio> listadoSocios) {
        listadoSocios.add(new Socio("111-A", "Raúl", "12/05/2020"));
        listadoSocios.add(new Socio("333-C", "Sofía", "20/09/2021"));
        listadoSocios.add(new Socio("222-B", "Julio", "07/12/2019"));
        listadoSocios.add(new Socio("555-E", "Sara", "12/11/2020"));
        listadoSocios.add(new Socio("444-D", "Yolanda", "05/05/2017"));
    }

    /*******************************************************************************************************************
     * Método encargado de mostrar un menú de selección y devolver la opción elegida por el usuario.                   *
     *                                                                                                                 *
     * @param scEntrada Scanner para la entrada de datos.                                                              *
     * @return Devuelve un valor int con la opción elegida por el usuario.                                             *
     *******************************************************************************************************************/
    private static int muestraMenu(Scanner scEntrada) {
        //DECLARACIÓN DE OBJETOS
        Integer integerReturn = null; //Integer que contiene la opción elegida por el usuario.

        do {
            System.out.println("""
                    Elige una de las siguientes opciones:
                        1. Dar de alta a un nuevo socio.
                        2. Dar de baja a un socio existente.
                        3. Modificar a un socio.
                        4. Listar por DNI.
                        5. Listar por antigüedad.
                        6. Salir.""");
            System.out.print("Opción: ");
            try {
                integerReturn = Integer.parseInt(scEntrada.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("No has introducido un número.");
            }
        } while (integerReturn == null);

        return integerReturn;
    }

    /*******************************************************************************************************************
     * Método encargado de solicitar el DNI del socio y devolverlo como resultado de la función.                       *
     *                                                                                                                 *
     * @param scEntrada Scanner para la entrada de datos.                                                              *
     * @return Devuelve el DNI introducido como resultado de la función.                                               *
     *******************************************************************************************************************/
    private static String dimeDni(Scanner scEntrada) {
        System.out.print("Dime DNI del socio: ");
        return scEntrada.nextLine();
    }

    /*******************************************************************************************************************
     * Método encargado de generar y dar de alta a un nuevo socio.                                                     *
     *                                                                                                                 *
     * @param scEntrada Scanner para la entrada de datos.                                                              *
     * @param listadoSocios Listado con los socios.                                                                    *
     * @param strDni String con el DNI del socio.                                                                      *
     * @return Devuelve un booleano true (si se ha añadido el socio) o false (si no se ha añadido el socio).           *
     *******************************************************************************************************************/
    private static boolean altaSocio(Scanner scEntrada, Set<Socio> listadoSocios, String strDni) {
        //DECLARACIÓN DE VARIABLES
        String strNombre; //String que almacena el nombre del socio.
        String strFecha; //String que almacena la fecha de alta del socio.

        System.out.print("Dime el nombre del socio: ");
        strNombre = scEntrada.nextLine();

        System.out.println("Dime fecha de alta:");
        strFecha = dimeFecha(scEntrada);

        return listadoSocios.add(new Socio(strDni, strNombre, strFecha));
    }

    /*******************************************************************************************************************
     * Método encargado de generar una fecha.                                                                          *
     *                                                                                                                 *
     * @param scEntrada Scanner para la entrada de datos.                                                              *
     * @return Devuelve un String con la fecha introducida en formato dd/MM/aaaa                                       *
     *******************************************************************************************************************/
    private static String dimeFecha(Scanner scEntrada) {
        //DECLARACIÓN DE VARIABLES
        int intAnno; //Int que almacena el año.
        int intMes; //Int que almacena el mes.
        int intDia; //Int que almacena el día.
        int intDiasMaximo = 0; //Int que determina los días máximos en función del mes.

        intAnno = dimeAnno(scEntrada);
        intMes = dimeMes(scEntrada);

        switch (intMes) {
            case 1, 3, 5, 7, 8, 10, 12 -> intDiasMaximo = 31;
            case 2 -> intDiasMaximo = ((intAnno % 4 == 0 && intAnno % 100 != 0) || intAnno % 400 == 0) ? 29 : 28;
            case 4, 6, 9, 11 -> intDiasMaximo = 30;
        }

        intDia = dimeDia(scEntrada, intDiasMaximo);

        return String.format("%02d/%02d/%04d", intDia, intMes, intAnno);
    }

    /*******************************************************************************************************************
     * Método encargado de solicitar un año al usuario y comprobar que es válido.                                      *
     *                                                                                                                 *
     * @param scEntrada Scanner para la entrada de datos.                                                              *
     * @return Devuelve un int con el año introducido por el usuario.                                                  *
     *******************************************************************************************************************/
    private static int dimeAnno(Scanner scEntrada) {
        //DECLARACIÓN DE OBJETOS
        Integer intAnno = null; //Integer que almacenará el año.

        do {
            System.out.print("Dime el año: ");
            try {
                intAnno = Integer.parseInt(scEntrada.nextLine());
                if (intAnno == 0) {
                    System.out.println("No existe el año 0.");
                    intAnno = null;
                }
            } catch (NumberFormatException e) {
                System.out.println("Has introducido un valor no numérico. Vuelve a intentarlo.");
            }
        } while (intAnno == null);

        return intAnno;
    }

    /*******************************************************************************************************************
     * Método encargado de solicitar un mes al usuario y comprobar que es válido.                                      *
     *                                                                                                                 *
     * @param scEntrada Scanner para la entrada de datos.                                                              *
     * @return Devuelve un int con el mes introducido por el usuario.                                                  *
     *******************************************************************************************************************/
    private static int dimeMes(Scanner scEntrada) {
        //DECLARACIÓN DE OBJETOS
        Integer intMes = null; //Integer que almacenará el mes.

        do {
            System.out.print("Dime el mes (1-12): ");
            try {
                intMes = Integer.parseInt(scEntrada.nextLine());
                if (intMes <= 0 || intMes > 12) {
                    System.out.println("La cifra indicada está fuera de rango.");
                    intMes = null;
                }
            } catch (NumberFormatException e) {
                System.out.println("Has introducido un valor no numérico. Vuelve a intentarlo.");
            }
        } while (intMes == null);

        return intMes;
    }

    /*******************************************************************************************************************
     * Método encargado de solicitar un día al usuario y comprobar que es válido.                                      *
     *                                                                                                                 *
     * @param scEntrada Scanner para la entrada de datos.                                                              *
     * @param intDiasMaximo Días máximos que puede haber.                                                              *
     * @return Devuelve un int con el día introducido por el usuario.                                                  *
     *******************************************************************************************************************/
    private static int dimeDia(Scanner scEntrada, int intDiasMaximo) {
        //DECLARACIÓN DE OBJETOS
        Integer intDia = null; //Integer que almacenará el día.

        do {
            System.out.print("Dime el día (1-" + intDiasMaximo + "): ");
            try {
                intDia = Integer.parseInt(scEntrada.nextLine());
                if (intDia <= 0 || intDia > intDiasMaximo) {
                    System.out.println("La cifra indicada está fuera de rango.");
                    intDia = null;
                }
            } catch (NumberFormatException e) {
                System.out.println("Has introducido un valor no numérico. Vuelve a intentarlo.");
            }
        } while (intDia == null);

        return intDia;
    }

    /*******************************************************************************************************************
     * Método encargado de dar de baja a un socio.                                                                     *
     *                                                                                                                 *
     * @param listadoSocios Listado con los socios.                                                                    *
     * @param strDni String con el DNI del socio a eliminar.                                                           *
     * @return Devuelve un booleano true (si se ha eliminado al socio) o false (si no se ha eliminado nada).           *
     *******************************************************************************************************************/
    private static boolean bajaSocio(Set<Socio> listadoSocios, String strDni) {
        return listadoSocios.remove(new Socio(strDni));
    }

    /*******************************************************************************************************************
     * Método encargado de modificar un socio.                                                                         *
     *                                                                                                                 *
     * @param scEntrada Scanner para la entrada de datos.                                                              *
     * @param listadoSocios Listado con los socios.                                                                    *
     * @param strDni String con el DNI del socio a eliminar.                                                           *
     * @return Devuelve un booleano true (si se ha realizado una modificación) o false (si no se ha modificado nada).  *
     *******************************************************************************************************************/
    private static boolean modificaSocio(Scanner scEntrada, Set<Socio> listadoSocios, String strDni) {
        return bajaSocio(listadoSocios, strDni) && altaSocio(scEntrada, listadoSocios, strDni);
    }

    /*******************************************************************************************************************
     * Método encargado de mostrar el listado de socios en función de su orden natural (por DNI).                      *
     *                                                                                                                 *
     * @param listadoSocios Listado de socios a mostrar.                                                               *
     *******************************************************************************************************************/
    private static void muestraListado(Set<Socio> listadoSocios) {
        //DECLARACIÓN DE VARIABLES
        int intCont = 1; //Int que funciona como contador.

        for (Socio socioValor : listadoSocios) {
            System.out.println("Socio " + intCont + " -> " + socioValor);
            intCont++;
        }
    }

    /*******************************************************************************************************************
     * Método encargado de mostrar el listado de socios por orden de antigüedad.                                       *
     *                                                                                                                 *
     * @param listadoSocios Listado de socios a mostrar.                                                               *
     *******************************************************************************************************************/
    private static void muestraListadoAntiguedad(Set<Socio> listadoSocios) {
        //DECLARACIÓN DE OBJETOS
        Set<Socio> listadoAntiguedad = new TreeSet<>(new Comparator<>() { //TreeSet auxiliar que se construye a partir de un Comparator por antigüedad.
            @Override
            public int compare(Socio socio, Socio otroSocio) {
                return Integer.compare(otroSocio.antiguedad(), socio.antiguedad());
            }
        });

        listadoAntiguedad.addAll(listadoSocios);

        muestraListado(listadoAntiguedad);
    }
}
