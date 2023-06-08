package tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto14_TrianguloRectangulo.clases.poligono;

/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo Rectangulo que heredan de Poligono.                                      *
 ***********************************************************************************************************************/
public class Rectangulo extends Poligono {
    /*******************************************************************************************************************
     * Constructor principal de la clase.                                                                              *
     *                                                                                                                 *
     * @param rlnBase Base del rectángulo.                                                                             *
     * @param rlnAltura Altura del rectángulo.                                                                         *
     *******************************************************************************************************************/
    public Rectangulo(double rlnBase, double rlnAltura) {
        super(rlnBase, rlnAltura);
    }

    /*******************************************************************************************************************
     * Método encargado de calcular el área del rectángulo.                                                            *
     *                                                                                                                 *
     * @return Devuelve el cálculo del área.                                                                           *
     *******************************************************************************************************************/
    public double area() {
        return rlnBase * rlnAltura;
    }
}
