<html>
    <head></head>
    <body>
            <?php
                for($intCont=0;$intCont<20;$intCont++)
                    $intArray[]=rand(0,100);
                
                print_r($intArray);
                
                $intFin=count($intArray)-1;
               $intInicio=0;
                echo "$intInicio<$intFin";
                while($intInicio<$intFin){
                    for(;$intInicio<$intFin && $intArray[$intFin]%2==1;$intFin--);
                    for(;$intInicio<$intFin && $intArray[$intInicio]%2==0;$intInicio++);
                    if($intInicio<$intFin){
                        $intAux=$intArray[$intFin];
                        $intArray[$intFin]=$intArray[$intInicio];
                        $intArray[$intInicio]= $intAux;
                    }
                }
                echo "<br />";
                print_r($intArray);

            ?>
    </body>
</html>
