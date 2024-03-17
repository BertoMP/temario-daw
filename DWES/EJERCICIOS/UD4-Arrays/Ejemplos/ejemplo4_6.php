<html>
    <head></head>
    <body>
        <?php
            $arrAlumnosDos = ['Pepe', 'Maria', 'Juan', 'Ana'];

            foreach($arrAlumnosDos as $strAlumno)
                          echo $strAlumno . ", ";
            echo '<br /><br />';
            
            $arrAlumnosDos = ['Pepe'=>5, 'Maria'=>7, 'Juan'=>9, 'Ana'=>6];
            foreach($arrAlumnosDos as $strAlumno => $strNota)
                          echo $strAlumno . " " . $strNota . ", ";
            echo '<br /><br />';

            foreach($arrAlumnos as $arrAlumno){
                echo "nombre: " . $arrAlumno['nombre'] . ' Curso: ' . $arrAlumno['curso'] . '<br />&nbsp;&nbsp;&nbsp;notas: ';
                foreach($arrAlumno['notas'] as $intNota)
                    echo $intNota . ', ';
                
                    echo '<br />';
            }
        ?>
    </body>
</html>
