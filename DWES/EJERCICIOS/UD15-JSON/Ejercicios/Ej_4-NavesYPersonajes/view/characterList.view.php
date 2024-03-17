<?php
$prevPage = $arrData['params']['previous'];
$nextPage = $arrData['params']['next'];
$actualPage = (int)$arrData['params']['actualPage'];
$count = $arrData['params']['count'];

$numberPages = (int)ceil($count / NUMBER_CHARACTERS);

$arrFields = ['NOMBRE', 'ALTURA', 'PESO', 'NACIMIENTO', 'MÁS INFORMACIÓN'];

$minCharacter = $actualPage * NUMBER_CHARACTERS - (NUMBER_CHARACTERS - 1);
$maxCharacter = ($actualPage === $numberPages) ? $count : $actualPage * NUMBER_CHARACTERS;

?>

<main class="character-list">
    <section>
        <a href="<?php echo CONTROLLERs_URL['characters'] . 'list/' . $prevPage ?>">
            <button type="button" <?php echo ($prevPage === null) ? 'disabled' : ''?>>Anterior</button>
        </a>

        <?php
        for ($intCont = 1; $intCont <= $numberPages; $intCont++) {
            ?>
            <a href="<?php echo CONTROLLERs_URL['characters'] . 'list/' . $intCont ?>">
                <button type="button" <?php echo ($actualPage === $intCont) ? 'disabled' : ''?>>
                    <?php echo $intCont ?>
                </button>
            </a>
            <?php
        }
        ?>
        <a href="<?php echo CONTROLLERs_URL['characters'] . 'list/' . $nextPage ?>">
            <button type="button" <?php echo ($nextPage === null) ? 'disabled' : ''?>>Siguiente</button>
        </a>
    </section>
    <section class="info">
        <p>Página <?php echo $actualPage ?> de <?php echo $numberPages ?></p>
        <p>Mostrando <?php echo NUMBER_CHARACTERS ?> personajes por página.</p>
        <p>Personajes <?php echo $minCharacter; ?> al <?php echo $maxCharacter ?> de <?php echo $count ?> personajes</p>
    </section>
    <section>
        <table>
            <thead>
            <tr>
                <?php foreach ($arrFields as $field): ?>
                    <th scope="col"><?php echo $field ?></th>
                <?php endforeach; ?>
            </tr>
            </thead>
            <tbody>
            <?php foreach ($arrData['data'] as $character): ?>
                <tr>
                    <td>
                        <?php echo $character['name'] ?>
                    </td>
                    <td>
                        <?php echo ($character['height'] === 'unknown')
                            ? '-'
                            : ($character['height'] / 100) . 'm' ?>
                    </td>
                    <td>
                        <?php echo ($character['mass'] === 'unknown')
                            ? '-'
                            : $character['mass'] . 'kg' ?>
                    </td>
                    <td>
                        <?php echo ($character['birth_year'] === 'unknown')
                            ? '-'
                            : $character['birth_year'] ?>
                    </td>
                    <td>
                        <a href="<?php echo CONTROLLERs_URL['characters'] . 'info/' . $character['id'] ?>">Ver más</a>
                    </td>
                </tr>
            <?php endforeach; ?>
            </tbody>
        </table>
    </section>
</main>