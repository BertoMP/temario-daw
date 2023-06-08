package tema07_Clases.ejerciciosResueltos.ejercicioResuelto14_metodoNoEstaticoEnMain;
import java.util.Arrays;
/***********************************************************************************************************************
 * Insertar el método no estático                                                                                      *
 *      void insertaFinal(int nuevo)                                                                                        *
 * que insertar un número entero al final de tablaEnteros[], que es un atributo no estático de la clase Inicio2.          *
 * Escribir un programa que inicialice la tabla con los números del 1 al 10 y después la muestre por consola.          *
 ***********************************************************************************************************************/
public class Main {
    //DECLARACIÓN DE VARIABLES
    private int[] intArrTablaEnteros; //Array de int

    public Main() {
        this.intArrTablaEnteros = new int[0];
    }

    public static void main(String[] args) {
        //DECLARACIÓN E INSTANCIACIÓN DE OBJETOS
        Main main = new Main(); //Objeto de la clase Main.

        for (int intCont = 1; intCont <= 10; intCont++) {
            main.insertarFinal(intCont);
        }

        System.out.println("Tabla: " + Arrays.toString(main.intArrTablaEnteros));
    }

    /*******************************************************************************************************************
     * Método encargado de insertar números al final de un array.                                                      *
     *                                                                                                                 *
     * @param intNuevo Número que se debe introducir en el array.                                                      *
     *******************************************************************************************************************/
    private void insertarFinal(int intNuevo) {
        this.intArrTablaEnteros = Arrays.copyOf(this.intArrTablaEnteros, this.intArrTablaEnteros.length + 1);
        this.intArrTablaEnteros[this.intArrTablaEnteros.length - 1] = intNuevo;
    }
}
