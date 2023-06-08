package tema07_Clases.ejerciciosResueltos.ejercicioResuelto10_empresaFerroviaria.clases.maquinaria;
/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo Vagon y de manejar sus atributos y métodos correspondientes.             *
 ***********************************************************************************************************************/
class Vagon {
    //DECLARACIÓN DE VARIABLES
    private final int INT_NUM_ID; //Variable que guardará el número de identificación del vagón.
    private double rlnCargaMax; //Variable que guardará la carga máxima del vagón.
    private double rlnCargaActual; //Variable que guardará la carga actual del vagón.
    private String strTipoMercancia; //Variable que guardará el tipo de mercancía del vagón.

    /*******************************************************************************************************************
     * Constructor principal de la clase.                                                                              *
     *                                                                                                                 *
     * @param intNumId Número de identificación del vagón.                                                             *
     * @param rlnCargaMax Carga máxima del vagón.                                                                      *
     * @param rlnCargaActual Carga actual del vagón.                                                                   *
     * @param strTipoMercancia Tipo de mercancía del vagón.                                                            *
     *******************************************************************************************************************/
    public Vagon (int intNumId, double rlnCargaMax, double rlnCargaActual, String strTipoMercancia) {
        this.INT_NUM_ID = intNumId;
        this.rlnCargaMax = rlnCargaMax;
        this.rlnCargaActual = rlnCargaActual;
        this.strTipoMercancia = strTipoMercancia;
    }
}
