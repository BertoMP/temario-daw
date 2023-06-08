package tema11_FicherosBinarios.ejerciciosPropuestos.ejercicioPropuesto28_Precios.clases;

import java.io.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada de controlar el desarrollo principal del programa.                                                  *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in);
        File fichero = new File("src/tema11_FicherosBinarios/ejerciciosPropuestos/" +
                "ejercicioPropuesto28_Precios/documentos/precios.dat");
        int intOpcion;

        do {
            intOpcion = muestraMenu(scEntrada);
            switch (intOpcion) {
                case 0 -> System.out.println("Se ha introducido un valor no numérico.");
                case 1 -> addArticulo(scEntrada, fichero);
                case 2 -> leeFichero(fichero);
                case 3 -> actualizarPreciosIPC(fichero);
                case 4 -> System.out.println("Finalizando...");
                default -> System.out.println("Se ha introducido un valor fuera de rango.");
            }
            System.out.println();
        } while (intOpcion != 4);

        scEntrada.close();
    }

    /*******************************************************************************************************************
     * Muestra un menú con opciones y solicita al usuario que seleccione una opción.                                   *
     *                                                                                                                 *
     * @return El número de opción seleccionado por el usuario, o 0 si se produce una excepción al intentar leer       *
     *         la entrada del usuario.                                                                                 *
     *******************************************************************************************************************/
    private static int muestraMenu(Scanner scEntrada) {
        System.out.println("""
                Elige una opción:
                    1. Añadir artículo.
                    2. Listar artículos.
                    3. Modificar precios IPC.
                    4. Salir.""");
        System.out.print("Opción: ");
        try {
            return Integer.parseInt(scEntrada.nextLine());
        } catch (NumberFormatException e) {
            return  0;
        }
    }

    /*******************************************************************************************************************
     * Este método añade un artículo al final de un fichero de acceso aleatorio.                                       *
     *                                                                                                                 *
     * @param scEntrada Scanner que recibe la entrada del usuario desde la consola.                                    *
     * @param fichero El archivo de acceso aleatorio en el que se va a agregar el artículo.                            *
     *******************************************************************************************************************/
    private static void addArticulo(Scanner scEntrada, File fichero) {
        //DECLARACIÓN DE OBJETOS
        StringBuffer stringBuffer; //StringBuffer para limitar la longitud de los Strings.
        DecimalFormat decimalFormat = new DecimalFormat("#.##"); //DecimalFormat para formatear los decimales.

        //DECLARACIÓN DE VARIABLES
        String strReferencia; //String que almacena la referencia del artículo.
        double rlnPrecio = 0; //double que almacena el precio del artículo.
        boolean blnPrecioValido; //boolean que actúa como bandera.

        //BLOQUE TRY-CATCH WITH RESOURCES
        try (RandomAccessFile ficheroAleatorio = new RandomAccessFile(fichero, "rw")) {
            ficheroAleatorio.seek(ficheroAleatorio.length());
            System.out.println("Añadiendo artículo al final del fichero...");
            do {
                System.out.print("Dime referencia del articulo: ");
                strReferencia = scEntrada.nextLine().trim();
                stringBuffer = new StringBuffer(strReferencia);
                stringBuffer.setLength(5);
                if (strReferencia.isEmpty()) {
                    System.out.println("La referencia no puede estar vacía.");
                }
            } while (strReferencia.isEmpty());
            do {
                System.out.print("Dime precio del artículo: ");
                try {
                    rlnPrecio = Double.parseDouble(scEntrada.nextLine().trim().replace(",","."));
                    rlnPrecio = decimalFormat.parse(decimalFormat.format(rlnPrecio)).doubleValue();
                    blnPrecioValido = true;
                    if (rlnPrecio <= 0) {
                        System.out.println("El precio tiene que tener un valor positivo.");
                    }
                } catch (NumberFormatException e) { //En caso de que se introduzca un número no válido.
                    System.out.println("No se ha introducido un número válido.");
                    blnPrecioValido = false;
                } catch (ParseException e) { //En caso de que no se pueda formatear el decimal.
                    System.out.println("No se pudo transformar el número a un formato válido.");
                    blnPrecioValido = false;
                }
            } while (!blnPrecioValido || rlnPrecio <= 0);
            ficheroAleatorio.writeUTF(String.valueOf(stringBuffer));
            ficheroAleatorio.writeDouble(rlnPrecio);
            System.out.println("Artículo añadido con éxito.");
        } catch (FileNotFoundException ignored) { //En caso de que el fichero no exista.
        } catch (IOException e) { //En caso de que se produzca un error de lecto-escritura.
            System.out.println("Se produjo un error de lecto-escritura.");
        }
    }

    /*******************************************************************************************************************
     * Este método lee un archivo de acceso aleatorio y muestra su contenido por consola.                              *
     *                                                                                                                 *
     * @param fichero El archivo de acceso aleatorio que se va a leer.                                                 *
     *******************************************************************************************************************/
    private static void leeFichero(File fichero) {
        //DECLARACIÓN DE VARIABLES
        String strReferencia; //String que almacena la referencia del artículo.
        double rlnPrecio; //double que almacena el precio del artículo.

        //BLOQUE TRY-CATCH WITH RESOURCES
        try (RandomAccessFile ficheroAleatorio = new RandomAccessFile(fichero, "r")) {
            System.out.println("Leyendo fichero...");
            System.out.println("REF" + "\t\tPrecio");
            while (true) {
                strReferencia = ficheroAleatorio.readUTF();
                rlnPrecio = ficheroAleatorio.readDouble();
                System.out.println(strReferencia + "\t" + rlnPrecio);
            }
        } catch (FileNotFoundException ignored) { //En caso de que el fichero no exista.
        } catch (EOFException e) { //En caso de alcanzar el final del fichero.
            System.out.println("Fin del fichero.");
        } catch (IOException e) { //En caso de que se produzca un error de lectura.
            System.out.println("Se produjo un error de lectura.");
        }
    }

    /*******************************************************************************************************************
     * Este método actualiza los precios de los artículos en un archivo de acceso aleatorio, aplicando un IPC mayor    *
     * o menor según el precio actual del artículo.                                                                    *
     *                                                                                                                 *
     * @param fichero El archivo de acceso aleatorio que se va a modificar.                                            *
     *******************************************************************************************************************/
    private static void actualizarPreciosIPC(File fichero) {
        //DECLARACIÓN DE CONSTANTES
        final double PRECIO_LIMITE = 100.0; //Constante double que almacena el precio límite para aplicar un IPC del 20% o del 30%.
        final double IPC_PRECIO_ALTO = 1.2; //Constante double que almacena el IPC a aplicar en artículos que superen el PRECIO_LIMITE.
        final double IPC_PRECIO_BAJO = 1.3; //Constante double que almacena el IPC a aplicar en artículos que no superan el PRECIO_LIMITE.

        //DECLARACIÓN DE VARIABLES
        String strReferencia; //String que almacena la referencia del artículo.
        String strPorcentaje; //String que almacena el porcentaje de IPC a aplicar.
        double rlnPrecio; //double que almacena el precio actual del artículo.
        double rlnNuevoPrecio; //double que almacena el nuevo precio del artículo.
        boolean blnCambio; //boolean que actúa de bandera.

        //BLOQUE TRY-CATCH WITH RESOURCES
        try (RandomAccessFile ficheroAleatorio = new RandomAccessFile(fichero, "rw")) {
            System.out.println("Modificando precios...");
            while (true) {
                strReferencia = ficheroAleatorio.readUTF();
                rlnPrecio = ficheroAleatorio.readDouble();
                if (rlnPrecio >= PRECIO_LIMITE) {
                    rlnNuevoPrecio = calculaIPC(rlnPrecio, IPC_PRECIO_ALTO);
                    blnCambio = true;
                } else {
                    rlnNuevoPrecio = calculaIPC(rlnPrecio, IPC_PRECIO_BAJO);
                    blnCambio = false;
                }

                strPorcentaje = blnCambio ? "(20%)" : "(30%)";

                ficheroAleatorio.seek(ficheroAleatorio.getFilePointer() - 8);
                ficheroAleatorio.writeDouble(rlnNuevoPrecio);
                System.out.println("Referencia: " + strReferencia +
                        "\n\t-Precio anterior: " + rlnPrecio +
                        "\n\t-Nuevo precio " + strPorcentaje + ": " + rlnNuevoPrecio);
            }
        } catch (FileNotFoundException ignored) { //En caso de que no se encuentre el fichero.
        } catch (EOFException e) { //En caso de que se alcance el final del fichero.
            System.out.println("Se alcanzó el final del fichero.");
        } catch (IOException e) { //En caso de que se produzca un error de lecto-escritura.
            System.out.println("Se produjo un error de lecto-escritura.");
        }
    }

    /*******************************************************************************************************************
     * Calcula el precio final dado un precio y un IPC.                                                                *
     *                                                                                                                 *
     * @param rlnPrecio Precio del artículo.                                                                           *
     * @param rlnIPC IPC a aplicar.                                                                                    *
     * @return El precio final del artículo.                                                                           *
     *******************************************************************************************************************/
    private static double calculaIPC(double rlnPrecio, double rlnIPC) {
        //DECLARACIÓN DE OBJETOS
        DecimalFormat decimalFormat = new DecimalFormat("#.##"); //DecimalFormat para formatear los double.

        try {
            return decimalFormat.parse(decimalFormat.format(rlnPrecio * rlnIPC)).doubleValue();
        } catch (ParseException e) { //En caso de que no se pueda formatear el precio
            System.out.println("No se pudo formatear el precio.");
            return rlnPrecio;
        }
    }
}
