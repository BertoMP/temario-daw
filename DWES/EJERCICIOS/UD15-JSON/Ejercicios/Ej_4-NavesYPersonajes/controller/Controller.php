<?php

/**
 * Clase abstracta que servirá como supertipo de los
 * controladores del programa
 */
abstract class Controller
{
    protected string $strPageTitle; // Título de la página
    protected string $strView; // Vista de la página
    protected array $arrParams; // Parámetros asociados de la página

    /**
     * Devuelve el valor del atributo $strPageTitle.
     *
     * @return string El valor del atributo $strPageTitle.
     */
    public function getPageTitle(): string
    {
        return $this->strPageTitle;
    }

    /**
     * Devuelve el valor del atributo $strView.
     *
     * @return string El valor del atributo $strView.
     */
    public function getView(): string
    {
        return $this->strView;
    }
}