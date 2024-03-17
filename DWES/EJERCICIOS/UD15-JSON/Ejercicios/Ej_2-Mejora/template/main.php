<?php
include './classes/Funcionalities.php';
include './includes/funcion.php';

$strNextPage = 'https://swapi.dev/api/people/';
$id = 1;

do {
    //$arrReturn = getJSON($strNextPage);
    $arrReturn = Functionality::getJSON($strNextPage);

    if ($arrReturn !== null) {
        $strNextPage = $arrReturn['next'];
        $arrCharacters = $arrReturn['results'];

        foreach ($arrCharacters as $character) {
            echo '<tr>';
            echo '<td>' . '#' . $id . '</td>';
            echo '<td>' . $character['name'] . '</td>';
            echo '<td>' . ($character['height'] === 'unknown' ? '-' : $character['height']) . '</td>';
            echo '<td>' . ($character['mass'] === 'unknown' ? '-' : $character['mass']) . '</td>';
            echo '<td>' . ($character['birth_year'] === 'unknown' ? '-' : $character['birth_year']) . '</td>';
            echo '</tr>';
            $id++;
        }
    }
} while($strNextPage !== null);