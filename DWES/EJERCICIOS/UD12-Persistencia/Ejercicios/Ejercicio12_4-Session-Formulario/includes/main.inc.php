<main>
    <h1><?= $strTitulo ?></h1>
    <section>
        <form action="./php/pagina2.php" method="get">
            <?php
            foreach ($arrCampos as $claveCampo => $valorCampo) {
                echo '<article>';
                if (is_array($valorCampo)) {
                    echo '<p>Sexo</p>';
                    foreach ($valorCampo as $clave => $valor) {
                        echo '<article>';
                        $checked = '';
                        if (isset($_SESSION['sexo']) && $_SESSION['sexo'] === $valor) {
                            $checked = 'checked';
                        }
                        echo '<input type="radio" name="sexo" id="' . $clave . '" value="' . $valor . '" ' . $checked . '>';
                        echo '<label for="' . $clave . '">' . $valor . '</label>';
                        echo '</article>';
                    }
                } else {
                    $valorPrevio = '';
                    if (isset($_SESSION[$claveCampo])) {
                        $valorPrevio = $_SESSION[$claveCampo];
                    }
                    echo '<label for="' . $claveCampo . '">' . $valorCampo . '</label>';
                    echo '<input type="text" name="' . $claveCampo . '" id="' . $claveCampo . '" value="' . $valorPrevio . '">';
                }
                echo '</article>';
            }
            ?>
            <button type="submit" name="envio-datos">Enviar datos</button>
            <?php
            if (isset($_SESSION['camposVacios']) && $_SESSION['camposVacios']) {
                echo '<p class="camposVacios">No puede haber campos vacíos.</p>';
            }
            ?>
        </form>
    </section>
</main>