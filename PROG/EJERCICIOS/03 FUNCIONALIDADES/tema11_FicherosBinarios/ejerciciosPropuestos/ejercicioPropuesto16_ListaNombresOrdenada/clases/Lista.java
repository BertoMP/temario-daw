package tema11_FicherosBinarios.ejerciciosPropuestos.ejercicioPropuesto16_ListaNombresOrdenada.clases;

import java.io.Serializable;
import java.util.Arrays;

/***********************************************************************************************************************
 * Clase lista.                                                                                                        *
 ***********************************************************************************************************************/

public class Lista implements Serializable {
    //DECLARACIÓN DE ATRIBUTOS
    private String[] strArrNombres; //Array de String que guardará los nombres.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *******************************************************************************************************************/
    public Lista() {
        this.strArrNombres = new String[0];
    }

    /*******************************************************************************************************************
     * Método encargado de añadir una lista que se pasa por parámetro.                                                 *
     *                                                                                                                 *
     * @param nombresAnteriores Objeto de tipo lista.                                                                  *
     *******************************************************************************************************************/
    public void addListadoPrevio(Lista nombresAnteriores) {
        strArrNombres = Arrays.copyOf(nombresAnteriores.strArrNombres, nombresAnteriores.strArrNombres.length);
    }

    /*******************************************************************************************************************
     * Método encargado de añadir un nuevo nombre en la lista.                                                         *
     *                                                                                                                 *
     * @param strNombre Nombre a añadir.                                                                               *
     *******************************************************************************************************************/
    public void addNombre(String strNombre) {
        int intIndiceBusqueda;

        intIndiceBusqueda = buscaNombre(strNombre);
        if (intIndiceBusqueda < 0) {
            intIndiceBusqueda = -intIndiceBusqueda -1;
        }
        this.strArrNombres = Arrays.copyOf(this.strArrNombres, this.strArrNombres.length + 1);
        System.arraycopy(this.strArrNombres,intIndiceBusqueda,this.strArrNombres, intIndiceBusqueda + 1,
                this.strArrNombres.length - intIndiceBusqueda - 1);
        this.strArrNombres[intIndiceBusqueda] = strNombre;
        System.out.println("Nombre añadido.");
    }

    /*******************************************************************************************************************
     * Método encargado de mostrar el contenido de la lista.                                                           *
     *******************************************************************************************************************/
    public void muestraLista() {
        System.out.println(Arrays.toString(this.strArrNombres));
    }

    /*******************************************************************************************************************
     * Método encargado de buscar en el array un nombre que se pasa por parámetro y devolver el índice donde se        *
     * encuentra.                                                                                                      *
     *                                                                                                                 *
     * @param strNombre String con el nombre a buscar.                                                                 *
     * @return El índice del elemento en el array si se encuentra, de lo contrario devuelve un valor negativo.         *
     *******************************************************************************************************************/
    private int buscaNombre(String strNombre) {
        return Arrays.binarySearch(this.strArrNombres, strNombre);
    }
}
