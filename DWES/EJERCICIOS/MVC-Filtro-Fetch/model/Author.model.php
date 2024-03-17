<?php

/**
 * Clase encargada de comunicarse con la tabla AUTORES
 * de la base de datos.
 */
class Author
{
    private string $strTable;           // Almacena el nombre de la tabla.
    private PDO $PDOConnection;         // Conexión a la base de datos.

    /**
     * Constructor del modelo de autores.
     *
     * Inicializa el nombre de la tabla ('AUTORES') y establece una conexión PDO.
     *
     * @return void
     */
    public function __construct()
    {
        $this->strTable = 'AUTORES';                        // Se asocia el nombre de la tabla a utilizar.
        $this->PDOConnection = Database::createConn();      // Se genera una conexión a la base de datos.
    }

    /**
     * Obtiene los detalles de un autor por su ID.
     *
     * Realiza una consulta SQL para recuperar los detalles de un autor específico
     * identificado por su ID_PERSONA.
     *
     * @param string $strAuthorId   El ID del autor que se desea obtener.
     * @return array                Un array asociativo que contiene los detalles del
     *                               autor o un array vacío si no se encuentra.
     */
    public function getAuthorById(string $strAuthorId): array
    {
        // Query SQL para obtener los detalles del autor por su ID.
        $SQLQuery = 'SELECT * FROM ' . $this->strTable
            . ' WHERE ID_PERSONA = :strAuthorId';

        // Preparar la consulta SQL.
        $PDOStmt = $this->PDOConnection->prepare($SQLQuery);

        // Vincular el parámetro de ID_PERSONA y ejecutar la consulta SQL.
        $PDOStmt->bindParam(':strAuthorId', $strAuthorId);
        $PDOStmt->execute();

        // Obtener la fila de resultados.
        $authorRow = $PDOStmt->fetch();

        // Verificar si la fila es un booleano, en caso afirmativo, retornar un array vacío.
        if (is_bool($authorRow)) {
            return [];
        }

        return $authorRow;
    }

    /**
     * Guarda o actualiza la entrada de un autor en la base de datos.
     *
     * Realiza una operación de inserción o actualización en la tabla de
     * autores según la existencia del ID del autor.
     *
     * @param array $arrInputs  Un array asociativo que contiene los datos
     *                          del autor a guardar o actualizar.
     * @return string           El ID del autor que se ha guardado o actualizado.
     */
    public function saveAuthorEntry(array $arrInputs): string
    {
        // Extraer los datos del array de entrada.
        $strAuthorId = $arrInputs['authorId'];                      // Id del autor.
        $strAuthorFirstName = $arrInputs['authorFirstName'];        // Nombre del autor.
        $strAuthorLastName = $arrInputs['authorLastName'];          // Apellido del autor.
        $strAuthorBirthDate = $arrInputs['authorBirthDate'];        // Fecha de nacimiento del autor.
        $strAuthorCountry = $arrInputs['authorCountry'];            // País de origen del autor.
        $strAuthorBooks = $arrInputs['authorBooks'];                // Cantidad de libros publicados por el autor.

        // Verificar si el ID del autor está vacío para determinar si es una inserción o una actualización.
        if (empty($strAuthorId)) {
            // Query SQL para la inserción de un nuevo autor.
            $SQLQuery = 'INSERT INTO ' . $this->strTable
                . ' (NOMBRE, APELLIDO, FECHA_NACIMIENTO, PAIS_ORIGEN, LIBROS_PUBLICADOS)'
                . ' VALUES (:strAuthorFirstName, :strAuthorLastName, :strAuthorBirthDate, :strAuthorCountry, :strAuthorBooks)';
            $PDOStmt = $this->PDOConnection->prepare($SQLQuery);

            // Vincular los parámetros y ejecutar la consulta para la inserción.
            $PDOStmt->bindParam(':strAuthorFirstName', $strAuthorFirstName);
            $PDOStmt->bindParam(':strAuthorLastName', $strAuthorLastName);
            $PDOStmt->bindParam(':strAuthorBirthDate', $strAuthorBirthDate);
            $PDOStmt->bindParam(':strAuthorCountry', $strAuthorCountry);
            $PDOStmt->bindParam(':strAuthorBooks', $strAuthorBooks);
            $PDOStmt->execute();

            // Obtener el ID del autor insertado.
            $strAuthorId = $this->PDOConnection->lastInsertId();
        } else {
            // Query SQL para la actualización de un autor existente.
            $SQLQuery = 'UPDATE ' . $this->strTable
                . ' SET NOMBRE = :strAuthorFirstName,'
                . ' APELLIDO = :strAuthorLastName,'
                . ' FECHA_NACIMIENTO = :strAuthorBirthDate,'
                . ' PAIS_ORIGEN = :strAuthorCountry,'
                . ' LIBROS_PUBLICADOS = :strAuthorBooks'
                . ' WHERE ID_PERSONA = :strAuthorId';

            // Preparar la consulta.
            $PDOStmt = $this->PDOConnection->prepare($SQLQuery);

            // Vincular los parámetros y ejecutar la consulta para la actualización.
            $PDOStmt->bindParam(':strAuthorFirstName', $strAuthorFirstName);
            $PDOStmt->bindParam(':strAuthorLastName', $strAuthorLastName);
            $PDOStmt->bindParam(':strAuthorBirthDate', $strAuthorBirthDate);
            $PDOStmt->bindParam(':strAuthorCountry', $strAuthorCountry);
            $PDOStmt->bindParam(':strAuthorBooks', $strAuthorBooks);
            $PDOStmt->bindParam(':strAuthorId', $strAuthorId);
            $PDOStmt->execute();
        }

        return $strAuthorId;
    }

