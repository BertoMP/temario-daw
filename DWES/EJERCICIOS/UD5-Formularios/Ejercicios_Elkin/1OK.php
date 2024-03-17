<html>
    <body>
        <table border="1">
            <?php
                foreach($_REQUEST as $key=>$valor){
                    echo "<tr><td>$key</td><td>";
                    if(!is_array($valor))
                        echo $valor;
                    else
                         foreach ($valor as $strElemento)
                            echo "$strElemento ";
                    
                    echo "</td></tr>";
                }
            ?>
        </table> 
    </body>
</html>