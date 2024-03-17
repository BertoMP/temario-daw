<?php
abstract class View
{
    // MÉTODO PARA RENDERIZAR LA PÁGINA
    public static function render(array $arrData): void
    {
        include_once 'view/template/header.php'; // Incluye el archivo de cabecera.
        include_once 'view/template/nav.php'; // Incluye el archivo de la barra de navegación.
        include_once 'view/' . $arrData['params']['view'] . '.view.php'; // Incluye el archivo de vista correspondiente.
        include_once 'view/template/footer.html'; // Incluye el archivo de pie de página.
    }
}