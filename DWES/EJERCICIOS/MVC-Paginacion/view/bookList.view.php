<main class="entry-list">
    <section class="create-search">
        <section class="create-button">
            <a class='create-entry'
               href="<?php echo CONTROLLERs_URL['books'] . 'edit' ?>">Añadir libro</a>
        </section>
        <section class="search">
            <form action="<?php echo CONTROLLERs_URL['books'] . 'search' ?>" method="post">
                <label for="searchQuery">Búsqueda:</label>
                <input type="text" name="searchQuery" id="searchQuery">
                <button type="submit">Buscar</button>
            </form>
        </section>
    </section>

    <?php
    if (count($arrData['data']) > 0) {
    ?>
    <section class="page-info">
        <?php Functionality::printPages($arrData['params'], 'books'); ?>
        <?php Functionality::printFilterOptions('books'); ?>
    </section>
    <section>
        <?php Functionality::printInfo($arrData['params'], 'libros'); ?>
    </section>
    <section class="elements-section">
        <?php Functionality::printItems($arrData['data'], 'books'); ?>
    </section>
    <?php
    } else {
    ?>
    <section>
        <p>Actualmente, no hay libros registrados.</p>
    </section>
    <?php
    }
    ?>
</main>