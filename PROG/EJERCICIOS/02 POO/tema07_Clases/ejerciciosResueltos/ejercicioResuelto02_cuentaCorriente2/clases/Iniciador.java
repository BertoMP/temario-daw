package tema07_Clases.ejerciciosResueltos.ejercicioResuelto02_cuentaCorriente2.clases;

/***********************************************************************************************************************
 * Clase encargada de la ejecución del programa.                                                                       *
 ***********************************************************************************************************************/
public class Iniciador {
    public static void inicio() {
        //CREACIÓN DE OBJETOS CON LOS DIFERENTES CONSTRUCTORES
        //Constructor de nombre y dni del cliente
        CuentaCorriente cuentaCorriente1 = new CuentaCorriente("Alberto", "12345678-T");
        //Constructor de nombre del cliente, su dni y saldo inicial de la cuenta
        CuentaCorriente cuentaCorriente2 = new CuentaCorriente("Ana", "87654321-A", 200.0);
        //Constructor de dni del cliente y saldo inicial de la cuenta
        CuentaCorriente cuentaCorriente3 = new CuentaCorriente("23456789-T", 500.0);
        //Constructor por defecto.
        CuentaCorriente cuentaCorriente4 = new CuentaCorriente();

        //COMPROBACIÓN DEL FUNCIONAMIENTO DE LOS OBJETOS
        System.out.println(cuentaCorriente1.muestraInformacion());
        System.out.println(cuentaCorriente2.muestraInformacion());
        System.out.println(cuentaCorriente3.muestraInformacion());
        System.out.println(cuentaCorriente4.muestraInformacion());
    }
}