    /**
     * Elimina un autor por su ID de la base de datos.
     *
     * Realiza la eliminación de un autor y sus registros
     * relacionados antes de borrar la entrada principal.
     *
     * @param string $strAuthorId   El ID del autor que se desea eliminar.
     * @return void
     */
    public function deleteAuthorById(string $strAuthorId): void
    {
        // Eliminar registros relacionados (llamada a función separada).
        $this->deleteForeignKey($strAuthorId);

        // Query SQL para la eliminación del autor por su ID_PERSONA.
        $SQLQuery =
            'DELETE FROM ' . $this->strTable
            . ' WHERE ID_PERSONA = :strAuthorId';

        // Preparar la consulta SQL.
        $PDOStmt = $this->PDOConnection->prepare($SQLQuery);

        // Vincular el parámetro de ID_PERSONA y ejecutar la consulta SQL.
        $PDOStmt->bindParam(':strAuthorId', $strAuthorId);
        $PDOStmt->execute();
    }

    /**
     * Realiza una búsqueda de autores en la base de datos según un criterio de búsqueda.
     *
     * Busca autores cuyo nombre, apellido, fecha de nacimiento,país de origen o cantidad
     * de libros publicados coincidan parcialmente con el criterio de búsqueda proporcionado.
     *
     * @param string $strPage    La página de la que conseguir los campos.
     * @return array             Un array con los datos de los autores que coinciden
     *                           con el criterio de búsqueda.
     */
    public function searchAuthors(string $strPage): array
    {
        $arrSearchParams = $this->getSearchParams();

        $intRegisters = $_SESSION['numRegisters'] ?? DEFAULT_REGISTERS;
        $intLimit = ((int)$strPage - 1) * $intRegisters;

        // Consulta SQL para buscar libros en la base de datos.
        $SQLQuery = 'SELECT * FROM ' . $this->strTable
            . ' WHERE ID_PERSONA BETWEEN :strMinAuthorID AND :strMaxAuthorID'
            . ' AND NOMBRE LIKE :strAuthorFirstName'
            . ' AND APELLIDO LIKE :strAuthorLastName'
            . ' AND FECHA_NACIMIENTO BETWEEN :strMinAuthorDateOfBirth AND :strMaxAuthorDateOfBirth'
            . ' AND PAIS_ORIGEN LIKE :strAuthorCountry'
            . ' AND LIBROS_PUBLICADOS BETWEEN :strMinAuthorBooks AND :strMaxAuthorBooks'
            . ' ORDER BY APELLIDO, NOMBRE'
            . ' LIMIT ' . $intLimit . ', ' . $intRegisters;

        // Preparar la consulta SQL.
        $PDOStmt = $this->PDOConnection->prepare($SQLQuery);

        // Vincular el parámetro con el valor proporcionado.
        Author::bindSearchParams($PDOStmt, $arrSearchParams);

        // Ejecutar la consulta SQL.
        $PDOStmt->execute();

        return $PDOStmt->fetchAll(PDO::FETCH_ASSOC);
    }

