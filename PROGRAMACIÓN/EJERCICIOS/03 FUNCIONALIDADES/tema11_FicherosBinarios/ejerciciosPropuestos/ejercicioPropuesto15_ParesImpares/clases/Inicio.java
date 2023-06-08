package tema11_FicherosBinarios.ejerciciosPropuestos.ejercicioPropuesto15_ParesImpares.clases;

import java.io.*;

/***********************************************************************************************************************
 * Clase encargada de controlar el desarrollo principal del programa.                                                  *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        File archivoNumeros = new File("src/tema11_FicherosBinarios/ejerciciosPropuestos/" +
                "ejercicioPropuesto15_ParesImpares/documentos/numeros.dat"); //Objeto File que guarda la ruta del fichero.
        File archivoPares = new File("src/tema11_FicherosBinarios/ejerciciosPropuestos/" +
                "ejercicioPropuesto15_ParesImpares/documentos/pares.dat"); //Objeto File que guarda la ruta del fichero.
        File archivoImpares = new File("src/tema11_FicherosBinarios/ejerciciosPropuestos/" +
                "ejercicioPropuesto15_ParesImpares/documentos/impares.dat"); //Objeto File que guarda la ruta del fichero.

        //DECLARACIÓN DE VARIABLES
        int intNumAleatorio; //Variable int que guarda un número aleatorio.
        int intNumLeido; //Variable int que guarda un número leído del archivo.

        //BLOQUE TRY-CATCH WITH RESOURCES
        try (ObjectOutputStream escritura = new ObjectOutputStream(new FileOutputStream(archivoNumeros))) {
            for (int intCont = 0; intCont < 10; intCont++) {
                intNumAleatorio = (int) (Math.random() * 100) + 1;
                escritura.writeInt(intNumAleatorio);
            }
        } catch (FileNotFoundException e) { //En caso de que no se encuentre el fichero.
            System.out.println("No se encontró el fichero numeros.dat.");
        } catch (IOException e) { //En caso de que se produzca un error de escritura.
            System.out.println("Se produjo un error de escritura en el fichero numeros.dat.");
        }

        if (archivoNumeros.exists()) {
            //BLOQUE TRY-CATCH WITH RESOURCES
            try (ObjectInputStream lectura = new ObjectInputStream(new FileInputStream(archivoNumeros));
                ObjectOutputStream escrituraPares = new ObjectOutputStream(new FileOutputStream(archivoPares));
                ObjectOutputStream escrituraImpares = new ObjectOutputStream(new FileOutputStream(archivoImpares))) {
                while (true) {
                    try {
                        intNumLeido = lectura.readInt();
                        if (intNumLeido %2 == 0) {
                            try {
                                escrituraPares.writeInt(intNumLeido);
                            } catch (IOException e) { //En caso de que se produzca un error de escritura.
                                System.out.println("Error de escritura en el fichero pares.dat.");
                            }
                        } else {
                            try {
                                escrituraImpares.writeInt(intNumLeido);
                            } catch (IOException e) { //En caso de que se produzca un error de escritura.
                                System.out.println("Error de escritura en el fichero impares.dat.");
                            }
                        }
                    } catch (IOException e) { //En caso de que se produzca un error de lectura.
                        System.out.println("Error de lectura en el fichero numeros.dat.");
                    }
                }
            } catch (EOFException e) { //En caso de alcanzar el final del fichero.
                System.out.println("Final del fichero con todos los números.");
            } catch (FileNotFoundException e) { //En caso de que no se encuentre el fichero.
                System.out.println("No se encontró uno de los ficheros.");
            } catch (IOException ignored) {} //En caso de que se produzca un error de lecto-escritura.
        }

        if (archivoPares.exists()) {
            System.out.println("\nFICHERO DE NÚMEROS PARES");
            lecturaFicheros(archivoPares);
        }

        if (archivoImpares.exists()) {
            System.out.println("\nFICHERO DE NÚMEROS IMPARES");
            lecturaFicheros(archivoImpares);
        }
    }

    /*******************************************************************************************************************
     * Método encargado de leer un fichero pasado por parámetro y mostrar su contenido por pantalla.                   *
     *                                                                                                                 *
     * @param fichero Fichero a leer.                                                                                  *
     *******************************************************************************************************************/
    public static void lecturaFicheros(File fichero) {
        try (ObjectInputStream lectura = new ObjectInputStream(new FileInputStream(fichero))) {
            while (true) {
                System.out.println(lectura.readInt());
            }
        } catch (EOFException e) { //En caso de alcanzar el final del fichero.
            System.out.println("Fin del fichero");
        } catch (FileNotFoundException ignored) { //En caso de que no se encuentre el fichero.
        } catch (IOException e) { //En caso de un error de lectura.
            System.out.println("Se produjo un error de lectura en el fichero");
        }
    }
}
