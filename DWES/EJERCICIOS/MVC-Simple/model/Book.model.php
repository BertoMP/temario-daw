<?php

class Book
{
    private string $strTable; // Atributo que almacenará la tabla a la que hacer consultas.
    private PDO $PDOConnection; // Atributo que almacenará la conexión a la base de datos.

    public function __construct()
    {
        $this->strTable = 'LIBROS'; // Nombre de la tabla asociada.
        $this->PDOConnection = Database::createConn(); // Conexión a la base de datos.
    }

    // FUNCIÓN DE BÚSQUEDA EN LA BASE DE DATOS A PARTIR DEL ARRAY DE DATOS QUE RECIBE POR PARÁMETRO
    public function searchBooks(array $arrPOST): array
    {
        // Inicialización en variables de los valores del array.
        // Vamos a utilizar el siguiente array como ejemplo:
        //      [minBookId => 50,
        //       maxBookID => '',
        //       bookTitle => 'cronica',
        //       bookGenre => '',
        //       bookCountry => 'usa',
        //       minBookYear => '',
        //       maxBookYear => 2000,
        //       minBookPage => '',
        //       maxBookPage => '']

        // En mínimos y máximos para evitar problemas con la base de datos al intentar buscar entre valores vacíos, es
        // conveniente usar funciones de consulta que nos devuelvan el valor mínimo o máximo del campo solicitado.

        // minBookId => Tiene valor en nuestro ejemplo por lo que se seteará ese valor. Valor: 50.
        $minBookId = empty($arrPOST['minBookId']) ? $this->getMinParam('ID_LIBRO') : $arrPOST['minBookId'];

        // maxBookId => No tiene valor en nuestro ejemplo por lo que se llamará a la función getMaxParam para solicitar
        // el ID_LIBRO más alto, supongamos que nos devuelve un 120. Valor: 120.
        $maxBookId = empty($arrPOST['maxBookId']) ? $this->getMaxParam('ID_LIBRO') : $arrPOST['maxBookId'];

        // bookTitle => Tiene valor en nuestro ejemplo y le añadimos los % de inicio y fin para hacer búsquedas
        // parciales con LIKE, quedando el valor así: '%cronica%'. Valor: '%cronica%'.
        $bookTitle = '%' . $arrPOST['bookTitle'] . '%';

        // bookGenre => No tiene en valor en nuestro ejemplo, por lo que simplemente se guardarán los %, significando
        // esto que cualquier género será válido en nuestra consulta. Valor '%%'.
        $bookGenre = empty($arrPOST['bookGenre']) ? '%%' : $arrPOST['bookGenre'];

        // bookCountry => Tiene valor en nuestro ejemplo, por lo que como nos viene de un desplegable que hemos
        // creado con valores de nuestra tabla asociamos el valor directamente. Valor: 'usa'.
        $bookCountry = empty($arrPOST['bookCountry']) ? '%%' : $arrPOST['bookCountry'];

        // minBookYear => No tiene valor en nuestro ejemplo, por lo que llamamos a la función getMinParam para
        // solicitar el mínimo año posible, supongamos que por ejemplo nos devuelve 1800. Valor: 1800.
        $minBookYear = empty($arrPOST['minBookYear']) ? $this->getMinParam('ANO') : $arrPOST['minBookYear'];

        // maxBookYear => Tiene valor en nuestro ejemplo, por lo que asociamos ese valor. Valor: 2000.
        $maxBookYear = empty($arrPOST['maxBookYear']) ? $this->getMaxParam('ANO') : $arrPOST['maxBookYear'];

        // minBookPage => No tiene valor en nuestro ejemplo, por lo que se llamará a la función getMinParam para
        // solicitar el mínimo de páginas posibles, supongo que nos devuelve el número 200. Valor: 200.
        $minBookPages = empty($arrPOST['minBookPage']) ? $this->getMinParam('NUM_PAGINAS') : $arrPOST['minBookPage'];

        // maxBookPage => No tiene valor en nuestro ejemplo, por lo que se llamará a la función getMaxParam para
        // solicitar el máximo de páginas posibles, supongo que nos devuelve el número 1276. Valor: 1276.
        $maxBookPages = empty($arrPOST['maxBookPage']) ? $this->getMaxParam('NUM_PAGINAS') : $arrPOST['maxBookPage'];

        // Construimos la consulta.
        $SQLQuery = 'SELECT * FROM ' . $this->strTable
            . ' WHERE ID_LIBRO BETWEEN :strMinBookID AND :strMaxBookID'
            . ' AND TITULO LIKE :strBookTitle'
            . ' AND GENERO LIKE :strBookGenre'
            . ' AND PAIS LIKE :strBookCountry'
            . ' AND ANO BETWEEN :strMinBookYear AND :strMaxBookYear'
            . ' AND NUM_PAGINAS BETWEEN :strMinBookPages AND :strMaxBookPages'
            . ' ORDER BY TITULO';

        // Preparamos la conexión con la consulta.
        $PDOStmt = $this->PDOConnection->prepare($SQLQuery);

        // Asociamos los valores.
        $PDOStmt->bindParam(':strMinBookID', $minBookId);
        $PDOStmt->bindParam(':strMaxBookID', $maxBookId);
        $PDOStmt->bindParam(':strBookTitle', $bookTitle);
        $PDOStmt->bindParam(':strBookGenre', $bookGenre);
        $PDOStmt->bindParam(':strBookCountry', $bookCountry);
        $PDOStmt->bindParam(':strMinBookYear', $minBookYear);
        $PDOStmt->bindParam(':strMaxBookYear', $maxBookYear);
        $PDOStmt->bindParam(':strMinBookPages', $minBookPages);
        $PDOStmt->bindParam(':strMaxBookPages', $maxBookPages);

        // Una vez terminados todos los binds nos quedaría esta consulta:
        // SELECT * FROM LIBROS
        //  WHERE ID_LIBRO BETWEEN 50 AND 120
        //      AND TITULO LIKE '%cronica%'
        //      AND GENERO LIKE '%%'
        //      AND PAIS LIKE 'usa'
        //      AND ANO BETWEEN 1800 AND 2000
        //      AND NUM_PAGINAS BETWEEN 200 AND 1276
        //  ORDER BY TITULO;

        // Ejecutamos la consulta.
        $PDOStmt->execute();

        // Devolvemos la consulta en un array de array en el que cada uno de los índices es uno de los registros de
        // la tabla que concuerdan con la consulta realizada, además cada uno de estos índices será a su vez un array
        // asociativo que asocia los nombres de la tabla con el valor del registro correspondiente.
        // Por ejemplo:
        // [
        //  [ID_LIBRO => 50,
        //   TITULO => 'Una crónica anunciada',
        //   GENERO => 'Misterio',
        //   PAIS => 'USA',
        //   ANO => 1976,
        //   NUM_PAGINAS => 672],
        //
        //  [ID_LIBRO => 75,
        //   TITULO => 'Crónica del caso de ayer',
        //   GENERO => 'Novela negra',
        //   PAIS => 'USA'
        //   ANO => 2000,
        //   NUM_PAGINAS => 754],
        //  ... Otros posibles registros que concuerden con la consulta.
        //]

        $arrReturn = $PDOStmt->fetchAll(PDO::FETCH_ASSOC);
        return $arrReturn;
    }

