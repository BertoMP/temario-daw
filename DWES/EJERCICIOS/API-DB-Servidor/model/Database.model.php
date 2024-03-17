<?php

abstract class Database
{
    public static function createConn(): PDO|null
    {
        try {
            return new PDO('mysql:host=' . DB_HOST . '; port= ' . DB_PORT
                . '; dbname=' . DB_NAME, DB_USER, DB_PASS);
        } catch (PDOException $e) {
            echo 'ERROR EN LA CONEXIÓN A LA BASE DE DATOS.';
            exit();
        }
    }
}