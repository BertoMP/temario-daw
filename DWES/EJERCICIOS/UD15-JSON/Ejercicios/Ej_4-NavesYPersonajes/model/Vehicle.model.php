<?php
class Vehicle {
    private string $strUrl;

    public function __construct()
    {
        $this->strUrl = 'https://swapi.dev/api/vehicles/';
    }

    public function getVehicleName(string $strUrl)
    {
        $arrCurlData = Functionality::getJSON($strUrl);
        return $arrCurlData['name'];
    }
}