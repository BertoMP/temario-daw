package tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto14_ListaObjectSobrecargaSuperclaseAbstracta.clases.animal;

/***********************************************************************************************************************
 * Clase abstracta animal.                                                                                             *
 ***********************************************************************************************************************/
public abstract class Animal implements Comparable {
    //DECLARACIÓN DE ATRIBUTOS
    protected String strNombre; //String que guarda el nombre.
    protected int intEdad; //Int que guarda la edad.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *                                                                                                                 *
     * @param strNombre Nombre del animal.                                                                             *
     * @param intEdad Edad del animal.                                                                                 *
     *******************************************************************************************************************/
    public Animal(String strNombre, int intEdad) {
        this.strNombre = strNombre;
        this.intEdad = intEdad;
    }

    /*******************************************************************************************************************
     * Implementación del método abstracto compareTo de la interfaz Comparable modificado para realizar una comparación*
     * por el nombre del animal.                                                                                       *
     *                                                                                                                 *
     * @param objeto Objeto de la clase Object.                                                                        *
     * @return Devuelve un int resultado de la comparación.                                                            *
     *******************************************************************************************************************/
    @Override
    public int compareTo(Object objeto) {
        Animal otroAnimal = (Animal) objeto;

        return this.strNombre.compareTo(otroAnimal.strNombre);
    }
}
