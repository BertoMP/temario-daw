<?php

/**
 * Clase encargada de comunicarse con la tabla LIBROS
 * de la base de datos.
 */
class Book
{
    private string $strTable;           // Almacena el nombre de la tabla.
    private PDO $PDOConnection;         // Conexión a la base de datos.

    /**
     * Constructor del modelo de libros.
     *
     * Inicializa el nombre de la tabla y la conexión PDO para la
     * gestión de libros en la base de datos.
     */
    public function __construct()
    {
        $this->strTable = 'LIBROS';                         // Se asocia el nombre de la tabla a utilizar.
        $this->PDOConnection = Database::createConn();      // Se genera una conexión a la base de datos.
    }

    public function getTotalBooksBySearch(): int
    {
        // Consulta SQL para buscar libros en la base de datos.
        $SQLQuery = 'SELECT COUNT(*) AS CANTIDAD'
            . ' FROM LIBROS';

        // Preparar la consulta SQL.
        $PDOStmt = $this->PDOConnection->prepare($SQLQuery);

        // Ejecutar la consulta SQL.
        $PDOStmt->execute();
        $totalBooksRow = $PDOStmt->fetch(PDO::FETCH_ASSOC);

        return $totalBooksRow['CANTIDAD'];
    }

    /**
     * Realiza una búsqueda de libros en la base de datos según la
     * consulta proporcionada.
     *
     * @param string $strPage   La página de la que conseguir los campos.
     *
     * @return array            Un array que contiene los resultados de la búsqueda de libros.
     */
    public function getItems(array $arrParams): array
    {
        $strPage = $arrParams[0];

        $intRegisters = $_SESSION['numRegisters'] ?? DEFAULT_REGISTERS;
        $intLimit = ((int)$strPage - 1) * $intRegisters;

        // Consulta SQL para buscar libros en la base de datos.
        $SQLQuery =
            'SELECT * FROM LIBROS'
            . ' ORDER BY TITULO'
            . ' LIMIT ' . $intLimit . ', ' . $intRegisters;

        // Preparar la consulta SQL.
        $PDOStmt = $this->PDOConnection->prepare($SQLQuery);

        // Ejecutar la consulta SQL.
        $PDOStmt->execute();
        $count = $this->getTotalBooksBySearch();
        $results = $PDOStmt->fetchAll(PDO::FETCH_ASSOC);

        return [
            'count' => $count,
            'results' => $results
        ];
    }
}