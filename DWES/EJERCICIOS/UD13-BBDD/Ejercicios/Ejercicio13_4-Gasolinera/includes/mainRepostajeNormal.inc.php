<main>
    <h1><?= $strTitulo ?></h1>
    <article class="atras">
        <form method="get">
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
                <button type="submit" formaction="./insercion_tabla_tickets.php" name="envio-datos-ticket">
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