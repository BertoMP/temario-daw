package tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto12_ComparatorSocioNombre.clases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/***********************************************************************************************************************
 * Clase Socio que implementa la interfaz Comparable.                                                                  *
 ***********************************************************************************************************************/
public class Socio implements Comparable<Socio> {
    //DECLARACIÓN DE ATRIBUTOS
    private final int INT_ID; //Int que guarda el ID del socio.
    private String strNombre; //String que guarda el nombre del socio.
    private int intEdad; //Int que guarda la edad del socio.
    private LocalDate fechaNacimiento; //LocalDate que guarda la fecha de nacimiento del socio.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *                                                                                                                 *
     * @param intId Int que contiene el ID del socio.                                                                  *
     * @param strNombre String que contiene el nombre del socio.                                                       *
     * @param intEdad Int que contiene la edad del socio.                                                              *
     * @param fechaNacimiento LocalDate que contiene la fecha de nacimiento del socio.                                 *
     *******************************************************************************************************************/
    public Socio(int intId, String strNombre, int intEdad, LocalDate fechaNacimiento) {
        this.INT_ID = intId;
        this.strNombre = strNombre;
        this.intEdad = intEdad;
        this.fechaNacimiento = fechaNacimiento;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver un String con el nombre del socio.                                                 *
     *                                                                                                                 *
     * @return Devuelve un String con el nombre del socio.                                                             *
     *******************************************************************************************************************/
    public String getStrNombre() {
        return this.strNombre;
    }

    /*******************************************************************************************************************
     * Implementación del método compareTo de la interfaz Comparable modificado para ordenar por fecha de nacimiento.  *
     *                                                                                                                 *
     * @param otroSocio Objeto de la clase Socio.                                                                      *
     * @return Devuelve un int resultado de la comparación.                                                            *
     *******************************************************************************************************************/
    @Override
    public int compareTo(Socio otroSocio) {
        return this.fechaNacimiento.compareTo(otroSocio.fechaNacimiento);
    }

    /*******************************************************************************************************************
     * Método encargado de devolver un String con los datos del socio.                                                 *
     *                                                                                                                 *
     * @return Devuelve un String con los datos del socio.                                                             *
     *******************************************************************************************************************/
    @Override
    public String toString() {
        return "ID:" + this.INT_ID + ", Nombre: " + this.strNombre + ", Edad: " + this.intEdad
                + ", Fecha de nacimiento: " + this.fechaNacimiento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
