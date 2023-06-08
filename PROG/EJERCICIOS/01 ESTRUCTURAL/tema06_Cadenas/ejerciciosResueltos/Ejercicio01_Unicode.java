package tema06_Cadenas.ejerciciosResueltos;
/***********************************************************************************************************************
 * Escribir un programa que muestre todos los caracteres Unicode junto con su code point, cuyo valor esté comprendido  *
 * entre \u0000 y \uFFFF.                                                                                              *
 ***********************************************************************************************************************/
public class Ejercicio01_Unicode {
    /*******************************************************************************************************************
     * Función encargada de controlar el desarrollo principal del programa.                                            *
     *******************************************************************************************************************/
    private static void inicio() {

        //BUCLE FOR PARA IMPRIMIR TODOS LOS VALORES
        for (int intContador = 0x0000; intContador <= 0xFFFF; intContador++) {
            /* Este bucle for se encarga de ir desde el primer valor hexadecimal 0x0000 hasta el último 0xFFFF
             * En cada iteración se convertirá el valor int (Integer) del contador en un valor hexadecimal convertido
             * en String a través del método toHexString();
             * Además, se imprimirá junto al carácter Unicode del contador, el cual debe ser
             * casteado/tipeado en char para poder realizarse la operación. */
            System.out.print("\\u" + Integer.toHexString(intContador) + " " + (char)intContador + "\t");
            if (intContador % 8 == 0) {
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        inicio();
    }
}
