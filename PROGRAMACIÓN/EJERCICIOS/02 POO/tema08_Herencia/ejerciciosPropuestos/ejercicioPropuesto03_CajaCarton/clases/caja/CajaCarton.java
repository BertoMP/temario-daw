package tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto03_CajaCarton.clases.caja;

import tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto03_CajaCarton.enumerados.Unidad;

/***********************************************************************************************************************
 * Clase encargada de generar objetos CajaCarton que heredan de Caja.                                                  *
 ***********************************************************************************************************************/
public class CajaCarton extends Caja {
    /*******************************************************************************************************************
     * Constructor principal de la clase.                                                                              *
     *                                                                                                                 *
     * @param intAncho Ancho de la caja.                                                                               *
     * @param intAlto Alto de la caja.                                                                                 *
     * @param intFondo Fondo de la caja.                                                                               *
     *******************************************************************************************************************/
    public CajaCarton(int intAncho, int intAlto, int intFondo) {
        super(intAncho, intAlto, intFondo, Unidad.CM);
    }

    /*******************************************************************************************************************
     * Método encargado de calcular el volumen de la caja.                                                             *
     *                                                                                                                 *
     * @return Devuelve el volumen de la caja.                                                                         *
     *******************************************************************************************************************/
    @Override
    public double getVolumen() {
        return super.getVolumen() * 0.8;
    }

    /*******************************************************************************************************************
     * Método encargado de calcular la superficie de la caja.                                                          *
     *                                                                                                                 *
     * @return Devuelve la superficie de la caja.                                                                      *
     *******************************************************************************************************************/
    public int getSuperficie() {
        return 2 * (this.INT_ALTO * this.INT_ANCHO + this.INT_ANCHO * this.INT_FONDO + this.INT_FONDO * this.INT_ALTO);
    }

    /*******************************************************************************************************************
     * Método encargado de devolver un String con los datos del objeto.                                                *
     *                                                                                                                 *
     * @return Devuelve un String con los datos del objeto.                                                            *
     *******************************************************************************************************************/
    @Override
    public String toString() {
        return super.toString() +
                "\n\t-Superficie: " + this.getSuperficie() + "cm2";
    }
}
