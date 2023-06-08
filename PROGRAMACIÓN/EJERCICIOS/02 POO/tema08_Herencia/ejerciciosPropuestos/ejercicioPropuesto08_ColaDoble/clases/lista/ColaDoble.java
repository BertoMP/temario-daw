package tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto08_ColaDoble.clases.lista;

import java.util.Arrays;

/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo ColaDoble y de manejar sus atributos y métodos correspondientes.         *
 ***********************************************************************************************************************/
public class ColaDoble extends Cola {
    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *******************************************************************************************************************/
    public ColaDoble() {
        super();
    }

    /*******************************************************************************************************************
     * Método encargado de guardar elementos en el principio del array.                                                *
     *******************************************************************************************************************/
    public void encolarPrincipio(int intNum) {
        this.insertaInicio(intNum);
    }

    /*******************************************************************************************************************
     * Método encargado de eliminar elementos del final del array.                                                     *
     *                                                                                                                 *
     * @return El método devuelve el Integer eliminado.                                                                *
     *******************************************************************************************************************/
    public Integer desencolarFinal() {
        return this.eliminaFinal();
    }

    /*******************************************************************************************************************
     * Método encargado de devolver un String con los elementos de la Cola.                                            *
     *                                                                                                                 *
     * @return Devuelve un String con los elementos de la Cola.                                                        *
     *******************************************************************************************************************/
    @Override
    public String toString() {
        return Arrays.toString(this.integerNumeros);
    }
}
