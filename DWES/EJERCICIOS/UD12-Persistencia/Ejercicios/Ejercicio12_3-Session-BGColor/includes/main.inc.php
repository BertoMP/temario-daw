<main>
    <h1><?= $strTitulo ?></h1>
    <section>
        <form action="index.php" method="get">
            <select name="seleccionColor" id="seleccionColor">
                <option value="">Selecciona color...</option>
                <?php
                foreach ($arrValueColores as $value => $nombre) {
                    echo '<option value="' . $value . '"';
                    if ($strColorElegido === $value) {
                        echo ' selected ';
                    }
                    echo '>' . $nombre . '</option>';
                }
                ?>
            </select>
            <article>
                <button type="submit" name="envioDatos">Seleccionar color</button>
                <?php
                if (!empty($strColorElegido)) {
                    echo '<a href="./php/verColor.php">Ver color seleccionado</a>';
                }
                ?>
            </article>
        </form>
    </section>
</main>