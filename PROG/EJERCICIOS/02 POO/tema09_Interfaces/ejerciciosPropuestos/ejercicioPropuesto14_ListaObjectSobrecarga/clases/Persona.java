package tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto14_ListaObjectSobrecarga.clases;

import java.util.Objects;

/***********************************************************************************************************************
 * Clase Persona que implementa la interfaz Comparable.                                                                *
 ***********************************************************************************************************************/
public class Persona implements Comparable {
    //DECLARACIÓN DE ATRIBUTOS
    private String strNombre; //String que guarda el nombre de la persona.
    private final String STR_DNI; //String que guarda el DNI de la persona.
    private int intEdad; //Int que guarda la edad de la persona.
    private String strOficio; //String que guarda el oficio de la persona.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *                                                                                                                 *
     * @param strNombre String que contiene el nombre de la persona.                                                   *
     * @param strDni String que contiene el DNI de la persona.                                                         *
     * @param intEdad Int que contiene el int de la persona.                                                           *
     * @param strOficio String que contiene el oficio de la persona.                                                   *
     *******************************************************************************************************************/
    public Persona(String strNombre, String strDni, int intEdad, String strOficio) {
        this.strNombre = strNombre;
        this.STR_DNI = strDni;
        this.intEdad = intEdad;
        this.strOficio = strOficio;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver un String con el nombre de la persona.                                             *
     *                                                                                                                 *
     * @return Devuelve un String con el nombre de la persona.                                                         *
     *******************************************************************************************************************/
    public String getStrNombre() {
        return this.strNombre;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver un int con la edad de la persona.                                                  *
     *                                                                                                                 *
     * @return Devuelve un String con la edad de la persona.                                                           *
     *******************************************************************************************************************/
    public int getIntEdad() {
        return this.intEdad;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver un String con el oficio de la persona.                                             *
     *                                                                                                                 *
     * @return Devuelve un String con el oficio de la persona.                                                         *
     *******************************************************************************************************************/
    public String getStrOficio() {
        return this.strOficio;
    }

    /*******************************************************************************************************************
     * Método encargado de comparar dos objetos.                                                                       *
     *                                                                                                                 *
     * @param objeto Objeto de la clase Object.                                                                        *
     * @return Devuelve un booleano en función de si es el mismo objeto (true) o no (false).                           *
     *******************************************************************************************************************/
    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) {
            return true;
        }

        if (objeto == null || this.getClass() != objeto.getClass()) {
            return false;
        }

        Persona otraPersona = (Persona) objeto;

        return Objects.equals(this.intEdad, otraPersona.intEdad)
                && Objects.equals(this.strNombre, otraPersona.strNombre)
                && Objects.equals(this.STR_DNI, otraPersona.STR_DNI)
                && Objects.equals(this.strOficio, otraPersona.strOficio);
    }

    /*******************************************************************************************************************
     * Método encargado de devolver un String con los datos de la persona.                                             *
     *                                                                                                                 *
     * @return Devuelve un String con los datos de la persona.                                                         *
     *******************************************************************************************************************/
    @Override
    public String toString() {
        return "Persona -> Nombre: " + this.strNombre + ", DNI: " + this.STR_DNI + ", Edad: " + this.intEdad
                + ", Oficio: " + this.strOficio;
    }

    /*******************************************************************************************************************
     * Implementación del método abstracto compareTo de la interfaz Comparable modificado para realizar una comparación*
     * por el dni de la persona.                                                                                       *
     *                                                                                                                 *
     * @param objeto Objeto de la clase Object.                                                                        *
     * @return Devuelve un int resultado de la comparación.                                                            *
     *******************************************************************************************************************/
    @Override
    public int compareTo(Object objeto) {
        Persona otraPersona = (Persona) objeto;

        return this.STR_DNI.compareTo(otraPersona.STR_DNI);
    }
}
