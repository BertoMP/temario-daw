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

    protected function paginateData(int $intTotalRegisters, string $strSelectedPage): array
    {
        // Array que se devolverá como resultado de la función.
        $arrReturn = [];

        // Convertir a entero el string con la página recibido por parámetro.
        $intSelectedPage = (int)$strSelectedPage;

        // Configuración del número de registros por página
        if (isset($_POST['numRegisters'])) {
            $_SESSION['numRegisters'] = $_POST['numRegisters'];
        }

        // Obtención del número de registros por página (o usa el valor predeterminado)
        $numberRegisters = $_SESSION['numRegisters'] ?? DEFAULT_REGISTERS;

        // Guarda el número total de registros en el array de retorno
        $arrReturn['totalRegisters'] = $intTotalRegisters;

        // Calcula la cantidad máxima de páginas basada en la paginación y registros por página
        $maxPage = ceil($intTotalRegisters / $numberRegisters);
        $arrReturn['maxPage'] = $maxPage;

        // Ajusta la página seleccionada para asegurarse de que esté dentro de los límites válidos
        if ($intSelectedPage <= 1) {
            $intSelectedPage = 1;
        } elseif ($intSelectedPage > $maxPage) {
            $intSelectedPage = $maxPage;
        }

        // Guarda la página actual seleccionada en el array de retorno
        $arrReturn['selectedPage'] = $intSelectedPage;

        return $arrReturn;
    }
}