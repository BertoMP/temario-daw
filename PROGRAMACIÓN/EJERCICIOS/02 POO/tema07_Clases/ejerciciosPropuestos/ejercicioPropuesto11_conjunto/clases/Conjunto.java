package tema07_Clases.ejerciciosPropuestos.ejercicioPropuesto11_conjunto.clases;
/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo Conjunto y de manejar sus atributos y métodos correspondientes.          *
 ***********************************************************************************************************************/
public class Conjunto {
    //DECLARACIÓN DE OBJETOS
    private final Lista LISTA; //Objeto de tipo lista.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *******************************************************************************************************************/
    public Conjunto() {
        this.LISTA = new Lista();
    }

    /*******************************************************************************************************************
     * Método encargado de devolver el número de elementos de un conjunto.                                             *
     *                                                                                                                 *
     * @return Devuelve el int que recibe desde la llamada.                                                            *
     *******************************************************************************************************************/
    public int numeroElementos() {
        return this.LISTA.numeroElementos();
    }

    /*******************************************************************************************************************
     * Método encargado de devolver si un elemento se ha insertado o no en el conjunto.                                *
     *                                                                                                                 *
     * @param numero Integer a insertar en el conjunto.                                                                *
     * @return Devuelve el booleano que recibe desde la llamada.                                                       *
     *******************************************************************************************************************/
    public boolean insertar(Integer numero) {
       return this.LISTA.inserta(numero);
    }
    /*******************************************************************************************************************
     * Método encargado de devolver si un conjunto se ha insertado o no en el conjunto.                                *
     *                                                                                                                 *
     * @param otroConjunto Conjunto a insertar en el conjunto invocante.                                               *
     * @param intNum Opción elegida por el usuario.                                                                    *
     * @return Devuelve el booleano que recibe desde la llamada.                                                       *
     *******************************************************************************************************************/
    public boolean insertar(Conjunto otroConjunto, int intNum) {
        return this.LISTA.anadeOtraLista(otroConjunto.LISTA, intNum);
    }

    /*******************************************************************************************************************
     * Método encargado de devolver si un elemento se ha eliminado o no en el conjunto.                                *
     *                                                                                                                 *
     * @param numero Integer a eliminar del conjunto.                                                                  *
     * @return Devuelve el booleano que recibe desde la llamada.                                                       *
     *******************************************************************************************************************/
    public boolean eliminarElemento(Integer numero) {
        return this.LISTA.elimina(numero);
    }

    /*******************************************************************************************************************
     * Método encargado de devolver si un conjunto se ha eliminado o no en el conjunto.                                *
     *                                                                                                                 *
     * @param otroConjunto Conjunto a eliminar del conjunto invocante.                                                 *
     * @param intNum Opción elegida por el usuario.                                                                    *
     * @return Devuelve el booleano que recibe desde la llamada.                                                       *
     *******************************************************************************************************************/
    public boolean eliminarConjunto(Conjunto otroConjunto, int intNum) {
        return this.LISTA.eliminaOtraLista(otroConjunto.LISTA, intNum);
    }

    /*******************************************************************************************************************
     * Método encargado de devolver si un elemento existe o no en el conjunto.                                         *
     *                                                                                                                 *
     * @param numero Integer a comprobar si existe en el conjunto.                                                     *
     * @return Devuelve el booleano que recibe desde la llamada.                                                       *
     *******************************************************************************************************************/
    public boolean pertenece (Integer numero) {
        return this.LISTA.buscaElemento(numero);
    }

    /*******************************************************************************************************************
     * Método encargado de la lista de elementos del conjunto.                                                         *
     *                                                                                                                 *
     * @return Devuelve el String que recibe desde la llamada.                                                         *
     *******************************************************************************************************************/
    public String muestra() {
        return this.LISTA.muestraLista();
    }
}
