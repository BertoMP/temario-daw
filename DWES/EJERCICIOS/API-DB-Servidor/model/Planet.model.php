<?php

class Planet
{
    private string $strTable;
    private PDO $PDOConnection;

    public function __construct()
    {
        $this->strTable = 'PLANETS';
        $this->PDOConnection = Database::createConn();
    }

    public function getItems(array $arrParams): array
    {
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

        return $PDOStmt->fetchAll(PDO::FETCH_ASSOC);
    }
}