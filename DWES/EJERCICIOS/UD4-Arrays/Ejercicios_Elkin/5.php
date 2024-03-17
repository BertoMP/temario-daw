<html>
    <head></head>
    <body>
        <form action="cinco.php" method="get">
            
            
                
            <p><input type="submit" value="enviar"></p>
            <?php
                $strArrPalabras = ['yo'=>'I', 'tu'=>'you', 'el'=>'he', 'si'=>'yes', 'nombre'=>'name', 'día'=>'day', 
                                    'seman'=>'week', 'mes'=>'moth', 'año'=>'year', 'pais'=>'country', 'libro'=>'book', 
                                    'bolsa'=>'bag', 'archivo'=>'file', 'llave'=>'key', 'foto'=>'picture', 'agua'=>'water', 
                                    'casa'=>'home', 'habitación'=>'bethroom', 'trabajo'=>'job', 'juego'=>'game'];
                $intArrAleatorios=[];
                while(count($intArrAleatorios)<5){//saca 5 valores no repetidos
                    $intAux = rand(0,19);
                    if(!in_array($intAux,$intArrAleatorios))
                        $intArrAleatorios[]=$intAux;
                }

                $intCount = 0;
                $intCount2 = 0;
                foreach($strArrPalabras as $strEspaniol=>$strIngles){
                    if(in_array($intCount, $intArrAleatorios)){//si la palabra en la que estamos ha salido seleccionada
                        echo "<p><input type='text' name='espaniol$intCount2' value='$strEspaniol' readonly>";
                        echo "&nbsp;<input type='text' name='ingles$intCount2'></p>";
                        $intCount2++;
                    }
                    $intCount++;
                }
            ?>
        </form>
    </body>
</html>