    // FUNCIÓN ENCARGADA DE DEVOLVER LOS REGISTROS DIFERENTES DE UNA COLUMNA ESPECÍFICA DE LA TABLA
    // La columna se recibe por parámetro.
    public function getDistinctColumn(string $strColumn): array
    {
        // Construimos la consulta SQL.
        // Por ejemplo, SELECT DISTINCT GENERO FROM LIBROS ORDER BY GENERO.
        $SQLQuery = 'SELECT DISTINCT ' . $strColumn . ' FROM ' . $this->strTable . ' ORDER BY ' . $strColumn;

        // Preparamos la conexión y ejecutamos la consulta.
        $PDOStmt = $this->PDOConnection->prepare($SQLQuery);
        $PDOStmt->execute();

        // Se devuelve un array asociativo del siguiente estilo:
        // [[GENERO => AVENTURA], [GENERO => COMEDIA], [GENERO => FICCIÓN]...]
        return $PDOStmt->fetchAll(PDO::FETCH_ASSOC);
    }

    // FUNCIÓN ENCARGADA DE DEVOLVER EL VALOR MÍNIMO DE UNA COLUMNA DE LA TABLA
    private function getMinParam(string $strParam): string {
        // Construimos la consulta SQL.
        // Por ejemplo, SELECT MIN(ANO) AS MIN FROM LIBROS.
        $SQLQuery = 'SELECT MIN(' . $strParam . ') AS MIN FROM ' . $this->strTable;

        // Preparamos la conexión y ejecutamos la consulta.
        $PDOStmt = $this->PDOConnection->prepare($SQLQuery);
        $PDOStmt->execute();

        // Guardamos la fila en una variable.
        // Esto genera un array asociativo como [MIN => 1820].
        $minRow = $PDOStmt->fetch(PDO::FETCH_ASSOC);

        // Devolvemos el valor de MIN de nuestro array asociativo (1820).
        return $minRow['MIN'];
    }

    // FUNCIÓN ENCARGADA DE DEVOLVER EL VALOR MÁXIMO DE UNA COLUMNA DE LA TABLA
    private function getMaxParam(string $strParam): string {
        // Construimos la consulta SQL.
        // Por ejemplo, SELECT MAX(ANO) AS MAX FROM LIBROS.
        $SQLQuery = 'SELECT MAX(' . $strParam . ') AS MAX FROM ' . $this->strTable;

        // Preparamos la conexión y ejecutamos la consulta.
        $PDOStmt = $this->PDOConnection->prepare($SQLQuery);
        $PDOStmt->execute();

        // Guardamos la fila en una variable.
        // Esto genera un array asociativo como [MAX => 2000].
        $maxRow = $PDOStmt->fetch(PDO::FETCH_ASSOC);

        // Devolvemos el valor de MAX de nuestro array asociativo (200).
        return $maxRow['MAX'];
    }
}