    public function getTotalAuthorsBySearch(): int
    {
        $arrSearchParams = $this->getSearchParams();

        // Consulta SQL para buscar libros en la base de datos.
        $SQLQuery = 'SELECT COUNT(*) AS CANTIDAD FROM ' . $this->strTable
            . ' WHERE ID_PERSONA BETWEEN :strMinAuthorID AND :strMaxAuthorID'
            . ' AND NOMBRE LIKE :strAuthorFirstName'
            . ' AND APELLIDO LIKE :strAuthorLastName'
            . ' AND FECHA_NACIMIENTO BETWEEN :strMinAuthorDateOfBirth AND :strMaxAuthorDateOfBirth'
            . ' AND PAIS_ORIGEN LIKE :strAuthorCountry'
            . ' AND LIBROS_PUBLICADOS BETWEEN :strMinAuthorBooks AND :strMaxAuthorBooks'
            . ' ORDER BY APELLIDO, NOMBRE';

        // Preparar la consulta SQL.
        $PDOStmt = $this->PDOConnection->prepare($SQLQuery);

        // Vincular el parámetro con el valor proporcionado.
        Author::bindSearchParams($PDOStmt, $arrSearchParams);

        // Ejecutar la consulta SQL.
        $PDOStmt->execute();
        $totalAuthorsRow = $PDOStmt->fetch(PDO::FETCH_ASSOC);

        return $totalAuthorsRow['CANTIDAD'];
    }

