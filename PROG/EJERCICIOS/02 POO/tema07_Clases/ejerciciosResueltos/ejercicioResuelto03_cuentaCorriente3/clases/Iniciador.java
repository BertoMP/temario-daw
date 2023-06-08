package tema07_Clases.ejerciciosResueltos.ejercicioResuelto03_cuentaCorriente3.clases;

/***********************************************************************************************************************
 * Clase encargada de la ejecución del programa.                                                                       *
 ***********************************************************************************************************************/
public class Iniciador {
    public static void inicio() {
        //CREACIÓN DE OBJETOS
        CuentaCorriente cuentaCorriente1 = new CuentaCorriente("Alberto", "12345678-T");

        //COMPROBACIÓN DEL FUNCIONAMIENTO DE LOS OBJETOS
        System.out.println("Antes del cambio: " + cuentaCorriente1.strDni);
        cuentaCorriente1.strDni = "12121212-T";
        System.out.println("Después del cambio: " + cuentaCorriente1.strDni);
        System.out.println("Antes del cambio: " + cuentaCorriente1.strNombre);
        cuentaCorriente1.strNombre = "Pepe";
        System.out.println("Después del cambio: " + cuentaCorriente1.strNombre);
        // System.out.println(cuentaCorriente1.rlnSaldo); No lo permite.
        // cuentaCorriente1.rlnSaldo = 100.0; No lo permite tampoco.
    }
}
