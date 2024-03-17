<?php
abstract class Functionality {
    public static function getJSON($page): array | null {
        $objCurl = curl_init();
        $arrReturn = null;

        curl_setopt($objCurl, CURLOPT_URL, $page);
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

    public static function includeAll(): void
    {
        include_once 'config/config.php';
        include_once 'handler/Handler.php';
        include_once 'controller/Controller.php';
        include_once 'model/Character.model.php';
        include_once 'model/Film.model.php';
        include_once 'model/Planet.model.php';
        include_once 'model/Species.model.php';
        include_once 'model/Starship.model.php';
        include_once 'model/Vehicle.model.php';
        include_once 'view/View.php';
    }
}