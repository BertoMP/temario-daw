package tema07_Clases.ejerciciosResueltos.ejercicioResuelto06_hora.clases;

public class Hora {
    //DECLARACIÓN DE VARIABLES
    private int intHora; //Variable que guardará las horas
    private int intMinuto; //Variable que guardará los minutos
    private int intSegundo; //Variable que guardará los segundos

    //CONSTRUCTOR POR DEFECTO
    public Hora() {
    }

    //MÉTODOS SET
    public void setIntHora(int intHora) {
        if (intHora >= 0 && intHora <= 23) {
            this.intHora = intHora;
        } else {
            this.intHora = 0; //Si la hora no es válida, se inicializan a 0.
        }
    }

    public void setIntMinuto(int intMinuto) {
        if (intMinuto >= 0 && intMinuto <= 59) {
            this.intMinuto = intMinuto;
        } else {
            this.intMinuto = 0; //Si los minutos no son válidos, se inicializan a 0.
        }
    }

    public void setIntSegundo(int intSegundo) {
        if (intSegundo >= 0 && intSegundo <= 59) {
            this.intSegundo = intSegundo;
        } else {
            this.intSegundo = 0; //Si los segundos no son válidos, se inicializan a 0.
        }
    }

    /*******************************************************************************************************************
     * Método encargado de mostrar la hora actual.                                                                     *
     *******************************************************************************************************************/
    public void muestraHora() {
        System.out.println(Hora.anadeCero(this.intHora) + ":" +
                Hora.anadeCero(this.intMinuto) + ":" + Hora.anadeCero(this.intSegundo));
        //LLAMADA AL MÉTODO incrementaSegundos() DE LA CLASE HORA
        this.aumentaSegundo();
    }

    /*******************************************************************************************************************
     * Método encargado de aumentar los segundos y, con ello, los minutos y horas.                                     *
     *******************************************************************************************************************/
    private void aumentaSegundo() {
        this.intSegundo++;
        if (this.intSegundo > 59) {
            this.intSegundo = 0;
            this.intMinuto++;
            if (this.intMinuto > 59) {
                this.intMinuto = 0;
                this.intHora++;
                if (this.intHora > 23) {
                    this.intHora = 0;
                }
            }
        }
    }

    /*******************************************************************************************************************
     * Método encargado de añadir un cero cuando sea necesario.                                                        *
     * @return Devuelve el valor formateado para que tenga dos caracteres.                                             *
     *******************************************************************************************************************/
    private static String anadeCero(int intNum) {
        return String.format("%02d", intNum);
    }
}
