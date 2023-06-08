package tema07_Clases.ejerciciosResueltos.ejercicioResuelto04_cuentaCorriente4.clases;
/***********************************************************************************************************************
 * Clase encargada de la ejecución del programa.                                                                       *
 ***********************************************************************************************************************/
public class Iniciador {
    public static void inicio() {
        //CREACIÓN DE OBJETOS
        CuentaCorriente cuentaCorriente1 = new CuentaCorriente("Alberto", "12345678-T");

        System.out.println(cuentaCorriente1.muestraInformacion());
        CuentaCorriente.setStrNombreBanco("Nuevo banco");
        System.out.println(cuentaCorriente1.muestraInformacion());
    }
}
