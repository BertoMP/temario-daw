package tema12_Colecciones.ejerciciosPropuestos.ejercicioPropuesto25_MapaSocio.clases;

import java.io.*;
import java.util.*;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal de la aplicación.                                                          *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Scanner para la entrada de datos.
        Map<String, Socio> socios; //Mapa donde se guardarán los socios.
        File fichero = new File("src/tema12_Colecciones/ejerciciosPropuestos/" + //File que almacenará la ruta del fichero donde se encuentran los datos.
                "ejercicioPropuesto25_MapaSocio/documentos/club.dat");

        //DECLARACIÓN DE VARIABLES
        int intOpcionUsuario; //Int que almacena la opcion del usarios.

        socios = (fichero.exists()) ? leeFichero(fichero) : new TreeMap<>();

        do {
            intOpcionUsuario = muestraMenu(scEntrada);

            switch (intOpcionUsuario) {
                case 1 -> {
                    System.out.println("\n\tALTA DE SOCIO");
                    altaSocio(socios, dimeApodo(scEntrada), scEntrada);
                }
                case 2 -> {
                    System.out.println("\n\tBAJA DE SOCIO");
                    bajaSocio(socios, dimeApodo(scEntrada));
                }
                case 3 -> {
                    System.out.println("\n\tMODIFICACIÓN DE SOCIO");
                    modificaSocio(socios, dimeApodo(scEntrada), scEntrada);
                }
                case 4 -> {
                    System.out.println("\n\t\t\tLISTADO SOCIOS POR APODO");
                    listarSociosPorApodo(socios);
                }
                case 5 -> {
                    System.out.println("\n\t\tLISTADO SOCIOS POR ANTIGÜEDAD");
                    listarSociosPorAntiguedad(socios);
                }
                case 6 -> listarSociosAnterioresANAnno(socios, dimeAnno(scEntrada));
                case 7 -> {
                    System.out.println("Finalizando aplicación...");
                    escribeFichero(fichero, socios);
                }
                default -> System.out.println("La opción elegida está fuera de rango.");
            }
            System.out.println();
        } while (intOpcionUsuario != 7);

        scEntrada.close();
    }

    /*******************************************************************************************************************
     * Método encargado de cargar los datos de clientes en un Map desde un fichero que pasa por parámetro.             *
     *                                                                                                                 *
     * @param fichero Fichero que contiene el mapa de datos que se tiene que cargar.                                   *
     * @return Devuelve un mapa recogido desde el fichero.                                                             *
     *******************************************************************************************************************/
    private static Map<String, Socio> leeFichero(File fichero) {
        //DECLARACIÓN DE OBJETOS
        Map<String, Socio> mapaReturn = new TreeMap<>(); //Mapa que se devolverá como resultado de la función.

        //BLOQUE TRY-CATCH WITH RESOURCES
        try (ObjectInputStream lectura = new ObjectInputStream(new FileInputStream(fichero))) {
            mapaReturn = (TreeMap<String, Socio>) lectura.readObject();
        } catch (FileNotFoundException ignored) {
        } catch (IOException e) {
            System.out.println("Se produjo un error de lectura.");
        } catch (ClassNotFoundException e) {
            System.out.println("El fichero no contiene un mapa de socios.");
        }

        return mapaReturn;
    }

    /*******************************************************************************************************************
     * Método encargado de mostrar un menú de selección y devolver la opción elegida por el usuario.                   *
     *                                                                                                                 *
     * @param scEntrada Scanner para la entrada de datos.                                                              *
     * @return Devuelve un valor int con la opción elegida por el usuario.                                             *
     *******************************************************************************************************************/
    private static int muestraMenu(Scanner scEntrada) {
        //DECLARACIÓN DE OBJETOS
        Integer integerOpcion = null; //Integer que guarda la opción del usuario.

        do {
            System.out.println("""
                Elige una opción:
                    1. Alta socio.
                    2. Baja socio.
                    3. Modificación socio.
                    4. Listar socios por apodo.
                    5. Listar socios por antigüedad.
                    6. Listar socios con alta anterior a un año determinado.
                    7. Salir.""");
            System.out.print("Opción: ");
            try {
                integerOpcion = Integer.parseInt(scEntrada.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("No se ha introducido un número. Vuelve a introducir un número.");
            }
        } while (integerOpcion == null);

        return integerOpcion;
    }

    /*******************************************************************************************************************
     * Método encargado generar y dar de alta a un nuevo socio.                                                        *
     *                                                                                                                 *
     * @param mapaSocios Mapa de socios.                                                                               *
     * @param scEntrada Scanner para la entrada de datos.                                                              *
     *******************************************************************************************************************/
    private static void altaSocio(Map<String, Socio> mapaSocios, String strApodo, Scanner scEntrada) {
        //DECLARACIÓN DE OBJETOS
        Socio nuevoSocio; //Socio que se dará de alta

        //DECLARACIÓN DE VARIABLES
        String strNombre; //String que almacena el nombre del socio.
        String strFecha; //String que almacena la fecha de alta del socio.

        if (!mapaSocios.containsKey(strApodo)) {
            strNombre = dimeNombre(scEntrada);
            System.out.println("Fecha de alta:");
            strFecha = dimeFecha(scEntrada);

            nuevoSocio = new Socio(strNombre, strFecha);
            mapaSocios.put(strApodo, nuevoSocio);
            System.out.println("Alta de socio realizada con éxito.");
        } else {
            System.out.println("Ya existe un socio con ese apodo -> " + mapaSocios.get(strApodo));
        }
    }

    /*******************************************************************************************************************
     * Método encargado de solicitar el apodo al usuario.                                                              *
     *                                                                                                                 *
     * @param scEntrada Scanner para la entrada de datos.                                                              *
     * @return Devuelve un String con el apodo introducido.                                                            *
     *******************************************************************************************************************/
    private static String dimeApodo(Scanner scEntrada) {
        String strApodo; //String que almacenará el apodo.

        do {
            System.out.print("Dime el apodo del socio: ");
            strApodo = scEntrada.nextLine();
            if (strApodo.isEmpty()) {
                System.out.println("El apodo no puede estar vacío.");
            }
        } while (strApodo.isEmpty());

        return strApodo;
    }

    /*******************************************************************************************************************
     * Método encargado de solicitar el nombre al usuario.                                                             *
     *                                                                                                                 *
     * @param scEntrada Scanner para la entrada de datos.                                                              *
     * @return Devuelve un String con el nombre introducido.                                                           *
     *******************************************************************************************************************/
    private static String dimeNombre(Scanner scEntrada) {
        String strNombre; //String que almacenará el nombre.

        do {
            System.out.print("Dime nombre del socio: ");
            strNombre = scEntrada.nextLine();
            if (strNombre.isEmpty()) {
                System.out.println("El nombre no puede estar vacío.");
            }
        } while (strNombre.isEmpty());

        return strNombre;
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
        Integer intAnno = null; //Integer que almacenará el año.

        do {
            System.out.print("\t- Dime el año: ");
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
        Integer intMes = null; //Integer que almacenará el mes.

        do {
            System.out.print("\t- Dime el mes (1-12): ");
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
        Integer intDia = null; //Integer que almacenará el día.

        do {
            System.out.print("\t- Dime el día (1-" + intDiasMaximo + "): ");
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
     * @param mapaSocios Mapa con los socios.                                                                          *
     * @param strApodo String con el apodo del socio a eliminar.                                                       *
     *******************************************************************************************************************/
    private static void bajaSocio(Map<String, Socio> mapaSocios, String strApodo) {
        if (mapaSocios.containsKey(strApodo)) {
            mapaSocios.remove(strApodo);
            System.out.println("Baja de socio realizada con éxito.");
        } else {
            System.out.println("No existe un socio con ese apodo.");
        }
    }

    /*******************************************************************************************************************
     * Método encargado de modificar un socio.                                                                         *
     *                                                                                                                 *
     * @param scEntrada Scanner para la entrada de datos.                                                              *
     * @param mapaSocios Mapa con los socios.                                                                          *
     * @param strApodo String con el apodo del socio a eliminar.                                                       *
     *******************************************************************************************************************/
    private static void modificaSocio(Map<String, Socio> mapaSocios, String strApodo, Scanner scEntrada) {
        //DECLARACION VARIABLES
        String strNuevoNombre; //String que almacena el nuevo nombre del Socio.
        String strNuevaFechaAlta; //String que almacena la nueva fecha de alta del Socio.

        if (mapaSocios.containsKey(strApodo)) {
            System.out.println("Cambiando nombre...");
            strNuevoNombre = dimeNombre(scEntrada);
            System.out.println("Cambiando fecha de alta...");
            strNuevaFechaAlta = dimeFecha(scEntrada);
            mapaSocios.put(strApodo, new Socio(strNuevoNombre, strNuevaFechaAlta));
            System.out.println("Modificación de socio realizada con éxito.");
        } else {
            System.out.println("No existe un socio con ese apodo.");
        }
    }

    /*******************************************************************************************************************
     * Método encargado de mostrar el listado de socios en función de su apodo.                                        *
     *                                                                                                                 *
     * @param mapaSocios Mapa de socios a mostrar.                                                                     *
     *******************************************************************************************************************/
    private static void listarSociosPorApodo(Map<String, Socio> mapaSocios) {
        for (Map.Entry<String, Socio> entradaValor : mapaSocios.entrySet()) {
            System.out.println("Apodo: " + entradaValor.getKey() + " -> " + entradaValor.getValue());
        }
    }

    /*******************************************************************************************************************
     * Método encargado de mostrar el listado de socios en función de su antigüedad.                                   *
     *                                                                                                                 *
     * @param mapaSocios Mapa de socios a mostrar.                                                                     *
     *******************************************************************************************************************/
    private static void listarSociosPorAntiguedad(Map<String, Socio> mapaSocios) {
        //DECLARACIÓN DE OBJETOS
        List<Map.Entry<String, Socio>> listadoSocios = new ArrayList<>(mapaSocios.entrySet()); //ArrayList con los socios del mapa.

        ordenaListadoPorAntiguedad(listadoSocios);

        imprimeListado(listadoSocios);
    }

    /*******************************************************************************************************************
     * Método encargado de ordenar un listado de socios por un criterio de antigüedad.                                 *
     *                                                                                                                 *
     * @param listadoSocios Listado a ordenar.                                                                         *
     * @return Devuelve un listado de socios ordenados por antigüedad.                                                 *
     *******************************************************************************************************************/
    private static List<Map.Entry<String, Socio>> ordenaListadoPorAntiguedad(List<Map.Entry<String, Socio>> listadoSocios) {
        listadoSocios.sort(new Comparator<Map.Entry<String, Socio>>() {
            @Override
            public int compare(Map.Entry<String, Socio> socio, Map.Entry<String, Socio> otroSocio) {
                return Integer.compare(otroSocio.getValue().antiguedad(), socio.getValue().antiguedad());
            }
        });

        return listadoSocios;
    }

    /*******************************************************************************************************************
     * Método encargado de imprimir un listado de socios que se pasa por parámetro.                                    *
     *                                                                                                                 *
     * @param listado Listado con los socios.                                                                          *
     *******************************************************************************************************************/
    private static void imprimeListado(List<Map.Entry<String, Socio>> listado) {
        for (Map.Entry<String, Socio> entradaValor : listado) {
            System.out.println("Apodo: " + entradaValor.getKey() + " -> " + entradaValor.getValue());
        }
    }

    /*******************************************************************************************************************
     * Método encargado de mostrar el listado de socios cuya fecha de alta es anterior a un año pasado por parámetros. *
     *                                                                                                                 *
     * @param mapaSocios Mapa de socios a mostrar.                                                                     *
     * @param intAnno Año máximo a mostrar.                                                                            *
     *******************************************************************************************************************/
    private static void listarSociosAnterioresANAnno(Map<String, Socio> mapaSocios, int intAnno) {
        //DECLARACIÓN DE OBJETOS
        List<Map.Entry<String, Socio>> listadoSocios = new ArrayList<>(mapaSocios.entrySet()); //ArrayList con los socios del mapa.
        List<Map.Entry<String, Socio>> listadoSociosAnterioresANAnno = new ArrayList<>(); //ArrayList con los socios anteriores a N año.

        for (Map.Entry<String, Socio> entradaValor : listadoSocios) {
            if (entradaValor.getValue().getAnnoIngreso() < intAnno) {
                listadoSociosAnterioresANAnno.add(entradaValor);
            }
        }

        if (listadoSociosAnterioresANAnno.size() > 0) {
            listadoSociosAnterioresANAnno = ordenaListadoPorAntiguedad(listadoSociosAnterioresANAnno);
            System.out.println("\n\tLISTADO DE SOCIOS CON FECHA DE ALTA ANTERIOR A " + intAnno);
            imprimeListado(listadoSociosAnterioresANAnno);

        } else {
            System.out.println("No existen socios con fecha de alta anterior a " + intAnno);
        }
    }

    /*******************************************************************************************************************
     * Método encargado de guardar los datos de clientes en un un fichero que pasa por parámetro.                      *
     *                                                                                                                 *
     * @param fichero Fichero en el que se deben guardar los datos.                                                    *
     * @param mapaSocios Mapa que debe almacenarse en el fichero.                                                      *
     *******************************************************************************************************************/
    private static void escribeFichero(File fichero, Map<String,Socio> mapaSocios) {
        //BLOQUE TRY-CATCH WITH RESOURCES
        try (ObjectOutputStream escritura = new ObjectOutputStream(new FileOutputStream(fichero))) {
            escritura.writeObject(mapaSocios);
        } catch (FileNotFoundException e) {
            System.out.println("No existe el fichero club.dat.");
        } catch (IOException e) {
            System.out.println("Se produjo un error de escritura.");
        }
    }
}
