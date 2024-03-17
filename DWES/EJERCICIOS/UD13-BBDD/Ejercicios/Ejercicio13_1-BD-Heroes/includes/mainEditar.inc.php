<main>
    <h1><?= $strTitulo ?></h1>
    <section>
        <?php
        // Llamada a la función selectHeroe(string $id) del archivo PDO.inc.php.
        selectHeroe($id);
        ?>
    </section>
</main>