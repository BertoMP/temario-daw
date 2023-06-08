package tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto06_ListaImplementsColaPilaObject.clases;

/***********************************************************************************************************************
 * Clase Persona.                                                                                                      *
 ***********************************************************************************************************************/
public class Persona {
    //DECLARACIÓN DE ATRIBUTOS
    private String strNombre; //String que guarda el nombre de la persona.
    private String strOficio; //String que guarda el oficio de la persona.
    private int intEdad; //Int que guarda la edad de la persona.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *                                                                                                                 *
     * @param strNombre String que contiene el nombre de la persona.                                                   *
     * @param strOficio String que contiene el oficio de la persona.                                                   *
     * @param intEdad String que contiene la edad de la persona.                                                       *
     *******************************************************************************************************************/
    public Persona(String strNombre, String strOficio, int intEdad) {
        this.strNombre = strNombre;
        this.strOficio = strOficio;
        this.intEdad = intEdad;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver un String con los datos de la persona.                                             *
     *                                                                                                                 *
     * @return Devuelve un String con los datos de la persona.                                                         *
     *******************************************************************************************************************/
    @Override
    public String toString() {
        return "Persona -> Nombre: " + this.strNombre + ", Oficio: " + this.strOficio + ", Edad: " + this.intEdad;
    }
}
