<html>
    <head></head>
    <body>
        <form action="4.php" method="get">
            
            <p><label for='palabra'>Palabra en español: </label>
            <input type='text' name='palabra'></p>
                
            <p><input type="submit" value="enviar"></p>
            <?php
                $strArrPalabras = ['yo'=>'I', 'tu'=>'you', 'el'=>'he', 'si'=>'yes', 'nombre'=>'name', 'día'=>'day', 
                                    'seman'=>'week', 'mes'=>'moth', 'año'=>'year', 'pais'=>'country', 'libro'=>'book', 
                                    'bolsa'=>'bag', 'archivo'=>'file', 'llave'=>'key', 'foto'=>'picture', 'agua'=>'water', 
                                    'casa'=>'home', 'habitación'=>'bethroom', 'trabajo'=>'job', 'juego'=>'game'];
                // $strEspaniol = isset($_GET("palabra"))?$_GET("palabra"):'';
                $strEspaniol = isset($_GET["palabra"])?$_GET["palabra"]:' ';
                if(isset($strArrPalabras[$strEspaniol]))
                    echo "Traducción al inglés: " . $strArrPalabras[$strEspaniol];
            ?>
        </form>
    </body>
</html>