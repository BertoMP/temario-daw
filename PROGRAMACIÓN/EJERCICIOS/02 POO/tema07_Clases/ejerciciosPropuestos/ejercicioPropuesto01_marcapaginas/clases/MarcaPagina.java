package tema07_Clases.ejerciciosPropuestos.ejercicioPropuesto01_marcapaginas.clases;
/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo MarcaPagina y de manejar sus atributos y métodos correspondientes.       *
 ***********************************************************************************************************************/
public class MarcaPagina {
    //DECLARACIÓN DE VARIABLES
    private int intPagina; //Variable que guardará la página que se debe marcar.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *******************************************************************************************************************/
    public MarcaPagina() {
        this.intPagina = 1;
    }

    /*******************************************************************************************************************
     * Método encargado de fijar la última página leída.                                                               *
     *                                                                                                                 *
     * @param intPagina Última página leída.                                                                           *
     *******************************************************************************************************************/
    public void marcaUltimaPaginaLeida(int intPagina) {
        this.intPagina = intPagina;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver la última página leída.                                                            *
     *                                                                                                                 *
     * @return Devuelve la última página leída.                                                                        *
     *******************************************************************************************************************/
    public int dimeUltimaPaginaLeida() {
        return this.intPagina;
    }

    /*******************************************************************************************************************
     * Método encargado de iniciar una nueva lectura.                                                                  *
     *******************************************************************************************************************/
    public void nuevaLectura() {
        this.marcaUltimaPaginaLeida(1);
    }
}
