<?php
class Character {
    private string $strUrl;

    public function __construct()
    {
        $this->strUrl = 'https://swapi.dev/api/people/';
    }

    public function getPageCharacters(string $strPage): array
    {
        $arrReturn = [];

        $arrCurlData = Functionality::getJSON($this->strUrl . '?page=' . $strPage);

        if ($arrCurlData !== null) {
            $arrCharacters = $arrCurlData['results'];
            $arrReturn['params']['actualPage'] = $strPage;
            $arrReturn['params']['count'] = $arrCurlData['count'];
            $arrReturn['params']['previous'] = $this->getPageNumber($arrCurlData['previous']);
            $arrReturn['params']['next'] = $this->getPageNumber($arrCurlData['next']);

            foreach ($arrCharacters as $character) {
                $characterId = Character::getId($character['url']);
                $arrReturn['data'][$characterId]['ID'] = $characterId;
                $arrReturn['data'][$characterId]['NOMBRE'] = $character['name'];
                $arrReturn['data'][$characterId]['ALTURA'] = $character['height'];
                $arrReturn['data'][$characterId]['PESO'] = $character['mass'];
                $arrReturn['data'][$characterId]['NACIMIENTO'] = $character['birth_year'];
            }
        }

        return $arrReturn;
    }

    public function getCharacterInfo(string $id): array
    {
        $arrReturn = [];
        $arrCurlData = Functionality::getJSON($this->strUrl . $id);

        if ($arrCurlData !== null) {
            $arrReturn['id'] = $id;
            $arrReturn['name'] = $arrCurlData['name'];

            $arrSpeciesUrl = $arrCurlData['species'];

            foreach ($arrSpeciesUrl as $speciesUrl) {
                $arrReturn['species'][] = (new Species())->getSpecieName($speciesUrl);
            }

            $arrReturn['hair_color'] = $arrCurlData['hair_color'];
            $arrReturn['skin_color'] = $arrCurlData['skin_color'];
            $arrReturn['eye_color'] = $arrCurlData['eye_color'];

            $arrStarshipsUrl = $arrCurlData['starships'];

            foreach ($arrStarshipsUrl as $starshipUrl) {
                $arrReturn['starships'][] = (new Starship())->getStarshipName($starshipUrl);
            }

            $arrVehiclesUrl = $arrCurlData['vehicles'];

            foreach ($arrVehiclesUrl as $vehicleUrl) {
                $arrReturn['vehicles'][] = (new Vehicle())->getVehicleName($vehicleUrl);
            }

            $arrReturn['homeworld'] = (new Planet())->getPlanetName($arrCurlData['homeworld']);

            $arrFilmsUrl = $arrCurlData['films'];

            foreach ($arrFilmsUrl as $filmUrl) {
                $arrReturn['films'][] = (new Film())->getFilmTitle($filmUrl);
            }
        }

        return $arrReturn;
    }

    private static function getId(string $strUrl): string
    {
        $arrUrlParams = explode('/', $strUrl);
        return $arrUrlParams[count($arrUrlParams) - 2];
    }

    private static function getPageNumber(string | null $strUrl): string | null
    {
        if ($strUrl === null) {
            return null;
        }

        $arrUrlParams = explode('=', $strUrl);
        return $arrUrlParams[1];
    }
}