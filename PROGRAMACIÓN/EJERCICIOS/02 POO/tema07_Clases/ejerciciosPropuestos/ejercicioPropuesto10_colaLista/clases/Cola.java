package tema07_Clases.ejerciciosPropuestos.ejercicioPropuesto10_colaLista.clases;
/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo Cola y de manejar sus atributos y métodos correspondientes.              *
 ***********************************************************************************************************************/
public class Cola {
    //DECLARACIÓN DE OBJETOS
    private final Lista LISTA; //Objeto de tipo Lista

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *******************************************************************************************************************/
    public Cola() {
        this.LISTA = new Lista();
    }

    /*******************************************************************************************************************
     * Método encargado de push (guardar) elementos en el array.                                                    *
     *                                                                                                                 *
     * @param intNum Siguiente número a push.                                                                       *
     *******************************************************************************************************************/
    public void encola(int intNum) {
        this.LISTA.inserta(intNum);
    }

    /*******************************************************************************************************************
     * Método encargado de popPila (eliminar) elementos en el array.                                                *
     *                                                                                                                 *
     * @param intIndice Siguiente indice a popPila.                                                                 *
     * @return El método devuelve el Integer eliminado.                                                                *
     *******************************************************************************************************************/
    public Integer desencola(int intIndice) {
        return this.LISTA.elimina(intIndice);
    }

    /*******************************************************************************************************************
     * Método encargado de mostrar los elementos de la cola.                                                           *
     *                                                                                                                 *
     * @return Devuelve un String del array de Integers.                                                               *
     *******************************************************************************************************************/
    public String muestraCola() {
        return this.LISTA.muestraElementos();
    }
}
