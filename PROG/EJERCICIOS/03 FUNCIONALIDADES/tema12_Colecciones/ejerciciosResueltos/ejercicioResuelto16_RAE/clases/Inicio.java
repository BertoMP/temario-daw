package tema12_Colecciones.ejerciciosResueltos.ejercicioResuelto16_RAE.clases;

import java.util.*;

/***********************************************************************************************************************
 * Clase encargada de controlar el desarrollo principal del programa.                                                  *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Scanner para la entrada de datos.
        Map<Character, Academico> letraAcademico = new TreeMap<>(); //Conjunto que contiene parejas letra : académico.

        System.out.println("RELLENANDO MAPA");
        rellenaMapa(scEntrada, letraAcademico);
        scEntrada.close();

        System.out.println("\nLISTADO POR NOMBRE Y SIN LETRA");
        listadoPorNombreSinLetra(letraAcademico);

        System.out.println("\nLISTADO POR AÑO Y SIN LETRA");
        listadoPorAnnoSinLetra(letraAcademico);

        System.out.println("\nLISTADO POR NOMBRE Y CON LETRA");
        listadoPorNombreConLetra(letraAcademico);

        System.out.println("\nLISTADO POR AÑO Y CON LETRA");
        listadoPorAnnoConLetra(letraAcademico);

    }

    /*******************************************************************************************************************
     * Método encargado de rellenar un mapa que se pasa por parámetro.                                                 *
     *                                                                                                                 *
     * @param scEntrada Scanner para la entrada de datos.                                                              *
     * @param letraAcademico Mapa a rellenar.                                                                          *
     *******************************************************************************************************************/
    private static void rellenaMapa(Scanner scEntrada, Map<Character, Academico> letraAcademico) {
        //DECLARACIÓN DE VARIABLES
        char chrLetra; //Char que almacena la letra.
        Academico nuevoAcademico; //Objeto Academico a almacenar en el mapa.

        while (letraAcademico.size() < 5) {
            System.out.println("\nNUEVO ACADÉMICO");
            nuevoAcademico = generaAcademico(scEntrada);
            System.out.print("Dime su letra: ");
            chrLetra = scEntrada.nextLine().charAt(0);
            nuevoAcademico(letraAcademico, nuevoAcademico, chrLetra);
        }
    }

    /*******************************************************************************************************************
     * Método encargado de generar un objeto Academico.                                                                *
     *                                                                                                                 *
     * @param scEntrada Scanner para la entrada de datos.                                                              *
     * @return Devuelve un objeto Académico.                                                                           *
     *******************************************************************************************************************/
    private static Academico generaAcademico(Scanner scEntrada) {
        //DECLARACIÓN DE VARIABLES
        String strNombre; //String que almacena el nombre.
        Integer intAnno = null; //Integer que almacena el año.

        System.out.print("Dime nombre del académico: ");
        strNombre = scEntrada.nextLine();

        do {
            System.out.print("Dime año de ingreso en RAE: ");
            try {
                intAnno = Integer.parseInt(scEntrada.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("El valor introducido no es numérico.");
            }
        } while (intAnno == null);

        return new Academico(strNombre, intAnno);
    }

    /*******************************************************************************************************************
     * Método encargado de ingresar una nueva pareja letra : academico en el mapa pasado por parámetro.                *
     *                                                                                                                 *
     * @param academia Mapa donde añadir la nueva pareja.                                                              *
     * @param academico Academico a añadir.                                                                            *
     * @param chrLetra Letra a añadir (o modificar).                                                                   *
     * @return Devuelve true si se ha producido un cambio en el mapa o false si no se ha podido realizar el cambio.    *
     *******************************************************************************************************************/
    private static boolean nuevoAcademico(Map<Character, Academico> academia, Academico academico, Character chrLetra) {
        if (Character.isLetter(chrLetra)) {
            academia.put(chrLetra, academico);
            System.out.println("Académico añadido con éxito");
            return true;
        }
        System.out.println("No se ha introducido una letra válida. No se añadirá al académico.");
        return false;
    }

    /*******************************************************************************************************************
     * Método encargado de listar e imprimir un mapa pasado por parámetro. Lo hará por nombre y sin la letra.          *
     *                                                                                                                 *
     * @param mapaAcademicos Mapa a imprimir.                                                                          *
     *******************************************************************************************************************/
    private static void listadoPorNombreSinLetra(Map<Character, Academico> mapaAcademicos) {
        Set<Academico> listadoAcademicos = new TreeSet<>(mapaAcademicos.values());

        for (Academico academicoValor : listadoAcademicos) {
            System.out.println(academicoValor);
        }
    }

    /*******************************************************************************************************************
     * Método encargado de listar e imprimir un mapa pasado por parámetro. Lo hará por año de ingreso y sin la letra.  *
     *                                                                                                                 *
     * @param mapaAcademicos Mapa a imprimir.                                                                          *
     *******************************************************************************************************************/
    private static void listadoPorAnnoSinLetra(Map<Character, Academico> mapaAcademicos) {
        List<Academico> listadoAcademicos = new ArrayList<>(mapaAcademicos.values());

        Comparator<Academico> comparadorAnnos = new Comparator<Academico>() {
            @Override
            public int compare(Academico academico, Academico otroAcademico) {
                return Integer.compare(academico.getIntAnnoIngreso(), otroAcademico.getIntAnnoIngreso());
            }
        };

        listadoAcademicos.sort(comparadorAnnos);

        for (Academico academicoValor : listadoAcademicos) {
            System.out.println(academicoValor);
        }
    }

    /*******************************************************************************************************************
     * Método encargado de listar e imprimir un mapa pasado por parámetro. Lo hará por nombre y con la letra.          *
     *                                                                                                                 *
     * @param mapaAcademicos Mapa a imprimir.                                                                          *
     *******************************************************************************************************************/
    private static void listadoPorNombreConLetra(Map<Character, Academico> mapaAcademicos) {
        List<Map.Entry<Character, Academico>> listadoAcademicos = new ArrayList<>(mapaAcademicos.entrySet());

        listadoAcademicos.sort(new Comparator<Map.Entry<Character, Academico>>() {
            @Override
            public int compare(Map.Entry<Character, Academico> academico, Map.Entry<Character, Academico> otroAcademico) {
                return Integer.compare(academico.getValue().getIntAnnoIngreso(), otroAcademico.getValue().getIntAnnoIngreso());
            }
        });

        for (Map.Entry<Character, Academico> entradaValor : listadoAcademicos) {
            System.out.println(entradaValor);
        }
    }

    /*******************************************************************************************************************
     * Método encargado de listar e imprimir un mapa pasado por parámetro. Lo hará por año de ingreso y con la letra.  *
     *                                                                                                                 *
     * @param mapaAcademicos Mapa a imprimir.                                                                          *
     *******************************************************************************************************************/
    private static void listadoPorAnnoConLetra(Map<Character, Academico> mapaAcademicos) {
        List<Map.Entry<Character, Academico>> listadoAcademicos = new ArrayList<>(mapaAcademicos.entrySet());

        listadoAcademicos.sort(new Comparator<Map.Entry<Character, Academico>>() {
            @Override
            public int compare(Map.Entry<Character, Academico> academico, Map.Entry<Character, Academico> otroAcademico) {
                return academico.getValue().compareTo(otroAcademico.getValue());
            }
        });

        for (Map.Entry<Character, Academico> entradaValor : listadoAcademicos) {
            System.out.println(entradaValor);
        }
    }
}
