<?php
$strMinBookId = $_SESSION['bookSearch']['minBookId'] ?? '';
$strMaxBookId = $_SESSION['bookSearch']['maxBookId'] ?? '';
$strBookTitle = $_SESSION['bookSearch']['bookTitle'] ?? '';
$strBookGenre = $_SESSION['bookSearch']['bookGenre'] ?? '';
$strBookCountry = $_SESSION['bookSearch']['bookCountry'] ?? '';
$strMinBookYear = $_SESSION['bookSearch']['minBookYear'] ?? '';
$strMaxBookYear = $_SESSION['bookSearch']['maxBookYear'] ?? '';
$strMinBookPage = $_SESSION['bookSearch']['minBookPage'] ?? '';
$strMaxBookPage = $_SESSION['bookSearch']['maxBookPage'] ?? '';
$arrBookAuthors = $_SESSION['bookSearch']['bookAuthor'] ?? [];
?>

<main class="entry-list">
    <section class="create-search">
        <?php
        if ($_SESSION['userRole'] > 1) {
        ?>
        <section class="create-button">
            <a class='create-entry'
               href="<?php echo CONTROLLERs_URL['books'] . 'edit' ?>">Añadir libro</a>
        </section>
        <?php
        }
        ?>
    </section>
    <section class="form-search">
        <h3>Búsqueda de libros</h3>
        <form action="<?php echo CONTROLLERs_URL['books'] . 'list' ?>" method="post">
            <section>
                <article>
                    <fieldset>
                        <legend>Número de ID</legend>
                        <article>
                            <label for="minBookId">Mínimo</label>
                            <input type="search" id="minBookId" name="minBookId" value="<?php echo $strMinBookId ?>">
                        </article>
                        <article>
                            <label for="maxBookId">Máximo</label>
                            <input type="search" id="maxBookId" name="maxBookId" value="<?php echo $strMaxBookId ?>">
                        </article>
                    </fieldset>
                </article>
                <article>
                    <label for="bookTitle">Título</label>
                    <input type="search" id="bookTitle" name="bookTitle" value="<?php echo $strBookTitle ?>">
                </article>
                <article>
                    <label for="bookGenre">Género</label>
                    <select id="bookGenre" name="bookGenre">
                        <option value=""> - CUALQUIERA - </option>
                        <?php
                        $arrGenres = $arrData['params']['genres'];
                        foreach ($arrGenres as $genre) {
                            ?>
                            <option value="<?php echo $genre['GENERO'] ?>"<?php echo $genre['GENERO'] === $strBookGenre
                                ? ' selected'
                                : ''; ?>>
                                <?php echo mb_strtoupper($genre['GENERO'], 'UTF-8'); ?>
                            </option>
                            <?php
                        }
                        ?>
                    </select>
                </article>
                <article>
                    <label for="bookCountry">País</label>
                    <select id="bookCountry" name="bookCountry">
                        <option value=""> - CUALQUIERA - </option>
                        <?php
                        $arrCountries = $arrData['params']['countries'];
                        foreach ($arrCountries as $country) {
                            ?>
                            <option value="<?php echo $country['PAIS'] ?>"<?php echo $country['PAIS'] === $strBookCountry
                                ? ' selected'
                                : '';?>>
                                <?php echo mb_strtoupper($country['PAIS'], 'UTF-8'); ?>
                            </option>
                            <?php
                        }
                        ?>
                    </select>
                </article>
                <article>
                    <label for="bookAuthor">Autor</label>
                    <select name="bookAuthor[]" id="bookAuthor" multiple>
                        <?php
                        $arrAuthors = $arrData['params']['authors'];
                        foreach ($arrAuthors as $author) {
                        ?>
                        <option value="<?php echo $author['ID_PERSONA']; ?>"
                            <?php echo in_array($author['ID_PERSONA'], $arrBookAuthors) ? ' selected' : ''; ?>>
                            <?php echo mb_strtoupper($author['APELLIDO'], 'UTF-8')
                                . ', ' . mb_strtoupper($author['NOMBRE'], 'UTF-8');
                            ?></option>
                        <?php
                        }
                        ?>
                    </select>
                </article>
            </section>
            <section>
                <article>
                    <fieldset>
                        <legend>Año publicación</legend>
                        <article>
                            <label for="minBookYear">Mínimo</label>
                            <input type="search" id="minBookYear" name="minBookYear" value="<?php echo $strMinBookYear ?>">
                        </article>
                        <article>
                            <label for="maxBookYear">Máximo</label>
                            <input type="search" id="maxBookYear" name="maxBookYear" value="<?php echo $strMaxBookYear ?>">
                        </article>
                    </fieldset>
                </article>
                <article>
                    <fieldset>
                        <legend>Número de páginas</legend>
                        <article>
                            <label for="minBookPage">Mínimo</label>
                            <input type="search" id="minBookPage" name="minBookPage" value="<?php echo $strMinBookPage ?>">
                        </article>
                        <article>
                            <label for="maxBookPage">Máximo</label>
                            <input type="search" id="maxBookPage" name="maxBookPage" value="<?php echo $strMaxBookPage ?>">
                        </article>
                    </fieldset>
                </article>
            </section>
            <article>
                <input type="hidden" name="btn-search">
                <button type="submit">Buscar</button>
            </article>
        </form>
    </section>

    <?php
    if (count($arrData['data']) > 0) {
        ?>
        <section>
            <h3>Resultados de la búsqueda de libros</h3>
            <p><?php echo $arrData['params']['message'] ?></p>
        </section>
        <section class="elements-section">
            <?php Functionality::printItems($arrData['data'], 'books'); ?>
        </section>
        <?php
    } else {
        ?>
        <section>
            <p><?php echo $arrData['params']['message'] ?></p>
        </section>
        <?php
    }
    ?>
</main>