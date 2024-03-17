<?php
/**
 * Método encargado de generar una conexión a la base de datos. Si la conexión es correcta, devuelve un objeto PDO,
 * si no lo es devuelve un null.
 *
 * @return  PDO|null    Resultado de la función. PDO si la conexión es exitosa. null si no lo es.
 */
function generarConexion(): PDO | null {
    $strGestorBD = 'mysql';
    $strHost = 'localhost';
    $strPuerto = '3308';
    $strNombreBD = 'gasolinera';
    $strUsuarioBD = 'root';
    $strPassBD = '';

    try {
        $PDOConexion = new PDO(
            $strGestorBD
            . ':host=' . $strHost
            . ';port=' .$strPuerto
            . ';dbname=' . $strNombreBD,
            $strUsuarioBD,
            $strPassBD
        );

        $PDOConexion -> setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

        return $PDOConexion;
    } catch (PDOException $e) {
        echo '<p class="no-valido">ERROR EN LA CONEXIÓN A LA BD ' . $strNombreBD . '.</p>';
        echo $e->getMessage();

        return null;
    }
}

/**
 * Método encargado de cerrar la conexión a la base de datos y el cursor (si no son nulos).
 *
 * @param   PDO|null            $conexion   Conexión a la base de datos.
 * @param   PDOStatement|null   $cursor     Cursor de la consulta realizada.
 * @return  void
 */
function cierraConexion(?PDO $conexion, ?PDOStatement $cursor): void {
    $cursor?->closeCursor();

    if ($conexion !== null) {
        $conexion = null;
    }
}

/**
 * Método encargado de realizar una sentencia de tipo SELECT sobre la tabla pasada por parámetro.
 * @param   string  $strTablaAcceso Nombre de la tabla a la que se quiere acceder.
 * @return  void
 */
function select(string $strTablaAcceso): void {
    $strComandoSQL = 'SELECT * FROM ' . $strTablaAcceso;

    $PDOConexion = null;
    $SQLStatement = null;

    try {
        $PDOConexion = generarConexion();

        if ($PDOConexion) {
            $SQLStatement = $PDOConexion -> prepare($strComandoSQL);
            $SQLStatement -> setFetchMode(PDO::FETCH_ASSOC);
            $SQLStatement -> execute();

            $intCantRegistros = $SQLStatement -> rowCount();

            if ($intCantRegistros > 0) {
                echo 'Registros encontrados: ' . $intCantRegistros;
                $arrCamposTabla = obtenCamposTabla($strTablaAcceso, $PDOConexion);
                generaTablaHTML($arrCamposTabla, $SQLStatement);
            } else {
                echo 'La tabla ' . $strTablaAcceso . ' no contiene registros.';
            }
        }
    } catch (PDOException $e) {
        echo '<p class="no-valido">ERROR EN EL ACCESO A LOS DATOS DE LA TABLA ' . $strTablaAcceso . '.</p>';
    } finally {
        cierraConexion($PDOConexion, $SQLStatement);
    }
}

/**
 * Método encargado de realizar una sentencia de tipo INSERT del objeto Ticket pasado por parámetro.
 *
 * @param   Ticket  $objTicket  El objeto Ticket a insertar en la tabla.
 * @return  void
 */
function insertTicket(Ticket $objTicket): void {
    $strComandoSQL = 'INSERT INTO REPOSTAJES (FECHA, HORA, IMPORTE) VALUES (:fecha, :hora, :importe)';

    $PDOConexion = null;
    $SQLStatement = null;

    try {
        $PDOConexion = generarConexion();

        if ($PDOConexion) {
            $SQLStatement = $PDOConexion -> prepare($strComandoSQL);

            $fecha = $objTicket->getFecha();
            $SQLStatement -> bindParam(':fecha', $fecha);

            $hora = $objTicket->getHora();
            $SQLStatement -> bindParam(':hora', $hora);

            $importe = $objTicket->getImporte();
            $SQLStatement -> bindParam(':importe', $importe);

            $SQLStatement -> execute();
        }
    } catch (PDOException $e) {
        echo '<p class="no-valido">ERROR EN LA INSERCIÓN DE LOS DATOS EN LA TABLA REPOSTAJES.</p>';
    } finally {
        cierraConexion($PDOConexion, $SQLStatement);
    }
}

