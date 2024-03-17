<?php
    //Valida que sea una ip, que sea ipv4 y que no sea una ip privada
    echo "IP<br />";
    $strArrIp =['10.11.12.13', '127.0.0.1', '192.168.0.1', '160.168.0.1', '172.16.0.1', '125,226,227,228'];
    foreach($strArrIp as $strIp)
        if(filter_var($strIp, FILTER_VALIDATE_IP, FILTER_FLAG_IPV4 | FILTER_FLAG_NO_PRIV_RANGE)) 
        echo "$strIp es true<br />";
        else
        echo "$strIp es false<br />";
    
    //Valida que sea un número real que esté entre 0 y 100
    echo "<br />Real<br />";
    $array =['22', 100, 22.3, -1, 'hola'];
    foreach($array as $valor)
        if(filter_var($valor, FILTER_VALIDATE_FLOAT, ["options" => ["min_range" => 0 , "max_range"=> 100]])) 
            echo "$valor es true<br />";
        else
            echo "$valor es false<br />";

    
    //Valida array
    echo "<br />Array<br />";
    $arrDatos = ['intId'=>1234, 'strDireccion'=> '192.168.0.1', 'intEdad'=>'Hola'];
        
    $arrConstantes = ['intId' => FILTER_VALIDATE_INT,
                'strDireccion'   => FILTER_VALIDATE_IP,
                'intEdad' => FILTER_VALIDATE_INT,
                'nombre' => FILTER_VALIDATE_INT];
        
    $arrDevoluciones = filter_var_array($arrDatos, $arrConstantes);
    foreach($arrDevoluciones as $clave=>$valor)
        if($valor!=null && $valor!=false) 
            echo "$valor es true<br />";
        else
            echo "$clave es false o no existe<br />"; 
?>