<?php
class Film {
    private string $strUrl;

    public function __construct()
    {
        $this->strUrl = 'https://swapi.dev/api/films/';
    }

    public function getFilmTitle(string $strUrl)
    {
        $arrCurlData = Functionality::getJSON($strUrl);
        return $arrCurlData['title'];
    }
}