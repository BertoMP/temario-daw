 <?php
    function resultado(?string $intNum): string {
      if(isset($intNum) && $intNum!=null)
        return($intNum==3?'X':$intNum);
      else
        return(resultado(rand(1,3)));
    } 

    $titulo = "Quiniela";
    include("general/cabecera.inc.php");
    $intArrPartidos = $_POST['partidos']; 
     
    for($intCont=0; $intCont<count($intArrPartidos); $intCont++)
      echo "Partido " . ($intCont+1) . ": " . resultado(filter_var($intArrPartidos[$intCont], FILTER_VALIDATE_INT, ["options" => ["min_range" => 1 , "max_range"=> 3]])) . "<br />";
    
    include("general/pie.inc.html");
?>
