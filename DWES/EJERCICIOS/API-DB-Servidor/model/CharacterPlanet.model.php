<?php

class CharacterPlanet
{
    private string $strTable;
    private PDO $PDOConnection;

    public function __construct()
    {
        $this->strTable = 'CHARACTERS_PLANETS';
        $this->PDOConnection = Database::createConn();
    }

    public function getPlanetUrl(string $characterId): array
    {
        $SQLQuery = 'SELECT PLANET_ID FROM ' . $this->strTable
            . ' WHERE CHARACTER_ID = :characterId';

        $PDOStmt = $this->PDOConnection->prepare($SQLQuery);

        $PDOStmt->bindParam(':characterId', $characterId);

        $PDOStmt->execute();

        $arrPlanets = $PDOStmt->fetchAll(PDO::FETCH_ASSOC);
        $arrReturn = [];
        $baseUrl = 'http://localhost/Servidor/API-Servidor/index.php/Planet/';

        foreach ($arrPlanets as $planet) {
            $arrReturn[] = $baseUrl . $planet['PLANET_ID'];
        }

        return $arrReturn;
    }
}