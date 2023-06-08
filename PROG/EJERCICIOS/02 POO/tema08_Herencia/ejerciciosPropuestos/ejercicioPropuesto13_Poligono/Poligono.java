package tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto13_Poligono;

/***********************************************************************************************************************
 * Implementa la clase abstracta Poligono, con los atributos base y altura, de tipo double y el método abstracto       *
 * double area().                                                                                                      *
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
