package tema07_Clases.ejerciciosResueltos.ejercicioResuelto01_cuentaCorriente.clases;
import java.util.Scanner;
/***********************************************************************************************************************
 * Clase encargada de la ejecución del programa.                                                                       *
 ***********************************************************************************************************************/
public class Iniciador {
    /*******************************************************************************************************************
     * Método encargado de imprimir opciones para la selección por parte del usuario.                                  *
     *                                                                                                                 *
     * @return La función devuelve la opción elegida por el usuario.                                                   *
     *******************************************************************************************************************/
    private static int imprimeOpciones(Scanner scEntrada) {
        System.out.println("""
                       BIENVENIDO A LA APLICACIÓN BANCARIA
                Elija una de las siguientes opciones para continuar:
                    1. Sacar dinero.
                    2. Hacer un ingreso en cuenta.
                    3. Ver los datos de la cuenta.
                    4. Salir.""");
        System.out.print("Opción: ");
        return scEntrada.nextInt();
    }

    public static void inicio() {
        //CREACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in);
        CuentaCorriente cuentaCorriente1 = new CuentaCorriente("Alberto", "47234226-T");

        //DECLARACIÓN DE VARIABLES
        int intOpcionUsuario;
        double rlnDinero;

        //DO WHILE PARA LA REPETICIÓN EN BUCLE DE LAS OPCIONES
        do {
            //LLAMADA AL MÉTODO imprimeOpciones()
            intOpcionUsuario = imprimeOpciones(scEntrada);

            //WHILE EN CASO DE OPCIÓN NO VÁLIDA
            while (intOpcionUsuario < 1 || intOpcionUsuario > 4) {
                System.out.println("Error ha elegido una opción no valida.\n");
                intOpcionUsuario = imprimeOpciones(scEntrada);
            }

            //SWITCH PARA LAS DIFERENTES OPCIONES DISPONIBLES
            switch (intOpcionUsuario) {
                case 1 -> {
                    System.out.print("Introduzca la cantidad que quiere sacar: ");
                    rlnDinero = scEntrada.nextDouble();
                    //LLAMADA AL MÉTODO sacarDinero(double) DE LA CLASE CuentaCorriente
                    cuentaCorriente1.sacarDinero(rlnDinero);
                }
                case 2 -> {
                    System.out.print("Introduzca la cantidad que quiera ingresar: ");
                    rlnDinero = scEntrada.nextDouble();
                    //LLAMADA AL MÉTODO hazIngreso(double) DE LA CLASE CuentaCorriente
                    cuentaCorriente1.hazIngreso(rlnDinero);
                }
                case 3 -> {
                    //LLAMADA AL MÉTODO muestraInformacion() DE LA CLASE CuentaCorriente
                    cuentaCorriente1.muestraInformacion();
                }
                case 4 -> {
                    System.out.println("Gracias por usar la aplicación.");
                }
            }

            System.out.println();

        } while (intOpcionUsuario != 4);
    }
}
