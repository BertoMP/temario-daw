<?php
$strBookId = $arrData['data']['ID_LIBRO']??'';
$strBookTitle = $arrData['data']['TITULO']??'';
$strBookGender = $arrData['data']['GENERO']??'';
$strBookCountry = $arrData['data']['PAIS']??'';
$strBookYear = $arrData['data']['ANO']??'';
$strBookPages = $arrData['data']['NUM_PAGINAS']??'';
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
    <article>
        <label for="bookTitle">Título</label>
        <input type="text" name="bookTitle" id="bookTitle" value="<?php echo $strBookTitle; ?>">
    </article>
    <article>
        <label for="bookGender">Género principal</label>
        <input type="text" name="bookGender" id="bookGender" value="<?php echo $strBookGender; ?>">
    </article>
    <article>
        <label for="bookCountry">País</label>
        <input type="text" name="bookCountry" id="bookCountry" value="<?php echo $strBookCountry; ?>">
    </article>
    <article>
        <label for="bookYear">Año de publicación</label>
        <input type="number" name="bookYear" id="bookYear" max="2024" value="<?php echo $strBookYear; ?>">
    </article>
    <article>
        <label for="bookPages">Páginas del libro</label>
        <input type="number" name="bookPages" id="bookPages" value="<?php echo $strBookPages; ?>">
    </article>
    <article>
        <button type="submit"><?php echo (empty($strBookId)) ? 'Añadir ' : 'Editar '; ?> libro</button>
        <a href="<?php echo CONTROLLERs_URL['books'] . 'list' ?>"><button type="button">Volver al listado</button></a>
    </article>
    </form>
</main>
