<html>

<body>
    <form action="2Dos.php" method="get">
            Nombre: <input type="text" name="nombre" pattern="[A-Za-z]{1,15}" title="Solo puede contener de 1 a 15 letras"><br />
            Nota: <input type="number" name="nota" min="0" max="10" step="0.01" /><br />
            <input type="submit" />
            <button type="submit" formaction="aniadeDos.php">Mostrar Resultados</button>
            <?php
                if(isset($_REQUEST['nombres'])){
                    $strArr = $_REQUEST['nombres'];
                    foreach($strArr as $strNombre)
                        echo "<input type=\"hidden\" name=\"nombres[]\" value=\"$strNombre\">";
                }
                if(isset($_REQUEST['notas'])){
                    $strArr = $_REQUEST['notas'];
                    foreach($strArr as $strNota)
                        echo "<input type=\"hidden\" name=\"notas[]\" value=\"$strNota\">";
                }
                if(isset($_REQUEST['nombre']) && $_REQUEST['nombre']!='' && 
                    isset($_REQUEST['nota']) && $_REQUEST['nota']!=''){
                    echo "<input type=\"hidden\" name=\"nombres[]\" value=\"" . ($_REQUEST['nombre']) . "\">";
                    echo "<input type=\"hidden\" name=\"notas[]\" value=\"" . ($_REQUEST['nota']) . "\">";
                }
            
            ?>
        </form>

</body>

</html>