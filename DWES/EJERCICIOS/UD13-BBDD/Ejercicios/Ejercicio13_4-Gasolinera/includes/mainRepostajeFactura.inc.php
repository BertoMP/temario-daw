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
                <label for="importe">Importe</label>
                <input type="number" name="importe" id="importe" step="0.01" min="0.01" max="9999.99"
                       value="<?php echo $_SESSION['importe'] ?? '' ?>">
            </article>
            <article>
                <label for="dni">DNI cliente (Formato: 12345678-A)</label>
                <input type="text" name="dni" id="dni" placeholder="12345678-A" pattern="^[0-9]{8}-[A-Z]$"
                       value="<?php echo $_SESSION['dni'] ?? '' ?>">
            </article>
            <article>
                <label for="matricula">Matrícula cliente (Formato: 1234-ABC)</label>
                <input type="text" name="matricula" id="matricula" placeholder="1234-ABC" pattern="^[0-9]{4}-[A-Z]{3}$"
                       value="<?php echo $_SESSION['matricula'] ?? '' ?>">
            </article>
            <article>
                <button type="submit" formaction="./insercion_tabla_facturas.php" name="envio-datos-factura">
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