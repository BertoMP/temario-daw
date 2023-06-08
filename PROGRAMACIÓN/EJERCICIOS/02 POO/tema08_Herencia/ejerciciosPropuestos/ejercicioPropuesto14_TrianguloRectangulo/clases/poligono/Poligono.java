package tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto14_TrianguloRectangulo.clases.poligono;

/***********************************************************************************************************************
 * Clase abstracta Polígono.                                                                                           *
 ***********************************************************************************************************************/
public abstract class Poligono {
    //DECLARACIÓN DE VARIABLES
    protected double rlnBase; //Variable que guardará la base del polígono.
    protected double rlnAltura; //Variable que guardara la altura del polígono.

    /*******************************************************************************************************************
     * Constructor principal de la clase.                                                                              *
     *                                                                                                                 *
     * @param rlnBase Base del polígono.                                                                               *
     * @param rlnAltura Altura del polígono.                                                                           *
     *******************************************************************************************************************/
    public Poligono(double rlnBase, double rlnAltura) {
        this.rlnBase = rlnBase;
        this.rlnAltura = rlnAltura;
    }

    /*******************************************************************************************************************
     * Método abstracto para el cálculo del área.                                                                      *
     *                                                                                                                 *
     * @return Devolverá un double con el área.                                                                        *
     *******************************************************************************************************************/
    protected abstract double area();
}
