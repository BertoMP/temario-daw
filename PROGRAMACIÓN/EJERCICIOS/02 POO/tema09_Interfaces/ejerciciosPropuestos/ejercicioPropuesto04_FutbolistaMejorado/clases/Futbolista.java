package tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto04_FutbolistaMejorado.clases;

import java.util.Objects;

/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo futbolista. La clase implementa la interfaz Comparable.                  *
 ***********************************************************************************************************************/
public class Futbolista implements Comparable{
    //DECLARACIÓN DE ATRIBUTOS
    private final String STR_DNI; //String que guarda el DNI del futbolista.
    private String strNombre; //String que guarda el nombre del futbolista.
    private int intEdad; //String que guarda la edad del futbolista.
    private int intNumGoles; //String que guarda el número de goles del futbolista.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *                                                                                                                 *
     * @param strDni DNI del futbolista.                                                                               *
     * @param strNombre Nombre del futbolista.                                                                         *
     * @param intEdad Edad del futbolista.                                                                             *
     * @param intNumGoles Número de goles del futbolista.                                                              *
     *******************************************************************************************************************/
    public Futbolista(String strDni, String strNombre, int intEdad, int intNumGoles) {
        this.STR_DNI = strDni;
        this.strNombre = strNombre;
        this.intEdad = intEdad;
        this.intNumGoles = intNumGoles;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver el nombre del futbolista.                                                          *
     *                                                                                                                 *
     * @return Devuelve un String con el nombre del futbolista.                                                        *
     *******************************************************************************************************************/
    public String getStrNombre() {
        return this.strNombre;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver la edad del futbolista.                                                            *
     *                                                                                                                 *
     * @return Devuelve un int con la edad del futbolista.                                                             *
     *******************************************************************************************************************/
    public int getIntEdad() {
        return this.intEdad;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver un String con los datos del futbolista.                                            *
     *                                                                                                                 *
     * @return Devuelve un String con los datos del futbolista.                                                        *
     *******************************************************************************************************************/
    @Override
    public String toString() {
        return "Futbolista: DNI: " + this.STR_DNI + ", Nombre: " + this.strNombre + ", Edad: " + this.intEdad +
                ", Número de Goles: " + this.intNumGoles;
    }

    /*******************************************************************************************************************
     * Método encargado de comparar dos objetos (de tipo Futbolista) en base a su DNI.                                 *
     *                                                                                                                 *
     * @param objeto Objeto de la clase Object.                                                                        *
     * @return Devuelve un booleano en función de si el objeto es el mismo (true) o no (false).                        *
     *******************************************************************************************************************/
    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) return true;
        if (objeto == null || this.getClass() != objeto.getClass()) return false;

        Futbolista otroFutbolista = (Futbolista) objeto;

        return Objects.equals(this.STR_DNI, otroFutbolista.STR_DNI);
    }

    /*******************************************************************************************************************
     * Implementación del método abstracto compareTo de la interfaz Comparable.                                        *
     *                                                                                                                 *
     * @param objeto Objeto de la clase Object.                                                                        *
     * @return Devuelve un int resultado de la comparación.                                                            *
     *******************************************************************************************************************/
    @Override
    public int compareTo(Object objeto) {
        Futbolista otroFutbolista = (Futbolista) objeto;
        return this.STR_DNI.compareTo(otroFutbolista.STR_DNI);
    }
}
