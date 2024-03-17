<?php
/**
 * Función encargada de realizar la inserción inicial de usuarios en la tabla USERS.
 *
 * @param array $arrUsuarios Array que contiene todos los usuarios
 * @return void
 */
function insertInicial(array $arrUsuarios): void {
    truncate();
    foreach ($arrUsuarios as $usuario) {
        insertaUsuario($usuario);
    }
}

/**
 * Función encargada de realizar una sentencia TRUNCATE de la tabla USERS.
 *
 * @return void
 */
function truncate(): void {
    $strTablaAcceso = 'USERS';
    $strComandoSQL = 'TRUNCATE TABLE ' . $strTablaAcceso;

    $PDOConexion = null;
    $SQLStatement = null;

    try {
        $PDOConexion = generarConexion();
        if ($PDOConexion) {
            $SQLStatement = $PDOConexion->prepare($strComandoSQL);
            $SQLStatement->execute();
        }
    } catch (PDOException $e) {
        echo 'ERROR EN LA ELIMINACIÓN DE TODOS LOS DATOS DE LA TABLA ' . $strTablaAcceso . '.';
    } finally {
        cierraConexion($PDOConexion, $SQLStatement);
    }
}

/**
 * Función encargada de insertar un usuario en la base de datos.
 *
 * @param array $usuario Array asociativo con las características del usuario.
 * @return void
 */
function insertaUsuario(array $usuario): void {
    $strTablaAcceso = 'USERS';
    $strComandoSQL = 'INSERT INTO ' . $strTablaAcceso
        . ' (ID, NOMBRE, USUARIO, PASSWORD, EMAIL) VALUES'
        . ' (:id, :nombre, :usuario, :password, :email)';

    $PDOConexion = null;
    $SQLStatement = null;

    try {
        $PDOConexion = generarConexion();
        if ($PDOConexion) {
            $usuario['PASSWORD'] = generaHash($usuario['PASSWORD']);
            $SQLStatement = $PDOConexion->prepare($strComandoSQL);
            $SQLStatement->bindParam(':id', $usuario['ID']);
            $SQLStatement->bindParam(':nombre', $usuario['NOMBRE']);
            $SQLStatement->bindParam(':usuario', $usuario['USUARIO']);
            $SQLStatement->bindParam(':password', $usuario['PASSWORD']);
            $SQLStatement->bindParam(':email', $usuario['EMAIL']);
            $SQLStatement->setFetchMode(PDO::FETCH_ASSOC);
            $SQLStatement->execute();
        }
    } catch (PDOException $e) {
        echo 'ERROR EN LA INSERCIÓN DE DATOS EN LA TABLA ' . $strTablaAcceso . '.';
    } finally {
        cierraConexion($PDOConexion, $SQLStatement);
    }
}

/**
 * Cifra una contraseña a partir de un algoritmo de cifrado.
 *
 * @param string $contrasena Contraseña del usuario.
 * @return string Devuelve un string con la contraseña cifrada.
 */
function generaHash(string $contrasena): string {
    return password_hash($contrasena, PASSWORD_DEFAULT);
}

/**
 * Función encargada de comprobar la contraseña introducida por el usuario.
 *
 * @param string $userName Nombre del usuario.
 * @param string $password Contraseña introducida.
 * @return bool Devuelve un booleano, true si la contraseña es correcta o false si no lo es.
 */
function compruebaContrasena(string $userName, string $password): bool {
    $passwordHash = getContrasenaHash($userName);

    if (password_verify($password, $passwordHash)) {
        return true;
    }

    return false;
}

/**
 * Función encargada de obtener la contraseña de un usuario.
 *
 * @param string $userName Nombre del usuario.
 * @return string Devuelve la contraseña almacenada en la base de datos.
 */
function getContrasenaHash(string $userName): string {
    $strContrasenaReturn = '';
    $strTablaAcceso = 'USERS';
    $strComandoSQL = 'SELECT PASSWORD FROM ' . $strTablaAcceso
        . ' WHERE USUARIO = :usuario';

    $PDOConexion = null;
    $SQLStatement = null;

    try {
        $PDOConexion = generarConexion();
        if ($PDOConexion) {
            $SQLStatement = $PDOConexion->prepare($strComandoSQL);
            $SQLStatement->bindParam(':usuario', $userName);
            $SQLStatement->setFetchMode(PDO::FETCH_ASSOC);
            $SQLStatement->execute();

            $filaUsuario = $SQLStatement->fetch();

            if ($filaUsuario) {
                $strContrasenaReturn = $filaUsuario['PASSWORD'];
            }
        }
    } catch (PDOException $e) {
        echo 'ERROR EN EL ACCESO A LOS DATOS DE LA TABLA ' . $strTablaAcceso . '.';
    } finally {
        cierraConexion($PDOConexion, $SQLStatement);
        return $strContrasenaReturn;
    }
}

