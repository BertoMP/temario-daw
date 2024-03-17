<?php
$strAuthorId = $arrData['data']['ID_PERSONA']??'';
$strAuthorFirstName = $arrData['data']['NOMBRE']??'';
$strAuthorLastName = $arrData['data']['APELLIDO']??'';
$strAuthorBirthDate = $arrData['data']['FECHA_NACIMIENTO']??'';
$strAuthorCountry = $arrData['data']['PAIS_ORIGEN']??'';
$strAuthorBooks = $arrData['data']['LIBROS_PUBLICADOS']??'';
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
                    <?php echo isset($arrData['params']['isAuthorCreation']) ? 'Creación ' : 'Edición ' ?>
                    realizada correctamente.
                </p>
                <?php
            }
            ?>
            <a href="<?php echo CONTROLLERs_URL['authors'] . 'list'; ?>">Volver al listado</a>
        </section>
        <?php
    }
    ?>
    <form method="post"
          action="<?php echo CONTROLLERs_URL['authors'] . 'save'
              . ((!empty($strAuthorId)) ? '/' . $strAuthorId : ''); ?>">
        <input type="hidden" name="authorId" value="<?php echo $strAuthorId; ?>">
        <article>
            <label for="authorFirstName">Nombre</label>
            <input type="text" name="authorFirstName" id="authorFirstName" value="<?php echo $strAuthorFirstName; ?>">
        </article>
        <article>
            <label for="authorLastName">Apellido</label>
            <input type="text" name="authorLastName" id="authorLastName" value="<?php echo $strAuthorLastName; ?>">
        </article>
        <article>
            <label for="authorBirthDate">Fecha nacimiento (AAAA-MM-DD)</label>
            <input type="text" name="authorBirthDate" id="authorBirthDate" value="<?php echo $strAuthorBirthDate; ?>">
        </article>
        <article>
            <label for="authorCountry">País</label>
            <input type="text" name="authorCountry" id="authorCountry" value="<?php echo $strAuthorCountry; ?>">
        </article>
        <article>
            <label for="authorBooks">Cantidad de libros publicados</label>
            <input type="number" name="authorBooks" id="authorBooks" value="<?php echo $strAuthorBooks; ?>">
        </article>
        <article>
            <button type="submit"><?php echo (empty($strAuthorId)) ? 'Añadir ' : 'Editar '; ?>autor</button>
            <a href="<?php echo CONTROLLERs_URL['authors'] . 'list' ?>">
                <button type="button">Volver al listado</button>
            </a>
        </article>
    </form>
</main>
