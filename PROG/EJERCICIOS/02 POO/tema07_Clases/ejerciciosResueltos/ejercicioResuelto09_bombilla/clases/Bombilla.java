package tema07_Clases.ejerciciosResueltos.ejercicioResuelto09_bombilla.clases;
/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo Bombilla y de manejar sus atributos y métodos correspondientes.          *
 ***********************************************************************************************************************/
public class Bombilla {
    //DECLARACIÓN DE VARIABLES
    private static boolean blnEstadoInterruptorGeneral = true; //Variable static que guarda el estado del interruptor general.
    private boolean blnEstadoBombilla; //Variable que guarda el estado de la bombilla.

    /*******************************************************************************************************************
     * Constructor principal de la clase.                                                                              *
     *******************************************************************************************************************/
    public Bombilla() {
        this.blnEstadoBombilla = false;
    }

    /*******************************************************************************************************************
     * Método set que sirve para cambiar el estado de una bombilla.                                                    *
     *                                                                                                                 *
     * @param blnEstadoEncendidoApagado Booleano con el estado de la bombilla: true (encendida) o false (apagada).     *
     *******************************************************************************************************************/
    public void setBlnEstadoBombilla(boolean blnEstadoEncendidoApagado) {
        this.blnEstadoBombilla = blnEstadoEncendidoApagado;
    }

    /*******************************************************************************************************************
     * Método set que sirve para mostrar el estado de una bombilla.                                                    *
     *                                                                                                                 *
     * @return El método devuelve un String en función de si la bombilla está encendida o apagada.                     *
     *******************************************************************************************************************/
    public String muestraEstadoBombilla() {
        return this.blnEstadoBombilla && Bombilla.blnEstadoInterruptorGeneral ? "Encendida" : "Apagada";
    }

    /*******************************************************************************************************************
     * Método estático de tipo set que cambia el estado del interruptor general.                                       *
     *                                                                                                                 *
     * @param blnEstadoInterruptorGeneral Booleano con el estado del interruptor general: true (encendido)             *
     *                                    o false (apagado).                                                           *
     *******************************************************************************************************************/
    public static void setBlnInterruptorLuzGeneral(boolean blnEstadoInterruptorGeneral) {
        Bombilla.blnEstadoInterruptorGeneral = blnEstadoInterruptorGeneral;
    }
}
