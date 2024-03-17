<?php

/**
 * Imprime la paginación en el formato HTML para la interfaz de usuario.
 *
 * Esta función utiliza información almacenada en la sesión para generar enlaces
 * de paginación que permiten al usuario navegar entre las diferentes páginas.
 * Muestra botones para ir a la página anterior y siguiente, así como enlaces
 * numerados para cada página disponible. El enlace de la página actual se
 * destaca con la clase CSS "selected".
 *
 * @return void
 */
function printPages(): void {
    $paginaSeleccionada = $_SESSION['paginaSeleccionada']; // Página seleccionada por el usuario.
    $paginaMaxima = $_SESSION['maxPag']; // Página máxima posible.

    echo '<article>';

    // Botón Anterior
    echo '<a href="http://localhost/Servidor/UD14-MVC/EjemploMVC/index.php/ControladorNota/list/'
        . ($paginaSeleccionada - 1) . '"><button ' . ($paginaSeleccionada <= 1 ? 'disabled' : '')
        . '>Anterior</button></a>';

    // Enlaces de páginas
    for ($intCont = 1; $intCont <= $paginaMaxima; $intCont++) {
        echo '<a ' . (
            $intCont !== (int) $paginaSeleccionada
                ? 'href="http://localhost/Servidor/UD14-MVC/EjemploMVC/index.php/ControladorNota/list/' . $intCont . '"'
                : 'class="selected"'
            ) . '>' . $intCont . '</a>';
    }

    // Botón Siguiente
    echo '<a href="http://localhost/Servidor/UD14-MVC/EjemploMVC/index.php/ControladorNota/list/'
        . ($paginaSeleccionada + 1) . '"><button ' . ($paginaSeleccionada >= $paginaMaxima ? 'disabled' : '')
        . '>Siguiente</button></a>';

    echo '</article>';
}

/**
 * Imprime las notas proporcionadas en formato HTML para la interfaz de usuario.
 *
 * Esta función recorre un array de notas y genera el HTML necesario para mostrar
 * cada nota individualmente en la interfaz. Cada nota incluye un título, contenido,
 * y enlaces para editar y eliminar la nota.
 *
 * @param array $notes Un array que contiene información de las notas a imprimir.
 *                     Cada elemento del array debe ser un array asociativo con las
 *                     claves 'id', 'titulo', y 'contenido'.
 *
 * @return void
 */
function printNotes($notes): void {
    foreach($notes as $note){
        echo '<div>';
        echo '<div>';
        echo '<h5>' . $note['titulo'] . '</h5>';
        echo '<div>' . nl2br($note['contenido']) . '</div>';
        echo '<a class="edit-note"
                 href="http://localhost/Servidor/UD14-MVC/EjemploMVC/index.php/ControladorNota/edit/'
                    . $note['id'] . '">Editar</a>';
        echo '<a class="delete-note" 
                 href="http://localhost/Servidor/UD14-MVC/EjemploMVC/index.php/ControladorNota/confirmDelete/'
                        . $note['id'] . '">Eliminar</a>';
        echo '</div>';
        echo '</div>';
    }
}

/**
 * Imprime opciones de filtrado en formato HTML para la interfaz de usuario.
 *
 * Esta función genera un formulario con un menú desplegable que permite al usuario
 * seleccionar la cantidad de notas a mostrar por página. Incluye un botón de filtrado
 * que redirige a la página de listado con la cantidad seleccionada.
 *
 * @return void
 */
function printOptions (): void {
    $options = [3, 5, 7, 10, 20];

    echo '<article>';
    echo '<form method="post">';
    echo '<label for="cantNotes">Cantidad de notas por página</label>';
    echo '<select name="cantNotes" id="cantNotes">';
    foreach ($options as $option) {
        echo '<option value="' . $option . '">' . $option . '</option>';
    }
    echo '</select>';
    echo '<button type="submit" 
                  formaction="http://localhost/Servidor/UD14-MVC/EjemploMVC/index.php/ControladorNota/list/"
                  >Filtrar</button>';
    echo '</form>';
    echo '</article>';
}

/**
 * Imprime información sobre la paginación y los resultados en formato HTML.
 *
 * Esta función recupera información de la sesión, como la página seleccionada,
 * la cantidad máxima de páginas, el número total de elementos y la cantidad de
 * notas a mostrar por página. Luego, genera HTML para mostrar esta información
 * en la interfaz de usuario, incluyendo la cantidad de notas por página y el rango
 * de resultados actual en relación con el total de resultados.
 *
 * @return void
 */
function printInfo() {
    $paginaSeleccionada = $_SESSION['paginaSeleccionada']; // Página seleccionada por el usuario.
    $paginaMaxima = $_SESSION['maxPag']; // Página máxima posible.
    $cantidadElementos = $_SESSION['contador']; // Cantidad total de notas que se encuentran en la BD.
    $cantidadRegistros = $_SESSION['cantNotes'] ?? constant('CANTIDAD_REGISTROS');// Cantidad de notas por página.

    $inicioResultados = ($paginaSeleccionada - 1) * $cantidadRegistros + 1;
    $finResultados = ($paginaSeleccionada < $paginaMaxima)
        ? ($paginaSeleccionada * $cantidadRegistros)
        : $cantidadElementos;

    echo '<p>Mostrando ' . $cantidadRegistros . ' notas por página.';
    echo '<p>Resultados ' . $inicioResultados . ' - ' . $finResultados . ' de ' . $cantidadElementos . ' resultados';
}