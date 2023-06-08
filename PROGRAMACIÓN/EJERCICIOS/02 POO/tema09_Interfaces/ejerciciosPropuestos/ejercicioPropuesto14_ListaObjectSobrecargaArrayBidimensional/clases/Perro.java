package tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto14_ListaObjectSobrecargaArrayBidimensional.clases;

import java.util.Objects;

/***********************************************************************************************************************
 * Clase Perro.                                                                                                        *
 ***********************************************************************************************************************/
public class Perro implements Comparable {
    private String strNombre; //String que guarda el nombre del perro.
    private String strRaza; //String que guarda la raza del perro.
    private int intEdad; //Int que guarda la edad del perro.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *                                                                                                                 *
     * @param strNombre String que contiene el nombre del perro.                                                       *
     * @param strRaza String que contiene la raza del perro.                                                           *
     * @param intEdad Int que contiene la edad del perro.                                                              *
     *******************************************************************************************************************/
    public Perro(String strNombre, String strRaza, int intEdad) {
        this.strNombre = strNombre;
        this.strRaza = strRaza;
        this.intEdad = intEdad;
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

        Perro otroPerro = (Perro) objeto;

        return Objects.equals(this.strNombre, otroPerro.strNombre)
                && Objects.equals(this.strRaza, otroPerro.strRaza)
                && Objects.equals(this.intEdad, otroPerro.intEdad);
    }

    /*******************************************************************************************************************
     * Método que devuelve un String con los datos del perro.                                                          *
     *                                                                                                                 *
     * @return Devuelve un String con los datos del perro.                                                             *
     *******************************************************************************************************************/
    @Override
    public String toString() {
        return "Perro -> Nombre: " + this.strNombre + ", Raza: " + this.strRaza + ", Edad: " + this.intEdad;
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
        Perro otroPerro = (Perro) objeto;
        int intDevolver;

        intDevolver = this.strRaza.compareTo(otroPerro.strRaza);

        if (intDevolver == 0) {
            intDevolver = Integer.compare(this.intEdad, otroPerro.intEdad);
        }

        return intDevolver;
    }
}
