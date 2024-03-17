<?php
$strId = $arrData['data']['id'];
$strName = $arrData['data']['name'];
$arrSpecies = $arrData['data']['species'] ?? [];
$strHairColor = ($arrData['data']['hair_color'] === 'n/a')
    ? 'No tiene pelo'
    : $arrData['data']['hair_color'];
$strSkinColor = ($arrData['data']['skin_color'] === 'unknown')
    ? 'Color de piel desconocido'
    : $arrData['data']['skin_color'];
$strEyeColor = ($arrData['data']['eye_color'] === 'unknown')
    ? 'Color de ojos desconocido'
    : $arrData['data']['eye_color'];
$arrStarships = $arrData['data']['starships'] ?? [];
$arrVehicles = $arrData['data']['vehicles'] ?? [];
$arrFilms = $arrData['data']['films'] ?? [];
$strHomeWorld = $arrData['data']['homeworld'];
?>

<main class="character-info">
    <a href="<?php echo INDEX_URL ?>">Volver atrás</a>
    <table>
        <tr>
            <td colspan="2">
                <img src="<?php echo IMG_URL . $strId . '.jpg' ?>" alt="Foto">
            </td>
        </tr>
        <tr>
            <th scope="row">NOMBRE</th>
            <td><?php echo $strName ?></td>
        </tr>
        <tr>
            <th scope="row">ESPECIES</th>
            <td>
                <?php
                if (count($arrSpecies) > 0): ?>
                    <ul>
                        <?php foreach ($arrSpecies as $species): ?>
                            <li><?php echo $species; ?></li>
                        <?php endforeach; ?>
                    </ul>
                <?php else: ?>
                    Human
                <?php endif; ?>
            </td>
        </tr>
        <tr>
            <th scope="row">COLOR DE PELO</th>
            <td><?php echo $strHairColor ?></td>
        </tr>
        <tr>
            <th scope="row">COLOR DE PIEL</th>
            <td><?php echo $strSkinColor ?></td>
        </tr>
        <tr>
            <th scope="row">COLOR DE OJOS</th>
            <td><?php echo $strEyeColor ?></td>
        </tr>
        <tr>
            <th scope="row">NAVES PILOTADAS</th>
            <td>
                <?php if (count($arrStarships) > 0): ?>
                    <ul>
                        <?php foreach ($arrStarships as $starship): ?>
                            <li><?php echo $starship; ?></li>
                        <?php endforeach; ?>
                    </ul>
                <?php else: ?>
                    No se conocen naves pilotadas.
                <?php endif; ?>
            </td>
        </tr>
        <tr>
            <th scope="row">VEHÍCULOS PILOTADOS</th>
            <td>
                <?php
                if (count($arrVehicles) > 0): ?>
                    <ul>
                        <?php foreach ($arrVehicles as $vehicle): ?>
                            <li><?php echo $vehicle; ?></li>
                        <?php endforeach; ?>
                    </ul>
                <?php else: ?>
                    No se conocen vehículos pilotados.
                <?php endif; ?>
            </td>
        </tr>
        <tr>
            <th scope="row">PLANETA DE ORIGEN</th>
            <td><?php echo $strHomeWorld ?></td>
        </tr>
        <tr>
            <th scope="row">PELÍCULAS</th>
            <td>
                <?php if (count($arrFilms) > 0): ?>
                    <ul>
                        <?php foreach ($arrFilms as $film): ?>
                            <li><?php echo $film; ?></li>
                        <?php endforeach; ?>
                    </ul>
                <?php else: ?>
                    No aparece en ninguna película.
                <?php endif; ?>
            </td>
        </tr>
    </table>
</main>