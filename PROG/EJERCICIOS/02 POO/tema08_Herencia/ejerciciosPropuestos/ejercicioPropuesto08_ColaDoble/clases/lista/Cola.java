package tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto08_ColaDoble.clases.lista;

/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo Cola y de manejar sus atributos y métodos correspondientes.              *
 ***********************************************************************************************************************/
public class Cola extends Lista {
    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *******************************************************************************************************************/
    public Cola() {
        super();
    }
    
    /*******************************************************************************************************************
     * Método encargado de guardar elementos en el final del array.                                                    *
     *******************************************************************************************************************/
    public void encolarFinal(int intNum) {
        this.insertaFinal(intNum);
    }

    /*******************************************************************************************************************
     * Método encargado de eliminar elementos del principio del array.                                                 *
     *                                                                                                                 *
     * @return El método devuelve el Integer eliminado.                                                                *
     *******************************************************************************************************************/
    public Integer desencolarInicio() {
        return this.eliminaInicio();
    }
}
