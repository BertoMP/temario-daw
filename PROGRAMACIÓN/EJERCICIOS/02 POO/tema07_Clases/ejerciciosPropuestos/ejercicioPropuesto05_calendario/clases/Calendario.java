package tema07_Clases.ejerciciosPropuestos.ejercicioPropuesto05_calendario.clases;
import java.util.Objects;

/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo Cambio y de manejar sus atributos y métodos correspondientes.            *
 ***********************************************************************************************************************/
public class Calendario {
    //DECLARACIÓN DE VARIABLES
    private byte bytDia; //Variable que guardará el día del objeto Calendario.
    private byte bytMes; //Variable que guardará el mes del objeto Calendario.
    private int intAnno; //Variable que guardará el mes del objeto Calendario.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *                                                                                                                 *
     * @param bytDia Día del objeto calendario.                                                                        *
     * @param bytMes Mes del objeto calendario.                                                                        *
     * @param intAnno Año del objeto calendario                                                                        *
     *******************************************************************************************************************/
    public Calendario (byte bytDia, byte bytMes, int intAnno) {
        this.bytDia = bytDia;
        this.bytMes = bytMes;
        this.intAnno = intAnno;
    }

    /*******************************************************************************************************************
     * Método encargado de aumentar los días.                                                                          *
     *******************************************************************************************************************/
    public void incrementaDia() {
        bytDia++;
        if (this.bytDia > compruebaMaximo(this.bytMes)) {
            this.bytDia = 1;
            this.incrementaMes();
        }
    }

    /*******************************************************************************************************************
     * Método encargado de aumentar los meses.                                                                         *
     *******************************************************************************************************************/
    public void incrementaMes() {
        this.bytMes++;
        if (this.bytMes > 12) {
            this.bytMes = 1;
            this.incrementaAnno(1);
        }

        if (this.bytDia > compruebaMaximo(this.bytMes)) {
            this.bytDia = 1;
        }
    }

    /*******************************************************************************************************************
     * Método encargado de aumentar los años.                                                                          *
     *                                                                                                                 *
     * @param intCantidad Cantidad de años a aumentar.                                                                 *
     *******************************************************************************************************************/
    public void incrementaAnno(int intCantidad) {
        for (int intCont = 0; intCont < intCantidad; intCont++) {
            this.intAnno++;
            if (this.intAnno == 0) {
                this.intAnno++;
            }
        }
    }

    /*******************************************************************************************************************
     * Método encargado de mostrar la fecha completa.                                                                  *
     *                                                                                                                 *
     * @return Devuelve un String con la fecha en formato D/M/A.                                                       *
     *******************************************************************************************************************/
    public String muestraFecha() {
        return "FECHA: " + this.bytDia + "/" + this.bytMes + "/" + this.intAnno;
    }


    /*******************************************************************************************************************
     * Método encargado de comparar dos fechas (una invocante y una pasada por parámetro).                             *
     *                                                                                                                 *
     * @param objeto Objeto de la clase Object.                                                                        *
     * @return Devuelve un booleano en función de si es la misma fecha (true) o no (false).                            *
     *******************************************************************************************************************/
    @Override
    public boolean equals(Object objeto) {
        Calendario otroCalendario = (Calendario) objeto;
        return this.bytDia == otroCalendario.bytDia
                && this.bytMes == otroCalendario.bytMes
                && this.intAnno == otroCalendario.intAnno;
    }

    /*******************************************************************************************************************
     * Método encargado de comprobar el número de días máximos del mes pasado por parámetro.                           *
     *                                                                                                                 *
     * @param bytMes Mes a comprobar.                                                                                  *
     * @return Devuelve un byte con el número de días máximos.                                                         *
     *******************************************************************************************************************/
    public static byte compruebaMaximo(byte bytMes) {
        switch(bytMes) {
            case 2 -> {
                return 28;
            }
            case 4,6,9,11 -> {
                return 30;
            }
            default -> {
                return 31;
            }
        }
    }
}
