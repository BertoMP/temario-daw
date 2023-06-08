package tema10_FicherosDeTexto.ejerciciosPropuestos.ejercicioPropuesto11_AgendaTelefonica.clases;

/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo Contacto. Implementa la interfaz Comparable.                             *
 ***********************************************************************************************************************/
public class Contacto implements Comparable<Contacto>{
    //DECLARACIÓN DE ATRIBUTOS
    private String strNombre; //String que guarda el nombre del contacto.
    private int intNum; //Int que guarda el número del contacto.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *                                                                                                                 *
     * @param strNombre Nombre del contacto.                                                                           *
     * @param intNum Número de teléfono del contacto.                                                                  *
     *******************************************************************************************************************/
    public Contacto(String strNombre, int intNum) {
        this.strNombre = strNombre;
        this.intNum = intNum;
    }

    /*******************************************************************************************************************
     * Método getter para el nombre del contacto.                                                                      *
     *                                                                                                                 *
     * @return Devuelve un String con el nombre del contacto.                                                          *
     *******************************************************************************************************************/
    public String getStrNombre() {
        return this.strNombre;
    }

    /*******************************************************************************************************************
     * Método getter para el número del contacto.                                                                      *
     *                                                                                                                 *
     * @return Devuelve un int con el número del contacto.                                                             *
     *******************************************************************************************************************/
    public int getIntNum() {
        return this.intNum;
    }

    /*******************************************************************************************************************
     * Método que devuelve una cadena con los datos del contacto.                                                      *
     *                                                                                                                 *
     * @return Devuelve un String con los datos del contacto.                                                          *
     *******************************************************************************************************************/
    public String toString() {
        return "Nombre: " + this.strNombre +
                "\nTeléfono: " + this.intNum;
    }

    /*******************************************************************************************************************
     * Override del método compareTo de la interfaz Comparable.                                                        *
     *                                                                                                                 *
     * @param otroContacto Contacto con el que comparar.                                                               *
     * @return Devuelve un int que sirve para ordenar dos objetos Contacto.                                            *
     *******************************************************************************************************************/
    @Override
    public int compareTo(Contacto otroContacto) {
        return this.strNombre.compareTo(otroContacto.strNombre);
    }
}
