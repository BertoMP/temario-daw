
<?php
    // esta función se podria sacar a un fichero a incluir
    function noNulo(array $strArray): bool{ 
        $blnDevuelve = true;
        foreach($strArray as $key=>$strValor)
            if($strArray[$key]==''){
                $blnDevuelve = false;
                break;
            }
        return $blnDevuelve;
    }
    $titulo = "12_4";
    //include("../general/cabecera.inc.php");
    session_start();
    
    if (noNulo($_REQUEST)){
        echo "<ul>";
        
        foreach($_SESSION as $key=>$value)
            echo "<li>$key: $value</li>";
        foreach($_REQUEST as $key=>$value){
            if($key!='enviar'){
                echo "<li>$key: ";   
                if(!is_array($value))
                    echo "$value";
                else{
                    echo "<ul>";
                    foreach($value as $strValor)
                        echo "<li>$strValor</li>";
                    echo "</ul>";
                }
                echo "</li>";
            }

        }
        echo "</ul>";
    }else
        header("Location:pagina2.php?mensaje=vacios");
    session_destroy();
  //include("../general/pie.inc.html"); // poner al final
?>
<form action="12_4.php">
    <input type="submit" name="enviar" value="Volver">
</form>