<?php

class BookController extends Controller
{
    public function __construct(array $arrParams)
    {
        $this->strPageTitle = 'Listado de libros';
        $this->strView = 'bookList';
        $this->arrParams = $arrParams;
    }

    public function list(): array
    {
        $this->strPageTitle = 'Listado de libros';
        $this->strView = 'bookList';

        $intSelectedPage = $this->arrParams[0] ?? 1;
        $maxPage = $_SESSION['maxPage'] ?? 1;

        if ($intSelectedPage > $maxPage) {
            $intSelectedPage = $maxPage;
        } elseif ($intSelectedPage < 1) {
            $intSelectedPage = 1;
        }

        $_SESSION['actualPage'] = $intSelectedPage;
        $url = APP_CALL_API . 'Book/' . $intSelectedPage;
        $arrReturn['data'] = Functionality::getJSON($url);

        return $arrReturn;
    }
}