<html>
    <body>
    <form>
            <label for="numero">Numero 1:</label>
				<input type="number" id="numero" name="numero" />
            <br />
			<label for="numero">Numero 2:</label>
				<input type="number" name="numero2" />
			<br />
            
            <input type="submit">
    </form>
                <?php
                    include("biblioteca.inc.php");
                    if(isset($_REQUEST["numero"]) && $_REQUEST["numero"]!='' &&
                       isset($_REQUEST["numero2"]) && $_REQUEST["numero2"]!=''){
                        $intNumero = $_REQUEST["numero"];
                        $intNumero2 = $_REQUEST["numero2"];
                        $strArrFunciones = ['suma','resta','multiplica','divide'];
                        foreach ($strArrFunciones as $strValor)
                            echo "$strValor " . $strValor($intNumero, $intNumero2) . "<br />";
                    }
                ?>
    </body>
</html>