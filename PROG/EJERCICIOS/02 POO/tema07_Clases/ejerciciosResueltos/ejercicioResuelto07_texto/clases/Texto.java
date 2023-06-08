package tema07_Clases.ejerciciosResueltos.ejercicioResuelto07_texto.clases;
import java.time.LocalDate;
import java.time.LocalDateTime;
/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo Texto con sus atributos y métodos correspondientes.                      *
 ***********************************************************************************************************************/
public class Texto {
    //DECLARACIÓN DE VARIABLES
    private String strCadenaTexto; //Variable que guarda la cadena de texto.
    private final LocalDate FECHA_CREACION; //Constante que guarda la fecha de creación del texto.
    private LocalDateTime fechaUltimaModificacion; //Variable que guarda la fecha de última modificación.
    private final int INT_LONGITUD_MAXIMA; //Constante que guarda la longitud máxima del texto.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *                                                                                                                 *
     * @param INT_LONGITUD_MAXIMA -> Longitud máxima del texto.                                                        *
     *******************************************************************************************************************/
    public Texto(int INT_LONGITUD_MAXIMA) {
        this.strCadenaTexto = "";
        this.INT_LONGITUD_MAXIMA = INT_LONGITUD_MAXIMA;
        this.FECHA_CREACION = LocalDate.now();
        this.fechaUltimaModificacion = null;
    }

    /*******************************************************************************************************************
     * Método encargado de añadir un carácter al final o al inicio de la cadena siempre que sea posible (si la         *
     * longitud del texto actual es menor a la longitud máxima marcada por el constructor).                            *
     *                                                                                                                 *
     * @param chrCaracter -> Carácter a añadir.                                                                        *
     * @param intNum -> Opción elegida por el usuario.                                                                 *
     *******************************************************************************************************************/
    public void anadeCaracter(char chrCaracter, int intNum) {
        if (this.strCadenaTexto.length() < this.INT_LONGITUD_MAXIMA) {
            if (intNum == 1) {
                this.strCadenaTexto += chrCaracter;
            } else {
                this.strCadenaTexto = chrCaracter + this.strCadenaTexto;
            }
            this.fechaUltimaModificacion = LocalDateTime.now();
        } else {
            System.out.println("No es posible añadir ese carácter porque se ha llegado al límite máximo.");
        }
    }

    /*******************************************************************************************************************
     * Método encargado de añadir una cadena al final o al inicio de la cadena original siempre que sea posible        *
     * (si la longitud del texto actual es menor a la longitud máxima marcada por el constructor).                     *
     *                                                                                                                 *
     * @param strCadena -> Cadena a añadir.                                                                            *
     * @param intNum -> Opción elegida por el usuario.                                                                 *
     *******************************************************************************************************************/
    public void anadeCadena(String strCadena, int intNum) {
        if (this.strCadenaTexto.length() + strCadena.length() <= this.INT_LONGITUD_MAXIMA) {
            if (intNum == 3) {
                this.strCadenaTexto += strCadena;
            } else {
                this.strCadenaTexto = strCadena + this.strCadenaTexto;
            }
            this.fechaUltimaModificacion = LocalDateTime.now();
        } else {
            System.out.println("No es posible añadir esa cadena porque se superaría el límite máximo.");
        }
    }

    /*******************************************************************************************************************
     * Método encargado de mostrar la información relativa al valor de los atributos del objeto de la clase.           *
     *******************************************************************************************************************/
    public String mostrar() {
        //RETURN
        return "Texto: " + this.strCadenaTexto
                + "\nFecha de creación: " + this.FECHA_CREACION
                + "\nFecha última modificación: " + this.fechaUltimaModificacion;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver el número de vocales contenidas en el texto.                                       *
     *                                                                                                                 *
     * @return El método devuelve un int con la cantidad de vocales contenidas en el texto.                            *
     *******************************************************************************************************************/
    public int numeroVocales() {
        //DECLARACIÓN DE VARIABLES
        int intContVocales = 0; //Variable tipo contador que almacena el número de vocales encontradas.

        for (int intCont = 0; intCont < strCadenaTexto.length(); intCont++) {
            if (Character.isLetter(strCadenaTexto.charAt(intCont))) {
                if (Texto.esVocal(strCadenaTexto.charAt(intCont))) {
                    intContVocales++;
                }
            }
        }

        //RETURN
        return intContVocales;
    }

    /*******************************************************************************************************************
     * Método privado encargado de comprobar si la letra pasada por parámetro.                                         *
     *                                                                                                                 *
     * @param chrLetra -> Letra a comprobar.                                                                           *
     * @return El método devuelve un booleano en función de si la letra pasada por parámetro es vocal (true) o         *
     *         consonante (false).                                                                                     *
     *******************************************************************************************************************/
    private static boolean esVocal(char chrLetra) {
        //DECLARACIÓN DE VARIABLES
        final String STR_VOCALES = "áaéeíióoúüu"; //Constante tipo String que almacena todas las vocales con y sin caracteres especiales.

        //RETURN
        return STR_VOCALES.indexOf(Character.toLowerCase(chrLetra)) != -1;
    }
}
