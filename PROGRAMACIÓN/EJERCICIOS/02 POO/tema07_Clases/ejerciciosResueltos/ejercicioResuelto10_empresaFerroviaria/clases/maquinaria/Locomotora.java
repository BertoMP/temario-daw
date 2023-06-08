package tema07_Clases.ejerciciosResueltos.ejercicioResuelto10_empresaFerroviaria.clases.maquinaria;
import tema07_Clases.ejerciciosResueltos.ejercicioResuelto10_empresaFerroviaria.clases.personal.Mecanico;
/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo Locomotora y de manejar sus atributos y métodos correspondientes.        *
 ***********************************************************************************************************************/
public class Locomotora {
    //DECLARACIÓN DE VARIABLES
    private final String STR_MATRICULA; //Variable que guarda la matrícula de la locomotora.
    private int intPotencia; //Variable que guardará la potencia de la locomotora.
    private final int INT_ANNO_FABRICACION; //Variable que guardará el año de fabricación.
    private Mecanico mecanico; //Objeto de tipo mecanico.

    /*******************************************************************************************************************
     * Constructor principal de la clase.                                                                              *
     *                                                                                                                 *
     * @param strMatricula Matrícula de la locomotora.                                                                 *
     * @param intPotencia Potencia de la locomotora.                                                                   *
     * @param intAnnoFabricacion Año de fabricación de la locomotora.                                                  *
     * @param mecanico Mecánico asignado a la locomotora.                                                              *
     *******************************************************************************************************************/
    public Locomotora (String strMatricula, int intPotencia, int intAnnoFabricacion, Mecanico mecanico) {
        this.STR_MATRICULA = strMatricula;
        this.intPotencia = intPotencia;
        this.INT_ANNO_FABRICACION = intAnnoFabricacion;
        this.mecanico = mecanico;
    }
}
