package tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto14_ListaObjectSobrecargaSuperclaseAbstracta.clases.animal;

import java.util.Objects;

/***********************************************************************************************************************
 * Clase Persona que implementa la interfaz Comparable.                                                                *
 ***********************************************************************************************************************/
public class Persona extends Animal {
    //DECLARACIÓN DE ATRIBUTOS
    private final String STR_DNI; //String que guarda el DNI de la persona.
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
        super(strNombre, intEdad);
        this.STR_DNI = strDni;
        this.strOficio = strOficio;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver un String con el oficio de la persona.                                             *
     *                                                                                                                 *
     * @return Devuelve un String con el oficio de la persona.                                                         *
     *******************************************************************************************************************/
    public String getSTR_DNI() {
        return this.STR_DNI;
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
}
