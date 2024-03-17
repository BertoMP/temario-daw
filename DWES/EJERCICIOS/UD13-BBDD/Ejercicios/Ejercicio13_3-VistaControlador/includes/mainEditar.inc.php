<main>
    <h1><?= $strTitulo ?></h1>
    <a href="./logout.php">Cerrar sesión</a>
    <section>
        <?php
        selectHeroe($id);
        ?>
    </section>
</main>