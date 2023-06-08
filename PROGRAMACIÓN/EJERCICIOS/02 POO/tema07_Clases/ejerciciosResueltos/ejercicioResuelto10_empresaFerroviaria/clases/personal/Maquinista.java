package tema07_Clases.ejerciciosResueltos.ejercicioResuelto10_empresaFerroviaria.clases.personal;
/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo Maquinista y de manejar sus atributos y métodos correspondientes.        *
 ***********************************************************************************************************************/
public class Maquinista {
    //DECLARACIÓN DE VARIABLES
    private String strNombre; //Variable que guardará el nombre del maquinista.
    private final String STR_DNI; //Variable que guardará el DNI del maquinista.
    private double rlnSueldo; //Variable que guardará el sueldo del maquinista.
    private String strRango; //Variable que guardará el rango del maquinista.

    /*******************************************************************************************************************
     * Constructor principal de la clase.                                                                              *
     *                                                                                                                 *
     * @param strNombre Nombre del maquinista.                                                                         *
     * @param strDni DNI del maquinista.                                                                               *
     * @param rlnSueldo Sueldo del maquinista.                                                                         *
     * @param strRango Rango del maquinista.                                                                           *
     *******************************************************************************************************************/
    public Maquinista(String strNombre, String strDni, double rlnSueldo, String strRango) {
        this.strNombre = strNombre;
        this.STR_DNI = strDni;
        this.rlnSueldo = rlnSueldo;
        this.strRango = strRango;
    }
}
