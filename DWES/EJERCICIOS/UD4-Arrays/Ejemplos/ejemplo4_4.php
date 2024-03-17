<html>
    <head></head>
    <body>
        <?php
            $intNotas = ['Pepe' => 5,
                         'Maria' => 7,
                         'Juan' => 9];

            echo 'notas: ';
            print_r($intNotas);
            $intNotas['Maria']=8;
            unset($intNotas['Pepe']);
            $intNotas['Ana']=6;
            echo '<br />notas: ';
            print_r($intNotas);
            
        ?>
    </body>
</html>
