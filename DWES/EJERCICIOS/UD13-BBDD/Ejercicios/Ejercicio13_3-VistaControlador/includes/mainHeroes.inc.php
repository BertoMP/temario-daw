<main>
    <h1><?= $strTitulo ?></h1>
    <a href="./logout.php">Cerrar sesión</a>
    <section>
        <?php
        if (!isset($_SESSION['ordenCampos'])) { // En caso de que el parámetro $_SESSION['ordenCampos' no exista.
            $_SESSION['ordenCampos'] = array(); // Lo crea asociándole un array vacío.
        }

        if (isset($_REQUEST['envio-datos'])) { // En caso de que haya un envío de datos desde formulario
            $strCampo = $_REQUEST['campo']; // Campo elegido por el usuario.
            $strOrden = $_REQUEST['orden']; // Orden elegido por el usuario.

            if (!isset($_SESSION['ordenCampos'][$strCampo])) { // Si no existe el campo elegido en el array
                $_SESSION['ordenCampos'][$strCampo] = $strOrden; // Lo crea y le asocia el orden.
            } else if ($_SESSION['ordenCampos'][$strCampo] === $strOrden) { // Se hace clic sobre un campo seleccionado
                unset($_SESSION['ordenCampos'][$strCampo]); // Lo elimina.
            } else {
                $_SESSION['ordenCampos'][$strCampo] = $strOrden; // En cualquier otro caso asocia el orden al campo.
            }
        }

        // Llamada a la función selectOrder(array $ordenCampos) del archivo PDO.inc.php.
        selectOrder($_SESSION['ordenCampos']);
        ?>
    </section>
</main>