<?php

/**
 * Clase abstracta que sirve métodos estáticos al programa
 * para funcionalidades como la impresión del paginado
 * o de las entradas de libros.
 */
abstract class Functionality
{
    /**
     * Función encargada de imprimir la paginación de cada una de las secciones de la página.
     * Se genera un botón anterior y un botón siguiente que tendrán el atributo disabled
     * en caso de encontrarnos en la primera o última página respectivamente. Además,
     * se imprimen cada una de las páginas intermedias como enlaces de acceso rápido.
     *
     * @param array $arrParams El array con los parámetros que necesita la función
     *                         para realizar su tarea. Es el dataToView del index.php,
     *                         concretamente el subarray ['params'] que almacena datos como
     *                         la página seleccionada o el máximo de páginas.
     *
     * @param string $strElement El string que determina el tipo de elemento del que habrá que
     *                           imprimir su paginado, 'libros' o 'autores' en este caso.
     *                           En función de este valor la variable $URL ajusta su valor,
     *                           y, por tanto, se asocia uno u otro enlace.
     * @return void
     */
    public static function printPages(array $arrParams, string $strElement): void
    {
        $selectedPage = $arrParams['selectedPage'];         // String que almacena la página seleccionada.
        $maxPage = $arrParams['maxPage'];                   // String que almacena la página máxima.
        $URL = CONTROLLERs_URL[$strElement] . 'list/';      // String que almacena la URL que debe utilizarse.
        $URLPreviousPage = $URL . ($selectedPage - 1);      // URL de la página anterior.
        $URLNextPage = $URL . ($selectedPage + 1);          // URL de la página siguiente.

        echo '<article>';

        echo '<a href="' . $URLPreviousPage . '"><button ' . ($selectedPage <= 1 ? 'disabled' : '')
            . '>Anterior</button></a>';

        for ($intCont = 1; $intCont <= $maxPage; $intCont++) {
            $URLPage = $URL . $intCont; // La URL de cada una de las páginas.
            echo '<a ' . ($intCont !== (int)$selectedPage ? 'href="' . $URLPage . '"' : 'class="selected"')
                . '>' . $intCont . '</a>';
        }

        echo '<a href="' . $URLNextPage . '"><button ' . ($selectedPage >= $maxPage ? 'disabled' : '')
            . '>Siguiente</button></a>';

        echo '</article>';
    }

    /**
     * Función encargada de imprimir un formulario de filtrado de resultados a través de un
     * select con diferentes options.
     *
     * @param string $strElement El string que determina el tipo de elemento que realiza la
     *                           la llamada.
     *                           En función de este valor la variable $URL ajusta su valor,
     *                           y, por tanto, se asocia uno u otro enlace.
     * @return void
     */
    public static function printFilterOptions(string $strElement): void
    {
        $arrOptions = DEFAULT_OPTIONS;                      // Array que almacena las options del select.
        $URL = CONTROLLERs_URL[$strElement] . 'list/';      // String que almacena la URL que debe utilizarse.
        $blnSelected = false;

        echo '<article>';
        echo '<form method="post" action="' . $URL . '">';
        echo '<article><label for="numRegisters">Cantidad de registros por página</label></article>';
        echo '<article>';
        echo '<select name="numRegisters" id="numRegisters">';
        foreach ($arrOptions as $option) {
            echo '<option value="' . $option . '"';

            if ((!$blnSelected) and (($option === DEFAULT_REGISTERS) or ($option === $_SESSION['numRegisters']))) {
                $blnSelected = !$blnSelected;
                echo 'selected';
            }

            echo '>' . $option . '</option>';
        }
        echo '</select>';
        echo '</article>';
        echo '<article><button type="submit">Filtrar</button></article>';
        echo '</article>';
        echo '</form>';
        echo '</article>';
    }

    /**
     * Función encargada de imprimir información del número de registros que se están
     * mostrando por página así como el índice de los registros menor y mayor de la
     * página sobre el total de la página. P.e. 'Mostrando 4 registros por página.
     * Resultados 5-8 de 16 libros'.
     *
     * @param array $arrParams El array con los parámetros que necesita la función
     *                         para realizar su tarea. Es el dataToView del index.php,
     *                         concretamente el subarray ['params'] que almacena datos como
     *                         la página seleccionada o el máximo de páginas.
     *
     * @param string $strElement El string que determina el tipo de elemento del que habrá que
     *                           imprimir en la información de los resultados.
     * @return void
     */
    public static function printInfo(array $arrParams, string $strElement): void
    {
        $numRegisters = $_SESSION['numRegisters'] ?? DEFAULT_REGISTERS;     // Int con el número de registros a mostrar.
        $selectedPage = $arrParams['selectedPage'];                         // Int con el número de la página seleccionada.
        $maxPage = $arrParams['maxPage'];                                   // Int con el número de la página máxima posible.
        $totalRegisters = $arrParams['totalRegisters'];                     // Int con el número total de registros de la base de datos.
        $firstResult = ($selectedPage - 1) * $numRegisters + 1;             // Int con el número del menor índice de la página.
        $lastResult = ($selectedPage < $maxPage)                            // Int con el mayor índice de la página.
            ? ($selectedPage * $numRegisters)
            : $totalRegisters;

        echo '<article>';
        echo '<p>Mostrando ' . $numRegisters . ' ' . $strElement . ' por página';
        echo '<p>Resultados ' . $firstResult . ' - ' . $lastResult . ' de ' . $totalRegisters . ' ' . $strElement;
        echo '</article>';
    }

