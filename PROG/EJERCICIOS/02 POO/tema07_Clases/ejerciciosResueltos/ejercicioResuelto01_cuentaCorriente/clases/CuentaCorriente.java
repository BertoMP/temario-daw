package tema07_Clases.ejerciciosResueltos.ejercicioResuelto01_cuentaCorriente.clases;
/***********************************************************************************************************************
 * Clase encargada de generar objetos CuentaCorriente y de una serie de métodos de asociados al manejo de              *
 * cuenta corriente.                                                                                                   *
 ***********************************************************************************************************************/
public class CuentaCorriente {
    //DECLARACIÓN DE VARIABLES
    private String strNombre; //Variable que guarda el nombre del propietario de la cuenta corriente.
    private String strDni; //Variable que guarda el DNI del propietario de la cuenta corriente.
    private double rlnSaldo; //Variable que guarda el saldo de la cuenta corriente.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *                                                                                                                 *
     * @param strNombre --> Nombre del propietario.                                                                    *
     * @param strDNI --> DNI del propietario.                                                                          *
     *******************************************************************************************************************/
    public CuentaCorriente(String strNombre, String strDNI) {
        this.strNombre = strNombre;
        this.strDni = strDNI;
        this.rlnSaldo = 0;
    }

    /*******************************************************************************************************************
     * Método que sirve para sacar dinero de la cuenta corriente.                                                      *
     *                                                                                                                 *
     * @param dinero --> Cantidad de dinero.                                                                           *
     *******************************************************************************************************************/
    public void sacarDinero(double dinero) {
        if (this.rlnSaldo < dinero) {
            System.out.println("No es posible realizar la operación.");
        } else {
            this.rlnSaldo -= dinero;
            System.out.println("Operación realizada con éxito. Saldo disponible: " + this.rlnSaldo);
        }
    }

    /*******************************************************************************************************************
     * Método que sirve para realizar ingresos en la cuenta corriente.                                                 *
     *                                                                                                                 *
     * @param dinero --> Cantidad de dinero.                                                                           *
     *******************************************************************************************************************/
    public void hazIngreso(double dinero) {
        this.rlnSaldo += dinero;
        System.out.println("Operación realizada con éxito. Saldo disponible: " + this.rlnSaldo);
    }

    /*******************************************************************************************************************
     * Función que muestra la información relativa a la cuenta corriente.                                              *
     *******************************************************************************************************************/
    public void muestraInformacion() {
        System.out.println("\n\t\tDATOS DE LA CUENTA");
        System.out.println("Nombre del propietario: " + strNombre);
        System.out.println("DNI del propietario: " + strDni);
        System.out.println("Saldo disponible: " + rlnSaldo + "€");
    }
}
