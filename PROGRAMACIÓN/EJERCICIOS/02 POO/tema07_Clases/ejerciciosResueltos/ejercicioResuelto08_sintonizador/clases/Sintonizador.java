package tema07_Clases.ejerciciosResueltos.ejercicioResuelto08_sintonizador.clases;
/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo Sintonizador y de manejar sus atributos y métodos correspondientes.      *
 ***********************************************************************************************************************/
public class Sintonizador {
    //DECLARACIÓN DE VARIABLES
    private double rlnFrecuencia; //Variable que guardará la frecuencia actual del sintonizador.

    /*******************************************************************************************************************
     * Constructor de la clase si se pasa una frecuencia de inicio.                                                    *
     *                                                                                                                 *
     * @param rlnFrecuencia -> Frecuencia de inicio del sintonizador.                                                  *
     *******************************************************************************************************************/
    public Sintonizador(double rlnFrecuencia) {
        if (rlnFrecuencia < 80) {
            this.rlnFrecuencia = 80;
        } else if (rlnFrecuencia > 108) {
            this.rlnFrecuencia = 108;
               } else {
                    this.rlnFrecuencia = rlnFrecuencia;
               }
    }

    /*******************************************************************************************************************
     * Constructor por defecto de la clase en caso de no pasarse una frecuencia de inicio.                             *
     *******************************************************************************************************************/
    public Sintonizador() {
        this(80);
    }

    /*******************************************************************************************************************
     * Método get de la clase para obtener la frecuencia actual.                                                       *
     *                                                                                                                 *
     * @return El método devuelve un double con la frecuencia actual del objeto sintonizador.                          *
     *******************************************************************************************************************/
    public double getRlnFrecuencia() {
        return this.rlnFrecuencia;
    }

    /*******************************************************************************************************************
     * Método encargado de aumentar la frecuencia actual en 0.5MHz.                                                    *
     *******************************************************************************************************************/
    public void up() {
        this.rlnFrecuencia += 0.5;
        compruebaLimite();
    }

    /*******************************************************************************************************************
     * Método encargado de disminuir la frecuencia actual en 0.5MHz.                                                   *
     *******************************************************************************************************************/
    public void down() {
        this.rlnFrecuencia += 0.5;
        compruebaLimite();
    }

    /*******************************************************************************************************************
     * Método encargado de informar de la frecuencia actual.                                                           *
     *******************************************************************************************************************/
    public void display() {
        System.out.println("Emisora actual: " + this.rlnFrecuencia + ".");
    }

    /*******************************************************************************************************************
     * Método privado encargado de comprobar los límites superior e inferior de frecuencias, en caso de superar        *
     * uno de los límites, se fija la frecuencia actual en el extremo opuesto.                                         *
     *******************************************************************************************************************/
    private void compruebaLimite() {
        if (this.rlnFrecuencia < 80) {
            this.rlnFrecuencia = 108;
        } else if (this.rlnFrecuencia > 108) {
            this.rlnFrecuencia = 80;
        }
    }
}
