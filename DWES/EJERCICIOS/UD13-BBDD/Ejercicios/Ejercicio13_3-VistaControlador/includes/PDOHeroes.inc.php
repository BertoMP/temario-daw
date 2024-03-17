<?php
/**
 * Método encargado de generar una conexión a la base de datos. Si la conexión es correcta, devuelve un objeto PDO,
 * si no lo es devuelve un null.
 *
 * @return PDO|null Resultado de la función. PDO si la conexión es exitosa. null si no lo es.
 */
function generarConexion(): PDO | null {
    $strGestorBD = 'mysql';
    $strHost = 'localhost';
    $strPuerto = '3310';
    $strNombreBD = 'juego';
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
        echo 'ERROR EN LA CONEXIÓN A LA BD ' . $strNombreBD . '.';

        return null;
    }
}

/**
 * Método encargado de cerrar la conexión a la base de datos y el cursor (si no son nulos).
 *
 * @param PDO|null $conexionBD Conexión a la base de datos.
 * @param PDOStatement|null $cursorConsulta Cursor de la consulta realizada.
 * @return void
 */
function cierraConexion(?PDO $conexionBD, ?PDOStatement $cursorConsulta): void {
    $cursorConsulta?->closeCursor();

    if ($conexionBD !== null) {
        $conexionBD = null;
    }
}

/**
 * Método encargado de devolver la búsqueda de todos los campos de la tabla en un orden establecido en un array
 * asociativo.
 *
 * @param array $arrCamposDirecciones Array que contiene una asociación de orden y su valor (p.e. NOMBRE -> ASC).
 * @return void
 */
function selectOrder(array $arrCamposDirecciones): void {
    $strAdd = getStringOrder($arrCamposDirecciones);

    $strTablaAcceso = 'HEROES';
    $strComandoSQL = 'SELECT * FROM ' . $strTablaAcceso . ' ORDER BY ';
    $strComandoSQL .= (!empty($strAdd)) ? $strAdd : 'ID ASC';

    echo '<p>' . $strComandoSQL . '</p>';

    $PDOConexion = null;
    $SQLStatement = null;

    try {
        $PDOConexion = generarConexion();

        if ($PDOConexion) {
            $SQLStatement = $PDOConexion->prepare($strComandoSQL);
            $SQLStatement->setFetchMode(PDO::FETCH_ASSOC);
            $SQLStatement->execute();

            $intCantRegistros = $SQLStatement -> rowCount();

            if($intCantRegistros > 0) {
                echo 'Registros encontrados: ' . $intCantRegistros;
                $arrCamposTabla = obtenCamposTabla($strTablaAcceso, $PDOConexion);
                generaTablaHTML($arrCamposTabla, $SQLStatement, $arrCamposDirecciones);
            } else {
                echo 'La tabla no contiene datos.';
            }
        }
    } catch (PDOException $e) {
        echo 'ERROR EN EL ACCESO A LOS DATOS DE LA TABLA ' . $strTablaAcceso . '.';
    } finally {
        cierraConexion($PDOConexion, $SQLStatement);
    }
}

/**
 * Método encargado de recoger los datos de un héroe concreto a partir del ID que se pasa por parámetro.
 *
 * @param string $id String que contiene el ID del héroe seleccionado.
 * @return void
 */
function selectHeroe(string $id): void {
    $strTablaAcceso = 'HEROES';
    $strComandoSQL = 'SELECT * FROM ' . $strTablaAcceso . ' WHERE ID = :id';

    $PDOConexion = null;
    $SQLStatement = null;

    try {
        $PDOConexion = generarConexion();
        if ($PDOConexion) {
            $SQLStatement = $PDOConexion->prepare($strComandoSQL);
            $SQLStatement->bindParam(':id', $id);
            $SQLStatement->setFetchMode(PDO::FETCH_ASSOC);
            $SQLStatement->execute();

            if ($filaHeroe = $SQLStatement -> fetch()) {
                generaFormulario($filaHeroe);
            } else {
                echo 'NO EXISTE UN HÉROE CON EL ID ' . $id . '.';
            }
        }
    } catch (PDOException $e) {
        echo 'ERROR EN EL ACCESO A LOS DATOS DE LA TABLA ' . $strTablaAcceso . '.';
    } finally {
        cierraConexion($PDOConexion, $SQLStatement);
    }
}

/**
 * Método encargado de realizar una sentencia SQL de tipo UPDATE a partir de un array pasado por parámetro.
 *
 * @param array $arrDatos Array que contiene los datos que se deben modificar en el héroe.
 * @return void
 */
