<main class="confirm-delete">
    <?php
    if (empty($arrData['data'])) {
    ?>
        <article class="alert">
            <p>No ha seleccionado un libro de forma correcta.</p>
            <a href="<?php echo CONTROLLERs_URL['books'] . 'list'; ?>">Volver al listado</a>
        </article>
    <?php
    } else {
        $strBookTitle = mb_strtoupper($arrData['data']['TITULO'], 'UTF-8');
    ?>
    <form method="post"
          action="<?php echo CONTROLLERs_URL['books'] . 'delete'; ?>">
        <input type="hidden" name="bookId" value="<?php echo $arrData['data']['ID_LIBRO']; ?>">

        <article class="alert">
            <p>¿Confirma que desea eliminar este libro?</p>
            <p><?php echo $strBookTitle ?></p>
        </article>

        <article>
            <button type="submit" class="btn-delete">Eliminar</button>
            <a href="<?php echo CONTROLLERs_URL['books'] . 'list'; ?>"><button type="button">Cancelar</button></a>
        </article>
    </form>
    <?php
    }
    ?>
</main>