    /**
     * Función encargada de imprimir por pantalla cada uno de los resultados de la
     * base de datos correspondientes al controlador seleccionado.
     *
     * @param array $arrData El array con los datos que necesita la función para
     *                       realizar su tarea. Es el dataToView del index.php,
     *                       concretamente el subarray ['data'] que almacena las
     *                       entradas de la base de datos.
     *
     * @param string $strElement El string que determina el tipo de elemento del que
     *                           habrá que imprimir en la información de la base de
     *                           datos.
     * @return void
     */
    public static function printItems(array $arrData, string $strElement): void
    {
        $URL = CONTROLLERs_URL[$strElement]; // URL base del controlador.

        switch ($strElement) {
            case 'books':
                foreach ($arrData as $book) {
                    $URLToEdit = $URL . 'edit/' . $book['ID_LIBRO'];                    // URL para la edición.
                    $URLToDelete = $URL . 'confirmDelete/' . $book['ID_LIBRO'];         // URL para la eliminación.

                    echo '<section class="element">';
                    echo '<h2>' . mb_strtoupper($book['TITULO'], 'UTF-8') . '</h2>';
                    echo '<table>';
                    echo '<tbody>';
                    echo '<tr><th>ID LIBRO</th><td>' . $book['ID_LIBRO'] . '</td></tr>';

                    if (str_contains($book['NOMBRES_AUTORES'], ',')) {
                        echo '<tr><th>AUTORES</th><td>';
                        $authors = explode(',', $book['NOMBRES_AUTORES']);
                        $strAuthors = '';
                        for ($intCont = 0; $intCont < count($authors); $intCont++) {
                            $strAuthors .= $authors[$intCont];

                            if ($intCont < (count($authors) - 1)) {
                                $strAuthors .= ', ';
                            }
                        }
                    } else {
                        echo '<tr><th>AUTOR</th><td>';
                        $strAuthors = $book['NOMBRES_AUTORES'];
                    }

                    echo mb_strtoupper($strAuthors, 'UTF-8'). '</td></tr>';
                    echo '<tr><th>GÉNERO PRINCIPAL</th><td>' . mb_strtoupper($book['GENERO'], 'UTF-8') . '</td></tr>';
                    echo '<tr><th>PAÍS</th><td>' . mb_strtoupper($book['PAIS'], 'UTF-8') . '</td></tr>';
                    echo '<tr><th>AÑO DE PUBLICACIÓN</th><td>' . $book['ANO'] . '</td></tr>';
                    echo '<tr><th>NÚMERO DE PÁGINAS</th><td>' . $book['NUM_PAGINAS'] . '</td></tr>';
                    echo '</tbody>';
                    echo '</table>';
                    if ($_SESSION['userRole'] > 5) {
                        echo '<article class="btn-container">';
                        echo '<a class="edit-element" href="' . $URLToEdit . '">Editar</a>';
                        echo '<a class="delete-element" href="' . $URLToDelete . '">Borrar</a>';
                        echo '</article>';
                    }
                    echo '</section>';
                }
                break;
            case 'authors':
                foreach ($arrData as $author) {
                    $URLToEdit = $URL . 'edit/' . $author['ID_PERSONA'];                    // URL para la edición.
                    $URLToDelete = $URL . 'confirmDelete/' . $author['ID_PERSONA'];         // URL para la eliminación.
                    $authorCompleteName = $author['APELLIDO'] . ', ' . $author['NOMBRE'];   // Nombre completo del autor.

                    echo '<section class="element">';
                    echo '<h2>' . mb_strtoupper($authorCompleteName, 'UTF-8') . '</h2>';
                    echo '<table>';
                    echo '<tbody>';
                    echo '<tr><th>ID AUTOR</th><td>' . $author['ID_PERSONA'] . '</td></tr>';
                    echo '<tr><th>FECHA DE NACIMIENTO</th><td>' . $author['FECHA_NACIMIENTO'] . '</td></tr>';
                    echo '<tr><th>PAÍS</th><td>' . mb_strtoupper($author['PAIS_ORIGEN'], 'UTF-8') . '</td></tr>';
                    echo '<tr><th>CANTIDAD DE LIBROS PUBLICADOS</th><td>' . $author['LIBROS_PUBLICADOS'] . '</td></tr>';
                    echo '</tbody>';
                    echo '</table>';
                    if ($_SESSION['userRole'] > 5) {
                        echo '<article class="btn-container">';
                        echo '<a class="edit-element" href="' . $URLToEdit . '">Editar</a>';
                        echo '<a class="delete-element" href="' . $URLToDelete . '">Borrar</a>';
                        echo '</article>';
                    }
                    echo '</section>';
                }
                break;
        }
    }
}