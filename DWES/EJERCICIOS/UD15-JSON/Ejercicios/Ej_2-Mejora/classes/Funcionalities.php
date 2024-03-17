<?php
class Funcionalities {
    public static function getJSON($page) {
        $objCurl = curl_init();
        $arrReturn = null;

        curl_setopt($objCurl, CURLOPT_URL, $page);
        curl_setopt($objCurl, CURLOPT_RETURNTRANSFER, 1);

        $strJSON = curl_exec($objCurl);

        if (curl_errno($objCurl)) {
            echo 'Error';
        } else {
            $arrReturn = json_decode($strJSON, true);
        }
        curl_close($objCurl);
        return $arrReturn;
    }
}