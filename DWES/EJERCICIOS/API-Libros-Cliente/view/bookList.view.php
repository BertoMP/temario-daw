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
    <?php
    if (count($arrData['data']['results']) > 0) {
        ?>
        <section class="page-info">
            <?php Functionality::printPages($arrData['data']['count'], 'books'); ?>
        </section>
        <section class="elements-section">
            <?php Functionality::printItems($arrData['data']['results'], 'books'); ?>
        </section>
        <?php
    } else {
        ?>
        <section>
            <p>No existen resultados.</p>
        </section>
        <?php
    }
    ?>
</main>