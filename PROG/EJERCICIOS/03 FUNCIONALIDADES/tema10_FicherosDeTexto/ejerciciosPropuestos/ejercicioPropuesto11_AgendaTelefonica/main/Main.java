package tema10_FicherosDeTexto.ejerciciosPropuestos.ejercicioPropuesto11_AgendaTelefonica.main;

import tema10_FicherosDeTexto.ejerciciosPropuestos.ejercicioPropuesto11_AgendaTelefonica.clases.Inicio;

/***********************************************************************************************************************
 * Diseña una pequeña agenda, que muestre el siguiente menú:                                                           *
 *      1. Nuevo contacto.                                                                                             *
 *      2. Buscar por nombre.                                                                                          *
 *      3. Mostrar todos.                                                                                              *
 *      4. Salir.                                                                                                      *
 * En ella, guardaremos el nombre y el teléfono de un máximo de 20 personas.                                           *
 * La opción 1 nos permitirá introducir un nuevo contacto siempre y cuando la agenda no esté llena, comprobando que el *
 * nombre no se encuentra insertado ya.                                                                                *
 * La opción 2 muestra todos los teléfonos que coinciden con la cadena que se busca. Por ejemplo, si tecleamos «Pe»,   *
 * mostrará el teléfono de Pedro, de Pepe y de Petunia.                                                                *
 * La opción 3 mostrará un listado con toda la información (nombres y teléfonos) ordenados alfabéticamente por el      *
 * nombre.                                                                                                             *
 * Por último, la opción 4 guarda todos los datos de la agenda en el archivo agenda.txt.                               *
 * La próxima vez que se ejecute la aplicación, si hay datos guardados, se cargarán en memoria.                        *
 ***********************************************************************************************************************/
public class Main {
    public static void main(String[] args) {
        Inicio.inicio();
    }
}
