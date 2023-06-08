package tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto03_CajaCarton.clases.caja;

import tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto03_CajaCarton.enumerados.Unidad;

/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo caja.                                                                    *
 ***********************************************************************************************************************/
public class Caja {
    //DECLARACIÓN DE VARIABLES
    protected final int INT_ANCHO; //Variable que guardará el ancho de la caja.
    protected final int INT_ALTO; //Variable que guardará el alto de la caja.
    protected final int INT_FONDO; //Variable que guardará el fondo de la caja.
    protected Unidad unidadMedida; //Variable que guardará la unidad de medida utilizada.
    protected String strEtiqueta; //Variable que guardará un String con la etiqueta de la caja.
    protected static final int INT_LONGITUD_MAXIMA = 30; //Constante que guarda el número máximo de caracteres de la etiqueta.

    /*******************************************************************************************************************
     * Constructor principal de la clase.                                                                              *
     *                                                                                                                 *
     * @param intAncho Ancho de la caja.                                                                               *
     * @param intAlto Alto de la caja.                                                                                 *
     * @param intFondo Fondo de la caja.                                                                               *
     * @param unidadMedida Unidad de medida utilizada.                                                                 *
     *******************************************************************************************************************/
    public Caja(int intAncho, int intAlto, int intFondo, Unidad unidadMedida) {
        this.INT_ANCHO = intAncho;
        this.INT_ALTO = intAlto;
        this.INT_FONDO = intFondo;
        this.unidadMedida = unidadMedida;
        this.strEtiqueta = "Sin etiqueta asignada.";
    }

    /*******************************************************************************************************************
     * Método encargado de calcular el volumen de la caja.                                                             *
     *                                                                                                                 *
     * @return Devuelve el volumen de la caja.                                                                         *
     *******************************************************************************************************************/
    public double getVolumen() {
        return this.INT_ANCHO * this.INT_ALTO * this.INT_FONDO;
    }

    /*******************************************************************************************************************
     * Método encargado de guardar en el objeto un String pasado como parámetro.                                       *
     *                                                                                                                 *
     * @param strEtiqueta String a almacenar en la variable strEtiqueta.                                               *
     *******************************************************************************************************************/
    public void setStrEtiqueta(String strEtiqueta) {
        if (strEtiqueta.length() > Caja.INT_LONGITUD_MAXIMA) {
            System.out.println("La etiqueta generada es demasiado larga.");
        } else {
            this.strEtiqueta = strEtiqueta;
        }
    }

    /*******************************************************************************************************************
     * Método encargado de devolver un String con los datos del objeto.                                                *
     *                                                                                                                 *
     * @return Devuelve un String con los datos del objeto.                                                            *
     *******************************************************************************************************************/
    @Override
    public String toString() {
        return "DATOS DE LA CAJA:" +
                "\n\t-Etiqueta: " + this.strEtiqueta +
                "\n\t-Ancho: " + this.INT_ANCHO +
                "\n\t-Alto: " + this.INT_ALTO +
                "\n\t-Fondo: " + this.INT_FONDO +
                "\n\t-Unidad: " + this.unidadMedida +
                "\n\t-Volumen: " + (int) this.getVolumen() + "cm3";
    }
}