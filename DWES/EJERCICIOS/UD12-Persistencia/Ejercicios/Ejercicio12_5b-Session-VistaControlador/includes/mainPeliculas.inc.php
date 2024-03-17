<main>
    <h1><?= $strTitulo ?></h1>
    <section>
        <ul>
            <?php
            foreach ($_SESSION['peliculas'] as $pelicula) {
                echo '<li>' . $pelicula . '</li>';
            }
            ?>
        </ul>
    </section>
    <section class="botones">
        <a href="../php/series.php">Ir al listado de series</a>
        <a href="../php/logout.php">Cerrar sesión</a>
    </section>
</main>