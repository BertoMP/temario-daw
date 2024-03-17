<?php

/**
 * Clase abstracta encargada de renderizar la página elegida.
 */
abstract class View
{
    /**
     * Función encargada de cargar la cabecera y el pie de página,
     * así como la vista elegida.
     *
     * @param array|null $arrData Un array con los datos necesarios para
     *                            la lógica interna de la vista.
     * @return void
     */
    public static function render(array $arrData = null): void
    {
        include_once 'view/template/header.php';                            // Se incluye el header de la página.
        include_once 'view/template/nav.php';                               // Se incluye la navbar de la página.
        include_once 'view/' . $arrData['params']['view'] . '.view.php';    // Se incluye la vista elegida.
        include_once 'view/template/footer.html';                           // Se incluye el footer de la página.
    }
}