<?php
include_once 'config/config.php';
include_once 'handler/Handler.php';
include_once 'model/Database.model.php';

header('Content-Type: application/json; charset=utf-8');

$objHandler = new Handler();

$strHandlerTable = $objHandler->getTable();
$arrHandlerParams = $objHandler->getParams();

$filePath = 'model/' . $strHandlerTable . '.model.php';

if (file_exists($filePath)) {
    include_once $filePath;

    $objModel = new $strHandlerTable();
    $response = $objModel->getItems($arrHandlerParams);

    echo json_encode($response, JSON_UNESCAPED_UNICODE);
} else {
    echo json_encode(ERROR, JSON_UNESCAPED_UNICODE);
}