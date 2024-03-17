<?php

class Character
{
    private string $strTable;
    private PDO $PDOConnection;

    public function __construct()
    {
        $this->strTable = 'CHARACTERS';
        $this->PDOConnection = Database::createConn();
    }

    public function getItems(array $arrParams): array
    {
        include_once 'CharacterPlanet.model.php';

        $SQLQuery = 'SELECT * FROM ' . $this->strTable;

        if (count($arrParams) > 0) {
            $value = $arrParams[0];
            if(is_numeric($value)) {
                $SQLQuery .= ' WHERE ID = :value';
            } else {
                $value = str_replace('+', ' ', $value);
                $SQLQuery .= ' WHERE NAME = :value';
            }

            $PDOStmt = $this->PDOConnection->prepare($SQLQuery);

            $PDOStmt->bindParam(':value', $value);
        } else {
            $PDOStmt = $this->PDOConnection->prepare($SQLQuery);
        }

        $PDOStmt->execute();
        $arrCharacters = $PDOStmt->fetchAll(PDO::FETCH_ASSOC);
        $arrReturn = [];

        foreach ($arrCharacters as $character) {
            $character['ORIGIN'] = (new CharacterPlanet())->getPlanetUrl($character['ID']);
            $character['IMG'] = IMG_URL . $character['ID'] . '.webp';

            $arrReturn[] = $character;
        }

        return $arrReturn;
    }
}