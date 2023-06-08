package tema12_Colecciones.ejerciciosResueltos.ejercicioResuelto14_EstacionMeteorologica.clases;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/***********************************************************************************************************************
 * Clase encarga del desarrollo principal de la aplicación.                                                            *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Scanner para la entrada de datos.
        File directorio = new File("src/tema12_Colecciones/ejerciciosResueltos/" + //Directorio donde se guardarán los ficheros.
                "ejercicioResuelto14_EstacionMeteorologica/documentos");
        Set<Registro> registroTemperaturas = new LinkedHashSet<>(); //Set que almacenará los registros de cada día.

        //DECLARACIÓN DE VARIABLES
        int intOpcionUsuario; //Int que guarda la opción del usuario.

        do {
            intOpcionUsuario = muestraMenu(scEntrada);
            switch (intOpcionUsuario) {
                case 1 -> nuevoRegistro(registroTemperaturas, scEntrada);
                case 2 -> listaRegistros(registroTemperaturas);
                case 3 -> muestraEstadisticas(registroTemperaturas);
                case 4 -> {
                    System.out.println("Finalizando y guardando datos...");
                    scEntrada.close();
                    escribeFichero(registroTemperaturas, directorio);
                }
                default -> System.out.println("La opción elegida está fuera de rango.");
            }
            System.out.println();
        } while (intOpcionUsuario != 4);
    }

    /*******************************************************************************************************************
     * Método encargado de mostrar un menú de selección y devolver la opción elegida por el usuario.                   *
     *                                                                                                                 *
     * @param scEntrada Scanner para la entrada de datos.                                                              *
     * @return Devuelve un valor int con la opción elegida por el usuario.                                             *
     *******************************************************************************************************************/
    private static int muestraMenu(Scanner scEntrada) {
        //DECLARACIÓN DE OBJETOS
        Integer intReturn = null; //Integer que almacena la opción del usuario.

        do {
            System.out.println("""
                Elige una opción de las siguientes:
                    1. Nuevo registro.
                    2. Listar registros del día.
                    3. Mostrar estadísticas.
                    4. Salir.""");
            System.out.print("Opción: ");
            try {
                intReturn = Integer.parseInt(scEntrada.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Se ha introducido un valor no numérico.");
            }
        } while (intReturn == null);

        return intReturn;
    }

    /*******************************************************************************************************************
     * Método encargado de generar y almacenar un nuevo registro en el conjunto que se pasa por parámetro.             *
     *                                                                                                                 *
     * @param registros Conjunto que almacena todos los registros del día.                                             *
     * @param scEntrada Scanner para la entrada de datos.                                                              *
     *******************************************************************************************************************/
    private static void nuevoRegistro(Set<Registro> registros, Scanner scEntrada) {
        //DECLARACIÓN DE OBJETOS
        Double rlnTemperatura = null; //Double que almacenará la temperatura del registro.

        System.out.println("\n\t\tNUEVO REGISTRO");

        do {
            System.out.print("Introduce temperatura: ");
            try {
                rlnTemperatura = Double.parseDouble(scEntrada.nextLine().replace(',','.'));
            } catch (NumberFormatException e) {
                System.out.println("No se ha introducido un valor válido.");
            }
        } while (rlnTemperatura == null);

        registros.add(new Registro(rlnTemperatura));
    }

    /*******************************************************************************************************************
     * Método encargado de mostrar las estadísticas de un conjunto de registros.                                       *
     *                                                                                                                 *
     * @param registros Conjunto con los registros del día.                                                            *
     *******************************************************************************************************************/
    private static void muestraEstadisticas(Set<Registro> registros) {
        //DECLARACIÓN DE OBJETOS
        Comparator<Registro> comparadorTemperatura = new Comparator<Registro>() { //Objeto Comparator que ordenará por temperatura.
            @Override
            public int compare(Registro registroUno, Registro registroDos) {
                return Double.compare(registroUno.getRlnTemperatura(), registroDos.getRlnTemperatura());
            }
        };

        //DECLARACIÓN DE VARIABLES
        double rlnSumaTemperatura = 0; //double que almacenará la suma de temperaturas.

        if (registros.size() > 0) {
            System.out.println("\t\t\nESTADÍSTICAS");

            for (Registro registroValor : registros) {
                rlnSumaTemperatura += registroValor.getRlnTemperatura();
            }

            System.out.println("Máxima temperatura: " + Collections.max(registros, comparadorTemperatura)
                    .getRlnTemperatura());
            System.out.println("Mínima temperatura: " + Collections.min(registros, comparadorTemperatura)
                    .getRlnTemperatura());
            System.out.println("Temperatura media: " + (rlnSumaTemperatura / registros.size()));
        } else {
            System.out.println("No se ha registrado ninguna temperatura todavía.");
        }
    }

    /*******************************************************************************************************************
     * Método encargado de imprimir por pantalla los registros que se han almacenado en el conjunto que se pasa        *
     * por parámetro.                                                                                                  *
     *                                                                                                                 *
     * @param registros Conjunto que contiene los registros del día.                                                   *
     *******************************************************************************************************************/
    private static void listaRegistros(Set<Registro> registros) {
        //DECLARACIÓN DE VARIABLES
        int intCont = 0; //int que funcionará como contador.

        if (registros.size() > 0) {
            System.out.println("\t\t\nREGISTROS DE HOY");

            for (Registro registroValor : registros) {
                System.out.println("\t- Registro " + (intCont + 1) + ": " + registroValor);
                intCont++;
            }
        } else {
            System.out.println("No se ha registrado ninguna temperatura todavía.");
        }
    }

    /*******************************************************************************************************************
     * Método encargado de generar y escribir un fichero en el que se almacenará el conjunto de registros realizados   *
     * en el día.                                                                                                      *
     *                                                                                                                 *
     * @param registros Conjunto de registros realizados.                                                              *
     * @param directorio Directorio donde se almacenarán los ficheros.                                                 *
     *******************************************************************************************************************/
    private static void escribeFichero(Set<Registro> registros, File directorio) {
        //DECLARACIÓN DE VARIABLES
        String strNombreFichero; //String que almacenará el nombre del fichero.

        strNombreFichero = "/registros" + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")) + ".dat";

        try (ObjectOutputStream escritura = new ObjectOutputStream(
                new FileOutputStream(directorio + strNombreFichero))) {
            escritura.writeObject(registros);
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el directorio asignado.");
        } catch (IOException e) {
            System.out.println("Se produjo un error de escritura en el fichero.");
        }
    }
}
