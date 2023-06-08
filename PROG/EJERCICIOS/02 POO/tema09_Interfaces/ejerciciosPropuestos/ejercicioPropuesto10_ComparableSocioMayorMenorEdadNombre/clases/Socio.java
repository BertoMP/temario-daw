package tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto10_ComparableSocioMayorMenorEdadNombre.clases;

/***********************************************************************************************************************
 * Clase Socio que implementa la interfaz Comparable.                                                                  *
 ***********************************************************************************************************************/
public class Socio implements Comparable {
    //DECLARACIÓN DE ATRIBUTOS
    private int intId; //Int que guarda el ID del socio.
    private String strNombre; //String que guarda el nombre del socio.
    private int intEdad; //Int que guarda la edad del socio.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *                                                                                                                 *
     * @param intId Int que contiene el ID del socio.                                                                  *
     * @param strNombre String que contiene el nombre del socio.                                                       *
     * @param intEdad Int que contiene la edad del socio.                                                              *
     *******************************************************************************************************************/
    public Socio(int intId, String strNombre, int intEdad) {
        this.intId = intId;
        this.strNombre = strNombre;
        this.intEdad = intEdad;
    }

    /*******************************************************************************************************************
     * Implementación del método compareTo de la interfaz Comparable modificado para ordenar por edad. En el caso de   *
     * que la edad sea la misma realizará una ordenación por nombre.                                                   *
     *                                                                                                                 *
     * @param objeto Objeto de la clase Object.                                                                        *
     * @return Devuelve un int resultado de la comparación.                                                            *
     *******************************************************************************************************************/
    @Override
    public int compareTo(Object objeto) {
        int intNumero;

        Socio otroSocio = (Socio) objeto;
        intNumero = Integer.compare(this.intEdad, otroSocio.intEdad);

        if (intNumero == 0) {
            return Integer.compare(this.intId, otroSocio.intId);
        } else {
            return intNumero;
        }
    }

    /*******************************************************************************************************************
     * Método encargado de devolver un String con los datos del socio.                                                 *
     *                                                                                                                 *
     * @return Devuelve un String con los datos del socio.                                                             *
     *******************************************************************************************************************/
    @Override
    public String toString() {
        return "ID:" + this.intId + ", Nombre: " + this.strNombre + ", Edad: " + this.intEdad;
    }
}
