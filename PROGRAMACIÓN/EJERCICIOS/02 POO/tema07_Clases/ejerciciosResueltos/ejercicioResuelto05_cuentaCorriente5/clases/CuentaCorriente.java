package tema07_Clases.ejerciciosResueltos.ejercicioResuelto05_cuentaCorriente5.clases;
/***********************************************************************************************************************
 * Clase encargada de generar objetos CuentaCorriente y de una serie de métodos de asociados al manejo de              *
 * cuenta corriente.                                                                                                   *
 ***********************************************************************************************************************/
public class CuentaCorriente {
    //DECLARACIÓN DE VARIABLES
    private String strNombre; //Variable que guarda el nombre del propietario de la cuenta corriente.
    private String strDni; //Variable que guarda el DNI del propietario de la cuenta corriente.
    private double rlnSaldo; //Variable que guarda el saldo de la cuenta corriente.
    private Gestor gestor;

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
     * Constructor de la clase con gestor de inicio.                                                                   *
     *                                                                                                                 *
     * @param strNombre --> Nombre del propietario.                                                                    *
     * @param strDni --> DNI del propietario.                                                                          *
     * @param rlnSaldo --> Saldo inicial de la cuenta.                                                                 *
     * @param gestor --> Gestor que se ocupa de la cuenta (objeto de la clase Gestor)                                  *
     *******************************************************************************************************************/
    public CuentaCorriente(String strNombre, String strDni, double rlnSaldo, Gestor gestor) {
        this(strNombre, strDni, rlnSaldo);
        this.gestor = gestor;
    }

    /*******************************************************************************************************************
     * Constructor de la clase con saldo inicial a 0.                                                                              *
     *                                                                                                                 *
     * @param strNombre --> Nombre del propietario.                                                                    *
     * @param strDni --> DNI del propietario.                                                                          *
     *******************************************************************************************************************/
    public CuentaCorriente(String strNombre, String strDni) {
        this (strNombre, strDni, 0);
    }

    //CONSTRUCTOR POR DEFECTO
    public CuentaCorriente(){
    }

    /*******************************************************************************************************************
     * Función que muestra la información relativa a la cuenta corriente.                                              *
     *******************************************************************************************************************/
    public String muestraInformacion() {
        if (gestor == null) {
                System.out.println("Esta cuenta no tiene gestor asociado.");
        } else {
            System.out.println("Información del gestor que lleva la cuenta:");
            System.out.println(this.gestor.muestraInformacion());
        }
        System.out.println("Información general de la cuenta:");
        return "Nombre: " + this.strNombre + " DNI: " + this.strDni + " Saldo: " + this.rlnSaldo;
    }

    public void setGestor(Gestor gestor) {
        this.gestor = gestor;
    }

    public Gestor getGestor() {
        return this.gestor;
    }
}
