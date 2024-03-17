<main>
    <h1><?= $strTitulo ?></h1>
    <section>
        <?php
        foreach ($arrBotones as $boton) {
            echo '<article>';
            echo '<form method="post">';
            echo '<button formaction="' . $boton[0] . '" name="' . $boton[1] . '">' . $boton[2] . '</button>';
            echo '</form>';
            echo '</article>';
        }

        if (isset($_REQUEST['importe-total'])) { // En el caso de que se seleccione la opción de ver el importe total.
            $_SESSION['ultima-opcion'] = 'importe'; // Asigna el valor 'importe' a $_SESSION['ultima-opcion'].

            // Llamada a la función sum() del fichero PDO.inc.php.
            $rlnTotalRepostajes = sumaImportes();
            echo '<p>El importe total de los repostajes es ' . $rlnTotalRepostajes . '€.</p>';
        }

        if (isset($_REQUEST['del-llenado'])) { // En el caso de que se quiera eliminar el último llenado.
            if ($_SESSION['ultima-opcion'] === 'llenado-deposito') { // Si la última opción fue llenado de depósito.
                $_SESSION['ultima-opcion'] = 'eliminado'; // Asigna el valor 'eliminado' a $_SESSION['ultima-opcion'].

                // Llamada a la función deleteDeposito del fichero PDO.inc.php.
                deleteDeposito();
            } else { // En caso de que la última opción no fuera un llenado de depósito
                echo '<p class="no-valido">Para realizar esta acción la última opción debe ser un llenado de depósito.<p>';
            }
        }
        ?>
    </section>
</main>