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
     * Obtiene el total de autores en la tabla.
     *
     * Ejecuta una consulta SQL para contar el número total de autores en la tabla.
     *
     * @return int La cantidad total de autores.
     */
    public function getTotalAuthors(): int
    {
        // Query SQL para contar el número total de autores.
        $SQLQuery = 'SELECT COUNT(ID_PERSONA) AS CANTIDAD FROM ' . $this->strTable;

        // Preparar y ejecutar la consulta SQL.
        $PDOStmt = $this->PDOConnection->prepare($SQLQuery);
        $PDOStmt->execute();

        // Obtener la fila de resultados.
        $counterAuthorsRow = $PDOStmt->fetch();

        return $counterAuthorsRow['CANTIDAD'];
    }

    /**
     * Obtiene un conjunto de autores paginados.
     *
     * Realiza una consulta SQL para recuperar un conjunto de autores, limitado por
     * la paginación ordenados por el identificador de persona (ID_PERSONA).
     *
     * @param string $strPage   Número de la página actual.
     * @return array            Un array asociativo que contiene los datos de los
     *                          autores recuperados.
     */
    public function getAuthors(string $strPage): array
    {
        // Obtener el número de registros por página desde la sesión o usar el valor predeterminado.
        $intNumRegisters = $_SESSION['numRegisters'] ?? DEFAULT_REGISTERS;

        // Calcular el límite de la consulta para la paginación.
        $intLimit = ((int)$strPage - 1) * $intNumRegisters;

        // Query SQL para obtener el conjunto de autores paginado.
        $SQLQuery = 'SELECT * FROM ' . $this->strTable
            . ' ORDER BY APELLIDO'
            . ' LIMIT ' . $intLimit . ', ' . $intNumRegisters;

        // Preparar y ejecutar la consulta SQL.
        $PDOStmt = $this->PDOConnection->prepare($SQLQuery);
        $PDOStmt->execute();

        return $PDOStmt->fetchAll(PDO::FETCH_ASSOC);
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
        $SQLQuery = 'DELETE FROM ' . $this->strTable . ' WHERE ID_PERSONA = :strAuthorId';

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
     * @param string $strSearchQuery    El criterio de búsqueda para encontrar autores.
     * @return array                    Un array con los datos de los autores que coinciden
     *                                  con el criterio de búsqueda.
     */
    public function searchAuthors(string $strSearchQuery): array
    {
        // Añadir caracteres de comodín para la búsqueda parcial.
        $strCompleteSearchQuery = '%' . $strSearchQuery . '%';

        // Query SQL para la búsqueda de autores basada en el criterio proporcionado.
        $SQLQuery = 'SELECT * FROM ' . $this->strTable
            . ' WHERE NOMBRE LIKE :strSearchQuery'
            . ' OR APELLIDO LIKE :strSearchQuery'
            . ' OR CAST(FECHA_NACIMIENTO AS CHAR) LIKE :strSearchQuery'
            . ' OR PAIS_ORIGEN LIKE :strSearchQuery'
            . ' OR CAST(LIBROS_PUBLICADOS AS CHAR) LIKE :strSearchQuery';

        // Preparar la consulta SQL.
        $PDOStmt = $this->PDOConnection->prepare($SQLQuery);

        // Vincular el parámetro de búsqueda y ejecutar la consulta SQL.
        $PDOStmt->bindParam(':strSearchQuery', $strCompleteSearchQuery);

        // Retornar los resultados de la búsqueda.
        $PDOStmt->execute();

        return $PDOStmt->fetchAll(PDO::FETCH_ASSOC);
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
        $SQLQuery = 'DELETE FROM ESCRIBEN WHERE ID_PERSONA = :strAuthorId';

        // Preparar la consulta SQL.
        $PDOStmt = $this->PDOConnection->prepare($SQLQuery);

        // Vincular el parámetro de ID_PERSONA y ejecutar la consulta SQL.
        $PDOStmt->bindParam(':strAuthorId', $strAuthorId);
        $PDOStmt->execute();
    }
}