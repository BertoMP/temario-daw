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
     * @param string $strEmail El correo electrónico del usuario.
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
        $SQLQuery = 'INSERT INTO ' . $this->strTable . '(EMAIL, PASSWORD, ROL)'
            . ' VALUES (:strUserEmail, :strUserPassword, :strUserRole)';

        // Prepara la declaración SQL
        $PDOStmt = $this->PDOConnection->prepare($SQLQuery);

        // Hash de la contraseña antes de almacenarla en la base de datos
        $hashPassword = password_hash($arrUserData['userPassword'], PASSWORD_DEFAULT);

        // Vincula los parámetros de la consulta con los valores proporcionados
        $PDOStmt->bindParam(':strUserEmail', $arrUserData['userEmail']);
        $PDOStmt->bindParam(':strUserPassword', $hashPassword);
        $PDOStmt->bindParam(':strUserRole', $_REQUEST['userRole']);

        // Ejecuta la consulta para insertar el nuevo usuario en la base de datos
        $PDOStmt->execute();
    }

    /**
     * Obtiene el rol asociada a un correo electrónico de usuario.
     *
     * @param string $strEmail El correo electrónico del usuario.
     *
     * @return string|null      Devuelve el rol asociado si el correo electrónico
     *                          está registrado o null si no existe.
     */
    public function getRole(string $strEmail): string|null
    {
        // Construcción de la consulta SQL para obtener la contraseña
        $SQLQuery = 'SELECT ROL FROM ' . $this->strTable . ' WHERE EMAIL = :email';

        // Preparación y ejecución de la consulta SQL con el correo electrónico como parámetro
        $PDOStmt = $this->PDOConnection->prepare($SQLQuery);
        $PDOStmt->bindParam(':email', $strEmail);
        $PDOStmt->execute();

        // Obtención de la fila de resultados
        $userRow = $PDOStmt->fetch();

        return (!is_bool($userRow)) ? $userRow['ROL'] : null;
    }

    /**
     * Evita inyecciones SQL eliminando palabras clave prohibidas del array de datos.
     *
     * @param array $arrData El array de datos a procesar.
     *
     * @return array El array procesado sin palabras clave SQL.
     */
    public static function preventSQLInjection(array $arrData): array
    {
        $forbiddenKeywords = ['select', 'insert', 'delete', 'update', 'from']; // Array con las palabras a eliminar.
        $arrReturn = [];
        foreach ($arrData as $index => $datum) {
            $strElementLowerCase = strtolower($datum); // String que pasa a minúsculas el string del parámetro.

            foreach ($forbiddenKeywords as $keyword) {
                $strElementLowerCase = str_replace($keyword, '', $strElementLowerCase);
            }

            $arrReturn[$index] = $strElementLowerCase;
        }

        return $arrReturn;
    }

    /**
     * Verifica si los campos en el array de datos no están vacíos.
     *
     * @param array $arrData El array de datos a verificar.
     *
     * @return bool True si no hay campos vacíos, False en caso contrario.
     */
    public static function checkEmptyFields(array $arrData): bool
    {
        for ($intCont = 0; $intCont < count($arrData); $intCont++) {
            if (empty($arrData[$intCont])) {
                return false;
            }
        }

        return true;
    }

    /**
     * Verifica si una dirección de correo electrónico es válida.
     *
     * @param string $email La dirección de correo electrónico a validar.
     *
     * @return bool True si la dirección de correo electrónico es válida, false de lo contrario.
     */
    public static function checkMail(string $email): bool
    {
        return !filter_var($email, FILTER_VALIDATE_EMAIL);
    }
}