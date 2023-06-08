package tema07_Clases.ejerciciosResueltos.ejercicioResuelto05_cuentaCorriente5.clases;

/***********************************************************************************************************************
 * Clase encargada de la ejecución del programa.                                                                       *
 ***********************************************************************************************************************/
public class Iniciador {
    public static void inicio() {
        //CREACIÓN DE OBJETOS
        Gestor gestor1 = new Gestor("Juan", "916790231", 20000);
        Gestor gestor2 = new Gestor("Alicia", "916790982");
        CuentaCorriente cuentaCorriente1 = new CuentaCorriente("Alberto", "12345678-T",
                2000, gestor1);
        CuentaCorriente cuentaCorriente2 = new CuentaCorriente("Pepe", "98765432-T",
                1000, gestor2);
        CuentaCorriente cuentaCorriente3 = new CuentaCorriente("Sara", "23456789-T");

        //IMPRESIÓN DE RESULTADOS
        System.out.println("NÚMEROS GESTORES");
        System.out.println("El número del gestor 1 es: " + gestor1.getStrNum());
        System.out.println("El número del gestor 2 es: " + gestor2.getStrNum());

        System.out.println("\nINFORMACIÓN DE LAS CUENTAS");
        System.out.println("Cuenta 1");
        System.out.println(cuentaCorriente1.muestraInformacion());
        System.out.println("\nCuenta 2");
        System.out.println(cuentaCorriente2.muestraInformacion());
        System.out.println("\nCuenta 3");
        System.out.println(cuentaCorriente3.muestraInformacion());

        System.out.println("\nINFORMACIÓN CUENTA 3 TRAS ASIGNACIÓN DE GESTOR");
        cuentaCorriente3.setGestor(gestor1);
        System.out.println(cuentaCorriente3.muestraInformacion());

        System.out.println("\nACCESO AL TELÉFONO DEL GESTOR DE LA CUENTA 3 A TRAVÉS DEL OBJETO CUENTA");
        System.out.println(cuentaCorriente3.getGestor().getStrNum());
    }
}
