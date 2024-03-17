<html>
    <head></head>
    <body>
        <?php
            for($intCont=0; $intCont<10; $intCont++)
                echo rand(2,15) . ' ';

            echo '<br />'; 
            $intArray = range(2,13,0.5);
            print_r($intArray);
            
            echo '<br />'; 
            $intArray = range(10,3,0.5);
            print_r($intArray);
            
            echo '<br />'; 
            $intArray = range('a','jc',2);
            print_r($intArray);

            $strArray = ['uno', 'dos', 'tres'];
            echo '<br />¿está uno en el array? '. ((in_array('uno', $strArray))==null?'false':'true');
            echo '<br />¿está cuatro en el array? '. ((in_array('cuatro', $strArray))==null?'false':'true') ;
            
            echo '<br /> array desordenado: ';
            print_r($strArray);
            sort($strArray);
            echo '<br /> array ordenado: ';
            print_r($strArray);
            $strArray = ['foto1', 'foto10', 'foto2', 'foto3','foto7','foto21'];
            sort($strArray);
            echo '<br /> array ordenado como cadena: ';
            print_r($strArray);
            $strArray = ['foto1', 'foto10', 'foto2', 'foto3','foto7','foto21'];
            sort($strArray, SORT_NATURAL);
            echo '<br /> array ordenado de forma natural: ';
            print_r($strArray);
        ?>
    </body>
</html>
