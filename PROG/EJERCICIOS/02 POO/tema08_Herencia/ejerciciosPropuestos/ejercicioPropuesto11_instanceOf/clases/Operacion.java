package tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto11_instanceOf.clases;

/***********************************************************************************************************************
 * Clase que genera objetos de tipo Operacion.                                                                         *
 ***********************************************************************************************************************/
public class Operacion {
    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *******************************************************************************************************************/
    public Operacion() {
    }

    /*******************************************************************************************************************
     * Método encargado de comprobar si un objeto pasado por parámetro es un número.                                   *
     *                                                                                                                 *
     * @param objeto Objeto de la clase Object.                                                                        *
     * @return Devuelve un booleano en función de si el objeto es un número (true) o no (false).                       *
     *******************************************************************************************************************/
    public static boolean esNumero (Object objeto) {
        return objeto instanceof Number;
    }

    /*******************************************************************************************************************
     * Método encargado de comprobar si un objeto pasado por parámetro es un String.                                   *
     *                                                                                                                 *
     * @param objeto Objeto de la clase Object.                                                                        *
     * @return Devuelve un booleano en función de si el objeto es un String (true) o no (false).                       *
     *******************************************************************************************************************/
    public static boolean esCadena (Object objeto) {
        return objeto instanceof String;
    }

    /*******************************************************************************************************************
     * Método encargado de concatenar 2 cadenas o sumar 2 números (convirtiéndolos a double). En caso de combinar      *
     * tipos se devuelve un "no sumables" como resultado.                                                              *
     *                                                                                                                 *
     * @param objetoA Objeto de la clase Object.                                                                       *
     * @param objetoB Objeto de la clase Object.                                                                       *
     * @return Devuelve un booleano en función de si la operación de suma/concatenación se ha podido realizar (true)   *
     *         o no (false). Además, se imprime en pantalla el resultado de la operación.                              *
     *******************************************************************************************************************/
    public boolean sumar (Object objetoA, Object objetoB) {
        if (Operacion.esCadena(objetoA) && Operacion.esCadena(objetoB)) {
            System.out.println("La concatenación de cadenas es: " + objetoA + objetoB);
            return true;
        } else if (Operacion.esNumero(objetoA) && Operacion.esNumero(objetoB)) {
            System.out.println("La suma de los objetos es: " + (Double.parseDouble(objetoA.toString())
                    + Double.parseDouble(objetoB.toString())));
            return true;
        } else {
            System.out.println("No sumables.");
            return false;
        }
    }
}
