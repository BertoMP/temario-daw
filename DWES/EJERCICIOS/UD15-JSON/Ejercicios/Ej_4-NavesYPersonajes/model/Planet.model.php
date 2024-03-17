<?php
class Planet {
    private string $strUrl;

    public function __construct()
    {
        $this->strUrl = 'https://swapi.dev/api/planet/';
    }

    public function getPlanetName(string $strUrl)
    {
        $arrCurlData = Functionality::getJSON($strUrl);
        return $arrCurlData['name'];
    }
}