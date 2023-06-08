package tema14_AccesoADatos.ejerciciosPropuestos.ejercicioPropuesto12_SelectLista.clases;

/**********************************************************************************************************************
 * Clase Oficina.                                                                                                      *
 ***********************************************************************************************************************/

public class Oficina {
    //DECLARACIÓN DE ATRIBUTOS
    private Integer intNumero; //Int que almacena el número de identificación de la oficina.
    private String strNombre; //String que almacena el nombre de la oficina.
    private String strCiudad; //String que almacena la ciudad de la oficina.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *                                                                                                                 *
     * @param intNumero Número de identificación de la oficina.                                                        *
     * @param strNombre Nombre de la oficina.                                                                          *
     * @param strCiudad Ciudad de la oficina.                                                                          *
     *******************************************************************************************************************/
    public Oficina(Integer intNumero, String strNombre, String strCiudad) {
        this.intNumero = intNumero;
        this.strNombre = strNombre;
        this.strCiudad = strCiudad;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver un String con los valores de los atributos de la oficina.                          *
     *                                                                                                                 *
     * @return Devuelve un String con los datos de la oficina.                                                         *
     *******************************************************************************************************************/
    @Override
    public String toString() {
        return "Oficina número: " + this.intNumero +
                "\n\t - Nombre: " + this.strNombre +
                "\n\t - Ciudad: " + this.strCiudad;
    }
}
