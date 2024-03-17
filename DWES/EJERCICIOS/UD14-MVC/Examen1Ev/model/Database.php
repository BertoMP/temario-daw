<?php

require_once 'config/config.php';

abstract class database {
    public static function getConexion(): PDO | null {
        try {
            return new PDO(
                'mysql:host=' . constant('DB_HOST')
                . '; port= ' . constant('DB_PORT')
                . '; dbname= ' . constant('DB_NAME'),
                constant('DB_USER'),
                constant('DB_PASS')
            );
        } catch (PDOException $e) {
            echo 'ERROR EN LA CONEXIÓN A LA BASE DE DATOS';
            exit();
        }
    }

    public static function closeConnection(?PDO $connection, ?PDOStatement $SQLStatement): void {
        $SQLStatement?->closeCursor();

        if ($connection !== null) {
            $connection = null;
        }
    }
}