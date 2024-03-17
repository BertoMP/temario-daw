<?php
$strBookId = $arrData['data']['ID_LIBRO']??'';
$strBookTitle = $arrData['data']['TITULO']??'';
$strBookGender = $arrData['data']['GENERO']??'';
$strBookCountry = $arrData['data']['PAIS']??'';
$strBookYear = $arrData['data']['ANO']??'';
$strBookPages = $arrData['data']['NUM_PAGINAS']??'';
$strBookAuthor = $arrData['data']['ID_PERSONA']??'';
?>
<main class="edit-create-form">
    <?php
    if (isset($arrData['params']['response']) and $arrData['params']['response'] === true) {
    ?>
        <section>
            <?php
            if (isset($arrData['params']['emptyData']) and $arrData['params']['emptyData'] === true) {
            ?>
            <p>No puedes introducir datos vacíos o no válidos.</p>
            <?php
            } else {
            ?>
            <p>
                <?php echo isset($arrData['params']['isBookCreation']) ? 'Creación ' : 'Edición ' ?>
                realizada correctamente.
            </p>
            <?php
            }
            ?>
            <a href="<?php echo CONTROLLERs_URL['books'] . 'list'; ?>">Volver al listado</a>
        </section>
    <?php
    }
    ?>
    <form method="post"
          action="<?php echo CONTROLLERs_URL['books'] . 'save'
              . ((!empty($strBookId)) ? '/' . $strBookId : ''); ?>">
    <input type="hidden" name="bookId" value="<?php echo $strBookId; ?>">
    <input type="hidden" name="authorId" value="<?php echo $strBookAuthor; ?>">
    <article>
        <label for="bookTitle">Título</label>
        <input type="search" name="bookTitle" id="bookTitle"
               value="<?php echo mb_strtoupper($strBookTitle, 'UTF-8'); ?>">
    </article>
    <article>
        <label for="bookGender">Género principal</label>
        <input type="search" name="bookGender" id="bookGender"
               value="<?php echo mb_strtoupper($strBookGender, 'UTF-8'); ?>">
    </article>
    <article>
        <label for="bookAuthor">Autor</label>
        <select name="bookAuthor" id="bookAuthor" multiple>
            <option value=""> - SELECCIONE UN AUTOR - </option>
            <?php
            $arrAuthors = $arrData['params']['authors'];
            foreach ($arrAuthors as $author) {
            ?>
                <option value="<?php echo $author['ID_PERSONA']; ?>"
                <?php echo $author['ID_PERSONA'] === $strBookAuthor ? ' selected' : '' ?>>
                    <?php echo mb_strtoupper($author['APELLIDO'], 'UTF-8')
                        . ', ' . mb_strtoupper($author['NOMBRE'], 'UTF-8'); ?>
                </option>
            <?php
            }
            ?>
        </select>
    </article>
    <article>
        <label for="bookCountry">País</label>
        <input type="search" name="bookCountry" id="bookCountry"
               value="<?php echo mb_strtoupper($strBookCountry, 'UTF-8'); ?>">
    </article>
    <article>
        <label for="bookYear">Año de publicación</label>
        <input type="search" name="bookYear" id="bookYear" max="2024" value="<?php echo $strBookYear; ?>">
    </article>
    <article>
        <label for="bookPages">Páginas del libro</label>
        <input type="search" name="bookPages" id="bookPages" value="<?php echo $strBookPages; ?>">
    </article>
    <article>
        <button type="submit"><?php echo (empty($strBookId)) ? 'Añadir ' : 'Editar '; ?> libro</button>
        <a href="<?php echo CONTROLLERs_URL['books'] . 'list' ?>"><button type="button">Volver al listado</button></a>
    </article>
    </form>
</main>
