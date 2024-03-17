<html>
    <body>
        <table border="1">
            <tr><td>Nombre:</td><td><?=$_REQUEST["nombre"];?></td></tr>
            <tr><td>Apellidos:</td><td><?=$_REQUEST["apellidos"];?></td></tr>
            <tr><td>Mail:</td><td><?=$_REQUEST["mail"];?></td></tr>
            <tr><td>Sitio web:</td><td><?=$_REQUEST["web"];?></td></tr>
            <tr><td>Sexo:</td><td><?=isset($_REQUEST["sexo"])?$_REQUEST["sexo"]:'';?></td></tr>
            <tr><td>N&uacute;mero de convivientes en el domicilio:</td><td><?=$_REQUEST["convivientes"];?></td></tr>
            <tr><td>Aficiones:</td><td>
                <?php
                    if(isset($_REQUEST["aficiones"])){
                        $strArrAficiones = $_REQUEST["aficiones"];
                        foreach ($strArrAficiones as $strAficion)
                            echo "$strAficion ";
                    }
                ?>
            </td></tr>
            <tr><td>Favorito:</td><td>
                <?php
                    if(isset($_REQUEST["favorito"])){
                        $strArrFavoritos = $_REQUEST["favorito"];
                        foreach ($strArrFavoritos as $strFavoritos)
                            echo "$strFavoritos ";
                    }
                ?>
            </td></tr>
        </table>  
    </body>
</html>