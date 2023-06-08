package tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto05_Supercola.clases;

public class Supercola {
    //DECLARACIÓN DE ATRIBUTOS
    private Cola cola1; //Objeto de tipo Cola.
    private Cola cola2; //Objeto de tipo Cola.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *******************************************************************************************************************/
    public Supercola() {
        this.cola1 = new Cola();
        this.cola2 = new Cola();
    }

    /*******************************************************************************************************************
     * Método encargado de solicitar la inserción de un número en la cola correspondiente.                             *
     *                                                                                                                 *
     * @param intNum Número a insertar.                                                                                *
     * @param intCola Cola elegida.                                                                                    *
     *******************************************************************************************************************/
    public void push(int intNum, int intCola) {
        if (intCola == 1) {
            this.cola1.push(intNum);
        } else {
            this.cola2.push(intNum);
        }
    }

    /*******************************************************************************************************************
     * Método encargado de solicitar la eliminación de un número en la cola correspondiente. En caso de que la         *
     * cola elegida no tenga elementos se eliminará de la otra cola.                                                   *
     *                                                                                                                 *
     * @param intCola Cola elegida.                                                                                    *
     * @return Devuelve el Integer eliminado, en caso de que ambas colas estén vacías devuelve un null.                *
     *******************************************************************************************************************/
    public Integer pop(int intCola) {
        Cola colaAUtilizar;

        if (intCola == 3) {
            colaAUtilizar = this.cola1;
        } else {
            colaAUtilizar = this.cola2;
        }

        if (colaAUtilizar.getNumeroElementos() > 0) {
            return colaAUtilizar.pop(0);
        } else if (intCola == 3 && this.cola2.getNumeroElementos() > 0) {
            System.out.println("No hay elementos en la cola 1, se desencolará en la 2.");
            return this.cola2.pop(0);
            } else if (intCola == 4 && this.cola1.getNumeroElementos() > 0) {
                System.out.println("No hay elementos en la cola 2, se desencolará en la 1.");
                return this.cola1.pop(0);
                } else {
                    System.out.println("No quedan elementos en ninguna cola");
                }
        return null;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver un String con los elementos de ambas colas.                                        *
     *                                                                                                                 *
     * @return Devuelve un String con los elementos de las dos colas.                                                  *
     *******************************************************************************************************************/
    @Override
    public String toString() {
        return "Cola 1: " + this.cola1.toString() + "\nCola 2: " + this.cola2.toString();
    }
}
