package tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto12_MetodoFinalize.clases;

/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo Persona.                                                                 *
 ***********************************************************************************************************************/
public class Persona {
    /*******************************************************************************************************************
     * Constructor por defecto.                                                                                        *
     *******************************************************************************************************************/
    public Persona() {
    }

    /*******************************************************************************************************************
     * Método que se activa justo antes del recolector de basura y que imprime un mensaje por pantalla.                *
     *                                                                                                                 *
     * @throws Throwable El método puede devolver cualquier tipo de excepción.                                         *
     *******************************************************************************************************************/
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Objeto de Persona eliminado.");
    }
}
