<main>
    <h1><?= $strTitulo ?></h1>
    <section>
        <form action="../php/pagina3.php" method="get">
            <?php
            foreach ($arrCampos as $claveCampo => $valorCampo) {
                echo '<article>';
                if (is_array($valorCampo)) {
                    $clavesAficiones = array_keys($arrCampos[$claveCampo]);
                    $intCont = 0;
                    if ($claveCampo === 'aficiones') {
                        echo '<p>Aficiones</p>';
                        echo '<section>';
                        foreach ($valorCampo as $clave => $valor) {
                            echo '<article>';
                            $checked = '';
                            if (isset($_SESSION['aficiones']) && in_array($valor, $_SESSION['aficiones'])) {
                                $checked = 'checked';
                            }
                            echo '<input type="checkbox" name="aficiones[]" id="' .
                                $clavesAficiones[$intCont] . '" value="' . $valor . '" ' . $checked . '>';
                            echo '<label for="' . $clavesAficiones[$intCont] . '">' . $valor . '</label>';
                            echo '</article>';
                            $intCont++;
                        }
                        echo '</section>';
                    } else {
                        echo '<p>Menú favorito</p>';
                        echo '<select name="menu[]" id="menu" multiple>';
                        foreach ($valorCampo as $clave => $valor) {
                            $selected = '';
                            if (isset($_SESSION['menu']) && in_array($valor, $_SESSION['menu'])) {
                                $selected = 'selected';
                            }
                            echo '<option value="' . $valor . '" ' . $selected . '>' . $valor . '</option>';
                        }
                        echo '</select>';
                    }
                } else {
                    $valorPrevio = '';
                    if (isset($_SESSION[$claveCampo])) {
                        $valorPrevio = $_SESSION[$claveCampo];
                    }
                    echo '<label for="' . $claveCampo . '">' . $valorCampo . '</label>';
                    echo '<input type="number" name="' . $claveCampo . '" id="' . $claveCampo . '" value="' . $valorPrevio . '">';
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