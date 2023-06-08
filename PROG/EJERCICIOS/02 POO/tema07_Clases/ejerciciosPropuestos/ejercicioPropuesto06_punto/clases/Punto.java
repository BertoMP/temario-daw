package tema07_Clases.ejerciciosPropuestos.ejercicioPropuesto06_punto.clases;
/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo Cambio y de manejar sus atributos y métodos correspondientes.            *
 ***********************************************************************************************************************/
public class Punto {
    //DECLARACIÓN DE VARIABLES
    private double rlnCoordX; //Variable que guardará la coordenada en el eje X del objeto de tipo Punto.
    private double rlnCoordY; //Variable que guardará la coordenada en el eje Y del objeto de tipo Punto.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *                                                                                                                 *
     * @param rlnCoordX Situación en el eje X del punto.                                                               *
     * @param rlnCoordY Situación en el eje Y del punto.                                                               *
     *******************************************************************************************************************/
    public Punto(double rlnCoordX, double rlnCoordY) {
        this.rlnCoordX = rlnCoordX;
        this.rlnCoordY = rlnCoordY;
    }

    /*******************************************************************************************************************
     * Método para desplazar en el eje X al punto.                                                                     *
     *                                                                                                                 *
     * @param rlnDesplazamientoX Desplazamiento en el eje X.                                                           *
     *******************************************************************************************************************/
    public void desplazaX(double rlnDesplazamientoX) {
        this.rlnCoordX += rlnDesplazamientoX;
    }

    /*******************************************************************************************************************
     * Método para desplazar en el eje Y al punto.                                                                     *
     *                                                                                                                 *
     * @param rlnDesplazamientoY Desplazamiento en el eje Y.                                                           *
     *******************************************************************************************************************/
    public void desplazaY(double rlnDesplazamientoY) {
        this.rlnCoordY += rlnDesplazamientoY;
    }

    /*******************************************************************************************************************
     * Método para desplazar en el eje X y en el eje Y al punto.                                                       *
     *                                                                                                                 *
     * @param rlnDesplazamientoX Desplazamiento en el eje X.                                                           *
     * @param rlnDesplazamientoY Desplazamiento en el eje Y.                                                           *
     *******************************************************************************************************************/
    public void desplazaXY(double rlnDesplazamientoX, double rlnDesplazamientoY) {
        this.desplazaX(rlnDesplazamientoX);
        this.desplazaY(rlnDesplazamientoY);
    }

    /*******************************************************************************************************************
     * Método para calcular la distancia Euclídea entre dos puntos.                                                    *
     *                                                                                                                 *
     * @param otroPunto Objeto de tipo punto.                                                                          *
     *******************************************************************************************************************/
    public double distanciaEuclidea(Punto otroPunto) {
        double rlnDistancia;

        rlnDistancia = Math.sqrt((Math.pow(otroPunto.rlnCoordX - this.rlnCoordX, 2))
                + (Math.pow(otroPunto.rlnCoordY - this.rlnCoordY, 2)));

        return rlnDistancia;
    }

    /*******************************************************************************************************************
     * Método para mostrar la información del punto.                                                                   *
     *******************************************************************************************************************/
    public void muestra() {
        System.out.println("Coordenadas del punto:" +
                           "\n\t- X: " + this.rlnCoordX +
                           "\n\t- Y: " + this.rlnCoordY);
    }
}
