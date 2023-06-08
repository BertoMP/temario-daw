package tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto07_ListaImplementsColaObject.clases;

/***********************************************************************************************************************
 * Clase Perro.                                                                                                        *
 ***********************************************************************************************************************/
public class Perro {
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
     * Método que devuelve un String con los datos del perro.                                                          *
     *                                                                                                                 *
     * @return Devuelve un String con los datos del perro.                                                             *
     *******************************************************************************************************************/
    @Override
    public String toString() {
        return "Perro -> Nombre: " + this.strNombre + ", Raza: " + this.strRaza + ", Edad: " + this.intEdad;
    }
}
