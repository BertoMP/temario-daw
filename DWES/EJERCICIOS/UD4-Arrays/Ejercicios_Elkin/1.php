<html>
    <head></head>
    <body>
        
        <form action="uno.php" method="get">
            <table>
            <?php
                $strArrMeses = ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'];
                foreach($strArrMeses as $strMes){
                    echo "<tr><td>$strMes: </td>";
                    echo "<td><input type='text' name='$strMes'></td></tr>";
                }
            ?>
            </table>
            <p><input type="submit" value="enviar"></p>
        </form>
    </body>
</html>
