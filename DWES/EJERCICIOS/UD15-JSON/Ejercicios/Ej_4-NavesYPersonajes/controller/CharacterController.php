<?php

use database\Character;

class CharacterController extends Controller
{
    private Character $objCharacterModel;

    public function __construct(array $arrParams)
    {
        $this->strPageTitle = 'Listado de personajes';
        $this->strView = 'characterList';
        $this->arrParams = $arrParams;
        $this->objCharacterModel = new Character();
    }

    public function list(): array
    {
        $this->strPageTitle = 'Listado de personajes';
        $this->strView = 'characterList';
        $arrReturn = $this->objCharacterModel->getPageCharacters($this->arrParams[0] ?? '1');

        if (empty($arrReturn)) {
            $this->strView = 'notAvailable';
        }

        return $arrReturn;
    }

    public function info(): array
    {
        $this->strPageTitle = 'Información del personaje';
        $this->strView = 'characterInfo';
        $arrReturn['data'] = $this->objCharacterModel->getCharacterInfo($this->arrParams[0]);

        if (empty($arrReturn['data'])) {
            $this->strView = 'notAvailable';
        }

        return $arrReturn;
    }
}
