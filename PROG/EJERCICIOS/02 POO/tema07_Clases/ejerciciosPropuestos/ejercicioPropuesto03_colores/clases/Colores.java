package tema07_Clases.ejerciciosPropuestos.ejercicioPropuesto03_colores.clases;
import java.util.Arrays;
import java.util.Scanner;
/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo Colores y de manejar sus atributos y métodos correspondientes.           *
 ***********************************************************************************************************************/
public class Colores {
    //DECLARACIÓN DE VARIABLES
    private String strColores; //Variable que guardará los colores.

    /*******************************************************************************************************************
     * Constructor principal de la clase.                                                                              *
     *******************************************************************************************************************/
    public Colores() {
        this.strColores = "rojo, verde, azul";
    }

    /*******************************************************************************************************************
     * Método encargado de devolver un String con los colores.                                                         *
     *                                                                                                                 *
     * @return String con los colores.                                                                                 *
     *******************************************************************************************************************/
    public String getStrColores() {
        return this.strColores;
    }

    /*******************************************************************************************************************
     * Método encargado de fijar el valor del atributo String strColores.                                              *
     *                                                                                                                 *
     * @param strColores Nuevo valor del atributo.                                                                     *
     *******************************************************************************************************************/
    public void setStrColores(String strColores) {
        this.strColores = strColores;
    }

    /*******************************************************************************************************************
     * Método encargado de generar una tabla sin colores repetidos.                                                    *
     *                                                                                                                 *
     * @param intNum Número de colores a introducir.                                                                   *
     * @param scEntrada Objeto scanner.                                                                                *
     * @return Devuelve una tabla con colores sin repetir.                                                             *
     *******************************************************************************************************************/
    public String[] imprimeColoresSinRepetidos(int intNum, Scanner scEntrada) {
        //DECLARACIÓN DE VARIABLES
        String[] strTodosLosColores; //Array que guardará todos los colores.
        String[] strArrayReturn = new String[0]; //Array que guardará los colores sin repetir y lo devolverá como resultado.
        int intNumAleatorio; //Variable que guardará un número aleatorio.

        strTodosLosColores = this.strColores.split(", ");

        while (intNum > strTodosLosColores.length) {
            System.out.println("Has solicitado más colores de los que hay diferentes ("
                            + (strTodosLosColores.length) + "). Vuelve a introducir un número.");
            System.out.print("Cantidad de colores: ");
            intNum = scEntrada.nextInt();
        }

        if (intNum == strTodosLosColores.length) {
            return strTodosLosColores;
        } else {
            for (int intCont = 0; intCont < intNum;) {
                intNumAleatorio = (int) (Math.random() * strTodosLosColores.length);
                if (!estaEnElArray(strTodosLosColores[intNumAleatorio], strArrayReturn)) {
                    strArrayReturn = Arrays.copyOf(strArrayReturn, strArrayReturn.length + 1);
                    strArrayReturn[strArrayReturn.length - 1] = strTodosLosColores[intNumAleatorio];
                    intCont++;
                }
            }
            return strArrayReturn;
        }
    }

    /*******************************************************************************************************************
     * Método encargado de comprobar si un color se encuentra ya en el array.                                          *
     *                                                                                                                 *
     * @param strColor String con un color.                                                                            *
     * @param strArray Array con los colores sin repetir.                                                              *
     * @return Devuelve un booleano, si el color está en el array devolverá un true, si no lo está, devolverá un false.*
     *******************************************************************************************************************/
    private boolean estaEnElArray(String strColor, String[] strArray) {
        for (String strValor : strArray) {
            if (strValor.equals(strColor)) {
                return true;
            }
        }
        return false;
    }
}
