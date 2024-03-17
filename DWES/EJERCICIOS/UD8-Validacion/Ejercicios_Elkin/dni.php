 <?php
    $titulo = "Ejercicio 8.2";
    include("general/cabecera.inc.php");
    $intDni = $_POST['ndni'];  
	if(filter_var($intDni, FILTER_VALIDATE_INT, ["options" => ["min_range" => 1 , "max_range"=> 99999999]])){
        $intLetra = $intDni%23;  
        $strArrLetras = 'TRWAGMYFPDXBNJZSQVHLCKE';  
        echo "El DNI $intDni tiene la letra " . $strArrLetras[$intLetra];
    }else
        echo "El DNI no es válido";
    
    include("general/pie.inc.html");
?>
