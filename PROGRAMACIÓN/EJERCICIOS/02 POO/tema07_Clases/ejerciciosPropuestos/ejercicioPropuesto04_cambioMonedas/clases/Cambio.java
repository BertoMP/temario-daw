package tema07_Clases.ejerciciosPropuestos.ejercicioPropuesto04_cambioMonedas.clases;

import java.math.BigDecimal;

/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo Cambio y de manejar sus atributos y métodos correspondientes.            *
 ***********************************************************************************************************************/
public class Cambio {
    //DECLARACIÓN DE VARIABLES
    private final static double[] RLN_ARR_CAMBIOS_POSIBLES = //Posibles billetes y monedas de cambio (estático, es dependiente de la clase y no del objeto).
            {500, 200, 100, 50, 20, 10, 5, 2, 1, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01};
    private final int[] RLN_ARR_CANTIDAD_CAMBIO; //Array que guardará las monedas y billetes de cada tipo.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *******************************************************************************************************************/
    public Cambio(){
        this.RLN_ARR_CANTIDAD_CAMBIO = new int[Cambio.RLN_ARR_CAMBIOS_POSIBLES.length];
    }

    /*******************************************************************************************************************
     * Método encargado de calcular el cambio (en monedas y billetes) que se debe devolver.                            *
     *                                                                                                                 *
     * @param rlnCambioCliente Cambio a entregar.                                                                      *
     *******************************************************************************************************************/
    public void calculaCambio(double rlnCambioCliente) {
        for (int intCont = 0; rlnCambioCliente != 0; intCont++) {
            if (rlnCambioCliente >= Cambio.RLN_ARR_CAMBIOS_POSIBLES[intCont]) {
                this.RLN_ARR_CANTIDAD_CAMBIO[intCont] =
                        (int) (rlnCambioCliente / Cambio.RLN_ARR_CAMBIOS_POSIBLES[intCont]);
                rlnCambioCliente %= Cambio.RLN_ARR_CAMBIOS_POSIBLES[intCont];
                rlnCambioCliente = Math.round(rlnCambioCliente * 100) / 100.0;

                if (Cambio.RLN_ARR_CAMBIOS_POSIBLES[intCont] > 2) {
                    System.out.println("\t- " + this.RLN_ARR_CANTIDAD_CAMBIO[intCont]
                            + " billete/s de " + Cambio.RLN_ARR_CAMBIOS_POSIBLES[intCont] + " €.");
                } else {
                    System.out.println("\t- " + this.RLN_ARR_CANTIDAD_CAMBIO[intCont]
                            + " moneda/s de " + Cambio.RLN_ARR_CAMBIOS_POSIBLES[intCont] + " €.");
                }
            }
        }
    }
}
