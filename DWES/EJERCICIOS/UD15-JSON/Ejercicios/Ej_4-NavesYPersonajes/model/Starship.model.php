<?php
class Starship {
    private string $strUrl;

    public function __construct()
    {
        $this->strUrl = 'https://swapi.dev/api/starship/';
    }

    public function getStarshipName(string $strUrl)
    {
        $arrCurlData = Functionality::getJSON($strUrl);
        return $arrCurlData['name'];
    }
}