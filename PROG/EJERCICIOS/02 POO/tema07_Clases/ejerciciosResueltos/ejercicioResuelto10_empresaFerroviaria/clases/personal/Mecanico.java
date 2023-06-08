package tema07_Clases.ejerciciosResueltos.ejercicioResuelto10_empresaFerroviaria.clases.personal;
/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo Mecánico y de manejar sus atributos y métodos correspondientes.          *
 ***********************************************************************************************************************/
public class Mecanico {
    //ENUM PARA LAS POSIBLES ESPECIALIDADES DE LA CLASE
    private enum Especialidad {FRENOS, HIDRAULICA, ELECTRICIDAD, MOTOR}

    //DECLARACIÓN DE VARIABLES
    private String strNombre; //Variable que guarda el nombre del mecánico.
    private String strNumero; //Variable que guarda el número del mecánico.
    private Especialidad especialidad; //Variable que guarda la especialidad del mecánico.

    /*******************************************************************************************************************
     * Constructor principal de la clase.                                                                              *
     *                                                                                                                 *
     * @param strNombre Nombre del mecánico.                                                                           *
     * @param strNumero Teléfono del mecánico.                                                                         *
     * @param especialidad Especialidad del mecánico.                                                                  *
     *******************************************************************************************************************/
    public Mecanico(String strNombre, String strNumero, String especialidad) {
        this.strNombre = strNombre;
        this.strNumero = strNumero;
        this.especialidad = Especialidad.valueOf(especialidad);
    }
}
