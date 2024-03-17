<?php
    echo "<form method=\"get\"><style>a.fich{color: black;}a{color: blue;}</style>";
    $strUbicacion = isset($_GET["dir"])?$_GET["dir"]:getcwd();
    echo "<b>$strUbicacion</b><br />";
    chdir($strUbicacion);
    //muestra el fichero si existe
    if(isset($_GET["fichero"])){
        echo '<pre>';
        readfile($_GET["fichero"]);
        echo '</pre>';
    }
    $strArrListado=scandir($strUbicacion);
    foreach($strArrListado as $strValor)
        if(is_file($strValor))
            echo "<a class=\"fich\" href=\"9_2.php?dir=$strUbicacion&fichero=$strValor\">$strValor</a> <br />";
        else if($strValor=='.')
                echo "<a href=\"9_2.php?dir=$strUbicacion\">$strValor</a> <br />";
             else if($strValor=='..'){
                    $strUbicacionAux = substr($strUbicacion,0,(strrpos($strUbicacion,'\\')));
                    echo "<a href=\"9_2.php?dir=$strUbicacionAux\">$strValor</a> <br />";
                  }else{
                    echo "<a href=\"9_2.php?dir=$strUbicacion\\$strValor\">$strValor</a> <br />";
                    echo "<input type=\"submit\" formaction=\"9_2.php?dir=$strUbicacion\\$strValor\">$strValor</button><br />";
                   }

?>