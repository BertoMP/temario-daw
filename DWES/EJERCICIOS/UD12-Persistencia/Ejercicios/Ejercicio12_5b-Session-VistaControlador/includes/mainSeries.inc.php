<main>
    <h1><?= $strTitulo ?></h1>
    <section>
        <ul>
            <?php
            foreach ($_SESSION['series'] as $serie) {
                echo '<li>' . $serie . '</li>';
            }
            ?>
        </ul>
    </section>
    <section class="botones">
        <a href="../php/peliculas.php">Ir al listado de peliculas</a>
        <a href="../php/logout.php">Cerrar sesión</a>
    </section>
</main>