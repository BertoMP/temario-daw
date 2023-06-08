package tema08_Herencia.ejerciciosResueltos.ejercicioResuelto01_Hora.clases;

/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo Hora.                                                                    *
 ***********************************************************************************************************************/
public class Hora {
    //DECLARACIÓN DE VARIABLES
    private byte bytHora; //Variable que guardará la hora del objeto Hora.
    private byte bytMinuto; //Variable que guardará los minutos del objeto Hora.

    /*******************************************************************************************************************
     * Constructor principal de la clase.                                                                              *
     *                                                                                                                 *
     * @param bytHora Variable hora a fijar.                                                                           *
     * @param bytMinuto Variable minutos a fijar.                                                                      *
     *******************************************************************************************************************/
    public Hora(byte bytHora, byte bytMinuto) {
        this.bytHora = 0;
        if (!this.setHora(bytHora)) {
            System.out.println("La hora no es correcta. Hora iniciada en 0.");
        }
        this.bytMinuto = 0;
        if (!this.setHora(bytMinuto)) {
            System.out.println("Los minutos no son correctos. Minutos iniciados en 0.");
        }
    }

    /*******************************************************************************************************************
     * Método encargado en aumentar un minuto la hora.                                                                 *
     *******************************************************************************************************************/
    public void incrementa() {
        this.bytMinuto++;
        this.bytHora = (byte) ((this.bytHora + (this.bytMinuto/60)) % 24);
        this.bytMinuto %= 60;
    }

    /*******************************************************************************************************************
     * Método encargado de fijar la hora.                                                                              *
     *                                                                                                                 *
     * @param bytHora Hora a fijar.                                                                                    *
     * @return Devuelve un booleano en función de si se ha podido fijar la hora (true) o no (false).                   *
     *******************************************************************************************************************/
    public boolean setHora(byte bytHora) {
        if (bytHora >= 0 && bytHora < 24) {
            this.bytHora = bytHora;
            return true;
        } else {
            return false;
        }
    }

    /*******************************************************************************************************************
     * Método encargado de fijar los minutos.                                                                          *
     *                                                                                                                 *
     * @param bytMinuto Minutos a fijar.                                                                               *
     * @return Devuelve un booleano en función de si se han podido fijar los minutos (true) o no (false).              *
     *******************************************************************************************************************/
    public boolean setMinutos(byte bytMinuto) {
        if (bytMinuto >= 0 && bytMinuto < 60) {
            this.bytMinuto = bytMinuto;
            return true;
        } else {
            return false;
        }
    }

    /*******************************************************************************************************************
     * Método encargado de devolver un String con la hora.                                                             *
     *                                                                                                                 *
     * @return Devuelve un String con la hora.                                                                         *
     *******************************************************************************************************************/
    @Override
    public String toString() {
        return Hora.formatea(this.bytHora) + ":" + Hora.formatea(this.bytMinuto);
    }

    /*******************************************************************************************************************
     * Método encargado de devolver un formateo de la hora para que tenga 2 dígitos siempre.                           *
     *                                                                                                                 *
     * @return Devuelve un String con la hora formateada.                                                              *
     *******************************************************************************************************************/
    private static String formatea(byte bytNumero) {
        return String.format("%02d", bytNumero);
    }
}
