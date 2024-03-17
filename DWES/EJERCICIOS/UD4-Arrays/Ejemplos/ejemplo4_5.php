<html>
    <head></head>
    <body>
        <?php
            $arrAlumnos = ['Pepe' => [
                                        'curso' => 'DAM2',
                                        'notas' => [3,6,9]
                            ],
                            'Maria'  => [
                                'curso' => 'DAM2',
                                'notas' => [7,5,6]
                            ]
                          ];

            echo 'Alumnos: ';
            print_r($arrAlumnos);
            $arrAlumnos['Maria']['notas'][1]=8;
            echo '<br />Alumnos: ';
            print_r($arrAlumnos);
        ?>
    </body>
</html>
