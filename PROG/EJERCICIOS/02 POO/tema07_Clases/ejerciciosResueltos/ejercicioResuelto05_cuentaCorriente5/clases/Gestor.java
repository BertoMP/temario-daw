package tema07_Clases.ejerciciosResueltos.ejercicioResuelto05_cuentaCorriente5.clases;

public class Gestor {
    //DECLARACIÓN DE VARIABLES
    public String strNombre; //Variable que guardará el nombre del gestor (visible por todas las clases).
    private final String strNum; //Variable que guardará el teléfono del gestor (inaccesible fuera de la clase).
    double rlnImporteMaximo; //Variable que guardará el importe máximo (visible por clases vecinas).

    /*******************************************************************************************************************
     * Constructor principal de la clase.                                                                              *
     *                                                                                                                 *
     * @param strNombre --> Nombre del gestor.                                                                         *
     * @param strNum --> Teléfono del gestor.                                                                          *
     * @param rlnImporteMaximo --> Importe máximo que puede manejar.                                                   *
     *******************************************************************************************************************/
    public Gestor (String strNombre, String strNum, double rlnImporteMaximo) {
        this.strNombre = strNombre;
        this.strNum = strNum;
        this.rlnImporteMaximo = rlnImporteMaximo;
    }

    /*******************************************************************************************************************
     * Constructor por defecto cuando no se conoce el importe máximo a manejar.                                        *
     *                                                                                                                 *
     * @param strNombre --> Nombre del gestor.                                                                         *
     * @param strNum --> Teléfono del gestor.                                                                          *
     *******************************************************************************************************************/
    public Gestor (String strNombre, String strNum) {
        this(strNombre, strNum, 10000.0);
    }

    //MÉTODO GET PARA PODER ACCEDER AL TELÉFONO DEL GESTOR DESDE CUALQUIER CLASE
    public String getStrNum() {
        return this.strNum;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver un String con la información del gestor.                                           *
     *                                                                                                                 *
     * @return String con la información del gestor.                                                                   *
     *******************************************************************************************************************/
    public String muestraInformacion() {
        return "Nombre: " + this.strNombre + " Número: " + this.strNum
                + " Importe máximo permitido: " + this.rlnImporteMaximo;
    }


}
