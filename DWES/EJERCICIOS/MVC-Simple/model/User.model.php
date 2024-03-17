<?php

class User
{
    private string $strTable; // Atributo que almacenará el nombre de la tabla a utilizar.
    private PDO $PDOConnection; // Atributo que almacenara la conexión a la base de datos.

    public function __construct()
    {
        $this->strTable = 'USUARIOS'; // Nombre de la tabla a la que se le harán consultas.
        $this->PDOConnection = Database::createConn(); // Creación de una conexión a la base de datos.
    }

    // FUNCIÓN QUE COMPRUEBA SI EL USUARIO ESTÁ LOGADO.
    public static function isLogged(): bool
    {
        return isset($_SESSION['logged']); // Devuelve true/false en función de si el valor 'logged' de SESSION está iniciado.
    }

    // FUNCIÓN ENCARGADA DE CONSULTAR Y DEVOLVER LA CONTRASEÑA DE UN EMAIL PASADO POR PARÁMETRO.
    public function getPassword(string $strEmail): string|null
    {
        // Construimos la sentencia SQL para la consulta.
        $SQLQuery = 'SELECT PASSWORD FROM ' . $this->strTable
            . ' WHERE EMAIL = :email';

        // Preparamos la conexión y la ejecutamos.
        $PDOStmt = $this->PDOConnection->prepare($SQLQuery);
        $PDOStmt->bindParam(':email', $strEmail);
        $PDOStmt->execute();

        // Guardamos el valor de la consulta en una variable. Esta variable guardará un
        // array asociativo ['PASSWORD' => valorPassWord] si el mail existe o false
        // si el mail no existe en la base de datos.
        $userRow = $PDOStmt->fetch(PDO::FETCH_ASSOC);

        // Devolvemos el valor de la PASSWORD si el mail existe o null si el mail no existe.
        return (!is_bool($userRow)) ? $userRow['PASSWORD'] : null;
    }
}