function update(array $arrDatos): void {
    $strTablaAcceso = 'HEROES';
    $strComandoSQL = 'UPDATE ' . $strTablaAcceso
        . ' SET NOMBRE = :nombre,'
        . ' ROL = :rol,'
        . ' DIFICULTAD = :dificultad,'
        . ' DESCRIPCION = :descripcion'
        . ' WHERE ID = :id';

    $PDOConexion = null;
    $SQLStatement = null;

    try {
        $PDOConexion = generarConexion();
        if ($PDOConexion) {
            $SQLStatement = $PDOConexion->prepare($strComandoSQL);
            $SQLStatement->bindParam(':nombre', $arrDatos['nombre']);
            $SQLStatement->bindParam(':rol', $arrDatos['rol']);
            $SQLStatement->bindParam(':dificultad', $arrDatos['dificultad']);
            $SQLStatement->bindParam(':descripcion', $arrDatos['descripcion']);
            $SQLStatement->bindParam(':id', $arrDatos['id']);
            $SQLStatement->execute();
        }
    } catch (PDOException $e) {
        echo 'ERROR AL ACTUALIZAR LOS DATOS EN LA TABLA ' . $strTablaAcceso . '.';
    } finally {
        cierraConexion($PDOConexion, $SQLStatement);
    }
}

/**
 * Método encargado de ejecutar una sentencia de tipo DELETE para borrar un héroe de la tabla.
 *
 * @param $id String que contiene el ID del héroe a borrar.
 * @return void
 */
function delete(string $id): void {
    $strTablaAcceso = 'HEROES';
    $strComandoSQL = 'DELETE FROM ' . $strTablaAcceso . ' WHERE ID = :id';

    $PDOConexion = null;
    $SQLStatement = null;

    try {
        $PDOConexion = generarConexion();
        if ($PDOConexion) {
            $SQLStatement = $PDOConexion -> prepare($strComandoSQL);
            $SQLStatement -> bindParam(':id', $id);
            $SQLStatement -> execute();
        }
    } catch (PDOException $e) {
        echo 'ERROR AL BORRAR DATOS DE LA TABLA ' . $strTablaAcceso . '.';
    } finally {
        cierraConexion($PDOConexion, $SQLStatement);
    }
}

/**
 * Método encargado de ejecutar una sentencia DESCRIBE sobre una tabla y de devolver
 * un array con el nombre de los campos.
 *
 * @param string $strTabla Nombre de la tabla de la cual se quieren conocer los campos.
 * @param PDO $PDOConexion Objeto PDO que contiene la conexión a la BD.
 * @return array - Devuelve un array con el nombre de los campos de la tabla.
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
        echo 'ERROR DURANTE EL ACCESO AL NOMBRE DE LOS CAMPOS DE LA TABLA ' . $strTabla;
    } finally {
        $SQLStatement?->closeCursor();
    }

    return $arrCamposReturn;
}

/**
 * Método encargado de generar una tabla de HTML con los atributos de cada héroe.
 *
 * @param array $arrCamposTabla Tabla que contiene el nombre de los campos de la tabla.
 * @param PDOStatement $sentenciaSQL Objeto PDOStatement con el resultado de la búsqueda en la base de datos.
 * @param array $arrCamposDirecciones Array que contiene un conjunto de parejas clave-valor con los órdenes actualmente
 *                                    elegidos por el usuario.
 * @return void
 */
function generaTablaHTML(array $arrCamposTabla, PDOStatement $sentenciaSQL, array $arrCamposDirecciones): void {
    echo '<table id="tabla-heroes">';
    echo generaThead($arrCamposTabla, $arrCamposDirecciones);
    echo generaTbody($sentenciaSQL);
    echo '</table>';
}

/**
 * Función encargada de generar un <thead> y su contenido a partir del array pasado por parámetro.
 *
 * @param array $arrCamposTabla Array con los nombres de los campos sobre los que se hace la consulta.
 * @param array $arrCamposDirecciones Array con parejas clave-valor campo-direccion (p. e. NOMBRE -> ASC).
 * @return string Devuelve un string que contiene las etiquetas HTML que conforman la cabecera de la tabla.
 */
function generaThead(array $arrCamposTabla, array $arrCamposDirecciones): string {
    $strReturn = '<thead><tr>';

    foreach ($arrCamposTabla as $campo) {
        $direccion = isset($arrCamposDirecciones[$campo]) ? $campo . ' ' . $arrCamposDirecciones[$campo] : '';
        $strReturn .= '<th>' . formAscDesc($campo, 'ASC', $direccion) .
            $campo .
            formAscDesc($campo, 'DESC', $direccion) .
            '</th>';
    }

    $strReturn .= '<th colspan="2">ACCIONES</th>';
    $strReturn .= '</tr>';
    $strReturn .= '</thead>';

    return $strReturn;
}

/**
 * Función encargada de generar un <tbody> con su contenido a partir de un elemento PDOStatement que contiene la
 * consulta realizada sobre la tabla.
 *
 * @param PDOStatement $SQLStatement PDOStatement que contiene la consulta que ha sido realizada sobre la tabla.
 * @return string Devuelve un string que contiene las etiquetas HTML que conforman el cuerpo de la tabla.
 */
