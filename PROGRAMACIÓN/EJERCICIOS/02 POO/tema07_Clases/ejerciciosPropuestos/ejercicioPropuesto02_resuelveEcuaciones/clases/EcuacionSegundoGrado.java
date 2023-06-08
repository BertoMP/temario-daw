package tema07_Clases.ejerciciosPropuestos.ejercicioPropuesto02_resuelveEcuaciones.clases;
/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo EcuacionSegundoGrado y de manejar sus atributos                          *
 * y métodos correspondientes.                                                                                         *
 ***********************************************************************************************************************/
public class EcuacionSegundoGrado {
    //DECLARACIÓN DE VARIABLES
    private double rlnCoeficienteA; //Variable que guardará el valor del coeficienteA.
    private double rlnCoeficienteB; //Variable que guardará el valor del coeficienteB.
    private double rlnCoeficienteC; //Variable que guardará el valor del coeficienteC.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *                                                                                                                 *
     * @param rlnCoeficienteA Valor del coeficiente A.                                                                 *
     * @param intCoeficienteB Valor del coeficiente B.                                                                 *
     * @param intCoeficienteC Valor del coeficiente C.                                                                 *
     *******************************************************************************************************************/
    public EcuacionSegundoGrado (double rlnCoeficienteA, double intCoeficienteB, double intCoeficienteC) {
        this.rlnCoeficienteA = rlnCoeficienteA;
        this.rlnCoeficienteB = intCoeficienteB;
        this.rlnCoeficienteC = intCoeficienteC;
    }

    /*******************************************************************************************************************
     * Método encargado de fijar el valor del coeficiente A.                                                           *
     *                                                                                                                 *
     * @param rlnCoeficienteA Valor del coeficiente A.                                                                 *
     *******************************************************************************************************************/
    public void setRlnCoeficienteA(double rlnCoeficienteA) {
        this.rlnCoeficienteA = rlnCoeficienteA;
    }

    /*******************************************************************************************************************
     * Método encargado de fijar el valor del coeficiente B.                                                           *
     *                                                                                                                 *
     * @param rlnCoeficienteB Valor del coeficiente B.                                                                 *
     *******************************************************************************************************************/
    public void setRlnCoeficienteB(double rlnCoeficienteB) {
        this.rlnCoeficienteB = rlnCoeficienteB;
    }

    /*******************************************************************************************************************
     * Método encargado de fijar el valor del coeficiente C.                                                           *
     *                                                                                                                 *
     * @param rlnCoeficienteC Valor del coeficiente C.                                                                 *
     *******************************************************************************************************************/
    public void setRlnCoeficienteC(double rlnCoeficienteC) {
        this.rlnCoeficienteC = rlnCoeficienteC;
    }

    /*******************************************************************************************************************
     * Método encargado de mostrar los coeficientes.                                                                   *
     *                                                                                                                 *
     * @return Devuelve un String con el valor de los 3 coeficientes.                                                  *
     *******************************************************************************************************************/
    public String muestraDatos() {
        return "Coeficiente A: " + this.rlnCoeficienteA + "\nCoeficiente B: "
                + this.rlnCoeficienteB + "\nCoeficiente C: " + this.rlnCoeficienteC;
    }

    /*******************************************************************************************************************
     * Método encargado de resolver la ecuación de segundo grado.                                                      *
     *******************************************************************************************************************/
    public double[] resuelveEcuacion() {
        //DECLARACIÓN DE VARIABLES
        double[] soluciones = new double[0];
        double rlnDiscriminante; //Variable que guardará el valor del discriminante.
        double rlnSolucion1 = 0; //Variable que guardará la primera solución.
        double rlnSolucion2 = 0; //Variable que guardará la segunda solución.

        rlnDiscriminante = this.calculaDiscriminante();

        if (rlnDiscriminante >= 0) {
            rlnSolucion1 = ((-(this.rlnCoeficienteB)) + Math.sqrt(rlnDiscriminante)) /
                    (2 * this.rlnCoeficienteA);
            rlnSolucion2 = ((-(this.rlnCoeficienteB)) - Math.sqrt(rlnDiscriminante)) /
                    (2 * this.rlnCoeficienteA);
        }

        if (rlnDiscriminante == 0) {
            System.out.println("La ecuación sólo tiene una solución.");
            soluciones = new double[1];
            soluciones[0] = rlnSolucion1;
        } else if (rlnDiscriminante > 0) {
            System.out.println("La ecuación tiene dos soluciones:");
            soluciones = new double[2];
            soluciones[0] = rlnSolucion1;
            soluciones[1] = rlnSolucion2;
        } else {
            System.out.println("La ecuación no tiene soluciones reales.");
        }
        return soluciones;
    }

    /*******************************************************************************************************************
     * Método encargado de comprobar si el discriminante es positivo o negativo.                                       *
     *******************************************************************************************************************/
    public void compruebaDiscriminante() {
        double rlnDiscriminante = calculaDiscriminante();

        if (rlnDiscriminante > 0) {
            System.out.println("\t- El discriminante es positivo: " + rlnDiscriminante + ".");
        } else if (rlnDiscriminante < 0){
            System.out.println("\t- El discriminante es negativo: " + rlnDiscriminante + ".");
        } else {
            System.out.println("\t- El discriminante es igual a 0.");
        }
    }

    /*******************************************************************************************************************
     * Método encargado de calcular el discriminante.                                                                  *
     *                                                                                                                 *
     * @return Devuelve el valor del discriminante.                                                                    *
     *******************************************************************************************************************/
    private double calculaDiscriminante() {
        return (Math.pow(this.rlnCoeficienteB, 2) - (4 * this.rlnCoeficienteA * this.rlnCoeficienteC));
    }
}
