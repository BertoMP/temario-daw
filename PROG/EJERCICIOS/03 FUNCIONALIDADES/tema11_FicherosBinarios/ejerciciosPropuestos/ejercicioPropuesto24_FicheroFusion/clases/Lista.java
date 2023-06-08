package tema11_FicherosBinarios.ejerciciosPropuestos.ejercicioPropuesto24_FicheroFusion.clases;

import java.io.*;
import java.util.Arrays;

/***********************************************************************************************************************
 * Clase Lista.                                                                                                        *
 ***********************************************************************************************************************/

public class Lista implements Serializable {
    //DECLARACIÓN DE ATRIBUTOS
    private Integer[] arrIntegers; //Array de Integer.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *******************************************************************************************************************/
    public Lista() {
        this.arrIntegers = new Integer[0];
    }

    /*******************************************************************************************************************
     * Añade un Integer al array de integers en orden ascendente.                                                      *
     *                                                                                                                 *
     * @param integer El Integer que se agregará al array de integers.                                                 *
     *******************************************************************************************************************/
    public void addInteger(Integer integer) {
        //DECLARACIÓN DE VARIABLES
        int intIndiceInsercion; //Int que guardará el índice de inserción.

        intIndiceInsercion = buscaInteger(integer);

        if (intIndiceInsercion < 0) {
            intIndiceInsercion = -intIndiceInsercion - 1;
        }

        this.arrIntegers = Arrays.copyOf(this.arrIntegers, this.arrIntegers.length + 1);
        System.arraycopy(this.arrIntegers, intIndiceInsercion, this.arrIntegers, intIndiceInsercion + 1,
                this.arrIntegers.length - intIndiceInsercion - 1);
        this.arrIntegers[intIndiceInsercion] = integer;
    }

    /*******************************************************************************************************************
     * Método que fusiona dos ficheros de enteros en un único array ordenado. Una vez finalizado el proceso, realiza   *
     * una sobreescritura del ficheroBase con la nuevo lista.                                                          *
     *                                                                                                                 *
     * @param strFicheroBase Nombre del primer fichero de enteros.                                                     *
     * @param strFicheroNuevo Nombre del segundo fichero de enteros.                                                   *
     *******************************************************************************************************************/
    public static void fusionar(String strFicheroBase, String strFicheroNuevo) {
        File fichero = new File("src/tema11_FicherosBinarios/ejerciciosPropuestos/" +
                "ejercicioPropuesto24_FicheroFusion/documentos/ficheroBase.dat"); //File que contiene el fichero donde se almacenará el listado de números.
        Lista listaBase; //Lista del fichero base.
        Integer[] arrIntegerNuevo; //Array del fichero nuevo.

        listaBase = leeFicheroLista();
        arrIntegerNuevo = leeFicheroArray();

        for (Integer integerValor : arrIntegerNuevo) {
            listaBase.addInteger(integerValor);
        }

        //BLOQUE TRY-CATCH WITH RESOURCES
        try (ObjectOutputStream escritura = new ObjectOutputStream(new FileOutputStream(fichero))) {
            escritura.writeObject(listaBase);
        } catch (FileNotFoundException ignored) { //En caso de que no se encuentre el fichero.
        } catch (IOException e) { //En caso de que se produzca un error de escritura.
            System.out.println("Se produjo un error de escritura.");
        }

        System.out.println("\nEl array fusionado final es: ");
        System.out.println(Arrays.toString(listaBase.arrIntegers));
    }

    /*******************************************************************************************************************
     * Busca un Integer en el array utilizando el algoritmo de búsqueda binaria.                                       *
     *                                                                                                                 *
     * @param integer El Integer que se desea buscar en el array.                                                      *
     * @return El índice del Integer en el array, o un valor negativo si no se encuentra.                              *
     *******************************************************************************************************************/
    private int buscaInteger(Integer integer) {
        return Arrays.binarySearch(this.arrIntegers, integer);
    }

    /*******************************************************************************************************************
     * Lee un archivo y devuelve un objeto de tipo Lista.                                                              *
     *                                                                                                                 *
     * @return Un objeto de la clase Lista.                                                                            *
     *******************************************************************************************************************/
    private static Lista leeFicheroLista() {
        File fichero = new File("src/tema11_FicherosBinarios/ejerciciosPropuestos/" +
                "ejercicioPropuesto24_FicheroFusion/documentos/ficheroBase.dat"); //File que contiene el fichero con el listado de números.

        if (fichero.exists()) {
            //BLOQUE TRY-CATCH WITH RESOURCES
            try (ObjectInputStream lectura = new ObjectInputStream(new FileInputStream(fichero))) {
                return (Lista) lectura.readObject();
            } catch (FileNotFoundException ignored) { //En caso de que no se encuentre el fichero.
            } catch (IOException e) { //En caso de que se produzca un error de lectura.
                System.out.println("Se produjo un error de lectura.");
            } catch (ClassNotFoundException e) { //En caso de que no se encuentre un objeto de la clase indicada.
                System.out.println("No se encontró una lista en el fichero.");
            }
        }
        return new Lista();
    }

    /*******************************************************************************************************************
     * Lee un archivo y devuelve un array de Integer con los elementos de la lista.                                    *
     *                                                                                                                 *
     * @return Un array de Integer con los elementos de la lista.                                                      *
     *******************************************************************************************************************/
    private static Integer[] leeFicheroArray() {
        File fichero = new File("src/tema11_FicherosBinarios/ejerciciosPropuestos/" +
                "ejercicioPropuesto24_FicheroFusion/documentos/ficheroNuevo.dat"); //File que contiene el fichero con el listado de números.

        if (fichero.exists()) {
            //BLOQUE TRY-CATCH WITH RESOURCES
            try (ObjectInputStream lectura = new ObjectInputStream(new FileInputStream(fichero))) {
                return ((Lista) lectura.readObject()).arrIntegers;
            } catch (FileNotFoundException ignored) { //En caso de que no se encuentre el fichero.
            } catch (IOException e) { //En caso de que se produzca un error de lectura.
                System.out.println("Se produjo un error de lectura.");
            } catch (ClassNotFoundException e) { //En caso de que no se encuentre un objeto de la clase indicada.
                System.out.println("No se encontró un array de Integer en el fichero.");
            }
        }
        return new Integer[0];
    }
}
