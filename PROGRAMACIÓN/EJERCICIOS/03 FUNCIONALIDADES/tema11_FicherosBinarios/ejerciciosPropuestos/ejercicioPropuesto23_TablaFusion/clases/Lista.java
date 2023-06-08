package tema11_FicherosBinarios.ejerciciosPropuestos.ejercicioPropuesto23_TablaFusion.clases;

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
     * Busca un Integer en el array utilizando el algoritmo de búsqueda binaria.                                       *
     *                                                                                                                 *
     * @param integer El Integer que se desea buscar en el array.                                                      *
     * @return El índice del Integer en el array, o un valor negativo si no se encuentra.                              *
     *******************************************************************************************************************/
    private int buscaInteger(Integer integer) {
        return Arrays.binarySearch(this.arrIntegers, integer);
    }

    /*******************************************************************************************************************
     * Método que fusiona dos ficheros de enteros en un único array ordenado.                                          *
     *                                                                                                                 *
     * @param strFichero1 Nombre del primer fichero de enteros.                                                        *
     * @param strFichero2 Nombre del segundo fichero de enteros.                                                       *
     * @return Un array de enteros fusionado y ordenado.                                                               *
     *******************************************************************************************************************/
    public static Integer[] fusionar(String strFichero1, String strFichero2) {
        //DECLARACIÓN DE VARIABLES
        Integer[] arrInteger1; //Array de integers del primer fichero.
        Integer[] arrInteger2; //Array de integers del segundo fichero.
        Integer[] arrFusionadoReturn; //Array de integers fusionado que se devolverá como resultado.
        int intContArray1 = 0; //Int que funciona como contador del array del primer fichero.
        int intContArray2 = 0; //Int que funciona como contador del array del segundo fichero.
        int intContArrayFusionado; //Int que funciona como contador del array fusionado.

        arrInteger1 = leeFichero(strFichero1);
        arrInteger2 = leeFichero(strFichero2);

        arrFusionadoReturn = new Integer[arrInteger1.length + arrInteger2.length];

        for (intContArrayFusionado = 0; intContArray1 < arrInteger1.length &&
                intContArray2 < arrInteger2.length; intContArrayFusionado++) {
            if (arrInteger1[intContArray1] <= arrInteger2[intContArray2]) {
                arrFusionadoReturn[intContArrayFusionado] = arrInteger1[intContArray1];
                intContArray1++;
            } else {
                arrFusionadoReturn[intContArrayFusionado] = arrInteger2[intContArray2];
                intContArray2++;
            }
        }

        if (intContArray1 < arrInteger1.length) {
            System.arraycopy(arrInteger1, intContArray1, arrFusionadoReturn, intContArrayFusionado,
                    arrInteger1.length - intContArray1);
        } else {
            System.arraycopy(arrInteger2, intContArray2, arrFusionadoReturn, intContArrayFusionado,
                    arrInteger2.length - intContArray2);
        }

        return arrFusionadoReturn;
    }

    /*******************************************************************************************************************
     * Lee un archivo y devuelve un array de Integer con los elementos de la lista.                                    *
     *                                                                                                                 *
     * @param strNombreFichero El nombre del archivo que se desea leer.                                                *
     * @return Un array de Integer con los elementos de la lista.                                                      *
     *******************************************************************************************************************/
    private static Integer[] leeFichero(String strNombreFichero) {
        File fichero = new File("src/tema11_FicherosBinarios/ejerciciosPropuestos/" +
                "ejercicioPropuesto23_TablaFusion/documentos/" + strNombreFichero);

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