    /**
     * Obtiene los parámetros de búsqueda para la búsqueda de autores.
     *
     * @return array Un array asociativo con los parámetros de búsqueda.
     */
    private function getSearchParams(): array
    {
        return [
            'minAuthorId' => empty($_SESSION['authorSearch']['minAuthorId'])
                ? $this->getMinParam('ID_PERSONA')
                : $_SESSION['authorSearch']['minAuthorId'],
            'maxAuthorId' => empty($_SESSION['authorSearch']['maxAuthorId'])
                ? $this->getMaxParam('ID_PERSONA')
                : $_SESSION['authorSearch']['maxAuthorId'],
            'authorFirstName' => '%' . $_SESSION['authorSearch']['authorFirstName'] . '%',
            'authorLastName' => '%' . $_SESSION['authorSearch']['authorLastName'] . '%',
            'minAuthorDateOfBirth' => empty($_SESSION['authorSearch']['minAuthorDateOfBirth'])
                ? $this->getMinParam('FECHA_NACIMIENTO')
                : $_SESSION['authorSearch']['minAuthorDateOfBirth'],
            'maxAuthorDateOfBirth' => empty($_SESSION['authorSearch']['maxAuthorDateOfBirth'])
                ? $this->getMaxParam('FECHA_NACIMIENTO')
                : $_SESSION['authorSearch']['maxAuthorDateOfBirth'],
            'authorCountry' => empty($_SESSION['authorSearch']['authorCountry'])
                ? '%%'
                : $_SESSION['authorSearch']['authorCountry'],
            'minAuthorBooks' => empty($_SESSION['authorSearch']['minAuthorBooks'])
                ? $this->getMinParam('LIBROS_PUBLICADOS')
                : $_SESSION['authorSearch']['minAuthorBooks'],
            'maxAuthorBooks' => empty($_SESSION['authorSearch']['maxAuthorBooks'])
                ? $this->getMaxParam('LIBROS_PUBLICADOS')
                : $_SESSION['authorSearch']['maxAuthorBooks'],
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
    private static function bindSearchParams(PDOStatement $PDOStmt, array $searchParams): void
    {
        $PDOStmt->bindParam(':strMinAuthorID', $searchParams['minAuthorId']);
        $PDOStmt->bindParam(':strMaxAuthorID', $searchParams['maxAuthorId']);
        $PDOStmt->bindParam(':strAuthorFirstName', $searchParams['authorFirstName']);
        $PDOStmt->bindParam(':strAuthorLastName', $searchParams['authorLastName']);
        $PDOStmt->bindParam(':strMinAuthorDateOfBirth', $searchParams['minAuthorDateOfBirth']);
        $PDOStmt->bindParam(':strMaxAuthorDateOfBirth', $searchParams['maxAuthorDateOfBirth']);
        $PDOStmt->bindParam(':strAuthorCountry', $searchParams['authorCountry']);
        $PDOStmt->bindParam(':strMinAuthorBooks', $searchParams['minAuthorBooks']);
        $PDOStmt->bindParam(':strMaxAuthorBooks', $searchParams['maxAuthorBooks']);
    }

    /**
     * Elimina registros relacionados en la tabla ESCRIBEN por el ID de un autor.
     *
     * Realiza la eliminación de registros en la tabla ESCRIBEN relacionados con
     * el ID_PERSONA del autor.
     *
     * @param string $strAuthorId   El ID del autor cuyos registros relacionados
     *                              se desean eliminar.
     * @return void
     */
    private function deleteForeignKey(string $strAuthorId): void
    {
        // Query SQL para la eliminación de registros relacionados en la tabla ESCRIBEN.
        $SQLQuery = 'DELETE FROM ESCRIBEN' . ' WHERE ID_PERSONA = :strAuthorId';

        // Preparar la consulta SQL.
        $PDOStmt = $this->PDOConnection->prepare($SQLQuery);

        // Vincular el parámetro de ID_PERSONA y ejecutar la consulta SQL.
        $PDOStmt->bindParam(':strAuthorId', $strAuthorId);
        $PDOStmt->execute();
    }


    /**
     * Obtiene un array de valores distintos para una columna específica desde la base de datos.
     *
     * @param string $strColumn El nombre de la columna para la cual se obtendrán valores distintos.
     *
     * @return array Un array que contiene valores distintos de la columna especificada.
     */
    public function getDistintColumn(string $strColumn): array
    {
        // Consulta SQL para buscar libros en la base de datos.
        $SQLQuery = 'SELECT DISTINCT ' . $strColumn . ' FROM ' . $this->strTable . ' ORDER BY ' . $strColumn;

        // Preparar la consulta SQL.
        $PDOStmt = $this->PDOConnection->prepare($SQLQuery);

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
            $strElementLowerCase = strtolower($datum); // String que pasa a minúsculas el string del parámetro.

            foreach ($forbiddenKeywords as $keyword) {
                $strElementLowerCase = str_replace($keyword, '', $strElementLowerCase);
            }

            $arrReturn[$index] = $strElementLowerCase;
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
     * Verifica si una cadena tiene el formato de fecha esperado (YYYY-MM-DD).
     *
     * @param array $arrDates La cadena que se va a verificar.
     *
     * @return bool Devuelve true si la cadena tiene el formato de fecha esperado, de lo contrario, false.
     */
    public static function checkDate(array $arrDates): bool
    {
        foreach ($arrDates as $date) {
            if (!empty($date)) {
                $arrDate = explode('-', $date);

                // Verifica la cantidad de elementos en el arreglo
                if (count($arrDate) !== 3) {
                    return false;
                }

                [$strYear, $strMonth, $strDay] = $arrDate;

                // Verifica el formato y longitud del año
                if (!is_numeric($strYear)
                    || strlen($strYear) !== 4
                    || (int)$strYear === 0) {
                    return false;
                }

                // Verifica el formato y longitud del mes
                if (!is_numeric($strMonth)
                    || !checkdate((int)$strMonth, 1, 1)
                    || strlen($strMonth) !== 2) {
                    return false;
                }

                // Verifica el formato y longitud del día
                if (!is_numeric($strDay)
                    || !checkdate((int)$strMonth, (int)$strDay, (int)$strYear)
                    || strlen($strDay) !== 2) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Verifica si los campos en el array de datos no están vacíos, excluyendo el primer y último elemento.
     *
     * @param array $arrData El array de datos a verificar.
     *
     * @return bool True si no hay campos vacíos, False en caso contrario.
     */
    public static function checkEmptyFields(array $arrData): bool {
        for ($intCont = 1; $intCont < count($arrData) - 1; $intCont++) {
            if (empty($arrData[$intCont])) {
                return false;
            }
        }

        return true;
    }

    /**
     * Obtiene la lista de autores desde la base de datos.
     *
     * @return array Un array asociativo con la información de los autores (ID_PERSONA, NOMBRE, APELLIDO).
     * @throws \PDOException Si ocurre un error durante la operación en la base de datos.
     */
    public function getAuthors(): array {
        $arrSearchParams = (new Book())->getSearchParams();

        // Consulta SQL para buscar libros en la base de datos.
        $SQLQuery = 'SELECT DISTINCT A.ID_PERSONA, A.NOMBRE, A.APELLIDO'
            . ' FROM ' . $this->strTable . ' AS A'
            . ' INNER JOIN ESCRIBEN AS E ON A.ID_PERSONA = E.ID_PERSONA'
            . ' INNER JOIN LIBROS AS L ON L.ID_LIBRO = E.ID_LIBRO'
            . ' WHERE L.ID_LIBRO BETWEEN :strMinBookID AND :strMaxBookID'
            . ' AND L.TITULO LIKE :strBookTitle'
            . ' AND L.GENERO LIKE :strBookGenre'
            . ' AND L.PAIS LIKE :strBookCountry'
            . ' AND L.ANO BETWEEN :strMinBookYear AND :strMaxBookYear'
            . ' AND L.NUM_PAGINAS BETWEEN :strMinBookPages AND :strMaxBookPages'
            . ' ORDER BY APELLIDO, NOMBRE';

        // Preparar la consulta SQL.
        $PDOStmt = $this->PDOConnection->prepare($SQLQuery);

        Book::bindSearchParams($PDOStmt, $arrSearchParams);

        // Ejecutar la consulta SQL.
        $PDOStmt->execute();

        return $PDOStmt->fetchAll(PDO::FETCH_ASSOC);
    }

    public function getAuthorsByBookId(string $strBookId): array
    {
        $SQLQuery = 'SELECT A.ID_PERSONA, CONCAT(A.NOMBRE, " ", A.APELLIDO) AS NOMBRE_COMPLETO'
            . ' FROM ' . $this->strTable . ' AS A'
            . ' INNER JOIN ESCRIBEN AS E ON A.ID_PERSONA = E.ID_PERSONA'
            . ' WHERE E.ID_LIBRO = :strBookId';

        $PDOStmt = $this->PDOConnection->prepare($SQLQuery);

        $PDOStmt->bindParam('strBookId', $strBookId);

        $PDOStmt->execute();

        return $PDOStmt->fetchAll(PDO::FETCH_ASSOC);
    }
}