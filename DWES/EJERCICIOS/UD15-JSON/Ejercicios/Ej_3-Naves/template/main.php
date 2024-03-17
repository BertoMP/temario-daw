<?php
include './classes/Funcionalities.php';
include './includes/funcion.php';

$strNextPage = 'https://swapi.dev/api/people/';
$id = 1;

do {
    $arrReturn = Functionality::getJSON($strNextPage);

    if ($arrReturn !== null) {
        $strNextPage = $arrReturn['next'];
        $arrCharacters = $arrReturn['results'];

        foreach ($arrCharacters as $character) {
            echo '<tr>';
            echo '<td>' . '#' . $id . '</td>';
            echo '<td>' . $character['name'] . '</td>';
            $arrStarshipsUrl = $character['starships'];
            if (count($arrStarshipsUrl) > 0) {
                echo '<td><ul>';
                foreach ($arrStarshipsUrl as $starshipUrl) {
                    $arrStarshipReturn = Functionality::getJSON($starshipUrl);
                    echo '<li>' . $arrStarshipReturn['name'] . '</li>';
                }
                echo '</td>';
            } else {
                echo '<td>No utiliza naves</td>';
            }

            $homeworldUrl = $character['homeworld'];
            $arrHomeworld = Functionality::getJSON($homeworldUrl);
            echo '<td>' . ($arrHomeworld['name'] === 'unknown' ? 'Desconocido' : $arrHomeworld['name']) . '</td>';
            $id++;
        }
    }
} while($strNextPage !== null);