<html>
    <head></head>
    <body>
        <form action="cinco.php" method="get">
            
            
                
            <?php
                $strArrPalabras = ['yo'=>'I', 'tu'=>'you', 'el'=>'he', 'si'=>'yes', 'nombre'=>'name', 'día'=>'day', 
                                    'seman'=>'week', 'mes'=>'moth', 'año'=>'year', 'pais'=>'country', 'libro'=>'book', 
                                    'bolsa'=>'bag', 'archivo'=>'file', 'llave'=>'key', 'foto'=>'picture', 'agua'=>'water', 
                                    'casa'=>'home', 'habitación'=>'bethroom', 'trabajo'=>'job', 'juego'=>'game'];
                
				for($intCount = 0, $intAcertadas=0;$intCount<5; $intCount++){
                    $strIngles = isset($_GET["ingles".$intCount])?$_GET["ingles".$intCount]:'';
                    $strEspaniol = isset($_GET["espaniol".$intCount])?$_GET["espaniol".$intCount]:'';
					echo "<span style='color: ";
					if($strIngles == $strArrPalabras[$strEspaniol])
						echo 'green';
					else
						echo 'red';
					echo ";'> $strEspaniol : $strIngles </span><br>";
                }
            ?>
        </form>
    </body>
</html>