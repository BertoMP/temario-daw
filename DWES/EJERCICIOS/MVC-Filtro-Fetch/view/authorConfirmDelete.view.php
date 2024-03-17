<main class="confirm-delete">
    <?php
    if (empty($arrData['data'])) {
    ?>
    <article class="alert">
        <p>No ha seleccionado un autor de forma correcta.</p>
        <a href="<?php echo CONTROLLERs_URL['authors'] . 'list'; ?>">Volver al listado</a>
    </article>
    <?php
    } else {
        $strAuthorCompleteName = mb_strtoupper(
                $arrData['data']['NOMBRE'] . ' ' . $arrData['data']['APELLIDO'],
                'UTF-8'
        );
        ?>
        <form method="post" action="<?php echo CONTROLLERs_URL['authors'] . 'delete'; ?>">
            <input type="hidden" name="authorId" value="<?php echo $arrData['data']['ID_PERSONA']; ?>">
            <article class="alert">
                <p>¿Confirma que desea eliminar a este autor?</p>
                <p><?php echo $strAuthorCompleteName; ?></p>
            </article>
            <article>
                <button type="submit" class="btn-delete">Eliminar</button>
                <a href="<?php echo CONTROLLERs_URL['authors'] . 'list'; ?>">
                    <button type="button">Cancelar</button
                </a>
            </article>
        </form>
        <?php
    }
    ?>
</main>