package tema08_Herencia.ejerciciosResueltos.ejercicioResuelto02_HoraExacta.clases;

/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo HoraExacta.                                                              *
 ***********************************************************************************************************************/
public class HoraExacta extends Hora {
    //DECLARACIÓN DE VARIABLES
    private byte bytSegundo; //Variable que guardará los segundos del objeto HoraExacta.

    /*******************************************************************************************************************
     * Constructor principal de la clase.                                                                              *
     *                                                                                                                 *
     * @param bytHora Variable hora a fijar.                                                                           *
     * @param bytMinuto Variable minutos a fijar.                                                                      *
     * @param bytSegundo Variable segundos a fijar.                                                                    *
     *******************************************************************************************************************/
    public HoraExacta(byte bytHora, byte bytMinuto, byte bytSegundo) {
        super(bytHora, bytMinuto);
        this.bytSegundo = 0;
        if(!this.setSegundo(bytSegundo)) {
            System.out.println("Los segundos no son correctos. Segundos iniciados a 0.");
        }
    }

    /*******************************************************************************************************************
     * Método encargado de fijar los segundos.                                                                         *
     *                                                                                                                 *
     * @param bytSegundo Segundos a fijar.                                                                             *
     * @return Devuelve un booleano en función de si se han podido fijar los segundos (true) o no (false).             *
     *******************************************************************************************************************/
    public boolean setSegundo(byte bytSegundo) {
        if (bytSegundo >= 0 && bytSegundo < 60) {
            this.bytSegundo = bytSegundo;
            return true;
        } else {
            return false;
        }
    }

    /*******************************************************************************************************************
     * Método encargado en aumentar un segundo la hora.                                                                *
     *******************************************************************************************************************/
    @Override
    public void incrementa() {
        this.bytSegundo++;
        if (this.bytSegundo > 59) {
            this.bytSegundo = 0;
            super.incrementa();
        }
    }

    /*******************************************************************************************************************
     * Método encargado de devolver un String con la hora.                                                             *
     *                                                                                                                 *
     * @return Devuelve un String con la hora.                                                                         *
     *******************************************************************************************************************/
    @Override
    public String toString() {
        return super.toString() + ":" + Hora.formatea(bytSegundo);
    }
}
