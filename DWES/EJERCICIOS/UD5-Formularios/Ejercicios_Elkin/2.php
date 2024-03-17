<html>

<body>
    <form action="2.php" method="get">
            Nombre: <input type="text" name="nombre" pattern="[A-Za-z]{1,15}" title="Solo puede contener de 1 a 15 letras"><br />
            Nota: <input type="number" name="nota" min="0" max="10" step="0.01" /><br />
            <input type="submit" />
            <button type="submit" formaction="aniade.php">Mostrar Resultados</button>
            <?php
                $strValor=isset($_REQUEST['valores']) ? $_REQUEST['valores'] : '';
                if(isset($_REQUEST['nombre']) && $_REQUEST['nombre']!='' && 
                   isset($_REQUEST['nota']) && $_REQUEST['nota']!='')
                    $strValor .= ':' . $_REQUEST['nombre'] . ':' . $_REQUEST['nota'];
            
                echo "<input type=\"hidden\" name=\"valores\" value=\"$strValor\">";
            ?>
        </form>

</body>

</html>