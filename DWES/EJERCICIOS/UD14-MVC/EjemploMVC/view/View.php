<?php

namespace view;
class View
{
    public static function render(object $controller, array $arrData = null)
    {
        include 'view/template/cabecera.php';
        include 'view/' . $controller->view . '.php';
        include 'view/template/pie.html';
    }
}