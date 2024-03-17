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
        $SQLQuery = 'SELECT L.ID_LIBRO, L.TITULO, L.GENERO, L.PAIS, L.ANO, L.NUM_PAGINAS, A.ID_PERSONA'
        . ' FROM LIBROS AS L'
        . ' INNER JOIN ESCRIBEN AS E ON L.ID_LIBRO = E.ID_LIBRO'
        . ' INNER JOIN AUTORES AS A ON A.ID_PERSONA = E.ID_PERSONA'
        . ' WHERE L.ID_LIBRO = :strBookId';

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
        $strAuthorId = $arrInputs['authorId'];                      // Id original del autor.
        $strBookTitle = $arrInputs['bookTitle'];                    // Título del libro.
        $strBookGender = $arrInputs['bookGender'];                  // Género del libro.
        $strBookCountry = $arrInputs['bookCountry'];                // País del libro.
        $strBookYear = $arrInputs['bookYear'];                      // Año de publicación del libro.
        $strBookPages = $arrInputs['bookPages'];                    // Número de páginas del libro.
        $strNewAuthor = $arrInputs['bookAuthor'];                   // Id del nuevo autor.

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
            $this->insertForeignKey($strBookId, $strNewAuthor);
        } else {
            $this->updateForeignKey($strBookId, $strAuthorId, $strNewAuthor);
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
     * Inserta una relación de clave foránea entre un libro y un autor en la tabla ESCRIBEN.
     *
     * @param string $strBookId El ID del libro.
     * @param string $strAuthorId El ID del autor.
     *
     * @return void
     * @throws \PDOException Si ocurre un error durante la operación en la base de datos.
     */
    private function insertForeignKey(string $strBookId, string $strAuthorId): void
    {
        // Consulta SQL para actualizar una relación de clave foránea.
        $SQLQuery = 'INSERT INTO ESCRIBEN (ID_LIBRO, ID_PERSONA)'
            . ' VALUES (:strBookId, :strAuthorId)';

        $PDOStmt = $this->PDOConnection->prepare($SQLQuery);

        // Vincular el parámetro con el valor proporcionado.
        $PDOStmt->bindParam(':strBookId', $strBookId);
        $PDOStmt->bindParam(':strAuthorId', $strAuthorId);

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
     * Actualiza una relación de clave foránea entre un libro y un autor en la tabla ESCRIBEN.
     *
     * @param string $strBookId         El ID del libro.
     * @param string $strAuthorPrevId   El ID del autor antes de la actualización.
     * @param string $strAuthorNewId    El nuevo ID del autor después de la actualización.
     *
     * @return void
     * @throws \PDOException Si ocurre un error durante la operación en la base de datos.
     */
    private function updateForeignKey(string $strBookId,
                                      string $strAuthorPrevId,
                                      string $strAuthorNewId): void
    {
        // Consulta SQL para actualizar una relación de clave foránea.
        $SQLQuery = 'UPDATE ESCRIBEN'
            . ' SET ID_LIBRO = :strBookID, ID_PERSONA = :strAuthorID'
            . ' WHERE ID_PERSONA = :strAuthorPrevID'
            . ' AND ID_LIBRO = :strBookID';

        $PDOStmt = $this->PDOConnection->prepare($SQLQuery);

        // Vincular el parámetro con el valor proporcionado.
        $PDOStmt->bindParam(':strBookID', $strBookId);
        $PDOStmt->bindParam(':strAuthorID', $strAuthorNewId);
        $PDOStmt->bindParam(':strAuthorPrevID', $strAuthorPrevId);

        // Ejecutar la consulta SQL.
        $PDOStmt->execute();
    }

    /**
     * Obtiene el número total de libros según los parámetros de búsqueda.
     *
     * @return int El número total de libros que coinciden con los criterios de búsqueda.
     */
    public function getTotalBooksBySearch(): int
    {
        $arrSearchParams = $this->getSearchParams();
        $whereAuthors = $arrSearchParams['bookAuthor'];

        // Consulta SQL para buscar libros en la base de datos.
        $SQLQuery = 'SELECT COUNT(DISTINCT L.ID_LIBRO) AS CANTIDAD'
            . ' FROM LIBROS AS L'
            . ' INNER JOIN ESCRIBEN AS E ON L.ID_LIBRO = E.ID_LIBRO'
            . ' INNER JOIN AUTORES AS A ON A.ID_PERSONA = E.ID_PERSONA'
            . ' WHERE L.ID_LIBRO BETWEEN :strMinBookID AND :strMaxBookID'
            . ' AND L.TITULO LIKE :strBookTitle'
            . ' AND L.GENERO LIKE :strBookGenre'
            . ' AND L.PAIS LIKE :strBookCountry'
            . ' AND L.ANO BETWEEN :strMinBookYear AND :strMaxBookYear'
            . ' AND L.NUM_PAGINAS BETWEEN :strMinBookPages AND :strMaxBookPages'
            . $whereAuthors;

        // Preparar la consulta SQL.
        $PDOStmt = $this->PDOConnection->prepare($SQLQuery);

        // Vincular el parámetro con el valor proporcionado.
        Book::bindSearchParams($PDOStmt, $arrSearchParams);

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
    public function searchBooks(string $strPage): array
    {
        $arrSearchParams = $this->getSearchParams();
        $intRegisters = $_SESSION['numRegisters'] ?? DEFAULT_REGISTERS;
        $intLimit = ((int)$strPage - 1) * $intRegisters;

        $strWhereAuthors = $arrSearchParams['bookAuthor'];

        // Consulta SQL para buscar libros en la base de datos.
        $SQLQuery =
            'SELECT DISTINCT L.ID_LIBRO, L.TITULO, L.GENERO, L.PAIS, L.ANO, L.NUM_PAGINAS'
            . ' FROM ' . $this->strTable . ' AS L'
            . ' INNER JOIN ESCRIBEN AS E ON E.ID_LIBRO = L.ID_LIBRO'
            . ' INNER JOIN AUTORES AS A ON A.ID_PERSONA = E.ID_PERSONA'
            . ' WHERE L.ID_LIBRO BETWEEN :strMinBookID AND :strMaxBookID'
            . ' AND L.TITULO LIKE :strBookTitle'
            . ' AND L.GENERO LIKE :strBookGenre'
            . ' AND L.PAIS LIKE :strBookCountry'
            . ' AND L.ANO BETWEEN :strMinBookYear AND :strMaxBookYear'
            . ' AND L.NUM_PAGINAS BETWEEN :strMinBookPages AND :strMaxBookPages'
            . $strWhereAuthors
            . ' ORDER BY TITULO'
            . ' LIMIT ' . $intLimit . ', ' . $intRegisters;

        // Preparar la consulta SQL.
        $PDOStmt = $this->PDOConnection->prepare($SQLQuery);

        // Vincular el parámetro con el valor proporcionado.
        Book::bindSearchParams($PDOStmt, $arrSearchParams);

        // Ejecutar la consulta SQL.
        $PDOStmt->execute();
        $arrReturn = [];

        while ($bookRow = $PDOStmt->fetch(PDO::FETCH_ASSOC)) {
            $authors = $this->getAuthors($bookRow['ID_LIBRO']);

            foreach ($authors as $author) {
                $bookRow['ID_PERSONA'][] = $author['ID_PERSONA'];
                $bookRow['NOMBRE_COMPLETO'][] = $author['NOMBRE_COMPLETO'];
            }

            $arrReturn[] = $bookRow;
        }

        return $arrReturn;
    }

    private function getAuthors(string $bookId): array
    {
        return (new Author())->getAuthorsByBookId($bookId);
    }

    /**
     * Obtiene los parámetros de búsqueda para la búsqueda de libros.
     *
     * @return array Un array asociativo con los parámetros de búsqueda.
     */
    public function getSearchParams(): array
    {
        return [
            'minBookId' => empty($_SESSION['bookSearch']['minBookId'])
                ? $this->getMinParam('ID_LIBRO')
                : $_SESSION['bookSearch']['minBookId'],
            'maxBookId' => empty($_SESSION['bookSearch']['maxBookId'])
                ? $this->getMaxParam('ID_LIBRO')
                : $_SESSION['bookSearch']['maxBookId'],
            'bookTitle' => empty($_SESSION['bookSearch']['maxBookId'])
                ? '%%'
                : '%' . $_SESSION['bookSearch']['bookTitle'] . '%',
            'bookGenre' => empty($_SESSION['bookSearch']['bookGenre'])
                ? '%%'
                : $_SESSION['bookSearch']['bookGenre'],
            'bookCountry' => empty($_SESSION['bookSearch']['bookCountry'])
                ? '%%'
                : $_SESSION['bookSearch']['bookCountry'],
            'minBookYear' => empty($_SESSION['bookSearch']['minBookYear'])
                ? $this->getMinParam('ANO')
                : $_SESSION['bookSearch']['minBookYear'],
            'maxBookYear' => empty($_SESSION['bookSearch']['maxBookYear'])
                ? $this->getMaxParam('ANO')
                : $_SESSION['bookSearch']['maxBookYear'],
            'minBookPages' => empty($_SESSION['bookSearch']['minBookPage'])
                ? $this->getMinParam('NUM_PAGINAS')
                : $_SESSION['bookSearch']['minBookPage'],
            'maxBookPages' => empty($_SESSION['bookSearch']['maxBookPage'])
                ? $this->getMaxParam('NUM_PAGINAS')
                : $_SESSION['bookSearch']['maxBookPage'],
            'bookAuthor' => empty($_SESSION['bookSearch']['bookAuthor'])
                ? ' AND A.ID_PERSONA LIKE \'%%\''
                : $this->getWhereAuthors($_SESSION['bookSearch']['bookAuthor'])
        ];
    }

    /**
     * Vincula los parámetros de búsqueda a los marcadores de posición en una consulta preparada.
     *
     * @param PDOStatement $PDOStmt      La declaración preparada a la que se vincularán los parámetros.
     * @param array        $searchParams Un array asociativo con los parámetros de búsqueda.
     *
     * @return void
     */
    public static function bindSearchParams(PDOStatement $PDOStmt, array $searchParams): void
    {
        $PDOStmt->bindParam(':strMinBookID', $searchParams['minBookId']);
        $PDOStmt->bindParam(':strMaxBookID', $searchParams['maxBookId']);
        $PDOStmt->bindParam(':strBookTitle', $searchParams['bookTitle']);
        $PDOStmt->bindParam(':strBookGenre', $searchParams['bookGenre']);
        $PDOStmt->bindParam(':strBookCountry', $searchParams['bookCountry']);
        $PDOStmt->bindParam(':strMinBookYear', $searchParams['minBookYear']);
        $PDOStmt->bindParam(':strMaxBookYear', $searchParams['maxBookYear']);
        $PDOStmt->bindParam(':strMinBookPages', $searchParams['minBookPages']);
        $PDOStmt->bindParam(':strMaxBookPages', $searchParams['maxBookPages']);
    }

    /**
     * Obtiene un array de valores distintos para una columna específica desde la base de datos.
     *
     * @param string $strColumn El nombre de la columna para la cual se obtendrán valores distintos.
     *
     * @return array Un array que contiene valores distintos de la columna especificada.
     */
    public function getDistinctColumn(string $strColumn): array
    {
        $arrSearchParams = $this->getSearchParams();

        $strWhereAuthors = $arrSearchParams['bookAuthor'];

        // Consulta SQL para buscar libros en la base de datos.
        $SQLQuery = 'SELECT DISTINCT ' . $strColumn . ' FROM ' . $this->strTable . ' AS L '
            . ' INNER JOIN ESCRIBEN AS E ON E.ID_LIBRO = L.ID_LIBRO'
            . ' INNER JOIN AUTORES AS A ON A.ID_PERSONA = E.ID_PERSONA'
            . ' WHERE L.ID_LIBRO BETWEEN :strMinBookID AND :strMaxBookID'
            . ' AND L.TITULO LIKE :strBookTitle'
            . ' AND L.GENERO LIKE :strBookGenre'
            . ' AND L.PAIS LIKE :strBookCountry'
            . ' AND L.ANO BETWEEN :strMinBookYear AND :strMaxBookYear'
            . ' AND L.NUM_PAGINAS BETWEEN :strMinBookPages AND :strMaxBookPages'
            . $strWhereAuthors
            . ' ORDER BY ' . $strColumn;

        // Preparar la consulta SQL.
        $PDOStmt = $this->PDOConnection->prepare($SQLQuery);

        Book::bindSearchParams($PDOStmt, $arrSearchParams);

        // Ejecutar la consulta SQL.
        $PDOStmt->execute();

        return $PDOStmt->fetchAll(PDO::FETCH_ASSOC);
    }

    /**
     * Obtiene el valor mínimo para un parámetro específico desde la base de datos.
     *
     * @param string $strParam El nombre del parámetro para el cual se obtendrá el valor mínimo.
     *
     * @return string El valor mínimo del parámetro.
     */
    private function getMinParam(string $strParam): string {
        // Consulta SQL para buscar libros en la base de datos.
        $SQLQuery = 'SELECT MIN(' . $strParam . ') AS MIN FROM ' . $this->strTable;

        // Preparar la consulta SQL.
        $PDOStmt = $this->PDOConnection->prepare($SQLQuery);

        // Ejecutar la consulta SQL.
        $PDOStmt->execute();

        $minRow = $PDOStmt->fetch(PDO::FETCH_ASSOC);

        return $minRow['MIN'];
    }

    /**
     * Obtiene el valor máximo para un parámetro específico desde la base de datos.
     *
     * @param string $strParam El nombre del parámetro para el cual se obtendrá el valor máximo.
     *
     * @return string El valor máximo del parámetro.
     */
    private function getMaxParam(string $strParam): string {
        // Consulta SQL para buscar libros en la base de datos.
        $SQLQuery = 'SELECT MAX(' . $strParam . ') AS MAX FROM ' . $this->strTable;

        // Preparar la consulta SQL.
        $PDOStmt = $this->PDOConnection->prepare($SQLQuery);

        // Ejecutar la consulta SQL.
        $PDOStmt->execute();

        $maxRow = $PDOStmt->fetch(PDO::FETCH_ASSOC);

        return $maxRow['MAX'];
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
            if (!is_array($datum)) {
                $strElementLowerCase = strtolower($datum); // String que pasa a minúsculas el string del parámetro.

                foreach ($forbiddenKeywords as $keyword) {
                    $strElementLowerCase = str_replace($keyword, '', $strElementLowerCase);
                }

                $arrReturn[$index] = $strElementLowerCase;
            } else {
                foreach ($datum as $arrIndex => $realDatum) {
                    $strElementLowerCase = strtolower($realDatum); // String que pasa a minúsculas el string del parámetro.

                    foreach ($forbiddenKeywords as $keyword) {
                        $strElementLowerCase = str_replace($keyword, '', $strElementLowerCase);
                    }

                    $arrReturn[$index][$arrIndex] = $strElementLowerCase;
                }
            }
        }

        return $arrReturn;
    }

    /**
     * Verifica si todos los elementos en el array son numéricos.
     *
     * @param array $arrData El array de datos a verificar.
     *
     * @return bool True si todos los elementos son numéricos, False en caso contrario.
     */
    public static function checkNumeric(array $arrData): bool
    {
        foreach ($arrData as $datum) {
            if (!empty($datum) and !is_numeric($datum)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Verifica si los campos en el array de datos no están vacíos.
     *
     * @param array $arrData El array de datos a verificar.
     *
     * @return bool True si no hay campos vacíos, False en caso contrario.
     */
    public static function checkEmptyFields(array $arrData): bool {
        $arrData = array_slice($arrData, 2);
        $arrDataFields = array_values($arrData);

        foreach ($arrDataFields as $datum) {
            if (empty($datum)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Obtiene la cláusula WHERE para la condición de autores en una consulta SQL.
     *
     * @param array $arrData El array de IDs de autores.
     *
     * @return string La cláusula WHERE generada para los IDs de autores.
     */
    private static function getWhereAuthors(array $arrData): string
    {
        $SQLQuery = ' AND (';

        for ($intCont = 0; $intCont < count($arrData); $intCont++) {
            $SQLQuery .= 'A.ID_PERSONA = ' . $arrData[$intCont];

            if ($intCont !== count($arrData) - 1) {
                $SQLQuery .= ' AND ';
            }
        }

        $SQLQuery .= ')';

        return $SQLQuery;
    }
}