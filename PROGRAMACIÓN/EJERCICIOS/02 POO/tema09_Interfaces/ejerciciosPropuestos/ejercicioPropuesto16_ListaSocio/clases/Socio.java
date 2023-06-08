package tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto16_ListaSocio.clases;

import java.time.LocalDate;

/***********************************************************************************************************************
 * Clase Socio que implementa la interfaz Comparable.                                                                  *
 ***********************************************************************************************************************/
public class Socio implements Comparable{
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
     * Implementación del método compareTo de la interfaz Comparable modificado para ordenar por edad.                 *
     *                                                                                                                 *
     * @param objeto Objeto de la clase Object.                                                                        *
     * @return Devuelve un int resultado de la comparación.                                                            *
     *******************************************************************************************************************/
    @Override
    public int compareTo(Object objeto) {
        Socio otroSocio = (Socio) objeto;

        return Integer.compare(this.intEdad, otroSocio.intEdad);
    }

    /*******************************************************************************************************************
     * Método encargado de devolver un String con los datos del socio.                                                 *
     *                                                                                                                 *
     * @return Devuelve un String con los datos del socio.                                                             *
     *******************************************************************************************************************/
    @Override
    public String toString() {
        return "ID:" + this.INT_ID + ", Nombre: " + this.strNombre + ", Edad: " + this.intEdad
                + ", Fecha de nacimiento: " + this.fechaNacimiento;
    }
}
