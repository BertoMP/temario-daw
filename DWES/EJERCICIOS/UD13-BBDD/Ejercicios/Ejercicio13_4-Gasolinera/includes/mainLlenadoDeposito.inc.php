<main>
    <h1><?= $strTitulo ?></h1>
    <article class="atras">
        <form method="post">
            <button type="submit" formaction="../index.php">Volver al índice</button>
        </form>
    </article>
    <section>
        <form method="post">
            <article>
                <label for="litros">Litros</label>
                <input type="number" name="litros" id="litros" step="0.01" min="0.01" max="9999.99"
                       value="<?php echo $_SESSION['litros'] ?? '' ?>">
            </article>
            <article>
                <label for="tipo-gasolina">Tipo de combustible</label>
                <select name="tipo-gasolina" id="tipo-gasolina">
                    <?php
                    $tipoGasolina = $_SESSION['tipo-gasolina'] ?? '';

                    foreach ($arrTiposGasolina as $key => $value) {
                        echo '<option value="' . $key . '" '
                            . (($tipoGasolina === $key) ? 'selected' : '') . '>' . $value . '</option>';
                    }
                    ?>
                </select>
            </article>
            <article>
                <label for="importe">Importe</label>
                <input type="number" name="importe" id="importe" step="0.01" min="0.01" max="9999.99"
                       value="<?php echo $_SESSION['importe'] ?? '' ?>">
            </article>
            <article>
                <button type="submit" formaction="./insercion_tabla_depositos.php" name="envio-datos-factura">
                    Enviar datos
                </button>
            </article>
            <?php
            if (isset($_SESSION['datos-incorrectos'])) {
                echo '<p>Los datos introducidos son incorrectos o están vacíos.</p>';
            }
            ?>
        </form>
    </section>
</main>