function generaTbody(PDOStatement $SQLStatement): string {
    $strReturn = '<tbody>';

    while ($filaHeroe = $SQLStatement->fetch()) {
        $strReturn .= '<tr>';
        $arrAtributos = array_values($filaHeroe);

        foreach ($arrAtributos as $atributo) {
            $strReturn .= '<td>' . $atributo . '</td>';
        }
        $strReturn .= '<td><form method="post">' .
            generaBoton($filaHeroe['ID'], './editar_heroe.php', 'Editar') .
            '</form></td><td><form method="post">' .
            generaBoton($filaHeroe['ID'], './borrar_heroe.php', 'Borrar') .
            '</form></td>';
    }

    $strReturn .= '</tbody>';

    return $strReturn;
}

/**
 * Función encargada de generar un formulario HTML a partir de los datos de un héroe (array) que se pasa por parámetro.
 *
 * @param array $heroe Array que contiene los datos de héroe en forma de clave valor.
 * @return void
 */
function generaFormulario(array $heroe): void {
    echo '<form method="post">';
    echo generarElementoFormulario('input', 'Nombre', 'nombre', 'nombreHeroe', $heroe['NOMBRE']);
    echo generarElementoFormulario('input','Rol', 'rol', 'rolHeroe', $heroe['ROL']);
    echo generarElementoFormulario('input','Dificultad', 'dificultad', 'dificultadHeroe',
        $heroe['DIFICULTAD']);
    echo generarElementoFormulario('textarea','Descripción', 'descripcion', 'descripcionHeroe',
        $heroe['DESCRIPCION']);
    echo '<article>';
    echo generaBoton($heroe['ID'], './actualizar_heroe.php', 'Editar héroe');
    echo generaBoton($heroe['ID'], './heroes.php', 'Anular cambios');
    echo '</article>';
    echo '</form>';
}

/**
 * Función encargada de generar un elemento <button> de HTML con los datos pasados por parámetro.
 *
 * @param string $ID Valor que tendrá el atributo ID.
 * @param string $enlace Valor que tendrá el atributo formaction.
 * @param string $mensaje Mensaje que tendrá el botón.
 * @return string Devuelve un String que contiene el elemento HTML.
 */
function generaBoton(string $ID, string $enlace, string $mensaje): string {
    return '<button type="submit" formaction="' . $enlace . '" name="id" value="' .
        $ID . '">' . $mensaje . '</button>';
}

/**
 * Función encargada de generar un elemento del formulario (input o textarea) con los datos pasados por parámetro.
 *
 * @param string $tipo Tipo de elemento a generar ('input' o 'textarea').
 * @param string $label Etiqueta del elemento.
 * @param string $name Nombre del elemento.
 * @param string $id Valor del atributo ID del elemento.
 * @param string $value Valor del elemento.
 * @return string Devuelve un String que contiene el elemento HTML.
 */
function generarElementoFormulario($tipo, $label, $name, $id, $value): string {
    $elemento = '<article><label for="' . $id . '">' . $label . '</label>';

    if ($tipo === 'input') {
        $elemento .= '<input type="text" name="' . $name . '" id="' . $id . '" value="' . $value . '">';
    } else {
        $elemento .= '<textarea name="' . $name . '" id="' . $id . '">' . $value . '</textarea>';
    }

    $elemento .= '</article>';

    return $elemento;
}

/**
 * Función encargada de generar un formulario para ordenar elementos en una página.
 *
 * @param string $campo Campo por el que se ordenarán los elementos.
 * @param string $direccion Dirección de ordenamiento ('ASC' o 'DESC').
 * @param string $ordenActual Orden actual de los elementos.
 * @return string Devuelve un String que contiene el formulario HTML.
 */
function formAscDesc($campo, $direccion, $ordenActual): string {
    $strSimbolo = ($direccion === 'ASC')
        ? '<i class="fa-solid fa-arrow-up-wide-short"></i>'
        : '<i class="fa-solid fa-arrow-down-short-wide"></i>';
    $strHTML = '<form method="post">';
    $strHTML .= '<input type="hidden" name="campo" value="' . $campo . '">';
    $strHTML .= '<input type="hidden" name="orden" value="' . $direccion . '">';
    $strHTML .= '<button type="submit" ';

    if ($ordenActual === $campo . ' ' . $direccion) {
        $strHTML .= 'class="pulsado" ';
    }

    $strHTML .= 'formaction="heroes.php" name="envio-datos">' . $strSimbolo . '</button>';
    $strHTML .= '</form>';

    return $strHTML;
}

/**
 * Método encargado de construir un String para la función selectOrder en el que se define el orden que debe seguir
 * la query del método inicial.
 *
 * @param array $arrCamposDirecciones Array que contiene los pares de valores clave -> valor (p.e. NOMBRE -> ASC)
 * @return string Devuelve un String que contiene el orden a seguir en la query.
 */
function getStringOrder(array $arrCamposDirecciones): string {
    $strReturn = '';
    $intLength = count($arrCamposDirecciones);

    if ($intLength > 0) {
        foreach ($arrCamposDirecciones as $campo => $direccion) {
            $strReturn .= $campo . ' ' . $direccion . ', ';
        }
    }

    return substr($strReturn, 0, -2);
}