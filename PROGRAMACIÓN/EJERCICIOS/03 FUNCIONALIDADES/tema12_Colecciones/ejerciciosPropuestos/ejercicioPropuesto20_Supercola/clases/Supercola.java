package tema12_Colecciones.ejerciciosPropuestos.ejercicioPropuesto20_Supercola.clases;

/***********************************************************************************************************************
 * Clase Supercola.                                                                                                    *
 ***********************************************************************************************************************/

public class Supercola {
    //DECLARACIÓN DE ATRIBUTOS
    private Cola<Integer> colaUno; //Objeto Cola para almacenar elementos Integer.
    private Cola<Integer> colaDos; //Objeto Cola para almacenar elementos Integer.

    /*******************************************************************************************************************
     * Constructor principal de la clase.                                                                              *
     *******************************************************************************************************************/
    public Supercola() {
        this.colaUno = new Cola<>();
        this.colaDos = new Cola<>();
    }

    /*******************************************************************************************************************
     * Método encargado de almacenar un nuevo elemento en la cola que se pasa por parámetro.                           *
     *                                                                                                                 *
     * @param integerElemento Integer a almacenar.                                                                     *
     * @param blnCola Boolean para decidir la cola en la que insertar: true -> 1 / false -> 2.                         *
     *******************************************************************************************************************/
    public void push(Integer integerElemento, boolean blnCola) {
        if (blnCola) {
            this.colaUno.push(integerElemento);
        } else {
            this.colaDos.push(integerElemento);
        }
    }

    /*******************************************************************************************************************
     * Método encargado de eliminar un elemento de la cola que se pasa como parámetro.                                 *
     *                                                                                                                 *
     * @param blnCola Boolean para decidir la cola en la que eliminar: true -> 1 / false -> 2.                         *
     * @return En caso de que la cola seleccionada tenga elementos, elimina el elemento de la cola. Si la cola         *
     *         seleccionada no tiene más elementos, intenta eliminar de la otra cosa. En caso de que ninguna cola      *
     *         tenga elementos, devuelve un null.                                                                      *
     *******************************************************************************************************************/
    public Integer pop(boolean blnCola) {
        //DECLARACIÓN DE OBJETOS
        Cola<Integer> colaAUtilizar; //Objeto cola que determina la cola que se debe utilizar.
        Integer integerReturn = null; //Objeto Integer que almacena el Integer eliminado y lo devuelve como resultado de la función.

        if (blnCola) {
            colaAUtilizar = this.colaUno;
        } else {
            colaAUtilizar = this.colaDos;
        }

        if (colaAUtilizar.dimeTamanyo() > 0) {
            integerReturn = colaAUtilizar.pop();
        } else if (blnCola && this.colaDos.dimeTamanyo() > 0) {
            System.out.println("No hay elementos en la cola 1, se desencolará en la 2.");
            integerReturn = this.colaDos.pop();
        } else if (!blnCola && this.colaUno.dimeTamanyo() > 0) {
            System.out.println("No hay elementos en la cola 2, se desencolará en la 1.");
            integerReturn = this.colaUno.pop();
        } else {
            System.out.println("No quedan elementos en ninguna cola");
        }
        return integerReturn;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver un String con el contenido de ambas colas.                                         *
     *                                                                                                                 *
     * @return Devuelve un String con el contenido de ambas colas.                                                     *
     *******************************************************************************************************************/
    @Override
    public String toString() {
        return "Cola 1 -> " + this.colaUno +
                "\nCola 2 -> " + this.colaDos;
    }
}
