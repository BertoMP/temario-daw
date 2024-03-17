<?php
$strMinBookId = $arrData['params']['searchValues']['minBookId'] ?? '';
$strMaxBookId = $arrData['params']['searchValues']['maxBookId'] ?? '';
$strBookTitle = $arrData['params']['searchValues']['bookTitle'] ?? '';
$strBookGenre = $arrData['params']['searchValues']['bookGenre'] ?? '';
$strBookCountry = $arrData['params']['searchValues']['bookCountry'] ?? '';
$strMinBookYear = $arrData['params']['searchValues']['minBookYear'] ?? '';
$strMaxBookYear = $arrData['params']['searchValues']['maxBookYear'] ?? '';
$strMinBookPage = $arrData['params']['searchValues']['minBookPage'] ?? '';
$strMaxBookPage = $arrData['params']['searchValues']['maxBookPage'] ?? '';
?>

<main class="entry-list">
    <section class="create-search">
        <section class="create-button">
            <a class='create-entry'
               href="<?php echo CONTROLLERs_URL['books'] . 'edit' ?>">Añadir libro</a>
        </section>
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
                            <input type="number" id="minBookId" name="minBookId" value="<?php echo $strMinBookId ?>">
                        </article>
                        <article>
                            <label for="maxBookId">Máximo</label>
                            <input type="number" id="maxBookId" name="maxBookId" value="<?php echo $strMaxBookId ?>">
                        </article>
                    </fieldset>
                </article>
                <article>
                    <label for="bookTitle">Título</label>
                    <input type="text" id="bookTitle" name="bookTitle" value="<?php echo $strBookTitle ?>">
                </article>
                <article>
                    <label for="bookGenre">Género</label>
                    <select id="bookGenre" name="bookGenre">
                        <option value=""> - SELECCIONA GÉNERO LITERARIO -</option>
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
                        <option value=""> - SELECCIONA PAÍS -</option>
                        <?php
                        $arrCountries = $arrData['params']['countries'];
                        foreach ($arrCountries as $country) {
                            ?>
                            <option value="<?php echo $country['PAIS'] ?>"<?php echo $country['PAIS'] === $strBookCountry
                                ? ' selected'
                                : ''; ?>>
                                <?php echo mb_strtoupper($country['PAIS'], 'UTF-8'); ?>
                            </option>
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
                            <input type="number" id="minBookYear" name="minBookYear"
                                   value="<?php echo $strMinBookYear ?>">
                        </article>
                        <article>
                            <label for="maxBookYear">Máximo</label>
                            <input type="number" id="maxBookYear" name="maxBookYear"
                                   value="<?php echo $strMaxBookYear ?>">
                        </article>
                    </fieldset>
                </article>
                <article>
                    <fieldset>
                        <legend>Número de páginas</legend>
                        <article>
                            <label for="minBookPage">Mínimo</label>
                            <input type="number" id="minBookPage" name="minBookPage"
                                   value="<?php echo $strMinBookPage ?>">
                        </article>
                        <article>
                            <label for="maxBookPage">Máximo</label>
                            <input type="number" id="maxBookPage" name="maxBookPage"
                                   value="<?php echo $strMaxBookPage ?>">
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
            <?php
            foreach ($arrData['data'] as $book) {
                $URLToEdit = CONTROLLERs_URL['books'] . 'edit/' . $book['ID_LIBRO'];
                $URLToDelete = CONTROLLERs_URL['books'] . 'confirmDelete/' . $book['ID_LIBRO'];
                ?>
                <section class="element">
                    <h2><?php echo mb_strtoupper($book['TITULO'], 'UTF-8'); ?></h2>
                    <table>
                        <tbody>
                        <tr>
                            <th>ID LIBRO</th>
                            <td><?php echo $book['ID_LIBRO']; ?></td>
                        </tr>
                        <tr>
                            <th>GÉNERO PRINCIPAL</th>
                            <td><?php echo mb_strtoupper($book['GENERO'], 'UTF-8'); ?></td>
                        </tr>
                        <tr>
                            <th>PAÍS</th>
                            <td><?php echo mb_strtoupper($book['PAIS'], 'UTF-8'); ?></td>
                        </tr>
                        <tr>
                            <th>AÑO DE PUBLICACIÓN</th>
                            <td><?php echo $book['ANO']; ?></td>
                        </tr>
                        <tr>
                            <th>NÚMERO DE PÁGINAS</th>
                            <td><?php echo $book['NUM_PAGINAS']; ?></td>
                        </tr>
                        </tbody>
                    </table>
                    <article class="btn-container">
                        <a class="edit-element" href="<?php echo $URLToEdit ?>">Editar</a>
                        <a class="delete-element" href="<?php echo $URLToDelete ?>">Borrar</a>
                    </article>
                </section>
                <?php
            }
            ?>
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