/**
 * Método encargado de realizar una sentencia de tipo INSERT del objeto Factura pasado por parámetro.
 *
 * @param   Factura     $objFactura     Objeto Factura a insertar.
 * @return  void
 */
function insertFactura(Factura $objFactura): void {
    $strComandoSQL = 'INSERT INTO REPOSTAJES (FECHA, HORA, IMPORTE, DNI, MATRICULA) ' .
        'VALUES (:fecha, :hora, :importe, :dni, :matricula)';

    $PDOConexion = null;
    $SQLStatement = null;

    try {
        $PDOConexion = generarConexion();

        if ($PDOConexion) {
            $SQLStatement = $PDOConexion->prepare($strComandoSQL);

            $fecha = $objFactura->getFecha();
            $SQLStatement->bindParam(':fecha', $fecha);

            $hora = $objFactura->getHora();
            $SQLStatement->bindParam(':hora', $hora);

            $importe = $objFactura->getImporte();
            $SQLStatement->bindParam(':importe', $importe);

            $dni = $objFactura->getDni();
            $SQLStatement->bindParam(':dni', $dni);

            $matricula = $objFactura->getMatricula();
            $SQLStatement->bindParam(':matricula', $matricula);

            var_dump($SQLStatement);

            $SQLStatement->execute();
        }
    } catch (PDOException $e) {
        echo '<p class="no-valido">ERROR EN LA INSERCIÓN DE LOS DATOS EN LA TABLA REPOSTAJES.</p>';
    } finally {
        cierraConexion($PDOConexion, $SQLStatement);
    }
}

/**
 * Método encargado de realizar una sentencia de tipo INSERT del objeto Deposito pasado por parámetro.
 *
 * @param   Deposito    $objDeposito    Objeto Deposito a insertar en la tabla.
 * @return  void
 */
function insertDeposito(Deposito $objDeposito): void {
    $strComandoSQL = 'INSERT INTO DEPOSITOS (CANT_LITROS, TIPO_GASOLINA, IMPORTE) ' .
        'VALUES (:cant_litros, :tipo_gasolina, :importe)';

    $PDOConexion = null;
    $SQLStatement = null;

    try {
        $PDOConexion = generarConexion();

        if ($PDOConexion) {
            $SQLStatement = $PDOConexion -> prepare($strComandoSQL);

            $cant_litros = $objDeposito->getLitrosSuministrados();
            $SQLStatement -> bindParam(':cant_litros', $cant_litros);

            $tipo_combustible = $objDeposito->getCombustible();
            $SQLStatement -> bindParam(':tipo_gasolina', $tipo_combustible);

            $importe = $objDeposito->getImporteTotal();
            $SQLStatement -> bindParam(':importe', $importe);

            $SQLStatement -> execute();
        }
    } catch (PDOException $e) {
        echo '<p class="no-valido">ERROR EN LA INSERCIÓN DE LOS DATOS EN LA TABLA DEPOSITOS.</p>';
    } finally {
        cierraConexion($PDOConexion, $SQLStatement);
    }
}

/**
 * Método encargado de ejecutar una sentencia de tipo DELETE para borrar el último depósito de la tabla
 * (el que tenga el ID más alto).
 *
 * @return  void
 */
function deleteDeposito(): void {
    $strComandoSQL = 'DELETE FROM DEPOSITOS WHERE ID = (SELECT MAX(ID) FROM DEPOSITOS)';

    $PDOConexion = null;
    $SQLStatement = null;

    try {
        $PDOConexion = generarConexion();

        if ($PDOConexion) {
            $SQLStatement = $PDOConexion -> prepare($strComandoSQL);
            $SQLStatement -> setFetchMode(PDO::FETCH_ASSOC);
            $SQLStatement -> execute();
            echo '<p class="valido">Registro eliminado de la tabla DEPOSITOS.</p>';
        }
    } catch (PDOException $e) {
        echo '<p class="no-valido">ERROR EN EL BORRADO DE DATOS DE LA TABLA DEPOSITOS.</p>';
    } finally {
        cierraConexion($PDOConexion, $SQLStatement);
    }
}

/**
 * Método encargado de sumar el importe de los repostajes.
 *
 * @return  float La suma de todos los importes de la tabla.
 */
