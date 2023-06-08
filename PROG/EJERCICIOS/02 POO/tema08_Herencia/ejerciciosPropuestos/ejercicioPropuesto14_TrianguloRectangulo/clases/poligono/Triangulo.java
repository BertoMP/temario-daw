package tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto14_TrianguloRectangulo.clases.poligono;

/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo Triangulo que heredan de Poligono.                                       *
 ***********************************************************************************************************************/
public class Triangulo extends Poligono {
    /*******************************************************************************************************************
     * Constructor principal de la clase.                                                                              *
     *                                                                                                                 *
     * @param rlnBase Base del triángulo.                                                                              *
     * @param rlnAltura Altura del triángulo.                                                                          *
     *******************************************************************************************************************/
    public Triangulo(double rlnBase, double rlnAltura) {
        super(rlnBase, rlnAltura);
    }

    /*******************************************************************************************************************
     * Método encargado de calcular el área del triángulo.                                                             *
     *                                                                                                                 *
     * @return Devuelve el cálculo del área.                                                                           *
     *******************************************************************************************************************/
    public double area() {
        return (rlnBase * rlnAltura) / 2;
    }
}
