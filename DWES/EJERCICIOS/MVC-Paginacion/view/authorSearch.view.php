<main class="entry-list">
    <section class="create-search">
        <section class="create-button">
            <a class='create-entry'
               href="<?php echo CONTROLLERs_URL['authors'] . 'list'; ?>">Volver al listado</a>
        </section>
        <section class="search">
            <form action="<?php echo CONTROLLERs_URL['authors'] . 'search'; ?>" method="post">
                <label for="searchQuery">Búsqueda:</label>
                <input type="text" name="searchQuery" id="searchQuery">
                <button type="submit">Buscar</button>
            </form>
        </section>
    </section>

    <?php
    if (isset($arrData['params']['error'])) {
        ?>
        <section>
            <p><?php echo $arrData['params']['error']; ?></p>
        </section>
        <?php
    } else {
        if (count($arrData['data']) > 0) {
            ?>
            <section>
                <p>
                    Se han encontrado <?php echo $arrData['params']['totalResults']; ?>
                    <?php echo $arrData['params']['totalResults'] > 1 ? 'resultados' : 'resultado'; ?> parcialmente
                    <?php echo $arrData['params']['totalResults'] > 1 ? 'coincidentes' : 'coincidente'; ?> para la búsqueda:
                    "<?php echo $arrData['params']['searchQuery']; ?>".
                </p>
            </section>
            <section class="elements-section">
                <?php Functionality::printItems($arrData['data'], 'authors') ?>
            </section>
            <?php
        } else {
            ?>
            <section>
                <p>No existen resultados para la búsqueda: "<?php echo $arrData['params']['searchQuery']; ?>"</p>
            </section>
            <?php
        }
    }
    ?>
</main>