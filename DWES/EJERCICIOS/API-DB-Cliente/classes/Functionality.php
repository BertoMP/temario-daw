<?php

abstract class Functionality
{
    public static function getJSON($url): array|null
    {
        $objCurl = curl_init();
        $arrReturn = null;

        curl_setopt($objCurl, CURLOPT_URL, $url);
        curl_setopt($objCurl, CURLOPT_RETURNTRANSFER, 1);

        $strJSON = curl_exec($objCurl);

        if (curl_errno($objCurl)) {
            echo 'Error';
        } else {
            $httpCode = curl_getinfo($objCurl, CURLINFO_HTTP_CODE);

            if ($httpCode === 200) {
                $arrReturn = json_decode($strJSON, true);
            }
        }
        curl_close($objCurl);

        return $arrReturn;
    }
}