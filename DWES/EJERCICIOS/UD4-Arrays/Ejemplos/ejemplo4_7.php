<html>
    <head></head>
    <body>
        <?php
             $arrAlumnosUno = ['Pepe', 'Maria', 'Juan', 'Ana'];
             $arrAlumnosDos = ['Raul', 'Sol', 'Jose', 'Lola', 'Carlos', 'Sara'];
             $arrAlumnosTres = $arrAlumnosUno + $arrAlumnosDos;
             echo 'Operador + <br /> arrAlumnosUno: ';
             print_r($arrAlumnosUno);
             echo '<br />arrAlumnosDos: ';
             print_r($arrAlumnosDos);
             echo '<br />arrAlumnosTres:  ';
             print_r($arrAlumnosTres);
             echo '<br /> arrAlumnosDos:';
             unset($arrAlumnosDos[3]);
             $arrAlumnosDos[3] = 'Margarita';
             print_r($arrAlumnosDos);
             unset($arrAlumnosUno[1]);
             unset($arrAlumnosUno[2]);
             $arrAlumnosUno[2]='Kevin';
             echo '<br /> arrAlumnosUno: ';
             print_r($arrAlumnosUno);
             echo '<br /> arrAlumnosTres: ';
             $arrAlumnosTres = $arrAlumnosUno + $arrAlumnosDos;
             print_r($arrAlumnosTres);
             
             
             // 'Operador == <br /> arrAlumnosUno: ';
             $arrAlumnosUno = ['Pepe', 'Maria', 'Juan', 'Ana'];
             $arrAlumnosDos = $arrAlumnosUno;
             echo '<br /><br />Operador == <br />arrAlumnosUno===arrAlumnosDos  ' . (($arrAlumnosUno===$arrAlumnosDos)==null?'false':'true') ;
             echo '<br />arrAlumnosUno!=arrAlumnosDos  ' . (($arrAlumnosUno!=$arrAlumnosDos)==null?'false':'true');
             echo '<br />arrAlumnosUno!==arrAlumnosDos  ' . (($arrAlumnosUno!==$arrAlumnosDos)==null?'false':'true');
             unset($arrAlumnosDos[2]);
             $arrAlumnosDos[2]=$arrAlumnosUno[2];
             echo '<br /> arrAlumnosUno: ';
             print_r($arrAlumnosUno);
             echo '<br />arrAlumnosDos: ';
             print_r($arrAlumnosDos);
             echo '<br />arrAlumnosUno==arrAlumnosDos  ' . (($arrAlumnosUno==$arrAlumnosDos)==null?'false':'true');
             echo '<br />arrAlumnosUno!=arrAlumnosDos  ' . (($arrAlumnosUno!=$arrAlumnosDos)==null?'false':'true');
             echo '<br />arrAlumnosUno!==arrAlumnosDos  ' . (($arrAlumnosUno!==$arrAlumnosDos)==null?'false':'true');
             echo '<br />arrAlumnosUno===arrAlumnosDos  ' . (($arrAlumnosUno===$arrAlumnosDos)==null?'false':'true') . '<br /> arrAlumnosUno: ';
             $arrAlumnosDos[2]='Kevin';
             print_r($arrAlumnosUno);
             echo '<br />arrAlumnosDos: ';
             print_r($arrAlumnosDos);
             echo '<br />arrAlumnosUno==arrAlumnosDos  ' . (($arrAlumnosUno==$arrAlumnosDos)==null?'false':'true');
             echo '<br />arrAlumnosUno!=arrAlumnosDos  ' . (($arrAlumnosUno!=$arrAlumnosDos)==null?'false':'true');
             echo '<br />arrAlumnosUno!==arrAlumnosDos  ' . (($arrAlumnosUno!==$arrAlumnosDos)==null?'false':'true');
             echo '<br />arrAlumnosUno===arrAlumnosDos  ' . (($arrAlumnosUno===$arrAlumnosDos)==null?'false':'true') . '<br /> arrAlumnosUno: ';

        ?>
    </body>
</html>
