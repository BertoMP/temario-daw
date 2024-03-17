<?php
$objCurl = curl_init();
$strNextPage = 'https://swapi.dev/api/people/';
$id = 1;

do {
    curl_setopt($objCurl, CURLOPT_URL, $strNextPage);
    curl_setopt($objCurl, CURLOPT_RETURNTRANSFER, 1);

    $strJSON = curl_exec($objCurl);

    if (curl_errno($objCurl)) {
        echo 'Error en la solicitud cURL: ' . curl_error($objCurl);
    } else {
        $arrPages = json_decode($strJSON, true);
        $arrCharacters = $arrPages['results'];

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

        $strNextPage = $arrPages['next'];
    }
} while($strNextPage !== null);

curl_close($objCurl);