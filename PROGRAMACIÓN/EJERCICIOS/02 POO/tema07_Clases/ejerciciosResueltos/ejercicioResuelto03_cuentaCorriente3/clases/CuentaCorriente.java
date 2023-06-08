package tema07_Clases.ejerciciosResueltos.ejercicioResuelto03_cuentaCorriente3.clases;
/***********************************************************************************************************************
 * Clase encargada de generar objetos CuentaCorriente y de una serie de métodos de asociados al manejo de              *
 * cuenta corriente.                                                                                                   *
 ***********************************************************************************************************************/
public class CuentaCorriente {
    //DECLARACIÓN DE VARIABLES
    public String strNombre; //Variable que guarda el nombre del propietario de la cuenta corriente.
    String strDni; //Variable que guarda el DNI del propietario de la cuenta corriente.
    private double rlnSaldo; //Variable que guarda el saldo de la cuenta corriente.

    /*******************************************************************************************************************
     * Constructor principal de la clase.                                                                              *
     *                                                                                                                 *
     * @param strNombre --> Nombre del propietario.                                                                    *
     * @param strDni --> DNI del propietario.                                                                          *
     * @param rlnSaldo --> Saldo inicial de la cuenta.                                                                 *
     *******************************************************************************************************************/
    public CuentaCorriente(String strNombre, String strDni, double rlnSaldo) {
        this.strNombre = strNombre;
        this.strDni = strDni;
        this.rlnSaldo = rlnSaldo;
    }

    /*******************************************************************************************************************
     * Constructor de la clase solo con nombre del cliente y su dni. Además el saldo de la cuenta se inicializa        *
     * a 0.                                                                                                            *
     *                                                                                                                 *
     * @param strNombre --> Nombre del propietario.                                                                    *
     * @param strDni --> DNI del propietario.                                                                          *
     *******************************************************************************************************************/
    public CuentaCorriente(String strNombre, String strDni) {
        this(strNombre, strDni, 0); //Llamada al constructor principal.
    }

    /*******************************************************************************************************************
     * Constructor de la clase solo con nombre del dni del cliente y un saldo inicial.                                 *
     *                                                                                                                 *
     * @param strDni --> DNI del propietario.                                                                          *
     * @param rlnSaldo --> Saldo inicial de la cuenta.                                                                 *
     *******************************************************************************************************************/
    public CuentaCorriente(String strDni, double rlnSaldo) {
        this(null, strDni, rlnSaldo); //Llamada al constructor principal.
    }

    /*******************************************************************************************************************
     * Constructor por defecto.                                                                                        *
     *******************************************************************************************************************/
    public CuentaCorriente() {
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
    public String muestraInformacion() {
        return "Nombre: " + this.strNombre + " DNI: " + this.strDni + " Saldo: " + this.rlnSaldo;
    }
}
