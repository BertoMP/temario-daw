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

    /**
     * Obtiene el total de libros en la base de datos.
     *
     * Realiza una consulta SQL para contar la cantidad total de libros
     * en la tabla correspondiente.
     *
     * @return int El total de libros en la base de datos.
     */
    public function getTotalBooks(): int
    {
        // Query SQL para contar la cantidad total de libros.
        $SQLQuery = 'SELECT COUNT(ID_LIBRO) AS CANTIDAD FROM ' . $this->strTable;

        // Preparar la consulta SQL.
        $PDOStmt = $this->PDOConnection->prepare($SQLQuery);

        // Ejecutar la consulta SQL.
        $PDOStmt->execute();

        // Obtener la fila de resultados.
        $counterBooksRow = $PDOStmt->fetch();

        return $counterBooksRow['CANTIDAD'];
    }

    /**
     * Obtiene una lista paginada de libros desde la base de datos.
     *
     * Realiza una consulta SQL para obtener una lista paginada de
     * libros ordenados por ID_LIBRO.
     *
     * @param string $strPage   La página seleccionada para la paginación.
     * @return array            Un array con los datos de los libros para la página actual.
     */
    public function getBooks(string $strPage): array
    {
        // Obtener el número de registros por página de la sesión o utilizar el valor predeterminado.
        $intNumRegisters = $_SESSION['numRegisters'] ?? DEFAULT_REGISTERS;

        // Calcular el límite para la paginación.
        $intLimit = ((int)$strPage - 1) * $intNumRegisters;

        // Query SQL para obtener una lista paginada de libros ordenados por ID_LIBRO.
        $SQLQuery = 'SELECT * FROM ' . $this->strTable
            . ' ORDER BY TITULO'
            . ' LIMIT ' . $intLimit . ', ' . $intNumRegisters;

        // Preparar la consulta SQL.
        $PDOStmt = $this->PDOConnection->prepare($SQLQuery);

        // Ejecutar la consulta SQL.
        $PDOStmt->execute();

        return $PDOStmt->fetchAll(PDO::FETCH_ASSOC);
    }

    /**
     * Obtiene los detalles de un libro por su ID.
     *
     * Realiza una consulta SQL para obtener los detalles de un libro
     * específico mediante su ID_LIBRO.
     *
     * @param string $strBookId     El ID del libro que se desea obtener.
     * @return array                Un array con los detalles del libro o
     *                              un array vacío si no se encuentra el libro.
     */
    public function getBookById(string $strBookId): array
    {
        // Query SQL para obtener los detalles de un libro por su ID_LIBRO.
        $SQLQuery = 'SELECT * FROM ' . $this->strTable
            . ' WHERE ID_LIBRO = :strBookId';

        // Preparar la consulta SQL.
        $PDOStmt = $this->PDOConnection->prepare($SQLQuery);

        // Vincular el parámetro :strBookId con el valor proporcionado.
        $PDOStmt->bindParam(':strBookId', $strBookId);

        // Ejecutar la consulta SQL.
        $PDOStmt->execute();

        // Obtener la fila de resultados.
        $bookRow = $PDOStmt->fetch();

        // Verificar si la fila es de tipo booleano (no se encontró el libro).
        if (is_bool($bookRow)) {
            return [];
        }

        // Retornar los detalles del libro.
        return $bookRow;
    }

    /**
     * Guarda la entrada de un libro en la base de datos.
     *
     * Realiza una operación de inserción si el ID del libro está vacío,
     * de lo contrario, realiza una operación de actualización.
     *
     * @param array $arrInputs Un array con los datos del libro a ser guardado.
     *   - 'bookId': El ID del libro (opcional, se usará para la actualización si está presente).
     *   - 'bookTitle': El título del libro.
     *   - 'bookGender': El género del libro.
     *   - 'bookCountry': El país de origen del libro.
     *   - 'bookYear': El año de publicación del libro.
     *   - 'bookPages': El número de páginas del libro.
     * @return string El ID del libro guardado o actualizado.
     */
    public function saveBookEntry(array $arrInputs): string
    {
        // Extraer los datos del array de entrada.
        $strBookId = $arrInputs['bookId'];                          // Id del libro.
        $strBookTitle = $arrInputs['bookTitle'];                    // Título del libro.
        $strBookGender = $arrInputs['bookGender'];                  // Género del libro.
        $strBookCountry = $arrInputs['bookCountry'];                // País del libro.
        $strBookYear = $arrInputs['bookYear'];                      // Año de publicación del libro.
        $strBookPages = $arrInputs['bookPages'];                    // Número de páginas del libro.

        // Verificar si el ID del libro está vacío.
        if (empty($strBookId)) {
            // Operación de inserción.
            $SQLQuery = 'INSERT INTO ' . $this->strTable . ' (TITULO, GENERO, PAIS, ANO, NUM_PAGINAS)'
                . ' VALUES (:strBookTitle, :strBookGender, :strBookCountry, :strBookYear, :strBookPages)';
            $PDOStmt = $this->PDOConnection->prepare($SQLQuery);

            // Vincular los parámetros con los valores proporcionados.
            $PDOStmt->bindParam(':strBookTitle', $strBookTitle);
            $PDOStmt->bindParam(':strBookGender', $strBookGender);
            $PDOStmt->bindParam(':strBookCountry', $strBookCountry);
            $PDOStmt->bindParam(':strBookYear', $strBookYear);
            $PDOStmt->bindParam(':strBookPages', $strBookPages);

            // Ejecutar la consulta SQL.
            $PDOStmt->execute();

            // Obtener el último ID insertado.
            $strBookId = $this->PDOConnection->lastInsertId();
        } else {
            // Operación de actualización.
            $SQLQuery = 'UPDATE ' . $this->strTable
                . ' SET TITULO = :strBookTitle,'
                . ' GENERO = :strBookGender,'
                . ' PAIS = :strBookCountry,'
                . ' ANO = :strBookYear,'
                . ' NUM_PAGINAS = :strBookPages'
                . ' WHERE ID_LIBRO = :strBookId';
            $PDOStmt = $this->PDOConnection->prepare($SQLQuery);

            // Vincular los parámetros con los valores proporcionados.
            $PDOStmt->bindParam(':strBookTitle', $strBookTitle);
            $PDOStmt->bindParam(':strBookGender', $strBookGender);
            $PDOStmt->bindParam(':strBookCountry', $strBookCountry);
            $PDOStmt->bindParam(':strBookYear', $strBookYear);
            $PDOStmt->bindParam(':strBookPages', $strBookPages);
            $PDOStmt->bindParam(':strBookId', $strBookId);

            // Ejecutar la consulta SQL.
            $PDOStmt->execute();
        }

        // Retornar el ID del libro guardado o actualizado.
        return $strBookId;
    }

    /**
     * Elimina un libro por su ID, incluyendo la eliminación de registros
     * en tablas relacionadas.
     *
     * @param string $strBookId El ID del libro a ser eliminado.
     */
    public function deleteBookById(string $strBookId): void
    {
        // Eliminar registros relacionados en la tabla ESCRIBEN.
        $this->deleteForeignKey($strBookId);

        // Consulta SQL para eliminar el libro por su ID.
        $SQLQuery = 'DELETE FROM ' . $this->strTable . ' WHERE ID_LIBRO = :strBookId';

        // Preparar la consulta SQL.
        $PDOStmt = $this->PDOConnection->prepare($SQLQuery);

        // Vincular el parámetro con el valor proporcionado.
        $PDOStmt->bindParam(':strBookId', $strBookId);

        // Ejecutar la consulta SQL.
        $PDOStmt->execute();
    }

    /**
     * Elimina registros en la tabla ESCRIBEN relacionados con el ID del
     * libro proporcionado.
     *
     * @param string $strBookId     El ID del libro para el cual se eliminarán
     *                              los registros en la tabla ESCRIBEN.
     */
    private function deleteForeignKey(string $strBookId): void
    {
        // Consulta SQL para eliminar registros en la tabla ESCRIBEN por el ID del libro.
        $SQLQuery = 'DELETE FROM ESCRIBEN WHERE ID_LIBRO = :strBookId';

        // Preparar la consulta SQL.
        $PDOStmt = $this->PDOConnection->prepare($SQLQuery);

        // Vincular el parámetro con el valor proporcionado.
        $PDOStmt->bindParam(':strBookId', $strBookId);

        // Ejecutar la consulta SQL.
        $PDOStmt->execute();
    }

    /**
     * Realiza una búsqueda de libros en la base de datos según la
     * consulta proporcionada.
     *
     * @param string $strSearchQuery    La cadena de búsqueda utilizada
     *                                  para buscar libros en varios campos.
     *
     * @return array                    Un array que contiene los resultados
     *                                  de la búsqueda de libros.
     */
    public function searchBooks(string $strSearchQuery): array
    {
        // Completar la cadena de búsqueda con comodines '%' al principio y al final.
        $strCompleteSearchQuery = '%' . $strSearchQuery . '%';

        // Consulta SQL para buscar libros en la base de datos.
        $SQLQuery = 'SELECT * FROM ' . $this->strTable
            . ' WHERE TITULO LIKE :strSearchQuery'
            . ' OR GENERO LIKE :strSearchQuery'
            . ' OR PAIS LIKE :strSearchQuery'
            . ' OR CAST(ANO AS CHAR) LIKE :strSearchQuery'
            . ' OR CAST(NUM_PAGINAS AS CHAR) LIKE :strSearchQuery';

        // Preparar la consulta SQL.
        $PDOStmt = $this->PDOConnection->prepare($SQLQuery);

        // Vincular el parámetro con el valor proporcionado.
        $PDOStmt->bindParam(':strSearchQuery', $strCompleteSearchQuery);

        // Ejecutar la consulta SQL.
        $PDOStmt->execute();

        return $PDOStmt->fetchAll(PDO::FETCH_ASSOC);
    }
}