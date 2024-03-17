<?php
    // esto es lo que se suele encontrar
    // Obtener la URI después del dominio
    $strDominio = "http://{$_SERVER['SERVER_NAME']}";
    $strUri = "{$strDominio}{$_SERVER['REQUEST_URI']}";
    
    // ejemplo para enterder el parse_url
    $arrParseUrl = parse_url('http://usuario:password@host:8080/ruta/programa?varible1=valor1&varible2=valor2#ancla');
    print_r($arrParseUrl);

    // Parsear la URI usando parse_url
    $arrParseUrl = parse_url($strUri);

    // Obtener la ruta de la URI ['path'] es el indicador del php que vamos a ejecutar
    // se podrían coger más valores entendiendo que la uri es del tipo http://usuario:password@host:puerto/programa?varible=valor#ancla como:
    // protocolo ['scheme'] host ["host"] puerto ["port"] usuario ["user"] password ["pass"] 
    // parámetros ["query"] posición ["fragment"] 
    $strRuta = $arrParseUrl['path']; 

    // Obtener el último segmento de la ruta usando basename
    $strUltimoSegmento = basename($strUri);

    echo "<br /><br />uri: $strUri ruta: $strRuta último segmento:$strUltimoSegmento <br />";
    print_r($arrParseUrl);echo'<br>';

    // solución mía
    //monto el dominio entendiendo que he llamado con http
    echo "<br>";
    $arrUrl = explode("/",$_SERVER['REQUEST_URI']);
    print_r($arrUrl);
    $intCont=0;
    for(; $arrUrl[$intCont]!='14_4.php' && $intCont<count($arrUrl); $intCont++);
    
    for($intCont2=1; $intCont<count($arrUrl); $intCont++, $intCont2++)
        echo "Elemento $intCont2: $arrUrl[$intCont] <br />";
?>