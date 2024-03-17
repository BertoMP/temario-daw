<?php
class Species {
    private string $strUrl;

    public function __construct()
    {
        $this->strUrl = 'https://swapi.dev/api/species/';
    }

    public function getSpecieName(string $strUrl)
    {
        $arrCurlData = Functionality::getJSON($strUrl);
        return $arrCurlData['name'];
    }
}