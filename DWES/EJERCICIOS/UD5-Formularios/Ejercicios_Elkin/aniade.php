<html>

<body>
    
            <?php
                $strArrValores=isset($_REQUEST['valores']) ? explode(':',$_REQUEST['valores']) : '';

                $intMedia=0;
                for($intIndice=1; $intIndice<count($strArrValores); $intIndice+=2){
                    $intMedia+=$strArrValores[$intIndice+1];
                    echo $strArrValores[$intIndice] . " " . $strArrValores[$intIndice+1] . "<br />";
                }

                echo "Media: " . ($intMedia/((count($strArrValores)-1)/2));
            ?>

</body>

</html>