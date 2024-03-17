<main>
    <h1><?= $strTitulo ?></h1>
    <section>
        <article class="atras">
            <form method="get">
                <button type="submit" formaction="../index.php">Volver al índice</button>
            </form>
        </article>
    </section>
    <section class="tabla-repostajes">
        <!-- Llamada a la función select() del fichero PDO.inc.php -->
        <?php select('REPOSTAJES'); ?>
    </section>
</main>