function sumaImportes(): float {
    $strComandoSQL = 'SELECT ROUND(SUM(IMPORTE), 2) AS TOTAL FROM REPOSTAJES';

    $rlnImporte = 0;

    $PDOConexion = null;
    $SQLStatement = null;

    try {
        $PDOConexion = generarConexion();

        if ($PDOConexion) {
            $SQLStatement = $PDOConexion -> prepare($strComandoSQL);
            $SQLStatement -> setFetchMode(PDO::FETCH_ASSOC);
            $SQLStatement -> execute();

            $filaTabla = $SQLStatement->fetch();
            $rlnImporte = $filaTabla['TOTAL'];
        }
    } catch (PDOException $e) {
        echo '<p class="no-valido">ERROR EN EL ACCESO A LOS DATOS DE LA TABLA REPOSTAJES</p>';
    } finally {
        cierraConexion($PDOConexion, $SQLStatement);
        return $rlnImporte;
    }
}

/**
 * Método encargado de ejecutar una sentencia DESCRIBE sobre una tabla y de devolver
 * un array con el nombre de los campos.
 *
 * @param   string  $strTabla       Nombre de la tabla de la cual se quieren conocer los campos.
 * @param   PDO     $PDOConexion    Objeto PDO que contiene la conexión a la BD.
 * @return  array   Devuelve un array con el nombre de los campos de la tabla.
 */
function obtenCamposTabla(string $strTabla, PDO $PDOConexion): array {
    $arrCamposReturn = array();
    $strComandoSQL = 'DESCRIBE ' . $strTabla;

    $SQLStatement = null;

    try {
        $SQLStatement = $PDOConexion->prepare($strComandoSQL);
        $SQLStatement->setFetchMode(PDO::FETCH_ASSOC);
        $SQLStatement->execute();

        while ($campo = $SQLStatement->fetch()) {
            $arrCamposReturn[] = $campo['Field'];
        }
    } catch (PDOException $e) {
        echo '<p class="no-valido">ERROR DURANTE EL ACCESO AL NOMBRE DE LOS CAMPOS DE LA TABLA ' . $strTabla . '.</p>';
    } finally {
        $SQLStatement?->closeCursor();
    }

    return $arrCamposReturn;
}

/**
 * Método encargado de generar una tabla de HTML con los atributos de cada héroe.
 *
 * @param   array           $arrCamposTabla     Tabla que contiene el nombre de los campos de la tabla.
 * @param   PDOStatement    $sentenciaSQL       Objeto PDOStatement con el resultado de la búsqueda en la base de datos.
 * @return  void
 */
function generaTablaHTML(array $arrCamposTabla, PDOStatement $sentenciaSQL): void {
    echo '<table>';
    echo generaThead($arrCamposTabla);
    echo generaTbody($sentenciaSQL);
    echo '</table>';
}

/**
 * Función encargada de generar un <thead> y su contenido a partir del array pasado por parámetro.
 *
 * @param   array   $arrCamposTabla     Array con los nombres de los campos sobre los que se hace la consulta.
 * @return  string  Devuelve un string que contiene las etiquetas HTML que conforman la cabecera de la tabla.
 */
function generaThead(array $arrCamposTabla): string {
    $strReturn = '<thead><tr>';

    foreach ($arrCamposTabla as $campo) {
        $strReturn .= '<th>' . $campo . '</th>';
    }

    $strReturn .= '</tr>';
    $strReturn .= '</thead>';

    return $strReturn;
}

/**
 * Función encargada de generar un <tbody> con su contenido a partir de un elemento PDOStatement que contiene la
 * consulta realizada sobre la tabla.
 *
 * @param   PDOStatement    $SQLStatement   PDOStatement que contiene la consulta que ha sido realizada sobre la tabla.
 * @return  string Devuelve un string que contiene las etiquetas HTML que conforman el cuerpo de la tabla.
 */
function generaTbody(PDOStatement $SQLStatement): string {
    $strReturn = '<tbody>';

    while ($filaTabla = $SQLStatement->fetch()) {
        $strReturn .= '<tr>';
        $arrAtributos = array_values($filaTabla);

        foreach ($arrAtributos as $atributo) {
            $strReturn .= '<td>' . $atributo . '</td>';
        }
    }

    $strReturn .= '</tbody>';

    return $strReturn;
}