<?php
$strMinAuthorId = $_SESSION['authorSearch']['minAuthorId'] ?? '';
$strMaxAuthorId = $_SESSION['authorSearch']['maxAuthorId'] ?? '';
$strAuthorFirstName = $_SESSION['authorSearch']['authorFirstName'] ?? '';
$strAuthorLastName = $_SESSION['authorSearch']['authorLastName'] ?? '';
$strAuthorCountry = $_SESSION['authorSearch']['authorCountry'] ?? '';
$strMinAuthorDateOfBirth = $_SESSION['authorSearch']['minAuthorDateOfBirth'] ?? '';
$strMaxAuthorDateOfBirth = $_SESSION['authorSearch']['maxAuthorDateOfBirth'] ?? '';
$strMinAuthorBooks = $_SESSION['authorSearch']['minAuthorBooks'] ?? '';
$strMaxAuthorBooks = $_SESSION['authorSearch']['maxAuthorBooks'] ?? '';
?>

<main class="entry-list">
    <section class="create-search">
        <?php
        if ($_SESSION['userRole'] > 1) {
        ?>
        <section class="create-button">
            <a class='create-entry'
               href="<?php echo CONTROLLERs_URL['authors'] . 'edit' ?>">Añadir autor</a>
        </section>
        <?php
        }
        ?>
    </section>
    <section class="form-search">
        <h3>Búsqueda de autores</h3>
        <form action="<?php echo CONTROLLERs_URL['authors'] . 'list' ?>" method="post">
            <section>
                <article>
                    <fieldset>
                        <legend>Número de ID</legend>
                        <article>
                            <label for="minAuthorId">Mínimo</label>
                            <input type="search" id="minAuthorId" name="minAuthorId"
                                   value="<?php echo $strMinAuthorId ?>">
                        </article>
                        <article>
                            <label for="maxAuthorId">Máximo</label>
                            <input type="search" id="maxAuthorId" name="maxAuthorId"
                                   value="<?php echo $strMaxAuthorId ?>">
                        </article>
                    </fieldset>
                </article>
                <article>
                    <fieldset>
                        <legend>Datos del autor</legend>
                        <article>
                            <label for="authorFirstName">Nombre</label>
                            <input type="search" id="authorFirstName" name="authorFirstName"
                                   value="<?php echo $strAuthorFirstName ?>">
                        </article>
                        <article>
                            <label for="authorLastName">Apellido</label>
                            <input type="search" id="authorLastName" name="authorLastName"
                                   value="<?php echo $strAuthorLastName ?>">
                        </article>
                        <article>
                            <label for="authorCountry">Pais</label>
                            <select id="authorCountry" name="authorCountry">
                                <option value=""> - SELECCIONA PAÍS DE ORIGEN - </option>
                                <?php
                                $arrCountries = $arrData['params']['countries'];
                                foreach ($arrCountries as $country) {
                                    ?>
                                    <option value="<?php echo $country['PAIS_ORIGEN'] ?>"
                                        <?php echo $country['PAIS_ORIGEN'] === $strAuthorCountry
                                            ? ' selected'
                                            : '';?>>
                                        <?php echo mb_strtoupper($country['PAIS_ORIGEN'], 'UTF-8'); ?>
                                    </option>
                                    <?php
                                }
                                ?>
                            </select>
                        </article>
                    </fieldset>
                </article>
            </section>
            <section>
                <article>
                    <fieldset>
                        <legend>Fecha de nacimiento</legend>
                        <article>
                            <label for="minAuthorDateOfBirth">Mínimo</label>
                            <input type="search" id="minAuthorDateOfBirth" name="minAuthorDateOfBirth"
                                   value="<?php echo $strMinAuthorDateOfBirth ?>"
                                   placeholder="AAAA-mm-DD">
                        </article>
                        <article>
                            <label for="maxAuthorDateOfBirth">Máximo</label>
                            <input type="search" id="maxAuthorDateOfBirth" name="maxAuthorDateOfBirth"
                                   value="<?php echo $strMaxAuthorDateOfBirth ?>"
                                   placeholder="AAAA-mm-DD">
                        </article>
                    </fieldset>
                </article>
                <article>
                    <fieldset>
                        <legend>Número de libros publicados</legend>
                        <article>
                            <label for="minAuthorBooks">Mínimo</label>
                            <input type="search" id="minAuthorBooks" name="minAuthorBooks"
                                   value="<?php echo $strMinAuthorBooks ?>">
                        </article>
                        <article>
                            <label for="maxAuthorBooks">Máximo</label>
                            <input type="search" id="maxAuthorBooks" name="maxAuthorBooks"
                                   value="<?php echo $strMaxAuthorBooks ?>">
                        </article>
                    </fieldset>
                </article>
            </section>
            <article>
                <input type="hidden" name="btn-search" value="new-author-search">
                <button>Buscar</button>
            </article>
        </form>
    </section>

    <?php
    if (count($arrData['data']) > 0) {
        ?>
        <section>
            <h3>Resultado de la búsqueda de autores</h3>
            <p><?php echo $arrData['params']['message'] ?></p>
        </section>
        <section class="page-info">
            <?php Functionality::printPages($arrData['params']['paginate'], 'authors'); ?>
            <?php Functionality::printFilterOptions('authors'); ?>
        </section>
        <section>
            <?php Functionality::printInfo($arrData['params']['paginate'], 'autores'); ?>
        </section>
        <section class="elements-section">
            <?php Functionality::printItems($arrData['data'], 'authors'); ?>
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