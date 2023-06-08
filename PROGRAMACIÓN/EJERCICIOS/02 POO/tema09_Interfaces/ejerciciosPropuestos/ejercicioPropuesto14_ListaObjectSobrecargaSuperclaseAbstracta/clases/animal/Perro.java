package tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto14_ListaObjectSobrecargaSuperclaseAbstracta.clases.animal;

import java.util.Objects;

/***********************************************************************************************************************
 * Clase Perro.                                                                                                        *
 ***********************************************************************************************************************/
public class Perro extends Animal {
    private String strRaza; //String que guarda la raza del perro.
    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *                                                                                                                 *
     * @param strNombre String que contiene el nombre del perro.                                                       *
     * @param strRaza String que contiene la raza del perro.                                                           *
     * @param intEdad Int que contiene la edad del perro.                                                              *
     *******************************************************************************************************************/
    public Perro(String strNombre, String strRaza, int intEdad) {
        super(strNombre, intEdad);
        this.strRaza = strRaza;
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
}
