<?php

/**
 * Clase encargada de comunicarse con la tabla USUARIOS
 * de la base de datos.
 */
class User
{
    private string $strTable;           // Almacena el nombre de la tabla.
    private PDO $PDOConnection;         // Conexión a la base de datos.

    /**
     * Constructor de la clase User.
     * Inicializa el nombre de la tabla y la conexión PDO a la base de datos.
     */
    public function __construct()
    {
        $this->strTable = 'USUARIOS';
        $this->PDOConnection = Database::createConn();
    }

    /**
     * Verifica si el usuario está autenticado.
     *
     * @return bool     Devuelve true si el usuario está autenticado,
     *                  false en caso contrario.
     */
    public static function isLogged(): bool
    {
        return isset($_SESSION['logged']);
    }

    /**
     * Obtiene la contraseña asociada a un correo electrónico de usuario.
     *
     * @param string $strEmail  El correo electrónico del usuario.
     *
     * @return string|null      Devuelve la contraseña si el correo electrónico
     *                          está registrado o null si no existe.
     */
    public function getPassword(string $strEmail): string|null
    {
        // Construcción de la consulta SQL para obtener la contraseña
        $SQLQuery = 'SELECT PASSWORD FROM ' . $this->strTable . ' WHERE EMAIL = :email';

        // Preparación y ejecución de la consulta SQL con el correo electrónico como parámetro
        $PDOStmt = $this->PDOConnection->prepare($SQLQuery);
        $PDOStmt->bindParam(':email', $strEmail);
        $PDOStmt->execute();

        // Obtención de la fila de resultados
        $userRow = $PDOStmt->fetch();

        return (!is_bool($userRow)) ? $userRow['PASSWORD'] : null;
    }

    /**
     * Guarda un nuevo usuario en la base de datos.
     *
     * @param array $arrUserData Un array que contiene los datos del usuario.
     *                           Requiere 'userEmail' y 'userPassword'.
     */
    public function saveUser(array $arrUserData): void
    {
        // Construye la consulta SQL para insertar un nuevo usuario
        $SQLQuery = 'INSERT INTO ' . $this->strTable . '(EMAIL, PASSWORD)'
            . ' VALUES (:strUserEmail, :strUserPassword)';

        // Prepara la declaración SQL
        $PDOStmt = $this->PDOConnection->prepare($SQLQuery);

        // Hash de la contraseña antes de almacenarla en la base de datos
        $hashPassword = password_hash($arrUserData['userPassword'], PASSWORD_DEFAULT);

        // Vincula los parámetros de la consulta con los valores proporcionados
        $PDOStmt->bindParam(':strUserEmail', $arrUserData['userEmail']);
        $PDOStmt->bindParam(':strUserPassword', $hashPassword);

        // Ejecuta la consulta para insertar el nuevo usuario en la base de datos
        $PDOStmt->execute();
    }
}