<?php
/**
 * Genera un string de etiquetas HTML con contenido a partir del array recibido por parámetro.
 * En el caso de que el array esté vacío, devuelve un mensaje predeterminado.
 * @param array $parameters - El array a convertir en string.
 * @return string - Devuelve un string con etiquetas HTML.
 */
function printParameters(array $parameters): string {
    $htmlToReturn = '';

    if (count($parameters) > 0) {
        $htmlToReturn .= '<ul>';

        foreach ($parameters as $index => $parameter) {
            $htmlToReturn .= '<li>' . $index . ': ' . $parameter . '</li>';
        }

        $htmlToReturn .= '</ul>';
    } else {
        $htmlToReturn .= 'No se han determinado parámetros.';
    }

    return $htmlToReturn;
}