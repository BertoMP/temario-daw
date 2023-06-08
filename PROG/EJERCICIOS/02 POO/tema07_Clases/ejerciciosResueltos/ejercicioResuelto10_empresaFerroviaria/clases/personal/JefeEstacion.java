package tema07_Clases.ejerciciosResueltos.ejercicioResuelto10_empresaFerroviaria.clases.personal;
import java.util.Date;
/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo JefeEstación y de manejar sus atributos y métodos correspondientes.      *
 ***********************************************************************************************************************/
public class JefeEstacion {
    //DECLARACIÓN DE VARIABLES
    private String strNombre; //Variable que guardará el nombre del jefe de estación.
    private final String STR_DNI; //Variable que guardará el DNI del jefe de estación.
    private Date dateFechaNombramiento; //Variable que guardará la fecha de nombramiento del jefe de estación.

    /*******************************************************************************************************************
     * Constructor principal de la clase.                                                                              *
     *                                                                                                                 *
     * @param strNombre Nombre del jefe de estación.                                                                   *
     * @param strDni DNI del jefe de estación.                                                                         *
     * @param dateFechaNombramiento Fecha de nombramiento del jefe de estación.                                        *
     *******************************************************************************************************************/
    public JefeEstacion(String strNombre, String strDni, Date dateFechaNombramiento) {
        this.strNombre = strNombre;
        this.STR_DNI = strDni;
        this.dateFechaNombramiento = dateFechaNombramiento;
    }
}
