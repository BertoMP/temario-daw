<?php

abstract class View
{
    public static function render(array $arrData = null): void
    {
        include_once 'view/template/header.php';
        include_once 'view/' . $arrData['params']['view'] . '.view.php';
        include_once 'view/template/footer.html';
    }
}