<main>
    <h1><?= $strTitulo ?></h1>
    <section>
        <table>
            <caption>DATOS INTRODUCIDOS EN LA SESIÓN</caption>
            <tbody>
                <?php
                foreach ($_SESSION as $clave => $valor) {
                    echo '<tr>';
                    echo '<th>' . $clave . '</th>';
                    if (is_array($valor)) {
                        echo '<td>';
                        echo '<ul>';
                        foreach ($valor as $itemValor) {
                            echo '<li>' . $itemValor . '</li>';
                        }
                        echo '</ul>';
                        echo '</td>';
                    } else {
                        echo '<td>' . $valor . '</td>';
                    }
                }
                ?>
            </tbody>
        </table>
    </section>
</main>
<a href="../php/destruyeSesion.php">Volver al inicio</a>