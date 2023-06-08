package tema09_Interfaces.ejerciciosResueltos.ejercicioResuelto06_encolarMultiple.clases.interfaces;
/***********************************************************************************************************************
 * Interfaz de Cola.                                                                                                   *
 ***********************************************************************************************************************/
public interface Cola {
    /*******************************************************************************************************************
     * Método abstracto para push elementos.                                                                        *
     *                                                                                                                 *
     * @param numero Número a push.                                                                                 *
     *******************************************************************************************************************/
    void encolar (Integer numero);

    /*******************************************************************************************************************
     * Método abstracto para popPila elementos.                                                                     *
     *                                                                                                                 *
     * @return El método una vez implementado devolverá un Integer.                                                    *
     *******************************************************************************************************************/
    Integer desencolar();

    /*******************************************************************************************************************
     * Método encargado de llamar n veces al método push.                                                           *
     *                                                                                                                 *
     * @param numero Número a push.                                                                                 *
     * @param intRepeticiones Veces que hay que push el número.                                                     *
     *******************************************************************************************************************/
    default void encolarMultiple(Integer numero, int intRepeticiones) {
        for (int intCont = 0; intCont < intRepeticiones; intCont++) {
            encolar(numero);
        }
    }
}
